package th.part_07_encapsulation.chapter_06;


public class Parcel4 {

	/**
	 * �����ڲ���
	 * @param s
	 * @return
	 */
	public Destination dest(String s) {
		
		class InnerDestination implements Destination {
			private String label;
			//˽�й��캯��
			private InnerDestination(String label) {
				System.out.println("���Ǹ��ࡣ�ҵĹ��캯����˽�еģ�");
				this.label = label;
			}
			public String readLabel() {
				System.out.println(label);
				return label;
			}
			
			/**
			 * �����Ѿ�������һ���вεĹ��캯����û�ж����޲ҹ���ʱ��
			 * ��ʱ����������Ϊ�����Ĭ�ϵ��޲ҹ��캯����
			 * ������̳�ʱ���������Լ��Ĺ��캯����ʽ���ø���Ĺ��캯����
			 * �Լ�����ȷ�������ڳ�ʼ��ǰ����ᱻʵ����
			 * @author Administrator
			 * ע��:˽�й��캯�������������޷����̳У�
			 * 		��Ҳ��Ŀǰ��֪����˽�й�����Ա��̳е�һ�ַ�ʽ
			 */
			
			 class Child extends InnerDestination{
				//�������û���޲ҹ��죬�������Լ��Ĺ��캯����ʽ���ø���Ĺ��캯��
				public Child(String str){
					super(str);
					System.out.println("����˽�й��캯������");
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
