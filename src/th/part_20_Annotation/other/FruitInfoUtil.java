package th.part_20_Annotation.other;

import java.lang.reflect.Field;

public class FruitInfoUtil {
	public static void getFruitInfo(Class<?> clazz) {
		String strFruitName = " 水果名称：";
		String strFruitColor = " 水果颜色：";
		String strFruitProvicer = "供应商信息：";
		Field[] fields = clazz.getDeclaredFields();
		
		for (Field field : fields) {
			//isAnnotationPresent(Class<? extends Annotation>)
			//如果指定类型的注释存在于此元素上,返回true,否则返回false
			if (field.isAnnotationPresent(FruitName.class)) {
				FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
				strFruitName += fruitName.value();
				System.out.println(strFruitName);
			} else if (field.isAnnotationPresent(FruitColor.class)) {
				FruitColor fruitColor = (FruitColor) field.getAnnotation(FruitColor.class);
				strFruitColor += fruitColor.fruitColor().toString();
				System.out.println(strFruitColor);
			} else if (field.isAnnotationPresent(FruitProvider.class)) {
				FruitProvider fruitProvider = (FruitProvider) field.getAnnotation(FruitProvider.class);
				strFruitProvicer = " 供应商编号：" + fruitProvider.id() + " 供应商名称：" + fruitProvider.name() + " 供应商地址："
						+ fruitProvider.address();
				System.out.println(strFruitProvicer);
			}
		}
	}
	
	public static void main(String[] args) {
        getFruitInfo(Apple.class);
    }
}
