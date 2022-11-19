package com.trabajos.labcorte01.cruds;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.trabajos.labcorte01.R;
import com.trabajos.labcorte01.db.DbEventos;
import com.trabajos.labcorte01.list_elements.List_eventos;
import com.trabajos.labcorte01.menus.MenuEventos;

import java.util.Objects;

public class Ver_Activity extends AppCompatActivity {

    EditText fechaInicio, descripcion, causa, servicioA, fechaFin, indisponibilidad;
    Button guardar, cancelar;
    FloatingActionButton editar,eliminar;

    List_eventos list_eventos;
    int id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        fechaInicio = findViewById(R.id.txt_view_Date);
        descripcion = findViewById(R.id.txt_view_descrip);
        causa = findViewById(R.id.txt_view_cause);
        servicioA = findViewById(R.id.txt_view_service);
        fechaFin = findViewById(R.id.txt_view_Date2);
        indisponibilidad = findViewById(R.id.txt_view_indisponible);
        guardar = findViewById(R.id.bnt_view_guardar);
        cancelar = findViewById(R.id.btn_view_cancelar);
        editar = findViewById(R.id.fabEdit);
        eliminar = findViewById(R.id.fabDelete);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras==null){
                id = Integer.parseInt(null);
            }else{
                id =extras.getInt("ID");
            }
        }else{
            id = (int) savedInstanceState.getSerializable("ID");

        }
        DbEventos dbEventos = new DbEventos(Ver_Activity.this);
        list_eventos = dbEventos.verEventos(id);

        if(list_eventos != null){
            fechaInicio.setText(list_eventos.getFecha_inicio());
            descripcion.setText(list_eventos.getDescripcion());
            causa.setText(list_eventos.getCausa());
            servicioA.setText(list_eventos.getServicioA());
            fechaFin.setText(list_eventos.getFecha_fin());
            indisponibilidad.setText(list_eventos.getIndisponibilidad());

            guardar.setVisibility(View.INVISIBLE);
            cancelar.setVisibility(View.INVISIBLE);
            fechaInicio.setInputType(InputType.TYPE_NULL);
            descripcion.setInputType(InputType.TYPE_NULL);
            causa.setInputType(InputType.TYPE_NULL);
            servicioA.setInputType(InputType.TYPE_NULL);
            fechaFin.setInputType(InputType.TYPE_NULL);
            indisponibilidad.setInputType(InputType.TYPE_NULL);
        }

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ver_Activity.this, edit_Activity.class);
                intent.putExtra("ID", id);
                startActivity(intent);
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Ver_Activity.this);
                builder.setMessage("Desea eliminar? ")
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                     if(dbEventos.eliminarEvento(id)){
                         lista();
                     }
                        Toast.makeText(Ver_Activity.this, "ELIMINADO", Toast.LENGTH_SHORT).show();
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int o) {

                            }
                        }).show();
            }
        });
    }
    private void lista(){
        Intent intent = new Intent(Ver_Activity.this, MenuEventos.class);
        startActivity(intent);
    }
}