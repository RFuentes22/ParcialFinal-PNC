package com.uca.ncapas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.ncapas.domain.administracion.Materia;
import com.uca.ncapas.repositories.MateriaRepo;
import com.uca.ncapas.service.MateriaService;

@Controller
public class MateriaController {
	
	@Autowired
	MateriaService materiaService;
	
	@RequestMapping("/saveMateria")
	public ModelAndView saveMateria(@Valid @ModelAttribute Materia materia, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("catalogos/crearMateria");
		}else {
			materiaService.save(materia);
			mav.addObject("save", 1);
			mav.setViewName("catalogos/catalogoMateria");
		}
		
		return mav;
	}
}
