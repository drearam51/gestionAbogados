package com.example.gestionabogados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Penal extends AppCompatActivity {
    ListView listPenal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penal);

        listPenal = findViewById(R.id.listAbogados);

        ArrayList<String> listLawyer = new ArrayList<>();

        listLawyer.add("Juan Carlos Fernandez");
        listLawyer.add("Maria Camila Isaza");
        listLawyer.add("Katherine Andrea Rodríguez");
        listLawyer.add("Emilio Santander Ariza");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listLawyer);

        listPenal.setAdapter(adapter);

    }
}