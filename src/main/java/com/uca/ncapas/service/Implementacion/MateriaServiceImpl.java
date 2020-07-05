package com.uca.ncapas.service.Implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.uca.ncapas.domain.administracion.Materia;
import com.uca.ncapas.repositories.MateriaRepo;
import com.uca.ncapas.service.MateriaService;

@Service
public class MateriaServiceImpl implements MateriaService{
	@Autowired
	MateriaRepo materiaRepo;

	@Override
	public List<Materia> findAll() throws DataAccessException {
		return materiaRepo.findAll();
	}

	@Override
	public Materia findOne(Integer code) throws DataAccessException {
		return materiaRepo.getOne(code);
	}

	@Override
	public List<Materia> findNombre(String cadena) throws DataAccessException {
		return materiaRepo.findBySnombre(cadena);
	}

	@Override
	public void save(Materia m) throws DataAccessException {
		materiaRepo.save(m);
	}

	@Override
	public List<Materia> findAll(Sort sort) {
		return materiaRepo.findAll(sort);
	}

	@Override
	public Page<Materia> findAll(Pageable page) throws DataAccessException {
		return materiaRepo.findAll(page);
	}

	@Override
	public Long countAll() {
		return materiaRepo.count();
	}

}
