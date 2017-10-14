package com.example.android.personasmaterial;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

public class DetallePersona extends AppCompatActivity {
    private CollapsingToolbarLayout collapsing_toolbar;
    private Persona p;
    private String cedula, nombre, apellido;
    private int fot, sexo;
    private Bundle b;
    private Intent i;
    private ImageView foto;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_persona);
/*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
*/
        collapsing_toolbar = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        foto = (ImageView)findViewById(R.id.fotoPersona);

        i = getIntent();
        b = i.getBundleExtra("datos");
        cedula = b.getString("cedula");
        nombre = b.getString("nombre");
        apellido = b.getString("apellido");
        sexo = b.getInt("sexo");
        fot = b.getInt("foto");

//        foto.setImageDrawable(ResourcesCompat.getDrawable(res,fot,null));
        collapsing_toolbar.setTitle(nombre+" "+apellido);
    }
}
