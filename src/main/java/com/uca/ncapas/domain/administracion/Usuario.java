package com.uca.ncapas.domain.administracion;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(schema = "administracion", name = "usuario")
public class Usuario {

    @Id
    @Column(name = "c_usuario")
    private Integer cusuario;

    @Column(name = "usuario")
    private String susuario;

    @Column(name = "contrasena")
    private String scontrasena;

    @Column(name = "estado")
    private Boolean bestado;

    @Column(name = "admin")
    private Boolean badmin;

    @Column(name = "fnacimiento")
    private Date ffnacimiento;

    @Column(name = "edad")
    private Integer iedad;

    @Column(name = "direccion")
    private String sdireccion;

    @Column(name = "departamento")
    private Integer idepartamento;

    @Column(name = "municipio")
    private Integer imunicipio;

    @Column(name = "activo")
    private Boolean bactivo;

    public Integer getCusuario() {
        return cusuario;
    }

    public void setCusuario(Integer cusuario) {
        this.cusuario = cusuario;
    }

    public String getSusuario() {
        return susuario;
    }

    public void setSusuario(String susuario) {
        this.susuario = susuario;
    }

    public String getScontrasena() {
        return scontrasena;
    }

    public void setScontrasena(String scontrasena) {
        this.scontrasena = scontrasena;
    }

    public Boolean getBestado() {
        return bestado;
    }

    public void setBestado(Boolean bestado) {
        this.bestado = bestado;
    }

    public Boolean getBadmin() {
        return badmin;
    }

    public void setBadmin(Boolean badmin) {
        this.badmin = badmin;
    }

    public Date getFfnacimiento() {
        return ffnacimiento;
    }

    public void setFfnacimiento(Date ffnacimiento) {
        this.ffnacimiento = ffnacimiento;
    }

    public Integer getIedad() {
        return iedad;
    }

    public void setIedad(Integer iedad) {
        this.iedad = iedad;
    }

    public String getSdireccion() {
        return sdireccion;
    }

    public void setSdireccion(String sdireccion) {
        this.sdireccion = sdireccion;
    }

    public Integer getIdepartamento() {
        return idepartamento;
    }

    public void setIdepartamento(Integer idepartamento) {
        this.idepartamento = idepartamento;
    }

    public Integer getImunicipio() {
        return imunicipio;
    }

    public void setImunicipio(Integer imunicipio) {
        this.imunicipio = imunicipio;
    }

    public Boolean getBactivo() {
        return bactivo;
    }

    public void setBactivo(Boolean bactivo) {
        this.bactivo = bactivo;
    }
}
