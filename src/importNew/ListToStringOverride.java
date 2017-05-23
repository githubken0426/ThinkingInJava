package importNew;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListToStringOverride {
	static List<String> list=new ArrayList<String>(){
		private static final long serialVersionUID = 1L;
		@Override
		public String toString(){
			StringBuffer sb=new StringBuffer();//���̰߳�ȫ
			Iterator<String> it=iterator();
			boolean hasNext=it.hasNext();
			while(hasNext){
				String val=it.next();
				sb.append(val);
				hasNext=it.hasNext();//�ٴε��ã�1��ֹ���󲻴���2��ֹ���õĶ���
				if(hasNext)
					sb.append(",");
			}
			return sb.toString();
		}
	};
	static List<String> list2=new ArrayList<String>(){
		private static final long serialVersionUID = 2L;
		@Override
		public String toString(){
			StringBuffer sb=new StringBuffer();
			Iterator<String> it=iterator();
			while(it.hasNext()){
				String val=it.next();
				sb.append(val+",");
			}
			return sb.toString();
		}
	};
	/**
	 * �������ӣ���˵��Դ�������
	 * @param args
	 * 2017-2-21 ����09:34:35
	 */
	public static void main(String[] args) {
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("a");
		System.out.println(list);
		list2.add("a");
		list2.add("a");
		list2.add("a");
		list2.add("a");
		System.out.println(list2);
	}
}
