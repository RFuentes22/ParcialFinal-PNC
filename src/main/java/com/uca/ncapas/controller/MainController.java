package com.uca.ncapas.controller;

import com.uca.ncapas.domain.administracion.*;
import com.uca.ncapas.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    MunicipioService municipioService;

    @Autowired
    EscuelaService escuelaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    MateriaService materiaService;

    static Usuario usuario = null;
    public Boolean flagEstadoUser = false;

    @RequestMapping("/login")
    public ModelAndView Login() {
        ModelAndView mav = new ModelAndView();
        if (flagEstadoUser) {
            mav.addObject("estado", 0);
        }
        mav.setViewName("index");

        return mav;
    }

    @PostMapping(value = "/validLogin")
    public ModelAndView validLogin(@RequestParam(value = "user") String user, @RequestParam(value = "password") String pass) {
        ModelAndView mav = new ModelAndView();
        usuario = usuarioService.findUserByLogin(user, pass);

        if (usuario == null) {
            mav.addObject("passw", 1);
            System.out.println("Fallo login");
            mav.setViewName("index");
        } else {
            if (!flagEstadoUser) {
                if (usuario.getBadmin()) {
                    usuario.setBestado(true);
                    usuarioService.save(usuario);
                    flagEstadoUser = true;
                    mav.setViewName("adminView");
                    AdminController.idusuario = usuario.getCusuario();
                    System.out.println("Succes login Admin");
                } else {
                    if (usuario.getBactivo()) {
                        usuario.setBestado(true);
                        usuarioService.save(usuario);
                        flagEstadoUser = true;
                        mav.setViewName("coordinatorView");
                        CoordinatorController.idusuario = usuario.getCusuario();
                        SignController.idusuario = usuario.getCusuario();
                        System.out.println("Succes login Coordinator");
                    } else {
                        mav.addObject("activo", 0);
                        mav.setViewName("index");
                    }
                }
            } else {
                mav.addObject("estado", 1);
                mav.setViewName("index");
            }

        }

        return mav;
    }

    @RequestMapping(value = "/cerrarsesion")
    public ModelAndView closeLogin() {
        ModelAndView mav = new ModelAndView();
        if (usuario.getBestado()) {
            usuario.setBestado(false);
            usuarioService.save(usuario);
            flagEstadoUser = false;
            AdminController.idusuario = 0;
            CoordinatorController.idusuario = 0;
            SignController.idusuario = 0;
            System.out.println("Succes Close");
        }
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/signup")
    public ModelAndView Signup() {
        ModelAndView mav = new ModelAndView();
        List<Departamento> departamentos = null;
        try {
            departamentos = departamentoService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("save", 0);
        mav.addObject("usuario", new Usuario());
        mav.addObject("departamentos", departamentos);
        mav.setViewName("crearCuenta");
        return mav;
    }


    //Consultas
    @RequestMapping(value = "/municipio", method = RequestMethod.POST)
    @ResponseBody
    public List<Municipio> getModals(@RequestParam(value = "dep", required = true) String dep) {
        System.out.println("valor pasado como pasametro: " + dep);
        return dep != null ? municipioService.findDepartamento(Integer.valueOf(dep)) : null;
    }

    @RequestMapping(value = "/schools", method = RequestMethod.POST)
    @ResponseBody
    public List<Centro_escolar> getSchool(@RequestParam(value = "muni", required = true) String muni) {
        System.out.println("valor pasado como pasametro muni: " + muni);
        return muni != null ? escuelaService.findByMun(Integer.valueOf(muni)) : null;
    }


}
