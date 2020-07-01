package com.uca.ncapas.Implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.uca.ncapas.domain.proceso_negocio.Nota;
import com.uca.ncapas.repositories.NotaRepo;
import com.uca.ncapas.service.NotaService;

public class NotaServiceImpl implements NotaService{
	
	@Autowired
	NotaRepo notaRepo;

	@Override
	public List<Nota> findNotas(Integer code) throws DataAccessException {
		return notaRepo.findByCestudiante(code);
	}

	@Override
	public Nota findOne(Integer code) throws DataAccessException {
		return notaRepo.getOne(code);
	}

	@Override
	public void save(Nota n) throws DataAccessException {
		notaRepo.save(n);
	}
	

}
