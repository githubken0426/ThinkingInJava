package cn.cglib.lazyload;

/**
 * 实体类Bean
 * 
 * @author ken
 * 2016-12-9 上午08:52:50
 */
public class PropertyBean {
	private String key;  
    private Object value;
    
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
    
}
