package com.andersen.mes.information.employee.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.andersen.mes.information.employee.vo.EmployeeVO;

public interface EmployeeService {
	
	/**
	 * 전체 사원을 조회하는 메소드
	 * 
	 * @return List 타입
	 * @throws DataAccessException
	 */
	public List employeeAllList() throws DataAccessException;
	
	public void addEmployee(EmployeeVO employeeVO) throws DataAccessException;
	
	public void modEmployee(EmployeeVO employeeVO) throws DataAccessException;
	
	public void delEmployee(int empNo) throws DataAccessException;
}
