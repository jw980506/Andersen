package com.andersen.mes.product.material_release.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.andersen.mes.product.material_release.vo.Material_ReleaseVO;

public interface Material_ReleaseService {
	
	 public List main_material_release() throws DataAccessException;
//	 public List list_material_release() throws DataAccessException;
	 public List DownList_material_release(String pr_NO) throws DataAccessException;
	 public List findDate_material_release(Material_ReleaseVO material_releaseVO) throws DataAccessException;
	 public List popList_material_release(Material_ReleaseVO material_releaseVO) throws DataAccessException;
	 public int addUpList_pop_material(String mr_NO) throws DataAccessException;
	 public int addDownList_pop_material(Material_ReleaseVO material_releaseVO) throws DataAccessException;
	 public int add_material_release(Material_ReleaseVO material_releaseVO) throws DataAccessException;
	 public int mod_material_release(Material_ReleaseVO material_releaseVO) throws DataAccessException;
	 public int rem_material_release(String mr_NO) throws DataAccessException;
}
