package com.andersen.mes.product.performance_registration.service;

import java.util.List;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andersen.mes.product.performance_registration.vo.Performance_RegistrationVO;
import com.andersen.mes.product.performance_registration.dao.Performance_RegistrationDAO;

@Service("performance_registrationService")
public class Performance_RegistrationServiceImpl implements Performance_RegistrationService{

	@Autowired
	private Performance_RegistrationDAO performance_registrationDAO;

	@Override
	public List main_performance_registration() throws DataAccessException {
		List mainList = null;
		mainList = performance_registrationDAO.selectAllPerformance_RegistrationUpList();
		return mainList;
	}
	
	@Override
	public List list_performance_registration() throws DataAccessException {
		List downList = null;
		downList = performance_registrationDAO.selectAllPerformance_RegistrationDownList();
		return downList;
	}
	
	@Override
	public List DownList_performance_registration(String rd_no) throws DataAccessException {
		List downList = null;
		downList = performance_registrationDAO.searchRd_noDownList(rd_no);
		return downList;
	}
	
	@Override
	public List findRd_noUpList_performance_registration(String rd_no) throws DataAccessException {
		List findList = null;
		findList = performance_registrationDAO.searchRd_noUpList(rd_no);
		return findList;
	}
	
	@Override
	public List findDate_performance_registration(Performance_RegistrationVO performance_registrationVO) throws DataAccessException {
		List findList = null;
		findList = performance_registrationDAO.searchDateUpList(performance_registrationVO);
		return findList;
	}
	
	@Override
	public int add_performance_registration(Performance_RegistrationVO performance_registrationVO) throws DataAccessException {
		int result = 0;
		result = performance_registrationDAO.insertPerformance_Registration(performance_registrationVO);
		int result2 = performance_registrationDAO.insertMaterial_Use(performance_registrationVO);
		
		return performance_registrationDAO.insertPerformance_Registration(performance_registrationVO);
	}
	
	@Override
	public int mod_performance_registration(Performance_RegistrationVO performance_registrationVO) throws DataAccessException {
		return performance_registrationDAO.updatePerformance_Registration(performance_registrationVO);
	}
	
	@Override
	public int rem_performance_registration(String id) throws DataAccessException {
		return performance_registrationDAO.deletePerformance_Registration(id);
	}
}
