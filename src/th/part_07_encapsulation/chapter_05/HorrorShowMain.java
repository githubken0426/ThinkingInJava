package th.part_07_encapsulation.chapter_05;

public class HorrorShowMain {
	static void u(Monster b) {
		b.menace();
	}

	static void v(DangerousMonster d) {
		d.menace();
		d.destroy();
	}
	static void c(){
		
	}
	public static void main(String[] args) {
		DragonZillaImpl if2 = new DragonZillaImpl();
		u(if2);
		v(if2);

	}

}
