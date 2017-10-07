package com.example.android.personasmaterial;

import java.util.ArrayList;

/**
 * Created by Android on 30/09/2017.
 */

public class Datos {
    public static ArrayList<Persona> personas= new ArrayList<>();

    public static void guardarPersona(Persona p){
        personas.add(p);
    }

    public static ArrayList<Persona> obtenerPersona(){
        return personas;
    }
}
