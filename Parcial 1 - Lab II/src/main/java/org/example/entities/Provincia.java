package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "provincias")
public class Provincia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre_provincia")
    private String nombre;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_pais")
    private Pais pais;


    public Provincia() {
    }

    public Provincia(String nombre, Pais pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    //Getter y Setter de Relaciones

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
