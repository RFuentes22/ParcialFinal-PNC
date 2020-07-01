package com.uca.ncapas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.ncapas.domain.proceso_negocio.Nota;

public interface NotaRepo extends JpaRepository<Nota, Integer>{
	
	public List<Nota> findByCestudiante(Integer cestudiante);
	
}
