package com.andersen.mes.product.performance_test.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("performance_testVO")
/**
 * ��������˻�
 */
public class Performance_TestVO {
	
	String rd_NO; //�۾����ù�ȣ
	String pr_NO; //�۾�������ȣ
	Date pr_Date; //default sysdate ������
	String itemNO; //ǰ��
	String item_Name; //ǰ��
	String stockUnit; //DEFAULT 'EA' ����
	int pr_Quantity; //��������
	String rd_Status; //default 'Ȯ��' ����
	String work_Scope; //DEFAULT '�۾�����' �۾�����
	
//	String pr_NO; //�۾�������ȣ
	int num; //����
	Date test_Date; //default sysdate �˻���
	String test_Class; //�˻籸��
	int sample_Quantity; //�÷��
	String test_Type; //default '���ð˻�',--�˻�����
	String pass; //default '�հ�',--�հݿ���
	int passed_Quantity; //�հݼ���
	int fail_Quantity; //���հݼ���
	
	private Date beginDate;
	private Date endDate;
	
	public Performance_TestVO() {
		
	}
	
	public Performance_TestVO(Date beginDate, Date endDate) {
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	
	public Performance_TestVO(String rd_NO, String pr_NO, Date pr_Date, String itemNO, String item_Name,
			String stockUnit, int pr_Quantity, String rd_Status, String work_Scope) {

		this.rd_NO = rd_NO;
		this.pr_NO = pr_NO;
		this.pr_Date = pr_Date;
		this.itemNO = itemNO;
		this.item_Name = item_Name;
		this.stockUnit = stockUnit;
		this.pr_Quantity = pr_Quantity;
		this.rd_Status = rd_Status;
		this.work_Scope = work_Scope;
	}

	public Performance_TestVO(String pr_NO, int num, Date test_Date, String test_Class, int sample_Quantity, String test_Type,
			String pass, int passed_Quantity, int fail_Quantity) {

		this.pr_NO = pr_NO;
		this.num = num;
		this.test_Date = test_Date;
		this.test_Class = test_Class;
		this.sample_Quantity = sample_Quantity;
		this.test_Type = test_Type;
		this.pass = pass;
		this.passed_Quantity = passed_Quantity;
		this.fail_Quantity = fail_Quantity;
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

	public int getPr_Quantity() {
		return pr_Quantity;
	}

	public void setPr_Quantity(int pr_Quantity) {
		this.pr_Quantity = pr_Quantity;
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

	public Date getTest_Date() {
		return test_Date;
	}

	public void setTest_Date(Date test_Date) {
		this.test_Date = test_Date;
	}

	public String getTest_Class() {
		return test_Class;
	}

	public void setTest_Class(String test_Class) {
		this.test_Class = test_Class;
	}

	public int getSample_Quantity() {
		return sample_Quantity;
	}

	public void setSample_Quantity(int sample_Quantity) {
		this.sample_Quantity = sample_Quantity;
	}

	public String getTest_Type() {
		return test_Type;
	}

	public void setTest_Type(String test_Type) {
		this.test_Type = test_Type;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getPassed_Quantity() {
		return passed_Quantity;
	}

	public void setPassed_Quantity(int passed_Quantity) {
		this.passed_Quantity = passed_Quantity;
	}

	public int getFail_Quantity() {
		return fail_Quantity;
	}

	public void setFail_Quantity(int fail_Quantity) {
		this.fail_Quantity = fail_Quantity;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
