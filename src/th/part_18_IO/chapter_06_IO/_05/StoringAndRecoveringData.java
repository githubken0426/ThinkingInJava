package th.part_18_IO.chapter_06_IO._05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StoringAndRecoveringData {
	static String file = "C:\\Users\\Administrator\\Desktop\\StoringAndRecoveringData.txt";
	

	public static void main(String[] args) {
		try {
			DataOutputStream out = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(file)));
			out.writeUTF("This is pai");
			out.writeDouble(3.1415926);
			out.writeUTF("Square root of 2");
			out.close();
			DataInputStream in = new DataInputStream(new BufferedInputStream(
					new FileInputStream(file)));
			System.out.println(in.readUTF());
			System.out.println(in.readDouble());
			System.out.println(in.readUTF());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
