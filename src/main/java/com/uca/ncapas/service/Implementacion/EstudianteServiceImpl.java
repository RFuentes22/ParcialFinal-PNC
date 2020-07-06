package com.uca.ncapas.service.Implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.uca.ncapas.domain.proceso_negocio.Estudiante;
import com.uca.ncapas.repositories.EstudianteRepo;
import com.uca.ncapas.service.EstudianteService;

@Service
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
	public Page<Estudiante> findAll(Pageable page) throws DataAccessException {
		return estudianteRepo.findAll(page);
	}

	@Override
	public Long countAll() {
		return estudianteRepo.count();
	}


	@Override
	public Page<Estudiante> findByName(Pageable page, String name) throws DataAccessException {
		return estudianteRepo.findBySnombres(page, name);
	}

	@Override
	public Page<Estudiante> findByLastname(Pageable page, String last) throws DataAccessException {
		return estudianteRepo.findBySapellidos(page, last);
	}

	

	
}
