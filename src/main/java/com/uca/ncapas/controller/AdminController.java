package com.uca.ncapas.controller;

import com.uca.ncapas.domain.administracion.Usuario;
import com.uca.ncapas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {


    @Autowired
    private UsuarioService usuarioService;

    static int idusuario = 0;
    Usuario usuario = null;

    @RequestMapping("/adminview")
    public ModelAndView AdminView() {
        ModelAndView mav = new ModelAndView();
        System.out.println(idusuario);

        if (idusuario == 0) {
            mav.setViewName("index");
        } else {
            usuario = usuarioService.findOne(idusuario);
            if (usuario.getBestado().equals(false)) {
                mav.setViewName("index");
            } else {
                mav.setViewName("adminView");
            }
        }

        return mav;
    }

}
