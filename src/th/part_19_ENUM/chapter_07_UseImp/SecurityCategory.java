package th.part_19_ENUM.chapter_07_UseImp;

import th.part_19_ENUM.chapter_06_Random.Enums;

/**
 * 枚举中的枚举2
 * @author Administrator
 * 2015-12-9 上午11:58:15
 *
 */
public enum SecurityCategory {
	STOCK(Security.Stock.class),
	BOND(Security.Bond.class);
	
	Security[] values;
	SecurityCategory(Class<? extends Security> kind){
		values=kind.getEnumConstants();
	}
	
	interface Security{
		enum Stock implements Security{
			SHORT,LONG,MARGIN;
		}
		enum Bond implements Security{
			MUICIPAL,JUNK
		}
	}
	
	public Security randonSelection(){
		return Enums.random(values);
	}
	
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			SecurityCategory security=Enums.random(SecurityCategory.class);
			System.out.println(security+":"+security.randonSelection());
		}
	}
}
