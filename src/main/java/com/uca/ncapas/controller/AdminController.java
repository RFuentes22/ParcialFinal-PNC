package com.uca.ncapas.controller;

import com.uca.ncapas.domain.administracion.Centro_escolar;
import com.uca.ncapas.domain.administracion.Departamento;
import com.uca.ncapas.domain.administracion.Materia;
import com.uca.ncapas.domain.administracion.Municipio;
import com.uca.ncapas.domain.administracion.Usuario;
import com.uca.ncapas.service.DepartamentoService;
import com.uca.ncapas.service.EscuelaService;
import com.uca.ncapas.service.MateriaService;
import com.uca.ncapas.service.MunicipioService;
import com.uca.ncapas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {


    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    MateriaService materiaService;
    
    @Autowired
    MunicipioService municipioService;
    
    @Autowired
    EscuelaService escuelaService;

    @Autowired
    private DepartamentoService departamentoService;

    static int idusuario = 0;
    Usuario usuario = null;

    @RequestMapping("/adminview")
    public ModelAndView AdminView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(validloginAdmin() ? "adminView" : "index");

        return mav;
    }


    @RequestMapping("/usuario")
    public ModelAndView CrearUsuario(Usuario usuario) {
        ModelAndView mav = new ModelAndView();

        if (validloginAdmin()) {
        List<Departamento> departamentos = null;
        List<Municipio> municipios = null;
        try {
            departamentos = departamentoService.findAll();
            municipios = municipioService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("usuario", new Usuario());
        mav.addObject("departamentos", departamentos);
        mav.addObject("municipios", municipios);
        mav.setViewName("catalogos/crearUsuario");
        }else mav.setViewName("index");

        return mav;
    }

    @RequestMapping("/filtroNombApll")
    public ModelAndView filtroNombApll() {
        ModelAndView mav = new ModelAndView();

        return mav;
    }

    @RequestMapping("/catalogoEscuela")
    public ModelAndView CatalogoEscuela() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(validloginAdmin() ? "catalogos/catalogoEscuela" : "index");
        return mav;
    }

    @RequestMapping("/catalogoMateria")
    public ModelAndView CatalogoMateria() {
        ModelAndView mav = new ModelAndView();
        List<Materia> materias = null;
        if (validloginAdmin()) {
            try {
                materias = materiaService.findAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mav.addObject("materias", materias);
            mav.addObject("save", 0);
            mav.setViewName("catalogos/catalogoMateria");

        }else mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/catalogoUsuario")
    public ModelAndView CatalogoUsuario() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(validloginAdmin() ? "catalogos/catalogoUsuario" : "index");
        return mav;
    }

    @RequestMapping("/activarCuenta")
    public ModelAndView ActivarCuenta() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(validloginAdmin() ? "activarCuenta" : "index");
        return mav;
    }

    @RequestMapping("/escuela")
    public ModelAndView CrearEscuela() {
        ModelAndView mav = new ModelAndView();
        if (validloginAdmin()) {
            List<Departamento> departamentos = null;
            List<Municipio> municipios = null;
            try {
                departamentos = departamentoService.findAll();
                municipios = municipioService.findAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mav.addObject("centro_escolar",new Centro_escolar());
            mav.addObject("departamentos",departamentos);
            mav.addObject("municipios", municipios);
            mav.setViewName("catalogos/crearEscuela");
        } else mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/materia")
    public ModelAndView CrearMateria() {
        ModelAndView mav = new ModelAndView();
        if (validloginAdmin()) {
            mav.addObject("materia", new Materia());
            mav.setViewName("catalogos/crearMateria");
        } else mav.setViewName("index");
        return mav;
    }

    public Boolean validloginAdmin() {
        return idusuario != 0;

    }
}
