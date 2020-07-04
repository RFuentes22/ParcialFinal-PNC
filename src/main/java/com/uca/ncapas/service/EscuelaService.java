package com.uca.ncapas.service;

import java.util.List;

import com.uca.ncapas.DTO.EscuelaDTO;
import com.uca.ncapas.domain.administracion.Municipio;
import org.springframework.dao.DataAccessException;

import com.uca.ncapas.domain.administracion.Centro_escolar;

public interface EscuelaService {
	
	public List<Centro_escolar> findAll() throws DataAccessException;
	
	public Centro_escolar findOne(Integer code) throws DataAccessException;
	
	public void save(Centro_escolar c) throws DataAccessException;
	
	public List<Centro_escolar> filterNombre(String cadena) throws DataAccessException;

	List<Centro_escolar> findByMun(Integer code) throws DataAccessException;

	List<EscuelaDTO> findschoolByMun(String cadena) throws DataAccessException;

}
