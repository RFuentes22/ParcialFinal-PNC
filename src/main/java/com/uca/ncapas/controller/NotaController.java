package com.uca.ncapas.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.ncapas.domain.administracion.Materia;
import com.uca.ncapas.domain.administracion.Usuario;
import com.uca.ncapas.domain.proceso_negocio.Nota;
import com.uca.ncapas.repositories.MateriaRepo;
import com.uca.ncapas.repositories.NotaRepo;
import com.uca.ncapas.service.MateriaService;

@Controller
public class NotaController {
	
	@Autowired
	NotaRepo notaRepo;
	@Autowired
	private MateriaService materiaService;
	
	@RequestMapping("/addMateria")
	public ModelAndView AddMateria(@Valid @ModelAttribute Nota nota, BindingResult r) throws ParseException, DataAccessException{
		ModelAndView mav = new ModelAndView();
		List<Materia> materias = null;
		try {
			materias = materiaService.findAll();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(r.hasErrors()) {
			mav.addObject("materias",materias);
			mav.setViewName("negocio/crearMateria");
		}else {
			notaRepo.save(nota);
			mav.addObject("nota", new Nota());
			mav.addObject("materias",materias);
			mav.addObject("exito", 1);
			mav.setViewName("negocio/crearMateria");
		}
		
		return mav;
	}
	
}
