
package com.trabajos.labcorte01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BasededatosSQLlite extends SQLiteOpenHelper {
    private static final String NOMBRE_DB=" BDSQLite";
    private static final int VERSION_DB=1;
    private static final String TABLA_EVENTOS="CREATE TABLE EVENTOS(ID TEXT PRIMARY KEY, FechaIni TEXT, Descripcion TEXT, Causa TEXT, ServicioAfectado TEXT,FechaFin TEXT, Indisponibilidad TEXT)";

    public BasededatosSQLlite( Context context) {
        super(context, NOMBRE_DB, null , VERSION_DB);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_EVENTOS);

    }

    @Override
    public void onUpgrade(@NonNull SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_EVENTOS);
        sqLiteDatabase.execSQL(TABLA_EVENTOS);

    }
    public void registrarEventos(String id,String fechaini, String descripcion, String causa, String servicioafectado,String fechafinal, String indisponibilidad ){
        SQLiteDatabase bd=getWritableDatabase() ;
        if(bd!=null){
            bd.execSQL("INSERT INTO EVENTOS VALUES('"+id+"','"+fechaini+"','"+descripcion+"','"+causa+"','"+servicioafectado+"','"+fechafinal+"','"+indisponibilidad+"')");
            bd.close();
        }
    }
}
