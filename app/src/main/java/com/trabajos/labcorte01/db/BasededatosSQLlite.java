package com.trabajos.labcorte01.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BasededatosSQLlite extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NOMBRE="eventos.db";
    public static final String TABLE_EVENTOS="t_eventos";



    public BasededatosSQLlite(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_EVENTOS +"(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "fechaInicio TEXT NOT NULL," +
                "descripcion TEXT NOT NULL," +
                "causa TEXT NOT NULL," +
                "servicioA TEXT not null," +
                "fechaFin TEXT NOT NULL," +
                "indisponibilidad TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("DROP TABLE " + TABLE_EVENTOS);
    onCreate(sqLiteDatabase);
    }
}
