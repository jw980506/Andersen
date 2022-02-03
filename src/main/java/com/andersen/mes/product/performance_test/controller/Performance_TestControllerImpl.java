package com.andersen.mes.product.performance_test.controller;

import java.util.*;
import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
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

import com.andersen.mes.product.performance_test.vo.Performance_TestVO;
import com.andersen.mes.product.performance_test.service.Performance_TestService;

@Controller("performance_testController")
public class Performance_TestControllerImpl implements Performance_TestController {
	private static final Logger logger = LoggerFactory.getLogger(Performance_TestControllerImpl.class);
	@Autowired
	private Performance_TestService performance_testService;
	@Autowired
	private Performance_TestVO performance_testVO ;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	@RequestMapping(value="/product/main_performance_test.do" ,method = RequestMethod.GET)
	public ModelAndView main_performance_test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/main_performance_test.do");
		String pr_NO = request.getParameter("checked_pr_no");
		System.out.println("checked_pr_no :" +pr_NO);
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		ModelAndView mav = new ModelAndView(viewName);
		
		if (pr_NO != null) {
			
			performance_testVO.setPr_NO(pr_NO);// vo 세터저장
			List downList = performance_testService.DownList_performance_test(pr_NO);
			List mainList = performance_testService.main_performance_test();
			mav.addObject("downList", downList);
			mav.addObject("mainList", mainList);
			
		} else if (pr_NO == null) {
			List mainList = performance_testService.main_performance_test();
			mav.addObject("mainList", mainList);
		}
		
		return mav;
	}
	
	@Override //실적기간 날짜검색
	@RequestMapping(value="/product/find_performance_test.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView findDate_performance_test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/find_performance_test.do");
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		ModelAndView mav = new ModelAndView(viewName);
		
		//실적번호체크로 조회
		String pr_NO = request.getParameter("checked_pr_no"); //실적번호번호체크
		System.out.println("실적번호출력 :" +pr_NO);
		
		//실적기간 Date로 변환하고 sql.Date 로 변환 
		String biginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		System.out.println("실적기간조회 :" +biginDate+"-"+endDate);
		
		if(pr_NO != null) {
			
			performance_testVO.setPr_NO(pr_NO);// vo 세터저장
			List downList = performance_testService.DownList_performance_test(pr_NO);
			List mainList = performance_testService.main_performance_test();
			mav.addObject("downList", downList);
			mav.addObject("mainList", mainList);
			
		} else if(biginDate != null) {
			
			Date bigin_Date = sdf.parse(biginDate);
			Date end_Date = sdf.parse(endDate);
			String a = sdf.format(bigin_Date);
			String b = sdf.format(end_Date);
			java.sql.Date date1 = java.sql.Date.valueOf(a);
			java.sql.Date date2 = java.sql.Date.valueOf(b);
			performance_testVO.setBeginDate(date1);
			performance_testVO.setEndDate(date2);

			//실적기간 리스트 출력
			List mainList = performance_testService.findDate_performance_test(performance_testVO);
			mav.addObject("mainList", mainList);
			System.out.println("mainList :" +mainList);
		}

		return mav;
	}
	
	@Override
	@RequestMapping(value="/product/add_performance_test.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView add_performance_test(@RequestParam(value="tdArr[]") List<String> addList,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/add_performance_test.do");

		List downList = performance_testService.DownList_performance_test(performance_testVO.getPr_NO());
		int num = downList.size() + 1;
		performance_testVO.setNum(num);
		System.out.println(num);

		//가져온 문자열을 Date로 변환후 sql.Date 로 변환        
		Date test_Date = sdf.parse(addList.get(0).replaceAll(", ", ""));
		String a = sdf.format(test_Date);
		java.sql.Date date = java.sql.Date.valueOf(a);
		performance_testVO.setTest_Date(date);
		System.out.println(date);
		
		String test_Class = addList.get(1).replaceAll(", ", "");
		performance_testVO.setTest_Class(test_Class);
		System.out.println(test_Class);

		int sample_Quantity = Integer.parseInt(addList.get(2).replaceAll(", ", ""));
		performance_testVO.setSample_Quantity(sample_Quantity);
		System.out.println(sample_Quantity);

		String test_Type = addList.get(3).replaceAll(", ", "");
		performance_testVO.setTest_Type(test_Type);
		String pass = addList.get(4).replaceAll(", ", "");
		performance_testVO.setPass(pass);
		int passed_Quantity = Integer.parseInt(addList.get(5).replaceAll(", ", ""));
		performance_testVO.setPassed_Quantity(passed_Quantity);
		int fail_Quantity = Integer.parseInt(addList.get(6).replaceAll(", ", ""));
		performance_testVO.setFail_Quantity(fail_Quantity);
		
	    int result = 0;
	    result = performance_testService.add_performance_test(performance_testVO);
	    ModelAndView mav = new ModelAndView("redirect:/product/main_performance_test.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/product/mod_performance_test.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView mod_performance_test(@RequestParam(value="tdArr[]") List<String> modList,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/mod_performance_test.do");
	       
//		performance_testVO.setPr_NO(modList.get(0).replaceAll(", ", ""));
		System.out.println(performance_testVO.getPr_NO());
		int num = Integer.parseInt(modList.get(0).replaceAll(", ", ""));
		performance_testVO.setNum(num);
		System.out.println(num);
		//가져온 문자열을 Date로 변환후 sql.Date 로 변환        
		Date test_Date = sdf.parse(modList.get(1).replaceAll(", ", ""));
		String a = sdf.format(test_Date);
		java.sql.Date date = java.sql.Date.valueOf(a);
		performance_testVO.setTest_Date(date);
		System.out.println(date);

		String test_Class = modList.get(2).replaceAll(", ", "");
		performance_testVO.setTest_Class(test_Class);
		System.out.println(test_Class);
		int sample_Quantity = Integer.parseInt(modList.get(3).replaceAll(", ", ""));
		performance_testVO.setSample_Quantity(sample_Quantity);
		System.out.println(sample_Quantity);
		String test_Type = modList.get(4).replaceAll(", ", "");
		performance_testVO.setTest_Type(test_Type);
		System.out.println(test_Type);
		String pass = modList.get(5).replaceAll(", ", "");
		performance_testVO.setPass(pass);
		System.out.println(pass);
		int passed_Quantity = Integer.parseInt(modList.get(6).replaceAll(", ", ""));
		performance_testVO.setPassed_Quantity(passed_Quantity);
		System.out.println(passed_Quantity);
		int fail_Quantity = Integer.parseInt(modList.get(7).replaceAll(", ", ""));
		performance_testVO.setFail_Quantity(fail_Quantity);
		
	    int result = 0;
	    result = performance_testService.mod_performance_test(performance_testVO);
	    ModelAndView mav = new ModelAndView("redirect:/product/main_performance_test.do");
		return mav;
	}
	
	@Override 
	@RequestMapping(value="/product/rem_performance_test.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView rem_performance_test(@RequestParam(value="tdArr[]") List<String> remList, 
			           HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		System.out.println("/product/rem_performance_test.do");
		int num = Integer.parseInt(remList.get(0));
		performance_testVO.setNum(num);
		System.out.println("삭제할 순서의 번호"+num);
		performance_testService.rem_performance_test(performance_testVO);
		ModelAndView mav = new ModelAndView("redirect:/product/main_performance_test.do");
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
