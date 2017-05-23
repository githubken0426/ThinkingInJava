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
		System.out.println(name+"请求计算机帮助计算，然后去玩去了.....");
	}

	@Override
	public void doFill(double a, double b, double result) {
		System.out.println("计算结果是:"+a+"+"+b+"="+result);
	}
	
	public static void main(String[] args) {
		new Student("小名").callBack(123.45, 230.15);
	}
}
