package com.andersen.mes.product.ProductPlanning.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("ProductPlanning_DTO")
public class ProductPlanning_DTO {
	String pp_NO;
	String itemNO;
	String item_Name;
	String stockUnit;
	double dayProduction;
	int pp_Sequence;
	Date pp_Schedule;
	int pp_Quantity;
	String emp_Name;
	
	String itemNO2;
	
	

	public ProductPlanning_DTO() {
		
	}

	public ProductPlanning_DTO(String pp_NO, String itemNO, String item_Name, String stockUnit, double dayProduction,
			int pp_Sequence, Date pp_Schedule, int pp_Quantity, String emp_Name, String iemNO2) {
		super();
		this.pp_NO = pp_NO;
		this.itemNO = itemNO;
		this.item_Name = item_Name;
		this.stockUnit = stockUnit;
		this.dayProduction = dayProduction;
		this.pp_Sequence = pp_Sequence;
		this.pp_Schedule = pp_Schedule;
		this.pp_Quantity = pp_Quantity;
		this.emp_Name = emp_Name;
		this.itemNO2 = itemNO2;
	}

	public String getPp_NO() {
		return pp_NO;
	}

	public void setPp_NO(String pp_NO) {
		this.pp_NO = pp_NO;
	}

	public String getItemNO() {
		return itemNO;
	}

	public void setItemNO(String itemNO) {
		this.itemNO = itemNO;
	}
	
	public String getItemNO2() {
		return itemNO2;
	}

	public void setItemNO2(String itemNO2) {
		this.itemNO2 = itemNO2;
	}
	
	public String getItem_Name() {
		return item_Name;
	}

	public void setItem_Name(String item_Name) {
		this.item_Name = item_Name;
	}

	public String getStockUnit() {
		return stockUnit;
	}

	public void setStockUnit(String stockUnit) {
		this.stockUnit = stockUnit;
	}

	public double getDayProduction() {
		return dayProduction;
	}

	public void setDayProduction(double dayProduction) {
		this.dayProduction = dayProduction;
	}

	public int getPp_Sequence() {
		return pp_Sequence;
	}

	public void setPp_Sequence(int pp_Sequence) {
		this.pp_Sequence = pp_Sequence;
	}

	public Date getPp_Schedule() {
		return pp_Schedule;
	}

	public void setPp_Schedule(Date pp_Schedule) {
		this.pp_Schedule = pp_Schedule;
	}

	public int getPp_Quantity() {
		return pp_Quantity;
	}

	public void setPp_Quantity(int pp_Quantity) {
		this.pp_Quantity = pp_Quantity;
	}

	public String getEmp_Name() {
		return emp_Name;
	}

	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}
	
	
		
}