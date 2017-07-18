package th.part_18_IO.chapter_01_File._01;

import java.io.File;
import java.util.Arrays;

/**
 * File对象:File并不是指代文件，他代表一个特定文件的名称或某个目录下一组文件的名称
 * 
 * @author ken 2017-5-18 下午02:24:18
 */
public class DirList {
	public static void main(String[] args) {
		File path = new File(
				"F:\\My_git\\ThinkingInJava\\src\\th\\part_18_IO\\chapter_01_File\\_01");
		String[] list;
		if (args.length == 0) {
			list = path.list();
		} else {
			list = path.list(new DirFilter(args[0]));
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);//case 是指英语字母的大写和小写 upper case = 大写 ，lower case = 小写
		for (String item : list) {
			System.out.println(item);
		}
	}
}
