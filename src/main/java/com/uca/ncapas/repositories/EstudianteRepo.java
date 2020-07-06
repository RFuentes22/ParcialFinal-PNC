package com.uca.ncapas.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.ncapas.domain.proceso_negocio.Estudiante;

public interface EstudianteRepo extends JpaRepository<Estudiante, Integer>{
	
	public Page<Estudiante> findBySnombres(Pageable page, String snombres);
	

	public Page<Estudiante> findBySapellidos(Pageable page, String sapellidos);
	
}
