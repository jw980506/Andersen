package com.andersen.mes.information.item.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.andersen.mes.information.item.service.ItemService;

@Controller("itemController")
public class ItemControllerImpl implements ItemController {

	@Autowired
	private ItemService itemService;
	
	@Override
	@RequestMapping(value = "/itemsList.do", method = RequestMethod.GET)
	public ModelAndView itemAllList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List listAllItem = itemService.itemAllList();
		
		ModelAndView mav = new ModelAndView("/itemsList");		
		mav.addObject("listAllItem", listAllItem);			
		
		return mav;
	}

}
