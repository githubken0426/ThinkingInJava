package th.part_11_collection.exercise;

import java.util.LinkedList;
import java.util.Queue;

public class E_27CommandQueue {
	
	static class Command {
		private String str;
		
		public String getStr() {
			return str;
		}

		public void setStr(String str) {
			this.str = str;
		}

		public Command(String str){
			this.str=str;
		}
		
		public String operatiion(){
			return this.str;
		}
	}
	
	static class CommandQueueProducer{
		private static Queue<Command> queue=null;
		
		public static Queue<Command> getCommandQueue(){
			if(queue==null){
				synchronized(CommandQueueProducer.class){
					if(queue==null){
						queue = new LinkedList<Command>();
					}
				}
			}
			return queue;
		}
		
		public static void add(Command ... command){
			for (Command com : command) {
				queue.add(com);
			}
		}
	}
	
	static class CommandConsumer{
		public static void commandConsumer(Queue<Command> queue){
			while(queue.peek()!=null){
				System.out.println(queue.remove().operatiion());
			}
		}
	}
	
	public static void main(String[] args) {
		Queue<Command> queue=CommandQueueProducer.getCommandQueue();
		CommandQueueProducer.add(new Command("Com1"),new Command("HJK"),new Command("IOP"),new Command("UIO"));
		CommandConsumer.commandConsumer(queue);
	}
}
