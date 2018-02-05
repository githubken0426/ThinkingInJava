package th.part_18_IO.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/**
 * 练习10，查找单词所在行数
 * @author Administrator
 * 2015-11-25 上午11:58:55
 *
 */
public class E10_FindWord {
	
	public static List<String> read(String fileName) throws IOException{
		List<String> list=new ArrayList<String>();
		BufferedReader read=new BufferedReader(new FileReader(fileName));
		String str;
		while((str=read.readLine())!=null){
			list.add(str);
		}
		read.close();
		return list;
	}
	
	public static void main(String[] args) {
		Set<String> wordSet=new HashSet<String>();
		for (String s : args) {
			wordSet.add(s);
		}
		try {
			List<String> list=read("E:\\Eclipse_WS\\ThinkingInJava\\src\\th\\part_18_IO\\exercise\\E10_FindWord.java");
			for(ListIterator<String> it =list.listIterator(list.size());it.hasPrevious();){
				String s=it.previous();
				//获取行数
				int line= it.nextIndex()+1;
				for (String word : wordSet) {
					if(s.indexOf(word)!=-1){
						System.out.println(s+"\40"+line);
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
