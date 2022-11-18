package com.trabajos.labcorte01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MenuEventos extends AppCompatActivity {

    RecyclerView recycler_view;
    tableAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_eventos);

        recycler_view = findViewById(R.id.recycler_view);
        setRecyclerView();
        //Boton Action Bar Para ir atras
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //Metodos para la Barra de menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
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

        };
        menu.findItem(R.id.search).setOnActionExpandListener(onActionExpandListener);
        SearchView searchView=(SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setQueryHint("Buscar datos aqui...");
        return true;
    }
    //Metodo para desplegar los items de CRUD



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

            switch (item.getItemId()){
                case R.id.addItem:
                    return true;
                case R.id.editItem:Item:
                return true;
                case R.id.deleteItem:Item:
                return true;
            }
            return super.onOptionsItemSelected(item);

    }

    private void setRecyclerView() {
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        adapter = new tableAdapter(this,getList());
        recycler_view.setAdapter(adapter);
    }

    private List<list_element1> getList(){
        List<list_element1> lista = new ArrayList<>();

        lista.add(new list_element1("25-07-2022","Averiado","Server Lorica","Reinicio","05-08-2022","4:25"));
        lista.add(new list_element1("25-07-2022","Averiado 1","Server Lorica","Reinicio","05-08-2022","4:25"));
        lista.add(new list_element1("25-07-2022","Averiado 2","Server Lorica","Reinicio","05-08-2022","4:25"));
        return lista;

    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart maEvents", Toast.LENGTH_SHORT).show();
        // La actividad est� a punto de hacerse visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume maEvents", Toast.LENGTH_SHORT).show();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause maEvents", Toast.LENGTH_SHORT).show();
        // Enfocarse en otra actividad  (esta actividad est� a punto de ser "detenida").
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop maEvents", Toast.LENGTH_SHORT).show();
        // La actividad ya no es visible (ahora est� "detenida")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy maEvents", Toast.LENGTH_SHORT).show();
        // La actividad est� a punto de ser destruida.
    }
}