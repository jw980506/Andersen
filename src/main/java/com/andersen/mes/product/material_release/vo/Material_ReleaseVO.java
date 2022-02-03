package com.andersen.mes.product.material_release.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("material_releaseVO")
/**
 * 생산자재출고
 */
public class Material_ReleaseVO {

	String mr_NO; //출고번호
	Date mr_Date; // default sysdate 출고일자
	String mr_Warehouse; // not null출고창고
	String mr_Place; // not null출고장소
	String rd_Process; // 공정
	String rd_Workspace; // 작업장
	String emp_Name; // not null담당자
	
//	String mr_NO VARCHAR2(20),//출고번호는 브라우저에 보이지 않음
//	String rd_NO; // 작업지시번호
	int mrs_Sequence; //NUMBER(*,4)순서
	String itemNO; //품번
	String item_Name; //품명
	String stockUnit; //DEFAULT 'EA'단위
	int rr_Quantity; //number(*,4)요청수량
	int mrs_Quantity; //number(*,4)출고수량
	
	//작업지시확정2 테이블을 들고오는 팝업창 VO
	String rd_NO; // 작업지시번호
	Date cds_Request_Date;// default sysdate 청구일자
//	itemNO 품번
//	item_Name 품명
//	stockUnit DEFAULT 'EA'단위
	int cds_needQuantity; //DEFAULT 1 확정수량 = 청구수량 = 청구잔량

	private Date beginDate;
	private Date endDate;
	
	public Material_ReleaseVO() {
		
	}
	
	public Material_ReleaseVO(Date beginDate, Date endDate) {
		super();
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	public Material_ReleaseVO(String mr_NO, Date mr_Date, String mr_Warehouse, String mr_Place, String rd_Process,
			String rd_Workspace, String emp_Name) {

		this.mr_NO = mr_NO;
		this.mr_Date = mr_Date;
		this.mr_Warehouse = mr_Warehouse;
		this.mr_Place = mr_Place;
		this.rd_Process = rd_Process;
		this.rd_Workspace = rd_Workspace;
		this.emp_Name = emp_Name;
	}

	public Material_ReleaseVO(String mr_NO, int mrs_Sequence, String itemNO, String item_Name, String stockUnit,
			int rr_Quantity, int mrs_Quantity) {

		this.mr_NO = mr_NO;
		this.mrs_Sequence = mrs_Sequence;
		this.itemNO = itemNO;
		this.item_Name = item_Name;
		this.stockUnit = stockUnit;
		this.rr_Quantity = rr_Quantity;
		this.mrs_Quantity = mrs_Quantity;
	}
	
	//팝업창 조회을 위한 생성자
	public Material_ReleaseVO(Date cds_Request_Date, String rd_NO, String itemNO, String item_Name, String stockUnit,
			int cds_needQuantity) {

		this.cds_Request_Date = cds_Request_Date;
		this.rd_NO = rd_NO;
		this.itemNO = itemNO;
		this.item_Name = item_Name;
		this.stockUnit = stockUnit;
		this.cds_needQuantity = cds_needQuantity;
	}

	public String getMr_NO() {
		return mr_NO;
	}

	public void setMr_NO(String mr_NO) {
		this.mr_NO = mr_NO;
	}

	public Date getMr_Date() {
		return mr_Date;
	}

	public void setMr_Date(Date mr_Date) {
		this.mr_Date = mr_Date;
	}

	public String getMr_Warehouse() {
		return mr_Warehouse;
	}

	public void setMr_Warehouse(String mr_Warehouse) {
		this.mr_Warehouse = mr_Warehouse;
	}

	public String getMr_Place() {
		return mr_Place;
	}

	public void setMr_Place(String mr_Place) {
		this.mr_Place = mr_Place;
	}

	public String getRd_Process() {
		return rd_Process;
	}

	public void setRd_Process(String rd_Process) {
		this.rd_Process = rd_Process;
	}

	public String getRd_Workspace() {
		return rd_Workspace;
	}

	public void setRd_Workspace(String rd_Workspace) {
		this.rd_Workspace = rd_Workspace;
	}

	public String getEmp_Name() {
		return emp_Name;
	}

	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}

	public int getMrs_Sequence() {
		return mrs_Sequence;
	}

	public void setMrs_Sequence(int mrs_Sequence) {
		this.mrs_Sequence = mrs_Sequence;
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

	public int getRr_Quantity() {
		return rr_Quantity;
	}

	public void setRr_Quantity(int rr_Quantity) {
		this.rr_Quantity = rr_Quantity;
	}

	public int getMrs_Quantity() {
		return mrs_Quantity;
	}

	public void setMrs_Quantity(int mrs_Quantity) {
		this.mrs_Quantity = mrs_Quantity;
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

	public String getRd_NO() {
		return rd_NO;
	}

	public void setRd_NO(String rd_NO) {
		this.rd_NO = rd_NO;
	}

	public Date getCds_Request_Date() {
		return cds_Request_Date;
	}

	public void setCds_Request_Date(Date cds_Request_Date) {
		this.cds_Request_Date = cds_Request_Date;
	}

	public int getCds_needQuantity() {
		return cds_needQuantity;
	}

	public void setCds_needQuantity(int cds_needQuantity) {
		this.cds_needQuantity = cds_needQuantity;
	}
	
}
