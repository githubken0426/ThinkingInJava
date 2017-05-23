package th.part_18_IO.chapter_06_IO._01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 缓冲输入文件
 * @author Administrator
 * 2015-11-24 下午04:21:49
 *
 */
public class BufferedInputFile {
	public static String read(String fileName) throws IOException{
		BufferedReader in =new BufferedReader(new FileReader(fileName));
		String str;
		StringBuilder sb=new StringBuilder();
		while((str=in.readLine())!=null){
			sb.append(str+"\n");
		}
		in.close();
		return sb.toString();
	}
	public static void main(String[] args) {
		try {
			String str=read("E:\\Eclipse_WS\\ThinkingInJava\\src\\th\\part_18_IO\\chapter_06_IO\\_01\\BufferedInputFile.java");
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
