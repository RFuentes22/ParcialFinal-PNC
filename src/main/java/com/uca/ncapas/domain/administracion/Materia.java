package com.uca.ncapas.domain.administracion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "administracion", name = "materia")
public class Materia {

    @Id
    @Column(name = "c_materia")
    private Integer cmateria;

    @Column(name = "nombre")
    private String snombre;

    public Integer getCmateria() {
        return cmateria;
    }

    public void setCmateria(Integer cmateria) {
        this.cmateria = cmateria;
    }

    public String getSnombre() {
        return snombre;
    }

    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }
}
