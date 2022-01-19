package com.andersen.mes.product.ProductPlanning.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.andersen.mes.product.ProductPlanning.dto.ProductPlanning_DTO;

public interface ProductPlanning_Service {
	public List ProductPlanning_ItemList() throws DataAccessException;
	public List Total_Plan_List() throws DataAccessException;
	public List ProductPlanning_Item_Plan_List(String itemno) throws DataAccessException;
	public List ProductPlanning_Item_Search_List(String itemno2) throws DataAccessException;
	public int ADD_Plan_List(ProductPlanning_DTO productplanning_dto) throws DataAccessException;
	public int MOD_Plan_List(ProductPlanning_DTO productplanning_dto) throws DataAccessException;
	public int DEL_Plan_List(String pp_no) throws DataAccessException;
	
}
