package com.uca.ncapas.domain.proceso_negocio;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "proceso_negocio", name = "notas")
public class Nota {

    @Id
    @Column(name = "c_estudiante")
    private Integer cestudiante;

    @Column(name = "c_materia")
    private Integer cmateria;

    @Column(name = "anio")
    private Integer ianio;

    @Column(name = "ciclo")
    private Integer iciclo;

    @Column(name = "nota")
    private Float inota;

    public Integer getCestudiante() {
        return cestudiante;
    }

    public void setCestudiante(Integer cestudiante) {
        this.cestudiante = cestudiante;
    }

    public Integer getCmateria() {
        return cmateria;
    }

    public void setCmateria(Integer cmateria) {
        this.cmateria = cmateria;
    }

    public Integer getIanio() {
        return ianio;
    }

    public void setIanio(Integer ianio) {
        this.ianio = ianio;
    }

    public Integer getIciclo() {
        return iciclo;
    }

    public void setIciclo(Integer iciclo) {
        this.iciclo = iciclo;
    }

    public Float getInota() {
        return inota;
    }

    public void setInota(Float inota) {
        this.inota = inota;
    }
}
