package com.uca.ncapas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.ncapas.domain.administracion.Centro_escolar;

public interface EscuelaRepo extends JpaRepository<Centro_escolar, Integer>{

}
