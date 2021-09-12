package com.example.elkin.bicy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Basededatos extends SQLiteOpenHelper {

    String Tabla = "CREATE TABLE USUARIOS(Nombre Text, Apellido Text, ciudad Text, Edad INTEGER, contraseña INTEGER,Mujer Text, Hombre Text)";
    String Tabla1 = "CREATE TABLE bicicletas(Propietario Text, cedula INTEGER, de Text, marca Text, clase Text,color Text, Dim Text, Marco Text, foto Drawable)";


    public Basededatos (Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Tabla);
        db.execSQL(Tabla1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS DBCLIENTE");
        db.execSQL(Tabla);
        db.execSQL(Tabla1);
    }
}
