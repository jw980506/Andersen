package com.andersen.mes.product.performance_registration.service;

import java.util.List;
import java.sql.Date;

import org.springframework.dao.DataAccessException;

import com.andersen.mes.product.performance_registration.vo.Performance_RegistrationVO;

public interface Performance_RegistrationService {
	
	 public List main_performance_registration() throws DataAccessException;
	 public List list_performance_registration() throws DataAccessException;
	 public List DownList_performance_registration(String rd_no) throws DataAccessException;
	 public List findRd_noUpList_performance_registration(String rd_no) throws DataAccessException;
	 public List findDate_performance_registration(Performance_RegistrationVO performance_registrationVO) throws DataAccessException;
	 public int add_performance_registration(Performance_RegistrationVO performance_registrationVO) throws DataAccessException;
	 public int mod_performance_registration(Performance_RegistrationVO performance_registrationVO) throws DataAccessException;
	 public int rem_performance_registration(String id) throws DataAccessException;
}
