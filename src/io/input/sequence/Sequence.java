package io.input.sequence;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.SequenceInputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.Vector;

import io.IoUtil;

public class Sequence {
	static Charset UTF_8 = Charset.forName("UTF-8");
	public static void main(String[] args) throws IOException {
		//test1();
		// test2();
		// test3
		System.out.println("结束，OK");
	}

	public static void test1() throws IOException {
		Vector<InputStream> vector = new Vector<>();
		vector.add(new FileInputStream(IoUtil.INPUT_PATH));
		vector.add(new FileInputStream(IoUtil.TEST_INPUT_PATH));
		Enumeration<InputStream> enumer = vector.elements();
		SequenceInputStream sequence = new SequenceInputStream(enumer);
		
		FileOutputStream out = new FileOutputStream(IoUtil.OUT_PATH);
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = sequence.read(buf)) != -1) {
			out.write(buf,0,len);
		}
		sequence.close();
		out.close();
	}

	/**
	 * 本质还是调用Enumeration
	 * 
	 * @throws IOException
	 * @throws @date
	 *             2018年12月7日 上午8:58:07
	 */
	public static void test2() throws IOException {
		InputStream input1 = new BufferedInputStream(new FileInputStream(IoUtil.TEST_INPUT_PATH));
		InputStream input2 = new BufferedInputStream(new FileInputStream(IoUtil.INPUT_PATH));
		SequenceInputStream sequence = new SequenceInputStream(input1, input2);
		FileOutputStream out = new FileOutputStream(IoUtil.OUT_PATH);
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = sequence.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		out.close();
		sequence.close();
	}
	
	public static void test3() throws IOException {
		Vector<InputStream> vector = new Vector<>();
		vector.add(new FileInputStream(IoUtil.TEST_INPUT_PATH));
		Enumeration<InputStream> enumer = vector.elements();
		SequenceInputStream sequence = new SequenceInputStream(enumer);
		
		FileOutputStream out = new FileOutputStream(IoUtil.OUT_PATH);
		OutputStreamWriter write = new OutputStreamWriter(out, UTF_8);
		BufferedWriter buffer=new BufferedWriter(write);
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = sequence.read(buf)) != -1) {
			System.out.println(new String(buf, UTF_8));
			out.write(buf,0,len);
		}
		sequence.close();
		buffer.close();
	}
}
