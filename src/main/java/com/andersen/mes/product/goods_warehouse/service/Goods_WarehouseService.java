package com.andersen.mes.product.goods_warehouse.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.andersen.mes.product.goods_warehouse.vo.Goods_WarehouseVO;

public interface Goods_WarehouseService {
	
	 public List main_goods_warehouse() throws DataAccessException;
	 public List list_goods_warehouse() throws DataAccessException;
	 public List DownList_goods_warehouse(String pr_NO) throws DataAccessException;
	 public List findDate_goods_warehouse(Goods_WarehouseVO goods_warehouseVO) throws DataAccessException;
	 public int add_goods_warehouse(Goods_WarehouseVO goods_warehouseVO) throws DataAccessException;
	 public int mod_goods_warehouse(Goods_WarehouseVO goods_warehouseVO) throws DataAccessException;
	 public int rem_goods_warehouse(String pr_NO) throws DataAccessException;
}
