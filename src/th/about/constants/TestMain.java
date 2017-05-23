package th.about.constants;

import static th.about.constants.Constants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 静态导入(jdk1.5)
 * 
 * @author Administrator 2015年10月12日
 */

public class TestMain {
	public static void main(String[] args) {
		System.out.println(NAME);
		System.out.println(MAX_VALUE);

		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString().toUpperCase().replace("-", ""));
		System.out.println(uuid.toString().toUpperCase().replace("-", "").length());
		
		List<String> list=new ArrayList<String>();
		for(int i=0;i<1000000;i++){
			UUID uid = UUID.randomUUID();
			list.add(uid.toString());
		}
		for(int i=0;i<list.size();i++){
			String strI=list.get(i);
			for(int j=i+1;j<list.size();j++){
				String strJ=list.get(j);
				if(strI.equals(strJ)){
					System.out.println(strJ);
					break;
				}
			}
		}
		System.out.println("end");
	}
}
