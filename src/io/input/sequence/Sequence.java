package io.input.sequence;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

import io.IoUtil;

public class Sequence {

	public static void main(String[] args) throws IOException {
		//test1();
		System.out.println("");
		test2();
	}

	public static void test1() throws IOException {
		Vector<InputStream> vector = new Vector<InputStream>();
		vector.add(new BufferedInputStream(new FileInputStream(IoUtil.TEST_INPUT_PATH)));
		vector.add(new BufferedInputStream(new FileInputStream(IoUtil.INPUT_PATH)));
		Enumeration<InputStream> en = vector.elements();
		SequenceInputStream sis = new SequenceInputStream(en);
		FileOutputStream fos = new FileOutputStream(IoUtil.OUT_PATH);
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = sis.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}
		fos.close();
		sis.close();
	}

	public static void test2() throws IOException {
		InputStream input1 = new BufferedInputStream(new FileInputStream(IoUtil.TEST_INPUT_PATH));
		InputStream input2 = new BufferedInputStream(new FileInputStream(IoUtil.INPUT_PATH));
		SequenceInputStream sequence = new SequenceInputStream(input1,input2);
		FileOutputStream out = new FileOutputStream(IoUtil.OUT_PATH);
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = sequence.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		out.close();
		sequence.close();
	}
}
