package com.uca.ncapas.service;

import com.uca.ncapas.domain.administracion.Usuario;
import com.uca.ncapas.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepo usuarioRepo;

    @Override
    public List<Usuario> findAll() throws DataAccessException {
        return usuarioRepo.mostrarTodosUsuarios();
    }

    @Override
    public Usuario findOne(Integer code) throws DataAccessException {
        return null;
    }

    @Override
    public void save(Usuario u) throws DataAccessException {

    }

    @Override
    public Usuario findUserByLogin(String user,String pass) throws DataAccessException {
       return usuarioRepo.findBySusuarioAndScontrasena(user,pass);

    }
}
