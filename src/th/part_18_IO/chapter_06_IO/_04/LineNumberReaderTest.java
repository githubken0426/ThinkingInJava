package th.part_18_IO.chapter_06_IO._04;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import th.part_18_IO.Constant;

/**
 * 可以通过行号判断
 * @ClassName: LineNumberReaderTest 
 * @Description: 
 * @author ken 
 * @date 2018年2月6日 下午5:25:01
 */
public class LineNumberReaderTest {
	static String fileName = Constant.IO_ROOT_PATH_18+"ThinkingInJava\\src\\th\\part_18_IO\\chapter_06_IO\\_04\\LineNumberReaderTest.java";
	public static void main(String[] args) throws IOException {
		LineNumberReader in =new LineNumberReader(new FileReader(fileName));
		//只是设置行号,并不能读取指定的行号
		in.setLineNumber(15);
		while(in.readLine()!=null) {
			System.out.println(in.getLineNumber()+in.readLine());
		}
		in.close();
	}
}
