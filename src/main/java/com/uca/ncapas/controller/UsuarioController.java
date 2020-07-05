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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.ncapas.domain.administracion.Departamento;
import com.uca.ncapas.domain.administracion.Materia;
import com.uca.ncapas.domain.administracion.Municipio;
import com.uca.ncapas.domain.administracion.Usuario;
import com.uca.ncapas.repositories.UsuarioRepo;
import com.uca.ncapas.service.DepartamentoService;
import com.uca.ncapas.service.MunicipioService;
import com.uca.ncapas.service.UsuarioService;

@Controller
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	MunicipioService municipioService;
	
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

			DateFormat fecha = new SimpleDateFormat("dd/mm/yyyy");
			Date convert = fecha.parse(usuario.getFfnacimiento());
			Date actual = new Date();

			SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
			Integer anio = Integer.parseInt(sdf.format(convert));
			Integer acanio = Integer.parseInt(sdf.format(actual));

			usuario.setIedad(acanio-anio);
			usuario.setBestado(false);
			usuarioService.save(usuario);
			mav.addObject("save", 2);
			mav.setViewName("catalogos/catalogoUsuario");

		}
		} else mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/editarUsuario")
    public ModelAndView editarUsuario(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView();
        
        List<Departamento> departamentos = null;
        List<Municipio> municipios = null;
        try {
            departamentos = departamentoService.findAll();
            municipios = municipioService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (AdminController.idusuario != 0) {
            Usuario u = usuarioService.findOne(id);
            mav.addObject("usuario", u);
            mav.addObject("departamentos", departamentos);
            mav.addObject("municipios", municipios);
            mav.setViewName("catalogos/crearUsuario");
        } else mav.setViewName("index");

        return mav;
    }
}
