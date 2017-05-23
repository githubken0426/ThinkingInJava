package th.part_12_exception.chapter_09;

import th.part_12_exception.chapter_09.ClassExceptions.BaseBallException;
import th.part_12_exception.chapter_09.ClassExceptions.Foul;
import th.part_12_exception.chapter_09.ClassExceptions.PopFoul;
import th.part_12_exception.chapter_09.ClassExceptions.RaineOutException;
import th.part_12_exception.chapter_09.ClassExceptions.Strike;


public class StormyInning extends Inning implements Sorm {
	
	public StormyInning() throws RaineOutException,BaseBallException {}
	
	public StormyInning(String str) throws Foul,BaseBallException {}
	
	/**
	 * �����������û���׳��κ��쳣���ڴ��׳��쳣����
	 */
	//public void walk()throws PopFoul{}
	
	/**
	 * ���෽���ͽӿڷ���������������ӻ��෽���е��쳣
	 * ���ǻ���ͽӿ��쳣�����
	 */
	//public void event()throws RaineOutException{}
	
	@Override
	public void event(){}
	
	/**
	 * ������û�д˷�������ӿ��з����쳣is ok  
	 */
	@Override
	public void rainHard()throws RaineOutException {
		
	}
	/**
	 * Strike��Foul���̳�BaseBallException�쳣��
	 * PopFoul�̳���Foul
	 * atBat()������throws Foul,Strike,
	 */
	
	@Override
	public void atBat() {
	
	}
	
	
	
	public static void main(String[] args) {
		try {
			StormyInning si= new StormyInning();
			si.atBat();
		} catch (PopFoul e) {
			System.out.println("PopFoul");
			e.printStackTrace();
		}catch (RaineOutException e) {
			System.out.println("RaineOutException");
			e.printStackTrace();
		} catch (BaseBallException e) {
			System.out.println("BaseBallException");
			e.printStackTrace();
		}
		
		try {
			Inning in=new StormyInning();
			in.atBat();
		} catch (Strike e) {
			System.out.println("Strike");
			e.printStackTrace();
		}catch (Foul e) {
			System.out.println("Foul");
			e.printStackTrace();
		}catch (RaineOutException e) {
			System.out.println("RaineOutException");
			e.printStackTrace();
		}catch (BaseBallException e) {
			System.out.println("BaseBallException");
			e.printStackTrace();
		}
	}
}
