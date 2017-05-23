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
	 * 2016-10-19 下午04:54:35
	 */
	public static void main(String[] args) {
		//下边界，包含T在内的任何T的子类
		List<? extends SuperClass> ecl=new ArrayList<SuperClass>();
		ecl=new ArrayList<ChildInterface>();
		ecl=new ArrayList<ChildClass>();
		
		
		//上边界，T在内的任何T的父类
		List<? super ChildInterface> esu=new ArrayList<ChildInterface>();
		esu=new ArrayList<Object>();
		esu=new ArrayList<SuperInterface>();
		esu.add(new Child());
	}

}
