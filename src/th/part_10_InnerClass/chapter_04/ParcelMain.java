package th.part_10_InnerClass.chapter_04;

public class ParcelMain {
	public static void main(String[] args) {
		Parcel4 par=new Parcel4();
		par.contents();
		System.out.println(par.destination("test").readLabel());
		//Parcel4.Contents c=par.new ContentsImpl();
	}
}
