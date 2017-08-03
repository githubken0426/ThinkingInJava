package th.part_18_IO.chapter_01_File._01;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

import th.part_18_IO.Constant;

/**
 * 匿名内部类创建FilenameFilter
 * 
 * @author ken 2017-5-18 下午02:43:37
 */
public class DirList2 {
	public static void test() {
		ABClass a = new ABClass() {
			@Override
			public void f() {
				System.out.println("test");
			}
		};
		a.f();
	}

	static interface ABClass {
		void f();
	}

	public static FilenameFilter filter(final String regex) {
		return new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);

			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		};
	}

	public static void main(String[] args) {
		File path = new File(Constant.IO_ROOT_PATH_18+"ThinkingInJava\\\\src\\\\th\\\\part_18_IO\\\\chapter_01_File\\\\_01");
		String[] list = path.list(filter("DirFilter.java"));
		/*
		 * if(args.length==0){ 
		 * 	list=path.list(); 
		 * } else{ 
		 * 	list = path.list(filter(args[0])); 
		 * }
		 */
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String item : list) {
			System.out.println(item);
		}
	}
}
