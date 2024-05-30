package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "unidades_de_medidas")
public class UnidadMedida implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "denominacion")
    private String denominacion;

    public UnidadMedida() {
    }
    public UnidadMedida(String denominacion) {
        this.denominacion = denominacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
}
