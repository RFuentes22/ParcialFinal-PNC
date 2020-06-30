package com.uca.ncapas.domain.administracion;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "administracion", name = "centro_escolar")
public class Centro_escolar {

    @Id
    @Column(name = "c_escuela")
    private Integer cescuela;

    @Column(name = "nombre")
    private String snombre;

    @Column(name = "direccion")
    private String sdireccion;

    @Column(name = "departamento")
    private Integer idepartamento;

    @Column(name = "municipio")
    private Integer imunicipio;

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
