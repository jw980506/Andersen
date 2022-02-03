package com.andersen.mes.information.item.vo;

public class ItemVO {

	private String itemNo; 
	private String item_Name;
	private String account;
	private String procurement;
	private String stockUnit;
	private String lot;
	private String setItem;
	private String test;
	private double weight;
	private double dayProduction;
	private double leadTime;
	private double stdCost;
	private double actualCost;
	private double safetyStock;
	
	public ItemVO() {
		
	}

	public ItemVO(String itemNo, String item_Name, String account, String procurement, String stockUnit, String lot,
			String setItem, String test, double weight, double dayProduction, double leadTime, double stdCost,
			double actualCost, double safetyStock) {
		this.itemNo = itemNo;
		this.item_Name = item_Name;
		this.account = account;
		this.procurement = procurement;
		this.stockUnit = stockUnit;
		this.lot = lot;
		this.setItem = setItem;
		this.test = test;
		this.weight = weight;
		this.dayProduction = dayProduction;
		this.leadTime = leadTime;
		this.stdCost = stdCost;
		this.actualCost = actualCost;
		this.safetyStock = safetyStock;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getItem_Name() {
		return item_Name;
	}

	public void setItem_Name(String item_Name) {
		this.item_Name = item_Name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getProcurement() {
		return procurement;
	}

	public void setProcurement(String procurement) {
		this.procurement = procurement;
	}

	public String getStockUnit() {
		return stockUnit;
	}

	public void setStockUnit(String stockUnit) {
		this.stockUnit = stockUnit;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getSetItem() {
		return setItem;
	}

	public void setSetItem(String setItem) {
		this.setItem = setItem;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getDayProduction() {
		return dayProduction;
	}

	public void setDayProduction(double dayProduction) {
		this.dayProduction = dayProduction;
	}

	public double getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(double leadTime) {
		this.leadTime = leadTime;
	}

	public double getStdCost() {
		return stdCost;
	}

	public void setStdCost(double stdCost) {
		this.stdCost = stdCost;
	}

	public double getActualCost() {
		return actualCost;
	}

	public void setActualCost(double actualCost) {
		this.actualCost = actualCost;
	}

	public double getSafetyStock() {
		return safetyStock;
	}

	public void setSafetyStock(double safetyStock) {
		this.safetyStock = safetyStock;
	}

	@Override
	public String toString() {
		return "ItemVO [itemNo=" + itemNo + ", item_Name=" + item_Name + ", account=" + account + ", procurement="
				+ procurement + ", stockUnit=" + stockUnit + ", lot=" + lot + ", setItem=" + setItem + ", test=" + test
				+ ", weight=" + weight + ", dayProduction=" + dayProduction + ", leadTime=" + leadTime + ", stdCost="
				+ stdCost + ", actualCost=" + actualCost + ", safetyStock=" + safetyStock + "]";
	}
	
	
}
