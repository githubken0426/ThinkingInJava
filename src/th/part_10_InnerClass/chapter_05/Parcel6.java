package th.part_10_InnerClass.chapter_05;

/**
 * ������Ƕ���ڲ���
 * 
 * @author ken
 * 2016-9-20 ����02:36:17
 */
public class Parcel6 {
	
	private static void internalTracking(boolean b){
		if(b){
			class TrackingSlip{
				private String id;
				
				TrackingSlip(String id){
					this.id=id;
				}
				String getSlip(){
					System.out.println("id="+id);
					return id;
				}
			}
			TrackingSlip ts=new TrackingSlip("test");
			ts.getSlip();
		}
		//out of scope,only in "if" scope
		//TrackingSlip ts=new TrackingSlip("test");
	}
	
	private static void track(){
		internalTracking(true);
	}
	
	public static void main(String[] args) {
		Parcel6.track();
	}
}
