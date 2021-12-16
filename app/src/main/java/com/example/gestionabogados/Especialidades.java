package com.example.gestionabogados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Especialidades extends AppCompatActivity {

    ListView listaEsp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialidades);

        listaEsp = findViewById(R.id.listViewEspecializacion);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.strEspecial, android.R.layout.simple_list_item_1);

        listaEsp.setAdapter(adaptador);

        listaEsp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), "Seleccionó la opción:" + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

                switch(parent.getItemAtPosition(position).toString()){
                    case "Familia": Intent intent = new Intent(Especialidades.this, Familia.class);
                        startActivity(intent);
                        break;
                    case "Penal": Intent intent2 = new Intent(Especialidades.this, Familia.class);
                        startActivity(intent2);
                        break;


                }
            }
        });
    }
}