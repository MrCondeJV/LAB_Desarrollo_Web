package com.trabajos.labcorte01.cruds;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.trabajos.labcorte01.R;
import com.trabajos.labcorte01.db.DbEventos;
import com.trabajos.labcorte01.list_elements.List_eventos;
import com.trabajos.labcorte01.menus.MenuEventos;

import java.util.Objects;

public class edit_Activity extends AppCompatActivity {

    EditText fechaInicio, descripcion, causa, servicioA, fechaFin, indisponibilidad;
    Button guardar, cancelar;
    FloatingActionButton editar,eliminar;
    boolean correcto = false;

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

        editar.setVisibility(View.INVISIBLE);
        eliminar.setVisibility(View.INVISIBLE);

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
        DbEventos dbEventos = new DbEventos(edit_Activity.this);
        list_eventos = dbEventos.verEventos(id);

        if(list_eventos != null){
            fechaInicio.setText(list_eventos.getFecha_inicio());
            descripcion.setText(list_eventos.getDescripcion());
            causa.setText(list_eventos.getCausa());
            servicioA.setText(list_eventos.getServicioA());
            fechaFin.setText(list_eventos.getFecha_fin());
            indisponibilidad.setText(list_eventos.getIndisponibilidad());


        }
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(edit_Activity.this, MenuEventos.class);
                startActivity(intent);
            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!fechaInicio.getText().toString().equals("") && !descripcion.getText().toString().equals("") && !causa.getText().toString().equals("") && !servicioA.getText().toString().equals("") && !fechaFin.getText().toString().equals("") && !indisponibilidad.getText().toString().equals("") ){

                  correcto = dbEventos.editarEvento(id,fechaInicio.getText().toString(),descripcion.getText().toString(),causa.getText().toString(),servicioA.getText().toString(),fechaFin.getText().toString(),indisponibilidad.getText().toString());

                  if(correcto==true){
                      Toast.makeText(edit_Activity.this,"REGISTRO MODIFICADO",Toast.LENGTH_LONG).show();
                      verRegistro();
                  }else{
                      Toast.makeText(edit_Activity.this,"ERROR AL MODIFICAR REGISTRO",Toast.LENGTH_LONG).show();
                  }
                }else{
                    Toast.makeText(edit_Activity.this,"DEBE LLENAR TODOS LOS CAMPOS",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void verRegistro(){
        Intent intent = new Intent(edit_Activity.this, Ver_Activity.class);
        intent.putExtra("ID", id);
        startActivity(intent);
    }
}
