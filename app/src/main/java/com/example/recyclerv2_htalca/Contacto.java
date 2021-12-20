package com.example.recyclerv2_htalca;

import java.util.ArrayList;
import java.util.Random;

public class Contacto {
    private String nombre;
    private String telefono;

    public ArrayList<Integer> numerosRandom;

    public Contacto(){
        nombre = "";
        telefono = "";
        numerosRandom = new ArrayList<Integer>();
        PoblarLista();
    }

    public Contacto(String nombre, String telefono){
        this.nombre = nombre;
        this.telefono = telefono;
        numerosRandom = new ArrayList<Integer>();
        PoblarLista();
    }

    public String GetNombre(){
        return nombre;
    }

    public String GetTelefono(){
        return telefono;
    }

    private void PoblarLista(){
        Random random = new Random();
        int posiciones = random.nextInt(4);
        for(int i = 0; i < posiciones; i++){
            numerosRandom.add(random.nextInt());
        }
    }
}
