package com.andersen.mes.information.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.andersen.mes.information.employee.dao.EmployeeDAO;
import com.andersen.mes.information.employee.vo.EmployeeVO;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	public List employeeAllList() throws DataAccessException {
		
		List listAllEmployee = null;
		listAllEmployee = employeeDAO.selectAllEmployeeList();
		return listAllEmployee;
	}

	@Override
	public void addEmployee(EmployeeVO employeeVO) throws DataAccessException {
		employeeDAO.addOneEmployee(employeeVO);
	}

	@Override
	public void modEmployee(EmployeeVO employeeVO) throws DataAccessException {
		employeeDAO.modOneEmployee(employeeVO);
	}

	@Override
	public void delEmployee(int empNo) throws DataAccessException {
		employeeDAO.delOneEmployee(empNo);
	}
	
	
}
