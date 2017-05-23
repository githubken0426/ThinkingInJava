package th.part_18_IO.chapter_01_File._01;

import java.io.File;
import java.util.Arrays;

/**
 * File对象
 * 
 * @author ken 2017-5-18 下午02:24:18
 */
public class DirList {
	public static void main(String[] args) {
		File path = new File(
				"C:\\Users\\Administrator\\git\\My_Git_Version201759\\ThinkingInJava\\src\\th\\part_18_IO\\chapter_01_File\\_01");
		String[] list;
		if (args.length == 0) {
			list = path.list();
		} else {
			list = path.list(new DirFilter(args[0]));
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String item : list) {
			System.out.println(item);
		}
	}
}
