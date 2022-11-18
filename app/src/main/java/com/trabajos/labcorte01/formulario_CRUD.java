package com.trabajos.labcorte01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class formulario_CRUD extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crud_eventos_layout);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart maForm", Toast.LENGTH_SHORT).show();
        // La actividad est� a punto de hacerse visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume maForm", Toast.LENGTH_SHORT).show();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause maForm", Toast.LENGTH_SHORT).show();
        // Enfocarse en otra actividad  (esta actividad est� a punto de ser "detenida").
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop maForm", Toast.LENGTH_SHORT).show();
        // La actividad ya no es visible (ahora est� "detenida")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy maForm", Toast.LENGTH_SHORT).show();
        // La actividad est� a punto de ser destruida.
    }
}
