package com.equals;

/**
 * mcd
 * 
 * @author Administrator
 */
public class Mcd {
	private String id;
	private String lonId;
	private String unit;
	private String side;
	private String partsName;
	private String feederType;
	private String machine;

	@Override
	public int hashCode() {
		int hash = 17;
		hash = hash * 31 + (unit == null ? 0 : unit.hashCode());
		hash = hash * 31 + (side == null ? 0 : side.hashCode());
		hash = hash * 31 + (partsName == null ? 0 : partsName.hashCode());
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mcd mcd = (Mcd) obj;
		boolean bUnit = unit != null && unit.equals(mcd.unit);
		boolean bSide = side != null && side.equals(mcd.side);
		boolean bparts = partsName != null && partsName.equals(mcd.partsName);
		return bparts && bUnit && bSide;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLonId() {
		return lonId;
	}

	public void setLonId(String lonId) {
		this.lonId = lonId;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getPartsName() {
		return partsName;
	}

	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}

	public String getFeederType() {
		return feederType;
	}

	public void setFeederType(String feederType) {
		this.feederType = feederType;
	}

	public String getMachine() {
		return machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}
}
