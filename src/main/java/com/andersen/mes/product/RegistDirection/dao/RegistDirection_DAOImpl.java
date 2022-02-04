package com.andersen.mes.product.RegistDirection.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.andersen.mes.product.ProductPlanning.vo.ProductPlanning_VO;
import com.andersen.mes.product.RegistDirection.dto.RegistDirection_DTO;

@Repository("RegistDirection_DAO")
public class RegistDirection_DAOImpl implements RegistDirection_DAO {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private RegistDirection_DTO registdirection_dto;

	@Override
	public List POPUP_List() throws DataAccessException {
		List<RegistDirection_DTO> POPUP_List = null;
		POPUP_List =
				sqlSession.selectList("mapper.product.registdirection.Find_POPUP_List");
		return POPUP_List;
	}
	
	@Override
	public List After_POPUP_List(String pp_no) throws DataAccessException{
		pp_no = registdirection_dto.getPp_NO();
				
		List<RegistDirection_DTO> After_POPUP_List = null;
		
		After_POPUP_List = 
				sqlSession.selectList("mapper.product.registdirection.After_POPUP_List", pp_no);

		return After_POPUP_List;
	}
}
