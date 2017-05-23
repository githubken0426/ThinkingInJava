package th.part_11_collection.chapter_13ForeachAndIterator.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import th.part_11_collection.chapter_13ForeachAndIterator.IterableInnerClass;

public class MultiIterableClass extends IterableInnerClass {
	
	final static String [] words="And this is how the Erath to be banan-shapped".split("");
	
	public Iterable<String> reversed(String [] str){
		return new Iterable<String>(){
			@Override
			public Iterator<String> iterator() {
				return new Iterator<String>(){
					
					int current=words.length-1;
					
					@Override
					public boolean hasNext() {
						return current>0;
					}

					@Override
					public String next() {
						return words[current--];
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
	
	public Iterable<String> randomized(){
		return new Iterable<String>(){
			@Override
			public Iterator<String> iterator() {
				List<String> list=new ArrayList<String>(Arrays.asList(words));
				/**
				 * shuffle()�����������򣬵��Ǵ��ҵ���list��һ������
				 * ����Ӱ��ԭ������
				 */
				Collections.shuffle(list,new Random(47));
				return list.iterator();
			}
		};
	}
	public static void main(String args[]) {
		MultiIterableClass mc =new MultiIterableClass();
		System.out.println("�������˳���:");
		for (String s : mc.randomized()) {
			System.out.print(s);
		}
		System.out.println();
		System.out.println("���鷴ת��:");
		for (String s : mc.reversed(words)) {
			System.out.print(s);
		}
		
		System.out.println();
		System.out.println(Integer.decode("20"));
		
	}
}
