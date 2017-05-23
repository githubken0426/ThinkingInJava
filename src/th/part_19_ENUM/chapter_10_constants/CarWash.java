package th.part_19_ENUM.chapter_10_constants;

import java.util.EnumSet;

public class CarWash {
	public enum Cycle{
		UNDERBODY{
			@Override
			public void action() {
				System.out.println("Underbody");
			}
		},WHEELWASH{
			@Override
			public void action() {
				System.out.println("Wheelwash");
			}
		},PREWASH{
			@Override
			public void action() {
				System.out.println("Prewash");
			}
		};
		abstract void action();
	}
	EnumSet<Cycle> cycles=EnumSet.of(Cycle.UNDERBODY,Cycle.PREWASH);
	
	public void add(Cycle e){
		cycles.add(e);
	}
	
	public void washCar(){
		for (Cycle ele : cycles) {
			ele.action();
		}
	}
	
	public String toString(){
		return cycles.toString();
	}
	
	/**
	 * 向EnumSet添加的顺序取决于创建enum时的顺序
	 * @param args
	 * 2017-5-2 下午04:52:26
	 */
	public static void main(String[] args) {
		CarWash wash=new CarWash();
		System.out.println(wash);
		wash.washCar();
		
		System.out.println("************");
		wash.add(Cycle.UNDERBODY);
		wash.add(Cycle.WHEELWASH);
		System.out.println(wash);
		wash.washCar();
	}
}
