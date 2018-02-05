package th.part_18_IO.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 练习7
 * @author Administrator
 * 2015-11-24 下午04:41:10
 *
 */
public class E07_FileIntoList {
	public static void read(String fileName) throws IOException{
		LinkedList<String> link=new LinkedList<String>();
		FileReader reader=new FileReader(fileName);
		BufferedReader b=new BufferedReader(reader);
		String str;
		while((str=b.readLine())!=null){
			link.add(str.toUpperCase());
		}
		Collections.reverse(link);
		for (String s : link) {
			System.out.println(s);
		}
		reader.close();
	}
	/**
	 * 练习8用args传参数(命令参数)省略
	 * 练习9省略
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			read("F:\\My_git\\ThinkingInJava\\src\\th\\part_18_IO\\exercise\\E07_FileIntoList.java");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
