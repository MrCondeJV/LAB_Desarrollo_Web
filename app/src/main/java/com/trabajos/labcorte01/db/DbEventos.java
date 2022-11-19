package com.trabajos.labcorte01.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

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
}
