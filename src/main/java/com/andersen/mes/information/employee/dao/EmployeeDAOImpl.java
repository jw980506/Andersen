package com.andersen.mes.information.employee.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.andersen.mes.information.employee.vo.EmployeeVO;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllEmployeeList() throws DataAccessException {
			
		List<EmployeeVO> listAllEmployee = null;			// VO타입의 리스트 선언
		listAllEmployee = sqlSession.selectList("mapper.information.employee.selectAllEmployeeList");		// 여러 행이라 selectList 사용
		return listAllEmployee;
	}

}
