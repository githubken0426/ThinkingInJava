package th.part_15_Generic.chapter_09_Bounds;


public class InheritanceBounds {
	public static void main(String[] args) {
		HoldItem<Bounded> item=new HoldItem<Bounded>(new Bounded());
		/**
		 * The member type HoldItem.Solid2<Bounded> 
		 * must be qualified with a parameterized type, since it is not static
		 * ���÷����ڲ��࣬���ͱ��������
		 */
		HoldItem<Bounded>.Solid2<Bounded> solid=item.new Solid2<Bounded>(item, new Bounded());
		solid.color();
		solid.weight();
		solid.getX();
	}
}
