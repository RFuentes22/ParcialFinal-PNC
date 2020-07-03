package com.uca.ncapas.controller;

import com.uca.ncapas.domain.administracion.Departamento;
import com.uca.ncapas.domain.administracion.Municipio;
import com.uca.ncapas.domain.administracion.Usuario;
import com.uca.ncapas.service.DepartamentoService;
import com.uca.ncapas.service.MunicipioService;
import java.util.List;
import com.uca.ncapas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    MunicipioService municipioService;

    @Autowired
    private UsuarioService usuarioService;

    Usuario usuario = null;
    public Boolean flagEstadoUser = false;
    AdminController adminController = new AdminController();


    @RequestMapping("/login")
    public ModelAndView Login() {
        ModelAndView mav = new ModelAndView();
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
                    CoordinatorController.idusuario=usuario.getCusuario();
                    System.out.println("Succes login Coordinator");
                } else {
                    mav.addObject("activo", 0);
                    mav.setViewName("index");
                }
            }

        }

        return mav;
    }

    @RequestMapping(value = "/cerrarsesion")
    public ModelAndView validLogin() {
        ModelAndView mav = new ModelAndView();
        if (usuario.getBestado()) {
            usuario.setBestado(false);
            usuarioService.save(usuario);
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
		}catch (Exception e) {
			e.printStackTrace();
		}
        mav.addObject("usuario", new Usuario());
        mav.addObject("departamentos", departamentos);
        mav.setViewName("crearCuenta");
        return mav;
    }

    @RequestMapping(value = "/municipio", method = RequestMethod.POST)
	    @ResponseBody
	    public List<Municipio> getModals(@RequestParam(value = "dep", required = true) String dep) {
	      System.out.println("valor pasado como pasametro: " + dep);
	      return dep != null ? municipioService.findDepartamento(Integer.valueOf(dep)) : null;
	    }




    //**************************CATALOGOS*********************************//

    @RequestMapping("/catalogoEscuela")
    public ModelAndView CatalogoEscuela() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("catalogos/catalogoEscuela");
        return mav;
    }

    @RequestMapping("/catalogoMateria")
    public ModelAndView CatalogoMateria() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("catalogos/catalogoMateria");
        return mav;
    }

    @RequestMapping("/catalogoUsuario")
    public ModelAndView CatalogoUsuario() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("catalogos/catalogoUsuario");
        return mav;
    }

    @RequestMapping("/escuela")
    public ModelAndView CrearEscuela() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("catalogos/crearEscuela");
        return mav;
    }

    @RequestMapping("/materia")
    public ModelAndView CrearMateria() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("catalogos/crearMateria");
        return mav;
    }

    @RequestMapping("/usuario")
    public ModelAndView CrearUsuario() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("catalogos/crearUsuario");
        return mav;
    }

    //**************************PROCESOS DE NEGOCIO*********************************//

    @RequestMapping("/alumnos")
    public ModelAndView ExpedienteAlumnos() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("negocio/expedienteAlumnos");
        return mav;
    }

    @RequestMapping("/lista")
    public ModelAndView ListaAlumnos() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("negocio/listaAlumnos");
        return mav;
    }

    @RequestMapping("/expediente")
    public ModelAndView NuevoAlumno() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("negocio/crearEstudiante");
        return mav;
    }
    
    @RequestMapping("/editarexpediente")
    public ModelAndView EditarAlumno() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("negocio/editarEstudiante");
        return mav;
    }

    @RequestMapping("/materiascursadas")
    public ModelAndView MateriasCursadas() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("negocio/listaMateria");
        return mav;
    }

    @RequestMapping("/nuevamateriacursada")
    public ModelAndView NuevaMateria() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("negocio/crearMateria");
        return mav;
    }
}
