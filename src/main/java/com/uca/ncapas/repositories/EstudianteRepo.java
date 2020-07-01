package com.uca.ncapas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.ncapas.domain.proceso_negocio.Estudiante;

public interface EstudianteRepo extends JpaRepository<Estudiante, Integer>{

}
