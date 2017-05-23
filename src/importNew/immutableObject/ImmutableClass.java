package importNew.immutableObject;

import java.util.HashMap;
import java.util.Iterator;

/**
 * ����һ�����ɱ���� ��������Ϊfinal�����������ܱ��̳� �����еĳ�Ա����Ϊ˽�еģ�
 * �����Ͳ�����ֱ�ӷ�����Щ��Ա �Ա�����Ҫ�ṩsetter����
 * �����пɱ�ĳ�Ա����Ϊfinal������ֻ�ܶ����Ǹ�ֵһ�� ͨ����������ʼ�����г�Ա���������(deep copy)
 * ��getter�����У���Ҫֱ�ӷ��ض��������ǿ�¡���󣬲����ض���Ŀ���
 * 
 * @author Administrator 2016-3-17 ����02:39:25
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
	 * �ɱ����ķ��ʷ���
	 * 
	 * @return
	 */
	public HashMap<Object, Object> getMap() {
		// cloneһ�����󣬲��ǵ�ǰ���������
		return (HashMap<Object, Object>) map.clone();
	}

	/**
	 * ����Ĺ���
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
		String key;
		Iterator<Object> it = map.keySet().iterator();
		while (it.hasNext()) {
			key = (String) it.next();
			hm.put(key, map.get(key));
		}
		this.map = hm;
	}

	/**
	 * ʵ��ǳ����(shallow copy)�Ĺ�����
	 * 
	 * @param i
	 * @param n
	 * @param hm
	 */

	// public ImmutableClass(int i, String n, HashMap hm) {
	// System.out.println("Shallow Copy");
	// this.id = i;
	// this.name = n;
	// this.map = hm;
	// }

	public static void main(String[] args) {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("1", "first");
		map.put("2", "second");
		String str = "original";
		int i = 10;
		ImmutableClass immutable = new ImmutableClass(i, str, map);

		System.out.println(str == immutable.getName());
		System.out.println("HashMap�Ŀ�¡����" + (map == immutable.getMap()));

		i = 20;
		str = "change";
		map.put("3", "third");

		System.out.println("id after change :" + immutable.getId());
		System.out.println("name after change:" + immutable.getName());
		System.out.println("map after  change:" + immutable.getMap());

		HashMap map2 = immutable.getMap();
		map2.put("4", "fourth");
		System.out.println(immutable.getMap());
	}
}
