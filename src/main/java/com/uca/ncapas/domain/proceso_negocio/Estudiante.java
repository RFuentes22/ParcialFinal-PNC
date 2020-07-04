package com.uca.ncapas.domain.proceso_negocio;


import com.uca.ncapas.domain.administracion.Centro_escolar;
import com.uca.ncapas.domain.administracion.Departamento;
import com.uca.ncapas.domain.administracion.Municipio;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;

@Entity
@Table(schema = "proceso_negocio", name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(generator="estudiante_c_estudiante_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "estudiante_c_estudiante_seq", sequenceName = "proceso_negocio.estudiante_c_estudiante_seq")
    @Column(name = "c_estudiante")
    private Integer cestudiante;

    @Column(name = "nombres")
    @NotEmpty(message = "El Nombre del estudiante no puede quedar vacio")
    @Size(max = 100, message = "El Nombre del estudiante debe tener maximo 100 caracteres")
    private String snombres;

    @Column(name = "apellidos")
    @NotEmpty(message = "El Apellido del estudiante no puede quedar vacio")
    @Size(max = 100, message = "El Apellido del estudiante debe tener maximo 100 caracteres")
    private String sapellidos;

    @Column(name = "carnet")
    @NotEmpty(message = "El Carnet del estudiante no puede quedar vacio")
    @Size(min = 9,max = 9,message = "El Carnet del estudiante debe tener 9 caracteres")
    private String ccarnet;

    @Column(name = "fnacimiento")
    @NotEmpty(message = "La Fecha de nacimiento del estudiante no puede quedar vacio")
    private String ffnacimiento;

    @Column(name = "direccion")
    @NotEmpty(message = "La Direccion del estudiante no puede quedar vacio")
    @Size(max = 150, message = "La Direccion del estudiante debe tener maximo 150 caracteres")
    private String sdireccion;

    @Column(name = "departamento")
    @NotNull(message = "El Departamento del estudiante no puede quedar vacio")
    private Integer cdepartamento;

    @Column(name = "municipio")
    @NotNull(message = "El Municipio del estudiante no puede quedar vacio")
    private Integer cmunicipio;

    @Column(name = "telefono")
    @NotNull(message = "El campo Telefono no puede quedar vacio")
    //@Max(value = 10, message = "El campo Telefono debe tener maximo 10 digitos")
    private Integer itelefono;

    @Column(name = "celular")
    @NotNull(message = "El campo Celular no puede quedar vacio")
    //@Max(value = 10, message = "El campo Celular debe tener maximo 10 caracteres")
    private Integer icelular;

    @Column(name = "escuela")
    @NotNull(message = "Escuela del estudiante no puede quedar vacio")
    private Integer cescuela;

    @Column(name = "nombre_madre")
    @NotEmpty(message = "El Nombre de la Madre del estudiante no puede quedar vacio")
    @Size(max = 150, message = "El Nombre de la Madre del estudiante debe tener maximo 150 caracteres")
    private String snombre_madre;

    @Column(name = "nombre_padre")
    @NotEmpty(message = "El Nombre del Padre del estudiante no puede quedar vacio")
    @Size(max = 150, message = "El Nombre del Padre del estudiante debe tener maximo 150 caracteres")
    private String snombre_padre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "escuela",unique=true,insertable = false, updatable = false)
    private Centro_escolar centro_escolar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "municipio",unique=true,insertable = false, updatable = false)
    private Municipio municipio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamento",unique=true,insertable = false, updatable = false)
    private Departamento departamento;

    public Centro_escolar getCentro_escolar() {
        return centro_escolar;
    }

    public void setCentro_escolar(Centro_escolar centro_escolar) {
        this.centro_escolar = centro_escolar;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Integer getCestudiante() {
        return cestudiante;
    }

    public void setCestudiante(Integer cestudiante) {
        this.cestudiante = cestudiante;
    }

    public String getSnombres() {
        return snombres;
    }

    public void setSnombres(String snombres) {
        this.snombres = snombres;
    }

    public String getSapellidos() {
        return sapellidos;
    }

    public void setSapellidos(String sapellidos) {
        this.sapellidos = sapellidos;
    }

    public String getCcarnet() {
        return ccarnet;
    }

    public void setCcarnet(String ccarnet) {
        this.ccarnet = ccarnet;
    }

    public String getFfnacimiento() {
        return ffnacimiento;
    }

    public void setFfnacimiento(String ffnacimiento) {
        this.ffnacimiento = ffnacimiento;
    }

    public String getSdireccion() {
        return sdireccion;
    }

    public void setSdireccion(String sdireccion) {
        this.sdireccion = sdireccion;
    }

    public Integer getCdepartamento() {
        return cdepartamento;
    }

    public void setCdepartamento(Integer cdepartamento) {
        this.cdepartamento = cdepartamento;
    }

    public Integer getCmunicipio() {
        return cmunicipio;
    }

    public void setCmunicipio(Integer cmunicipio) {
        this.cmunicipio = cmunicipio;
    }

    public Integer getItelefono() {
        return itelefono;
    }

    public void setItelefono(Integer itelefono) {
        this.itelefono = itelefono;
    }

    public Integer getIcelular() {
        return icelular;
    }

    public void setIcelular(Integer icelular) {
        this.icelular = icelular;
    }

    public Integer getCescuela() {
        return cescuela;
    }

    public void setCescuela(Integer cescuela) {
        this.cescuela = cescuela;
    }

    public String getSnombre_madre() {
        return snombre_madre;
    }

    public void setSnombre_madre(String snombre_madre) {
        this.snombre_madre = snombre_madre;
    }

    public String getSnombre_padre() {
        return snombre_padre;
    }

    public void setSnombre_padre(String snombre_padre) {
        this.snombre_padre = snombre_padre;
    }
}
