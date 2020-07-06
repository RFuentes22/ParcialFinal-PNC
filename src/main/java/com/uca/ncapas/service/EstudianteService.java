package com.uca.ncapas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.uca.ncapas.domain.proceso_negocio.Estudiante;

public interface EstudianteService {
	
	public List<Estudiante> findAll() throws DataAccessException;
	
	public Estudiante findOne(Integer code) throws DataAccessException;
	
	public void save(Estudiante e) throws DataAccessException;
	
	public List<Estudiante> findNombres(String cadena) throws DataAccessException;
	
	public List<Estudiante> findApellidos(String cadena) throws DataAccessException;
	
	public Page<Estudiante> findAll(Pageable page) throws DataAccessException;

	public Long countAll();
 }
