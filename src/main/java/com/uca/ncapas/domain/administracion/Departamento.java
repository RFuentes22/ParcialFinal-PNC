package com.uca.ncapas.domain.administracion;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "administracion", name = "departamento")
public class Departamento {

    @Id
    @Column(name = "c_departamento")
    private Integer cdepartamento;

    @Column(name = "nombre")
    private String snombre;

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
