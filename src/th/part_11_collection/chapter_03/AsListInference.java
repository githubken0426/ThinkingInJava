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
		 * �������
		 * Light��Heavy�̳� Power,��ȻPower�̳���Snow,���Ǳ�������Ϊ������Snow����
		 * Collections.addAll�������������������к�ᱨUnsupportedOperationException�쳣
		 */
//		List<Snow> snow2=Arrays.asList(new Light(),new Heavy()));
		//һ�·�ʽ����
		List<Snow> snow3=new ArrayList<Snow>(Arrays.asList(new Light(),new Heavy()));
		Collections.addAll(snow3, new Light(),new Heavy());
		System.out.println("snow3="+snow3+",snow3.size()="+snow3.size());
		/**
		 * ��ʽ���Ͳ���˵��
		 */
		List<Snow> snow4=Arrays.<Snow>asList(new Heavy());
		System.out.println("snow4="+snow4);
	}

}
