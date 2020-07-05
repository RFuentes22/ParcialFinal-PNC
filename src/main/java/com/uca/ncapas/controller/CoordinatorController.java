package com.uca.ncapas.controller;

import com.uca.ncapas.domain.administracion.Centro_escolar;
import com.uca.ncapas.domain.administracion.Departamento;
import com.uca.ncapas.domain.administracion.Materia;
import com.uca.ncapas.domain.administracion.Usuario;
import com.uca.ncapas.domain.proceso_negocio.Estudiante;
import com.uca.ncapas.domain.proceso_negocio.Nota;
import com.uca.ncapas.service.DepartamentoService;
import com.uca.ncapas.service.EscuelaService;
import com.uca.ncapas.service.EstudianteService;
import com.uca.ncapas.service.MateriaService;
import com.uca.ncapas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CoordinatorController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private EscuelaService escuelaService;

    @Autowired
    private DepartamentoService departamentoService;
    
    @Autowired
    private MateriaService materiaService;

    static int idusuario = 0;
    Usuario usuario = null;

    @RequestMapping("/coordinatorview")
    public ModelAndView CoordinatorView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(validloginCoord() ? "coordinatorview" : "index");

        return mav;
    }

    @RequestMapping("/newalumno")
    public ModelAndView NuevoAlumno(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) throws ParseException {
        ModelAndView mav = new ModelAndView();

        if (validloginCoord()) {
            mav.setViewName("negocio/crearEstudiante");
            List<Departamento> departamentos = null;
            try {
                departamentos = departamentoService.findAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (result.hasErrors()) {
                mav.addObject("departamentos", departamentos);
                mav.setViewName("negocio/crearEstudiante");
            } else {
                DateFormat fecha = new SimpleDateFormat("dd/mm/yyyy");
                Date convert = fecha.parse(estudiante.getFfnacimiento());
                Date actual = new Date();

                SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
                Integer anio = Integer.parseInt(sdf.format(convert));
                Integer acanio = Integer.parseInt(sdf.format(actual));
                estudiante.setIedad(acanio-anio);
                estudianteService.save(estudiante);
                mav.setViewName("negocio/expedienteAlumnos");
            }
        } else mav.setViewName("index");


        return mav;
    }

    @RequestMapping("/alumnos")
    public ModelAndView ExpedienteAlumnos() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(validloginCoord() ? "negocio/expedienteAlumnos" : "index");
        return mav;
    }


    @RequestMapping("/lista")
    public ModelAndView ListaAlumnos() {
        ModelAndView mav = new ModelAndView();
        if (validloginCoord()) {
            mav.setViewName("negocio/listaAlumnos");
        } else mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/filter")
    public ModelAndView filterNombApll(@Valid @ModelAttribute("idfilter") String id) {
        ModelAndView mav = new ModelAndView();
        if (validloginCoord()) {
            if (id.equals("1")){

            }else{

            }
            mav.setViewName("negocio/listaAlumnos");
        } else mav.setViewName("index");


        return mav;
    }

    @RequestMapping("/editarexpediente")
    public ModelAndView EditarAlumno() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(validloginCoord() ? "negocio/editarEstudiante" : "index");
        return mav;
    }

    @RequestMapping("/materiascursadas")
    public ModelAndView MateriasCursadas() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(validloginCoord() ? "negocio/listaMateria" : "index");
        return mav;
    }

    @RequestMapping("/nuevamateriacursada")
    public ModelAndView NuevaMateria() {
        ModelAndView mav = new ModelAndView();
        List<Materia> materias = null;
		try {
			materias = materiaService.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
        mav.addObject("nota", new Nota());
        mav.setViewName(validloginCoord() ? "negocio/crearMateria" : "index");
        return mav;
    }




    /* View vacio */

    @RequestMapping("/expediente")
    public ModelAndView Expediente() {
        ModelAndView mav = new ModelAndView();
        if (validloginCoord()) {
            List<Departamento> departamentos = null;
            try {
                departamentos = departamentoService.findAll();

            } catch (Exception e) {
                e.printStackTrace();
            }
            mav.addObject("estudiante", new Estudiante());
            mav.addObject("departamentos", departamentos);
            mav.setViewName("negocio/crearEstudiante");
        } else mav.setViewName("index");
        return mav;

    }

    public Boolean validloginCoord() {
        if (idusuario == 0) return false;
        usuario = usuarioService.findOne(idusuario);
        return !usuario.getBestado().equals(false);
    }
}
