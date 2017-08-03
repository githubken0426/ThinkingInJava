package th.part_18_IO.chapter_02_IN_OUT.out;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PipedOutputStream;

public class OutputStreamTest {
	public static void main(String[] args) {
		try {
			//1.把信息存入文件中
			OutputStream out=new FileOutputStream("F:\\stream.xml");
			//2.把信息存入内存中的一个缓冲区中
			out=new ByteArrayOutputStream();
			//3.处理被序列化的对象
			out=new ObjectOutputStream(null);
			//4.处理线程间的输入流
			out=new PipedOutputStream();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
