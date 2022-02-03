package com.andersen.mes.product.direction_deadline.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.andersen.mes.product.direction_deadline.vo.Direction_DeadlineVO;

@Repository("direction_deadlineDAO")
public class Direction_DeadlineDAOImpl implements Direction_DeadlineDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllDirection_DeadlineUpList() throws DataAccessException {
		List<Direction_DeadlineVO> mainList = null;
		mainList = sqlSession.selectList("mapper.product.direction.selectAllDirection_DeadlineUpList");
		return mainList;
	}
	
	@Override
	public List searchDateUpList(Direction_DeadlineVO direction_deadlineVO) throws DataAccessException {
		List<Direction_DeadlineVO> findList = null;
		findList = sqlSession.selectList("mapper.product.direction.searchDateUpList", direction_deadlineVO);
		return findList;
	}
	
	@Override
	public int updateDirection_Deadline(String rd_NO) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.direction.updateDirection_Deadline", rd_NO);
		return result;
	}
	
	@Override
	public int updateBackDirection_Deadline(String rd_NO) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.direction.updateBackDirection_Deadline", rd_NO);
		return result;
	}
}
