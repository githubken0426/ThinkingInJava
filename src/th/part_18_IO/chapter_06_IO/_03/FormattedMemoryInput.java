package th.part_18_IO.chapter_06_IO._03;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import th.part_18_IO.Constant;
import th.part_18_IO.chapter_06_IO._01.BufferedInputFile;

/**
 * DataInputStream面向字节的流
 * 
 * @ClassName: FormattedMemoryInput
 * @Description:
 * @author ken
 * @date 2018年2月5日 下午6:03:27
 */
public class FormattedMemoryInput {
	static String fileName = Constant.IO_ROOT_PATH_18
			+ "ThinkingInJava\\src\\th\\part_18_IO\\chapter_06_IO\\_03\\FormattedMemoryInput.java";

	public static void main(String[] args) throws IOException {
		unMessyCode();
	}
	/**
	 * 解决乱码
	 * @throws IOException
	 * @throws 
	 * @date 2018年2月5日 下午7:43:47
	 */
	static void unMessyCode() throws IOException {
		StringBuffer sb = new StringBuffer();
		//使用FileInputStream装饰
		DataInputStream input = new DataInputStream(new FileInputStream(new File(fileName)));
		int len = 0;
		byte[] buffer = new byte[4096];
		while ((len = input.read(buffer)) != -1) {
			sb.append(new String(buffer, 0, len, "UTF-8"));
		}
		System.out.println(sb.toString());
		input.close();
	}
	/**
	 * 汉字乱码
	 * @throws IOException
	 * @throws 
	 * @date 2018年2月5日 下午7:42:45
	 */
	static void messyCode() throws IOException {
		String result = BufferedInputFile.read(fileName);
		//DataInputStream是字节流，UTF-8是字符，不兼容，需要使用InputStreamReader进行转换
		DataInputStream input = new DataInputStream(new ByteArrayInputStream(result.getBytes("UTF-8")));
		/**
		 * readByte()读出来的是一个字节，而汉字是两个字节，必然乱码。
		 * available()方法是在没有阻塞的情况下所读取的字节流
		 */
		while (input.available() != 0)
			System.out.print((char) input.readByte());
		input.close();
	}
}
