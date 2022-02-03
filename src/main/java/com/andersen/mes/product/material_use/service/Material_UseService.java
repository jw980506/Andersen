package com.andersen.mes.product.material_use.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.andersen.mes.product.material_use.vo.Material_UseVO;

public interface Material_UseService {
	
	 public List main_material_use() throws DataAccessException;
	 public List DownList_material_use(String pr_NO) throws DataAccessException;
	 public List findDate_material_use(Material_UseVO material_useVO) throws DataAccessException;
	 public int add_material_use(Material_UseVO material_useVO) throws DataAccessException;
	 public int mod_material_use(Material_UseVO material_useVO) throws DataAccessException;
	 public int rem_material_use(Material_UseVO material_useVO) throws DataAccessException;
}
