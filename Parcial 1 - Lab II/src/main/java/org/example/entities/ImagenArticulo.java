package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "imagenes_articulos")
public class ImagenArticulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "denominacion")
    private String denominacion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_articulo")
    private Articulo articulo;

    public ImagenArticulo() {
    }

    public ImagenArticulo(String denominacion) {
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

    //Getter y setter de relaciones

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
