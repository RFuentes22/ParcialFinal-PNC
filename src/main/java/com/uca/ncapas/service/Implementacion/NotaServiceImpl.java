package com.uca.ncapas.service.Implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.uca.ncapas.domain.proceso_negocio.Nota;
import com.uca.ncapas.repositories.NotaRepo;
import com.uca.ncapas.service.NotaService;

@Service
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

	@Override
	public Page<Nota> findById(Pageable page, Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return notaRepo.findByIdnota(page, id);
	}

	@Override
	public Long countAll() {
		// TODO Auto-generated method stub
		return notaRepo.count();
	}
	

}
