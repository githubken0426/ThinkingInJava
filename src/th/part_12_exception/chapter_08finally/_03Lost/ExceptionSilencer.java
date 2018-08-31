package th.part_12_exception.chapter_08finally._03Lost;

public class ExceptionSilencer {
	@SuppressWarnings("finally")
	public static void main(String[] args) {
		try {
			throw new RuntimeException();
		} finally {
			// 使用return后，异常将不再被抛出
			return;
		}
	}
}
