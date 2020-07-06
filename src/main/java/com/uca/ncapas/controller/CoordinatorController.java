package com.uca.ncapas.controller;

import com.uca.ncapas.DTO.TableDTO;
import com.uca.ncapas.domain.administracion.*;
import com.uca.ncapas.domain.proceso_negocio.Estudiante;
import com.uca.ncapas.domain.proceso_negocio.Nota;
import com.uca.ncapas.repositories.NotaRepo;
import com.uca.ncapas.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CoordinatorController {

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private MateriaService materiaService;

    @Autowired
    MunicipioService municipioService;

    @Autowired
    EscuelaService escuelaService;

    @Autowired
    NotaRepo notaRepo;

    Integer tipoFilter;
    String valorFilter;

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
                if (MainController.usuario.getCusuario() == null){
                    mav.setViewName("negocio/crearEstudiante");
                }else {mav.setViewName("negocio/editarEstudiante");}

            } else {
                DateFormat fecha = new SimpleDateFormat("dd/mm/yyyy");
                Date convert = fecha.parse(estudiante.getFfnacimiento());
                Date actual = new Date();

                SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
                Integer anio = Integer.parseInt(sdf.format(convert));
                Integer acanio = Integer.parseInt(sdf.format(actual));
                estudiante.setIedad(acanio - anio);
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
    public ModelAndView ListaAlumnos(@RequestParam Integer tipo,
                                     @RequestParam(required = true) String valor) {
        ModelAndView mav = new ModelAndView();
        if (validloginCoord()) {
            mav.setViewName("negocio/listaAlumnos");
            tipoFilter = tipo;
            valorFilter = valor;
        } else mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/filterStudent")
    public @ResponseBody TableDTO filterStudent(@RequestParam Integer draw,
                                                @RequestParam Integer start, @RequestParam Integer length,
                                                @RequestParam(value="search[value]", required = false) String search) {

        Page<Estudiante> estudiantes = null;
        List<String[]> data = new ArrayList<>();
        System.out.println(tipoFilter.toString());
        System.out.println(valorFilter.toString());


        if (tipoFilter.equals(1)) {
            estudiantes = estudianteService.findByName(PageRequest.of(start / length, length, Sort.by(Sort.Direction.ASC, "cestudiante")),valorFilter);
            System.out.println("Filtrar Nombre");
        }else {
            estudiantes = estudianteService.findByLastname(PageRequest.of(start / length, length, Sort.by(Sort.Direction.ASC, "cestudiante")),valorFilter);
            System.out.println("Filtrar Apellido");
        }

        Integer auxNotasA, auxNotasR;
        Float promedio;
        for(Estudiante u : estudiantes) {
            auxNotasA = notaRepo.materiasAprobadas(u.getCestudiante());
            auxNotasR = notaRepo.materiasReprobadas(u.getCestudiante());
            promedio = notaRepo.promedio(u.getCestudiante());
            
            //validar si algun campo es null
            String notaA="",notaB="",notaP="";
            if(auxNotasA==null) {notaA="0";}else{notaA=auxNotasA.toString();};
            if(auxNotasR==null) {notaB="0";}else{notaB=auxNotasR.toString();};
            if(promedio==null) {notaP="0";}else{notaP=promedio.toString();};
            
            
            data.add(new String[] {u.getCestudiante().toString(),u.getSnombres(),u.getSapellidos(), 
            		notaA,notaB,notaP});
            System.out.println(data.toString());
        }

        TableDTO dto = new TableDTO();
        dto.setData(data);
        dto.setDraw(draw);
        dto.setRecordsFiltered(estudianteService.countAll().intValue());
        dto.setRecordsTotal(estudianteService.countAll().intValue());

        return dto;


    }
    @RequestMapping("/editarexpediente")
    public ModelAndView EditarAlumno(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView();
        List<Departamento> departamentos = null;
        List<Municipio> municipios = null;
        List<Centro_escolar> centro_escolars = null;
        try {
            departamentos = departamentoService.findAll();
            municipios = municipioService.findAll();
            centro_escolars = escuelaService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (validloginCoord()) {
            Estudiante e = estudianteService.findOne(id);
            mav.addObject("estudiante", e);
            mav.addObject("departamentos", departamentos);
            mav.addObject("municipios", municipios);
            mav.addObject("escuelas", centro_escolars);
            mav.setViewName("negocio/editarEstudiante");
        }
        else mav.setViewName("index");
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
        if (validloginCoord()) {
            mav.setViewName("negocio/crearMateria");
            try {
                materias = materiaService.findAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mav.addObject("materias", materias);
            mav.addObject("nota", new Nota());
        } else mav.setViewName("index");
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

    public static Boolean validloginCoord() {
        if (MainController.usuario == null) {
            System.out.println("Coord no ha ingresado");
            return false;
        } else {
            return MainController.usuario.getBadmin().equals(false) && MainController.usuario.getBestado().equals(true);
        }
    }

}
