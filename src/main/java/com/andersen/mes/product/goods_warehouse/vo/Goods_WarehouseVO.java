package com.andersen.mes.product.goods_warehouse.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("goods_warehouseVO")
/**
 * ����ǰâ���԰�ó��
 */
public class Goods_WarehouseVO {
	
	String rd_NO; //�۾����ù�ȣ
	String pr_NO;//������ȣ
	Date pr_Date; //������
	String itemNO; //-ǰ��
	String item_Name; //ǰ��
	String stockUnit; //DEFAULT 'EA',--����
	String rd_Status; //default 'Ȯ��',--����
	int pr_Quantity; //��������
	int warehouse_Quantity; //�԰������
	int warehousing_Quantity; //�԰���
	
//	String pr_NO; //�۾�������ȣ
	String gw_NO; //�԰��ȣ
	Date gw_DATE; //default sysdate �԰�����
	String gw_Warehouse; //�԰�â��
	String gw_Place; //�԰����
	int gw_Quantity; //�԰����
	
	private Date beginDate;
	private Date endDate;

	public Goods_WarehouseVO() {
		
	}
	
	public Goods_WarehouseVO(Date beginDate, Date endDate) {
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	
	public Goods_WarehouseVO(String rd_NO, String pr_NO, Date pr_Date, String itemNO, String item_Name, String stockUnit,
			String rd_Status, int pr_Quantity, int warehouse_Quantity, int warehousing_Quantity) {
		
		this.rd_NO = rd_NO;
		this.pr_NO = pr_NO;
		this.pr_Date = pr_Date;
		this.itemNO = itemNO;
		this.item_Name = item_Name;
		this.stockUnit = stockUnit;
		this.rd_Status = rd_Status;
		this.pr_Quantity = pr_Quantity;
		this.warehouse_Quantity = warehouse_Quantity;
		this.warehousing_Quantity = warehousing_Quantity;
	}

	public Goods_WarehouseVO(String pr_NO, String gw_NO, Date gw_DATE, String gw_Warehouse, String gw_Place,
			int gw_Quantity) {
		
		this.pr_NO = pr_NO;
		this.gw_NO = gw_NO;
		this.gw_DATE = gw_DATE;
		this.gw_Warehouse = gw_Warehouse;
		this.gw_Place = gw_Place;
		this.gw_Quantity = gw_Quantity;
	}

	public String getRd_NO() {
		return rd_NO;
	}

	public void setRd_NO(String rd_NO) {
		this.rd_NO = rd_NO;
	}

	public String getPr_NO() {
		return pr_NO;
	}

	public void setPr_NO(String pr_NO) {
		this.pr_NO = pr_NO;
	}

	public Date getPr_Date() {
		return pr_Date;
	}

	public void setPr_Date(Date pr_Date) {
		this.pr_Date = pr_Date;
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

	public String getRd_Status() {
		return rd_Status;
	}

	public void setRd_Status(String rd_Status) {
		this.rd_Status = rd_Status;
	}

	public int getPr_Quantity() {
		return pr_Quantity;
	}

	public void setPr_Quantity(int pr_Quantity) {
		this.pr_Quantity = pr_Quantity;
	}

	public int getWarehouse_Quantity() {
		return warehouse_Quantity;
	}

	public void setWarehouse_Quantity(int warehouse_Quantity) {
		this.warehouse_Quantity = warehouse_Quantity;
	}

	public int getWarehousing_Quantity() {
		return warehousing_Quantity;
	}

	public void setWarehousing_Quantity(int warehousing_Quantity) {
		this.warehousing_Quantity = warehousing_Quantity;
	}

	public String getGw_NO() {
		return gw_NO;
	}

	public void setGw_NO(String gw_NO) {
		this.gw_NO = gw_NO;
	}

	public Date getGw_DATE() {
		return gw_DATE;
	}

	public void setGw_DATE(Date gw_DATE) {
		this.gw_DATE = gw_DATE;
	}

	public String getGw_Warehouse() {
		return gw_Warehouse;
	}

	public void setGw_Warehouse(String gw_Warehouse) {
		this.gw_Warehouse = gw_Warehouse;
	}

	public String getGw_Place() {
		return gw_Place;
	}

	public void setGw_Place(String gw_Place) {
		this.gw_Place = gw_Place;
	}

	public int getGw_Quantity() {
		return gw_Quantity;
	}

	public void setGw_Quantity(int gw_Quantity) {
		this.gw_Quantity = gw_Quantity;
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
