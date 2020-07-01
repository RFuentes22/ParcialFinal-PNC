package com.uca.ncapas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.ncapas.domain.proceso_negocio.Estudiante;

public interface EstudianteRepo extends JpaRepository<Estudiante, Integer>{
	public List<Estudiante> findBySnombres(String snombres);
	
	public List<Estudiante> findBySapellidos(String sapellidos);
	
}
