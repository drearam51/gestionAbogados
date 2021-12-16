package com.example.gestionabogados;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.gestionabogados.adaptadores.ListaAbogadosAdapter;
import com.example.gestionabogados.db.Abogados;
import com.example.gestionabogados.modelo.Abogado;

import java.util.ArrayList;

public class ListaAbogados extends AppCompatActivity {
    RecyclerView listaAbogados;
    ArrayList<Abogado> listarArrayAbogados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_abogados);
        listaAbogados = findViewById(R.id.listaAbogados);
        listaAbogados.setLayoutManager(new LinearLayoutManager(this));

        Abogados dbabog = new Abogados(this);
        listarArrayAbogados = new ArrayList<>();

        ListaAbogadosAdapter adaptador = new ListaAbogadosAdapter(dbabog.listarAbogados());
        listaAbogados.setAdapter(adaptador);
    }
}