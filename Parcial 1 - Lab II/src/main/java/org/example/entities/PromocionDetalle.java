package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "promociones_detalles")
public class PromocionDetalle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_articulo")
    private Articulo articulo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_promocion")
    private Promocion promocion;

    public PromocionDetalle() {
    }

    public PromocionDetalle(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }
}
