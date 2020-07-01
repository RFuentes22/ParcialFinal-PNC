package com.uca.ncapas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.ncapas.domain.administracion.Materia;

public interface MateriaService {

	public List<Materia> findAll() throws DataAccessException;
	
	public Materia findOne(Integer code) throws DataAccessException;
	
	public List<Materia> findNombre(String cadena) throws DataAccessException;
	
	public void save(Materia m) throws DataAccessException;
}
