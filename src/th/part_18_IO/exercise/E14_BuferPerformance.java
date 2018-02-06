package th.part_18_IO.exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import th.part_18_IO.Constant;

public class E14_BuferPerformance {
	static String file="C:\\Users\\Administrator\\Desktop\\E14_Bufer.txt";
	static String file2="C:\\Users\\Administrator\\Desktop\\E14_Bufer2.txt";
	static String fileName= Constant.IO_ROOT_PATH_18+"\\ThinkingInJava\\src\\th\\part_18_IO\\exercise\\E14_BuferPerformance.java";
	
	public static void main(String[] args) {
		try {
			List<String> list=E10_FindWord.read(fileName);
			//使用缓冲
			PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter(file)));
			int lineCount=1;
			long t1=System.currentTimeMillis();
			for(String s:list){
				for(int i=0;i<1000;i++)
					out.print(lineCount+":"+s);
				lineCount++;
			}
			long t2=System.currentTimeMillis();
			out.close();
			System.out.println("Buffered:"+(t2-t1));
			//无缓冲
			PrintWriter out2=new PrintWriter(new FileWriter(file2));
			long t3=System.currentTimeMillis();
			lineCount=1;
			for(String s:list){
				for(int i=0;i<1000;i++)
					out2.print(lineCount+":"+s);
				lineCount++;
			}
			long t4=System.currentTimeMillis();
			out2.close();
			System.out.println("NO Buffered:"+(t4-t3));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
