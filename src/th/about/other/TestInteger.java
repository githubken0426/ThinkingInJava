package th.about.other;

public class TestInteger {
	public static void main(String[] args) {
		Integer i1=-128;  
		Integer i2=-128;  
		Integer i3=300;  
		Integer i4=300; 
		int a=i3;
		System.out.println(i1==i2);  
		System.out.println(i3==i4);  
		System.out.println(a==i4);
		System.out.println("====================");
		
		Integer integer100 = 100;  
		int int100 = 100;  
		Long long200 = 200l;  
		System.out.println(integer100 + int100);  
		System.out.println(long200 == (integer100 + int100));  
		System.out.println(long200.equals(integer100 + int100));  
	}
	
}
