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

public class MenuLogs extends AppCompatActivity {

    RecyclerView recycler_view3;
    tableAdapter_Logs adapter_logs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_logs);

        recycler_view3 = findViewById(R.id.recycler_view3);
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
                Toast.makeText(MenuLogs.this, "Search ha sido Expandido", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(@NonNull MenuItem item) {
                Toast.makeText(MenuLogs.this, "Search ha sido Colapsado", Toast.LENGTH_SHORT).show();
                return true;
            }

        };
        menu.findItem(R.id.search).setOnActionExpandListener(onActionExpandListener);
        SearchView searchView=(SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setQueryHint("Buscar datos aqui...");
        return true;
    }
    private void setRecyclerView() {
        recycler_view3.setHasFixedSize(true);
        recycler_view3.setLayoutManager(new LinearLayoutManager(this));
        adapter_logs = new tableAdapter_Logs( this,getList());
        recycler_view3.setAdapter(adapter_logs);
    }

    private List<list_element3> getList(){
        List<list_element3> lista = new ArrayList<>();

        lista.add(new list_element3("Server Lorica","05-08-2022 ","Admin","Fallida","08:00"));
        lista.add(new list_element3("Server Monteria","05-08-2022 ","Admin","Exitosa","13:00"));
        lista.add(new list_element3("Server Lorica","05-08-2022 ","Admin","Fallida","08:00"));
        lista.add(new list_element3("Server Monteria","05-08-2022 ","Admin","Exitosa","13:00"));
        lista.add(new list_element3("Server Lorica","05-08-2022 ","Admin","Fallida","08:00"));
        lista.add(new list_element3("Server Monteria","05-08-2022 ","Admin","Exitosa","13:00"));

        return lista;

    }@Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart maLogs", Toast.LENGTH_SHORT).show();
        // La actividad est� a punto de hacerse visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume maLogs", Toast.LENGTH_SHORT).show();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause maLogs", Toast.LENGTH_SHORT).show();
        // Enfocarse en otra actividad  (esta actividad est� a punto de ser "detenida").
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop maLogs", Toast.LENGTH_SHORT).show();
        // La actividad ya no es visible (ahora est� "detenida")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy maLogs", Toast.LENGTH_SHORT).show();
        // La actividad est� a punto de ser destruida.
    }
}