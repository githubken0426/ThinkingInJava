package th.part_06.chapter_08;


public class FianlAndStatic {
	 static final Value staticValue = new Value();
     final Value value = new Value();
     
     public String toString(){
         return "value = " + value + "\nstaticValue = " + staticValue;
     }
     
     /**
 	 * static�ĳ���������ص�ʱ�򱻳�ʼ����
 	 * ��ʵ��������ʵ������ʱ�򱻳�ʼ��
 	 * ��̬�Ķ���ֻ�ᱻ��ʼ��һ�Σ�����������ص�ʱ��
 	 * @param args
 	 */
     public static void main(String[] args) {
    	 System.out.println("First Object:");
    	 System.out.println(new FianlAndStatic());
         System.out.println("Second Object:");
         System.out.println(new FianlAndStatic());
	}
}
