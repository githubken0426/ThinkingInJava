package th.part_18_IO.chapter_01_File._02;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import th.part_18_IO.Constant;

/**
 * 目录
 * 
 * @author ken 2015-11-23 上午08:40:03
 *
 */
public class Directory {
	
	/**
	 * 测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String path = Constant.IO_ROOT_PATH_18 + "ThinkingInJava\\src\\th\\part_18_IO\\chapter_01_File\\_02";
		if (args.length == 0) {
			System.out.print(walk(path));
		} else {
			for (String str : args) {
				System.out.println(walk(str));
			}
		}
		System.out.println();
		File [] files=local(path,".*\\.java");
		for (File file : files) {
			System.out.println(file.getName());
		}
	}
	
	/**
	 * listFiles()方法是返回某个目录下所有文件和目录的绝对路径，返回的是File数组
	 * list()方法是返回某个目录下的所有文件和目录的文件名，返回的是String数组
	 * 
	 * @param dir
	 * @param regex
	 * @return
	 * @throws @date
	 *             2017年7月18日 下午4:41:18
	 */
	public static File[] local(File dir, final String regex) {
		
		return dir.listFiles(new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);
			
			@Override
			public boolean accept(File dir, String name) {
				File f = new File(name);
				String fName = f.getName();
				Matcher matcher = pattern.matcher(fName);
				boolean result=matcher.matches();
				return result;
			}
		});
	}

	public static File[] local(String path, final String regex) {
		return local(new File(path), regex);
	}

	public static class ThreeInfo implements Iterable<File> {
		public List<File> files = new ArrayList<File>();
		public List<File> dirs = new ArrayList<File>();

		@Override
		public Iterator<File> iterator() {
			return files.iterator();
		}

		void addAll(ThreeInfo other) {
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}
		
		public String toString() {
			System.out.println("*********************文件路径：*********************");
			for (File file : files) {
				System.out.println(file);
			}
			System.out.println("^^^^^^^^^^^^^^^^^^^^^文件夹路径：*********************");
			for (File dir : dirs) {
				System.out.println(dir);
			}
			return "dirs:" + dirs + ",files" + files;
		}

	}

	/**
	 * recurse 递归
	 * 
	 * @param startDir
	 * @param regex
	 * @return
	 */
	public static ThreeInfo recurseDirs(File startDir, String regex) {
		ThreeInfo result = new ThreeInfo();
		File[] fileList=startDir.listFiles();
		for (File item : fileList) {// 能够获取当前文件夹下的所有文件和文件夹
			if (item.isDirectory()) { // 如果path表示的是一个目录则返回true
				result.dirs.add(item);
				result.addAll(recurseDirs(item, regex));
			} else if (item.getName().matches(regex))
				result.files.add(item);
		}
		return result;
	}

	public static ThreeInfo walk(String start, String regex) {
		return recurseDirs(new File(start), regex);
	}

	public static ThreeInfo walk(File start, String regex) {
		return recurseDirs(start, regex);
	}

	public static ThreeInfo walk(File start) {
		return recurseDirs(start, ".*");
	}

	public static ThreeInfo walk(String start) {
		return recurseDirs(new File(start), ".*");
	}
}
