package th.part_18_IO.chapter_12_Serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

public class Worm implements Serializable{
	static String file = "C:\\Users\\Administrator\\Desktop\\Worm.txt";
	private static Random random=new Random(47);
	public Data[] data={new Data(random.nextInt()),new Data(random.nextInt()),new Data(random.nextInt())};
	
	private static int age=24;
	private transient String name="�Ҳ��ܱ����л���";
	
	private Worm next;
	private char c;
	public Worm(int i,char x){
		System.out.println("Worm Constructor:"+i+x);
		c=x;
		if(--i>0){
			next=new Worm(i,(char) (x+1));
		}
	}
	public Worm(){
		System.out.println("Default Constructor");
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder(":");
		sb.append(c);
		sb.append("(");
		for(Data d:data){
			sb.append(d);
		}
		sb.append(age);
		sb.append(")");
		if(next!=null)sb.append(next);
		
		return sb.toString();
	}
	/**
	 * ���������Ҫ���л�һ����������Ҫ����ĳЩOutputStream(��FileOutputStream��ByteArrayOutputStream��)��
	 * Ȼ����ЩOutputStream��װ��һ��ObjectOutputStream�С���ʱ��ֻ��Ҫ����writeObject()�����Ϳ��Խ��������л���
	 * �����䷢�͸�OutputStream����ס����������л��ǻ����ֽڵģ�����ʹ��Reader��Writer�Ȼ����ַ��Ĳ�νṹ����
	 * 
	 * �������еĹ��̣�����һ�����л�ԭ��Ϊһ�����󣩣�
	 * ��Ҫ��һ��InputStream(��FileInputstream��ByteArrayInputStream��)��װ��ObjectInputStream�ڣ�
	 * Ȼ�����readObject()����
	 * @param args
	 */
	/**
	 * �� "=="����equal�� or ��ǳ���ƻ�����ƣ� 
	 * �𰸣���ƣ������л���ԭ��Ķ����ַ��ԭ���ĵĵ�ַ��ͬ
	 * 
	 * ���л�ǰ�����ĵ�ַ��ͬ�ˣ�����������һ���ģ����Ҷ����а���������Ҳ��ͬ��
	 * ���仰˵��ͨ�����л�����,���ǿ���ʵ�ֶ��κο�Serializable����ġ���ȸ��ƣ�deep copy��"
	 * ��������ζ�����Ǹ��Ƶ������������������������ǻ������������á�����ͬһ���Ķ���
	 * ���ǵĵ�ַ����ͬ��˵��������ͬһ�����󣬵������������Ķ����ַȴ����ͬ��
	 * Ҳ��˵��ֻҪ���������л�����һ���У��Ϳ��Իָ���������д��ʱһ���Ķ�������
	 * ����ֻҪ��ͬһ���У�������ͬһ��
	 * 
	 * �л�����Ծ�̬�����������л������澲̬������״̬
	 */
	public static void main(String[] args) {
		Worm w=new Worm(3,'a');
		System.out.println("W="+w);
		try {
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject("Worm Storage\n");
			out.writeObject(w);
			out.close();
			ObjectInputStream in=new ObjectInputStream(new FileInputStream(file));
			String s=(String) in.readObject();
			Worm w2=(Worm) in.readObject();
			System.out.println("S="+s+"W2="+w2);
			/**
			 * ���л�����Ծ�̬�����������л������澲̬������״̬��
			 * ��̬��Ա�����༶��ģ����Բ������л���
			 * �� ���л����Ƕ����״̬�������״̬��
			 * ����Ĳ������л�����˼�������л���Ϣ�в����������̬��Ա��
			 * �����������static��֮���Ի������24����Ϊ��ֵ��JVM���ظ���ʱ�����ֵ
			 */
			age=1;//��̬�������¸�ֵ
			System.out.println("����:"+w2.age);
			System.out.println("����:"+w2.name);
			
			ByteArrayOutputStream bout=new ByteArrayOutputStream();
			ObjectOutputStream out2=new ObjectOutputStream(bout);
			out2.writeObject("Worm Storage\n");
			out2.writeObject(w);
			out2.flush();
			
			ObjectInputStream in2=new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
			String s2=(String) in2.readObject();
			Worm w3=(Worm) in2.readObject();
			System.out.println(s2+"W3="+w3);
			System.out.println("����2:"+w2.age);
			System.out.println("����2:"+w2.name);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
