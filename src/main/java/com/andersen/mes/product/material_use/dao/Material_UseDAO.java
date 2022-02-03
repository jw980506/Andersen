package com.andersen.mes.product.material_use.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.andersen.mes.product.material_use.vo.Material_UseVO;

public interface Material_UseDAO {

	 public List selectAllMaterial_UseUpList() throws DataAccessException;
//	 public List selectAllMaterial_UseDownList() throws DataAccessException;
	 public List searchPr_noDownList(String pr_NO) throws DataAccessException;
	 public List searchDateUpList(Material_UseVO material_useVO) throws DataAccessException;
	 public int insertMaterial_Use(Material_UseVO material_useVO) throws DataAccessException ;
	 public int updateMaterial_Use(Material_UseVO material_useVO) throws DataAccessException ;
	 public int deleteMaterial_Use(Material_UseVO material_useVO) throws DataAccessException;

}
