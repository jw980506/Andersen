package com.andersen.mes.information.employee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.andersen.mes.information.employee.service.EmployeeService;
import com.andersen.mes.product.ProductPlanning.controller.ProductPlanning_ControllerImpl;

@Controller("employeeController")
public class EmployeeControllerImpl implements EmployeeController {

	 private static final Logger logger = LoggerFactory.getLogger(ProductPlanning_ControllerImpl.class);
	@Autowired
	private EmployeeService employeeService;
	
	@Override
	@RequestMapping(value = "/employeesList.do", method = RequestMethod.GET)
	public ModelAndView employeeAllList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("컨트롤러 진입");
		
		List listAllEmployee = employeeService.employeeAllList();
		
		ModelAndView mav = new ModelAndView("/employeesList");		// addObject에 쓰일 jsp명
		mav.addObject("listAllEmployee", listAllEmployee);			// listAllEmployee를 jsp에 리턴
		
		return mav;
	}

	
}
