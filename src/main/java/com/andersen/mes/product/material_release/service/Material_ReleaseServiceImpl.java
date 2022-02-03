package com.andersen.mes.product.material_release.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andersen.mes.product.material_release.vo.Material_ReleaseVO;
import com.andersen.mes.product.material_release.dao.Material_ReleaseDAO;

@Service("material_releaseService")
public class Material_ReleaseServiceImpl implements Material_ReleaseService {
	@Autowired
	private Material_ReleaseDAO material_releaseDAO;

	@Override
	public List main_material_release() throws DataAccessException {
		List mainList = null;
		mainList = material_releaseDAO.selectAllMaterial_ReleaseUpList();
		return mainList;
	}
	
	@Override
	public List DownList_material_release(String mr_NO) throws DataAccessException {
		List downList = null;
		downList = material_releaseDAO.searchMr_noDownList(mr_NO);
		return downList;
	}
	
	@Override
	public List findDate_material_release(Material_ReleaseVO material_releaseVO) throws DataAccessException {
		List findList = null;
		findList = material_releaseDAO.searchDateUpList(material_releaseVO);
		return findList;
	}
	
	@Override
	public List popList_material_release(Material_ReleaseVO material_releaseVO) throws DataAccessException {
		List popList = null;
		popList = material_releaseDAO.searchDatePopList(material_releaseVO);
		return popList;
	}
	
	@Override
	public int addUpList_pop_material(String mr_NO) throws DataAccessException {
		return material_releaseDAO.insertUpPop_Material_Release(mr_NO);
	}
	
	@Override
	public int addDownList_pop_material(Material_ReleaseVO material_releaseVO) throws DataAccessException {
		return material_releaseDAO.insertDownPop_Material_Release(material_releaseVO);
	}
	
	@Override
	public int add_material_release(Material_ReleaseVO material_releaseVO) throws DataAccessException {
		return material_releaseDAO.insertMaterial_Release(material_releaseVO);
	}
	
	@Override
	public int mod_material_release(Material_ReleaseVO material_releaseVO) throws DataAccessException {
		return material_releaseDAO.updateMaterial_Release(material_releaseVO);
	}
	
	@Override
	public int rem_material_release(String mr_NO) throws DataAccessException {
		return material_releaseDAO.deleteMaterial_Release(mr_NO);
	}
}
