package th.part_18_IO.exercise;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import TIJ4_code.net.mindview.util.TextFile;

/**
 * 练习1
 * @author Administrator
 * 20151030
 */
public class E01_SearchWords {
	public static void main(final String[] args) {
		File path=new File
				("E:\\Eclipse_WS\\ThinkingInJava\\src\\th\\part_18_IO\\exercise.");
		String [] list;
		if(args.length==0)
			list=path.list();
		else
			list=path.list(new FilenameFilter() {
				private String ext=args[0].toLowerCase();
				@Override
				public boolean accept(File dir, String name) {
					if(name.toLowerCase().endsWith(ext)){
						if(args.length==1)
							return true;
						Set<String> set=new HashSet<String>
							(new TextFile(new File(dir,name).getAbsolutePath(),"\\W+"));
						for(int i=0;i<args.length;i++){
							if(set.contains(args[i])){
								return true;
							}
						}
					}
					return false;
				}
			});
			Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
			for (String item : list) {
				System.out.println(item);
			}
	}
}
