package com.uca.ncapas.controller;

import com.uca.ncapas.domain.administracion.Materia;
import com.uca.ncapas.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class MateriaController {

    @Autowired
    MateriaService materiaService;


    @RequestMapping("/saveMateria")
    public ModelAndView saveMateria(@Valid @ModelAttribute Materia materia, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        if (AdminController.validloginAdmin()) {
            if (result.hasErrors()) {
                mav.setViewName("catalogos/crearMateria");
            } else {
                materiaService.save(materia);
                mav.addObject("save", 1);
                mav.setViewName("catalogos/catalogoMateria");
            }
        } else mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/editarMateria")
    public ModelAndView CrearMateria(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView();
        if (AdminController.validloginAdmin()) {
            Materia m = materiaService.findOne(id);
            mav.addObject("materia", m);
            mav.setViewName("catalogos/crearMateria");
        } else mav.setViewName("index");

        return mav;
    }
}
