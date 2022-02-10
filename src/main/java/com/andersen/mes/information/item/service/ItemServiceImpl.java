package com.andersen.mes.information.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.andersen.mes.information.item.dao.ItemDAO;
import com.andersen.mes.information.item.vo.ItemVO;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDAO itemDAO;
	
	@Override
	public List itemAllList() throws DataAccessException {
		
		List listAllItem = null;
		listAllItem = itemDAO.selectAllItemList();
		return listAllItem;		
	}

	@Override
	public void addItem(ItemVO itemVO) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modItem(ItemVO itemVO) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delItem(String itemNo) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
