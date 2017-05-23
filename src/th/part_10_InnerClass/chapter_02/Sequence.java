package th.part_10_InnerClass.chapter_02;

public class Sequence {
	private Object[] items;
	private int next=0;
	public Sequence(int size){
		items=new Object[size];
	}
	
	public void add(Object obj){
		if(next<items.length)
			items[next++]=obj;
	}
	/**
	 * Selector实现类
	 * @author Administrator
	 *
	 * 2016-9-19 下午04:41:45
	 */
	private class SequenceSelector implements Selector{
		private int i=0;
		@Override
		public Object current() {
			return items[i];
		}

		@Override
		public boolean end() {
			return i==items.length;
		}

		@Override
		public void next() {
			if(i<items.length)
				i++;
		}
	}
	/**
	 * 获取Selector对象
	 * @return
	 */
	public Selector selector(){
		return new SequenceSelector();
	}
	
	public static void main(String[] args) {
		Sequence seq=new Sequence(10);
		for(int i=0;i<10;i++){
			seq.add(i);
		}
		Selector selector=seq.selector();
		while(!selector.end()){
			System.out.print(selector.current()+" ");
			selector.next();
		}
	}
}
