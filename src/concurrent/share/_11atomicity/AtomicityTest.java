package concurrent.share._11atomicity;

public class AtomicityTest {
	private int level;
	private double score;//64λ˫���ȸ�����
	private long money;  //64λ������
	
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
