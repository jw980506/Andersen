package com.andersen.mes.product.material_use.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("material_useVO")
/**
 * ������������
 */
public class Material_UseVO {

	String rd_NO; //�۾����ù�ȣ
	String pr_NO; //�۾�������ȣ
	String use_Report; //DEFAULT '��' ��������
	String pr_Process; //��������
	String pr_Workspace; //�����۾���
	Date pr_Date; // default sysdate ������
	String itemNO; // ǰ��
	String item_Name; // ǰ��
	String stockUnit; // DEFAULT 'EA' ����
	String rd_Status; // default '���' ����
	String pr_OrNot; // DEFAULT '����' ��������
	int pr_Quantity; // ��������
	
//	pr_NO �۾�������ȣ ������ȣ�� ����
	int num; //����
	Date use_Date; //default sysdate �����
//	pr_Process ����
//	pr_Workspace �۾���
//	itemNO ǰ��
//	item_Name ǰ��
//	stockUnit ����
	int cds_needQuantity; // number(*,4)������
	
	private Date beginDate;
	private Date endDate;
	
	public Material_UseVO() {
		
	}
	
	public Material_UseVO(Date beginDate, Date endDate) {
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	
	public Material_UseVO(String rd_NO, String pr_NO, String use_Report, String pr_Process, String pr_Workspace,
			Date pr_Date, String itemNO, String item_Name, String stockUnit, String rd_Status, String pr_OrNot,
			int pr_Quantity) {
	
		this.rd_NO = rd_NO;
		this.pr_NO = pr_NO;
		this.use_Report = use_Report;
		this.pr_Process = pr_Process;
		this.pr_Workspace = pr_Workspace;
		this.pr_Date = pr_Date;
		this.itemNO = itemNO;
		this.item_Name = item_Name;
		this.stockUnit = stockUnit;
		this.rd_Status = rd_Status;
		this.pr_OrNot = pr_OrNot;
		this.pr_Quantity = pr_Quantity;
	}

	public Material_UseVO(String pr_NO, int num, Date use_Date, String pr_Process, String pr_Workspace, String itemNO, String item_Name,
			String stockUnit, int cds_needQuantity) {
	
		this.pr_NO = pr_NO;
		this.num = num;
		this.use_Date = use_Date;
		this.pr_Process = pr_Process;
		this.pr_Workspace = pr_Workspace;
		this.itemNO = itemNO;
		this.item_Name = item_Name;
		this.stockUnit = stockUnit;
		this.cds_needQuantity = cds_needQuantity;
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

	public String getUse_Report() {
		return use_Report;
	}

	public void setUse_Report(String use_Report) {
		this.use_Report = use_Report;
	}

	public String getPr_Process() {
		return pr_Process;
	}

	public void setPr_Process(String pr_Process) {
		this.pr_Process = pr_Process;
	}

	public String getPr_Workspace() {
		return pr_Workspace;
	}

	public void setPr_Workspace(String pr_Workspace) {
		this.pr_Workspace = pr_Workspace;
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

	public String getPr_OrNot() {
		return pr_OrNot;
	}

	public void setPr_OrNot(String pr_OrNot) {
		this.pr_OrNot = pr_OrNot;
	}

	public int getPr_Quantity() {
		return pr_Quantity;
	}

	public void setPr_Quantity(int pr_Quantity) {
		this.pr_Quantity = pr_Quantity;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Date getUse_Date() {
		return use_Date;
	}

	public void setUse_Date(Date use_Date) {
		this.use_Date = use_Date;
	}

	public int getCds_needQuantity() {
		return cds_needQuantity;
	}

	public void setCds_needQuantity(int cds_needQuantity) {
		this.cds_needQuantity = cds_needQuantity;
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
