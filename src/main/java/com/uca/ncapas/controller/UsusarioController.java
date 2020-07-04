package com.uca.ncapas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.ncapas.domain.administracion.Departamento;
import com.uca.ncapas.domain.administracion.Materia;
import com.uca.ncapas.domain.administracion.Usuario;
import com.uca.ncapas.repositories.UsuarioRepo;
import com.uca.ncapas.service.DepartamentoService;
import com.uca.ncapas.service.UsuarioService;

@Controller
public class UsusarioController {
	@Autowired
	UsuarioRepo usuarioRepo;
	
	 @Autowired
	 private DepartamentoService departamentoService;

		
	@RequestMapping("/saveUser")
	public ModelAndView createCount(@Valid @ModelAttribute Usuario usuario, BindingResult result ) {
		ModelAndView mav = new ModelAndView();
		List<Departamento> departamentos = null;
		System.out.println(usuario.getImunicipio().toString());
		try {
			departamentos = departamentoService.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result.hasErrors()) {
			mav.addObject("departamentos", departamentos);
			mav.setViewName("crearUsuario");
		}else {
			usuarioRepo.save(usuario);
			mav.setViewName("index");
		}
		
		return mav;
	}
}
