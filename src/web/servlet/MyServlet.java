package web.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Server + applet
 * 意为：运行在服务器端的小程序。
 * 
 * Servlet实际上就是一个接口。
            - 狭义上的Servlet，指的就是Servlet接口
            - 广义上的我们认为凡是实现Servlet接口的类，我们都称他是一个Servlet *****
 *  Servlet的作用：
            1.接收用户发送的请求
            2.调用其他的java程序来处理请求
            3.根据处理结果，返回给用户一个页面
 * 
 * 1.客户端通过发送请求给Tomcat，Tomcat发送客户端的请求页面给客户端。
 * 2.用户对请求页面进行相关操作后将页面提交给Tomcat,Tomcat将其封装成一个HttpRequest对象，
 * 	 然后对请求进行处理,。
 * 3.Tomcat截获请求，根据action属性值查询xml文件中对应的servlet-name，再根据servlet-name查询到对应的java类
 * 	 （如果是第一次，Tomcat则会将servlet编译成java类文件，所以第一次运行的时候程序会比较慢）。
 * 4.Tomcat实例化查询到的java类，注意该类只实例化一次。
 * 5.调用java类对象的service()方法（如果不对service()方法进行重写则根据提交的方式来决定执行doPost()方法还是doGet()方法）。
 * 6.通过request对象取得客户端传过来的数据，对数据进行处理后通过response对象将处理结果写回客户端。
 * 
 * 
 * servlet是线程安全的吗？
 * 当客户端第一次请求Servlet的时候,tomcat会根据web.xml配置文件实例化servlet，
 * 当又有一个客户端访问该servlet的时候，不会再实例化该servlet，也就是多个线程在使用这个实例。
 * JSP/Servlet容器默认是采用单实例多线程(这是造成线程安全的主因)方式处理多个请求的，
 * 这种默认以多线程方式执行的设计可大大降低对系统的资源需求，提高系统的并发量及响应时间。
 * Servlet本身是无状态的，一个无状态的Servlet是绝对线程安全的
 * (无状态对象设计也是解决线程安全问题的一种有效手段)
 * 所以，servlet是否线程安全是由它的实现来决定的，如果它内部的属性或方法会被多个线程改变，
 * 它就是线程不安全的，反之，就是线程安全的.
 * 
 * 避免使用实例变量,避免使用非线程安全的集合,
 * 在多个Servlet中对某个外部对象(例如文件)的修改时务必加锁（Synchronized，或者ReentrantLock），互斥访问。
 * 属性的线程安全：ServletContext、HttpSession是线程安全的；
 * ServletRequest是非线程安全的。
 * 
 * @author ken
 * 2017-3-10 上午08:56:20
 */
public class MyServlet implements Servlet{
	private long count;
	public long getCount(){
		return count;
	}
	/**
	 * 1:Servlet容器负责加载和实例化Servelt。
	 * 当Servlet容器启动时，或者在容器检测到需要这个Servlet来响应第一个请求时，
	 * 创建Servlet实例。当Servlet容器启动后，Servlet通过类加载器来加载Servlet类，
	 * 加载完成后再new一个Servlet对象来完成实例化
	 */
	/**
	 * 2:初始化
	 * 在Servlet实例化之后，容器将调用init()方法，并传递实现ServletConfig接口的对象。
	 * 在init()方法中，Servlet可以部署描述符中读取配置参数，或者执行任何其他一次性活动。
	 * 在Servlet的整个生命周期类，init()方法只被调用一次
	 */
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		
	}
	/**
	 * 3:请求处理
	 * 当Servlet初始化后，容器就可以准备处理客户机请求了。
	 * 当容器收到对这一Servlet的请求，就调用Servlet的service()方法，
	 * 并把请求和响应对象作为参数传递。当并行的请求到来时，
	 * 多个service()方法能够同时运行在独立的线程中。
	 * 通过分析ServletRequest或者HttpServletRequest对象，service()方法处理用户的请求，
	 * 并调用ServletResponse或者HttpServletResponse对象来响应
	 */
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		++count;
		Thread.yield();
		++count;
	}
	/**
	 * 3:销毁
	 * 一旦Servlet容器检测到一个Servlet要被卸载，这可能是因为要回收资源或者因为它正在被关闭，
	 * 容器会在所有Servlet的service()线程之后，调用Servlet的destroy()方法。
	 * 然后，Servlet就可以进行无用存储单元收集清理。这样Servlet对象就被销毁了。
	 * 这四个阶段共同决定了Servlet的生命周期
	 */
	@Override
	public void destroy() {
		
	}
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}
/**
 * 
 * 实现线程安全的Servlet:
 * 
 * 1.实现 SingleThreadModel 接口
	该接口指定了系统如何处理对同一个Servlet的调用。如果一个Servlet被这个接口指定，
	那么在这个Servlet中的service方法将不会有两个线程被同时执行，
	当然也就不存在线程安全的问题。但是，如果一个Servlet实现了SingleThreadModel接口，
	Servlet引擎将为每个新的请求创建一个单独的Servlet实例，这将引起大量的系统开销，
	在现在的Servlet开发中基本看不到SingleThreadModel的使用，这种方式了解即可，尽量避免使用。
	public class XXXXX extends HttpServlet implements SingleThreadModel {
	}

  *	2.同步对共享数据的操作
	使用synchronized 关键字能保证一次只有一个线程可以访问被保护的区段，
	可以通过同步块操作来保证Servlet的线程安全。如果在程序中使用同步来保护要使用的共享的数据，
	也会使系统的性能大大下降。这是因为被同步的代码块在同一时刻只能有一个线程执行它，
	使得其同时处理客户请求的吞吐量降低，而且很多客户处于阻塞状态。
	另外为保证主存内容和线程的工作内存中的数据的一致性，要频繁地刷新缓存,
	这也会大大地影响系统的性能。所以在实际的开发中也应避免或最小化Servlet 中的同步代码。
	
	同步代码：
	Public class XXXXXX extends HttpServlet {
	synchronized (this){XXXX}
	}
	
  *	3.避免使用实例变量
	线程安全问题很大部分是由实例变量造成的，只要在Servlet里面的任何方法里面都不使用实例变量，
	那么该Servlet就是线程安全的。
 */
	
}
