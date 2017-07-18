package th.part_18_IO.chapter_01_File._02;

import java.io.File;
import java.io.IOException;

import th.util.Constant;

public class ProcessFiles {
	public interface Strategy{
		void process(File file);
	}
	
	private Strategy strategy;
	private String ext;
	
	public ProcessFiles(Strategy strategy,String ext){
		this.strategy=strategy;
		this.ext=ext;
	}
	/**
	 * getAbsoluteFile()返回抽象绝对路径名字符串
	 * @param file
	 * @throws Exception
	 */
	public void processDirectoryThree(File file)throws Exception{
		for(File f:Directory.walk(file.getAbsoluteFile(), ".*\\."+ext)){
			strategy.process(f.getCanonicalFile());
		}
	}
	
	public void start(String [] args){
		try {
			if(args.length==0){
				processDirectoryThree(new File(Constant.IO_ROOT_PATH_18+"ThinkingInJava\\src\\th\\part_18_IO\\chapter_01_File\\_01."));
			}else{
				for (String arg : args) {
					File fileArg=new File(arg);
					if(fileArg.isDirectory())
						processDirectoryThree(fileArg);
					else
						if(!arg.endsWith("."+ext))
							arg+="."+ext;
						strategy.process(new File(arg).getCanonicalFile());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Canonical 是标准的路径，而Absolute是绝对路径.它们之间唯一的区别就是Canonical能解析路径中的“." 和 ".." （分别代表当前路径和上一级路径）
	 * 
	 * getCanonicalFile()和getAbsoluteFile():
	 *   getXXXFile()方法只是将File对象中的路径属性由相对路径换成绝对路径而已。
	 *   如果没有getXXXFile()方法，那么我们要得到一个File路径属性为绝对路径的File对象要怎么做？
	 *   1:直接在声明File对象的时候敲入冗长的路径(File file = new File("hello.txt")为相对路径,不规范);。
	 *   2:输入相对路径由getCanonicalPath得到File的绝对路径名，然后再构造。
	 *   3:就直接再调用一次getXXXFile()方法
	 * @param args
	 * @throws IOException
	 * @throws 
	 * @date 2017年7月18日 下午5:20:42
	 */
	public static void main(String[] args) throws IOException {
		 File f = new File("src\\th\\part_18_IO\\..\\chapter_01_File\\_02\\ProcessFiles.java");
		 //   getPath()返回的是构造方法里的路径，不做任何处理
	     System.out.println("getPath():"+f.getPath());
	     //   getAbsolutePath()返回的是 user.dir+getPath()，则不管”.”、“..”，返回当前的路径加上你在new File()时设定的路径
	     System.out.println("getAbsolutePath():"+f.getAbsolutePath());
	     System.out.println("getAbsoluteFile():"+f.getAbsoluteFile());
	 	 // Canonical能解析路径中的“." 和 ".."
	     System.out.println("getCanonicalPath():"+f.getCanonicalPath());
	     System.out.println("getCanonicalFile():"+f.getCanonicalFile());
	     
	     System.out.println("================================");
	     new ProcessFiles(new ProcessFiles.Strategy() {
			@Override
			public void process(File file) {
				System.out.println(file);
			}
		},"java").start(args);
	}
}
