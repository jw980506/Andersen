package com.andersen.mes.information.item.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.andersen.mes.information.item.vo.ItemVO;

public class ItemDAOImpl implements ItemDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List selectAllItemList() throws DataAccessException {
		
		List<ItemVO> listAllItem = null;
		listAllItem = sqlSession.selectList("mapper.information.employee.selectAllItemList");
		return listAllItem;
	}

	@Override
	public void addOneItem(ItemVO itemVO) throws DataAccessException {
		
	}

	@Override
	public void modOneItem(ItemVO itemVO) throws DataAccessException {
		
	}

	@Override
	public void delOneItem(String itemNo) throws DataAccessException {
		
	}
	
}
