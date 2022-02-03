package com.andersen.mes.product.performance_test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.andersen.mes.product.performance_test.vo.Performance_TestVO;

@Repository("performance_testDAO")
public class Performance_TestDAOImpl implements Performance_TestDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllPerformance_TestUpList() throws DataAccessException {
		List<Performance_TestVO> mainList = null;
		mainList = sqlSession.selectList("mapper.product.performance.selectAllPerformance_TestUpList");
		return mainList;
	}
	
	@Override
	public List selectAllPerformance_TestDownList() throws DataAccessException {
		List<Performance_TestVO> downList = null;
		downList = sqlSession.selectList("mapper.product.performance.selectAllPerformance_TestList");
		return downList;
	}
	
	@Override
	public List searchPr_noDownList(String pr_NO) throws DataAccessException {
		List<Performance_TestVO> downList = null;
		downList = sqlSession.selectList("mapper.product.performance.searchPr_noDownList", pr_NO);
		return downList;
	}
	
	@Override
	public List searchDateUpList(Performance_TestVO performance_testVO) throws DataAccessException {
		List<Performance_TestVO> findList = null;
		findList = sqlSession.selectList("mapper.product.performance.searchDateUpList", performance_testVO);
		return findList;
	}
	
	@Override
	public int insertPerformance_Test(Performance_TestVO performance_testVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.performance.insertPerformance_Test", performance_testVO);
		return result;
	}
	
	@Override
	public int updatePerformance_Test(Performance_TestVO performance_testVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.performance.updatePerformance_Test", performance_testVO);
		return result;
	}
	
	@Override
	public int deletePerformance_Test(Performance_TestVO performance_testVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.performance.deletePerformance_Test", performance_testVO);
		return result;
	}
}
