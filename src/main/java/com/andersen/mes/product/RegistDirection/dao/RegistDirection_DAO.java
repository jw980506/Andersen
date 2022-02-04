package com.andersen.mes.product.RegistDirection.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.andersen.mes.product.RegistDirection.dto.RegistDirection_DTO;

public interface RegistDirection_DAO {
	
	public List POPUP_List() throws DataAccessException;
	
	public List After_POPUP_List(String pp_no) throws DataAccessException;

}
