package th.part_18_IO.chapter_06_IO._06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class UsingRandomAccessFile {
	static String file = "C:\\Users\\Administrator\\Desktop\\UsingRandomAccessFile.txt";

	static void display() throws IOException {
		RandomAccessFile rf = new RandomAccessFile(file, "r");
		for (int i = 0; i < 7; i++) {
			System.out.println("Value:" + i + ":" + rf.readDouble());
		}
		System.out.println(rf.readUTF());
		rf.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
		try {
			for (int i = 0; i < 7; i++) {
				rf.writeDouble(i * 1.414);
			}
			rf.writeUTF("The end of File");
			rf.close();
			display();
			rf = new RandomAccessFile(file, "rw");
			rf.seek(5 * 8);
			rf.writeDouble(47.00001);
			rf.close();
			display();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
