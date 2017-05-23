package th.part_20_Annotation.chapter_01_Base._01;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserCateTraker {
	public static void trakerUserCase(List<Integer> userCase,Class<?> c){
		for (Method me: c.getDeclaredMethods()) {
			UserCase uc=me.getAnnotation(UserCase.class);
			if(uc!=null){
				System.out.println("From UserCase:"+uc.description()+","+uc.id());
				userCase.remove(new Integer(uc.id()));
			}
		}
		for(int i:userCase){
			System.out.println("Missing UserCase:"+i);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> userCase =new ArrayList<Integer>();
		Collections.addAll(userCase,47,48,49);
		trakerUserCase(userCase,PasswordUtil.class);
	}
}
