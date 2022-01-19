package com.andersen.mes.product.ProductPlanning.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.andersen.mes.product.ProductPlanning.dto.ProductPlanning_DTO;
import com.andersen.mes.product.ProductPlanning.vo.ProductPlanning_VO;


@Repository("ProductPlanning_DAO")
public class ProductPlanning_DAOImpl implements ProductPlanning_DAO{
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private ProductPlanning_DTO productplanning_dto;
	
	@Override
	//생산계획등록 품목 리스트 출력
	public List Find_ItemList_All() throws DataAccessException {
		List<ProductPlanning_VO> ProductPlanning_ItemList = null;
		ProductPlanning_ItemList = sqlSession.selectList("mapper.product.productplanning.Find_ProductPlanning_ItemList_All");
		return ProductPlanning_ItemList;
	}
	
	@Override
	public List Total_Plan_List() throws DataAccessException{
		List<ProductPlanning_VO> Total_Plan_List = null;
		Total_Plan_List = sqlSession.selectList("mapper.product.productplanning.Total_Plan_List");
		return Total_Plan_List;
	}
	
	
	@Override
	public List<ProductPlanning_VO> ProductPlanning_Item_Plan_List(String itemno) throws DataAccessException{
		itemno = productplanning_dto.getItemNO();
		
		List<ProductPlanning_VO> ProductPlanning_Item_Plan_List =
				sqlSession.selectList
				("mapper.product.productplanning.Find_ProductPlanning_Item_Plan_List_All", itemno);
				
		return ProductPlanning_Item_Plan_List;
	}

	@Override
	public List<ProductPlanning_VO> ProductPlanning_Item_Search_List(String itemno2) throws DataAccessException {
		itemno2 = productplanning_dto.getItemNO2();
		
		List<ProductPlanning_VO> ProductPlanning_Item_Search_List =
				sqlSession.selectList
				("mapper.product.productplanning.Find_ProductPlanning_Item_Search_List", itemno2);
		
		return ProductPlanning_Item_Search_List;
	}

	@Override
	public int ADD_Plan_List(ProductPlanning_DTO productplanning_dto) throws DataAccessException {

		int result = sqlSession.insert("mapper.product.productplanning.ADD_PrdouctPlanning_Plan_List", productplanning_dto);
		
		return result;
	}
	
	@Override
	public int MOD_Plan_List(ProductPlanning_DTO productplanning_dto) throws DataAccessException {

		int result = sqlSession.insert("mapper.product.productplanning.MOD_PrdouctPlanning_Plan_List", productplanning_dto);
		
		return result;
	}
	
	@Override
	public int DEL_Plan_List(String pp_no) throws DataAccessException {
		pp_no = productplanning_dto.getPp_NO();

		int result = sqlSession.insert("mapper.product.productplanning.DEL_ProductPlanning_Plan_List", pp_no);
		
		return result;
	}
	
	
}
