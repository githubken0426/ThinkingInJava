package th.part_13_String.chaper_07;

import java.util.Scanner;

public class ScannerDelimiter {
	public static void main(String[] args) {
		Scanner input=new Scanner("12, 42, 45, 46, 50");
		input.useDelimiter("\\s*,\\S*");
		while(input.hasNext()){
			System.out.println(input.next());
		}
	}
}
