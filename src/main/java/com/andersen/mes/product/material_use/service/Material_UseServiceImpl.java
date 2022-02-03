package com.andersen.mes.product.material_use.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.andersen.mes.product.material_use.vo.Material_UseVO;
import com.andersen.mes.product.material_use.dao.Material_UseDAO;

@Service("material_useService")
public class Material_UseServiceImpl implements Material_UseService{

	@Autowired
	private Material_UseDAO material_useDAO;

	@Override
	public List main_material_use() throws DataAccessException {
		List mainList = null;
		mainList = material_useDAO.selectAllMaterial_UseUpList();
		return mainList;
	}
	
	@Override
	public List DownList_material_use(String pr_NO) throws DataAccessException {
		List downList = null;
		downList = material_useDAO.searchPr_noDownList(pr_NO);
		return downList;
	}
	
	@Override
	public List findDate_material_use(Material_UseVO material_useVO) throws DataAccessException {
		List findList = null;
		findList = material_useDAO.searchDateUpList(material_useVO);
		return findList;
	}
	
	@Override
	public int add_material_use(Material_UseVO material_useVO) throws DataAccessException {
		return material_useDAO.insertMaterial_Use(material_useVO);
	}
	
	@Override
	public int mod_material_use(Material_UseVO material_useVO) throws DataAccessException {
		return material_useDAO.updateMaterial_Use(material_useVO);
	}
	
	@Override
	public int rem_material_use(Material_UseVO material_useVO) throws DataAccessException {
		return material_useDAO.deleteMaterial_Use(material_useVO);
	}
}
