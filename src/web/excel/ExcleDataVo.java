package web.excel;

import java.util.ArrayList;
import java.util.List;

public class ExcleDataVo {
	private String serialNumber;
	private String cellName;
	private List<Object> cellList = new ArrayList<Object>();
	
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getCellName() {
		return cellName;
	}
	public void setCellName(String cellName) {
		this.cellName = cellName;
	}
	public List<Object> getCellList() {
		return cellList;
	}
	public void setCellList(List<Object> cellList) {
		this.cellList = cellList;
	}
}
