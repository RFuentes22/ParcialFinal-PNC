package com.uca.ncapas.controller;

import com.uca.ncapas.domain.administracion.Usuario;
import com.uca.ncapas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {


    @Autowired
    private UsuarioService usuarioService;

    static int idusuario = 0;
    Usuario usuario = null;

    @RequestMapping("/adminview")
    public ModelAndView AdminView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(validloginAdmin() ? "adminView" : "index");

        return mav;
    }


    public Boolean validloginAdmin() {
        if (idusuario == 0) return false;
        usuario = usuarioService.findOne(idusuario);
        return !usuario.getBestado().equals(false);
    }
}
