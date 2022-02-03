package com.andersen.mes.product.goods_warehouse.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.andersen.mes.product.goods_warehouse.controller.Goods_WarehouseControllerImpl;
import com.andersen.mes.product.goods_warehouse.service.Goods_WarehouseService;
import com.andersen.mes.product.goods_warehouse.vo.Goods_WarehouseVO;

@Controller("goods_warehouseController")
public class Goods_WarehouseControllerImpl implements Goods_WarehouseController{
	private static final Logger logger = LoggerFactory.getLogger(Goods_WarehouseControllerImpl.class);
	@Autowired
	private Goods_WarehouseService goods_warehouseService;
	@Autowired
	private Goods_WarehouseVO goods_warehouseVO;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	@RequestMapping(value="/product/main_goods_warehouse.do" ,method = RequestMethod.GET)
	public ModelAndView main_goods_warehouse(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/main_goods_warehouse.do");
		String pr_NO = request.getParameter("checked_pr_no");
		System.out.println("checked_pr_no :" +pr_NO);
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		ModelAndView mav = new ModelAndView(viewName);
		
		if (pr_NO != null) {
			
			goods_warehouseVO.setPr_NO(pr_NO);//���������� ������������ �����ϱ� ���� vo ��������
			
			List downList = goods_warehouseService.DownList_goods_warehouse(pr_NO);
			List mainList = goods_warehouseService.main_goods_warehouse();
			mav.addObject("downList", downList);
			mav.addObject("mainList", mainList);			
			
		} else if (pr_NO == null) {
			
			List mainList = goods_warehouseService.main_goods_warehouse();
			mav.addObject("mainList", mainList);
		}
		
		return mav;
	}
	
	@Override //�����Ⱓ ��¥�˻�
	@RequestMapping(value="/product/find_goods_warehouse.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView findDate_goods_warehouse(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/find_goods_warehouse.do");
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		ModelAndView mav = new ModelAndView(viewName);
		
		//������ȣüũ�� ��ȸ
		String pr_NO = request.getParameter("checked_pr_no"); //���ù�ȣüũ
		System.out.println("������ȣ��� :" +pr_NO);
		
		//�����Ⱓ Date�� ��ȯ�ϰ� sql.Date �� ��ȯ 
		String biginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		System.out.println("�����Ⱓ��ȸ :" +biginDate+"-"+endDate);
		
		if(pr_NO != null) {
			
			goods_warehouseVO.setPr_NO(pr_NO);//���������� ������������ �����ϱ� ���� vo ��������
			
			List downList = goods_warehouseService.DownList_goods_warehouse(pr_NO);
			List mainList = goods_warehouseService.main_goods_warehouse();
			mav.addObject("downList", downList);
			mav.addObject("mainList", mainList);
			
		} else if(biginDate != null) {
			
			Date bigin_Date = sdf.parse(biginDate);
			Date end_Date = sdf.parse(endDate);
			String a = sdf.format(bigin_Date);
			String b = sdf.format(end_Date);
			java.sql.Date date1 = java.sql.Date.valueOf(a);
			java.sql.Date date2 = java.sql.Date.valueOf(b);
			goods_warehouseVO.setBeginDate(date1);
			goods_warehouseVO.setEndDate(date2);

			//���ñⰣ ����Ʈ ���
			List mainList = goods_warehouseService.findDate_goods_warehouse(goods_warehouseVO);
			mav.addObject("mainList", mainList);
			System.out.println("mainList :" +mainList);
		}

		return mav;
	}
	
	@Override //����ǰâ���԰�ó�� ���
	@RequestMapping(value="/product/add_goods_warehouse.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView add_goods_warehouse(@RequestParam(value="tdArr[]") List<String> addList,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/add_goods_warehouse.do");
		

		//�԰��ȣ �ڵ����� GW+��¥+DownList��ũ��
		List downList = goods_warehouseService.list_goods_warehouse();
		int total = downList.size();
		//�����ȴ� �Ϸù�ȣ����
	    SimpleDateFormat today = new SimpleDateFormat("yyyyMM");
	    Calendar c1 = Calendar.getInstance();
	    String strToday = today.format(c1.getTime());
	    //���ó�¥ 000 ����
	    String _gw_NO = "GW" + strToday + 000 + total; 
	    if(total>9) {
	    	_gw_NO = "GW" + strToday + "00" + total;
	    } if (total>99) {
	    	_gw_NO = "GW" + strToday + "0" + total;
	    }	
	    //����� ���� VO��������
	    goods_warehouseVO.setGw_NO(_gw_NO);
	    
		//������ ���ڿ��� Date�� ��ȯ�� sql.Date �� ��ȯ 
		Date gw_DATE = sdf.parse(addList.get(0).replaceAll(", ", ""));
		String a = sdf.format(gw_DATE);
		java.sql.Date date = java.sql.Date.valueOf(a);
		goods_warehouseVO.setGw_DATE(date);
		
		String gw_Warehouse = addList.get(1).replaceAll(", ", "");
		goods_warehouseVO.setGw_Warehouse(gw_Warehouse);
		String gw_Place = addList.get(2).replaceAll(", ", "");
		goods_warehouseVO.setGw_Place(gw_Place);
		int gw_Quantity = Integer.parseInt(addList.get(3).replaceAll(", ", ""));
		goods_warehouseVO.setGw_Quantity(gw_Quantity);
		
	    int result = 0;
	    result = goods_warehouseService.add_goods_warehouse(goods_warehouseVO);
	    ModelAndView mav = new ModelAndView("redirect:/product/main_goods_warehouse.do");
		return mav;
	}
	
	@Override //����ǰâ���԰�ó�� ����
	@RequestMapping(value="/product/mod_goods_warehouse.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView mod_goods_warehouse(@RequestParam(value="tdArr[]") List<String> modList,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/mod_goods_warehouse.do");
		
		goods_warehouseVO.setGw_NO(modList.get(0).replaceAll(", ", ""));
	    
		//������ ���ڿ��� Date�� ��ȯ�� sql.Date �� ��ȯ 
		Date gw_DATE = sdf.parse(modList.get(1).replaceAll(", ", ""));
		String a = sdf.format(gw_DATE);
		java.sql.Date date = java.sql.Date.valueOf(a);
		goods_warehouseVO.setGw_DATE(date);
		
		String gw_Warehouse = modList.get(2).replaceAll(", ", "");
		goods_warehouseVO.setGw_Warehouse(gw_Warehouse);
		String gw_Place = modList.get(3).replaceAll(", ", "");
		goods_warehouseVO.setGw_Place(gw_Place);
		int gw_Quantity = Integer.parseInt(modList.get(4).replaceAll(", ", ""));
		goods_warehouseVO.setGw_Quantity(gw_Quantity);
		
	    int result = 0;
	    result = goods_warehouseService.mod_goods_warehouse(goods_warehouseVO);
	    ModelAndView mav = new ModelAndView("redirect:/product/main_goods_warehouse.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/product/rem_goods_warehouse.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView rem_goods_warehouse(@RequestParam(value="tdArr[]") List<String> remList, 
			           HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		String gw_NO = remList.get(0);
		System.out.println("������ �԰��ȣ: "+gw_NO);
		
		goods_warehouseService.rem_goods_warehouse(gw_NO);
		ModelAndView mav = new ModelAndView("redirect:/product/main_goods_warehouse.do");
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
