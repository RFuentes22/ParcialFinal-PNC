package com.uca.ncapas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.ncapas.domain.administracion.Materia;
import com.uca.ncapas.domain.administracion.Usuario;
import com.uca.ncapas.service.UsuarioService;

@Controller
public class UsusarioController {
	@Autowired
	UsuarioService userService;
	
	@RequestMapping("/saveUser")
	public ModelAndView saveMateria(@Valid @ModelAttribute Usuario usuario , BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("catalogos/crearMateria");
		}else {
			userService.save(usuario);
			mav.addObject("save", 1);
			mav.setViewName("catalogos/catalogoUsuario");
		}
		
		return mav;
	}
}
