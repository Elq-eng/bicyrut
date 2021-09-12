package com.example.elkin.bicy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class principal extends AppCompatActivity {
    TextView nuevacuenta;
    EditText User;
    EditText Password;
    Button Iniciar;
    Cruds FUNCI = new Cruds();
    Usuario USUARIO = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        nuevacuenta = (TextView) findViewById(R.id.crearcuenta);
        User = (EditText) findViewById(R.id.txtuser);
        Password = (EditText) findViewById(R.id.txtpassword);
        Iniciar = ( Button) findViewById(R.id.Iniciar);

    }

    public void cuenta (View View){
        Intent nuevacuenta = new Intent( principal.this,RegistrarUsuario.class);
        startActivity(nuevacuenta);

    }

    public void Iniciar(View view) {

        String Users = User.getText().toString() , password = Password.getText().toString();
        if (Users.length() <= 0 || password.length() <= 0) {
            Toast.makeText(this, "Llena todos los campos", Toast.LENGTH_SHORT).show();
        }
        else{
            try {

                if (Users.equals("Admin") && password.equals("Admin")) {
                    Intent Consultar1 = new Intent(principal.this, Consultar_Usurarios.class);
                    startActivity(Consultar1);
                    Toast.makeText(this, "Usuario Administrativo", Toast.LENGTH_SHORT).show();
                } else {
                    USUARIO.setUsuario(Users);
                    USUARIO.setContra(Integer.parseInt(password));
                    FUNCI.CONSULTAR(getApplicationContext(), USUARIO);
                }

            } catch (Exception ex) {
                Toast.makeText(this, "Usuario Incorrecto", Toast.LENGTH_SHORT).show();
            }

        }

    }
}

