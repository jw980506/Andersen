package com.andersen.mes.product.material_release.controller;

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

import com.andersen.mes.product.material_release.controller.Material_ReleaseControllerImpl;
import com.andersen.mes.product.material_release.service.Material_ReleaseService;
import com.andersen.mes.product.material_release.vo.Material_ReleaseVO;

@Controller("material_releaseController")
	public class Material_ReleaseControllerImpl implements Material_ReleaseController {
	private static final Logger logger = LoggerFactory.getLogger(Material_ReleaseControllerImpl.class);
	@Autowired
	private Material_ReleaseService material_releaseService;
	@Autowired
	private Material_ReleaseVO material_releaseVO;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	@RequestMapping(value="/product/main_material_release.do" ,method = RequestMethod.GET)
	public ModelAndView main_material_release(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/main_material_release.do");
		String mr_NO = request.getParameter("checked_mr_no");
		System.out.println("checked_mr_no :" +mr_NO);
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		ModelAndView mav = new ModelAndView(viewName);
		
		if (mr_NO != null) {
			
			material_releaseVO.setMr_NO(mr_NO);//���������� ����������� �����ϱ� ���� vo ��������
			
			List downList = material_releaseService.DownList_material_release(mr_NO);
			List mainList = material_releaseService.main_material_release();
			mav.addObject("downList", downList);
			mav.addObject("mainList", mainList);			
			
		} else if (mr_NO == null) {
			
			List mainList = material_releaseService.main_material_release();
			mav.addObject("mainList", mainList);
		}
		
		return mav;
	}
	
	@Override //���Ⱓ ��¥�˻�
	@RequestMapping(value="/product/find_material_release.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView findDate_material_release(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/find_material_release.do");
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		ModelAndView mav = new ModelAndView(viewName);
		
		//����ȣüũ�� ��ȸ
		String mr_NO = request.getParameter("checked_mr_no"); //����ȣüũ
		System.out.println("����ȣ��� :" +mr_NO);
		
		//���Ⱓ Date�� ��ȯ�ϰ� sql.Date �� ��ȯ 
		String biginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		System.out.println("���Ⱓ��ȸ :" +biginDate+"-"+endDate);
		
		if(mr_NO != null) {
			
			material_releaseVO.setMr_NO(mr_NO);//���������� ����������� �����ϱ� ���� vo ��������
			
			List downList = material_releaseService.DownList_material_release(mr_NO);
			List mainList = material_releaseService.main_material_release();
			mav.addObject("downList", downList);
			mav.addObject("mainList", mainList);
			
		} else if(biginDate != null) {
			
			Date bigin_Date = sdf.parse(biginDate);
			Date end_Date = sdf.parse(endDate);
			String a = sdf.format(bigin_Date);
			String b = sdf.format(end_Date);
			java.sql.Date date1 = java.sql.Date.valueOf(a);
			java.sql.Date date2 = java.sql.Date.valueOf(b);
			material_releaseVO.setBeginDate(date1);
			material_releaseVO.setEndDate(date2);

			//���Ⱓ ����Ʈ ���
			List mainList = material_releaseService.findDate_material_release(material_releaseVO);
			mav.addObject("mainList", mainList);
			System.out.println("mainList :" +mainList);
		}

		return mav;
	}
	
	@Override //�˾�â ��ȸ
	@RequestMapping(value="/product/pop_material_release.do" , method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView pop_material_release(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/pop_material_release.do");
		String viewName = getViewName(request);
		logger.info("viewName: "+ viewName);
		logger.debug("viewName: "+ viewName);
		ModelAndView mav = new ModelAndView(viewName);
		
		//���Ⱓ Date�� ��ȯ�ϰ� sql.Date �� ��ȯ 
		String biginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		System.out.println("û���Ⱓ��ȸ :" +biginDate+"-"+endDate);
		
		if (biginDate != null) {
			Date bigin_Date = sdf.parse(biginDate);
			Date end_Date = sdf.parse(endDate);
			String a = sdf.format(bigin_Date);
			String b = sdf.format(end_Date);
			java.sql.Date date1 = java.sql.Date.valueOf(a);
			java.sql.Date date2 = java.sql.Date.valueOf(b);
			material_releaseVO.setBeginDate(date1);
			material_releaseVO.setEndDate(date2);

			//û���Ⱓ ����Ʈ ���
			List popList = material_releaseService.popList_material_release(material_releaseVO);
			mav.addObject("popList", popList);
			System.out.println("popList :" +popList);
		}

		
		return mav;
	}
	
	@Override
	@RequestMapping(value="/product/add_pop_material.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView add_pop_material(@RequestParam(value="tdArr[]") List<String> addList, 
			           HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		System.out.println("/product/add_pop_material.do");
		
		String rd_NO = addList.get(0);//2��° ���̺� ����
		material_releaseVO.setRd_NO(rd_NO);
		System.out.println("���ù�ȣ: "+rd_NO);
		
		String mr_NO = null;
		mr_NO =	material_releaseVO.getMr_NO();
		material_releaseVO.setMr_NO(mr_NO);
		System.out.println("����ȣ: "+mr_NO);

	    //������ �ڵ��������� �����
//	    int mrs_Sequence = Integer.parseInt(addList.get(1));
//		material_releaseVO.setMrs_Sequence(mrs_Sequence); 
//		System.out.println("����:"+mrs_Sequence);
		
		String itemNO = addList.get(1);
		material_releaseVO.setItemNO(itemNO);
		System.out.println("ǰ��:"+itemNO);
		String item_Name = addList.get(2);
		material_releaseVO.setItem_Name(item_Name);
		System.out.println("ǰ��:"+item_Name);
		String stockUnit = addList.get(3);
		material_releaseVO.setStockUnit(stockUnit);
		System.out.println("����:"+stockUnit);
		int cds_needQuantity = Integer.parseInt(addList.get(4));
		material_releaseVO.setRr_Quantity(cds_needQuantity); // Ȯ�������� ��û������ ����
		material_releaseVO.setMrs_Quantity(cds_needQuantity); // Ȯ�������� �������� ����
		System.out.println("Ȯ������:"+cds_needQuantity);
		
		material_releaseService.addDownList_pop_material(material_releaseVO);
		ModelAndView mav = new ModelAndView("redirect:/product/find_material_release.do");
		return mav;
	}
	
	@Override //����������� ���
	@RequestMapping(value="/product/add_material_release.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView add_material_release(@RequestParam(value="tdArr[]") List<String> addList,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/add_material_release.do");
		
		//����ȣ �ڵ����� MR+��¥+mainList��ũ��
		List mainList = material_releaseService.main_material_release();
		int total = mainList.size();
		//�����ȴ� �Ϸù�ȣ����
	    SimpleDateFormat today = new SimpleDateFormat("yyyyMM");
	    Calendar c1 = Calendar.getInstance();
	    String strToday = today.format(c1.getTime());
	    //���ó�¥ 000 ����
	    String _mr_NO = "MR" + strToday + 000 + total; 
	    if(total>9) {
	    	_mr_NO = "MR" + strToday + "00" + total;
	    } if (total>99) {
	    	_mr_NO = "MR" + strToday + "0" + total;
	    }	
	    material_releaseVO.setMr_NO(_mr_NO);
	    System.out.println("������ ����ȣ:"+_mr_NO);

	    //ù��°���̺� ���� ���� ����� �ʿ��ϴ� ERPó�� �����Ϸ���
//		material_releaseService.addUpList_pop_material(_mr_NO);//���� ���� �ΰ������ �ϳ��� ��ȣ�� ���� ù���� ���̺� ���� ���������
	    
		//������ ���ڿ��� Date�� ��ȯ�� sql.Date �� ��ȯ 
		Date mr_Date = sdf.parse(addList.get(0));
		String a = sdf.format(mr_Date);
		java.sql.Date date = java.sql.Date.valueOf(a);
		material_releaseVO.setMr_Date(date);
		
		String mr_Warehouse = addList.get(1);
		material_releaseVO.setMr_Warehouse(mr_Warehouse);
		String mr_Place = addList.get(2);
		material_releaseVO.setMr_Place(mr_Place);
		String rd_Process = addList.get(3);
		material_releaseVO.setRd_Process(rd_Process);
		String rd_Workspace = addList.get(4);
		material_releaseVO.setRd_Workspace(rd_Workspace);
		String emp_Name = addList.get(5);
		material_releaseVO.setEmp_Name(emp_Name);
		
	    int result = 0;
	    result = material_releaseService.add_material_release(material_releaseVO);
	    ModelAndView mav = new ModelAndView("redirect:/product/main_material_release.do");
		return mav;
	}
	
	@Override //����ǰâ���԰�ó�� ����
	@RequestMapping(value="/product/mod_material_release.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView mod_material_release(@RequestParam(value="tdArr[]") List<String> modList,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("/product/mod_material_release.do");
		
		String mr_NO = modList.get(0);
		material_releaseVO.setMr_NO(mr_NO);
		
		//������ ���ڿ��� Date�� ��ȯ�� sql.Date �� ��ȯ 
		Date mr_Date = sdf.parse(modList.get(1));
		String a = sdf.format(mr_Date);
		java.sql.Date date = java.sql.Date.valueOf(a);
		material_releaseVO.setMr_Date(date);
				
		String mr_Warehouse = modList.get(2);
		material_releaseVO.setMr_Warehouse(mr_Warehouse);
		String mr_Place = modList.get(3);
		material_releaseVO.setMr_Place(mr_Place);
		String rd_Process = modList.get(4);
		material_releaseVO.setRd_Process(rd_Process);
		String rd_Workspace = modList.get(5);
		material_releaseVO.setRd_Workspace(rd_Workspace);
		String emp_Name = modList.get(6);
		material_releaseVO.setEmp_Name(emp_Name);
		
	    int result = 0;
	    result = material_releaseService.mod_material_release(material_releaseVO);
	    ModelAndView mav = new ModelAndView("redirect:/product/main_material_release.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/product/rem_material_release.do" ,method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView rem_material_release(@RequestParam(value="tdArr[]") List<String> remList, 
			           HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		System.out.println("/product/mod_material_release.do");
		
		String mr_NO = remList.get(0);
		System.out.println("������ ����ȣ: "+ mr_NO);
		
		material_releaseService.rem_material_release(mr_NO);
		ModelAndView mav = new ModelAndView("redirect:/product/main_material_release.do");
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
