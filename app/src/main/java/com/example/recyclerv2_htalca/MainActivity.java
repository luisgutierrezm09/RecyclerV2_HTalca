package com.example.recyclerv2_htalca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adaptador adaptador;
    private ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos = new ArrayList<Contacto>();
        PoblarLista();

        adaptador = new Adaptador(contactos);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptador);


    }

    private void PoblarLista(){
        contactos.add(new Contacto("Ivo Muñoz", "11223344"));
        contactos.add(new Contacto("Jorge Canales", "11223344"));
        contactos.add(new Contacto("Juan Pablo Ulloa", "11223344"));
        contactos.add(new Contacto("Luis Gutiérrez", "11223344"));
    }

}