package th.part_18_IO.exercise;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

import th.part_18_IO.Constant;
import th.part_18_IO.chapter_06_IO._01.BufferedInputFile;

/**
 * 使用LineNumberReader记录行号
 * @ClassName: E13_BasicFileOutPut 
 * @Description: 
 * @author ken 
 * @date 2018年2月6日 下午5:10:36
 */
public class E13_BasicFileOutPut {
	static String fileName = Constant.IO_ROOT_PATH_18+"ThinkingInJava\\src\\th\\part_18_IO\\exercise\\E13_BasicFileOutPut.java";
	static String writeFile ="C:\\Users\\Administrator\\Desktop\\E13_BasicFileOutPut.txt";
	public static void main(String[] args) {
		try {
			LineNumberReader in =new LineNumberReader(new FileReader(fileName));
			PrintWriter out =new PrintWriter(new BufferedWriter(new FileWriter(writeFile)));
			String s;
			while((s=in.readLine())!=null){
				out.println(in.getLineNumber()+s);
			}
			//如果不显示调用close,缓冲区内容不会刷新,无法写入文件
			out.close();
			in.close();
			System.out.println(BufferedInputFile.read(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
