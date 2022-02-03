package com.andersen.mes.product.performance_registration.controller;

import java.util.*;
import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import com.andersen.mes.product.performance_registration.vo.Performance_RegistrationVO;
import com.andersen.mes.product.performance_registration.service.Performance_RegistrationService;

@Controller("Performance_RegistrationController")
public class Performance_RegistrationControllerImpl implements Performance_RegistrationController {
	private static final Logger logger = LoggerFactory.getLogger(Performance_RegistrationControllerImpl.class);
	@Autowired
	private Performance_RegistrationService performance_registrationService;
	@Autowired
	private Performance_RegistrationVO performance_registrationVO ;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //날짜 변환
	
	@Override //메인화면 리스트 출력
	@RequestMapping(value="/product/main_performance_registration.do" ,method = RequestMethod.GET)
	public ModelAndView main_performance_registration(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/main_performance_registration.do");
		//지시번호체크로 조회
		String rd_no = request.getParameter("checked_rd_no"); 
		System.out.println("지시번호출력 :" +rd_no);
		
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		ModelAndView mav = new ModelAndView(viewName);
		
		if (rd_no != null) {
			
			performance_registrationVO.setRd_no(rd_no);//다음페이지 생산자재사용등록 저장하기 위한 vo 세터저장
			List<Performance_RegistrationVO> addNextList = null;
			addNextList = performance_registrationService.findRd_noUpList_performance_registration(rd_no);
			performance_registrationVO.setItemNO(addNextList.get(0).getItemNO());
			performance_registrationVO.setItem_Name(addNextList.get(0).getItem_Name());
			performance_registrationVO.setRd_Status(addNextList.get(0).getRd_Status());
			
			List downList = performance_registrationService.DownList_performance_registration(rd_no);
			List mainList = performance_registrationService.main_performance_registration();
			mav.addObject("downList", downList);
			mav.addObject("mainList", mainList);
			
		} else if (rd_no == null) {
			
			List mainList = performance_registrationService.main_performance_registration();
			mav.addObject("mainList", mainList);
		}
		
		return mav;
	}
	
	@Override //지시기간 날짜검색
	@RequestMapping(value="/product/find_performance_registration.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView findDate_performance_registration(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/find_performance_registration.do");
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		ModelAndView mav = new ModelAndView(viewName);
		//지시번호체크로 조회
		String rd_no = request.getParameter("checked_rd_no"); //지시번호체크
		System.out.println("지시번호출력 :" +rd_no);
		
		//지시기간 Date로 변환하고 sql.Date 로 변환 
		String biginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		System.out.println("지시기간조회 :" +biginDate+"-"+endDate);
		
		if(rd_no != null) {
			
			performance_registrationVO.setRd_no(rd_no);//다음페이지 생산자재사용등록 저장하기 위한 vo 세터저장
			List<Performance_RegistrationVO> addNextList = null;
			addNextList = performance_registrationService.findRd_noUpList_performance_registration(rd_no);
			performance_registrationVO.setItemNO(addNextList.get(0).getItemNO());
			performance_registrationVO.setItem_Name(addNextList.get(0).getItem_Name());
			performance_registrationVO.setRd_Status(addNextList.get(0).getRd_Status());
			
			List downList = performance_registrationService.DownList_performance_registration(rd_no);
			List mainList = performance_registrationService.main_performance_registration();
			mav.addObject("downList", downList);
			mav.addObject("mainList", mainList);
			
		} else if(biginDate != null) {
			
			Date bigin_Date = sdf.parse(biginDate);
			Date end_Date = sdf.parse(endDate);
			String a = sdf.format(bigin_Date);
			String b = sdf.format(end_Date);
			java.sql.Date date1 = java.sql.Date.valueOf(a);
			java.sql.Date date2 = java.sql.Date.valueOf(b);
			performance_registrationVO.setBeginDate(date1);
			performance_registrationVO.setEndDate(date2);

			//지시기간 리스트 출력
			List mainList = performance_registrationService.findDate_performance_registration(performance_registrationVO);
			mav.addObject("mainList", mainList);
			System.out.println("mainList :" +mainList);
		}

		return mav;
	}
	
	@Override //생산실적등록, 생산자재사용등록 같이등록
	@RequestMapping(value="/product/add_performance_registration.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView add_performance_registration(@RequestParam(value="tdArr[]") List<String> addList,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/add_performance_registration.do");
		

		//실적번호 자동생성 PR+날짜+DownList총크기
		List downList = performance_registrationService.list_performance_registration();
		int total = downList.size();
		//생성된달 일련번호생성
	    SimpleDateFormat today = new SimpleDateFormat("yyyyMM");
	    Calendar c1 = Calendar.getInstance();
	    String strToday = today.format(c1.getTime());
	    //오늘날짜 000 숫자
	    String _pr_NO = "PR" + strToday + 000 + total; 
	    if(total>9) {
	    	_pr_NO = "PR" + strToday + "00" + total;
	    } if (total>99) {
	    	_pr_NO = "PR" + strToday + "0" + total;
	    }	
	    //등록을 위한 VO세터저장
		performance_registrationVO.setPr_NO(_pr_NO);
		performance_registrationVO.setMaterials_Availability(0);
		//가져온 문자열을 Date로 변환후 sql.Date 로 변환 
		Date _pr_Date = sdf.parse(addList.get(2).replaceAll(", ", ""));
		String a = sdf.format(_pr_Date);
		java.sql.Date date = java.sql.Date.valueOf(a);
		performance_registrationVO.setPr_Date(date);
		
		String _pr_Process = addList.get(3).replaceAll(", ", "");
		performance_registrationVO.setPr_Process(_pr_Process);
		String _pr_Workspace = addList.get(4).replaceAll(", ", "");
		performance_registrationVO.setPr_Workspace(_pr_Workspace);
		int _transfer_Separation = Integer.parseInt(addList.get(5).replaceAll(", ", ""));
		performance_registrationVO.setTransfer_Separation(_transfer_Separation);
		int _pr_OrNot = Integer.parseInt(addList.get(6).replaceAll(", ", ""));
		performance_registrationVO.setPr_OrNot(_pr_OrNot);
		int _pr_Quantity = Integer.parseInt(addList.get(7).replaceAll(", ", ""));
		performance_registrationVO.setPr_Quantity(_pr_Quantity);
		int _rd_Test = Integer.parseInt(addList.get(8).replaceAll(", ", ""));
		performance_registrationVO.setRd_Test(_rd_Test);
		String _pr_Name = addList.get(9).replaceAll(", ", "");
		performance_registrationVO.setPr_Name(_pr_Name);
		String _warehouse_Process = addList.get(10).replaceAll(", ", "");
		performance_registrationVO.setWarehouse_Process(_warehouse_Process);
		String _place_Workspace = addList.get(11).replaceAll(", ", "");
		performance_registrationVO.setPlace_Workspace(_place_Workspace);
		
	    int result = 0;
	    result = performance_registrationService.add_performance_registration(performance_registrationVO);
	    ModelAndView mav = new ModelAndView("redirect:/product/main_performance_registration.do");
		return mav;
	}
	
	@Override //작업실적등록 수정
	@RequestMapping(value="/product/mod_performance_registration.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView mod_performance_registration(@RequestParam(value="tdArr[]") List<String> modList,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/mod_performance_registration.do");
		
		String _pr_NO = modList.get(0).replaceAll(", ", "");
		performance_registrationVO.setPr_NO(_pr_NO);
		performance_registrationVO.setMaterials_Availability(0);
		//가져온 문자열을 Date로 변환후 sql.Date 로 변환 
		Date _pr_Date = sdf.parse(modList.get(2).replaceAll(", ", ""));
		String a = sdf.format(_pr_Date);
		java.sql.Date date = java.sql.Date.valueOf(a);
		performance_registrationVO.setPr_Date(date);
		
		String _pr_Process = modList.get(3).replaceAll(", ", "");
		performance_registrationVO.setPr_Process(_pr_Process);
		String _pr_Workspace = modList.get(4).replaceAll(", ", "");
		performance_registrationVO.setPr_Workspace(_pr_Workspace);
		int _transfer_Separation = Integer.parseInt(modList.get(5).replaceAll(", ", ""));
		performance_registrationVO.setTransfer_Separation(_transfer_Separation);
		int _pr_OrNot = Integer.parseInt(modList.get(6).replaceAll(", ", ""));
		performance_registrationVO.setPr_OrNot(_pr_OrNot);
		int _pr_Quantity = Integer.parseInt(modList.get(7).replaceAll(", ", ""));
		performance_registrationVO.setPr_Quantity(_pr_Quantity);
		int _rd_Test = Integer.parseInt(modList.get(8).replaceAll(", ", ""));
		performance_registrationVO.setRd_Test(_rd_Test);
		String _pr_Name = modList.get(9).replaceAll(", ", "");
		performance_registrationVO.setPr_Name(_pr_Name);
		String _warehouse_Process = modList.get(10).replaceAll(", ", "");
		performance_registrationVO.setWarehouse_Process(_warehouse_Process);
		String _place_Workspace = modList.get(11).replaceAll(", ", "");
		performance_registrationVO.setPlace_Workspace(_place_Workspace);
		
	    int result = 0;
	    result = performance_registrationService.mod_performance_registration(performance_registrationVO);
	    ModelAndView mav = new ModelAndView("redirect:/product/main_performance_registration.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/product/rem_performance_registration.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView rem_performance_registration(@RequestParam(value="tdArr[]") List<String> remList, 
			           HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		String pr_NO = remList.get(0);
		System.out.println("삭제할 실적번호: "+pr_NO);
		
		performance_registrationService.rem_performance_registration(pr_NO);
		ModelAndView mav = new ModelAndView("redirect:/product/main_performance_registration.do");
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
