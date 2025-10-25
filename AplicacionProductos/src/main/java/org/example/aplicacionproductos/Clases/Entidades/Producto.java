package org.example.aplicacionproductos.Clases.Entidades;

import java.io.Serializable;
import java.math.BigDecimal;

public class Producto{

    private int id;
    private int tipoProducto;
    private String nombreProducto;
    private BigDecimal precioUnidad;

    public Producto() {
    }

    public Producto(int id, int tipoProducto, String nombreProducto, BigDecimal precioUnidad) {
        this.id = id;
        this.tipoProducto = tipoProducto;
        this.nombreProducto = nombreProducto;
        this.precioUnidad = precioUnidad;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(int tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigDecimal getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(BigDecimal precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

}
