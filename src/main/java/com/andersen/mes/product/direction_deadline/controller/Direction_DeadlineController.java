package com.andersen.mes.product.direction_deadline.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface Direction_DeadlineController {
	public ModelAndView main_direction_deadline(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView findDate_material_use(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView mod_direction_deadline(@RequestParam(value="tdArr[]") List<String> modList, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView modNot_direction_deadline(@RequestParam(value="tdArr[]") List<String> modList, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
