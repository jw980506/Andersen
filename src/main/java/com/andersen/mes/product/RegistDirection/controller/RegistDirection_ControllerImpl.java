package com.andersen.mes.product.RegistDirection.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.andersen.mes.product.ProductPlanning.vo.ProductPlanning_VO;
import com.andersen.mes.product.RegistDirection.dto.RegistDirection_DTO;
import com.andersen.mes.product.RegistDirection.service.RegistDirection_Service;
import com.andersen.mes.product.RegistDirection.vo.RegistDirection_VO;

@Controller("RegistDirection_Controller")
public class RegistDirection_ControllerImpl implements RegistDirection_Controller {
	@Autowired
	private RegistDirection_Service registdirection_service;
	@Autowired
	private RegistDirection_DTO registdirection_dto;
	@Autowired
	private RegistDirection_VO registdirection_vo;


	@RequestMapping(value = "/RegistDirection.do", method = RequestMethod.GET)
	public ModelAndView RegistDirection_List(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = getViewName(request);
		System.out.println(viewName);		
		
//		List ProductPlanning_ItemList = productplanning_service.ProductPlanning_ItemList();
		
		ModelAndView mav = new ModelAndView(viewName);
		
//		mav.addObject("ProductPlanning_ItemList", ProductPlanning_ItemList);
				
		return mav;
	}
	
	@RequestMapping(value = "/RegistDirection2.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView AfterPOP_RegistDirection_List(@Param(value="itemno") String itemno,
					HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("2로 옴?");
	
//		itemno = registdirection_dto.getItemNO();
		
//		System.out.println("2페이지 번호 : " + itemno);
				
		
		String viewName = getViewName(request);
		System.out.println(viewName);		
		
		List After_POPUP_List = registdirection_service.After_POPUP_List(itemno);
		
		ModelAndView mav = new ModelAndView(viewName);
//		System.out.println(mav);
		
		mav.addObject("After_POPUP_List", After_POPUP_List);
				
		return mav;
	}
	
	@RequestMapping(value = "/POP_TO_REGI.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView POP_TO_REGI(@RequestParam(value="tdArr[]") List<String> plan_list,
				HttpServletRequest request, HttpServletResponse response)
						throws Exception {
		
		String viewName = getViewName(request);
		System.out.println(viewName);		
		
		String itemno = plan_list.get(0);
		String itemname = plan_list.get(1);
		String stockunit = plan_list.get(2);
		int pp_quantity = Integer.parseInt(plan_list.get(3));
		String string_pp_Schedule = plan_list.get(4);
		String pp_no = plan_list.get(5);
		
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd"); //날짜 변환 
		Date to = fm.parse(string_pp_Schedule); //to에 날짜 변환한 거 담기
		
		System.out.println(itemno);
		System.out.println(itemname);
		System.out.println(stockunit);
		System.out.println(pp_quantity);
		System.out.println(to);
		System.out.println(pp_no);
		
		registdirection_dto.setItemNO(itemno);
		registdirection_dto.setItem_Name(itemname);
		registdirection_dto.setStockUnit(stockunit);
		registdirection_dto.setPp_Quantity(pp_quantity);
		registdirection_dto.setPp_Schedule(to);
		registdirection_dto.setPp_NO(pp_no);
	
		ModelAndView mav = new ModelAndView("redirect:/RegistDirection2.do");
		
		mav.addObject("itemno", itemno);
		mav.addObject("itemname", itemname);
				
		return mav;
	}
	
	@RequestMapping(value = "/showpop.do",  method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView RegistDirection_POPUP(HttpServletRequest request, HttpServletResponse response)
						throws Exception {	

		String viewName = getViewName(request);
		System.out.println(viewName);	

		Date a = registdirection_dto.getDate1();
		Date b = registdirection_dto.getDate2();
		System.out.println(a);
		
		ModelAndView mav = new ModelAndView(viewName);
		
		if(a==null && b==null) {
			System.out.println("여기로 오나? 널이 아니라서");
			List POPUP_List = registdirection_service.POPUP_List();
			System.out.println("컨트롤러 팝업 리스트 : " + POPUP_List);
			
			
			mav.addObject("POPUP_List", POPUP_List);
		}
		
		if(a!=null && b!=null) {
			System.out.println("asd");
		}
	return mav;
	}
	
	@RequestMapping(value ="/search_by_Date.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Search_Date_POP(
			@RequestParam(value="_date1") String date1,
				@RequestParam(value="_date2") String date2,
					HttpServletRequest request, HttpServletResponse response)
						throws Exception {
		System.out.println("조회버튼 이후 컨트롤러");
		String bef_date1 = date1;
		String bef_date2 = date2;

		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd"); //날짜 변환 
		Date to = fm.parse(bef_date1); //to에 날짜 변환한 거 담기
		Date to2 = fm.parse(bef_date2); //to에 날짜 변환한 거 담기
		
		registdirection_dto.setDate1(null);
		registdirection_dto.setDate2(null);
		registdirection_dto.setDate1(to);
		registdirection_dto.setDate2(to2);
		
		ModelAndView mav = new ModelAndView("redirect:/showpop.do");
		
		return mav;
	
	}
	

	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}
}
