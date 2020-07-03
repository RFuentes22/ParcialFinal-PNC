package com.uca.ncapas.controller;

import com.uca.ncapas.domain.administracion.Usuario;
import com.uca.ncapas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoordinatorController {

    @Autowired
    private UsuarioService usuarioService;

    static int idusuario = 0;
    Usuario usuario = null;

    @RequestMapping("/coordinatorview")
    public ModelAndView CoordinatorView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(validloginCoord() ? "coordinatorview" : "index");

        return mav;
    }

    @RequestMapping("/expediente")
    public ModelAndView NuevoAlumno() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("negocio/crearEstudiante");


        return mav;
    }


    public Boolean validloginCoord() {
        if (idusuario == 0) return false;
        usuario = usuarioService.findOne(idusuario);
        return !usuario.getBestado().equals(false);
    }
}
