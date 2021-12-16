package com.example.gestionabogados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class InicioAplicacion extends AppCompatActivity implements View.OnClickListener {
    ProgressBar pb;
    TextView tv;
    Button bt;
    Handler h=new Handler();
    boolean isActivo=false;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_aplicacion);
        pb = findViewById(R.id.pbBuscandoAbog);
        tv = findViewById(R.id.txtPorcentaje);
        bt = findViewById(R.id.btnBuscar);
        bt.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnBuscar) {
            if(!isActivo) {
                Thread hilo = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (i<=100){
                            h.post(new Runnable() {
                                @Override
                                public void run() {
                                    tv.setText(i+" %");
                                    pb.setProgress(i);
                                }
                            });
                            try{
                                Thread.sleep(100);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                            if(i==100){
                                Intent intent = new Intent(InicioAplicacion.this,Familia.class);
                                startActivity(intent);
                            }
                            i++;
                            isActivo=true;
                        }
                    }
                });
                hilo.start();
            }
        }
    }
}