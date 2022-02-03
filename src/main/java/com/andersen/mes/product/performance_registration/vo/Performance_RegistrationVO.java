package com.andersen.mes.product.performance_registration.vo;

import java.sql.Date;
//import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.format.annotation.DateTimeFormat;


@Component("performance_registrationVO")
/**
 * 작업실적등록
 */
public class Performance_RegistrationVO { 

	private String rd_no;
	private String release_Status;
	private String rd_Workspace;
//	@JsonFormat(shape=JsonFormat.Shap.STRING, pattern="yyyy-MM-dd")
//	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone="Asia/Seoul")
//	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date rd_Date;
	private Date mr_Date;
	private String itemNO;
	private String item_Name;
	private String stockUnit;
	private int rd_Quantity;
	private int pr_Quantity;
	private int pr_Residual_Quantity;
	private String rd_Status;//상태
	private String work_Scope;
	private int rd_Test;

//	private String rd_no; 작업실적등록조회
	private String pr_NO;
	private int materials_Availability;
	private Date pr_Date;
	private String pr_Process;
	private String pr_Workspace;
	private int transfer_Separation;
	private int pr_OrNot;
//	private int pr_Quantity;
//	private int rd_Test;
	private String pr_Name;
	private String warehouse_Process;
	private String place_Workspace;
	
	private Date beginDate;
	private Date endDate;
	
	public Performance_RegistrationVO() {
		
	}
	
	public Performance_RegistrationVO(Date beginDate, Date endDate) {
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	public Performance_RegistrationVO(String rd_no, String release_Status, String rd_Workspace, Date rd_Date,
			Date mr_Date, String itemNO, String item_Name, String stockUnit, int rd_Quantity, int pr_Quantity,
			int pr_Residual_Quantity, String rd_Status, String work_Scope, int rd_Test) {

		this.rd_no = rd_no;
		this.release_Status = release_Status;
		this.rd_Workspace = rd_Workspace;
		this.rd_Date = rd_Date;
		this.mr_Date = mr_Date;
		this.itemNO = itemNO;
		this.item_Name = item_Name;
		this.stockUnit = stockUnit;
		this.rd_Quantity = rd_Quantity;
		this.pr_Quantity = pr_Quantity;
		this.pr_Residual_Quantity = pr_Residual_Quantity;
		this.rd_Status = rd_Status;
		this.work_Scope = work_Scope;
		this.rd_Test = rd_Test;
	}

	public Performance_RegistrationVO(String rd_no, String pr_NO,
			int materials_Availability, Date pr_Date, String pr_Process, String pr_Workspace, int transfer_Separation,
			int pr_OrNot, int pr_Quantity, int rd_Test, String pr_Name, String warehouse_Process, String place_Workspace) {
		
		this.rd_no = rd_no;
		this.pr_NO = pr_NO;
		this.materials_Availability = materials_Availability;
		this.pr_Date = pr_Date;
		this.pr_Process = pr_Process;
		this.pr_Workspace = pr_Workspace;
		this.transfer_Separation = transfer_Separation;
		this.pr_OrNot = pr_OrNot;
		this.pr_Quantity = pr_Quantity;
		this.rd_Test = rd_Test;
		this.pr_Name = pr_Name;
		this.warehouse_Process = warehouse_Process;
		this.place_Workspace = place_Workspace;
	}

	public String getRd_no() {
		return rd_no;
	}

	public void setRd_no(String rd_no) {
		this.rd_no = rd_no;
	}

	public String getRelease_Status() {
		return release_Status;
	}

	public void setRelease_Status(String release_Status) {
		this.release_Status = release_Status;
	}

	public String getRd_Workspace() {
		return rd_Workspace;
	}

	public void setRd_Workspace(String rd_Workspace) {
		this.rd_Workspace = rd_Workspace;
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

	public int getPr_Quantity() {
		return pr_Quantity;
	}

	public void setPr_Quantity(int pr_Quantity) {
		this.pr_Quantity = pr_Quantity;
	}

	public int getPr_Residual_Quantity() {
		return pr_Residual_Quantity;
	}

	public void setPr_Residual_Quantity(int pr_Residual_Quantity) {
		this.pr_Residual_Quantity = pr_Residual_Quantity;
	}

	public String getRd_Status() {
		return rd_Status;
	}

	public void setRd_Status(String rd_Status) {
		this.rd_Status = rd_Status;
	}

	public String getWork_Scope() {
		return work_Scope;
	}

	public void setWork_Scope(String work_Scope) {
		this.work_Scope = work_Scope;
	}

	public int getRd_Test() {
		return rd_Test;
	}

	public void setRd_Test(int rd_Test) {
		this.rd_Test = rd_Test;
	}

	public String getPr_NO() {
		return pr_NO;
	}

	public void setPr_NO(String pr_NO) {
		this.pr_NO = pr_NO;
	}

	public int getMaterials_Availability() {
		return materials_Availability;
	}

	public void setMaterials_Availability(int materials_Availability) {
		this.materials_Availability = materials_Availability;
	}

	public Date getPr_Date() {
		return pr_Date;
	}

	public void setPr_Date(Date pr_Date) {
		this.pr_Date = pr_Date;
	}
	
//	public void setPr_Date(java.util.Date pr_Date) {
//		this.pr_Date = (Date) pr_Date;
//	}
	
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

	public int getTransfer_Separation() {
		return transfer_Separation;
	}

	public void setTransfer_Separation(int transfer_Separation) {
		this.transfer_Separation = transfer_Separation;
	}

	public int getPr_OrNot() {
		return pr_OrNot;
	}

	public void setPr_OrNot(int pr_OrNot) {
		this.pr_OrNot = pr_OrNot;
	}

	public String getPr_Name() {
		return pr_Name;
	}

	public void setPr_Name(String pr_Name) {
		this.pr_Name = pr_Name;
	}

	public String getWarehouse_Process() {
		return warehouse_Process;
	}

	public void setWarehouse_Process(String warehouse_Process) {
		this.warehouse_Process = warehouse_Process;
	}

	public String getPlace_Workspace() {
		return place_Workspace;
	}

	public void setPlace_Workspace(String place_Workspace) {
		this.place_Workspace = place_Workspace;
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
