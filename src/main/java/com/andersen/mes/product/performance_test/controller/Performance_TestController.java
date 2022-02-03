package com.andersen.mes.product.performance_test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface Performance_TestController {

	public ModelAndView main_performance_test(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView findDate_performance_test(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView add_performance_test(@RequestParam(value="tdArr[]") List<String> addList, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView mod_performance_test(@RequestParam(value="tdArr[]") List<String> modList, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView rem_performance_test(@RequestParam(value="tdArr[]") List<String> remList, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
