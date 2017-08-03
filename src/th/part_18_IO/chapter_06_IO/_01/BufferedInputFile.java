package th.part_18_IO.chapter_06_IO._01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import th.part_18_IO.Constant;

/**
 * 缓冲输入文件
 * @author Administrator
 * 2015-11-24 下午04:21:49
 *
 */
public class BufferedInputFile {
	
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
	public static String read(String filePath) throws IOException{
		BufferedReader in =new BufferedReader(new FileReader(filePath));
		String str;
		StringBuilder sb=new StringBuilder();
		while((str=in.readLine())!=null){
			sb.append(str+"\n");
		}
		in.close();
		return sb.toString();
	}
	public static void main(String[] args) {
		try {
			String str=read(Constant.IO_ROOT_PATH_18+"\\ThinkingInJava\\src\\th\\part_18_IO\\chapter_06_IO\\_01\\BufferedInputFile.java");
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
