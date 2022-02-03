package com.andersen.mes.information.employee.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.andersen.mes.information.employee.service.EmployeeService;
import com.andersen.mes.information.employee.vo.EmployeeVO;

@Controller("employeeController")
public class EmployeeControllerImpl implements EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeControllerImpl.class);
	@Autowired
	private EmployeeService employeeService;
	
	@Override
	@RequestMapping(value = "/employeesList.do", method = RequestMethod.GET)
	public ModelAndView employeeAllList(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
		List listAllEmployee = employeeService.employeeAllList();
		
		ModelAndView mav = new ModelAndView("/employeesList");		// addObject에 쓰일 jsp명
		mav.addObject("listAllEmployee", listAllEmployee);			// listAllEmployee를 jsp에 리턴
		
		return mav;
	}

	@Override
	@RequestMapping(value = "/employeeOneAdd.do", method = RequestMethod.POST)
	public ModelAndView employeeOneAdd(@RequestParam(value = "tdArr[]")List<String> addList,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		EmployeeVO employeeVO = new EmployeeVO();
		
		int _empNo			= Integer.parseInt(addList.get(0));
		String _emp_Name	= addList.get(1);
		String _password	= addList.get(2);
		double _deptNo		= Double.parseDouble(addList.get(3));
		String _dept_Name	= addList.get(4);
		
		employeeVO.setEmpNo(_empNo);
		employeeVO.setEmp_Name(_emp_Name);
		employeeVO.setPassword(_password);
		employeeVO.setDeptNo(_deptNo);
		employeeVO.setDept_Name(_dept_Name);
		
		employeeService.addEmployee(employeeVO);
		ModelAndView mav = new ModelAndView("redirect:/employeesList.do");
		return mav;
	}

	@Override
	@RequestMapping(value = "/employeeOneMod.do", method = RequestMethod.POST)
	public ModelAndView employeeOndMod(@RequestParam(value = "modArr[]") List<String> modList, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		// System.out.println(modList);
		
		EmployeeVO employeeVO = new EmployeeVO();
		
		int _empNo			= Integer.parseInt(modList.get(0));
		String _emp_Name	= modList.get(1);
		String _password	= modList.get(2);
		double _deptNo		= Double.parseDouble(modList.get(3));
		String _dept_Name	= modList.get(4);
		
		employeeVO.setEmpNo(_empNo);
		employeeVO.setEmp_Name(_emp_Name);
		employeeVO.setPassword(_password);
		employeeVO.setDeptNo(_deptNo);
		employeeVO.setDept_Name(_dept_Name);
		
		employeeService.modEmployee(employeeVO);
		ModelAndView mav = new  ModelAndView("redirect:/employeesList.do");
		return mav;
	}

	@Override
	@RequestMapping(value = "/employeeOneDel.do", method = RequestMethod.POST)
	public ModelAndView employeeOneDel(@RequestParam(value = "delArr[]") List<String> delList, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		EmployeeVO employeeVO = new EmployeeVO();
		
		int _empNo = Integer.parseInt(delList.get(0));
		
		employeeVO.setEmpNo(_empNo);
		
		employeeService.delEmployee(_empNo);
		ModelAndView mav = new ModelAndView("redirect:/employeesList.do");
		return mav;
	}


	
}
