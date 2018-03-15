package importNew.immutableObject;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 创建一个不可变对象 将类声明为final，所以它不能被继承 将所有的成员声明为私有的， 这样就不允许直接访问这些成员 对变量不要提供setter方法
 * 将所有可变的成员声明为final，这样只能对它们赋值一次 通过构造器初始化所有成员，进行深拷贝(deep copy)
 * 在getter方法中，不要直接返回对象本身，而是克隆对象，并返回对象的拷贝
 * 
 * @author Administrator 2016-3-17 下午02:39:25
 * 
 */
public final class ImmutableClass {
	private final int id;
	private final String name;
	private final HashMap<Object, Object> map;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	/**
	 * 可变对象的访问方法
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public HashMap<Object, Object> getMap() {
		// clone一个对象，不是当前对象的引用
		return (HashMap<Object, Object>) map.clone();
	}

	/**
	 * 深拷贝的构造
	 * 
	 * @param id
	 * @param name
	 * @param map
	 */

	public ImmutableClass(int id, String name, HashMap<Object, Object> map) {
		System.out.println("Deep Copy");
		this.name = name;
		this.id = id;
		HashMap<Object, Object> hm = new HashMap<Object, Object>();
		Iterator<Object> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			hm.put(key, map.get(key));
		}
		this.map = hm;
	}

	/**
	 * 实现浅拷贝(shallow copy)的构造器
	 * @param i
	 * @param n
	 * @param hm
	 */
	public ImmutableClass(int i, String n,HashMap<Object, Object> map,int flag) {
		System.out.println("Shallow Copy");
		this.id = i;
		this.name = n;
		this.map = map;//仅仅是创建map的引用
	}

	public static void main(String[] args) {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("1", "first");
		map.put("2", "second");
		
		String str = "original";
		int i = 10;
		ImmutableClass immutable = new ImmutableClass(i, str, map);
		System.out.println(str == immutable.getName());
		System.out.println("HashMap的克隆对象：" + (map == immutable.getMap()));
		
		i = 20;
		str = "change";
		map.put("3", "third");
		System.out.println("id after change :" + immutable.getId());
		System.out.println("name after change:" + immutable.getName());
		System.out.println("map after  change:" + immutable.getMap());

		HashMap<Object,Object> map2 = immutable.getMap();
		map2.put("4", "fourth");
		System.out.println(immutable.getMap());
	}
}
