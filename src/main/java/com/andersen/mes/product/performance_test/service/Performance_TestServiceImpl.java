package com.andersen.mes.product.performance_test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andersen.mes.product.performance_test.vo.Performance_TestVO;
import com.andersen.mes.product.performance_test.dao.Performance_TestDAO;

@Service("performance_testService")
public class Performance_TestServiceImpl implements Performance_TestService{

	@Autowired
	private Performance_TestDAO performance_testDAO;

	@Override
	public List main_performance_test() throws DataAccessException {
		List mainList = null;
		mainList = performance_testDAO.selectAllPerformance_TestUpList();
		return mainList;
	}
	
//	@Override
//	public List list_performance_test() throws DataAccessException {
//		List downList = null;
//		downList = performance_testDAO.selectAllPerformance_TestDownList();
//		return downList;
//	}
	
	@Override
	public List DownList_performance_test(String pr_NO) throws DataAccessException {
		List downList = null;
		downList = performance_testDAO.searchPr_noDownList(pr_NO);
		return downList;
	}
	
	@Override
	public List findDate_performance_test(Performance_TestVO performance_testVO) throws DataAccessException {
		List findList = null;
		findList = performance_testDAO.searchDateUpList(performance_testVO);
		return findList;
	}
	
	@Override
	public int add_performance_test(Performance_TestVO performance_testVO) throws DataAccessException {
		return performance_testDAO.insertPerformance_Test(performance_testVO);
	}
	
	@Override
	public int mod_performance_test(Performance_TestVO performance_testVO) throws DataAccessException {
		return performance_testDAO.updatePerformance_Test(performance_testVO);
	}
	
	@Override
	public int rem_performance_test(Performance_TestVO performance_testVO) throws DataAccessException {
		return performance_testDAO.deletePerformance_Test(performance_testVO);
	}
}
