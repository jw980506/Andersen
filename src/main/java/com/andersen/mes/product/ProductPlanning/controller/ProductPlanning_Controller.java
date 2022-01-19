package com.andersen.mes.product.ProductPlanning.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public interface ProductPlanning_Controller {
	public ModelAndView ProductPlanning_ItemList (HttpServletRequest request, HttpServletResponse response) throws Exception; //생산계획등록 품목 출력
	
	public ModelAndView ProductPlanning_Item_Plan(@RequestParam(value="tdArr[]")List<String> Search_Plan, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView ProductPlanning_Item_List_Search(@RequestParam("_itemno2") String _itemno2,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView ProductPlanning_ADD_Plan_List(@RequestParam(value="tdArr[]") List<String> add_Plan, 
				HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView ProductPlanning_MOD_Plan_List(@RequestParam(value="tdArr[]") List<String> mod_Plan, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView ProductPlanning_Item_Plan_List
	(@Param("_itemno") String _itemno,
		@Param("_itemno2") String _itemno2,
			HttpServletRequest request, HttpServletResponse response) 
	throws Exception;
	
	public ModelAndView ProductPlanning_DEL_Plan_List(@RequestParam(value="tdArr[]") List<String> del_Plan, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	
 	
}

	



