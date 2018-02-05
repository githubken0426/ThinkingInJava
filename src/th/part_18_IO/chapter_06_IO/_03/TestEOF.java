package th.part_18_IO.chapter_06_IO._03;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import th.part_18_IO.Constant;

/**
 * DataInputStream available()方法是在没有阻塞的情况下所读取的字节流
 * @author Administrator
 * 2015-11-26 上午10:58:13
 *
 */
public class TestEOF {
	static String fileName = Constant.IO_ROOT_PATH_18
			+ "ThinkingInJava\\src\\th\\part_18_IO\\chapter_06_IO\\_03\\TestEOF.java";
	
	public static void main(String[] args) {
		try {
			DataInputStream in =new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
			while((in.available())!=0){
				System.out.print((char)in.readByte());
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
