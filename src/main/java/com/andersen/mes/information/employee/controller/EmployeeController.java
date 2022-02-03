package com.andersen.mes.information.employee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.andersen.mes.information.employee.vo.EmployeeVO;

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
	
	/**
	 * 
	 * 
	 * @return
	 * @throws Exception
	 */
	public ModelAndView employeeOneAdd(List<String> addList, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView employeeOndMod(List<String> modList,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView employeeOneDel(List<String> delList,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
}