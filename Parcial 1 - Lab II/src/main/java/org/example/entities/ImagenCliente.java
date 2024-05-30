package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "imagenes_clientes")
public class ImagenCliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "denominacion")
    private String denominacion;

    public ImagenCliente() {
    }

    public ImagenCliente(String denominacion) {
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
