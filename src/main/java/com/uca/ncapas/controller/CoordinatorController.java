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

        System.out.println(idusuario);

        if (idusuario == 0) {
            mav.setViewName("index");
        } else {
            usuario = usuarioService.findOne(idusuario);
            if (usuario.getBestado().equals(false)) {
                mav.setViewName("index");
            } else {
                mav.setViewName("coordinatorview");
            }
        }


        return mav;
    }

}
