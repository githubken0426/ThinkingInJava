package th.part_13_String.chaper_03;

public class InfiniteRecursion {
	
	public InfiniteRecursion(){}
	
	public InfiniteRecursion(String name){
		this.name=name;
	}
	/**
	 * ������������this+��ʱ�򣬾�������ת����
	 * this��InfiniteRecursion���ͣ������InfiniteRecursion��toString()����
	 * �����쳣���ݹ���á�
	 */
	public String toString(){
		//return "�ڴ��ַ:"+this+"\n";
		return "�ڴ��ַ:"+super.toString()+"\n";
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
