package th.about;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CapacityTest {
	public static void main(String[] args) {
		Vector<String> v=new Vector<String>();
		List<String> l=new ArrayList<String>();
		
		System.out.println("¿©≥‰«∞£∫"+v.size());
		v.ensureCapacity(15);
		System.out.println("¿©≥‰∫Û"+v.size());
	}
}
