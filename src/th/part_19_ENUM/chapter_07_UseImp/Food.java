package th.part_19_ENUM.chapter_07_UseImp;

public interface Food {
	enum Appeltizer implements Food{
		SALAD,SOUP,SPRING_ROLLS//´º¾í;
	}
	enum MainCourse implements Food{
		LASAGNE,BRRITO,PAD_THAT,LENTILS,HUMMOUS,VINDALOO;
	}
	enum Dessert implements Food{
		TIRAMISU,GELATO,BLACK_FOREST_CAKE,FRUIT,CREME_CARAMEL;
	}
	enum Coffee implements Food{
		BLACK_COFFEE,DECAF_COFFEE,EXPRESSO,LATTE,CAPPUCCINO,HERB_TEA;
	}
}
