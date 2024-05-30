package org.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "articulos_insumos")
public class ArticuloInsumo extends Articulo{

    @Column(name = "precio_compra")
    private Double precioCompra;

    @Column(name = "stock_actual")
    private Integer stockActual;

    @Column(name = "stock_maximo")
    private Integer stockMaximo;

    @Column(name = "es_para_elaborar")
    private Boolean esParaElaborar;

    public ArticuloInsumo() {
    }

    public ArticuloInsumo(String denominacion, Double precioVenta, Double precioCompra, Integer stockActual, Integer stockMaximo, Boolean esParaElaborar) {
        super(denominacion, precioVenta);
        this.precioCompra = precioCompra;
        this.stockActual = stockActual;
        this.stockMaximo = stockMaximo;
        this.esParaElaborar = esParaElaborar;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Integer getStockActual() {
        return stockActual;
    }

    public void setStockActual(Integer stockActual) {
        this.stockActual = stockActual;
    }

    public Integer getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(Integer stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public Boolean getEsParaElaborar() {
        return esParaElaborar;
    }

    public void setEsParaElaborar(Boolean esParaElaborar) {
        this.esParaElaborar = esParaElaborar;
    }
}
