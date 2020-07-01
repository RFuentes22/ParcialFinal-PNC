package com.uca.ncapas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.ncapas.domain.administracion.Usuario;

public interface UsuarioService {
	
	public List<Usuario> findAll() throws DataAccessException;
	
	public Usuario findOne(Integer code) throws DataAccessException;
	
	public void save(Usuario u) throws DataAccessException;
	
	public Usuario findUsuario(String cadena) throws DataAccessException;
}
