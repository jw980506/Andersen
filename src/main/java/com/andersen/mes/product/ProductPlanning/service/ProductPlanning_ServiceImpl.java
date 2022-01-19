package com.andersen.mes.product.ProductPlanning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andersen.mes.product.ProductPlanning.dao.ProductPlanning_DAO;
import com.andersen.mes.product.ProductPlanning.dto.ProductPlanning_DTO;


@Service("ProductionPlanning_Service")
@Transactional(propagation = Propagation.REQUIRED)
public class ProductPlanning_ServiceImpl implements ProductPlanning_Service{
	@Autowired
	private ProductPlanning_DAO productplanning_dao;
	@Autowired
	private ProductPlanning_DTO productplanning_dto;
	
	@Override
	public List ProductPlanning_ItemList() throws DataAccessException {
		List ProductPlanning_ItemList = null;
		ProductPlanning_ItemList = productplanning_dao.Find_ItemList_All();
		return ProductPlanning_ItemList;
	}
	
	@Override
	public List Total_Plan_List() throws DataAccessException{
		List Total_Plan_List = null; 
		Total_Plan_List = productplanning_dao.Total_Plan_List();
		return Total_Plan_List;
	}
	
	@Override
	public List ProductPlanning_Item_Plan_List(String itemno) throws DataAccessException{		
		List ProductPlanning_Item_Plan_List = null;
		ProductPlanning_Item_Plan_List = productplanning_dao.ProductPlanning_Item_Plan_List(itemno);
		
		return ProductPlanning_Item_Plan_List ;
	}

	@Override
	public List ProductPlanning_Item_Search_List(String itemno2) throws DataAccessException {
		List ProductPlanning_Item_Search_List = null;
		ProductPlanning_Item_Search_List = productplanning_dao.ProductPlanning_Item_Search_List(itemno2);
		
		return ProductPlanning_Item_Search_List;
	}
	
	@Override
	public int ADD_Plan_List(ProductPlanning_DTO productplanning_dto) throws DataAccessException{

		return productplanning_dao.ADD_Plan_List(productplanning_dto);
	}
	
	@Override
	public int MOD_Plan_List(ProductPlanning_DTO productplanning_dto) throws DataAccessException{

		return productplanning_dao.MOD_Plan_List(productplanning_dto);
	}
	
	@Override
	public int DEL_Plan_List(String pp_no) throws DataAccessException{
		return productplanning_dao.DEL_Plan_List(pp_no);
	}
	

}
