package th.part_12_exception.chapter_08finally;

public class LostMessage {
	private static void f()throws VeryImportantException{
		throw new VeryImportantException();
	}
	private static void dispose()throws HoHumException{
		throw new HoHumException();
	}
	public static void main(String[] args) {
		
		try {
			try {
				LostMessage.f();
			} finally{
				try {
					LostMessage.dispose();
				} catch (HoHumException e) {
					e.printStackTrace();
					System.out.println(e);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
