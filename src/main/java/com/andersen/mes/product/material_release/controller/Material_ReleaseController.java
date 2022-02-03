package com.andersen.mes.product.material_release.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface Material_ReleaseController {

	public ModelAndView main_material_release(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView pop_material_release(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView findDate_material_release(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView add_pop_material(@RequestParam(value="tdArr[]") List<String> addList, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView add_material_release(@RequestParam(value="tdArr[]") List<String> addList, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView mod_material_release(@RequestParam(value="tdArr[]") List<String> modList, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView rem_material_release(@RequestParam(value="tdArr[]") List<String> remList, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
