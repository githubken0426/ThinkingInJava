package resourceCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import resourceCode.map.MyMap;

public class Test {
	public static void main(String[] args) {
		Collection<?> coll=new ArrayList<String>();
		Iterable<?> it=(Iterable) coll.iterator();
		List<String> list=new ArrayList<String>();
		ListIterator<?> listI= list.listIterator();
		
		Map<String,Object> map=new HashMap<String, Object>();
		ArrayList array=new ArrayList();
	}
	public Set<MyMap.Entry<String, Object>> entrySet() {
		return null;
	}
}
