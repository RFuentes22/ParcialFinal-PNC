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
import com.uca.ncapas.domain.administracion.Materia;
import com.uca.ncapas.service.MateriaService;

@Controller
public class TableController {

	@Autowired
	MateriaService materiaService;
	
	@RequestMapping("/cargarMaterias")
    public @ResponseBody TableDTO cargarMaterias(@RequestParam Integer draw,
			@RequestParam Integer start, @RequestParam Integer length, 
			@RequestParam(value="search[value]", required = false) String search) {
		
		System.out.println("en cargar materias");
		
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
}
