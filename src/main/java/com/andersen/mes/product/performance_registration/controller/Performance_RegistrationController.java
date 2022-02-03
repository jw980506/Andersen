package com.andersen.mes.product.performance_registration.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface Performance_RegistrationController {

	public ModelAndView main_performance_registration(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView findDate_performance_registration(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView add_performance_registration(@RequestParam(value="tdArr[]") List<String> addList, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView mod_performance_registration(@RequestParam(value="tdArr[]") List<String> modList, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView rem_performance_registration(@RequestParam(value="tdArr[]") List<String> remList, HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
