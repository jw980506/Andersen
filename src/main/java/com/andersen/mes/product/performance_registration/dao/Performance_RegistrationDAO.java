package com.andersen.mes.product.performance_registration.dao;

import java.util.List;
import java.sql.Date;

import org.springframework.dao.DataAccessException;

import com.andersen.mes.product.performance_registration.vo.Performance_RegistrationVO;

public interface Performance_RegistrationDAO {

	 public List selectAllPerformance_RegistrationUpList() throws DataAccessException;
	 public List selectAllPerformance_RegistrationDownList() throws DataAccessException;
	 public List searchRd_noDownList(String rd_no) throws DataAccessException;
	 public List searchRd_noUpList(String rd_no) throws DataAccessException;
	 public List searchDateUpList(Performance_RegistrationVO performance_registrationVO) throws DataAccessException;
	 public int insertPerformance_Registration(Performance_RegistrationVO performance_registrationVO) throws DataAccessException ;
	 public int insertMaterial_Use(Performance_RegistrationVO performance_registrationVO) throws DataAccessException ;
	 public int updatePerformance_Registration(Performance_RegistrationVO performance_registrationVO) throws DataAccessException ;
	 public int deletePerformance_Registration(String id) throws DataAccessException;

}
