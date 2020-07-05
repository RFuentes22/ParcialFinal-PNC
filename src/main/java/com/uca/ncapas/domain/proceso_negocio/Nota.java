package com.uca.ncapas.domain.proceso_negocio;


import com.uca.ncapas.domain.administracion.Materia;
import com.uca.ncapas.domain.administracion.Municipio;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;

@Entity
@Table(schema = "proceso_negocio", name = "nota")
public class Nota {

    @Id
    //@GeneratedValue(generator="nota_c_nota_seq", strategy = GenerationType.AUTO)
    //@SequenceGenerator(name = "nota_c_nota_seq", sequenceName = "proceso_negocio.nota_c_nota_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_nota")
    private Integer idnota;

    @Column(name = "c_estudiante")
    private Integer cestudiante;

    @Column(name = "c_materia")
    @NotNull(message = "Debe seleccionar una materia")
    private Integer cmateria;

    @Column(name = "anio")
    @NotNull(message = "El campo año no puede quedar vacio")
    private Integer ianio;

    @Column(name = "ciclo")
    @NotNull(message = "Debe seleccionar un ciclo")
    private Integer iciclo;

    @Column(name = "nota")
    @NotNull(message = "El campo nota no puede quedar vacio")
    private Float inota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_estudiante",unique=true,insertable = false, updatable = false)
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_materia",unique=true,insertable = false, updatable = false)
    private Materia materia;


    public Integer getIdnota() {
        return idnota;
    }

    public void setIdnota(Integer idnota) {
        this.idnota = idnota;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

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
