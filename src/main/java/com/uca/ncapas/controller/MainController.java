package com.uca.ncapas.controller;

import com.uca.ncapas.domain.administracion.Departamento;
import com.uca.ncapas.domain.administracion.Municipio;
import com.uca.ncapas.domain.administracion.Usuario;
import com.uca.ncapas.service.DepartamentoService;
import com.uca.ncapas.service.MunicipioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	 @Autowired
	 private DepartamentoService departamentoService;

	 @Autowired
	 MunicipioService municipioService;

    @RequestMapping("/login")
    public ModelAndView Login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");

        return mav;
    }

    @RequestMapping("/signup")
    public ModelAndView Signup() {
        ModelAndView mav = new ModelAndView();
        List<Departamento> departamentos = null;
        List<Municipio> municipios = null;
        try {
			departamentos = departamentoService.findAll();
			municipios = municipioService.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
        mav.addObject("usuario", new Usuario());
        mav.addObject("departamentos", departamentos);
        mav.addObject("municipios", municipios);
        mav.setViewName("crearCuenta");
        return mav;
    }

    @PostMapping(value = "/municipio")
    @ResponseBody
    public List<Municipio> getModals(@RequestParam(value = "dep", required = true) String dep) {
      System.out.println("valor pasado como pasametro: " + dep);
    //  List<Municipio> municipios = null;
     // municipios = municipioService.findDepartamento(Integer.valueOf(dep));
     // model.addObject("municipios", municipios);
      return dep != null ? municipioService.findDepartamento(Integer.valueOf(dep)) : null;
    }




    //**************************CATALOGOS*********************************//

    @RequestMapping("/catalogoEscuela")
    public ModelAndView CatalogoEscuela() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("catalogos/catalogoEscuela");
        return mav;
    }

    @RequestMapping("/catalogoMateria")
    public ModelAndView CatalogoMateria() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("catalogos/catalogoMateria");
        return mav;
    }

    @RequestMapping("/catalogoUsuario")
    public ModelAndView CatalogoUsuario() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("catalogos/catalogoUsuario");
        return mav;
    }

    @RequestMapping("/escuela")
    public ModelAndView CrearEscuela() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("catalogos/crearEscuela");
        return mav;
    }

    @RequestMapping("/materia")
    public ModelAndView CrearMateria() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("catalogos/crearMateria");
        return mav;
    }

    @RequestMapping("/usuario")
    public ModelAndView CrearUsuario() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("catalogos/crearUsuario");
        return mav;
    }

}
