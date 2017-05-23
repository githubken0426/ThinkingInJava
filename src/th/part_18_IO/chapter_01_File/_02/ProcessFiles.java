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
	 * getAbsoluteFile()���س������·�����ַ���
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
		 //   getPath()���ص��ǹ��췽�����·���������κδ���
	     System.out.println(f.getPath());
	     //   getAbsolutePath()���ص��� user.dir+getPath()��Ҳ����ִ��·�����Ϲ��췽���е�·��
	     System.out.println(f.getAbsolutePath());
	 	 //   getCanonicalPath()���ص��ǽ�������ȫ������·����Ҳ����ȫ·��
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
