package com.uca.ncapas.service.Implementacion;

import com.uca.ncapas.domain.administracion.Centro_escolar;
import com.uca.ncapas.repositories.EscuelaRepo;
import com.uca.ncapas.service.EscuelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

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

	@Override
	public Page<Centro_escolar> findAll(Pageable page) throws DataAccessException {
		return escuelaRepo.findAll(page);
	}

	@Override
	public Long countAll() {
		return escuelaRepo.count();
	}


}
