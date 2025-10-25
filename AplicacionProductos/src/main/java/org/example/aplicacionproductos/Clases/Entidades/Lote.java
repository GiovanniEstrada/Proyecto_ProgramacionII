package org.example.aplicacionproductos.Clases.Entidades;

import java.time.LocalDate;

public class Lote {

    private static final long serialVersionUID = 1L;

    private int id;
    private int idProducto;
    private LocalDate fechaCaducidad;
    private int cantidadInicial;
    private int cantidadRestante;
    private boolean estatus;

    // 🔹 Constructor vacío
    public Lote() {
    }

    // 🔹 Constructor completo
    public Lote(int idProducto, LocalDate fechaCaducidad, int cantidadInicial, int cantidadRestante, boolean estatus) {
        this.id = id;
        this.idProducto = idProducto;
        this.fechaCaducidad = fechaCaducidad;
        this.cantidadInicial = cantidadInicial;
        this.cantidadRestante = cantidadRestante;
        this.estatus = estatus;
    }

    // 🔹 Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(int cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public int getCantidadRestante() {
        return cantidadRestante;
    }

    public void setCantidadRestante(int cantidadRestante) {
        this.cantidadRestante = cantidadRestante;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Lote{" +
                "id=" + id +
                ", idProducto=" + idProducto +
                ", fechaCaducidad=" + fechaCaducidad +
                ", cantidadInicial=" + cantidadInicial +
                ", cantidadRestante=" + cantidadRestante +
                ", estatus=" + estatus +
                '}';
    }
}

