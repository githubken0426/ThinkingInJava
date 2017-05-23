package th.part_14_TypeInfo.chapter_08_NullObject;

import java.util.List;

import th.part_14_TypeInfo.chapter_08_NullObject._02.Operation;

public interface Robot {
	String name();
	String model();
	List<Operation> operation();

	class test{
		public static void doWork(Robot r){
			if( r instanceof NullInterface){
				System.out.println("This Is Null Robnot");
			}
			System.out.println("r.name():"+r.name());
			System.out.println("r.model():"+r.model());
			for(Operation op:r.operation()){
				System.out.println(op.description());
				op.command();
			}
		}
	}
}
