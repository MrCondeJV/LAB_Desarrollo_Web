package com.trabajos.labcorte01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MenuSeguridad extends AppCompatActivity {
     RecyclerView recycler_view2;
     tableAdapter_Seguridad tableAdapter_seguridad;
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_seguridad);
        
        recycler_view2 = findViewById(R.id.recycler_view2);
        setRecyclerView();
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