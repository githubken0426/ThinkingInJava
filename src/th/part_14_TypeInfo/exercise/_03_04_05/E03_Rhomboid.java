package th.part_14_TypeInfo.exercise._03_04_05;

import java.util.Arrays;
import java.util.List;

public class E03_Rhomboid {
	public static void main(String[] args) {
		List<Shape> list=Arrays.asList(new Circle(),new Rhomboid());
		for (Shape shaps : list) {
			shaps.draw();
		}
		Shape r=new Rhomboid();
		r.draw();
		Rhomboid r2=(Rhomboid) r;
		r2.draw();
		/**
		 *  Downcast to Circle. Succeeds at compile time,
		 *	but fails at runtime with a ClassCastException:
		 */
		if(r instanceof Circle){
			Circle c=(Circle)r;
			c.draw();
		}else{
			System.out.println("shap not a circle");
		}
		//E_05
		Shape circle=new Circle();
		if(circle instanceof Circle){
			circle.rotate();
		}
	}
}
