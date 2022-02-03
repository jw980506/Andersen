package com.andersen.mes.product.direction_deadline.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.andersen.mes.product.direction_deadline.vo.Direction_DeadlineVO;

public interface Direction_DeadlineDAO {
	
	 public List selectAllDirection_DeadlineUpList() throws DataAccessException;
	 public List searchDateUpList(Direction_DeadlineVO direction_deadlineVO) throws DataAccessException;
	 public int updateDirection_Deadline(String rd_NO) throws DataAccessException ;
	 public int updateBackDirection_Deadline(String rd_NO) throws DataAccessException ;
}
