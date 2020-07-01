package com.uca.ncapas.domain.proceso_negocio;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NotNull(message = "El Nombre del estudiante no puede quedar vacio")
    @Size(max = 100, message = "El Nombre del estudiante debe tener maximo 100 caracteres")
    private String snombres;

    @Column(name = "apellidos")
    @NotNull(message = "El Apellido del estudiante no puede quedar vacio")
    @Size(max = 100, message = "El Apellido del estudiante debe tener maximo 100 caracteres")
    private String sapellidos;

    @Column(name = "carnet")
    @NotNull(message = "El Carnet del estudiante no puede quedar vacio")
    @Size(max = 9, message = "El Carnet del estudiante debe tener maximo 9 caracteres")
    private Integer ccarnet;

    @Column(name = "fnacimiento")
    @NotEmpty(message = "La Fecha de nacimiento del estudiante no puede quedar vacio")
    private Date ffnacimiento;

    @Column(name = "direccion")
    @NotNull(message = "La Direccion del estudiante no puede quedar vacio")
    @Size(max = 150, message = "La Direccion del estudiante debe tener maximo 150 caracteres")
    private String sdireccion;

    @Column(name = "departamento")
    @NotEmpty(message = "El Departamento del estudiante no puede quedar vacio")
    private Integer cdepartamento;

    @Column(name = "municipio")
    @NotEmpty(message = "El Municipio del estudiante no puede quedar vacio")
    private Integer cmunicipio;

    @Column(name = "telefono")
    @NotNull(message = "El campo Telefono no puede quedar vacio")
    @Size(max = 10, message = "El campo Telefono debe tener maximo 10 caracteres")
    private Integer itelefono;

    @Column(name = "celular")
    @NotNull(message = "El campo Celular no puede quedar vacio")
    @Size(max = 10, message = "El campo Celular debe tener maximo 10 caracteres")
    private Integer icelular;

    @Column(name = "escuela")
    @NotEmpty(message = "Escuela del estudiante no puede quedar vacio")
    private Integer cescuela;

    @Column(name = "nombre_madre")
    @NotNull(message = "El Nombre de la Madre del estudiante no puede quedar vacio")
    @Size(max = 150, message = "El Nombre de la Madre del estudiante debe tener maximo 150 caracteres")
    private String snombre_madre;

    @Column(name = "nombre_padre")
    @NotNull(message = "El Nombre del Padre del estudiante no puede quedar vacio")
    @Size(max = 150, message = "El Nombre del Padre del estudiante debe tener maximo 150 caracteres")
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
