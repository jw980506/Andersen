package com.andersen.mes.product.material_use.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.andersen.mes.product.material_use.vo.Material_UseVO;
import com.andersen.mes.product.performance_registration.vo.Performance_RegistrationVO;

@Repository("material_useDAO")
public class Material_UseDAOImpl implements Material_UseDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllMaterial_UseUpList() throws DataAccessException {
		List<Material_UseVO> mainList = null;
		mainList = sqlSession.selectList("mapper.product.material.selectAllMaterial_UseUpList");
		return mainList;
	}
	
//	@Override
//	public List selectAllMaterial_UseDownList() throws DataAccessException {
//		List<Material_UseVO> downList = null;
//		downList = sqlSession.selectList("mapper.product.material.selectAllMaterial_UseDownList");
//		return downList;
//	}
	
	@Override
	public List searchPr_noDownList(String pr_NO) throws DataAccessException {
		List<Material_UseVO> downList = null;
		downList = sqlSession.selectList("mapper.product.material.searchPr_noDownList", pr_NO);
		return downList;
	}
	
	@Override
	public List searchDateUpList(Material_UseVO material_useVO) throws DataAccessException {
		List<Material_UseVO> findList = null;
		findList = sqlSession.selectList("mapper.product.material.searchDateUpList", material_useVO);
		return findList;
	}
	
	@Override
	public int insertMaterial_Use(Material_UseVO material_useVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.material.insertMaterial_Use", material_useVO);
		return result;
	}
	
	@Override
	public int updateMaterial_Use(Material_UseVO material_useVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.material.updateMaterial_Use", material_useVO);
		return result;
	}
	
	@Override
	public int deleteMaterial_Use(Material_UseVO material_useVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.material.deleteMaterial_Use", material_useVO);
		return result;
	}
}
