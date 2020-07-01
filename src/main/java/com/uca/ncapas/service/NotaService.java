package com.uca.ncapas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.ncapas.domain.proceso_negocio.Nota;

public interface NotaService {
	
	public List<Nota> findNotas(Integer code) throws DataAccessException;
	
	public Nota findOne(Integer code) throws DataAccessException;
	
	public void save(Nota n) throws DataAccessException;
	
}
