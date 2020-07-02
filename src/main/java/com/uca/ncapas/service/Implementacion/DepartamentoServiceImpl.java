package com.uca.ncapas.service.Implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.uca.ncapas.domain.administracion.Departamento;
import com.uca.ncapas.repositories.DepartamentoRepo;
import com.uca.ncapas.service.DepartamentoService;

public class DepartamentoServiceImpl implements DepartamentoService{
	
	@Autowired
	DepartamentoRepo departamentoRepo;

	@Override
	public List<Departamento> findAll() throws DataAccessException {
		return departamentoRepo.findAll();
	}

	@Override
	public Departamento findOne(Integer code) throws DataAccessException {
		return departamentoRepo.getOne(code);
	}

}
