package com.andersen.mes.product.goods_warehouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.andersen.mes.product.goods_warehouse.dao.Goods_WarehouseDAO;
import com.andersen.mes.product.goods_warehouse.vo.Goods_WarehouseVO;
import com.andersen.mes.product.performance_registration.vo.Performance_RegistrationVO;

@Service("goods_warehouseService")
public class Goods_WarehouseServiceImpl implements Goods_WarehouseService {

	@Autowired
	private Goods_WarehouseDAO goods_warehouseDAO;

	@Override
	public List main_goods_warehouse() throws DataAccessException {
		List mainList = null;
		mainList = goods_warehouseDAO.selectAllGoods_WarehouseUpList();
		return mainList;
	}
	
	@Override
	public List list_goods_warehouse() throws DataAccessException {
		List downList = null;
		downList = goods_warehouseDAO.selectAllGoods_WarehouseDownList();
		return downList;
	}
	
	@Override
	public List DownList_goods_warehouse(String pr_NO) throws DataAccessException {
		List downList = null;
		downList = goods_warehouseDAO.searchPr_noDownList(pr_NO);
		return downList;
	}
	
	@Override
	public List findDate_goods_warehouse(Goods_WarehouseVO goods_warehouseVO) throws DataAccessException {
		List findList = null;
		findList = goods_warehouseDAO.searchDateUpList(goods_warehouseVO);
		return findList;
	}
	
	@Override
	public int add_goods_warehouse(Goods_WarehouseVO goods_warehouseVO) throws DataAccessException {
		return goods_warehouseDAO.insertGoods_Warehouse(goods_warehouseVO);
	}
	
	@Override
	public int mod_goods_warehouse(Goods_WarehouseVO goods_warehouseVO) throws DataAccessException {
		return goods_warehouseDAO.updateGoods_Warehouse(goods_warehouseVO);
	}
	
	@Override
	public int rem_goods_warehouse(String pr_NO) throws DataAccessException {
		return goods_warehouseDAO.deleteGoods_Warehouse(pr_NO);
	}
}
