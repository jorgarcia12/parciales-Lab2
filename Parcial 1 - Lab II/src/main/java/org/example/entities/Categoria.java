package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "denominacion")
    private String denominacion;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_categoria_propietario")
    private Categoria categoriaPropietario;

    public Categoria() {
    }

    public Categoria(String denominacion) {
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

    //Getter y  Setter de Relaciones

    public Categoria getCategoriaPropietario() {
        return categoriaPropietario;
    }
}
