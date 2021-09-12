package com.example.elkin.bicy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistrarUsuario extends AppCompatActivity {
    Button RegistarBu;
    EditText Nombre, Apellido, Ciudad, Contraseña, Edad;
    RadioButton Mujer, Hombre;
    Usuario usu = new Usuario();
    String Muje = " ", Hombre2 = " ";
    Cruds Funciones = new Cruds();
    Spinner ciudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);
        Nombre = (EditText) findViewById(R.id.txtNombre);
        Apellido = (EditText) findViewById(R.id.txtApellido);
        Ciudad = (EditText) findViewById(R.id.txtCiudad);
        Contraseña = (EditText) findViewById(R.id.txtContraseña);
        Edad = (EditText) findViewById(R.id.txtEdad);
        Hombre = (RadioButton) findViewById(R.id.txtHombre);
        Mujer = (RadioButton) findViewById(R.id.txtMujer);
        RegistarBu = (Button) findViewById(R.id.Resgitrar);
        ciudades = (Spinner) findViewById(R.id.Spin);

        ArrayAdapter<CharSequence> Adapter = ArrayAdapter.createFromResource(this,R.array.Ciudades, android.R.layout.simple_spinner_item);
        ciudades.setAdapter(Adapter);
        ciudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),
                        "Seleccionado: " + parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
                String Ciudad3;
            Ciudad.setText(parent.getItemAtPosition(position).toString());


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void Mujer(View view) {
        Muje = "Mujer";
    }
    public void Hombre2(View view) {
        Hombre2 = "Hombre";
    }


    public void Registrar(View view) {
        try {
            String nombre,apellido,ciudad,mujer, hombre;
            int  contraseña,edad;
            nombre = Nombre.getText().toString();
            apellido = Apellido.getText().toString();
            ciudad = Ciudad.getText().toString();
            contraseña = Integer.parseInt(Contraseña.getText().toString());
            edad = Integer.parseInt(Edad.getText().toString());
            mujer = Muje;
            hombre = Hombre2;
            usu.setName(nombre);
            usu.setApellido(apellido);
            usu.setCiudad(ciudad);
            usu.setContraseña(contraseña);
            usu.setEdad(edad);
            usu.setMujer(mujer);
            usu.setHombre(hombre);
            Funciones.insertar(getApplicationContext(),usu);
            LIMPIAR();
            Toast.makeText(this, "Registro Insertado", Toast.LENGTH_SHORT).show();
            Intent Registrar = new Intent( RegistrarUsuario.this,Cicla.class);
            startActivity(Registrar);


        }
        catch (Exception ex){
            Toast.makeText(this, "Llena todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
    public void LIMPIAR(){

        Nombre.setText(" ");
        Apellido.setText(" ");
        Ciudad.setText(" ");
        Contraseña.setText(" ");
        Edad.setText(" ");
        Hombre.setText(" ");
        Mujer.clearComposingText();
        Hombre.clearComposingText();

    }



}
