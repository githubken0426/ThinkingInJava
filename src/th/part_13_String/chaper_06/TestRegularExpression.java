package th.part_13_String.chaper_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestRegularExpression {
	
	public static void main(String[] args) {
		if(args.length>2){
			System.out.println("Useage:TestRegularExpression");
			System.exit(0);
		}
		args=new String[]{"abc","abc","abc2"};
		for (String str : args) {
			Pattern p=Pattern.compile(str);
			Matcher m=p.matcher(args[0]);
			while(m.find()){
				System.out.println("m.group():"+m.group()+";m.start():"+m.start()+"-"+m.end());
			}
		}
	}
}
