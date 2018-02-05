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
			DataInputStream input =new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
			int len = 0;
			byte[] buffer = new byte[4096];
			while ((len = input.read(buffer)) != -1) {
				System.out.println(new String(buffer, 0, len, "UTF-8"));
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
