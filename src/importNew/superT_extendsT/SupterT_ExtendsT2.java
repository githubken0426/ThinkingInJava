package importNew.superT_extendsT;

import java.util.ArrayList;
import java.util.List;

import importNew.superT_extendsT.cl.Child;
import importNew.superT_extendsT.cl.ChildClass;
import importNew.superT_extendsT.cl.ChildInterface;
import importNew.superT_extendsT.cl.SuperClass;
import importNew.superT_extendsT.cl.SuperInterface;

public class SupterT_ExtendsT2 {

	/**
	 * @param args
	 * 2016-10-19 ����04:54:35
	 */
	public static void main(String[] args) {
		//�±߽磬����T���ڵ��κ�T������
		List<? extends SuperClass> ecl=new ArrayList<SuperClass>();
		ecl=new ArrayList<ChildInterface>();
		ecl=new ArrayList<ChildClass>();
		
		
		//�ϱ߽磬T���ڵ��κ�T�ĸ���
		List<? super ChildInterface> esu=new ArrayList<ChildInterface>();
		esu=new ArrayList<Object>();
		esu=new ArrayList<SuperInterface>();
		esu.add(new Child());
	}

}
