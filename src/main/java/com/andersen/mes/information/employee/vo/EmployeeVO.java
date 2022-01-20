package com.andersen.mes.information.employee.vo;

import java.util.Date;

public class EmployeeVO {
	
	private int empNo;				// 사원코드
	private String emp_Name;		// 사원명
	private String password;		// 비밀번호
	private double deptNo;			// 부서코드
	private String dept_Name;		// 부서명
	private Date hireDate;			// 입사일
	
	// 기본 생성자
	public EmployeeVO() {
		
	}

	// 사용자 정의 생성자
	public EmployeeVO(int empNo, String emp_Name, String password, double deptNo, String dept_Name, Date hireDate) {
		this.empNo = empNo;
		this.emp_Name = emp_Name;
		this.password = password;
		this.deptNo = deptNo;
		this.dept_Name = dept_Name;
		this.hireDate = hireDate;
	}

	// getter, setter
	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmp_Name() {
		return emp_Name;
	}

	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(double deptNo) {
		this.deptNo = deptNo;
	}

	public String getDept_Name() {
		return dept_Name;
	}

	public void setDept_Name(String dept_Name) {
		this.dept_Name = dept_Name;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "EmployeeVO >> [empNo=" + empNo + ", emp_Name=" + emp_Name + ", password=" + password + ", deptNo=" + deptNo
				+ ", dept_Name=" + dept_Name + "]";
	}
	
	
}