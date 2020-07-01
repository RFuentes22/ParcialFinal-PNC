package com.uca.ncapas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.ncapas.domain.administracion.Centro_escolar;

public interface EscuelaRepo extends JpaRepository<Centro_escolar, Integer>{
	
	public List<Centro_escolar> findBySnombre(String snombre);
}
