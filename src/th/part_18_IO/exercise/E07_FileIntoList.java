package th.part_18_IO.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

/**
 * ��ϰ7
 * @author Administrator
 * 2015-11-24 ����04:41:10
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
	}
	/**
	 * ��ϰ8��args������(�������)ʡ��
	 * ��ϰ9ʡ��
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			read("E:\\Eclipse_WS\\ThinkingInJava\\src\\th\\part_18_IO\\exercise\\E07_FileIntoList.java");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
