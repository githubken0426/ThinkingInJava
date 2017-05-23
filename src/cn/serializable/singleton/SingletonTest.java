package cn.serializable.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SingletonTest {
	/**
	 * ͨ����Singleton�����л��뷴���л��õ��Ķ�����һ���µĶ�������ƻ���Singleton�ĵ�����
	 * ���л���ͨ����������޲����Ĺ��췽������һ���µĶ���
	private Object readOrdinaryObject(boolean unshared)
        throws IOException{
        //�˴�ʡ�Բ��ִ���
        Object obj;
        try {
            obj = desc.isInstantiable() ? desc.newInstance() : null;
        } catch (Exception ex) {
            throw (IOException) new InvalidClassException(
                desc.forClass().getName(),
                "unable to create instance").initCause(ex);
        }
        //�˴�ʡ�Բ��ִ���
        if (obj != null &&
            handles.lookupException(passHandle) == null &&
            desc.hasReadResolveMethod()){
            Object rep = desc.invokeReadResolve(obj);
            if (unshared && rep.getClass().isArray()) {
                rep = cloneArray(rep);
            }
            if (rep != obj) {
                handles.setObject(passHandle, obj = rep);
            }
        }
        return obj;
    }*/
	/** @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String file="C:\\Users\\Administrator\\Desktop\\singleton.txt";
		ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(file));
		os.writeObject(Singleton.getInstance());
		os.close();
		ObjectInputStream is=new ObjectInputStream(new FileInputStream(file));
		Singleton singleton = (Singleton) is.readObject();
		is.close();
		//false
		System.out.println(singleton==Singleton.getInstance());
	}
}
