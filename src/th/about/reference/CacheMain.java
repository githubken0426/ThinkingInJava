package th.about.reference;

/**
 * Employee»º´æÆ÷²âÊÔ
 * @author Administrator
 * 2015Äê9ÔÂ16ÈÕ
 */
public class CacheMain {
	public static void main(String[] args) {
		EmployeeCache cache=EmployeeCache.getInstance();
		cache.getEmployee("SN002");
		cache.getEmployee("SN002");
	}
}
