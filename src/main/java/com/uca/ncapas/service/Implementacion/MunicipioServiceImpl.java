package com.uca.ncapas.service.Implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.uca.ncapas.domain.administracion.Municipio;
import com.uca.ncapas.repositories.MunicipioRepo;
import com.uca.ncapas.service.MunicipioService;

public class MunicipioServiceImpl implements MunicipioService{
	
	@Autowired
	MunicipioRepo municipioRepo;

	@Override
	public List<Municipio> findAll() throws DataAccessException {
		return municipioRepo.findAll();
	}

	@Override
	public Municipio findOne(Integer code) throws DataAccessException {
		return municipioRepo.getOne(code);
	}

	@Override
	public List<Municipio> findDepartamento(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
