package com.andersen.mes.product.performance_registration.dao;

import java.util.List;
import java.sql.Date;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.andersen.mes.product.performance_registration.vo.Performance_RegistrationVO;

@Repository("performance_registrationDAO")
public class Performance_RegistrationDAOImpl implements Performance_RegistrationDAO {

	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private Performance_RegistrationVO performance_registrationVO;

	@Override
	public List selectAllPerformance_RegistrationUpList() throws DataAccessException {
		List<Performance_RegistrationVO> mainList = null;
		mainList = sqlSession.selectList("mapper.product.selectAllPerformance_RegistrationUpList");
		return mainList;
	}
	
	@Override
	public List selectAllPerformance_RegistrationDownList() throws DataAccessException {
		List<Performance_RegistrationVO> downList = null;
		downList = sqlSession.selectList("mapper.product.selectAllPerformance_RegistrationDownList");
		return downList;
	}
	
	@Override //생산자제사용등록을 위한 리스트 호출
	public List searchRd_noDownList(String rd_no) throws DataAccessException {
		List<Performance_RegistrationVO> downList = null;
		downList = sqlSession.selectList("mapper.product.searchRd_noDownList", rd_no);
		return downList;
	}
	
	@Override
	public List searchRd_noUpList(String rd_no) throws DataAccessException {
		List<Performance_RegistrationVO> findList = null;
		findList = sqlSession.selectList("mapper.product.searchRd_noUpList", rd_no);
		return findList;
	}
	
	@Override
	public List searchDateUpList(Performance_RegistrationVO performance_registrationVO) throws DataAccessException {
		List<Performance_RegistrationVO> findList = null;
//		System.out.println("기간출력 :" +performance_registrationVO.getBeginDate());
		findList = sqlSession.selectList("mapper.product.searchDateUpList", performance_registrationVO);
		return findList;
	}
	
	@Override
	public int insertPerformance_Registration(Performance_RegistrationVO performance_registrationVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.insertPerformance_Registration", performance_registrationVO);
//		int result2 = sqlSession.insert("mapper.product.insertMaterial_Use", performance_registrationVO);
		return result;
	}
	
	@Override
	public int insertMaterial_Use(Performance_RegistrationVO performance_registrationVO) throws DataAccessException {
//		int result = sqlSession.insert("mapper.product.insertPerformance_Registration", performance_registrationVO);
		int result = sqlSession.insert("mapper.product.insertMaterial_Use", performance_registrationVO);
		return result;
	}
	
	@Override
	public int updatePerformance_Registration(Performance_RegistrationVO performance_registrationVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.updatePerformance_Registration", performance_registrationVO);
		return result;
	}
	
	@Override
	public int deletePerformance_Registration(String id) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.deletePerformance_Registration", id);
		return result;
	}
}
