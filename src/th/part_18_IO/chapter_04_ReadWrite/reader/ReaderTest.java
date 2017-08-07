package th.part_18_IO.chapter_04_ReadWrite.reader;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PipedReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
/**
 * Reader 用于读入16位字符，也就是Unicode 编码的字符；
 * 而 InputStream 用于读入 ASCII 字符和二进制数据。
 * @ClassName: ReaderTest 
 * @Description: 
 * @author ken 
 * @date 2017年8月4日 上午9:49:10
 */
public class ReaderTest {
	public static void main(String[] args) {
		try {
			// 1.将指定的字符串构造成一个字符输入缓冲区提供给其他字符IO类使用
			char[] ch = "test".toCharArray();
			Reader reader = new CharArrayReader(ch);
			// 2.处理文本信息
			reader = new StringReader("test");
			// 3.提供通用的缓冲方式文本读取
			reader = new BufferedReader(reader);
				// 3.1 继承BufferedReader
			reader = new LineNumberReader(reader);
			// 4.将字节流转换为字符流
			reader = new InputStreamReader(new ByteArrayInputStream("test".getBytes("UTF-8")));
				// 4.1.读取文件中的数据,继承InputStreamReader
			reader = new FileReader(new File("path"));
			//5.管道输入流,可用于线程间管道通信
			reader = new PipedReader();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
