package com.andersen.mes.product.goods_warehouse.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.andersen.mes.product.goods_warehouse.vo.Goods_WarehouseVO;
import com.andersen.mes.product.performance_registration.vo.Performance_RegistrationVO;

@Repository("goods_warehouseDAO")
public class Goods_WarehouseDAOImpl implements Goods_WarehouseDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllGoods_WarehouseUpList() throws DataAccessException {
		List<Goods_WarehouseVO> mainList = null;
		mainList = sqlSession.selectList("mapper.product.goods.selectAllGoods_WarehouseUpList");
		return mainList;
	}
	
	@Override
	public List selectAllGoods_WarehouseDownList() throws DataAccessException {
		List<Goods_WarehouseVO> downList = null;
		downList = sqlSession.selectList("mapper.product.goods.selectAllGoods_WarehouseDownList");
		return downList;
	}
	
	@Override
	public List searchPr_noDownList(String pr_NO) throws DataAccessException {
		List<Goods_WarehouseVO> findList = null;
		findList = sqlSession.selectList("mapper.product.goods.searchPr_noDownList", pr_NO);
		return findList;
	}
	
	@Override
	public List searchDateUpList(Goods_WarehouseVO goods_warehouseVO) throws DataAccessException {
		List<Performance_RegistrationVO> findList = null;
		findList = sqlSession.selectList("mapper.product.goods.searchDateUpList", goods_warehouseVO);
		return findList;
	}
	
	@Override
	public int insertGoods_Warehouse(Goods_WarehouseVO goods_warehouseVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.goods.insertGoods_Warehouse", goods_warehouseVO);
		return result;
	}
	
	@Override
	public int updateGoods_Warehouse(Goods_WarehouseVO goods_warehouseVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.goods.updateGoods_Warehouse", goods_warehouseVO);
		return result;
	}
	
	@Override
	public int deleteGoods_Warehouse(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.product.goods.deleteGoods_Warehouse", id);
		return result;
	}
}
