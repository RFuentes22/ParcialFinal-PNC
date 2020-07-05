package com.uca.ncapas.service.Implementacion;

import com.uca.ncapas.domain.administracion.Usuario;
import com.uca.ncapas.repositories.UsuarioRepo;
import com.uca.ncapas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        return usuarioRepo.getOne(code);
    }

    @Override
    @Transactional
    public void save(Usuario usuario) throws DataAccessException {
        usuarioRepo.save(usuario);
    }

    @Override
    public Usuario findUserByLogin(String user, String pass) throws DataAccessException {
        return usuarioRepo.findBySusuarioAndScontrasena(user, pass);
    }

	@Override
	public List<Usuario> findByUser(String user) throws DataAccessException {
		return usuarioRepo.findBySusuario(user);
	}

	@Override
	public Page<Usuario> findAll(Pageable page) throws DataAccessException {
		return usuarioRepo.findAll(page);
	}

	@Override
	public Long countAll() {
		return usuarioRepo.count();
	}


}
