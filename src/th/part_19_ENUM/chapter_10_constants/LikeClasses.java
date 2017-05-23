package th.part_19_ENUM.chapter_10_constants;

public enum LikeClasses {
	WINKEN {
		@Override
		public void behavior() {
			System.out.println("WINKEN behavior");
		}
	},
	BLIKEN {
		@Override
		public void behavior() {
			System.out.println("BLIKEN behavior");
		}
	},
	AON {
		@Override
		public void behavior() {
			System.out.println("AON behavior");
		}
	};
	abstract void behavior();
}

class NotClass {
	/*
	 * compile error; cannot be resolved to a type
	 * ÿ��enumԪ�ض���һ��LikeClasses���͵�static finalʵ��
	 */
//	static void f(LikeClasses.WINKEN instance){}
	
	static void f(LikeClasses instance){}
	
	public static void main(String[] args) {
		LikeClasses str= LikeClasses.WINKEN;
	}
}
