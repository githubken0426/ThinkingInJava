package th.part_18_IO.chapter_02_IN_OUT.in;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PipedInputStream;
import java.io.SequenceInputStream;
import java.io.StringBufferInputStream;

import javax.sound.sampled.AudioInputStream;
/**
 * Reader 用于读入16位字符，也就是Unicode 编码的字符；
 * 而 InputStream 用于读入 ASCII 字符和二进制数据。
 * @ClassName: InputStreamTest 
 * @Description: 
 * @author ken 
 * @date 2017年7月19日 上午10:38:40
 */
public class InputStreamTest {
	public static void main(String[] args) {
		try {
			//1.处理文件，从文件中读取信息。
			InputStream stream=new FileInputStream("F:\\stream.xml");
			String str="test";
			//2.将String转换为InputStream.使用StringBuffer作为数据源。(ByteArrayInputStream替代)
			stream=new StringBufferInputStream(str);
			//3.处理字节数组
			stream=new ByteArrayInputStream(str.getBytes("UTF-8"));
			//4.处理被序列化的对象
			stream=new ObjectInputStream(stream);
			//5.处理线程间的输入流
			stream=new PipedInputStream();
			//6.处理多种数据来源(将一个或多个InputStream转换为一个)
			stream=new SequenceInputStream(stream, stream);
			//7.处理音频
			stream=new AudioInputStream(null);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
