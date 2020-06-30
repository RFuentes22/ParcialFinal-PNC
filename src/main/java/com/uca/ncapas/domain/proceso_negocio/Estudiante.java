package com.uca.ncapas.domain.proceso_negocio;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(schema = "proceso_negocio", name = "estudiante")
public class Estudiante {

    @Id
    @Column(name = "c_estudiante")
    private Integer cestudiante;

    @Column(name = "nombres")
    private String snombres;

    @Column(name = "apellidos")
    private String sapellidos;

    @Column(name = "carnet")
    private Integer ccarnet;

    @Column(name = "fnacimiento")
    private Date ffnacimiento;

    @Column(name = "direccion")
    private String sdireccion;

    @Column(name = "departamento")
    private Integer cdepartamento;

    @Column(name = "municipio")
    private Integer cmunicipio;

    @Column(name = "telefono")
    private String stelefono;

    @Column(name = "celular")
    private String scelular;

    @Column(name = "escuela")
    private Integer cescuela;

    @Column(name = "nombre_madre")
    private String snombre_madre;

    @Column(name = "nombre_padre")
    private String snombre_padre;

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

    public Integer getCcarnet() {
        return ccarnet;
    }

    public void setCcarnet(Integer ccarnet) {
        this.ccarnet = ccarnet;
    }

    public Date getFfnacimiento() {
        return ffnacimiento;
    }

    public void setFfnacimiento(Date ffnacimiento) {
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

    public String getStelefono() {
        return stelefono;
    }

    public void setStelefono(String stelefono) {
        this.stelefono = stelefono;
    }

    public String getScelular() {
        return scelular;
    }

    public void setScelular(String scelular) {
        this.scelular = scelular;
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
