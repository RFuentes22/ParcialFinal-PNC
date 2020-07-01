package com.uca.ncapas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.ncapas.domain.administracion.Materia;

public interface MateriaRepo extends JpaRepository<Materia, Integer>{
	
	public List<Materia> findBySnombre(String snombre);
	
}
