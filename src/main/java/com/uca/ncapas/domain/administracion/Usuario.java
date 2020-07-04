package com.uca.ncapas.domain.administracion;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(schema = "administracion", name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_usuario")
    private Integer cusuario;

    @Column(name = "usuario")
    //@NotEmpty(message = "El Usuario no puede quedar vacio")
    @Size(max = 20, message = "El Usuario debe tener maximo 20 caracteres")
    private String susuario;

    @Column(name = "nombre")
   // @NotNull(message = "El Nombre del usuario no puede quedar vacio")
    @Size(min = 2, max = 40, message = "El Nombre del usuario debe tener minimo 2 y maximo 40 caracteres")
    //@NotEmpty(message = "no vacio")
    private String nameuser;

    @Column(name = "apellido")
    //@NotNull(message = "El Apellido del usuario no puede quedar vacio")
    @Size(max = 40, message = "El Apellido del usuario debe tener maximo 40 caracteres")
    //@NotEmpty(message = "no vacio")
    private String lastnameuser;

    @Column(name = "contrasena")
    //@NotEmpty(message = "La Contraseña del usuario no puede quedar vacio")
    @Size(max = 50, message = "La Contraseña del usuario debe tener maximo 50 caracteres")
    private String scontrasena;

    @Column(name = "estado")
    private Boolean bestado;

    @Column(name = "admin")
    //@NotEmpty(message = "El Rol del usuario no puede quedar vacio")
    private Boolean badmin;

    @Column(name = "fnacimiento")
    @NotNull(message = "La Fecha de nacimiento del usuario no puede quedar vacio")
    private Date ffnacimiento;

    @Column(name = "edad")
    private Integer iedad;

    @Column(name = "direccion")
    @NotEmpty(message = "La Direccion del Usuario no puede quedar vacio")
    @Size(max = 150, message = "La Direccion del Usuario debe tener maximo 150 caracteres")
    private String sdireccion;

    @Column(name = "c_departamento")
    @NotNull(message = "El Departamento del usuario no puede quedar vacio")
    private Integer idepartamento;

    @Column(name = "c_municipio")
    @NotNull(message = "El municipio del usuario no puede quedar vacio")
    private Integer imunicipio;

    @Column(name = "activo")
    private Boolean bactivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_departamento",unique=true,insertable = false, updatable = false)
    private Departamento departamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_municipio",unique=true,insertable = false, updatable = false)
    private Municipio municipio;

    public String getNameuser() {
        return nameuser;
    }

    public void setNameuser(String nameuser) {
        this.nameuser = nameuser;
    }

    public String getLastnameuser() {
        return lastnameuser;
    }

    public void setLastnameuser(String lastnameuser) {
        this.lastnameuser = lastnameuser;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

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
