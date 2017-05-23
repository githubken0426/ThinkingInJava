package th.part_17_DeepInCollection.chapter_02Fill._01Generator;

import TIJ4_code.net.mindview.util.Generator;


public class Government implements Generator<String> {
	String foundation[] = "this is the test !".split(" ");
	private int index = 0;

	@Override
	public String next() {
		//数组越界问题
		return foundation[index++];
	}
}
