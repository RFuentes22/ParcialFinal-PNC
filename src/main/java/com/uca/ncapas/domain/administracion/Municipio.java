package com.uca.ncapas.domain.administracion;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
