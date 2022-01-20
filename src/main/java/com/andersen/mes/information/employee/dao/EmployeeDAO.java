package com.andersen.mes.information.employee.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface EmployeeDAO {
	
	/**
	 * 전체 사원을 조회하는 기능
	 * 
	 * @return List타입
	 * @throws DataAccessException
	 */
	public List selectAllEmployeeList() throws DataAccessException;
	
	public void addEmployee() throws DataAccessException;
}
