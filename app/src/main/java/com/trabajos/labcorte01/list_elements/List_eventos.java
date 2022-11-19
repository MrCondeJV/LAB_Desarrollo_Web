package com.trabajos.labcorte01.list_elements;

public class List_eventos {


    private int id;
    String fecha_inicio;
    String descripcion;
    String causa;
    String servicioA;
    String fecha_fin;
    String indisponibilidad;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getServicioA() {
        return servicioA;
    }

    public void setServicioA(String server) {
        this.servicioA = server;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String solucion) {
        this.descripcion = solucion;
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
