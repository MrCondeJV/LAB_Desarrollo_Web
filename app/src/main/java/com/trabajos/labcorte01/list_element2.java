package com.trabajos.labcorte01;

public class list_element2 {

    String NombreServer;
    String NombreEvento;
    String Descripcion;

    public list_element2(String nombreServer, String nombreEvento, String descripcion) {
        NombreServer = nombreServer;
        NombreEvento = nombreEvento;
        Descripcion = descripcion;
    }

    public String getNombreServer() {
        return NombreServer;
    }

    public String getNombreEvento() {
        return NombreEvento;
    }

    public String getDescripcion() {
        return Descripcion;
    }
}
