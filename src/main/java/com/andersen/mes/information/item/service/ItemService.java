package com.andersen.mes.information.item.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.andersen.mes.information.item.vo.ItemVO;

public interface ItemService {
	
	public List itemAllList() throws DataAccessException;
	
	public void addItem(ItemVO itemVO) throws DataAccessException;
	
	public void modItem(ItemVO itemVO) throws DataAccessException;
	
	public void delItem(String itemNo) throws DataAccessException;
}
