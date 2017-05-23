package th.part_18_IO.chapter_06_IO._04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import th.part_18_IO.chapter_06_IO._01.BufferedInputFile;


public class BasicFileOutPut {
	static String fileName="E:\\Eclipse_WS\\ThinkingInJava\\src\\th\\part_18_IO\\chapter_06_IO\\_04\\BasicFileOutPut.java";
	static String writeFile ="C:\\Users\\Administrator\\Desktop\\fl.txt";
	public static void main(String[] args) {
		try {
			BufferedReader in =new BufferedReader(new FileReader(fileName));
			PrintWriter out =new PrintWriter(new BufferedWriter(new FileWriter(writeFile)));
			int lineCount=1;
			String s;
			while((s=in.readLine())!=null){
				out.println(s+":"+lineCount);
				lineCount++;
			}
			out.close();
			System.out.println(BufferedInputFile.read(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
