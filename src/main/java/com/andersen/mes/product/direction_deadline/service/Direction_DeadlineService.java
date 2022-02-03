package com.andersen.mes.product.direction_deadline.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.andersen.mes.product.direction_deadline.vo.Direction_DeadlineVO;

public interface Direction_DeadlineService {
	 public List main_direction_deadline() throws DataAccessException;
	 public List findDate_direction_deadline(Direction_DeadlineVO direction_deadlineVO) throws DataAccessException;
	 public int mod_direction_deadline(String rd_NO) throws DataAccessException;
	 public int modNot_direction_deadline(String rd_NO) throws DataAccessException;
}
