package com.uca.ncapas.repositories;

import com.uca.ncapas.domain.administracion.Centro_escolar;
import com.uca.ncapas.domain.administracion.Usuario;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EscuelaRepo extends JpaRepository<Centro_escolar, Integer>{
	
	List<Centro_escolar> findBySnombre(String snombre);

	List<Centro_escolar> findByImunicipio(Integer codMun);

}
