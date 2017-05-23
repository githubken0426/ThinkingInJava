package th.part_21_Concurrence.chapter_02._09ChangeCode;

public class ThreadVariations {
	public static void main(String[] args) {
		new InnerThread1("InnerThread1");
		new InnerThread2("InnerThread2");
		new InnerRunnable1("InnerRunnable1");
		new InnerRunnable1("InnerRunnable2");
		new ThreadMethod("ThreadMethod").runTask();
	}
}
