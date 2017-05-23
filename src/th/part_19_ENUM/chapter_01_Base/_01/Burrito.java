package th.part_19_ENUM.chapter_01_Base._01;
import static th.part_19_ENUM.chapter_01_Base._01.Spiciness.*;

/**
 * 枚举的静态导入
 * @author Administrator
 * 2015-12-8 下午02:25:31
 *
 */
public class Burrito {
	Spiciness spiciness;
	public Burrito(Spiciness spciness){
		this.spiciness=spciness;
	}
	
	public String toString(){
		return "Burrito is "+this.spiciness;
	}
	
	public static void main(String[] args) {
		System.out.println(new Burrito(HOT));
		System.out.println(new Burrito(NOT));
	}
}
