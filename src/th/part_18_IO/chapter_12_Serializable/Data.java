package th.part_18_IO.chapter_12_Serializable;

import java.io.Serializable;

public class Data implements Serializable {
	private Integer n;
	public Data(Integer n){
		this.n=n;
	}
	public String toString(){
		return Integer.toString(n);
	}
}
