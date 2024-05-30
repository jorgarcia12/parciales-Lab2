package org.example.entities;

import org.example.entities.enums.Rol;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre_cliente")
    private String nombre;

    @Column(name = "apellido_cliente")
    private String apellido;

    @Column(name = "telefono_cliente")
    private String telefono;

    @Column(name = "email_cliente")
    private String email;

    @Column(name = "fecha_nacimiento_cliente")
    private LocalDate fechaNacimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private Rol rol;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_usuario_cliente")
    private UsuarioCliente usuarioCliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_imagen_cliente")
    private ImagenCliente imagenCliente;


    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "domicilio_cliente",
            joinColumns = @JoinColumn(name = "FK_cliente"),
            inverseJoinColumns = @JoinColumn(name = "FK_domicilio"))
    private List<Domicilio> domicilioCliente = new ArrayList<>();


    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String telefono, String email, LocalDate fechaNacimiento, Rol rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.rol = rol;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    //Getters y setters de UsuarioCliente y ImagenCliente

    public UsuarioCliente getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(UsuarioCliente usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public ImagenCliente getImagenCliente() {
        return imagenCliente;
    }

    public void setImagenCliente(ImagenCliente imagenCliente) {
        this.imagenCliente = imagenCliente;
    }

    //Getter de Pedidos


    public List<Domicilio> getDomicilioCliente() {
        return domicilioCliente;
    }
}
