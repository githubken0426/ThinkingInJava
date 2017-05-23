package th.part_17_DeepInCollection.chapter_06Set;

public class TreeType extends SetType implements Comparable<TreeType> {

	public TreeType(int i) {
		super(i);
	}

	@Override
	public int compareTo(TreeType o) {
		/**
		 * 此处并没有使用i-o.i的形式
		 * (此种形式只有在i和o.i都是无符号整形才适用)
		 * 对于有符号int,当i为十分大的正整数、o.i为很大的负整数， 
		 * 两者相减就会内存溢出，返回负数，从而计算出错
		 */
		return o.i < i ? -1 : (o.i == i ? 0 : 1);
	}

	/**
	 * 整型的每一种都分有无符号（unsigned）和
	 * 有符号（signed）两种类型（float和double总是带符号的），
	 * 在默认情况下声明的整型变量都是有符号的类型（char有点特别），
	 * 如果需声明无符号类型的话就需要在类型前加上unsigned。
	 * 
	 * 无符号版本和有符号版本的区别:无符号类型能保存2倍于有符号类型的正整数数据，
	 * 比如16位系统中一个int能存储的数据的范围为-32768~32767，
	 * 而unsigned能存储的数据范围则是0~65535。
	 * 由于在计算机中,整数是以补码形式存放的。根据最高位的不同，
	 * 如果是1,有符号数的话就是负数；如果是无符号数,则都解释为正数。
	 * unsigned若省略,大多数编译器都会认为是unsigned int.
	 * 
	 * @param args
	 *            2017-1-5 上午09:37:19
	 */
	public static void main(String[] args) {
		int i = 2147483647;
		int j = -2147483647;
		System.out.println(i - j);
	}
}
