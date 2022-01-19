package com.andersen.mes.product.ProductPlanning.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.andersen.mes.product.ProductPlanning.dto.ProductPlanning_DTO;
import com.andersen.mes.product.ProductPlanning.service.ProductPlanning_Service;
import com.andersen.mes.product.ProductPlanning.vo.ProductPlanning_VO;

@Controller("ProductPlanning_Controller")
public class ProductPlanning_ControllerImpl implements ProductPlanning_Controller {
	@Autowired
	private ProductPlanning_Service productplanning_service;
	@Autowired
	private ProductPlanning_VO productplanning_vo;
	@Autowired
	private ProductPlanning_DTO productplanning_dto;
	
	  private static final Logger logger = LoggerFactory.getLogger(ProductPlanning_ControllerImpl.class);
	  
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public String home(Locale locale, Model model) {
	    logger.info("Welcome home! The client locale is {}.", locale);

	    Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, 
	    DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
	    return "home";
	  }

	// 품목 리스트 요청
	@Override
	@RequestMapping(value = "/ProductPlanning.do", method = RequestMethod.GET)
	public ModelAndView ProductPlanning_ItemList(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = getViewName(request);
		System.out.println(viewName);		
		
		List ProductPlanning_ItemList = productplanning_service.ProductPlanning_ItemList();
		
		ModelAndView mav = new ModelAndView(viewName);
		
		mav.addObject("ProductPlanning_ItemList", ProductPlanning_ItemList);
				
		return mav;
	}
	
	
	@Override
	@RequestMapping(value = "/SelectItem_Plan.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView ProductPlanning_Item_Plan(@RequestParam(value="tdArr[]")List<String> Search_Plan, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{		
		
		String viewName = getViewName(request);
		System.out.println(viewName);	
		
		productplanning_dto.setItemNO2(null); //검색결과 초기화

		String _itemno = Search_Plan.get(0);
		String _itemname = Search_Plan.get(1);
		String _stockunit = Search_Plan.get(2);
		double _dayproduction = Double.parseDouble(Search_Plan.get(3));
		
		productplanning_dto.setItemNO(null);
		productplanning_dto.setItem_Name(null);
		productplanning_dto.setStockUnit(null);
		productplanning_dto.setDayProduction(0);
		
		productplanning_dto.setItemNO(_itemno);
		productplanning_dto.setItem_Name(_itemname);
		productplanning_dto.setStockUnit(_stockunit);
		productplanning_dto.setDayProduction(_dayproduction);
				
		ModelAndView mav = new ModelAndView("redirect:/ProductPlanning_Plan.do");
		mav.addObject("_itemno", _itemno);
	
		return mav;
	}
	

	@Override	
	@RequestMapping(value="/search_by_itemNO.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView ProductPlanning_Item_List_Search(@RequestParam("_itemno2") String _itemno2,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = getViewName(request);
		System.out.println(viewName);	
		
		productplanning_dto.setItemNO(null);
		productplanning_dto.setItemNO2(null);
		productplanning_dto.setItemNO(_itemno2);
		productplanning_dto.setItemNO2(_itemno2);
		
		ModelAndView mav = new ModelAndView("redirect:/ProductPlanning_Plan.do");
		mav.addObject("_itemno2", _itemno2);
		
		return mav;
	}
	
	@Override
	@RequestMapping(value="/Add_Plan.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView ProductPlanning_ADD_Plan_List(@RequestParam(value="tdArr[]") List<String> add_Plan, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = getViewName(request);
		System.out.println(viewName);	
				
		int pp_Sequence = Integer.parseInt(add_Plan.get(0));
		String string_Schedule = add_Plan.get(1); //날짜
		int pp_quantity = Integer.parseInt(add_Plan.get(2));
		String emp_Name = add_Plan.get(3);
		
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd"); //날짜 변환 
		Date to = fm.parse(string_Schedule); //to에 날짜 변환한 거 담기
		
		productplanning_dto.setPp_Sequence(pp_Sequence);
		productplanning_dto.setPp_Schedule(to); //변환된 날짜 set해주기
		productplanning_dto.setPp_Quantity(pp_quantity);
		productplanning_dto.setEmp_Name(emp_Name);
		
		String _itemno = productplanning_dto.getItemNO();
		productplanning_dto.setItemNO(_itemno);
		
		String _itemname = productplanning_dto.getItem_Name();
		productplanning_dto.setItem_Name(_itemname);
		
		String _stockunit = productplanning_dto.getStockUnit();
		productplanning_dto.setStockUnit(_stockunit);
		
		double _dayproduction = productplanning_dto.getDayProduction();
		productplanning_dto.setDayProduction(_dayproduction);
		
		//생산계획등록 번호 자동 생성
		
		List Total_Plan_List = productplanning_service.Total_Plan_List();
		
		int ad = Total_Plan_List.size();
					
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		Calendar c1 = Calendar.getInstance();
		String strToday = sdf.format(c1.getTime());
				
		String auto_pp_NO = "pp" + strToday + "000" + ad;

		productplanning_dto.setPp_NO(auto_pp_NO);
		
		int result = 0;
		result = productplanning_service.ADD_Plan_List(productplanning_dto);
		ModelAndView mav = new ModelAndView("redirect:/ProductPlanning_Plan.do");
		
		return mav;
	}
	
	@Override
	@RequestMapping(value="/Mod_Plan.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView ProductPlanning_MOD_Plan_List(@RequestParam(value="tdArr[]") List<String> mod_Plan, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = getViewName(request);
		System.out.println(viewName);	
				
		int pp_Sequence = Integer.parseInt(mod_Plan.get(0));
		String string_Schedule = mod_Plan.get(1); //날짜
		int pp_quantity = Integer.parseInt(mod_Plan.get(2));
		String emp_Name = mod_Plan.get(3);
		String pp_no = mod_Plan.get(4);
		
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd"); //날짜 변환 
		Date to = fm.parse(string_Schedule); //to에 날짜 변환한 거 담기
		
		productplanning_dto.setPp_Sequence(pp_Sequence);
		productplanning_dto.setPp_Schedule(to); //변환된 날짜 set해주기
		productplanning_dto.setPp_Quantity(pp_quantity);
		productplanning_dto.setEmp_Name(emp_Name);
		productplanning_dto.setPp_NO(pp_no);
		
		int result = 0;
		result = productplanning_service.MOD_Plan_List(productplanning_dto);
		ModelAndView mav = new ModelAndView("redirect:/ProductPlanning_Plan.do");
		
		return mav;
	}
	
	@RequestMapping(value="/Del_Plan.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView ProductPlanning_DEL_Plan_List(@RequestParam(value="tdArr[]") List<String> del_Plan, 
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("del컨");
		String viewName = getViewName(request);
		System.out.println(viewName);	
		
		productplanning_dto.setPp_NO(null);
				
		String pp_no = del_Plan.get(0);
		
		productplanning_dto.setPp_NO(pp_no);
		
		int result = 0;
		result = productplanning_service.DEL_Plan_List(pp_no);
		ModelAndView mav = new ModelAndView("redirect:/ProductPlanning_Plan.do");
		
		return mav;
	}
	
	
	
	@Override
	@RequestMapping(value="/ProductPlanning_Plan.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView ProductPlanning_Item_Plan_List
	(@Param("_itemno") String _itemno,
		@Param("_itemno2") String _itemno2,
			HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
		String viewName = getViewName(request);
		System.out.println(viewName);	
		
		ModelAndView mav = new ModelAndView(viewName);
		
		_itemno = productplanning_dto.getItemNO(); //체크박스 값
		_itemno2 = productplanning_dto.getItemNO2(); //검색결과 값

		//체크박스랑 검색결과가 다르면
		if(!(_itemno.equals(_itemno2))) {
			List ProductPlanning_ItemList = productplanning_service.ProductPlanning_ItemList();
			List ProductPlanning_Item_Plan_List = productplanning_service.ProductPlanning_Item_Plan_List(_itemno);

			mav.addObject("ProductPlanning_ItemList", ProductPlanning_ItemList); //왼쪽 아이템 리스트
			mav.addObject("ProductPlanning_Item_Plan_List", ProductPlanning_Item_Plan_List); // 체크박스 받아서 오른쪽에 계획 리스트(전체)
					
		}
		//체크박스랑 검색결과가 같으면
		if(_itemno.equals(_itemno2)) {
			productplanning_dto.setItemNO(_itemno2);
			
			List ProductPlanning_Item_Plan_List = productplanning_service.ProductPlanning_Item_Plan_List(_itemno2);
			List ProductPlanning_Item_Search_List = productplanning_service.ProductPlanning_Item_Search_List(_itemno2);
			
			mav.addObject("ProductPlanning_Item_Search_List", ProductPlanning_Item_Search_List); // 품번 검색결과 리스트(검색결과1개)
			mav.addObject("ProductPlanning_Item_Plan_List", ProductPlanning_Item_Plan_List); // 체크박스 받아서 오른쪽에 계획 리스트(전체)
		}
		
		return mav;
	}

	
	
	//ViewName 요청
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

	

	



