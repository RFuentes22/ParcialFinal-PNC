package com.uca.ncapas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.ncapas.domain.administracion.Centro_escolar;
import com.uca.ncapas.domain.administracion.Departamento;
import com.uca.ncapas.domain.administracion.Materia;
import com.uca.ncapas.domain.administracion.Municipio;
import com.uca.ncapas.repositories.EscuelaRepo;
import com.uca.ncapas.service.DepartamentoService;
import com.uca.ncapas.service.EscuelaService;
import com.uca.ncapas.service.MunicipioService;

@Controller
public class EscuelaController {
	@Autowired
	EscuelaService escuelaService;
	
	 @Autowired
	 private DepartamentoService departamentoService;
	 
	 @Autowired
	 MunicipioService municipioService;
		
	@RequestMapping("/saveCentro")
	public ModelAndView crearCentro(@Valid @ModelAttribute Centro_escolar centro_escolar, BindingResult result ) {
		ModelAndView mav = new ModelAndView();
		List<Departamento> departamentos = null;
		if (AdminController.idusuario != 0) {
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
			escuelaService.save(centro_escolar);
			mav.addObject("centro_escolar",new Centro_escolar());
			mav.addObject("departamentos",departamentos);
			mav.addObject("exito", 1);
			mav.setViewName("catalogos/crearEscuela");
			System.out.println("else");
		}
		} else mav.setViewName("index");
		
		return mav;
	}
	
	@RequestMapping("/editarEscuela")
    public ModelAndView CrearMateria(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView();
        Centro_escolar c = escuelaService.findOne(id);
        List<Departamento> departamentos = null;
        List<Municipio> municipios = null;
		if (AdminController.idusuario != 0) {
        try {
            departamentos = departamentoService.findAll();
            municipios = municipioService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("centro_escolar", c);
        mav.addObject("departamentos", departamentos);
        mav.addObject("municipios", municipios);
        mav.setViewName("catalogos/crearEscuela");
	} else mav.setViewName("index");
        return mav;
    }
}
