package th.part_12_exception.chapter_08finally._01;

import th.part_12_exception.chapter_06._02Rethorw.OneException;

public class AwalysFinally {
	public static void main(String[] args) {
		System.out.println("Entering first 1!");
		try {
			try {
				throw new OneException("异常测试");
			} finally {
				System.out.println("finally in 2!");
			}
		} catch (OneException e) {
			e.printStackTrace();
			System.out.println("catch in 3 !");
		}finally {
			System.out.println("finally in 4!");
		}
	}
}
