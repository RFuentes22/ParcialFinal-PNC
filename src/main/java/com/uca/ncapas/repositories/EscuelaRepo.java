package com.uca.ncapas.repositories;

import com.uca.ncapas.domain.administracion.Centro_escolar;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface EscuelaRepo extends JpaRepository<Centro_escolar, Integer>{
	
	List<Centro_escolar> findBySnombre(String snombre);

	List<Centro_escolar> findByImunicipio(Integer codMun);
	
	public List<Centro_escolar> findAll(Sort sort);

}
