package th.part_06.chapter_08;


public class FianlAndStatic {
	 static final Value staticValue = new Value();
     final Value value = new Value();
     
     public String toString(){
         return "value = " + value + "\nstaticValue = " + staticValue;
     }
     
     /**
 	 * static的常量在类加载的时候被初始化，
 	 * 而实例常量在实例化的时候被初始化
 	 * 静态的东西只会被初始化一次，发生在类加载的时候。
 	 * @param args
 	 */
     public static void main(String[] args) {
    	 System.out.println("First Object:");
    	 System.out.println(new FianlAndStatic());
         System.out.println("Second Object:");
         System.out.println(new FianlAndStatic());
	}
}
