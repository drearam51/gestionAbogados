package com.example.gestionabogados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;

import com.example.gestionabogados.db.Abogados;
import com.example.gestionabogados.modelo.Abogado;

public class Editar extends AppCompatActivity {

    EditText edtIdent, edtNombre, edtEspec, edtCorreo, edtCosto;
    Abogado abog;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_abogado);

        edtNombre = findViewById(R.id.edtNombre);
        edtEspec = findViewById(R.id.edtEspecializacion);
        edtCorreo = findViewById(R.id.edtCorreo);
        edtCosto = findViewById(R.id.edtCosto);

        if(savedInstanceState==null){
            Bundle extras = getIntent().getExtras();
            if(extras==null){
                id = Integer.parseInt(null);
            }else{
                id = extras.getInt("id");
            }

        }else{
            id=(int)savedInstanceState.getSerializable("id");
        }

        Abogados dbabog = new Abogados(Editar.this);
        abog = dbabog.verAbogado(id);

        if(dbabog != null){
            edtNombre.setText(abog.getNombre());
            edtEspec.setText(abog.getEspecializacion());
            edtCorreo.setText(abog.getEmail());
            edtCosto.setText(String.valueOf(abog.getCostoh()));
            edtNombre.setInputType(InputType.TYPE_NULL);
            edtEspec.setInputType(InputType.TYPE_NULL);
            edtCorreo.setInputType(InputType.TYPE_NULL);
            edtCosto.setInputType(InputType.TYPE_NULL);
        }
    }
}