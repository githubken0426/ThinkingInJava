package th.part_18_IO.chapter_01_File;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

import th.part_18_IO.Constant;

public class TestMain {
	public static void main(String[] args) {
		MyFile file = new MyFile(Constant.IO_ROOT_PATH_18 + "ThinkingInJava\\src\\th\\part_18_IO\\chapter_01_File\\_01");
		String[] files = file.list(new MyFiler());
		for (String f : files) {
			System.out.println(f);
		}
	}
}

class MyFiler implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		System.out.println("dir:" + dir + ",name:" + name);
		return name.endsWith(".java");
	}
}

class MyFile extends File {
	private static final long serialVersionUID = 1L;
	
	public MyFile(String uri) {
		super(uri);
	}

	public String[] list(FilenameFilter filter) {
		String names[] = list();
		if ((names == null) || (filter == null)) {
			return names;
		}
		ArrayList<String> array = new ArrayList<String>();
		for (int i = 0; i < names.length; i++) {
			if (filter.accept(this, names[i])) {
				array.add(names[i]);
			}
		}
		String str[] = new String[array.size()];
		String result[] = (String[]) array.toArray(str);
		return result;
	}

}
