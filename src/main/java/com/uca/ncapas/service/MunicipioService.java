package com.uca.ncapas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.ncapas.domain.administracion.Municipio;

public interface MunicipioService {
	
	public List<Municipio> findAll() throws DataAccessException;
	
	public Municipio findOne(Integer code) throws DataAccessException;
	
	public List<Municipio> findDepartamento(Integer code) throws DataAccessException;
}
