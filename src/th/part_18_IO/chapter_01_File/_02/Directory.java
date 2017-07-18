package th.part_18_IO.chapter_01_File._02;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import th.util.DateUtil;


/**
 * 目录
 * @author Administrator
 * 2015-11-23 上午08:40:03
 *
 */
public class Directory {
	public static File[] local(File dir,final String regex){
		return dir.listFiles(new FilenameFilter(){
			private Pattern pattern=Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(new File(name).getName()).matches();
			}
		});
	}
	
	public static File[] local(String path,final String regex){
		return local(new File(path),regex);
	}
	
	public static class ThreeInfo implements Iterable<File> {
		public List<File> files=new ArrayList<File>();
		public List<File> dirs=new ArrayList<File>();
		
		@Override
		public Iterator<File> iterator() {
			return files.iterator();
		}

		void addAll(ThreeInfo other){
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}
		
		public String toString(){
			return "dirs:"+dirs+",files"+files;
		}
	}
		/**
		 * recurse �ݹ�
		 * @param startDir
		 * @param regex
		 * @return
		 */
		public static ThreeInfo recurseDirs(File startDir,String regex){
			ThreeInfo result =new ThreeInfo();
			for(File item:startDir.listFiles()){//�ܹ���ȡ��ǰ�ļ����µ������ļ����ļ���
				if(item.isDirectory()){			//���path��ʾ����һ��Ŀ¼�򷵻�true
					result.dirs.add(item);
					result.addAll(recurseDirs(item,regex));
				}else
					if(item.getName().matches(regex))
						result.files.add(item);
			}
			return result;
		}
		
		public static ThreeInfo walk(String start,String regex){
			return recurseDirs(new File(start),regex);
		}
		public static ThreeInfo walk(File start,String regex){
			return recurseDirs(start,regex);
		}
		public static ThreeInfo walk(File start){
			return recurseDirs(start,".*");
		}
		public static ThreeInfo walk(String start){
			return recurseDirs(new File(start),".");
		}
		
		/**
		 * ����
		 * @param args
		 */
		public static void main(String[] args) {
			
			DateUtil.sdf1.format("");
			if(args.length==0){
				System.out.print(walk("E:\\Eclipse_WS\\ThinkingInJava\\src\\th\\part_18_IO."));
			}else{
				for (String str : args) {
					System.out.println(walk(str));
				}
			}
		}
}
