package com.andersen.mes.information.employee.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface EmployeeService {
	
	/**
	 * 전체 사원을 조회하는 메소드
	 * 
	 * @return List 타입
	 * @throws DataAccessException
	 */
	public List employeeAllList() throws DataAccessException;
}
