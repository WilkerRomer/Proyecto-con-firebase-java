package com.example.proyectofirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void  Registarse(View ver){
        Intent i = new Intent(this,Registrarse.class);
        startActivity(i);
    }

    public void Iniciar(View ver){
        Intent i = new Intent(this,iniciar_sesion.class);
        startActivity(i);
    }
    public void noticias(View ver){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
        startActivity(i);
    }
    public void consejos(View ver){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
        startActivity(i);
    }
    public void razas(View ver){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
        startActivity(i);
    }
    public void tiposDeGanaderia(View ver){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://economipedia.com/definiciones/tipos-de-ganaderia.html"));
        startActivity(i);
    }
}