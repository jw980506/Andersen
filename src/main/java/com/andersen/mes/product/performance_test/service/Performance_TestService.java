package com.andersen.mes.product.performance_test.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.andersen.mes.product.performance_test.vo.Performance_TestVO;

public interface Performance_TestService {
	
	 public List main_performance_test() throws DataAccessException;
//	 public List main_performance_test() throws DataAccessException;
	 public List DownList_performance_test(String pr_NO) throws DataAccessException;
	 public List findDate_performance_test(Performance_TestVO performance_testVO) throws DataAccessException;
	 public int add_performance_test(Performance_TestVO performance_testVO) throws DataAccessException;
	 public int mod_performance_test(Performance_TestVO performance_testVO) throws DataAccessException;
	 public int rem_performance_test(Performance_TestVO performance_testVO) throws DataAccessException;
}
