package th.part_20_Annotation.chapter_01_Base._04;


public enum TestEnum {
	Test(""),
	SQLString("String"),
	SQLInteger("Integer"),
	SQLDouble("Double")	;
	
	
	private String dataType;

	
	
	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}


	private TestEnum(String dataType){
		this.dataType=dataType;
	}

	
}
