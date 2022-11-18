package com.trabajos.labcorte01;

public class list_element3 {
    String NombreServerLog;
    String fechaHora;
    String Usuario;
    String EstadoSesion;

    public list_element3(String nombreServerLog, String fechaHora, String usuario, String estadoSesion) {
        NombreServerLog = nombreServerLog;
        this.fechaHora = fechaHora;
        Usuario = usuario;
        EstadoSesion = estadoSesion;
    }

    public String getNombreServerLog() {
        return NombreServerLog;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getEstadoSesion() {
        return EstadoSesion;
    }
}
