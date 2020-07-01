package com.uca.ncapas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.ncapas.domain.administracion.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer>{

}
