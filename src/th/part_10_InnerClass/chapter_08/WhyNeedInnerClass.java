package th.part_10_InnerClass.chapter_08;
/**
 * 10.8 Ϊ����Ҫ�ڲ���
 * �ڲ������Χ��ʵ�ֽӿ�����Ч����һ���ġ�
 * �ڲ�����ӷ����Ч���ڲ�����ڲ���װ���Ӱ�ȫ
 * �ڲ���ӵ��һ��ָ����Χ������ã�����������Χ�����Ϣ���ڲ���Ҳ���Բ�����Χ��˽�г�Ա
 * 
 * @author ken
 * 2016-9-22 ����05:07:56
 */
public class WhyNeedInnerClass {
	interface A{}
	interface B{}
	
	class X implements A,B{}
	
	class Y implements A{
		B makeB(){
			return new B(){};
		}
	}
	
}
