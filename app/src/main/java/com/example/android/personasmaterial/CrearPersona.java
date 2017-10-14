package com.example.android.personasmaterial;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class CrearPersona extends AppCompatActivity {
    private EditText txtNombre, txtApellido, txtCedula;
    private TextInputLayout cajaNombre, cajaApellido, cajaCedula;
    private Spinner SpinnerSexo;
    private String [] opc;
    private ArrayAdapter<String> adapter;
    private ArrayList<Integer> fotos;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_persona);

        res =this.getResources();

        txtCedula = (EditText)findViewById(R.id.txtCedula);
        txtNombre = (EditText)findViewById(R.id.txtNombre);
        txtApellido = (EditText)findViewById(R.id.txtApellido);
        cajaCedula = (TextInputLayout)findViewById(R.id.cajaCedula);
        cajaNombre = (TextInputLayout) findViewById(R.id.cajaNombre);
        cajaApellido = (TextInputLayout) findViewById(R.id.cajaApellido);
        SpinnerSexo = (Spinner)findViewById(R.id.cmbSexo);
        opc = res.getStringArray(R.array.sexo);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opc);
        SpinnerSexo.setAdapter(adapter);

        iniciarFotos();

    }

    public void iniciarFotos(){
        fotos = new ArrayList<>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);
    }

    public void guardar(View v){
        String cedula, nombre, apellido;
        int sexo;
        cedula = txtCedula.getText().toString();
        nombre = txtNombre.getText().toString();
        apellido = txtApellido.getText().toString();
        sexo = SpinnerSexo.getSelectedItemPosition();
        Persona p = new Persona(Metodos.fotoAleatoria(fotos), cedula, nombre, apellido, sexo);
        p.guardar();
        Snackbar.make(v, res.getString(R.string.msjGuardar), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

    }

    public void limpiar(View v){
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        SpinnerSexo.setSelection(0);
        txtCedula.requestFocus();

    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(CrearPersona.this, Principal.class);
        startActivity(i);
    }
}
