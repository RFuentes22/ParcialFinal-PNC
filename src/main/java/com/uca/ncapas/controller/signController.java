package com.uca.ncapas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.ncapas.domain.administracion.Usuario;
import com.uca.ncapas.repositories.UsuarioRepo;

@Controller
public class signController {
	
	@Autowired
	UsuarioRepo usuarioRepo;
		
	@RequestMapping("/crearCuenta")
	public ModelAndView createCount(@Valid @ModelAttribute Usuario usuario, BindingResult result ) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("crearCuenta");
		}else {
			usuarioRepo.save(usuario);
			mav.setViewName("index");
		}
		
		return mav;
	}
}
