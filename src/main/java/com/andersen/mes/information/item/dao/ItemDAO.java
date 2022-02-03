package com.andersen.mes.information.item.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.andersen.mes.information.item.vo.ItemVO;

public interface ItemDAO {

	public List selectAllItemList() throws DataAccessException;
	
	public void addOneItem(ItemVO itemVO) throws DataAccessException;
	
	public void modOneItem(ItemVO itemVO) throws DataAccessException;
	
	public void delOneItem(String itemNo) throws DataAccessException;
}