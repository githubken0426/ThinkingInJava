/**   
 * <b>package-info����ƽ���࣬������������:</b><br>   
 * 1��Ϊ��ע�ڰ���Annotation�ṩ������<br>   
 * 2����������˽����ͳ�����<br>   
 * 3���ṩ��������ע��˵����<br>   
 *  
 * @author   
*/   

@Test
package th.part_20_Annotation.chapter_01_Base._01;
  
class PackageInfo{  
    public void common(){  
        System.out.println("sa");  
    }  
}  
  
class PackageInfoGeneric<T extends Throwable>{  
    private T obj;  
    public void set(T obj){  
        this.obj = obj;  
    }  
    public void common(){  
        System.out.println(obj + "sa");  
    }  
}  
  
interface packageInfoInteger{  
    public void test();  
}  
  
class PackageConstants{  
    public static final String ERROE_CODE = "100001";     
}  