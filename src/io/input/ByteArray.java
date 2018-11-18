package io.input;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.IoUtil;

public class ByteArray {
	/**
	 * 字节数组输入流在内存中创建一个字节数组缓冲区，从输入流读取的数据保存在该字节数组缓冲区中。
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		writeFile();
		printInfo();
	}
	/**
	 * ByteArrayOutputStream输出二进制内容
	 * @throws IOException
	 */
	public static void printInfo() throws IOException {
		byte byteArray [] = IoUtil.traditionConvert();
		InputStream input=new ByteArrayInputStream(byteArray);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream(byteArray.length);
		byte[] buffer = new byte[1024];
		int postion = 0;
		while ((postion = input.read(buffer)) != -1) 
			out.write(buffer, 0, postion);
		
		byte[] data = out.toByteArray(); // 取内存中保存的数据
		System.out.println(new String(data, "utf-8"));
	}
	/**
	 * FileOutputStream写入到文件
	 * @throws IOException
	 */
	public static void writeFile() throws IOException {
		byte byteArray [] = IoUtil.nioConvert();
		OutputStream fileOut=new FileOutputStream(IoUtil.OUT_PATH);
		fileOut.write(byteArray,0,byteArray.length);
		fileOut.flush();
		fileOut.close();
		System.out.println("写入完毕");
	}
}
