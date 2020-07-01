package com.uca.ncapas.domain.administracion;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "administracion", name = "centro_escolar")
public class Centro_escolar {

    @Id
    @GeneratedValue(generator="centro_escolar_c_escuela_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "centro_escolar_c_escuela_seq", sequenceName = "administracion.centro_escolar_c_escuela_seq")
    @Column(name = "c_escuela")
    private Integer cescuela;

    @Column(name = "nombre")
    @NotNull(message = "El Nombre del Centro Escolar no puede quedar vacio")
    @Size(max = 150, message = "El Nombre del Centro Escolar debe tener maximo 150 caracteres")
    private String snombre;

    @Column(name = "direccion")
    @NotNull(message = "La Direccion del Centro Escolar no puede quedar vacio")
    @Size(max = 150, message = "La Direccion del Centro Escolar debe tener maximo 150 caracteres")
    private String sdireccion;

    @Column(name = "departamento")
    private Integer idepartamento;

    @Column(name = "municipio")
    private Integer imunicipio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "municipio",unique=true,insertable = false, updatable = false)
    private Municipio municipio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamento",unique=true,insertable = false, updatable = false)
    private Departamento departamento;

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

    public Integer getCescuela() {
        return cescuela;
    }

    public void setCescuela(Integer cescuela) {
        this.cescuela = cescuela;
    }

    public String getSnombre() {
        return snombre;
    }

    public void setSnombre(String snombre) {
        this.snombre = snombre;
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
}
