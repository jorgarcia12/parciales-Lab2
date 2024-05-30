package org.example;

import org.example.entities.*;
import org.example.entities.enums.Estado;
import org.example.entities.enums.FormaPago;
import org.example.entities.enums.Rol;
import org.example.entities.enums.TipoEnvio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        try {
            entityManager.getTransaction().begin();

            //Creamos algunas instancias de Empleado

            Empleado empleado1 = new Empleado("Santiago", "Bazan", "2615994365", "jor4300@gmail.com.ar", LocalDate.of(2002, 07, 19), Rol.ADMINISTRADOR);
            ImagenEmpleado imagenEmpleado1 = new ImagenEmpleado("imagenEmpleado1");
            UsuarioEmpleado usuarioEmpleado1 = new UsuarioEmpleado("usuarioEmpleado1", "elMejorEmpleado1");
            Sucursal sucursal1 = new Sucursal("Comilonas", LocalTime.of(11, 30), LocalTime.of(18, 00), true);
            Sucursal sucursal2 = new Sucursal("El Botellon", LocalTime.of(19, 30), LocalTime.of(02, 00), true);
            //Asignamos las instancias y los persistimos
            empleado1.setImagen(imagenEmpleado1);
            empleado1.setUsuarioEmpleado(usuarioEmpleado1);
            empleado1.setSucursal(sucursal1);

            //Persistimos
            entityManager.persist(empleado1);

            //Creamos algunas instancias de Cliente

            Cliente cliente1 = new Cliente("Jorge", "Garcia", "2615780987", "jorgelit@gmail.com", LocalDate.of(2003, 04, 02), Rol.CLIENTE);
            ImagenCliente imagenCliente1 = new ImagenCliente("imagenCliente1");
            UsuarioCliente usuarioCliente1 = new UsuarioCliente("usuarioCliente1", "elMejorCliente1");

            //Creamos algunas instancias de Domicilio

            Pais pais1 = new Pais("Argentina");
            Provincia provincia1 = new Provincia("Mendoza", pais1);
            Provincia provincia2 = new Provincia("Buenos Aires", pais1);
            Localidad localidad2 = new Localidad("CABA", provincia2);
            Localidad localidad1 = new Localidad("Las Heras", provincia1);

            Domicilio domicilio1 = new Domicilio("Doctor Lemos", 59, 5539, localidad1);
            Domicilio domicilio2 = new Domicilio("Pilar", 44, 5400, localidad2);

            //Asignamos las instancias

            cliente1.setImagenCliente(imagenCliente1);
            cliente1.setUsuarioCliente(usuarioCliente1);

            cliente1.getDomicilioCliente().add(domicilio1);
            cliente1.getDomicilioCliente().add(domicilio2);

            //Persistimos
            entityManager.persist(cliente1);

            //Creamos algunas Empresas
            Empresa emp1 = new Empresa("Coca-Cola", "envasadora", 23 - 44662355 - 8);
            Empresa emp2 = new Empresa("Marlboro", "tabaquera", 25 - 44366545 - 9);

            sucursal1.setEmpresa(emp1);
            sucursal2.setEmpresa(emp2);

            //Creamos algunos pedidos
            Pedido pedido1 = new Pedido(LocalTime.of(17, 15), 2000.00, 700.00, Estado.PENDIENTE, TipoEnvio.DELIVERY, FormaPago.MERCADOPAGO, LocalDate.of(2024, 5, 30));

            pedido1.setEmpleado(empleado1);
            pedido1.setCliente(cliente1);
            pedido1.setDomicilio(domicilio1);
            pedido1.setSucursal(sucursal1);

            //Creamos una Factura
            Factura fac1 = new Factura(LocalDate.of(2024, 5, 30), 221, 221, "jorgarcia.03", FormaPago.MERCADOPAGO, 2000.00);

            pedido1.setFactura(fac1);

            //Persistimos
            entityManager.persist(pedido1);


            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}