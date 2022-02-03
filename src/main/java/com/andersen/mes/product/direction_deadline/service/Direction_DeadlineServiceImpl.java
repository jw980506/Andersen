package com.andersen.mes.product.direction_deadline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.andersen.mes.product.direction_deadline.dao.Direction_DeadlineDAO;
import com.andersen.mes.product.direction_deadline.vo.Direction_DeadlineVO;

@Service("direction_deadlineService")
public class Direction_DeadlineServiceImpl implements Direction_DeadlineService {
	@Autowired
	private Direction_DeadlineDAO direction_deadlineDAO;

	@Override
	public List main_direction_deadline() throws DataAccessException {
		List mainList = null;
		mainList = direction_deadlineDAO.selectAllDirection_DeadlineUpList();
		return mainList;
	}
	
	@Override
	public List findDate_direction_deadline(Direction_DeadlineVO direction_deadlineVO) throws DataAccessException {
		List findList = null;
		findList = direction_deadlineDAO.searchDateUpList(direction_deadlineVO);
		return findList;
	}
	
	@Override
	public int mod_direction_deadline(String rd_NO) throws DataAccessException {
		return direction_deadlineDAO.updateDirection_Deadline(rd_NO);
	}
	
	@Override
	public int modNot_direction_deadline(String rd_NO) throws DataAccessException {
		return direction_deadlineDAO.updateBackDirection_Deadline(rd_NO);
	}
}
