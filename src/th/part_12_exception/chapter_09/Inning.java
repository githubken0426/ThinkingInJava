package th.part_12_exception.chapter_09;

import th.part_12_exception.chapter_09.ClassExceptions.BaseBallException;
import th.part_12_exception.chapter_09.ClassExceptions.Foul;
import th.part_12_exception.chapter_09.ClassExceptions.PopFoul;
import th.part_12_exception.chapter_09.ClassExceptions.Strike;

public abstract class Inning {
	
	public Inning()throws BaseBallException{}
	
	public void event()throws BaseBallException{}
	
	public  abstract  void atBat()throws Foul,Strike;
	
	//没有抛出任何异常,此处也可以throws PopFoul
	public void walk(){}
}
