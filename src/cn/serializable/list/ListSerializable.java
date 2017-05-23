package cn.serializable.list;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * list的序列化
 * @author Administrator
 *
 */
public class ListSerializable {

	/**
	 * 在序列化过程中，如果被序列化的类中定义了writeObject 和 readObject 方法，
	 * 虚拟机会试图调用对象类里的 writeObject 和 readObject 方法，进行用户自定义的序列化和反序列化。
	   
	 * 如果没有这样的方法，则默认调用是 ObjectOutputStream 的 defaultWriteObject 方法
	 * 以及 ObjectInputStream 的 defaultReadObject 方法。
	 * 用户自定义的 writeObject 和 readObject 方法可以允许用户控制序列化的过程，
	 * 比如可以在序列化的过程中动态改变序列化的数值。
	 * @param args
	 */
	
	/**
	 * why transient 
	 * ArrayList实际上是动态数组，每次在放满以后自动增长设定的长度值，
	 * 如果数组自动增长长度设为100，而实际只放了一个元素，那就会序列化99个null元素。
	 * 为了保证在序列化的时候不会将这么多null同时进行序列化，ArrayList把元素数组设置为transient。
	 * 
	 * why writeObject and readObject
	 * 前面说过，为了防止一个包含大量空对象的数组被序列化，为了优化存储，
	 * 所以，ArrayList使用transient来声明elementData。
	 * 但是，作为一个集合，在序列化过程中还必须保证其中的元素可以被持久化下来，
	 * 所以，通过重写writeObject 和 readObject方法的方式把其中的元素保留下来。
	 * writeObject方法把elementData数组中的元素遍历的保存到输出流（ObjectOutputStream）中。
	 * readObject方法从输入流（ObjectInputStream）中读出对象并保存赋值到elementData数组中
	 * @param args
	 */
	public static void main(String[] args) {
		String path="C:\\Users\\Administrator\\Desktop\\list.txt";
		List<String> list=new ArrayList<String>();
		list.add("Hello");
		list.add("World!");
		System.out.println("List:"+list.toString());
		try {
			//写入
			ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream(path));
			output.writeObject(list);
			output.close();
			//读取
			ObjectInputStream input =new ObjectInputStream(new FileInputStream(path));
		    @SuppressWarnings("unchecked")
			List<String> str=(List<String>) input.readObject();
			input.close();
			for (String s : str) {
				System.out.println("读取信息:"+s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
