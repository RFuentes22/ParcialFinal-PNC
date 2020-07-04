package com.uca.ncapas.repositories;

import com.uca.ncapas.domain.administracion.Centro_escolar;
import com.uca.ncapas.domain.administracion.Usuario;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EscuelaRepo extends JpaRepository<Centro_escolar, Integer>{
	
	List<Centro_escolar> findBySnombre(String snombre);

	@Query(nativeQuery = true, value = "select administracion.centro_escolar.c_escuela,administracion.centro_escolar.nombre from administracion.centro_escolar,administracion.municipio where  administracion.centro_escolar.municipio = administracion.municipio.c_municipio and administracion.municipio.nombre = :snombreMuni")
	List<Object[]> mostrarEscuelasByMun(String snombreMuni) throws DataAccessException;

	List<Centro_escolar> findByImunicipio(Integer codMun);

}
