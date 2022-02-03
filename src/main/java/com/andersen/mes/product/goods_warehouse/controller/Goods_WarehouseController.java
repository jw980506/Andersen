package com.andersen.mes.product.goods_warehouse.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface Goods_WarehouseController {

	public ModelAndView main_goods_warehouse(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView findDate_goods_warehouse(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView add_goods_warehouse(@RequestParam(value="tdArr[]") List<String> addList, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView mod_goods_warehouse(@RequestParam(value="tdArr[]") List<String> modList, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView rem_goods_warehouse(@RequestParam(value="tdArr[]") List<String> remList, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
