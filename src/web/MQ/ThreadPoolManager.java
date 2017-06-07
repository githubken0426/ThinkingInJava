package web.MQ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明： 
 * 由于部署阿里云的SLS日志服务，写了个日志接口，考虑到系统日志量提交有可能会阻塞，
 * 这里引入了线程池（生产者与消费者模式）来维护日志队列的发送。 
 * 一个发送消息模块将消息发送到消息队列中，无需等待返回结果，发送模块继续执行其他任务。
 * 消息队列中的指令由线程池中的线程来处理。 使用一个Queue来存放线程池溢出时的任务
 * 
 * @author ken 2017-6-7 上午08:47:06
 */
public class ThreadPoolManager {
	private static ThreadPoolManager tpm = new ThreadPoolManager();
	// 线程池维护线程的最少数量
	private final static int CORE_POOL_SIZE = 4;
	// 线程池维护线程的最大数量
	private final static int MAX_POOL_SIZE = 10;
	// 线程池维护线程所允许的空闲时间
	private final static int KEEP_ALIVE_TIME = 0;
	// 线程池所使用的缓冲队列大小
	private final static int WORK_QUEUE_SIZE = 10;
	// 消息缓冲队列
	Queue<String> msgQueue = new LinkedList<String>();
	// 访问消息缓存的调度线程
    // 查看是否有待定请求，如果有，则创建一个新的AccessDBThread，并添加到线程池中
    final Runnable accessBufferThread = new Runnable() {
        @Override
        public void run() {
            if(hasMoreAcquire()){
                String msg = ( String ) msgQueue.poll();
                Runnable task = new AccessDBThread( msg );
                threadPool.execute(task);
            }
        }
    };
    final RejectedExecutionHandler handler = new RejectedExecutionHandler(){
		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			 System.out.println(((AccessDBThread )r).getMsg()+"消息放入队列中重新等待执行");
	            msgQueue.offer((( AccessDBThread ) r ).getMsg() );
		}
    };
     
	// 管理数据库访问的线程池
	@SuppressWarnings({"unchecked" })
	final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
			CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
			new ArrayBlockingQueue(WORK_QUEUE_SIZE), this.handler);

	// 调度线程池
	final ScheduledExecutorService scheduler = Executors
			.newScheduledThreadPool(100);

	final ScheduledFuture<?> taskHandler = scheduler.scheduleAtFixedRate(
			accessBufferThread, 0, 1, TimeUnit.SECONDS);

	public static ThreadPoolManager newInstance() {
		return tpm;
	}

	private ThreadPoolManager() {
	}

	private boolean hasMoreAcquire() {
		return !msgQueue.isEmpty();
	}

	public void addLogMsg(String msg) {
		Runnable task = new AccessDBThread(msg);
		threadPool.execute(task);
	}
}
