package com.trabajos.labcorte01;

public class list_element3 {
    String NombreServerLog;
    String fecha;
    String Usuario;
    String EstadoSesion;
    String Hora;

    public list_element3(String nombreServerLog, String fecha, String usuario, String estadoSesion, String hora) {
        NombreServerLog = nombreServerLog;
        this.fecha = fecha;
        Usuario = usuario;
        EstadoSesion = estadoSesion;
        Hora = hora;
    }

    public String getNombreServerLog() {
        return NombreServerLog;
    }

    public String getFecha() {
        return fecha;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getEstadoSesion() {
        return EstadoSesion;
    }

    public String getHora() {
        return Hora;
    }
}
