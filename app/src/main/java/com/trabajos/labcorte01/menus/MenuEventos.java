package com.trabajos.labcorte01.menus;

import static com.trabajos.labcorte01.db.BasededatosSQLlite.TABLE_EVENTOS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.trabajos.labcorte01.R;
import com.trabajos.labcorte01.db.BasededatosSQLlite;
import com.trabajos.labcorte01.cruds.formulario_CRUD;
import com.trabajos.labcorte01.list_elements.List_eventos;
import com.trabajos.labcorte01.tables_adapters.tableAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MenuEventos extends AppCompatActivity {

    RecyclerView recycler_view;
    tableAdapter adapter;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu_eventos);
        recycler_view = findViewById(R.id.recycler_view);

        setRecyclerView();

        //Boton Action Bar Para ir atras
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


    }

    //Metodos para la Barra de menu
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);




        MenuItem.OnActionExpandListener onActionExpandListener=new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(@NonNull MenuItem item) {
                Toast.makeText(MenuEventos.this, "Search ha sido Expandido", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(@NonNull MenuItem item) {
                Toast.makeText(MenuEventos.this, "Search ha sido Colapsado", Toast.LENGTH_SHORT).show();
                return true;
            }


        }; //Boton de busqueda
        menu.findItem(R.id.search).setOnActionExpandListener(onActionExpandListener);
        SearchView searchView=(SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setQueryHint("Buscar datos aqui...");
        return true;


    }
    //Metodo para desplegar los items de CRUD

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item ){
          switch (item.getItemId()){
              case R.id.addItem:
                  Toast.makeText(this, "AddItem", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(MenuEventos.this, formulario_CRUD.class);
                   startActivity(intent);
                  return true;

              default: return super.onOptionsItemSelected(item);
          }


    }






    private void setRecyclerView() {
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        adapter = new tableAdapter(this,getList());
        recycler_view.setAdapter(adapter);
    }

    private List<List_eventos> getList(){

        BasededatosSQLlite basededatosSQLlite = new BasededatosSQLlite(MenuEventos.this);
        SQLiteDatabase db = basededatosSQLlite.getWritableDatabase();

        List<List_eventos> lista_eventos = new ArrayList<>();
        List_eventos eventos = null;
        Cursor cursorEventos = null;

        cursorEventos = db.rawQuery("SELECT * FROM "+ TABLE_EVENTOS, null);
        if(cursorEventos.moveToFirst()){
            do{
                eventos = new List_eventos();
                eventos.setId(cursorEventos.getInt(0));
                eventos.setFecha_inicio(cursorEventos.getString(1));
                eventos.setDescripcion(cursorEventos.getString(2));
                eventos.setCausa(cursorEventos.getString(3));
                eventos.setServicioA(cursorEventos.getString(4));
                eventos.setFecha_fin(cursorEventos.getString(5));
                eventos.setIndisponibilidad(cursorEventos.getString(6));
                lista_eventos.add(eventos);

            }while (cursorEventos.moveToNext());
        }
        cursorEventos.close();
         return lista_eventos;
    }

}