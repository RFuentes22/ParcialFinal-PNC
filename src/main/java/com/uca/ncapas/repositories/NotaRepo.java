package com.uca.ncapas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.uca.ncapas.domain.proceso_negocio.Nota;

public interface NotaRepo extends JpaRepository<Nota, Integer>{
	
	public List<Nota> findByCestudiante(Integer cestudiante);
	
	@Query(value = "select count(n.nota) from proceso_negocio.estudiante e, proceso_negocio.nota n where e.c_estudiante = n.c_estudiante and n.nota >=6 and n.c_estudiante=:estudiante", nativeQuery = true)
    public Integer materiasAprobadas(@Param("estudiante") Integer estudiante);
	
	@Query(value = "select count(n.nota) from proceso_negocio.estudiante e, proceso_negocio.nota n where e.c_estudiante = n.c_estudiante and n.nota <6 and n.c_estudiante=:estudiante", nativeQuery = true)
    public Integer materiasReprobadas(@Param("estudiante") Integer estudiante);
	
	@Query(value = "select sum(n.nota)/count(n.c_materia)\r\n" + 
			"from proceso_negocio.estudiante e, proceso_negocio.nota n\r\n" + 
			"where e.c_estudiante = n.c_estudiante and n.nota >=6 and n.c_estudiante=:estudiante\r\n" + 
			"", nativeQuery = true)
    public Float promedio(@Param("estudiante") Integer estudiante);
	
}
