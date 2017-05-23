package th.part_18_IO.chapter_01_File._01;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;


public class DirFilter implements  FilenameFilter {
	private Pattern pattern;
	
	public DirFilter(String regex){
		pattern=Pattern.compile(regex);
	}
	/**
	 * accept()方法可以回调给list()使用
	 */
	@Override
	public boolean accept(File dir, String mame) {
		boolean b=pattern.matcher(mame).matches();
		return b;
	}

}
