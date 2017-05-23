package cn.serializable.list;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * list�����л�
 * @author Administrator
 *
 */
public class ListSerializable {

	/**
	 * �����л������У���������л������ж�����writeObject �� readObject ������
	 * ���������ͼ���ö�������� writeObject �� readObject �����������û��Զ�������л��ͷ����л���
	   
	 * ���û�������ķ�������Ĭ�ϵ����� ObjectOutputStream �� defaultWriteObject ����
	 * �Լ� ObjectInputStream �� defaultReadObject ������
	 * �û��Զ���� writeObject �� readObject �������������û��������л��Ĺ��̣�
	 * ������������л��Ĺ����ж�̬�ı����л�����ֵ��
	 * @param args
	 */
	
	/**
	 * why transient 
	 * ArrayListʵ�����Ƕ�̬���飬ÿ���ڷ����Ժ��Զ������趨�ĳ���ֵ��
	 * ��������Զ�����������Ϊ100����ʵ��ֻ����һ��Ԫ�أ��Ǿͻ����л�99��nullԪ�ء�
	 * Ϊ�˱�֤�����л���ʱ�򲻻Ὣ��ô��nullͬʱ�������л���ArrayList��Ԫ����������Ϊtransient��
	 * 
	 * why writeObject and readObject
	 * ǰ��˵����Ϊ�˷�ֹһ�����������ն�������鱻���л���Ϊ���Ż��洢��
	 * ���ԣ�ArrayListʹ��transient������elementData��
	 * ���ǣ���Ϊһ�����ϣ������л������л����뱣֤���е�Ԫ�ؿ��Ա��־û�������
	 * ���ԣ�ͨ����дwriteObject �� readObject�����ķ�ʽ�����е�Ԫ�ر���������
	 * writeObject������elementData�����е�Ԫ�ر����ı��浽�������ObjectOutputStream���С�
	 * readObject��������������ObjectInputStream���ж������󲢱��渳ֵ��elementData������
	 * @param args
	 */
	public static void main(String[] args) {
		String path="C:\\Users\\Administrator\\Desktop\\list.txt";
		List<String> list=new ArrayList<String>();
		list.add("Hello");
		list.add("World!");
		System.out.println("List:"+list.toString());
		try {
			//д��
			ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream(path));
			output.writeObject(list);
			output.close();
			//��ȡ
			ObjectInputStream input =new ObjectInputStream(new FileInputStream(path));
		    @SuppressWarnings("unchecked")
			List<String> str=(List<String>) input.readObject();
			input.close();
			for (String s : str) {
				System.out.println("��ȡ��Ϣ:"+s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
