package th.part_15_Generic.chapter_02_SimpleGeneric._01_Tuple;

/**
 * 2άԪ��
 * 
 * Ԫ�����һ�ε��ã����ض����ͬ�Ķ���
 * TupleԪ���ǲ��ɱ�list��һ��������һ��tuple�Ͳ������κη�ʽ�ı�����python��
 * 
 * @author ken
 * 2015��9��18��
 * @param <A>
 * @param <B>
 */
public class TwoTuple<A,B> {
	//����final���ͣ�Ϊ���ö������ֻ������
	public final A first;
	public final B second;
	
	public TwoTuple(A a,B b){
		this.first=a;
		this.second=b;
	}
	
	public String toString(){
		return "First:"+first+",Second:"+second.getClass().getCanonicalName();
	}
}
