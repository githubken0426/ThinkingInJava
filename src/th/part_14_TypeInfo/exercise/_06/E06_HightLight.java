package th.part_14_TypeInfo.exercise._06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E06_HightLight {

	public static void main(String[] args) {
		System.out.println("1:++++++++++++++++++++++++++++++++++++++++++++++++");
		List<HShap> list=Arrays.asList(new HCircle(),new HSquaer());
		HShap.hightLight1(HCircle.class);
		HShap.hightLight2(HCircle.class);
		
		for (HShap hShap : list) {
			hShap.draw();
		}
		System.out.println("2:++++++++++++++++++++++++++++++++++++++++++++++++");
		HShap.hightLight1(HShap.class);
		HShap.hightLight2(HShap.class);
		
		for (HShap hShap : list) {
			hShap.draw();
		}
		
		System.out.println("3:++++++++++++++++++++++++++++++++++++++++++++++++");
		HShap.clearnHightLight1(ArrayList.class);
		HShap.clearnHightLight2(ArrayList.class);
		
		for (HShap hShap : list) {
			hShap.draw();
		}
	}
}
