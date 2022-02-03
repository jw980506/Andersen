package com.andersen.mes.product.material_use.controller;

import java.util.*;
import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.andersen.mes.product.material_use.vo.Material_UseVO;
import com.andersen.mes.product.material_use.service.Material_UseService;

@Controller("material_useController")
public class Material_UseControllerImpl implements Material_UseController {
	private static final Logger logger = LoggerFactory.getLogger(Material_UseControllerImpl.class);
	@Autowired
	private Material_UseService material_useService;
	@Autowired
	private Material_UseVO material_useVO ;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	@RequestMapping(value="/product/main_material_use.do" ,method = RequestMethod.GET)
	public ModelAndView main_material_use(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/main_material_use.do");
		String pr_NO = request.getParameter("checked_pr_no");
		System.out.println("checked_pr_no :" +pr_NO);
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		ModelAndView mav = new ModelAndView(viewName);
		
		if (pr_NO != null) {
			
			material_useVO.setPr_NO(pr_NO);//다음페이지 생산자재사용등록 저장하기 위한 vo 세터저장
			List downList = material_useService.DownList_material_use(pr_NO);
			List mainList = material_useService.main_material_use();
			mav.addObject("downList", downList);
			mav.addObject("mainList", mainList);
			
		} else if (pr_NO == null) {
			List mainList = material_useService.main_material_use();
			mav.addObject("mainList", mainList);
		}
		
		return mav;
	}
	
	@Override //실적기간 날짜검색
	@RequestMapping(value="/product/find_material_use.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView findDate_material_use(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/find_material_use.do");
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		ModelAndView mav = new ModelAndView(viewName);
		
		//실적번호체크로 조회
		String pr_NO = request.getParameter("checked_pr_no"); //지시번호체크
		System.out.println("실적번호출력 :" +pr_NO);
		
		//실적기간 Date로 변환하고 sql.Date 로 변환 
		String biginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		System.out.println("실적기간조회 :" +biginDate+"-"+endDate);
		
		if(pr_NO != null) {
			
			material_useVO.setPr_NO(pr_NO);//다음페이지 생산자재사용등록 저장하기 위한 vo 세터저장
			List downList = material_useService.DownList_material_use(pr_NO);
			List mainList = material_useService.main_material_use();
			mav.addObject("downList", downList);
			mav.addObject("mainList", mainList);
			
		} else if(biginDate != null) {
			
			Date bigin_Date = sdf.parse(biginDate);
			Date end_Date = sdf.parse(endDate);
			String a = sdf.format(bigin_Date);
			String b = sdf.format(end_Date);
			java.sql.Date date1 = java.sql.Date.valueOf(a);
			java.sql.Date date2 = java.sql.Date.valueOf(b);
			material_useVO.setBeginDate(date1);
			material_useVO.setEndDate(date2);

			//지시기간 리스트 출력
			List mainList = material_useService.findDate_material_use(material_useVO);
			mav.addObject("mainList", mainList);
			System.out.println("mainList :" +mainList);
		}

		return mav;
	}
	
	@Override
	@RequestMapping(value="/product/add_material_use.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView add_material_use(@RequestParam(value="tdArr[]") List<String> addList,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/add_material_use.do");
		
		List downList = material_useService.DownList_material_use(material_useVO.getPr_NO());
		int num = downList.size() + 1;
		material_useVO.setNum(num);
		//가져온 문자열을 Date로 변환후 sql.Date 로 변환        
		Date use_Date = sdf.parse(addList.get(0).replaceAll(", ", ""));
		String a = sdf.format(use_Date);
		java.sql.Date date = java.sql.Date.valueOf(a);
		material_useVO.setUse_Date(date);
		
		String pr_Process = addList.get(1).replaceAll(", ", "");
		material_useVO.setPr_Process(pr_Process);
		System.out.println(pr_Process);
		String pr_Workspace = addList.get(2).replaceAll(", ", "");
		material_useVO.setPr_Workspace(pr_Workspace);
		String itemNO = addList.get(3).replaceAll(", ", "");
		material_useVO.setItemNO(itemNO);
		String item_Name = addList.get(4).replaceAll(", ", "");
		material_useVO.setItem_Name(item_Name);
		String stockUnit = addList.get(5).replaceAll(", ", "");
		material_useVO.setStockUnit(stockUnit);
		int cds_needQuantity = Integer.parseInt(addList.get(6).replaceAll(", ", ""));
		material_useVO.setCds_needQuantity(cds_needQuantity);
		
	    int result = 0;
	    result = material_useService.add_material_use(material_useVO);
	    ModelAndView mav = new ModelAndView("redirect:/product/main_material_use.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/product/mod_material_use.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView mod_material_use(@RequestParam(value="tdArr[]") List<String> modList,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/mod_material_use.do");
		
		int num = Integer.parseInt(modList.get(0).replaceAll(", ", ""));
		material_useVO.setNum(num);
		System.out.println(num);
		
		//가져온 문자열을 Date로 변환후 sql.Date 로 변환        
		Date use_Date = sdf.parse(modList.get(1).replaceAll(", ", ""));
		String a = sdf.format(use_Date);
		java.sql.Date date = java.sql.Date.valueOf(a);
		material_useVO.setUse_Date(date);
		System.out.println(date);
		
		String pr_Process = modList.get(2).replaceAll(", ", "");
		material_useVO.setPr_Process(pr_Process);
		System.out.println(pr_Process);
		
		String pr_Workspace = modList.get(3).replaceAll(", ", "");
		material_useVO.setPr_Workspace(pr_Workspace);
		System.out.println(pr_Workspace);
		
		String itemNO = modList.get(4).replaceAll(", ", "");
		material_useVO.setItemNO(itemNO);
		System.out.println(itemNO);
		
		String item_Name = modList.get(5).replaceAll(", ", "");
		material_useVO.setItem_Name(item_Name);
		System.out.println(item_Name);
		
		String stockUnit = modList.get(6).replaceAll(", ", "");
		material_useVO.setStockUnit(stockUnit);
		System.out.println(stockUnit);
		
		int cds_needQuantity = Integer.parseInt(modList.get(7).replaceAll(", ", ""));
		material_useVO.setCds_needQuantity(cds_needQuantity);
		System.out.println(cds_needQuantity);
		
	    int result = 0;
	    result = material_useService.mod_material_use(material_useVO);
	    ModelAndView mav = new ModelAndView("redirect:/product/main_material_use.do");
		return mav;
	}
	
	@Override  //실적번호의 순서로 삭제
	@RequestMapping(value="/product/rem_material_use.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView rem_material_use(@RequestParam(value="tdArr[]") List<String> remList, 
			           HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		System.out.println("/product/rem_material_use.do");
		int num = Integer.parseInt(remList.get(0));
		System.out.println("삭제할 순서의 번호"+num);
		material_useVO.setNum(num);
		
		material_useService.rem_material_use(material_useVO);
		ModelAndView mav = new ModelAndView("redirect:/product/main_material_use.do");
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
