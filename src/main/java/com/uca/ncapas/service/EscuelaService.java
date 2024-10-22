package com.uca.ncapas.service;

import com.uca.ncapas.domain.administracion.Centro_escolar;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EscuelaService {
	
	public List<Centro_escolar> findAll() throws DataAccessException;
	
	public Centro_escolar findOne(Integer code) throws DataAccessException;
	
	void save(Centro_escolar c) throws DataAccessException;
	
	public List<Centro_escolar> filterNombre(String cadena) throws DataAccessException;

	List<Centro_escolar> findByMun(Integer code) throws DataAccessException;
	
	public Page<Centro_escolar> findAll(Pageable page) throws DataAccessException;
	
	public Long countAll();

}
