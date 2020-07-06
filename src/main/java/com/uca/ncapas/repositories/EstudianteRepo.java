package com.uca.ncapas.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.ncapas.domain.proceso_negocio.Estudiante;

public interface EstudianteRepo extends JpaRepository<Estudiante, Integer>{
	
	@Query(value = "SELECT * FROM proceso_negocio.estudiante WHERE nombres = :snombres  ORDER BY c_estudiante \n-- #page\n",
			  countQuery = "SELECT count(*) FROM proceso_negocio.estudiante",
			  nativeQuery = true)
	public Page<Estudiante> findBySnombres(Pageable page, String snombres);
	
	@Query(value = "SELECT * FROM proceso_negocio.estudiante WHERE nombres = :snombres  ORDER BY c_estudiante \n-- #page\n",
			  countQuery = "SELECT count(*) FROM proceso_negocio.estudiante",
			  nativeQuery = true)
	public Page<Estudiante> findBySapellidos(Pageable page, String sapellidos);
	
}
