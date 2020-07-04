package com.uca.ncapas.repositories;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import com.uca.ncapas.domain.administracion.Usuario;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {


    //Devuelve una lista de Usuarios cuyo User Y Password sea IGUAL a los enviados como parametro
    Usuario findBySusuarioAndScontrasena(String user, String pass);

    @Query(nativeQuery = true, value = "select * from administracion.usuario")
    List<Usuario> mostrarTodosUsuarios() throws DataAccessException;

    public List<Usuario> findBySusuario(String susuario);
    
}

