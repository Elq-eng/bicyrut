package com.example.elkin.bicy;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Consultar_Usurarios extends AppCompatActivity {
    Basededatos baseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar__usurarios);
        cargar();
    }

    public void cargar(){
        baseHelper = new Basededatos(this, "DBCLIENTE" , null ,1);
        //Voy a escribir sobre la tabla de la BD
        SQLiteDatabase db = baseHelper.getReadableDatabase();
        if (db!=null){
            Cursor c = db.rawQuery("select * from USUARIOS",null );
            int cantidad = c.getCount();
            int i=0;
            String[] arreglo = new String[cantidad];
            if(c.moveToFirst()){
                do{

                    String linea = c.getString(0)+" " + c.getString(1)+" "+c.getString(2)+" "+c.getInt(3)+" "+c.getInt(4)+" "+c.getString(5)+" "+c.getString(6);
                    arreglo[i] = linea;
                    i++;
                }while(c.moveToNext());
            }
            ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arreglo);
            ListView lista = (ListView) findViewById(R.id.Lista);
            lista.setAdapter(adapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu mimenu){
        getMenuInflater().inflate(R.menu.menu_en_activity, mimenu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem opcion_menu){
        int id = opcion_menu.getItemId();
        if (id==R.id.configuracion){
            return true;
        }
        if (id == R.id.action_listar)
        {
            startActivity(new Intent(this, Consultar_Usurarios.class));
        }
        return super.onOptionsItemSelected(opcion_menu);
    }


}
