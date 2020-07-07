package com.uca.ncapas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.uca.ncapas.domain.proceso_negocio.Estudiante;
import com.uca.ncapas.domain.proceso_negocio.Nota;

public interface NotaService {
	
	public List<Nota> findNotas(Integer code) throws DataAccessException;
	
	public Nota findOne(Integer code) throws DataAccessException;
	
	public void save(Nota n) throws DataAccessException;
	
	public Page<Nota> findById(Pageable page, Integer id ) throws DataAccessException;

	public Long countAll();
}
