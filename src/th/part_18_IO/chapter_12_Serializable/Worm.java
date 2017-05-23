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
	private transient String name="我不能被序列化！";
	
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
	 * 如果我们想要序列化一个对象，首先要创建某些OutputStream(如FileOutputStream、ByteArrayOutputStream等)，
	 * 然后将这些OutputStream封装在一个ObjectOutputStream中。这时候，只需要调用writeObject()方法就可以将对象序列化，
	 * 并将其发送给OutputStream（记住：对象的序列化是基于字节的，不能使用Reader和Writer等基于字符的层次结构）。
	 * 
	 * 而反序列的过程（即将一个序列还原成为一个对象），
	 * 需要将一个InputStream(如FileInputstream、ByteArrayInputStream等)封装在ObjectInputStream内，
	 * 然后调用readObject()即可
	 * @param args
	 */
	/**
	 * 是 "=="还是equal？ or 是浅复制还是深复制？ 
	 * 答案：深复制，反序列化还原后的对象地址与原来的的地址不同
	 * 
	 * 序列化前后对象的地址不同了，但是内容是一样的，而且对象中包含的引用也相同。
	 * 换句话说，通过序列化操作,我们可以实现对任何可Serializable对象的”深度复制（deep copy）"
	 * ——这意味着我们复制的是整个对象网，而不仅仅是基本对象及其引用。对于同一流的对象，
	 * 他们的地址是相同，说明他们是同一个对象，但是与其他流的对象地址却不相同。
	 * 也就说，只要将对象序列化到单一流中，就可以恢复出与我们写出时一样的对象网，
	 * 而且只要在同一流中，对象都是同一个
	 * 
	 * 列化会忽略静态变量，即序列化不保存静态变量的状态
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
			 * 序列化会忽略静态变量，即序列化不保存静态变量的状态。
			 * 静态成员属于类级别的，所以不能序列化。
			 * 即 序列化的是对象的状态不是类的状态。
			 * 这里的不能序列化的意思，是序列化信息中不包含这个静态成员域。
			 * 最上面添加了static后之所以还是输出24是因为该值是JVM加载该类时分配的值
			 */
			age=1;//静态变量重新赋值
			System.out.println("年龄:"+w2.age);
			System.out.println("姓名:"+w2.name);
			
			ByteArrayOutputStream bout=new ByteArrayOutputStream();
			ObjectOutputStream out2=new ObjectOutputStream(bout);
			out2.writeObject("Worm Storage\n");
			out2.writeObject(w);
			out2.flush();
			
			ObjectInputStream in2=new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
			String s2=(String) in2.readObject();
			Worm w3=(Worm) in2.readObject();
			System.out.println(s2+"W3="+w3);
			System.out.println("年龄2:"+w2.age);
			System.out.println("姓名2:"+w2.name);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
