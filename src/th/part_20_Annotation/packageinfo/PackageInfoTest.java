package th.part_20_Annotation.packageinfo;

public class PackageInfoTest {
	public static void main(String[] args) {
		System.out.println(PackageConstants.ERROE_CODE);
		new PackageInfo().common();
		
		new PackageInfoInterface(){
			@Override
			public void test() {
				System.out.println("自己实现package-info中的接口PackageInfo");	
			}
		};
	}
}
