package th.part_18_IO.chapter_07_WR;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {
	static String file = "C:\\Users\\Administrator\\Desktop\\TextFile.txt";
	static String fileName="E:\\Eclipse_WS\\ThinkingInJava\\src\\th\\part_18_IO\\chapter_07_WR\\TextFile.java";
	
	public static String read(String fileName){
		StringBuilder sb=new StringBuilder();
		try {
			BufferedReader in=new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
			String s;
			while((s=in.readLine())!=null){
				sb.append(s);
				sb.append("\n");
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static void write(String fileName,String text){
		try {
			PrintWriter out=new PrintWriter(new File(fileName).getAbsoluteFile());
			out.print(text);
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public TextFile(String fileName,String spliter){
		super(Arrays.asList(read(fileName).split(spliter)));
		if(get(0).equals(""))remove(0);
	}
	public TextFile(String fileName){
		this(fileName,"\n");
	}
	
	public  void write(String fileName){
		try {
			PrintWriter out=new PrintWriter(new File(fileName).getAbsoluteFile());
			for (String item : this) {
				out.print(item);
				out.close();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		String str=read(fileName);
		write(file,str);
		TextFile text=new TextFile(fileName);
		TreeSet<String> set=new TreeSet<String>(new TextFile(fileName,"\\w+"));
		System.out.println(set.headSet("a"));
	}
}
