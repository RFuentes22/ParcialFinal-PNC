package com.uca.ncapas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.ncapas.domain.administracion.Centro_escolar;
import com.uca.ncapas.domain.administracion.Departamento;
import com.uca.ncapas.repositories.EscuelaRepo;
import com.uca.ncapas.service.DepartamentoService;

@Controller
public class EscuelaController {
	@Autowired
	EscuelaRepo escuelaRepo;
	
	 @Autowired
	 private DepartamentoService departamentoService;
		
	@RequestMapping("/saveCentro")
	public ModelAndView crearCentro(@Valid @ModelAttribute Centro_escolar centro_escolar, BindingResult result ) {
		ModelAndView mav = new ModelAndView();
		List<Departamento> departamentos = null;
		try {
			departamentos = departamentoService.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result.hasErrors()) {
			mav.addObject("departamentos", departamentos);
			mav.setViewName("catalogos/crearEscuela");
			System.out.println("if");
		}else {
			escuelaRepo.save(centro_escolar);
			mav.addObject("centro_escolar",new Centro_escolar());
			mav.addObject("departamentos",departamentos);
			mav.addObject("exito", 1);
			mav.setViewName("catalogos/crearEscuela");
			System.out.println("else");
		}
		
		return mav;
	}
}
