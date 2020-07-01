package com.uca.ncapas.Implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.uca.ncapas.domain.proceso_negocio.Estudiante;
import com.uca.ncapas.repositories.EstudianteRepo;
import com.uca.ncapas.service.EstudianteService;

public class EstudianteServiceImpl implements EstudianteService{
	@Autowired
	EstudianteRepo estudianteRepo;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		return estudianteRepo.findAll();
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		return estudianteRepo.getOne(code);
	}

	@Override
	public void save(Estudiante e) throws DataAccessException {
		estudianteRepo.save(e);
	}

	@Override
	public List<Estudiante> findNombres(String cadena) throws DataAccessException {
		return estudianteRepo.findBySnombres(cadena);
	}

	@Override
	public List<Estudiante> findApellidos(String cadena) throws DataAccessException {
		return estudianteRepo.findBySapellidos(cadena);
	}

}
