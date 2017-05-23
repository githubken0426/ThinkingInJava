package th.part_18_IO.chapter_01_File._02;

import java.io.File;
import java.io.IOException;

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
				processDirectoryThree(new File("E:\\Eclipse_WS\\ThinkingInJava\\src\\th\\part_18_IO\\chapter_01_File\\_01."));
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
	
	public static void main(String[] args) throws IOException {
		 File f = new File("..\\src\\file");
		 //   getPath()返回的是构造方法里的路径，不做任何处理
	     System.out.println(f.getPath());
	     //   getAbsolutePath()返回的是 user.dir+getPath()，也就是执行路径加上构造方法中的路径
	     System.out.println(f.getAbsolutePath());
	 	 //   getCanonicalPath()返回的是将符号完全解析的路径，也就是全路径
	     System.out.println(f.getCanonicalPath());
	     
	     System.out.println("================================");
	     
	     new ProcessFiles(new ProcessFiles.Strategy() {
			
			@Override
			public void process(File file) {
				System.out.println(file);
			}
		},"java").start(args);
	}
}
