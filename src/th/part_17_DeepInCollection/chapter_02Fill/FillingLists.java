package th.part_17_DeepInCollection.chapter_02Fill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FillingLists {
	public static void main(String[] args) {
		/**
		 * nCopies(n,Object)����n��Object
		 */
		List<StringAddress> list=new ArrayList<StringAddress>
			(Collections.nCopies(3, new StringAddress("hello")));
		System.out.println(list);
		/**
		 * fill()�滻list�е�Ԫ�أ���ֻ���滻���е�Ԫ�أ�����������µ�Ԫ��
		 */
		Collections.fill(list, new StringAddress("word"));
		System.out.println(list);
	}
}
