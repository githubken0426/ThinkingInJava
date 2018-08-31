package th.part_12_exception.chapter_08finally._09limit;
//: exceptions/StormyInning.java

// Overridden methods may throw only the exceptions
// specified in their base-class versions, or exceptions
// derived from the base-class exceptions.

class BaseballException extends Exception {
	private static final long serialVersionUID = 1L;
}

class Foul extends BaseballException {
	private static final long serialVersionUID = 1L;
}

class Strike extends BaseballException {
	private static final long serialVersionUID = 1L;
}

abstract class Inning {
	
	public Inning() throws BaseballException {
	}
	/**
	 * 声明异常，但是没有抛出异常，这种方式可以强制用户捕获override后的event()后增加的异常
	 * @throws BaseballException
	 */
	public void event() throws BaseballException {
		// Doesn't actually have to throw anything
	}
	public abstract void atBat() throws Strike, Foul;

	public void walk() {
	} // Throws no checked exceptions
}

class StormException extends Exception {
	private static final long serialVersionUID = 1L;
}

class RainedOut extends StormException {
	private static final long serialVersionUID = 1L;
}

class PopFoul extends Foul {
	private static final long serialVersionUID = 1L;
}

interface Storm {
	public void event() throws RainedOut;
	
	public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm{
	// OK to add new exceptions for constructors, but you
	// must deal with the base constructor exceptions:
	public StormyInning() throws RainedOut, BaseballException {
	}

	public StormyInning(String s) throws Foul, BaseballException {
	}

	// Regular methods must conform to base class:
	//public void walk() throws PopFoul {} //Compile error
	
	
	// If the method doesn't already exist in the
	// base class, the exception is OK:
	public void rainHard() throws RainedOut {}

	/**
	 * Inning 和接口 Storm拥有共同方法event()，分别抛出不同异常。
	 * 则event()无法区分到底抛出那种异常，所以不能抛出任何异常。
	 */
	// You can choose to not throw any exceptions,even if the base version does:
	public void event() {}
	// Interface CANNOT add exceptions to existing methods from the base class:
	//public void event()throws BaseballException,RainedOut{}
	
	// Overridden methods can throw inherited exceptions:
	public void atBat() throws PopFoul{
	}

	public static void main(String[] args) {
		try {
			StormyInning si = new StormyInning();
			si.atBat();
		} catch (PopFoul e) {
			System.out.println("Pop foul");
		} catch (RainedOut e) {
			System.out.println("Rained out");
		} catch (BaseballException e) {
			System.out.println("Generic baseball exception");
		}
		// Strike not thrown in derived version.
		try {
			// What happens if you upcast?
			Inning i = new StormyInning();
			i.atBat();
			// You must catch the exceptions from the
			// base-class version of the method:
		} catch (Strike e) {
			System.out.println("Strike");
		} catch (Foul e) {
			System.out.println("Foul");
		} catch (RainedOut e) {
			System.out.println("Rained out");
		} catch (BaseballException e) {
			System.out.println("Generic baseball exception");
		}
	}
}
