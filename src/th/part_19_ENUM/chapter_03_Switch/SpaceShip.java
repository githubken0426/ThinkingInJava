package th.part_19_ENUM.chapter_03_Switch;

/**
 * 重写enum的toString()方法
 * @author Administrator
 * 2015-12-8 下午02:53:17
 *
 */
public enum SpaceShip {
	WEST,NOTH,EAST,SOUTH;
	public String toString(){
		String id=name();
		String lower=id.substring(1).toLowerCase();
		return id.charAt(0)+lower;
	}

	public static void main(String[] args) {
		for(SpaceShip s:SpaceShip.values()){
			System.out.println(s);
		}
	}
}
