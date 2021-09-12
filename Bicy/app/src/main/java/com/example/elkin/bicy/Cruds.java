package com.example.elkin.bicy;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

public class Cruds
{
    Basededatos baseHelper;
    public Cruds(){

    }
    public Long insertar(Context context, Usuario us) {
        baseHelper = new Basededatos(context , "DBCLIENTE" , null ,1);
        //Voy a escribir sobre la tabla de la BD
        SQLiteDatabase db = baseHelper.getWritableDatabase();
        if (db != null) {
            ContentValues registronuevo = new ContentValues();
            //Agrego cada uno de los valores a la DB
            String name = us.getName();
            String apellido = us.getApellido();
            String ciudad = us.getCiudad();
            int Edad = us.getEdad();
            int contraseña = us.getContraseña();
            String Mujer = us.getMujer();
            String Hombre = us.getHombre();
            registronuevo.put("Nombre",name);
            registronuevo.put("Apellido",apellido);
            registronuevo.put("ciudad", ciudad);
            registronuevo.put("Edad", Edad);
            registronuevo.put("contraseña", contraseña);
            registronuevo.put("Hombre", Hombre);
            registronuevo.put("Mujer" , Mujer);
            long IdGuardado = db.insert("USUARIOS", null, registronuevo);
        }

        return null;
    }
    public Long insertar2(Context context, Bicy_Usuario Bicy) {
        baseHelper = new Basededatos(context , "DBCLIENTE" , null ,1);
        //Voy a escribir sobre la tabla de la BD
        SQLiteDatabase db = baseHelper.getWritableDatabase();
        if (db != null) {
            ContentValues registronuevo = new ContentValues();
            String propietario1,de1,marca21,calse1,dim1,color21,marco1;
            int cedula1;
            Drawable imagen1;
            propietario1 = Bicy.getPropietario();
            de1 = Bicy.getDe();
            marca21 = Bicy.getMarca();
            calse1 = Bicy.getClase();
            dim1 = Bicy.getDim();
            color21 = Bicy.getColor();
            marco1 = Bicy.getMarc();
            cedula1 = Bicy.getCedula();
            imagen1 = Bicy.getImagen();
            registronuevo.put("Propietario",propietario1);
            registronuevo.put("cedula",cedula1);
            registronuevo.put("de", de1);
            registronuevo.put("marca", marca21);
            registronuevo.put("clase", calse1);
            registronuevo.put("color", color21);
            registronuevo.put("Dim" , dim1);
            registronuevo.put("Marco" , marco1);
            registronuevo.put("foto" , String.valueOf(imagen1));
            long IdGuardado = db.insert("bicicletas", null, registronuevo);
        }

        return null;
    }

    public Long CONSULTAR(Context context, Usuario us )
    {   baseHelper = new Basededatos(context , "DBCLIENTE" , null ,1);
        SQLiteDatabase db = baseHelper.getReadableDatabase();
        String name = us.getUsuario();
        int  pass = us.getContra();
        if (db != null)
        {
            Cursor c = db.rawQuery("select Nombre, contraseña from USUARIOS where Nombre ='"+name+"' AND Contrasena='"+pass+"'", null);
            if(c.moveToFirst()){
                //Hago un muestreo de los datos, uno por uno hasta que llegue al ultimo
                Toast.makeText(context, "BIENBENIDOS", Toast.LENGTH_SHORT).show();
                Intent  intent2= new Intent(context, Guia.class);
                context.startActivity(intent2);
            }else{
                Toast.makeText(context, "Datos incorrectos", Toast.LENGTH_SHORT).show();
            }
        }

        return null;
    }



}
