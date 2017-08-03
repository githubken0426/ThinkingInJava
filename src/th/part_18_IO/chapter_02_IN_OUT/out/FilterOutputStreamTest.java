package th.part_18_IO.chapter_02_IN_OUT.out;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class FilterOutputStreamTest {
	public static void main(String[] args) {
		try {
			OutputStream out=new FileOutputStream("path");
			//1.从stream中读取基本类型（int、char等）数据
			FilterOutputStream filter=new DataOutputStream(out);
			//2.缓冲输出流,作用是为另一个输出流提供“缓冲功能”。
			filter=new BufferedOutputStream(out);
			//3.打印各种数据值表示形式
			filter=new PrintStream(out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
