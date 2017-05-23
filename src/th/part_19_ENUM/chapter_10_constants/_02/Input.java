package th.part_19_ENUM.chapter_10_constants._02;

import java.util.Random;
/**
 * 19.10.2 
 * 使用enum的状态机
 * 
 * @author ken
 * 2017-5-4 上午08:55:42
 */
public enum Input {
	NICKEL(5),DIME(10),TOOTHPASTE(200),CHIPS(75),SODA(100),SOAP(50),
	ABORT_TRANSCTION{
		int amount(){
			throw new RuntimeException("ABORT.amount()");
		}
	},STOP{
		int amount(){
			throw new RuntimeException("SHUT_DOWN.amount()");
		}
	};
	
	int value;
	int amount(){
		return value;
	}
	private Input(){}
	private Input(int value){
		this.value=value;
	}
	
	static Random random=new Random(47);
	
	public static Input randomSection(){
		//length-1 don't include STOP
		return values()[random.nextInt(values().length-1)];
	}
}
