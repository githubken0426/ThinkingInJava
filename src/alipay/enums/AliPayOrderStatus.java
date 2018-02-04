package alipay.enums;

public enum AliPayOrderStatus {
	WAIT_BUYER_PAY("WAIT_BUYER_PAY", "未支付", "交易创建，等待买家付款"), 
	TRADE_CLOSED("TRADE_CLOSED", "已关闭","未付款交易超时关闭，或支付完成后全额退款"), 
	TRADE_SUCCESS("TRADE_SUCCESS", "支付成功","交易支付成功"), 
	TRADE_FINISHED("TRADE_FINISHED", "交易结束", "交易结束，不可退款");
	
	private String index;
	private String name;
	private String remark;

	public static String findNameByIndex(String index) {
		for (AliPayOrderStatus status : AliPayOrderStatus.values()) {
			if (status.getIndex().equals(index)) {
				return status.getName();
			}
		}
		return null;
	}

	private AliPayOrderStatus(String index, String name, String remark) {
		this.index = index;
		this.name = name;
		this.remark = remark;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
