package com.uca.ncapas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.ncapas.domain.administracion.Departamento;

public interface DepartamentoService {

	public List<Departamento> findAll() throws DataAccessException;
	
	public Departamento findOne(Integer code) throws DataAccessException;
	
}
