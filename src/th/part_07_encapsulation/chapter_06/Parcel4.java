package th.part_07_encapsulation.chapter_06;


public class Parcel4 {

	/**
	 * 匿名内部类
	 * @param s
	 * @return
	 */
	public Destination dest(String s) {
		
		class InnerDestination implements Destination {
			private String label;
			//私有构造函数
			private InnerDestination(String label) {
				System.out.println("我是父类。我的构造函数是私有的！");
				this.label = label;
			}
			public String readLabel() {
				System.out.println(label);
				return label;
			}
			
			/**
			 * 父类已经定义了一个有参的构造函数，没有定义无惨构造时候，
			 * 此时编译器不会为你调用默认的无惨构造函数，
			 * 当子类继承时，必须在自己的构造函数显式调用父类的构造函数，
			 * 自己才能确保子类在初始化前父类会被实例化
			 * @author Administrator
			 * 注意:私有构造函数出了这个类就无法被继承，
			 * 		这也是目前我知道的私有构造可以被继承的一种方式
			 */
			
			 class Child extends InnerDestination{
				//如果父类没有无惨构造，子类在自己的构造函数显式调用父类的构造函数
				public Child(String str){
					super(str);
					System.out.println("我是私有构造函数子类");
				}
			}
		}
		return new InnerDestination(s);
	}
	
	public static void main(String[] args) {
		Parcel4 p = new Parcel4();
		Destination d = p.dest("Tanzania");
		d.readLabel();
	}
}
