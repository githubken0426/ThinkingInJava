package cn.cglib.filter;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

/**
 * cglib������
 * @author Administrator
 * 2016-1-5 ����01:29:10
 *
 */
public class MyProxyFilter implements CallbackFilter {
	/**
	 * �ص����˷���
	 * ���ص�ֵΪ���֣�������Callback�����е�����λ��
	 * ���ص�ֵ��������ĸ��������ڻص�����Callback[]�е�λ������
	 * 0[��Ӧproxy]/1[��ӦNoOp.INSTANCE]/2[��Ӧnew TargetResultFixed()]
	 */
	@Override
	public int accept(Method arg0) {
		if("delete".equalsIgnoreCase(arg0.getName()))
			return 0;
		if("update".equalsIgnoreCase(arg0.getName())){  
            System.out.println("Filter update ==2");  
            return 2;  
        } 
		return 1;
	}

}
