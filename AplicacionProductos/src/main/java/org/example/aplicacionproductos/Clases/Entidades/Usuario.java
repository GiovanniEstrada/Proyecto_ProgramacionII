package org.example.aplicacionproductos.Clases.Entidades;

import java.time.LocalDateTime;

public class Usuario {

    private int id;
    private String usuario;
    private String password;
    private String nombreCompleto;
    private String correo;
    private byte estatus;          // FK hacia tabla de estatus
    private byte tipoUsuario;      // FK hacia tabla de tipos de usuario
    private LocalDateTime fechaHoraCreacion;
    private LocalDateTime fechaHoraUltimaConexion;

    // 🔹 Constructor vacío
    public Usuario() {
    }

    // 🔹 Constructor completo
    public Usuario(int id, String usuario, String password, String nombreCompleto, String correo,
                   byte estatus, byte tipoUsuario, LocalDateTime fechaHoraCreacion, LocalDateTime fechaHoraUltimaConexion) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.estatus = estatus;
        this.tipoUsuario = tipoUsuario;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.fechaHoraUltimaConexion = fechaHoraUltimaConexion;
    }

    // 🔹 Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public byte getEstatus() {
        return estatus;
    }

    public void setEstatus(byte estatus) {
        this.estatus = estatus;
    }

    public byte getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(byte tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public LocalDateTime getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(LocalDateTime fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public LocalDateTime getFechaHoraUltimaConexion() {
        return fechaHoraUltimaConexion;
    }

    public void setFechaHoraUltimaConexion(LocalDateTime fechaHoraUltimaConexion) {
        this.fechaHoraUltimaConexion = fechaHoraUltimaConexion;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", correo='" + correo + '\'' +
                ", estatus=" + estatus +
                ", tipoUsuario=" + tipoUsuario +
                ", fechaHoraCreacion=" + fechaHoraCreacion +
                ", fechaHoraUltimaConexion=" + fechaHoraUltimaConexion +
                '}';
    }
}
