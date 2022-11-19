package com.trabajos.labcorte01.list_elements;

public class list_element1 {
    String fecha_inicio;
    String causa;
    String server;
    String solucion;
    String fecha_fin;
    String indisponibilidad; //capturar esta variable en Horas

    public list_element1(String fecha_inicio, String causa, String server, String solucion, String fecha_fin, String indisponibilidad) {
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

    public String getCausa() {
        return causa;
    }

    public String getServer() {
        return server;
    }

    public String getSolucion() {
        return solucion;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public String getIndisponibilidad() {
        return indisponibilidad;
    }
}
