package th.part_15_Generic.chapter_10_WildCard._00;

public class Fruit {
	class Apple extends Fruit{}
	
	class JonaThan extends Apple{
		JonaThan(Apple a){
			a.super();
		}
	}
	class Orange extends Fruit{}
}
