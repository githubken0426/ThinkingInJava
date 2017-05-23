package th.part_14_TypeInfo.chapter_03._03;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归计数
 * @author Administrator
 * 2015年9月8日
 */
public class TypeCounter extends HashMap<Class<?>,Integer> {
	/**
	 * instanceof 针对实例
	 * 
	 * isAssignableFrom(Class<?> cls)校验一个类是否实现指定的父类,针对class对象.
	 * 如果调用这个方法的class或接口 与 参数cls表示的类或接口相同，或者是参数cls表示的类或接口的父类，则返回true
	 * 
	 * isInstance(Object obj)obj是被测试的对象，如果obj是调用这个方法的class或接口 的实例，则返回true
	 * @param type
	 */
	
	private Class<?> baseType;
	
	public TypeCounter(Class<?> baseType){
		this.baseType=baseType;
	}
	
	public void count(Object obj){
		Class<?> type=obj.getClass();
		if(!baseType.isAssignableFrom(type)){
			throw new RuntimeException(obj+"Incorrect type:"+type+",should be type of subtype of"+baseType);
		}
		countClass(type);
	}
	
	private void countClass(Class<?> type){
		Integer quantity=get(type);
		put(type,quantity==null ? 1:quantity+1);
		Class<?> superClass=type.getSuperclass();
		if(null!=superClass && baseType.isAssignableFrom(superClass)){
			countClass(superClass);
		}
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder("{");
		for(Map.Entry<Class<?>, Integer> pair:entrySet()){
			sb.append(pair.getKey().getSimpleName());
			sb.append("=");
			sb.append(pair.getValue());
			sb.append(", ");
		}
		sb.delete(sb.length()-1,sb.length());
		sb.append("}");
		return sb.toString();
	}
}
