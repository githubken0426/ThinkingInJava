package th.part_18_IO.chapter_04_ReadWrite.writer;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class WriterTest {
	public static void main(String[] args) {
		try {
			// 1.将指定的字符串构造成一个字符输出缓冲区提供给其他字符IO类使用
			char[] ch = "test".toCharArray();
			Writer writer = new CharArrayWriter();
			// 2.处理文本信息
			writer = new StringWriter();
			// 3.提供通用的缓冲方式文本读取
			writer = new BufferedWriter(writer);
			// 4.将字节流转换为字符流
			writer = new OutputStreamWriter(new ByteArrayOutputStream());
			// 4.1.读取文件中的数据,继承OutputStreamwrite
			writer = new FileWriter(new File("path"));
			// 5.管道输入流,可用于线程间管道通信
			writer = new PipedWriter();
			// 6.向文本输出流打印对象的格式化表示形式
			writer = new PrintWriter("");
			//FilterWriter需要自己实现
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
