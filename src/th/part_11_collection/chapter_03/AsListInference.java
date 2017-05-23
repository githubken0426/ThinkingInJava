package th.part_11_collection.chapter_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AsListInference {

	public static void main(String[] args) {
		List<Snow> snow1=Arrays.asList(new Crusty(),new Slush(),new Power(),new Heavy());
		System.out.println("snow1="+snow1+",snow1.size()="+snow1.size());
		/**
		 * 编译错误
		 * Light和Heavy继承 Power,虽然Power继承了Snow,但是编译器认为他不是Snow类型
		 * Collections.addAll方法不会编译出错，但运行后会报UnsupportedOperationException异常
		 */
//		List<Snow> snow2=Arrays.asList(new Light(),new Heavy()));
		//一下方式正常
		List<Snow> snow3=new ArrayList<Snow>(Arrays.asList(new Light(),new Heavy()));
		Collections.addAll(snow3, new Light(),new Heavy());
		System.out.println("snow3="+snow3+",snow3.size()="+snow3.size());
		/**
		 * 显式类型参数说明
		 */
		List<Snow> snow4=Arrays.<Snow>asList(new Heavy());
		System.out.println("snow4="+snow4);
	}

}
