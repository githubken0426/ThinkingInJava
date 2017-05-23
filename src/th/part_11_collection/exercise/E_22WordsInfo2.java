package th.part_11_collection.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import TIJ4_code.net.mindview.util.TextFile;

public class E_22WordsInfo2 {
	static class WordCounter{
		private final String word;
		private int frequency;
		
		WordCounter(String word){
			this.word=word;
			frequency=1;
		}
		
		void incFrequency(){
			++frequency;
		}
		
		public String getWord() {
			return word;
		}

		public int getFrequency() {
			return frequency;
		}
		
		public boolean equals(Object obj){
			return obj instanceof WordCounter && word.equals(((WordCounter)obj).word);
		}
		
		public int hashCode(){
			return word.hashCode();
		}
		
		public static final Comparator<WordCounter> CASE_INSENSITIVE_RODER =
			new Comparator<WordCounter>(){
				@Override
				public int compare(WordCounter o1, WordCounter o2) {
					return o1.word.compareToIgnoreCase(o2.word);
				}
		};
		
		public static void updateState(Iterator<WordCounter> it,WordCounter wc){
			while(it.hasNext()){
				WordCounter currentWc=it.next();
				if(currentWc.equals(wc)){
					wc.incFrequency();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String path="src\\th\\part_11_collection\\exercise\\E_21WordsInfo.java";
		Set<WordCounter> set=new HashSet<WordCounter>();
		for(String str:new TextFile(path,"\\W+")){
			WordCounter wc=new WordCounter(str);
			if(set.contains(wc))
				WordCounter.updateState(set.iterator(), wc);
			else
				set.add(wc);
		}
		List<WordCounter> list= new ArrayList<WordCounter>(set);
		Collections.sort(list,WordCounter.CASE_INSENSITIVE_RODER);
		for (WordCounter wordCounter : list) {
			System.out.println(wordCounter.getWord()+"==>"+wordCounter.getFrequency());
		}
	}
}
