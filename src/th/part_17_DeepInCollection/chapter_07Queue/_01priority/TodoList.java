package th.part_17_DeepInCollection.chapter_07Queue._01priority;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PriorityQueue;

public class TodoList extends PriorityQueue<TodoList.TodoItem> {
	private static final long serialVersionUID = 1L;

	static class TodoItem implements Comparable<TodoItem>{
		private char primary;
		private int secondary;
		private String item;
		public TodoItem(char primary,int secondary,String item){
			this.primary=primary;
			this.secondary=secondary;
			this.item=item;
		}
		@Override
		public int compareTo(TodoItem arg) {
			if(primary>arg.primary)
				return +1;
			if(primary==arg.primary){
				if(secondary>arg.secondary)
					return +1;
				else if(secondary==arg.secondary)
					return 0;
			}
			return -1;
		}
		
		public String toString(){
			return Character.toString(primary)+secondary+","+item;
		}
	}
	
	public void add(char primary,int secondary,String item){
		super.add(new TodoItem(primary, secondary, item));
	}
	
	public static void main(String[] args) {
		TodoList to=new TodoList();
		to.add('c',4,"Empty trash");
		to.add('b',4,"Empty trash");
		to.add('a',4,"A4");
		to.add('a',1,"A1");
		while(!to.isEmpty()){
			System.out.println(to.remove());
		}
		
		DateFormat df=new SimpleDateFormat("dd/MM/yy");
		String df2=DateFormat.getDateInstance().format(new Date());
		System.out.println(df2);
	}
}
