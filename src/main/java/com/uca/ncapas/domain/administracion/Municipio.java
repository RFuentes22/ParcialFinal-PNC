package com.uca.ncapas.domain.administracion;


import com.uca.ncapas.domain.proceso_negocio.Estudiante;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "administracion", name = "municipio")
public class Municipio {

    @Id
    @Column(name = "c_municipio")
    private Integer cmunicipio;

    @Column(name = "nombre")
    private String snombre;

    @Column(name = "c_departamento")
    private Integer cdepatamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_departamento")
    private Departamento departamento;

    @OneToMany(mappedBy = "municipio", fetch = FetchType.LAZY)
    private List<Estudiante> estudianteList;

    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Integer getCmunicipio() {
        return cmunicipio;
    }

    public void setCmunicipio(Integer cmunicipio) {
        this.cmunicipio = cmunicipio;
    }

    public String getSnombre() {
        return snombre;
    }

    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }

    public Integer getCdepatamento() {
        return cdepatamento;
    }

    public void setCdepatamento(Integer cdepatamento) {
        this.cdepatamento = cdepatamento;
    }
}
