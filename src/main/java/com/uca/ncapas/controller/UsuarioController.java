package com.uca.ncapas.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.ncapas.domain.administracion.Departamento;
import com.uca.ncapas.domain.administracion.Usuario;
import com.uca.ncapas.repositories.UsuarioRepo;
import com.uca.ncapas.service.DepartamentoService;

@Controller
public class UsuarioController {
	@Autowired
	UsuarioRepo usuarioRepo;
	
	 @Autowired
	 private DepartamentoService departamentoService;

		
	@RequestMapping("/saveUser")
	public ModelAndView createCount(@Valid @ModelAttribute Usuario usuario, BindingResult result ) throws ParseException {
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
			mav.setViewName("catalogos/crearUsuario");
		}else {

			if(usuarioRepo.findBySusuario(usuario.getSusuario()).size()!=0) {
				mav.addObject("save", 1);
				mav.addObject("departamentos", departamentos);
				mav.setViewName("catalogos/crearUsuario");

			}else {
				DateFormat fecha = new SimpleDateFormat("dd/mm/yyyy");
				Date convert = fecha.parse(usuario.getFfnacimiento());
				Date actual = new Date();

				SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
				Integer anio = Integer.parseInt(sdf.format(convert));
				Integer acanio = Integer.parseInt(sdf.format(actual));

				usuario.setIedad(acanio-anio);
				usuario.setBestado(false);
				usuarioRepo.save(usuario);
				mav.addObject("usuario", new Usuario());
				mav.addObject("departamentos",departamentos);
				mav.addObject("exito", 1);
				mav.setViewName("catalogos/crearUsuario");
			}
		}
		} else mav.setViewName("index");
		return mav;
	}
}
