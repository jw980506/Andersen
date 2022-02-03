package com.andersen.mes.product.performance_test.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.andersen.mes.product.material_use.vo.Material_UseVO;
import com.andersen.mes.product.performance_test.vo.Performance_TestVO;

public interface Performance_TestDAO {

	 public List selectAllPerformance_TestUpList() throws DataAccessException;
	 public List selectAllPerformance_TestDownList() throws DataAccessException;
	 public List searchPr_noDownList(String pr_NO) throws DataAccessException;
	 public List searchDateUpList(Performance_TestVO performance_testVO) throws DataAccessException;
	 public int insertPerformance_Test(Performance_TestVO performance_testVO) throws DataAccessException ;
	 public int updatePerformance_Test(Performance_TestVO performance_testVO) throws DataAccessException ;
	 public int deletePerformance_Test(Performance_TestVO performance_testVO) throws DataAccessException;
	 
}