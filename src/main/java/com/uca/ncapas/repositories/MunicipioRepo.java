package com.uca.ncapas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.ncapas.domain.administracion.Municipio;

public interface MunicipioRepo extends JpaRepository<Municipio, Integer>{
	
	public List<Municipio> findByCdepatamento(Integer cdepatamento);
	
}
