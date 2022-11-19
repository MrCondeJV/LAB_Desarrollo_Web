package com.trabajos.labcorte01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Activity_fichero extends AppCompatActivity {

    EditText texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fichero);


    texto = (EditText)findViewById(R.id.listadotxt);
    String archivos [] = fileList();


    if( encontrado(archivos,"SeguridadLog.txt" )   ){

        try{
            InputStreamReader archivo =  new InputStreamReader(openFileInput("SeguridadLog.txt"));
            BufferedReader br = new BufferedReader(archivo);
            String linea = br.readLine();
            String todo="";

            while(linea != null){

                todo = todo + linea +"\n";
                linea = br.readLine();
            }

            br.close();
            archivo.close();
            texto.setText(todo);

        }
        catch (IOException e){


        }


    }



}


    private boolean encontrado(String archivos [], String  fichero){


        for ( int i =0; i < archivos.length ; i++ ){

            if(fichero.equals(archivos[i])){

                return true;

            }


        }

        return  false;
    }



    public void guardar(View view){


        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("listados.txt", Activity.MODE_PRIVATE));
            archivo.write(texto.getText().toString());
            archivo.flush();
            archivo.close();


        }catch (IOException e){
        }

        Toast.makeText(this,"texto guardado",Toast.LENGTH_SHORT).show();
        finish();

    }
}