package com.andersen.mes.product.goods_warehouse.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.andersen.mes.product.goods_warehouse.vo.Goods_WarehouseVO;

public interface Goods_WarehouseDAO {
	
	 public List selectAllGoods_WarehouseUpList() throws DataAccessException;
	 public List selectAllGoods_WarehouseDownList() throws DataAccessException;
	 public List searchPr_noDownList(String pr_NO) throws DataAccessException;
	 public List searchDateUpList(Goods_WarehouseVO goods_warehouseVO) throws DataAccessException;
	 public int insertGoods_Warehouse(Goods_WarehouseVO goods_warehouseVO) throws DataAccessException ;
	 public int updateGoods_Warehouse(Goods_WarehouseVO goods_warehouseVO) throws DataAccessException ;
	 public int deleteGoods_Warehouse(String id) throws DataAccessException;

}
