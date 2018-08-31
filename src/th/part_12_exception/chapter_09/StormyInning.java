package th.part_12_exception.chapter_09;

import th.part_12_exception.chapter_09.ClassExceptions.BaseBallException;
import th.part_12_exception.chapter_09.ClassExceptions.Foul;
import th.part_12_exception.chapter_09.ClassExceptions.PopFoul;
import th.part_12_exception.chapter_09.ClassExceptions.RaineOutException;
import th.part_12_exception.chapter_09.ClassExceptions.Strike;

public class StormyInning extends Inning implements Sorm {

	public StormyInning() throws RaineOutException, BaseBallException {
	}

	public StormyInning(String str) throws Foul, BaseBallException {
	}

	/**
	 * 编译出错，方法没有抛出任何异常，在此抛出异常报错
	 */
	// public void walk()throws PopFoul{}

	/**
	 * 基类方法和接口方法重名，不能添加基类方法中的异常 除非基类和接口异常都添加
	 */
	// public void event()throws RaineOutException{}

	@Override
	public void event() {
	}

	/**
	 * 基类中没有此方法，则接口中方法异常is ok
	 */
	@Override
	public void rainHard() throws RaineOutException {

	}

	/**
	 * Strike和Foul都继承BaseBallException异常， PopFoul继承于Foul atBat()父类中throws
	 * Foul,Strike,
	 */

	@Override
	public void atBat() {

	}

	public static void main(String[] args) {
		try {
			StormyInning si = new StormyInning();
			si.atBat();
		} catch (PopFoul e) {
			System.out.println("PopFoul");
			e.printStackTrace();
		} catch (RaineOutException e) {
			System.out.println("RaineOutException");
			e.printStackTrace();
		} catch (BaseBallException e) {
			System.out.println("BaseBallException");
			e.printStackTrace();
		}

		try {
			Inning in = new StormyInning();
			in.atBat();
		} catch (Strike e) {
			System.out.println("Strike");
			e.printStackTrace();
		} catch (Foul e) {
			System.out.println("Foul");
			e.printStackTrace();
		} catch (RaineOutException e) {
			System.out.println("RaineOutException");
			e.printStackTrace();
		} catch (BaseBallException e) {
			System.out.println("BaseBallException");
			e.printStackTrace();
		}
	}
}
