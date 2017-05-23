package th.part_18_IO.chapter_06_IO._03;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * DataInputStream available()��������û�����������������ȡ���ֽ���
 * @author Administrator
 * 2015-11-26 ����10:58:13
 *
 */
public class TestEOF {
	public static void main(String[] args) {
		String fileName="E:\\Eclipse_WS\\ThinkingInJava\\src\\th\\part_18_IO\\chapter_06_IO\\_03\\TestEOF.java";
		try {
			DataInputStream in =new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
			while((in.available())!=0){
				System.out.print((char)in.readByte());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
