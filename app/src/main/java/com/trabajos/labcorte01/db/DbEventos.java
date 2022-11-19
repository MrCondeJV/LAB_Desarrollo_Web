package com.trabajos.labcorte01.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.trabajos.labcorte01.list_elements.List_eventos;

public class DbEventos extends BasededatosSQLlite{

    Context context;

    public DbEventos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarEvento(String fechaInicio, String descripcion, String causa, String servicioA, String fechaFin, String indisponibilidad){
        long id=0;
        try {
            BasededatosSQLlite basededatosSQLlite = new BasededatosSQLlite(context);
            SQLiteDatabase db = basededatosSQLlite.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("fechaInicio",fechaInicio);
            values.put("descripcion",descripcion);
            values.put("causa",causa);
            values.put("servicioA",servicioA);
            values.put("fechaFin",fechaFin);
            values.put("indisponibilidad",indisponibilidad);
            id= db.insert(TABLE_EVENTOS, null, values);
        }catch (Exception ex){
            ex.toString();
        }

        return id;
    }



    public List_eventos verEventos(int id){

        BasededatosSQLlite basededatosSQLlite = new BasededatosSQLlite(context);
        SQLiteDatabase db = basededatosSQLlite.getWritableDatabase();


        List_eventos eventos = null;
        Cursor cursorEventos ;

        cursorEventos = db.rawQuery("SELECT * FROM "+ TABLE_EVENTOS + " WHERE id = " + id + " LIMIT 1", null);
        if(cursorEventos.moveToFirst()){

                eventos = new List_eventos();
                eventos.setId(cursorEventos.getInt(0));
                eventos.setFecha_inicio(cursorEventos.getString(1));
                eventos.setDescripcion(cursorEventos.getString(2));
                eventos.setCausa(cursorEventos.getString(3));
                eventos.setServicioA(cursorEventos.getString(4));
                eventos.setFecha_fin(cursorEventos.getString(5));
                eventos.setIndisponibilidad(cursorEventos.getString(6));

        }
        cursorEventos.close();
        return eventos;
    }

    public boolean editarEvento(int id, String fechaInicio, String descripcion, String causa, String servicioA, String fechaFin, String indisponibilidad){
        boolean correcto = false;

        BasededatosSQLlite basededatosSQLlite = new BasededatosSQLlite(context);
        SQLiteDatabase db = basededatosSQLlite.getWritableDatabase();

        try {

            db.execSQL("UPDATE "+ TABLE_EVENTOS + " SET fechaInicio= '"+ fechaInicio + "',descripcion = '" + descripcion + "', causa = '" + causa + "', ServicioA = '" + servicioA + "', fechaFin = '" + fechaFin + "', indisponibilidad = '" + indisponibilidad + "' WHERE id = '" + id +"' ");
            correcto=true;
        }catch (Exception ex){
            ex.toString();
            correcto=false;
        }finally {
            db.close();
        }

        return correcto;
    }

    public boolean eliminarEvento(int id){
        boolean correcto = false;

        BasededatosSQLlite basededatosSQLlite = new BasededatosSQLlite(context);
        SQLiteDatabase db = basededatosSQLlite.getWritableDatabase();

        try {

            db.execSQL("DELETE FROM " + TABLE_EVENTOS + " WHERE id = '" + id + "'");
            correcto=true;
        }catch (Exception ex){
            ex.toString();
            correcto=false;
        }finally {
            db.close();
        }

        return correcto;
    }
}

