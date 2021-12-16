package com.example.gestionabogados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import com.example.gestionabogados.db.Abogados;
import com.example.gestionabogados.modelo.Abogado;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class VerAbogado extends AppCompatActivity {
    EditText edtIdent, edtNombre, edtEspec, edtCorreo, edtCosto;
    Abogado abog;
    FloatingActionButton fbotonEditar;
    int id;
    boolean correcto = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_abogado);

        edtNombre = findViewById(R.id.edtNombre);
        edtEspec = findViewById(R.id.edtEspecializacion);
        edtCorreo = findViewById(R.id.edtCorreo);
        edtCosto = findViewById(R.id.edtCosto);
        fbotonEditar = findViewById(R.id.flBtnEditar);
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

        Abogados dbabog = new Abogados(VerAbogado.this);
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

        fbotonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correcto = dbabog.editarAbogado(id,edtNombre.getText().toString(),edtEspec.getText().toString(),
                        edtCorreo.getText().toString(), Integer.parseInt(edtCorreo.getText().toString()));
            }
            /*if (correcto){
                Toast.makeText()
            }else{

            }*/
        });
    }
}