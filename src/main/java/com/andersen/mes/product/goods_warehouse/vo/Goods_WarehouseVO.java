package com.andersen.mes.product.goods_warehouse.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("goods_warehouseVO")
/**
 * 생산품창고입고처리
 */
public class Goods_WarehouseVO {
	
	String rd_NO; //작업지시번호
	String pr_NO;//실적번호
	Date pr_Date; //실적일
	String itemNO; //-품번
	String item_Name; //품명
	String stockUnit; //DEFAULT 'EA',--단위
	String rd_Status; //default '확정',--상태
	int pr_Quantity; //실적수량
	int warehouse_Quantity; //입고대상수량
	int warehousing_Quantity; //입고가능
	
//	String pr_NO; //작업실적번호
	String gw_NO; //입고번호
	Date gw_DATE; //default sysdate 입고일자
	String gw_Warehouse; //입고창고
	String gw_Place; //입고장소
	int gw_Quantity; //입고수량
	
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
