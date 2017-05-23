package th.part_17_DeepInCollection.chapter_09HashCode;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class SpringDetector {
	public static <T extends Groundhog> void detectorSpring(Class<T> type)
			throws Exception {
		Constructor<T> ghog = type.getConstructor(int.class);
		Map<Groundhog,Prediction> map=new HashMap<Groundhog,Prediction>();
		for(int i=0;i<3;i++)
			map.put(ghog.newInstance(i), new Prediction());
		System.out.println("map:"+map);
		Groundhog gh=ghog.newInstance(0);
		System.out.println("\nLooking up prediction for "+gh);
		/**
		 * �����ҵ�keyֵ����0��Groundhog
		 * Groundhog�Զ��̳�Object,
		 * ʹ�õ���Object��hashCode()���ɵ�ɢ����(Ĭ��ʹ�ö���ĵ�ַ����ɢ����)
		 * ghog.newInstance(i)��ghog.newInstance(0)������ʵ��������ɢ���벻ͬ
		 * �����д��hashCode()�����ҲҪ��дequals()
		 */
		if(map.containsKey(gh))
			System.out.println("\nmap.get(gh):"+map.get(gh));
		else
			System.out.println("\nkey not found:"+gh);
	}
	
	public static void main(String[] args) {
		try {
			detectorSpring(Groundhog.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
