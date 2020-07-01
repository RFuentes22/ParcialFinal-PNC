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

    Boolean flagEstadoUser = false;

    @PostMapping(value = "/validLogin")
    public ModelAndView validLogin(@RequestParam(value = "user") String user, @RequestParam(value = "password") String pass) {
        ModelAndView mav = new ModelAndView();
        Usuario usuario = usuarioService.findUserByLogin(user, pass);

        //List<Usuario> usuarioList = null;
        //usuarioList = usuarioService.findAll();

        if(flagEstadoUser){
            mav.addObject("estado", 1);
            mav.setViewName("index");
        }else {
            if (usuario == null) {
                System.out.println("Fallo login");
                mav.setViewName("index");
            } else {
                mav.setViewName("adminView");
                System.out.println("Succes login");
                flagEstadoUser = true;

            }
        }

        return mav;
    }

}
