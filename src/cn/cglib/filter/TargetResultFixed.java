package cn.cglib.filter;

import net.sf.cglib.proxy.FixedValue;

/**
 * ������������ֵ�����۱�������ķ�������ʲôֵ���ص����������ع̶�ֵ
 * 
 * @author ken
 * 2016-12-7 ����09:50:13
 */
public class TargetResultFixed implements FixedValue {
	/**
	 * MyProxyFilter�ж����ʹ��FixedValue�ص��ķ���ΪgetConcreteMethodFixedValue
	 * �÷�������ֵΪ����
	 */
	@Override
	public Object loadObject() throws Exception {
		System.out.print("�������:");
		Object obj = 888;
		return obj;
	}

}
