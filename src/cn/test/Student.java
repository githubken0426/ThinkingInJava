package cn.test;


public class Student implements DoFillJob {

	private String name;
	public Student(String name){
		this.name=name;
	}
	
	public void callBack(final double a, final double b){
		new Thread(new Runnable(){

			@Override
			public void run() {
				SuperCalculator.getResult(a, b, new  Student(name));
			}
		}).start();
		System.out.println(name+"���������������㣬Ȼ��ȥ��ȥ��.....");
	}

	@Override
	public void doFill(double a, double b, double result) {
		System.out.println("��������:"+a+"+"+b+"="+result);
	}
	
	public static void main(String[] args) {
		new Student("С��").callBack(123.45, 230.15);
	}
}
