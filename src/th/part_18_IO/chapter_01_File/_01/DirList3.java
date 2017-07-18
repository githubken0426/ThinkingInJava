package th.part_18_IO.chapter_01_File._01;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 匿名内部类实现3
 * @ClassName: DirList3 
 * @Description: TODO 
 * @author ken 
 * @date 2017年7月18日 下午4:13:59 
 *
 */
public class DirList3 {
	public static final String PATH_SECOND = "F:\\My_git\\ThinkingInJava\\src\\th\\part_18_IO\\chapter_01_File\\_01";
	/**
	 * 
	 * @param args
	 * @throws 
	 * @throws 
	 * @date 2017年7月18日 下午4:30:23
	 */
	public static void main(String[] args){
		File file = new File(PATH_SECOND);
		String[] str=file.list(new FilenameFilter() {
			String regex="DirFilter.java";
			Pattern pattern=Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				boolean result=pattern.matcher(name).matches();
				return result;
			}
		});
		Arrays.sort(str,String.CASE_INSENSITIVE_ORDER);
		for (String ele : str) {
			System.out.println(ele);
		}
	}
}
