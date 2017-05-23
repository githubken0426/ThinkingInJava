package th.part_11_collection.chapter_06Iterator._01listIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import th.part_11_collection.chapter_06Iterator.PetsA;

public class ListIteratorMain {
	/**
	 * ListIterator������
	 * 
	 * void add(E e): ��ָ����Ԫ�ز����б�����λ��Ϊ��������ǰλ��֮ǰ void set(E
	 * e)�����б��н�next()��previous()���ص����һ��Ԫ�ط��ص����һ��Ԫ�ظ���Ϊָ��Ԫ��e
	 * 
	 * boolean hasNext()������������б�ʱ������б���������滹��Ԫ�أ��򷵻� true�����򷵻�false boolean
	 * hasPrevious():�������������б��б������ǰ�滹��Ԫ�أ��򷵻� true�����򷵻�false
	 * 
	 * Object next()�������б���ListIteratorָ��λ�ú����Ԫ�� int
	 * nextIndex():�����б���ListIterator����λ�ú���Ԫ�ص�����
	 * 
	 * Object previous():�����б���ListIteratorָ��λ��ǰ���Ԫ�� int
	 * previousIndex()�������б���ListIterator����λ��ǰ��Ԫ�ص�����
	 * 
	 * void remove():���б���ɾ��next()��previous()���ص�Ԫ��
	 * ���е��ֿڣ���˼���ǶԵ�����ʹ��hasNext()����ʱ��ɾ��ListIteratorָ��λ�ú����Ԫ�أ�
	 * ���Ե�����ʹ��hasPrevious()����ʱ��ɾ��ListIteratorָ��λ��ǰ���Ԫ�أ�
	 * 
	 * 
	 * @param args
	 */

	/**
	 * 1.ʹ�÷�Χ��ͬ��Iterator����Ӧ�������еļ��ϣ�Set��List��Map����Щ���ϵ������͡�
	 * ��ListIteratorֻ������List���������͡�
	 * 
	 * 2.ListIterator��add������������List����Ӷ��󣬶�Iterator���ܡ�
	 * 
	 * 3.ListIterator��Iterator����hasNext()��next()����������ʵ��˳����������
	 * ����ListIterator��hasPrevious()��previous()����������ʵ������˳����ǰ�������� Iterator�����ԡ�
	 * 
	 * 4.ListIterator���Զ�λ��ǰ������λ�ã�nextIndex()��previousIndex()����ʵ�֡� Iteratorû�д˹��ܡ�
	 * 
	 * 5.����ʵ��ɾ������������ListIterator����ʵ�ֶ�����޸ģ�set()��������ʵ�֡� Iterator���ܱ����������޸ġ�
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
					if (hasNext)// Դ���пո�buf.append(", ");
						buf.append(",");
				}
				return buf.toString();
			}
		};
		PetsA[] pet = new PetsA[] { new PetsA(1, "�ϴ�", 23),
				new PetsA(2, "�϶�", 22), new PetsA(3, "����", 21),
				new PetsA(4, "����", 20) };
		Collections.addAll(list, pet);
		ListIterator<PetsA> listIter = list.listIterator();
		// ����Ԫ�أ����ϵ��µ�˳����ӵ�����ǰ��
		listIter.add(new PetsA(5, "����", 25));
		listIter.add(new PetsA(6, "����", 26));

		System.out.println(list.toString());

		while (listIter.hasNext()) {
			PetsA p = listIter.next();// ���ǵ��ô˷�������ѭ��
			System.out.println(p.getName() + ";�����±�:" + listIter.nextIndex()
					+ "��ǰһ���±꣺" + listIter.previousIndex());
			if (listIter.nextIndex() == 6) {
				listIter.set(new PetsA(5, "���ı��޸���", 20));
			}
		}
		// ����µ�Ԫ�غ󣬱������µ���listIterator(),������ʾ����ӵ�Ԫ��
		System.out.println("\n******��ʾ��Ӻ��Ԫ���б�******");
		listIter = list.listIterator();
		while (listIter.hasNext()) {
			PetsA p = listIter.next();
			System.out.println("����:" + p.getName() + ";�����±�:"
					+ listIter.nextIndex() + "��ǰһ���±꣺"
					+ listIter.previousIndex());
		}

		System.out.println("******�����ȡ������Ϣ******:");
		while (listIter.hasPrevious()) {
			PetsA p = listIter.previous();
			System.out.println("����:" + p.getName() + ";�����±�:"
					+ listIter.nextIndex() + "��ǰһ���±꣺"
					+ listIter.previousIndex());
		}
	}

}
