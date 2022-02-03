package com.andersen.mes.product.material_release.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("material_releaseVO")
/**
 * �����������
 */
public class Material_ReleaseVO {

	String mr_NO; //����ȣ
	Date mr_Date; // default sysdate �������
	String mr_Warehouse; // not null���â��
	String mr_Place; // not null������
	String rd_Process; // ����
	String rd_Workspace; // �۾���
	String emp_Name; // not null�����
	
//	String mr_NO VARCHAR2(20),//����ȣ�� �������� ������ ����
//	String rd_NO; // �۾����ù�ȣ
	int mrs_Sequence; //NUMBER(*,4)����
	String itemNO; //ǰ��
	String item_Name; //ǰ��
	String stockUnit; //DEFAULT 'EA'����
	int rr_Quantity; //number(*,4)��û����
	int mrs_Quantity; //number(*,4)������
	
	//�۾�����Ȯ��2 ���̺��� ������ �˾�â VO
	String rd_NO; // �۾����ù�ȣ
	Date cds_Request_Date;// default sysdate û������
//	itemNO ǰ��
//	item_Name ǰ��
//	stockUnit DEFAULT 'EA'����
	int cds_needQuantity; //DEFAULT 1 Ȯ������ = û������ = û���ܷ�

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
	
	//�˾�â ��ȸ�� ���� ������
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
