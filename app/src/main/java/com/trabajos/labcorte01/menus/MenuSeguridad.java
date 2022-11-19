package com.trabajos.labcorte01.menus;

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

import com.trabajos.labcorte01.R;
import com.trabajos.labcorte01.list_elements.list_element2;
import com.trabajos.labcorte01.tables_adapters.tableAdapter_Seguridad;

import java.util.ArrayList;
import java.util.List;

public class MenuSeguridad extends AppCompatActivity {
     RecyclerView recycler_view2;
     tableAdapter_Seguridad tableAdapter_seguridad;
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_seguridad);
        
        recycler_view2 = findViewById(R.id.listRecyclerView);
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
                Toast.makeText(MenuSeguridad.this, "Search ha sido Expandido", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(@NonNull MenuItem item) {
                Toast.makeText(MenuSeguridad.this, "Search ha sido Colapsado", Toast.LENGTH_SHORT).show();
                return true;
            }

        };
        menu.findItem(R.id.search).setOnActionExpandListener(onActionExpandListener);
        SearchView searchView=(SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setQueryHint("Buscar datos aqui...");
        return true;
    }
    private void setRecyclerView() {
        recycler_view2.setHasFixedSize(true);
        recycler_view2.setLayoutManager(new LinearLayoutManager(this));
        tableAdapter_seguridad = new tableAdapter_Seguridad(this,getList());
        recycler_view2.setAdapter(tableAdapter_seguridad);
    }

    private List<list_element2>getList(){
        List<list_element2> lista = new ArrayList<>();
        lista.add(new list_element2("Server Sahagun","Reparacion","Mantenimiento del server"));
        lista.add(new list_element2("Server Planeta R","Reparacion","Mantenimiento del server"));
        return lista;
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart ma3", Toast.LENGTH_SHORT).show();
        // La actividad est� a punto de hacerse visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume ma3", Toast.LENGTH_SHORT).show();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause ma3", Toast.LENGTH_SHORT).show();
        // Enfocarse en otra actividad  (esta actividad est� a punto de ser "detenida").
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop ma3", Toast.LENGTH_SHORT).show();
        // La actividad ya no es visible (ahora est� "detenida")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy ma3", Toast.LENGTH_SHORT).show();
        // La actividad est� a punto de ser destruida.
    }

}