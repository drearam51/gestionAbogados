package com.example.gestionabogados.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.gestionabogados.modelo.Abogado;

import java.util.ArrayList;

public class Abogados extends DataBaseHelper{
    Context context;

    public Abogados(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarAbogado(String nombre, String espec, String correo, int costo){
        long id = 0;
        try {
            DataBaseHelper bddatos = new DataBaseHelper(context);
            SQLiteDatabase dbase = bddatos.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_NOMBRE, nombre);
            values.put(COLUMN_ESPECIALIZACION, espec);
            values.put(COLUMN_EMAIL, correo);
            values.put(COLUMN_COSTOH, costo);
            id = dbase.insert(TABLA_ABOGADOS, null, values);
        }catch(Exception excep){
            excep.toString();
        }
        return id;
    }

    public ArrayList<Abogado> listarAbogados() {
        DataBaseHelper dbdatos = new DataBaseHelper(context);
        SQLiteDatabase db = dbdatos.getWritableDatabase();

        ArrayList<Abogado> listaAbogados = new ArrayList<>();
        Abogado abog = null;
        Cursor cursorAbogados = null;

        cursorAbogados = db.rawQuery("SELECT * FROM " + TABLA_ABOGADOS, null);
        if (cursorAbogados.moveToFirst()) {
            do {
                abog = new Abogado();
                abog.setIdentificacion(cursorAbogados.getInt(0));
                abog.setNombre(cursorAbogados.getString(1));
                abog.setEspecializacion(cursorAbogados.getString(2));
                abog.setEmail(cursorAbogados.getString(3));
                abog.setCostoh(cursorAbogados.getInt(4));
                listaAbogados.add(abog);
            } while (cursorAbogados.moveToNext());

        }
        cursorAbogados.close();
        return listaAbogados;
    }

    public Abogado verAbogado(int id) {
        DataBaseHelper dbdatos = new DataBaseHelper(context);
        SQLiteDatabase db = dbdatos.getWritableDatabase();

        Abogado abog = null;
        Cursor cursorAbogados = null;

        cursorAbogados = db.rawQuery("SELECT * FROM " + TABLA_ABOGADOS + " WHERE "+COLUMN_ID+"=" + id + " LIMIT 1", null);
        if (cursorAbogados.moveToFirst()) {
            abog = new Abogado();
            abog.setIdentificacion(cursorAbogados.getInt(0));
            abog.setNombre(cursorAbogados.getString(1));
            abog.setEspecializacion(cursorAbogados.getString(2));
            abog.setEmail(cursorAbogados.getString(3));
            abog.setCostoh(cursorAbogados.getInt(4));

        }
        cursorAbogados.close();
        return abog;
    }

    public boolean editarAbogado(int ident, String nombre, String espec, String correo, int costo){
        boolean correcto = false;
        DataBaseHelper bddatos = new DataBaseHelper(context);
        SQLiteDatabase dbase = bddatos.getWritableDatabase();
        try {
            dbase.execSQL("UPDATE " + TABLA_ABOGADOS + " SET nombre='"+nombre+"',espec='"+ espec + "'," +
                    "correo='"+correo+"'+ costo = "+costo + " WHERE "+COLUMN_ID+"="+ident);
            correcto=true;
        }catch(Exception excep){
            excep.toString();
            correcto = false;
        }finally{
            dbase.close();
        }
        return correcto;
    }
}
