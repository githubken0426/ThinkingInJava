package th.part_18_IO.chapter_06_IO._02;

import java.io.IOException;
import java.io.StringReader;

import th.part_18_IO.chapter_06_IO._01.BufferedInputFile;

/**
 * ���ڴ�����
 * @author Administrator
 * 2015-11-26 ����10:22:57
 *
 */
public class MemoryInput {
	public static void main(String[] args) {
		String fileName="E:\\Eclipse_WS\\ThinkingInJava\\src\\th\\part_18_IO\\chapter_06_IO\\_02\\MemoryInput.java";
		try {
			StringReader in =new StringReader(BufferedInputFile.read(fileName));
			int c;
			while((c=in.read())!=-1){
				System.out.print((char)c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
