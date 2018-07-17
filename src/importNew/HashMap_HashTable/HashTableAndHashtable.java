package importNew.HashMap_HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * HashMap和Hashtable区别
 * 
 * 1：HashMap不是synchronized的，线程不安全。
 * 	  Hashtable是synchronized的，线程安全的,多个线程可以共享一个Hashtable。
 * 
 * 2: HashMap可以存null的key、value.Hashtable不可以。
 * 
 * 3：另一个区别是HashMap的迭代器(Iterator)是fail-fast迭代器，而Hashtable的Enumerator迭代器不是fail-fast的。
 *    所以当有其它线程改变了HashMap的结构（增加或者移除元素），将会抛出ConcurrentModificationException，
 *    但迭代器本身的remove()方法移除元素则不会抛出ConcurrentModificationException异常。
 *    但这并不是一个一定发生的行为，要看JVM。这条同样也是Enumeration和Iterator的区别。
 *    
 *  4：由于Hashtable是线程安全的，单线程下效率会比HashMap慢
 *  
 *  5：HashMap不能保证随着时间的推移Map中的元素次序是不变的。
 * 
 * @author Administrator
 * 2016-3-1 下午04:13:14
 *
 */
public class HashTableAndHashtable {
	public static  void putMap(final Map<Object,Integer> map, final int id){
		for( int i=0;i<=id;i++){
			final int a=i;//内部类只能用final修饰
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
		 * Collections.synchronizedMap()方法可以使HashMap同步
		 */
//		Map<Object,String> map=new HashMap<Object,String>();
//		Map<Object,String> m=Collections.synchronizedMap(map);
//		/**
//		 * ConcurrentHashMap使HashMap同步
//		 */
//		Map<Object,Integer> currentMap=new ConcurrentHashMap<Object,Integer>();
//		putMap(currentMap, 5);
//		TimeUnit.SECONDS.sleep(2);
//		System.out.println(currentMap);
//		
//		/**
//		 * 线程安全
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