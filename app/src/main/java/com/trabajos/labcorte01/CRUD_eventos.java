package com.trabajos.labcorte01;

public class CRUD_eventos {


    String fecha_inicio;
    String causa;
    String server;
    String solucion;
    String fecha_fin;
    String indisponibilidad;

    public CRUD_eventos( String fecha_inicio, String causa, String server, String solucion, String fecha_fin, String indisponibilidad) {

        this.fecha_inicio = fecha_inicio;
        this.causa = causa;
        this.server = server;
        this.solucion = solucion;
        this.fecha_fin = fecha_fin;
        this.indisponibilidad = indisponibilidad;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getIndisponibilidad() {
        return indisponibilidad;
    }

    public void setIndisponibilidad(String indisponibilidad) {
        this.indisponibilidad = indisponibilidad;
    }
}
