package th.part_13_String.chaper_06;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {
	public static final String POEM="Twas brilling,and the slithy toves\n"+
				"Did gyre and gimble in the wabe.\n"+"All mimisy were the borogoves.\n"+
				"Beware the Jabberwock,my son,\n"+"The jaws that bite ,the claws that chatch.\n"+
				"Bewate the Jub bird ,and shun \n"+"The frumious Bandersnatch";
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Matcher m=Pattern.compile("(?m)(\\s+)\\s+((\\s+)\\s+(\\s+))$").matcher(POEM);
		while(m.find()){
			for(int j=0;j<=m.groupCount();j++){
				System.out.println("["+m.group()+"]");
			}
		}
		System.out.println("What is you name?");
		String name=input.next();
		System.out.println(name);
	}
}
