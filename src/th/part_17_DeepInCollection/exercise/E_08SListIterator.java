package th.part_17_DeepInCollection.exercise;

import java.util.NoSuchElementException;



public class E_08SListIterator {
	
	public interface SListIterator<T>{
		boolean hasNext();
		void add(T t);
		void remove();
		T next();
	}
	
	static class SList<T>{
		private final Link<T> header=new Link<T>(null,null);
		SList(){
			header.next=header;
		}
		
		public String toString(){
			StringBuffer sb=new StringBuffer();
			sb.append("{");
			for(SListIterator<T> it=iterator();it.hasNext();){
				T element=it.next();
				sb.append(element==this?"this Slist":String.valueOf(element));
				if(it.hasNext())
					sb.append(",");
			}
			sb.append("}");
			return sb.toString();
		}
		
		/**
		 * 使用匿名类实现
		 * @return
		 */
		public SListIterator<T> iterator(){
			return new SListIterator<T>(){
				private Link<T> lastReturned=header;
				private Link<T> next;
				
				{
					next=header.next;
				}
				@Override
				public void add(T t) {
					lastReturned=header;
					Link<T> newLink=new Link<T>(t,next);
					if(header.next==next)
						header.next=newLink;
					else{
						for(Link<T> curr=header;;curr=curr.next)
							if(curr.next==next){
								curr.next=newLink;
								break;
							}
					}
				}

				@Override
				public boolean hasNext() {
					return next!=header;
				}

				@Override
				public T next() {
					if(next==header)
						throw new NoSuchElementException();
					lastReturned=next;
					next=next.next;
					return lastReturned.element;
				}

				@Override
				public void remove() {
					if(next==header)
						throw new IllegalStateException();
					for(Link<T> curr=header;;curr=curr.next){
						if(curr.next==lastReturned){
							curr.next=lastReturned.next;
							break;
						}
					}
					lastReturned=header;
				}
			};
		}
		
		private class Link<T>{
			T element;
			Link<T> next;
			
			Link(T element,Link<T> next){
				this.element=element;
				this.next=next;
			}
		}
		
		@Deprecated
		private class SListIteratorImpl implements SListIterator<T>{
			
			private Link<T> lastReturned=header;
			private Link<T> next;
			
			SListIteratorImpl(){
				next=header.next;
			}
			
			@Override
			public void add(T t) {
				lastReturned=header;
				Link<T> newLink=new Link<T>(t,next);
				if(header.next==next)
					header.next=newLink;
				else{
					for(Link<T> curr=header;;curr=curr.next)
						if(curr.next==next){
							curr.next=newLink;
							break;
						}
				}
			}

			@Override
			public boolean hasNext() {
				return next!=header;
			}

			@Override
			public void remove() {
				if(next==header)
					throw new IllegalStateException();
				for(Link<T> curr=header;;curr=curr.next){
					if(curr.next==lastReturned){
						curr.next=lastReturned.next;
						break;
					}
				}
				lastReturned=header;
			}

			@Override
			public T next() {
				if(next==header)
					throw new NoSuchElementException();
				lastReturned=next;
				next=next.next;
				return lastReturned.element;
			}
		}
	}
	
	public static void main(String[] args) {
		SList<String> list=new SList<String>();
		System.out.println(list);
		
		SListIterator<String> it=list.iterator();
		it.add("one");
		it.add("two");
		System.out.println(it.hasNext());
		System.out.println(list);
	}
}
