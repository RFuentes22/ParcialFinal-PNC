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
public class SignController {

    @Autowired
    UsuarioRepo usuarioRepo;

    @Autowired
    private DepartamentoService departamentoService;


    @RequestMapping("/crearCuenta")
    public ModelAndView createCount(@Valid @ModelAttribute Usuario usuario, BindingResult result) throws ParseException {
        ModelAndView mav = new ModelAndView();
        List<Departamento> departamentos = null;
        try {
            departamentos = departamentoService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result.hasErrors()) {
            mav.addObject("departamentos", departamentos);
            mav.setViewName("crearCuenta");
        } else {

            if (usuarioRepo.findBySusuario(usuario.getSusuario()).size() != 0) {
                mav.addObject("save", 1);
                mav.addObject("departamentos", departamentos);
                mav.setViewName("crearCuenta");

            } else {
                DateFormat fecha = new SimpleDateFormat("dd/mm/yyyy");
                Date convert = fecha.parse(usuario.getFfnacimiento());
                Date actual = new Date();

                SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
                Integer anio = Integer.parseInt(sdf.format(convert));
                Integer acanio = Integer.parseInt(sdf.format(actual));

                usuario.setIedad(acanio - anio);

                if (usuario.getBadmin()) {
                    usuario.setBactivo(true);
                    usuario.setBestado(true);
                    usuarioRepo.save(usuario);
                    mav.setViewName("adminView");
                } else {
                    usuario.setBactivo(false);
                    usuario.setBestado(false);
                    usuarioRepo.save(usuario);
                    mav.setViewName("activarCuenta");
                }
                MainController.usuario = usuario;
            }
        }

        return mav;
    }
}
