package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sucursales")
public class Sucursal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "horario_apertura")
    private LocalTime horarioApertura;

    @Column(name = "horario_cierre")
    private LocalTime horarioCierre;

    @Column(name = "casa_matriz")
    private Boolean casaMatriz;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_sucursal_domicilio")
    private Domicilio domicilioSucursal;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "sucursal_promocion",
            joinColumns = @JoinColumn(name = "FK_sucursal"),
            inverseJoinColumns = @JoinColumn(name = "FK_promocion"))
    private List<Promocion> promociones;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "sucursal_categoria",
            joinColumns = @JoinColumn(name = "FK_sucursal"),
            inverseJoinColumns = @JoinColumn(name = "FK_categoria"))
    private List<Categoria> categorias;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_empresa")
    private Empresa empresa;

    public Sucursal() {
    }

    public Sucursal(String nombre, LocalTime horarioApertura, LocalTime horarioCierre, Boolean casaMatriz) {
        this.nombre = nombre;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.casaMatriz = casaMatriz;
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

    public LocalTime getHorarioApertura() {
        return horarioApertura;
    }

    public void setHorarioApertura(LocalTime horarioApertura) {
        this.horarioApertura = horarioApertura;
    }

    public LocalTime getHorarioCierre() {
        return horarioCierre;
    }

    public void setHorarioCierre(LocalTime horarioCierre) {
        this.horarioCierre = horarioCierre;
    }

    public Boolean getCasaMatriz() {
        return casaMatriz;
    }

    public void setCasaMatriz(Boolean casaMatriz) {
        this.casaMatriz = casaMatriz;
    }


    //Getter y Setter de Relaciones


    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Promocion> getPromociones() {
        return promociones;
    }

    public Domicilio getDomicilioSucursal() {
        return domicilioSucursal;
    }

    public void setDomicilioSucursal(Domicilio domicilioSucursal) {
        this.domicilioSucursal = domicilioSucursal;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }
}
