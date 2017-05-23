package th.part_15_Generic.chapter_04_GenericMethod._06;

import java.util.EnumSet;
import java.util.Set;

import th.util.CommonSets;
import th.util.WaterColors;

public class WaterColorSets {
	
	public static void main(String[] args) {
		Set<WaterColors> set1=EnumSet.range(WaterColors.ZINC,WaterColors.YELLOW);
		Set<WaterColors> set2=EnumSet.range(WaterColors.RED,WaterColors.BLUE);
		System.out.println("set1:"+set1);
		System.out.println("set2:"+set2);
		//虽然合并了两个参数，但是set是无序不可重复的。
		System.out.println("union(set1, set2):"+CommonSets.union(set1, set2));
		
		System.out.println("interSelection(set1, set2):"+CommonSets.interSelection(set1, set2));
		
		System.out.println("dfference(set1, set2):"+CommonSets.dfference(set1, set2));
		System.out.println("complement(set1, set2):"+CommonSets.complement(set1, set2));
	}
}
