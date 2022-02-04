package com.andersen.mes.product.RegistDirection.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("RegistDirection_VO")
public class RegistDirection_VO {
	String rd_NO;
	Date re_Date;
	Date rd_Period;
	String itemNO;
	String item_Name;
	String stockUnit;
	String rd_Process;
	String rd_WorkSpace;
	int rd_Quantity;
	String rd_Status;
	String rd_Test;
	String emp_Name;
	
	public RegistDirection_VO() {
		
	}
	
	public RegistDirection_VO(String rd_NO, Date re_Date, Date rd_Period, String itemNO, String item_Name,
			String stockUnit, String rd_Process, String rd_WorkSpace, int rd_Quantity, String rd_Status, String rd_Test,
			String emp_Name) {
		
		this.rd_NO = rd_NO;
		this.re_Date = re_Date;
		this.rd_Period = rd_Period;
		this.itemNO = itemNO;
		this.item_Name = item_Name;
		this.stockUnit = stockUnit;
		this.rd_Process = rd_Process;
		this.rd_WorkSpace = rd_WorkSpace;
		this.rd_Quantity = rd_Quantity;
		this.rd_Status = rd_Status;
		this.rd_Test = rd_Test;
		this.emp_Name = emp_Name;
	}
	
	public String getRd_NO() {
		return rd_NO;
	}
	public void setRd_NO(String rd_NO) {
		this.rd_NO = rd_NO;
	}
	public Date getRe_Date() {
		return re_Date;
	}
	public void setRe_Date(Date re_Date) {
		this.re_Date = re_Date;
	}
	public Date getRd_Period() {
		return rd_Period;
	}
	public void setRd_Period(Date rd_Period) {
		this.rd_Period = rd_Period;
	}
	public String getItemNO() {
		return itemNO;
	}
	public void setItemNO(String itemNO) {
		this.itemNO = itemNO;
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
	public String getRd_Process() {
		return rd_Process;
	}
	public void setRd_Process(String rd_Process) {
		this.rd_Process = rd_Process;
	}
	public String getRd_WorkSpace() {
		return rd_WorkSpace;
	}
	public void setRd_WorkSpace(String rd_WorkSpace) {
		this.rd_WorkSpace = rd_WorkSpace;
	}
	public int getRd_Quantity() {
		return rd_Quantity;
	}
	public void setRd_Quantity(int rd_Quantity) {
		this.rd_Quantity = rd_Quantity;
	}
	public String getRd_Status() {
		return rd_Status;
	}
	public void setRd_Status(String rd_Status) {
		this.rd_Status = rd_Status;
	}
	public String getRd_Test() {
		return rd_Test;
	}
	public void setRd_Test(String rd_Test) {
		this.rd_Test = rd_Test;
	}
	public String getEmp_Name() {
		return emp_Name;
	}
	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}
	
}
