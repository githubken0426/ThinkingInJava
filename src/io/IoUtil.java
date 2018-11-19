package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class IoUtil {
	public static final String INPUT_PATH = "D:\\Git_workspace\\Git_ThingiInJava\\ThinkingInJava\\src\\io\\Java_IO.docx";
	public static final String OUT_PATH = "C:\\Users\\ken\\Desktop\\Java_IO.docx";
	/**
	 * 传统转换
	 * FileInputStream是字节流，BufferedInputStream是字节缓冲流，
	 * 使用BufferedInputStream读资源比FileInputStream读取资源的效率高
	 * （BufferedInputStream的read方法会读取尽可能多的字节），
	 * 且FileInputStream对象的read方法会出现阻塞；
	 * @return
	 * @throws IOException
	 */
	public static byte[] traditionConvert() throws IOException {
		File file = new File(INPUT_PATH);
		InputStream input = new BufferedInputStream(new FileInputStream(file));
		byte[] byteArray = new byte[(int) file.length()];
		input.read(byteArray);
		input.close();
		return byteArray;
	}
	/**
	 * Nio方式转换
	 * @return
	 * @throws IOException
	 */
	public static byte[] nioConvert() throws IOException {
		File file = new File(INPUT_PATH);
		byte[] byteArray = Files.readAllBytes(file.toPath());
		//byte[] bFile = Files.readAllBytes(Paths.get(INPUT_PATH));
		return byteArray;
	}
}
