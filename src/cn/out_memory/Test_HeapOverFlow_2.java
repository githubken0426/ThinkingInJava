package cn.out_memory;

import java.util.ArrayList;
import java.util.List;
/**
 * args -verbose:gc -Xmx50m -Xms50m
 * ���������洢����ģ���Ȼ����һ�������ڶ���������ݼ����ķ�չ����
 * ��ô���������ˣ�һ���ǲ��ܱ�ɱ���Ķ���̫���ˡ�
 * ģ�� Heap �ڴ������ֻҪ���ϴ������󲢱��������ô��ڼ��ɡ�
 * @author ken
 * 2016-12-9 ����11:05:54
 */
public class Test_HeapOverFlow_2 {
	public static class HeapObject{
		
	}
	public static void main(String[] args) {
		List<HeapObject> list=new ArrayList<HeapObject>();
		while(true){
			list.add(new HeapObject());
		}
	}
}
