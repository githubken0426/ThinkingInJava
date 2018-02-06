package th.part_18_IO.chapter_06_IO._04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import th.part_18_IO.Constant;
import th.part_18_IO.chapter_06_IO._01.BufferedInputFile;

/**
 * 18.6.4Reader和Writer
 * @ClassName: BasicFileOutPut 
 * @Description: 
 * @author ken 
 * @date 2018年2月6日 下午6:03:42
 */
public class BasicFileOutPut {
	static String fileName = Constant.IO_ROOT_PATH_18+"ThinkingInJava\\src\\th\\part_18_IO\\chapter_06_IO\\_04\\BasicFileOutPut.java";
	static String writeFile ="C:\\Users\\Administrator\\Desktop\\fl.txt";
	public static void main(String[] args) {
		try {
			BufferedReader in =new BufferedReader(new FileReader(fileName));
			PrintWriter out =new PrintWriter(new BufferedWriter(new FileWriter(writeFile)));
			/**
			 * PrintWriter提供了辅助的构造器,不用每次都调用装饰类
			 */
			PrintWriter out2 =new PrintWriter(writeFile);
			int lineCount=1;
			String s;
			while((s=in.readLine())!=null){
				out.println(s+":"+lineCount);
				lineCount++;
			}
			//如果不显示调用close,缓冲区内容不会刷新,无法写入文件
			out.close();
			out2.close();
			in.close();
			System.out.println(BufferedInputFile.read(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
