package com.uca.ncapas.domain.administracion;


import com.uca.ncapas.domain.proceso_negocio.Estudiante;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "administracion", name = "departamento")
public class Departamento {

    @Id
    @Column(name = "c_departamento")
    private Integer cdepartamento;

    @Column(name = "nombre")
    private String snombre;

    @OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY)
    private List<Municipio> municipioList;

    @OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY)
    private List<Centro_escolar> centro_escolarList;

    @OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY)
    private List<Estudiante> estudianteList;

    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }

    public List<Centro_escolar> getCentro_escolarList() {
        return centro_escolarList;
    }

    public void setCentro_escolarList(List<Centro_escolar> centro_escolarList) {
        this.centro_escolarList = centro_escolarList;
    }

    public List<Municipio> getMunicipioList() {
        return municipioList;
    }

    public void setMunicipioList(List<Municipio> municipioList) {
        this.municipioList = municipioList;
    }

    public Integer getCdepartamento() {
        return cdepartamento;
    }

    public void setCdepartamento(Integer cdepartamento) {
        this.cdepartamento = cdepartamento;
    }

    public String getSnombre() {
        return snombre;
    }

    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }
}
