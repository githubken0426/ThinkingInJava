package th.part_17_DeepInCollection.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class E_03FillCountries {
	public static final String [] DATA ={"China","Algeria","Angola"};
	
	public static void main(String[] args) {
		Set<String> set= new HashSet<String>();
		Collections.addAll(set, DATA);
		System.out.println(set);
		
		Set<String> set2= new LinkedHashSet<String>(Arrays.asList(DATA));
		System.out.println(set2);
		
		Set<String> set3= new TreeSet<String>(Arrays.asList(DATA));
		System.out.println(set3);
	}
}
