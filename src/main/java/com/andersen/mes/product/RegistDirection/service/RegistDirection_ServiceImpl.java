package com.andersen.mes.product.RegistDirection.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andersen.mes.product.RegistDirection.dao.RegistDirection_DAO;
import com.andersen.mes.product.RegistDirection.dto.RegistDirection_DTO;

@Service("RegistDirection_Service")
@Transactional(propagation = Propagation.REQUIRED)
public class RegistDirection_ServiceImpl implements RegistDirection_Service {
	@Autowired
	private RegistDirection_DTO registdirection_dto;
	@Autowired
	private RegistDirection_DAO registdirection_dao;

	@Override
	public List POPUP_List() throws DataAccessException {
		List POPUP_List = null;
		POPUP_List = registdirection_dao.POPUP_List();
		return POPUP_List;
	}
	
	@Override
	public List After_POPUP_List(String pp_no) throws DataAccessException{
		List After_POPUP_List = null;
		After_POPUP_List = registdirection_dao.After_POPUP_List(pp_no);
		return After_POPUP_List;
	}
}
