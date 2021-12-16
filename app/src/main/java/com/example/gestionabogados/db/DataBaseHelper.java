package com.example.gestionabogados.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.gestionabogados.modelo.Abogado;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String TABLA_ABOGADOS = "TABLA_ABOGADOS";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NOMBRE = "NOMBRE";
    public static final String COLUMN_ESPECIALIZACION = "ESPECIALIZACION";
    public static final String COLUMN_EMAIL = "EMAIL";
    public static final String COLUMN_COSTOH = "COSTOH";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "abogados.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableStatement = "CREATE TABLE " + TABLA_ABOGADOS + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NOMBRE + " TEXT, " + COLUMN_ESPECIALIZACION + " TEXT, " + COLUMN_EMAIL + " TEXT, " + COLUMN_COSTOH + " INT)";
        db.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(Abogado abogado){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NOMBRE, abogado.getNombre());
        cv.put(COLUMN_ESPECIALIZACION, abogado.getEspecializacion());
        cv.put(COLUMN_EMAIL, abogado.getEmail());
        cv.put(COLUMN_COSTOH, abogado.getCostoh());

        long insert = db.insert(TABLA_ABOGADOS, null, cv);

        if(insert == -1){
            return  false;
        }else{
            return true;
        }
    }
}
