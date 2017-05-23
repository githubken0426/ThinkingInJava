package th.part_11_collection.chapter_06Iterator._01listIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import th.part_11_collection.chapter_06Iterator.PetsA;

public class ListIteratorMain {
	/**
	 * ListIterator方法：
	 * 
	 * void add(E e): 将指定的元素插入列表，插入位置为迭代器当前位置之前 void set(E
	 * e)：从列表中将next()或previous()返回的最后一个元素返回的最后一个元素更改为指定元素e
	 * 
	 * boolean hasNext()：以正向遍历列表时，如果列表迭代器后面还有元素，则返回 true，否则返回false boolean
	 * hasPrevious():如果以逆向遍历列表，列表迭代器前面还有元素，则返回 true，否则返回false
	 * 
	 * Object next()：返回列表中ListIterator指向位置后面的元素 int
	 * nextIndex():返回列表中ListIterator所需位置后面元素的索引
	 * 
	 * Object previous():返回列表中ListIterator指向位置前面的元素 int
	 * previousIndex()：返回列表中ListIterator所需位置前面元素的索引
	 * 
	 * void remove():从列表中删除next()或previous()返回的元素
	 * （有点拗口，意思就是对迭代器使用hasNext()方法时，删除ListIterator指向位置后面的元素；
	 * 当对迭代器使用hasPrevious()方法时，删除ListIterator指向位置前面的元素）
	 * 
	 * 
	 * @param args
	 */

	/**
	 * 1.使用范围不同，Iterator可以应用于所有的集合，Set、List和Map和这些集合的子类型。
	 * 而ListIterator只能用于List及其子类型。
	 * 
	 * 2.ListIterator有add方法，可以向List中添加对象，而Iterator不能。
	 * 
	 * 3.ListIterator和Iterator都有hasNext()和next()方法，可以实现顺序向后遍历，
	 * 但是ListIterator有hasPrevious()和previous()方法，可以实现逆向（顺序向前）遍历。 Iterator不可以。
	 * 
	 * 4.ListIterator可以定位当前索引的位置，nextIndex()和previousIndex()可以实现。 Iterator没有此功能。
	 * 
	 * 5.都可实现删除操作，但是ListIterator可以实现对象的修改，set()方法可以实现。 Iterator仅能遍历，不能修改。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<PetsA> list = new ArrayList<PetsA>() {
			@Override
			public String toString() {
				StringBuffer buf = new StringBuffer();
				Iterator<PetsA> pets = iterator();
				boolean hasNext = pets.hasNext();
				while (hasNext) {
					PetsA o = pets.next();
					buf.append(o.getName());
					hasNext = pets.hasNext();
					if (hasNext)// 源码有空格，buf.append(", ");
						buf.append(",");
				}
				return buf.toString();
			}
		};
		PetsA[] pet = new PetsA[] { new PetsA(1, "老大", 23),
				new PetsA(2, "老二", 22), new PetsA(3, "老三", 21),
				new PetsA(4, "老四", 20) };
		Collections.addAll(list, pet);
		ListIterator<PetsA> listIter = list.listIterator();
		// 新增元素，从上到下的顺序，添加到集合前面
		listIter.add(new PetsA(5, "老五", 25));
		listIter.add(new PetsA(6, "老六", 26));

		System.out.println(list.toString());

		while (listIter.hasNext()) {
			PetsA p = listIter.next();// 忘记调用此方法。死循环
			System.out.println(p.getName() + ";正向下标:" + listIter.nextIndex()
					+ "，前一个下标：" + listIter.previousIndex());
			if (listIter.nextIndex() == 6) {
				listIter.set(new PetsA(5, "老四被修改了", 20));
			}
		}
		// 添加新的元素后，必须重新调用listIterator(),才能显示出添加的元素
		System.out.println("\n******显示添加后的元素列表******");
		listIter = list.listIterator();
		while (listIter.hasNext()) {
			PetsA p = listIter.next();
			System.out.println("姓名:" + p.getName() + ";正向下标:"
					+ listIter.nextIndex() + "，前一个下标："
					+ listIter.previousIndex());
		}

		System.out.println("******逆向读取集合信息******:");
		while (listIter.hasPrevious()) {
			PetsA p = listIter.previous();
			System.out.println("姓名:" + p.getName() + ";正向下标:"
					+ listIter.nextIndex() + "，前一个下标："
					+ listIter.previousIndex());
		}
	}

}
