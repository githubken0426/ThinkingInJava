package th.part_18_IO.chapter_02_IN_OUT.in;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.LineNumberInputStream;
import java.io.PushbackInputStream;
/**
 * 
 * @ClassName: InputStreamTest 
 * @Description: 
 * @author ken 
 * @date 2017年7月19日 上午10:38:40
 */
public class FilterInputStreamTest {
	@SuppressWarnings({ "deprecation", "resource" })
	public static void main(String[] args) {
		try {
			InputStream stream=new FileInputStream("F:\\stream.xml");
			/**
			 * DataInputStream 是数据输入流。它继承于FilterInputStream。
			 * DataInputStream 是用来装饰其它输入流，它“允许应用程序以与机器无关方式从底层输入流中读取基本 Java 数据类型”
			 */
			FilterInputStream filterStream=new DataInputStream(stream);
			/**
			 * 缓冲器指的是缓冲寄存器，它分输入缓冲器和输出缓冲器两种。
			 * 前者的作用是将外设送来的数据暂时存放，以便处理器将它取走；
			 * 后者的作用是用来暂时存放处理器送往外设的数据。
			 * 有了数控缓冲器，就可以使高速工作的CPU与慢速工作的外设起协调和缓冲作用，实现数据传送的同步。
			 * 由于缓冲器接在数据总线上，故必须具有三态输出功能.
			 * 
			 * BufferedInputStream内部有一个缓冲区，默认大小为8M，每次调用read方法的时候，它首先尝试从缓冲区里读取数据，
			 * 若读取失败（缓冲区无可读数据），则选择从物理数据源（譬如文件）读取新数据（这里会尝试尽可能读取多的字节）放入到缓冲区中，
			 * 最后再将缓冲区中的内容部分或全部返回给用户.
			 * 由于从缓冲区里读取数据远比直接从物理数据源（譬如文件）读取速度快，所以BufferedInputStream的效率很高！
			 */
			filterStream=new BufferedInputStream(stream);
			/**
			 * LineNumberInputStream可以获取当前的行号或设置当前行号,已过时。已经被LineNumberReader替代
			 */
			filterStream=new LineNumberInputStream(stream);
			/**
			 * 可以将当前读取的字节数据推回到缓存区
			 */
			filterStream=new PushbackInputStream(stream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
