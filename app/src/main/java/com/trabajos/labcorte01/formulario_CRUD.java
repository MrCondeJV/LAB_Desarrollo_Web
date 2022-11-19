package com.trabajos.labcorte01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.trabajos.labcorte01.db.BasededatosSQLlite;
import com.trabajos.labcorte01.db.DbEventos;
import com.trabajos.labcorte01.menus.MenuEventos;
import com.trabajos.labcorte01.tables_adapters.tableAdapter;

import java.util.Objects;

public class formulario_CRUD extends AppCompatActivity {

    EditText fechaInicio, descripcion, causa, servicioA, fechaFin, indisponibilidad;
    Button guardar, cancelar,creardb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_crud);

        guardar = findViewById(R.id.bnt_crud_guardar);
        cancelar = findViewById(R.id.btn_crud_cancelar);
        creardb = findViewById(R.id.bnt_crud_crearDB);

        //Boton Action Bar Para ir atras
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        creardb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //----------> Creacion de la base de datos apenas se abra el formulario y se guardara la instancia
                BasededatosSQLlite basededatosSQLlite = new BasededatosSQLlite(formulario_CRUD.this);
                SQLiteDatabase db = basededatosSQLlite.getWritableDatabase();
                if(db != null){
                    Toast.makeText(formulario_CRUD.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(formulario_CRUD.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
                }
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(formulario_CRUD.this, tableAdapter.class);

                startActivity(intent);
            }
        });


            //RETORNANDO LOS VALORES DE LOS EDIT TEXT

            fechaInicio = findViewById(R.id.txt_crud_Date);
            descripcion = findViewById(R.id.txt_crud_descrip);
            causa = findViewById(R.id.txt_crud_cause);
            servicioA = findViewById(R.id.txt_crud_service);
            fechaFin = findViewById(R.id.txt_crud_Date2);
            indisponibilidad = findViewById(R.id.txt_crud_indisponible);
            guardar = findViewById(R.id.bnt_crud_guardar);
            cancelar = findViewById(R.id.btn_crud_cancelar);


            guardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DbEventos dbEventos = new DbEventos(formulario_CRUD.this);
                    long id=dbEventos.insertarEvento(fechaInicio.getText().toString(),descripcion.getText().toString(),causa.getText().toString(),servicioA.getText().toString(),fechaFin.getText().toString(),indisponibilidad.getText().toString());

                    if (id>0){

                            Toast.makeText(formulario_CRUD.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                            limpiar();

                    }else {
                        Toast.makeText(formulario_CRUD.this, "ERROR AL GUARDAR EL REGISTRO ", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

      private void limpiar(){
          fechaInicio.setText("");
          descripcion.setText("");
          causa.setText("");
          servicioA.setText("");
          fechaFin.setText("");
          indisponibilidad.setText("");
      }


}