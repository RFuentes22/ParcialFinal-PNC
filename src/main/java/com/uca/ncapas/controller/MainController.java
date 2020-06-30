package com.uca.ncapas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class MainController {
	
	@RequestMapping("/login")
	public ModelAndView Login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
}
