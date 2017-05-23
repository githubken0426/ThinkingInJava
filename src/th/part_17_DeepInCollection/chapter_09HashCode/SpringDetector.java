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
		 * 不会找到key值包含0的Groundhog
		 * Groundhog自动继承Object,
		 * 使用的是Object的hashCode()生成的散列码(默认使用对象的地址计算散列码)
		 * ghog.newInstance(i)和ghog.newInstance(0)是两个实例，所以散列码不同
		 * 如果重写了hashCode()则必须也要重写equals()
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
