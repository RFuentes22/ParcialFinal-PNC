package com.uca.ncapas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/login")
	public ModelAndView Login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/signup")
	public ModelAndView Signup() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("crearCuenta");
		return mav;
	}
	
	@RequestMapping("/adminview")
	public ModelAndView AdminView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminView");
		return mav;
	}
	
	@RequestMapping("/coordinatorview")
	public ModelAndView CoordinatorView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("coordinatorView");
		return mav;
	}
	
	@RequestMapping("/catalogoEscuela")
	public ModelAndView CatalogoEscuela() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("catalogoEscuela");
		return mav;
	}
}
