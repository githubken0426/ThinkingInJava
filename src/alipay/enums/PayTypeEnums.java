package alipay.enums;

public enum PayTypeEnums {
	WXAPP(1, "微信"), ALIPAY(2, "支付宝"), WEBPAY(3, "网银");

	public static String getNameByIndex(int index) {
		for (PayTypeEnums PayType : PayTypeEnums.values()) {
			if (PayType.getIndex() == index) {
				return PayType.getName();
			}
		}
		return null;
	}

	private PayTypeEnums(int index, String name) {
		this.index = index;
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int index;
	private String name;
}
