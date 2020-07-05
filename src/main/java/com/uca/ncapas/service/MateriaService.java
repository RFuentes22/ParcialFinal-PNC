package com.uca.ncapas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.uca.ncapas.domain.administracion.Materia;

public interface MateriaService {

	public List<Materia> findAll() throws DataAccessException;
	
	public Materia findOne(Integer code) throws DataAccessException;
	
	public List<Materia> findNombre(String cadena) throws DataAccessException;
	
	public void save(Materia m) throws DataAccessException;
	
	public List<Materia> findAll(Sort sort);
	
	public Page<Materia> findAll(Pageable page) throws DataAccessException;
	
	public Long countAll();
}
