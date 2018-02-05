package th.part_18_IO.exercise;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 练习3
 * 
 * @author Administrator
 * 2015年10月30日
 */
public class E03_DirSize {
	public static void main(final String[] args) {
		File path=new File
				("E:\\Eclipse_WS\\ThinkingInJava\\src\\th\\part_18_IO\\chapter_01_File\\_00.");
		String [] list;
		if(args.length==0)
			list=path.list();
		else
			list=path.list(new FilenameFilter() {
				//args必须修改成final，此处main方法中一个内部类
				private Pattern pattern=Pattern.compile(args[0]);
				
				@Override
				public boolean accept(File dir, String name) {
					return pattern.matcher(name).matches();
				}
			});
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		long total=0;
		long fs;
		for (String item : list) {
			fs=new File(path,item).length();
			System.out.println(item+","+fs+"byte(s)");
		}
		System.out.println("===========================");
		System.out.println(list.length+"file(s),"+total+"bytes");
	}
}
