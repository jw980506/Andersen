package com.andersen.mes.product.RegistDirection.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("RegistDirection_DTO")
public class RegistDirection_DTO {
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
	//ÆË¾÷Ã¢
	String pp_NO;
	int residual_Quantity;
	Date pp_Schedule;
	int pp_Quantity;
	Date date1;
	Date date2;
	
	
	


	public RegistDirection_DTO() {
		
	}
	
	
	public RegistDirection_DTO(String rd_NO, Date re_Date, Date rd_Period, String itemNO, String item_Name,
			String stockUnit, String rd_Process, String rd_WorkSpace, int rd_Quantity, String rd_Status, String rd_Test,
			String emp_Name, String pp_NO, int residual_Quantity, Date pp_Schedule, int pp_Quantity) {
		super();
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
		this.pp_NO = pp_NO;
		this.residual_Quantity = residual_Quantity;
		this.pp_Schedule = pp_Schedule;
		this.pp_Quantity = pp_Quantity;
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
	public String getPp_NO() {
		return pp_NO;
	}
	public void setPp_NO(String pp_NO) {
		this.pp_NO = pp_NO;
	}
	public int getResidual_Quantity() {
		return residual_Quantity;
	}
	public void setResidual_Quantity(int residual_Quantity) {
		this.residual_Quantity = residual_Quantity;
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
	
	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}
	
}
	
	