package th.about.reference;

/**
 * Employee����������
 * @author Administrator
 * 2015��9��16��
 */
public class CacheMain {
	public static void main(String[] args) {
		EmployeeCache cache=EmployeeCache.getInstance();
		cache.getEmployee("SN002");
		cache.getEmployee("SN002");
	}
}
