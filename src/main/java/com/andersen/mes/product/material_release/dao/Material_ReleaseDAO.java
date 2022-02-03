package com.andersen.mes.product.material_release.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.andersen.mes.product.material_release.vo.Material_ReleaseVO;

public interface Material_ReleaseDAO {
	
	 public List selectAllMaterial_ReleaseUpList() throws DataAccessException;
//	 public List selectAllMaterial_ReleaseDownList() throws DataAccessException;
	 public List searchMr_noDownList(String mr_NO) throws DataAccessException;
	 public List searchDateUpList(Material_ReleaseVO material_releaseVO) throws DataAccessException;
	 public List searchDatePopList(Material_ReleaseVO material_releaseVO) throws DataAccessException;
	 public int insertUpPop_Material_Release(String mr_NO) throws DataAccessException ;
	 public int insertDownPop_Material_Release(Material_ReleaseVO material_releaseVO) throws DataAccessException ;
	 public int insertMaterial_Release(Material_ReleaseVO material_releaseVO) throws DataAccessException ;
	 public int updateMaterial_Release(Material_ReleaseVO material_releaseVO) throws DataAccessException ;
	 public int deleteMaterial_Release(String mr_NO) throws DataAccessException;
}
