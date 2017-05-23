package th.part_19_ENUM.chapter_05_Imp;

import java.util.Random;

import TIJ4_code.net.mindview.util.Generator;

/**
 * 19.5 ʵ�֣����Ǽ̳�
 * @author ken
 * 
 * 2015-12-9 ����09:55:10
 * 2017-5-2 ����10:03:41
 */
public enum CartoonCharacter implements Generator<CartoonCharacter>{
	SLAPPY,SPANKY,PUNCHY,SILLU,BOUNCY,NUTTY,BOB;
	private Random random=new Random(47);
	@Override
	public CartoonCharacter next() {
		return values()[random.nextInt(values().length)];
	}
	
}
