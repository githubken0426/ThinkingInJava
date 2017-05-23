package th.part_11_collection.chapter_07LinkedList;

import java.util.Arrays;
import java.util.LinkedList;
/**
 * ArrayList内部是通过一动态数据存储的。所以查找数据很快。根据INDEX，查数据效率高。数据存储在数组中。
	LinkedList内数据根本没有固定的容器存储。而是通过对象关联引用，一层一层深入下去的。
	简单的说，就是保存在一个对象的无限引用中，引用链有多深取决数据量的大小。 具体数据结构如下：
	Entry<E> {
		E element;
		Entry<E> previous;
		Entry<E> next;
	}
	所以无论是查找还是插入，删除，都要从第一个元数据开始找。这样效率自然就很低。
	有很多人说，LinkedList查找效率比ArrayList效率差。但批量添加或删除效率比ArrayList高。
	前者很好理解。后者我测试了，LinkedList怎么都效率不高。批量添加或删除效率也不比ArrayList高。
	大家有没有用过LinkedList，他究竟有什么好处。我看来除了数据结构设计的链表类，实际上很少用，不知道有什么用。 
	唯一发现有个用处，好象是在JDK里设计缓存策略时有用
 * @author ken
 * 2016-12-27 下午03:58:57
 */

public class LinkedListFeatures {
	public static void main(String[] args) {
		LinkedList<String> linkedList=new LinkedList<String>(Arrays.asList("元素_1","元素_2","元素_3"));
		System.out.println(linkedList);
		System.out.println("getFirst():"+linkedList.getFirst());
		/**
		 * 返回第一个元素，和getFirst()类似,元素为空时候抛出异常：NoSuchElementException
		 */
		System.out.println("element():"+linkedList.element());
		System.out.println("remove():"+linkedList.remove());
		//removeFirst()移出并返回列表的头部元素
		System.out.println("removeFirst():"+linkedList.removeFirst());
		//removeAll()移出所有数据返回true
//		System.out.println("removeAll():"+linkedList.removeAll(linkedList));
		/**
		 * 元素为空时，输出null不会抛出异常
		 * peek()不会删除当前元素，poll()删除当前元素
		 */
		System.out.println("peek:"+linkedList.peek());
		System.out.println("peek:"+linkedList);
		System.out.println("poll():"+linkedList.poll());
		System.out.println("poll():"+linkedList);
		
		
		/**
		 * offer(E e)将指定元素添加到此列表的末尾(最后一个元素)
		 * 等同addLast("bbb");
		 */
		linkedList.offer("abc");
		linkedList.addLast("bbb");
		System.out.println("After offer():"+linkedList);
		
		linkedList.set(linkedList.size()-1, "replace!");
		System.out.println(linkedList);
	}
}
