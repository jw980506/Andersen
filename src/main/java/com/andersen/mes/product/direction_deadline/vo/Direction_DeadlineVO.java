package com.andersen.mes.product.direction_deadline.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("direction_deadlineVO")
/**
 * �۾����ø���ó��
 */
public class Direction_DeadlineVO {

	String rd_NO; //�۾����ù�ȣ
	Date rd_Date; //default sysdate ������
	Date mr_Date; //default sysdate �Ϸ���
	String itemNO; //ǰ��
	String item_Name; //ǰ��
	String stockUnit; //DEFAULT 'EA',--����
	int rd_Quantity; //���ü���
	String rd_Status; //default 'Ȯ��',--����
	
	private Date beginDate;
	private Date endDate;
	
	public Direction_DeadlineVO(Date beginDate, Date endDate) {
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	
	public Direction_DeadlineVO() {
		
	}
	
	public Direction_DeadlineVO(String rd_NO, Date rd_Date, Date mr_Date, String itemNO, String item_Name,
			String stockUnit, int rd_Quantity, String rd_Status) {
		super();
		this.rd_NO = rd_NO;
		this.rd_Date = rd_Date;
		this.mr_Date = mr_Date;
		this.itemNO = itemNO;
		this.item_Name = item_Name;
		this.stockUnit = stockUnit;
		this.rd_Quantity = rd_Quantity;
		this.rd_Status = rd_Status;
	}

	public String getRd_NO() {
		return rd_NO;
	}

	public void setRd_NO(String rd_NO) {
		this.rd_NO = rd_NO;
	}

	public Date getRd_Date() {
		return rd_Date;
	}

	public void setRd_Date(Date rd_Date) {
		this.rd_Date = rd_Date;
	}

	public Date getMr_Date() {
		return mr_Date;
	}

	public void setMr_Date(Date mr_Date) {
		this.mr_Date = mr_Date;
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

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}	
