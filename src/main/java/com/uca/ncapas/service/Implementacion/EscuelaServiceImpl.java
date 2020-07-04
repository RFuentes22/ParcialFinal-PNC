package com.uca.ncapas.service.Implementacion;

import java.util.List;

import com.uca.ncapas.domain.administracion.Municipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.ncapas.domain.administracion.Centro_escolar;
import com.uca.ncapas.repositories.EscuelaRepo;
import com.uca.ncapas.service.EscuelaService;

@Service
public class EscuelaServiceImpl implements EscuelaService{
	
	@Autowired
	EscuelaRepo escuelaRepo;

	@Override
	public List<Centro_escolar> findAll() throws DataAccessException {
		return escuelaRepo.findAll();
	}

	@Override
	public Centro_escolar findOne(Integer code) throws DataAccessException {
		return escuelaRepo.getOne(code);
	}

	@Override
	public void save(Centro_escolar c) throws DataAccessException {
		escuelaRepo.save(c);
		
	}

	@Override
	public List<Centro_escolar> filterNombre(String cadena) throws DataAccessException {
		return escuelaRepo.findBySnombre(cadena);
	}

	@Override
	public List<Centro_escolar> findByMun(Integer code) throws DataAccessException {
		return escuelaRepo.findByImunicipio(code);
	}


}
