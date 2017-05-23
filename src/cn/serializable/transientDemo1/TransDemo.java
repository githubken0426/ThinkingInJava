package cn.serializable.transientDemo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *  jdk1.7 try-with-resources 锟斤拷洌拷远锟斤拷锟皆达拷头锟�
 *  只锟斤拷实锟斤拷锟斤拷java.lang.AutoCloseable锟接口ｏ拷锟斤拷锟斤拷java.io.Closable
 *  锟斤拷实锟斤拷锟较硷拷锟斤拷锟斤拷java.lang.AutoCloseable锟斤拷锟接口的讹拷锟襟，才伙拷锟皆讹拷锟斤拷锟斤拷锟斤拷close()锟斤拷锟斤拷
 * @author Administrator
 * 2015锟斤拷11锟斤拷6锟斤拷
 */
public class TransDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException {
//		  if (args.length != 1) {
//	            System.err.println("usage: java TransDemo classfile");
//	            return;
//	        }
	        ClassLib cl = new ClassLib(new FileInputStream(args[0]));
	        System.out.printf("Minor version number: %d%n", cl.getMinorVer());
	        System.out.printf("Major version number: %d%n", cl.getMajorVer());
	        cl.showIS();
	 
//	        try (FileOutputStream fos = new FileOutputStream("x.ser");
//	                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//	            oos.writeObject(cl);
//	        }
//	        cl = null;
//	        try(FileInputStream fis = new FileInputStream("x.ser");
//	                ObjectInputStream ois = new ObjectInputStream(fis)) {
//	            System.out.println();
//	            cl = (ClassLib) ois.readObject();
//	            System.out.printf("Minor version number: %d%n", cl.getMinorVer());
//	            System.out.printf("Major version number: %d%n", cl.getMajorVer());
//	            cl.showIS();
//	        } catch (ClassNotFoundException cnfe) {
//	            System.err.println(cnfe.getMessage());
//	        }
//	        
//	        try {
//				System.out.println("test");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
	}

}
