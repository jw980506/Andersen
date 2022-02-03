package com.andersen.mes.product.material_release.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.andersen.mes.product.material_release.vo.Material_ReleaseVO;

@Repository("material_releaseDAO")
public class Material_ReleaseDAOImpl implements Material_ReleaseDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllMaterial_ReleaseUpList() throws DataAccessException {
		List<Material_ReleaseVO> mainList = null;
		mainList = sqlSession.selectList("mapper.product.material_r.selectAllMaterial_ReleaseUpList");
		return mainList;
	}
	
//	@Override
//	public List selectAllMaterial_ReleaseDownList() throws DataAccessException {
//		List<Material_UseVO> downList = null;
//		downList = sqlSession.selectList("mapper.product.material.selectAllMaterial_UseDownList");
//		return downList;
//	}
	
	@Override
	public List searchMr_noDownList(String mr_NO) throws DataAccessException {
		List<Material_ReleaseVO> downList = null;
		downList = sqlSession.selectList("mapper.product.material_r.searchMr_noDownList", mr_NO);
		return downList;
	}
	
	@Override
	public List searchDateUpList(Material_ReleaseVO material_releaseVO) throws DataAccessException {
		List<Material_ReleaseVO> findList = null;
		findList = sqlSession.selectList("mapper.product.material_r.searchDateUpList", material_releaseVO);
		return findList;
	}
	
	@Override
	public List searchDatePopList(Material_ReleaseVO material_releaseVO) throws DataAccessException {
		List<Material_ReleaseVO> popList = null;
		popList = sqlSession.selectList("mapper.product.material_r.searchDatePopList", material_releaseVO);
		return popList;
	}
	
	@Override
	public int insertUpPop_Material_Release(String mr_NO) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.material_r.insertUpPop_Material_Release", mr_NO);
		return result;
	}
	
	@Override
	public int insertDownPop_Material_Release(Material_ReleaseVO material_releaseVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.material_r.insertDownPop_Material_Release", material_releaseVO);
		return result;
	}
	
	@Override
	public int insertMaterial_Release(Material_ReleaseVO material_releaseVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.material_r.insertMaterial_Release", material_releaseVO);
		return result;
	}
	
	@Override
	public int updateMaterial_Release(Material_ReleaseVO material_releaseVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.material_r.updateMaterial_Release", material_releaseVO);
		return result;
	}
	
	@Override
	public int deleteMaterial_Release(String mr_NO) throws DataAccessException {
		int result = sqlSession.insert("mapper.product.material_r.deleteMaterial_Release", mr_NO);
		return result;
	}
}
