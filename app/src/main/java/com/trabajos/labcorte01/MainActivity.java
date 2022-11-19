package com.trabajos.labcorte01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.trabajos.labcorte01.menus.MenuEventos;
import com.trabajos.labcorte01.menus.MenuLogs;
import com.trabajos.labcorte01.menus.MenuSeguridad;

public class MainActivity extends AppCompatActivity {

    private ImageView img_eventos;
    private ImageView img_seguridad;
    private ImageView img_logs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_eventos = (ImageView) findViewById(R.id.ma_img_eventos);
        img_seguridad = (ImageView) findViewById(R.id.ma_img_seguridad);
        img_logs= (ImageView) findViewById(R.id.ma_img_logs);

        img_eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuEventos.class);

                startActivity(intent);
            }
        });
        img_seguridad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuSeguridad.class);

                startActivity(intent);
            }
        });
        img_logs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MenuLogs.class);

                startActivity(intent);
            }
        });

    }

    //ASINC TASK
   /* @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart maMain", Toast.LENGTH_SHORT).show();
        // La actividad est� a punto de hacerse visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume maMain", Toast.LENGTH_SHORT).show();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause maMain", Toast.LENGTH_SHORT).show();
        // Enfocarse en otra actividad  (esta actividad est� a punto de ser "detenida").
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop maMain", Toast.LENGTH_SHORT).show();
        // La actividad ya no es visible (ahora est� "detenida")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy maMain", Toast.LENGTH_SHORT).show();
        // La actividad est� a punto de ser destruida.
    }
*/
    }
