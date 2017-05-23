package th.part_11_collection.chapter_13ForeachAndIterator;

import java.util.Iterator;
/**
 * 11.13
 * ForeachºÍµü´úÆ÷
 * @author ken
 * 2016-12-29 ÏÂÎç02:03:27
 */
public class IterableInnerClass implements Iterable<String> {
	protected String words[]="This is Java EE".split(" ");
	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>(){
			private int index=0;
			@Override
			public boolean hasNext() {
				return index < words.length;
			}

			@Override
			public String next() {
				return words[index++];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] args) {
		for(String str:new IterableInnerClass()){
			System.out.println(str);
		}
	}
}
