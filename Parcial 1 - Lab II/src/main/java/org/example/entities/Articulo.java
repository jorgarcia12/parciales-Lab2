package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Articulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "denominacion")
    protected String denominacion;

    @Column(name = "precio_venta")
    protected Double precioVenta;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_categoria")
    private Categoria categoria;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_unidad_medida")
    private UnidadMedida unidadMedida;


    public Articulo() {
    }

    public Articulo(String denominacion, Double precioVenta) {
        this.denominacion = denominacion;
        this.precioVenta = precioVenta;
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

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }


    //Getter y setter de relaciones


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
}
