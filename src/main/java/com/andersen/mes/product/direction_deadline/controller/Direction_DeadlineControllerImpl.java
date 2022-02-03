package com.andersen.mes.product.direction_deadline.controller;

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

import com.andersen.mes.product.direction_deadline.controller.Direction_DeadlineControllerImpl;
import com.andersen.mes.product.direction_deadline.service.Direction_DeadlineService;
import com.andersen.mes.product.direction_deadline.vo.Direction_DeadlineVO;

@Controller("direction_deadlineController")
public class Direction_DeadlineControllerImpl implements Direction_DeadlineController {
	private static final Logger logger = LoggerFactory.getLogger(Direction_DeadlineControllerImpl.class);
	@Autowired
	private Direction_DeadlineService direction_deadlineService;
	@Autowired
	private Direction_DeadlineVO direction_deadlineVO;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	@RequestMapping(value="/product/main_direction_deadline.do" ,method = RequestMethod.GET)
	public ModelAndView main_direction_deadline(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/main_direction_deadline.do");
	
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		ModelAndView mav = new ModelAndView(viewName);
		
		List mainList = direction_deadlineService.main_direction_deadline();
		mav.addObject("mainList", mainList);
		
		return mav;
	}
	
	@Override //지시기간 날짜검색
	@RequestMapping(value="/product/find_direction_deadline.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView findDate_material_use(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/find_direction_deadline.do");
		
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		ModelAndView mav = new ModelAndView(viewName);
		
		//지시기간 Date로 변환하고 sql.Date 로 변환 
		String biginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		System.out.println("지시기간조회 :" +biginDate+"-"+endDate);
		
		if(biginDate != null) {
			
			Date bigin_Date = sdf.parse(biginDate);
			Date end_Date = sdf.parse(endDate);
			String a = sdf.format(bigin_Date);
			String b = sdf.format(end_Date);
			java.sql.Date date1 = java.sql.Date.valueOf(a);
			java.sql.Date date2 = java.sql.Date.valueOf(b);
			direction_deadlineVO.setBeginDate(date1);
			direction_deadlineVO.setEndDate(date2);

			//지시기간 리스트 출력
			List mainList = direction_deadlineService.findDate_direction_deadline(direction_deadlineVO);
			mav.addObject("mainList", mainList);
			System.out.println("mainList :" +mainList);
		}

		return mav;
	}
	
	@Override //마감처리 메소드
	@RequestMapping(value="/product/mod_direction_deadline.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView mod_direction_deadline(@RequestParam(value="tdArr[]") List<String> modList,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/mod_direction_deadline.do");
	   
		String rd_NO = modList.get(0);
		System.out.println("지시번호 :"+rd_NO);
	    int result = 0;
	    result = direction_deadlineService.mod_direction_deadline(rd_NO);
	    ModelAndView mav = new ModelAndView("redirect:/product/main_direction_deadline.do");
		return mav;
	}
	
	@Override //마감취소 메소드
	@RequestMapping(value="/product/mod_not_direction_deadline.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView modNot_direction_deadline(@RequestParam(value="tdArr[]") List<String> modNotList,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/mod_not_direction_deadline.do");
	   
		String rd_NO = modNotList.get(0);
		System.out.println("지시번호 :"+rd_NO);
	    int result = 0;
	    result = direction_deadlineService.modNot_direction_deadline(rd_NO);
	    ModelAndView mav = new ModelAndView("redirect:/product/main_direction_deadline.do");
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
