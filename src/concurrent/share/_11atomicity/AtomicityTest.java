package concurrent.share._11atomicity;

public class AtomicityTest {
	private int level;
	private double score;//64位双精度浮点数
	private long money;  //64位长整型
	
	public int getLevel() {
		return level;
	}
	public int incrementLevel() {
		level++;
		return level;
	}
	
	public double getScore() {
		return score;
	}
	
	public long getMoney() {
		return money;
	}
}
