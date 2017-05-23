package cn.serializable.transientDemo1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public class ClassLib implements Serializable {

	/**
	 * 我们都知道一个对象只要实现了Serializable接口， 这个对象就可以被序列化，java的这种序列化模式为开发者提供了很多便利，
	 * 我们可以不必关系具体序列化的过程，只要这个类实现了Serializable接口， 这个类的所有属性和方法都会自动序列化。
	 * 然而在实际开发过程中，我们常常会遇到这样的问题，这个类的有些属性需要序列化， 而其他属性不需要被序列化，这时候就需要transient关键字
	 */
	private static final long serialVersionUID = 1L;
	private transient InputStream is;
	private int majorVer;
	private int minorVer;

	public ClassLib(InputStream is) throws IOException {
		System.out.println("ClassLib(InputStream) called");
		this.is = is;
		DataInputStream dis;
		if (is instanceof DataInputStream)
			dis = (DataInputStream) is;
		else
			dis = new DataInputStream(is);
		if (dis.readInt() != 0xcafebabe)
			throw new IOException("not a .class file");
		minorVer = dis.readShort();
		majorVer = dis.readShort();
	}

	public int getMajorVer() {
		return majorVer;
	}

	public int getMinorVer() {
		return minorVer;
	}

	public void showIS() {
		System.out.println(is);
	}
}
