package th.part_18_IO.exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class E14_BuferPerformance {
	static String file="C:\\Users\\Administrator\\Desktop\\E14_BuferPerformance.txt";
	static String fileName="E:\\Eclipse_WS\\ThinkingInJava\\src\\th\\part_18_IO\\exercise\\E14_BuferPerformance.java";
	public static void main(String[] args) {
		try {
			List<String> list=E10_FindWord.read(fileName);
			//使用缓冲
			PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter(file)));
			int lineCount=1;
			long t1=System.currentTimeMillis();
			for(String s:list){
				for(int i=0;i<10000;i++)
					out.print(lineCount+":"+s);
				lineCount++;
			}
			long t2=System.currentTimeMillis();
			System.out.println("Buiffered:"+(t2-t1));
			out.close();
			//不用缓冲
			out=new PrintWriter(new FileWriter(file));
			t1=System.currentTimeMillis();
			for(String s:list){
				for(int i=0;i<10000;i++)
					out.print(lineCount+":"+s);
				lineCount++;
			}
			t2=System.currentTimeMillis();
			System.out.println("Buiffered:"+(t2-t1));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
