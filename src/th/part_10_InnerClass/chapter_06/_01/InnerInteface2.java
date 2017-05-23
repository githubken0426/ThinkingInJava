package th.part_10_InnerClass.chapter_06._01;

public class InnerInteface2 {
	interface Game{
		boolean move();
	}
	
	interface GameFactory{
		Game getGame();
	}
	
	static class Checker implements Game{
		private Checker(){}
		private int moves=0;
		private static final int MOVES=3;
		
		@Override
		public boolean move() {
			System.out.println("Checker moves:"+moves);
			return (++moves)!=MOVES;
		}
		/**
		 * 每次都创建一个实例,moves每次都被初始化
		 * moves永远不会递增
		 */
		public static GameFactory factory=new GameFactory(){
			@Override
			public Game getGame() {
				return new Checker();
			}
		};
	}
	
	static class Chess implements Game{
		public Chess(){}
		private int moves=0;
		private static final int MOVES=3;
		
		@Override
		public boolean move() {
			System.out.println("Chess moves:"+moves);
			return ++moves!=MOVES;
		}
		/**
		 * 返回当前实例，实现moves递增
		 */
		public  GameFactory factory=new GameFactory(){
			@Override
			public Game getGame() {
				return Chess.this;
			}
		};
	}
	
	
}
