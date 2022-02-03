package com.andersen.mes.information.employee.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.andersen.mes.information.employee.vo.EmployeeVO;

public interface EmployeeDAO {
	
	/**
	 * 전체 사원을 조회하는 기능
	 * 
	 * @return List타입
	 * @throws DataAccessException
	 */
	public List selectAllEmployeeList() throws DataAccessException;
	
	public void addOneEmployee(EmployeeVO employeeVO) throws DataAccessException;
	
	public void modOneEmployee(EmployeeVO employeeVO) throws DataAccessException;
	
	public void delOneEmployee(int empNo) throws DataAccessException;
}
