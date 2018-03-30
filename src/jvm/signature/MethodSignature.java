package jvm.signature;

/**
 * 方法签名
 * 
 * @author ken 2017-5-31 上午08:53:40
 */
public class MethodSignature {
	public void testVoid() {//testVoid(Ljava/lang/String;)V
	} 
	public void testVoid(String str) {//testVoid:(Ljava/lang/String;)V
	}
	
	//testObject(Ljava/lang/Object;)Ljava/lang/Object;
	public Object testObject(Object str) {
		return str;
	}
	//testObject(Ljava/lang/String;)Ljava/lang/Object;
	public Object testObject(String str) {
		return str;
	}
	
	//testInt()I
	public int testInt() {
		return 1;
	} 
	//testInt()(I)I
	public int testInt(int i) {
		return i;
	} 
	
	
	public float testFloat() {
		return 1.0f;
	}
	public float testFloat(float f) {
		return f;
	}
	
	
	public short testShort() {
		return 1;
	}
	public short testShort(short s) {
		return s;
	}
	
	
	public double testDouble() {
		return 1.02;
	}
	public double testDouble(double d) {
		return d;
	}
	
	
	public long testLong() {
		return 1l;
	}
	public long testLong(long l) {
		return l;
	}
	
	
	public boolean testBoolean() {
		return true;
	}
	public boolean testBoolean(boolean b) {
		return b;
	}
	
	
	public char testChar() {
		return 'a';
	}
	public char testChar(char c) {
		return c;
	}
	
	
	public byte testByte() {
		return 'a';
	}
	public byte testByte(byte b) {
		return b;
	}
	
	public static void main(String[] args) {
		MethodSignature sign=new MethodSignature();
		Object obj=sign.testObject((Object)"abc");
		System.out.println(obj);
	}
}
