package cn.out_memory;

import java.util.ArrayList;
import java.util.List;

/**
 * ���г������ڴ����
 * 
 * ������ʱ�������������Ϳ���ʵ���� Method Area �����Ŀ�ġ�
 * �����ǳ��������� String ��� intern ���������ϵز����µĳ�����
 * @author ken
 * 2016-12-9 ����01:27:24
 */
public class Test_RuntimePool_4 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		int i=0;
		while(true){
			list.add(String.valueOf(i++).intern());
		}
	}
}
