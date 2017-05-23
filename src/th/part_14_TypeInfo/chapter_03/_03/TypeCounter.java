package th.part_14_TypeInfo.chapter_03._03;

import java.util.HashMap;
import java.util.Map;

/**
 * �ݹ����
 * @author Administrator
 * 2015��9��8��
 */
public class TypeCounter extends HashMap<Class<?>,Integer> {
	/**
	 * instanceof ���ʵ��
	 * 
	 * isAssignableFrom(Class<?> cls)У��һ�����Ƿ�ʵ��ָ���ĸ���,���class����.
	 * ����������������class��ӿ� �� ����cls��ʾ�����ӿ���ͬ�������ǲ���cls��ʾ�����ӿڵĸ��࣬�򷵻�true
	 * 
	 * isInstance(Object obj)obj�Ǳ����ԵĶ������obj�ǵ������������class��ӿ� ��ʵ�����򷵻�true
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
