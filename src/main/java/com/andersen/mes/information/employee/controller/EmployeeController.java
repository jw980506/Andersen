package com.andersen.mes.information.employee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface EmployeeController {
	
	/**
	 * Service에서 전체사원 조회 메소드를 들고와 리턴되는 List값을 addObject로 묶어서 jsp로 반환
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView employeeAllList(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
