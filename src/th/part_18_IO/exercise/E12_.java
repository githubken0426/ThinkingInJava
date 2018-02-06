package th.part_18_IO.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import th.part_18_IO.Constant;

public class E12_ {
	static String fileName = Constant.IO_ROOT_PATH_18+"ThinkingInJava\\src\\th\\part_18_IO\\exercise\\E12_.java";
	static String writeFile ="C:\\Users\\Administrator\\Desktop\\E12_.txt";
	
	public static void main(String[] args) throws IOException {
		readWriteFile(fileName,writeFile);
	}
	
	public static void readWriteFile(String inputFileName,String outFileName) throws IOException{
		LinkedList<String> link=new LinkedList<String>();
		BufferedReader reader=new BufferedReader(new FileReader(inputFileName));
		
		PrintWriter write=new PrintWriter(new BufferedWriter(new FileWriter(outFileName)));
		String str;
		while((str=reader.readLine())!=null){
			link.add(str);
		}
		for (int i=0;i<link.size();i++) {
			String result=(i+1)+link.get(i);
			write.println(result);
			System.out.println(result);
		}
		reader.close();
		write.close();
	}
}
