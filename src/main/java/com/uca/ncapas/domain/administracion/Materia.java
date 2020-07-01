package com.uca.ncapas.domain.administracion;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "administracion", name = "materia")
public class Materia {

    @Id
    @GeneratedValue(generator="materia_c_materia_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "materia_c_materia_seq", sequenceName = "administracion.materia_c_materia_seq")
    @Column(name = "c_materia")
    private Integer cmateria;

    @Column(name = "nombre")
    @NotNull(message = "El Nombre de la materia no puede quedar vacio")
    @Size(max = 50, message = "El Nombre de la materia debe tener maximo 50 caracteres")
    private String snombre;

    public Integer getCmateria() {
        return cmateria;
    }

    public void setCmateria(Integer cmateria) {
        this.cmateria = cmateria;
    }

    public String getSnombre() {
        return snombre;
    }

    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }
}
