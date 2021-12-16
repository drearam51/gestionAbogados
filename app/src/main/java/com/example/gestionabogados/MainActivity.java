package com.example.gestionabogados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestionabogados.db.Abogados;
//import com.example.gestionabogados.db.DbBaseDatos;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nombres, email, especializacion, costoh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSiguiente = findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(this);
        Button btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(this);
        Button btnVerMapa = findViewById(R.id.btnVerMapa);
        btnVerMapa.setOnClickListener(this);
        Button btnUbicActual = findViewById(R.id.btnUbicActual);
        btnUbicActual.setOnClickListener(this);
        Button btnEliminar = findViewById(R.id.btnEliminar);
        btnEliminar.setOnClickListener(this);
        Button btnListar = findViewById(R.id.btnListar);
        btnListar.setOnClickListener(this);

        nombres = findViewById(R.id.edtNombre);
        email = findViewById(R.id.edtEmail);
        especializacion = findViewById(R.id.edtEspecialización);
        costoh = findViewById(R.id.edtCosto);
    }

    protected void definirMetodos(int opc){
        switch (opc){
            case R.id.btnIngresar:Toast.makeText(MainActivity.this,"Ingresar Datos", Toast.LENGTH_SHORT).show();

                /*Abogado abogado;

                try{
                    abogado = new Abogado(-1, nombres.getText().toString(), especializacion.getText().toString(), email.getText().toString(), Integer.parseInt(costoh.getText().toString()));

                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error created Lawyer", Toast.LENGTH_SHORT).show();
                    abogado = new Abogado(-1, "error","error","error",0);
                }
                DataBaseHelper dbBaseDatos = new DataBaseHelper(MainActivity.this);
                boolean success = dbBaseDatos.addOne(abogado);
                Toast.makeText(MainActivity.this, "Success "+success, Toast.LENGTH_SHORT).show();*/
                Abogados dbabog = new Abogados(MainActivity.this);
                long id = dbabog.insertarAbogado(nombres.getText().toString(), especializacion.getText().toString(),email.getText().toString(),
                        Integer.parseInt(costoh.getText().toString()));
                if(id>0){
                    Toast.makeText(this,"Se registro la base de datos",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"Error no se registró la base de datos",Toast.LENGTH_SHORT).show();
                }
                limpiarCampos();
                break;
            case R.id.btnVerMapa:Toast.makeText(MainActivity.this,"Ver Ubicación Bufete", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, MapsActivity.class);
                intent3.putExtra("tipoMapa","mapa");
                startActivity(intent3);
                break;
            case R.id.btnUbicActual:Toast.makeText(MainActivity.this,"Ver Ubicación Bufete", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(this, MapsActivity.class);
                intent4.putExtra("tipoMapa","actual");
                startActivity(intent4);
                break;
            case R.id.btnEliminar:Toast.makeText(MainActivity.this,"Eliminar Datos", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnListar:Toast.makeText(MainActivity.this,"Listar datos", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(this, ListaAbogados.class);
                                startActivity(intent);
                                break;

            case R.id.btnSiguiente: Intent intent2 = new Intent(this, Especialidades.class);
                startActivity(intent2);
        }
    }

    @Override
    public void onClick(View view){
        definirMetodos(view.getId());
    }

    public  void limpiarCampos(){
        nombres.setText("");
        especializacion.setText("");
        email.setText("");
        costoh.setText("");
        nombres.requestFocus();
    }
}