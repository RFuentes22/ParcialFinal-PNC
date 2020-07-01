package com.uca.ncapas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.ncapas.domain.administracion.Departamento;

public interface DepartamentoRepo extends JpaRepository<Departamento, Integer>{

}
