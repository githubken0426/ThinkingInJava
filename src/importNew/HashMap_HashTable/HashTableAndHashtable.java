package importNew.HashMap_HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * HashMap��Hashtable����
 * 
 * 1��HashMap����synchronized�ģ��̲߳���ȫ��
 * 	  Hashtable��synchronized�ģ��̰߳�ȫ��,����߳̿��Թ���һ��Hashtable��
 * 
 * 2: HashMap���Դ�null��key��value.Hashtable�����ԡ�
 * 
 * 3����һ��������HashMap�ĵ�����(Iterator)��fail-fast����������Hashtable��Enumerator����������fail-fast�ġ�
 *    ���Ե��������̸߳ı���HashMap�Ľṹ�����ӻ����Ƴ�Ԫ�أ��������׳�ConcurrentModificationException��
 *    �������������remove()�����Ƴ�Ԫ���򲻻��׳�ConcurrentModificationException�쳣��
 *    ���Ⲣ����һ��һ����������Ϊ��Ҫ��JVM������ͬ��Ҳ��Enumeration��Iterator������
 *    
 *  4������Hashtable���̰߳�ȫ�ģ����߳���Ч�ʻ��HashMap��
 *  
 *  5��HashMap���ܱ�֤����ʱ�������Map�е�Ԫ�ش����ǲ���ġ�
 * 
 * @author Administrator
 * 2016-3-1 ����04:13:14
 *
 */
public class HashTableAndHashtable {
	public static  void putMap(final Map<Object,Integer> map, final int id){
		for( int i=0;i<=id;i++){
			final int a=i;//�ڲ���ֻ����final����
			new Thread("Thread_"+i){
				public void run(){
					Thread.yield();
					map.put(a,a*id);
				}
			}.start();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		/**
		 * Collections.synchronizedMap()��������ʹHashMapͬ��
		 */
//		Map<Object,String> map=new HashMap<Object,String>();
//		Map<Object,String> m=Collections.synchronizedMap(map);
//		/**
//		 * ConcurrentHashMapʹHashMapͬ��
//		 */
//		Map<Object,Integer> currentMap=new ConcurrentHashMap<Object,Integer>();
//		putMap(currentMap, 5);
//		TimeUnit.SECONDS.sleep(2);
//		System.out.println(currentMap);
//		
//		/**
//		 * �̰߳�ȫ
//		 */
//		Map<Object,Integer> table=new Hashtable<Object,Integer>();
//		putMap(table, 5);
//		TimeUnit.SECONDS.sleep(2);
//		System.out.println(table);
		
		Map<Object,Integer> hashMap=new HashMap<Object,Integer>();
		putMap(hashMap, 10);
		TimeUnit.SECONDS.sleep(2);
		System.out.println(hashMap);
	}
}
