package com.uca.ncapas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uca.ncapas.DTO.TableDTO;
import com.uca.ncapas.domain.administracion.Centro_escolar;
import com.uca.ncapas.domain.administracion.Materia;
import com.uca.ncapas.domain.administracion.Usuario;
import com.uca.ncapas.domain.proceso_negocio.Estudiante;
import com.uca.ncapas.repositories.NotaRepo;
import com.uca.ncapas.service.EscuelaService;
import com.uca.ncapas.service.EstudianteService;
import com.uca.ncapas.service.MateriaService;
import com.uca.ncapas.service.UsuarioService;

@Controller
public class TableController {

	@Autowired
	MateriaService materiaService;
	
	@Autowired
	NotaRepo notaRepo;
	
	@Autowired
	EstudianteService estudianteService;
	
	@Autowired
	EscuelaService escuelaService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("/cargarMaterias")
    public @ResponseBody TableDTO cargarMaterias(@RequestParam Integer draw,
			@RequestParam Integer start, @RequestParam Integer length, 
			@RequestParam(value="search[value]", required = false) String search) {
		
		Page<Materia> materias = materiaService.findAll(PageRequest.of(start/length, length, Sort.by(Direction.ASC,"cmateria")));
		
		List<String[]> data = new ArrayList<>();
		
		for(Materia u : materias) {
			data.add(new String[] {u.getCmateria().toString(),u.getCmateria().toString(),u.getSnombre()});
		}
		
		TableDTO dto = new TableDTO();
		dto.setData(data);
		dto.setDraw(draw);
		dto.setRecordsFiltered(materiaService.countAll().intValue());
		dto.setRecordsTotal(materiaService.countAll().intValue());	
		
		return dto;
    }
	
	@RequestMapping("/cargarEscuelas")
    public @ResponseBody TableDTO cargarEscuelas(@RequestParam Integer draw,
			@RequestParam Integer start, @RequestParam Integer length, 
			@RequestParam(value="search[value]", required = false) String search) {
		
		Page<Centro_escolar> escuelas = escuelaService.findAll(PageRequest.of(start/length, length, Sort.by(Direction.ASC,"cescuela")));
		
		List<String[]> data = new ArrayList<>();
		
		for(Centro_escolar u : escuelas) {
			data.add(new String[] {u.getCescuela().toString(),u.getCescuela().toString(),u.getSnombre(),u.getSdireccion(),
					u.getDepartamento().getSnombre(), u.getMunicipio().getSnombre()});
		}
		
		TableDTO dto = new TableDTO();
		dto.setData(data);
		dto.setDraw(draw);
		dto.setRecordsFiltered(materiaService.countAll().intValue());
		dto.setRecordsTotal(materiaService.countAll().intValue());	
		
		return dto;
    }
	
	@RequestMapping("/cargarUsuarios")
    public @ResponseBody TableDTO cargarUsuarios(@RequestParam Integer draw,
			@RequestParam Integer start, @RequestParam Integer length, 
			@RequestParam(value="search[value]", required = false) String search) {
		
		Page<Usuario> usuarios = usuarioService.findAll(PageRequest.of(start/length, length, Sort.by(Direction.ASC,"cusuario")));
		
		List<String[]> data = new ArrayList<>();
		
		for(Usuario u : usuarios) {
			data.add(new String[] {u.getCusuario().toString(), u.getCusuario().toString(), u.getSusuario(),
					u.getBadmin()== true?"Administrador":"Coordinador",u.getFfnacimiento(), u.getSdireccion(),
							u.getDepartamento().getSnombre(),u.getMunicipio().getSnombre(),u.getBactivo()==true?"Activo":"Inactivo"});
		}
		
		TableDTO dto = new TableDTO();
		dto.setData(data);
		dto.setDraw(draw);
		dto.setRecordsFiltered(materiaService.countAll().intValue());
		dto.setRecordsTotal(materiaService.countAll().intValue());	
		
		return dto;
    }
	
	@RequestMapping("/cargarEstudiantes")
    public @ResponseBody TableDTO cargarEstudiantes(@RequestParam Integer draw,
			@RequestParam Integer start, @RequestParam Integer length, 
			@RequestParam(value="search[value]", required = false) String search) {
		
		Page<Estudiante> estudiantes = estudianteService.findAll(PageRequest.of(start/length, length, Sort.by(Direction.ASC,"cestudiante")));
		
		List<String[]> data = new ArrayList<>();
		int auxNotasA, auxNotasR;
		for(Estudiante u : estudiantes) {
			auxNotasA = notaRepo.materiasAprobadas(u.getCestudiante());
			auxNotasR = notaRepo.materiasReprobadas(u.getCestudiante());
			data.add(new String[] {});
		}
		
		TableDTO dto = new TableDTO();
		dto.setData(data);
		dto.setDraw(draw);
		dto.setRecordsFiltered(materiaService.countAll().intValue());
		dto.setRecordsTotal(materiaService.countAll().intValue());	
		
		return dto;
    }
}
