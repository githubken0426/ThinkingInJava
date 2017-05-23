package th.part_21_Concurrence.chapter_02._12Form;

import java.io.IOException;

public class ResponseUI extends Thread {
	private static volatile double d=1;
	public ResponseUI(){
		setDaemon(true);
		start();
	}
	public void run(){
		System.out.println("�ػ��߳�");
		while(true)
			d+=(Math.PI+Math.E)/d;//E:��Ȼ����
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(Math.E);
		new ResponseUI();
		System.in.read();
		System.out.println(d);
	}
}
