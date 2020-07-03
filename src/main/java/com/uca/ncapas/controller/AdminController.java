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

    Usuario usuario = null;
    Boolean flagEstadoUser = false;

    @PostMapping(value = "/validLogin")
    public ModelAndView validLogin(@RequestParam(value = "user") String user, @RequestParam(value = "password") String pass) {
        ModelAndView mav = new ModelAndView();
        usuario = usuarioService.findUserByLogin(user, pass);

        if (flagEstadoUser) {
            mav.addObject("estado", 1);
            mav.setViewName("index");
        } else {
            if (usuario == null) {
                System.out.println("Fallo login");
                mav.addObject("passw", 1);
                mav.setViewName("index");
            } else {
                if (validarActivoUser(usuario)) {
                    mav.setViewName("adminView");
                    usuario.setBestado(true);
                    usuarioService.save(usuario);
                    flagEstadoUser = true;
                    System.out.println("Succes login");
                } else {
                    mav.addObject("activo", 0);
                    mav.setViewName("index");
                }
            }
        }

        return mav;
    }

    @RequestMapping("/adminview")
    public ModelAndView AdminView() {
        ModelAndView mav = new ModelAndView();
        if (!flagEstadoUser) {
            mav.setViewName("index");
        } else {
            mav.setViewName("adminView");
        }
        return mav;
    }

    @RequestMapping(value = "/cerrarsesion")
    public ModelAndView validLogin() {
        ModelAndView mav = new ModelAndView();
        if (flagEstadoUser) {
            usuario.setBestado(false);
            usuarioService.save(usuario);
            System.out.println("Succes Close");
            flagEstadoUser = false;
        }
        mav.setViewName("index");
        return mav;
    }

    public Boolean validarActivoUser(Usuario usuario) {
        if (usuario.getBadmin()) {
            return true;
        } else {
            return usuario.getBactivo();
        }
    }
}
