package th.part_17_DeepInCollection.chapter_06Set;

public class TreeType extends SetType implements Comparable<TreeType> {

	public TreeType(int i) {
		super(i);
	}

	@Override
	public int compareTo(TreeType o) {
		/**
		 * �˴���û��ʹ��i-o.i����ʽ
		 * (������ʽֻ����i��o.i�����޷������β�����)
		 * �����з���int,��iΪʮ�ִ����������o.iΪ�ܴ�ĸ������� 
		 * ��������ͻ��ڴ���������ظ������Ӷ��������
		 */
		return o.i < i ? -1 : (o.i == i ? 0 : 1);
	}

	/**
	 * ���͵�ÿһ�ֶ������޷��ţ�unsigned����
	 * �з��ţ�signed���������ͣ�float��double���Ǵ����ŵģ���
	 * ��Ĭ����������������ͱ��������з��ŵ����ͣ�char�е��ر𣩣�
	 * ����������޷������͵Ļ�����Ҫ������ǰ����unsigned��
	 * 
	 * �޷��Ű汾���з��Ű汾������:�޷��������ܱ���2�����з������͵����������ݣ�
	 * ����16λϵͳ��һ��int�ܴ洢�����ݵķ�ΧΪ-32768~32767��
	 * ��unsigned�ܴ洢�����ݷ�Χ����0~65535��
	 * �����ڼ������,�������Բ�����ʽ��ŵġ��������λ�Ĳ�ͬ��
	 * �����1,�з������Ļ����Ǹ�����������޷�����,�򶼽���Ϊ������
	 * unsigned��ʡ��,�����������������Ϊ��unsigned int.
	 * 
	 * @param args
	 *            2017-1-5 ����09:37:19
	 */
	public static void main(String[] args) {
		int i = 2147483647;
		int j = -2147483647;
		System.out.println(i - j);
	}
}
