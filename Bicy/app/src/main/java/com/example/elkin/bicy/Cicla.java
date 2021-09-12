package com.example.elkin.bicy;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Cicla extends AppCompatActivity {

    ImageView imagen;
    EditText  Propietario,De,Marca,Clase,Dim,color1, marco1,Cedula;
    Bicy_Usuario Bicy = new Bicy_Usuario();
    Cruds Funciones = new Cruds();
    Spinner TiposCiclas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cicla);
        imagen = (ImageView) findViewById(R.id.imagennew);
        Propietario = (EditText) findViewById(R.id.txtPropietario);
        De = (EditText) findViewById(R.id.txtExpedicion);
        TiposCiclas =(Spinner) findViewById(R.id.Sp2);
        Marca = (EditText) findViewById(R.id.txtmarca);
        Clase = (EditText) findViewById(R.id.txtClase);
        Dim = (EditText) findViewById(R.id.txtDimesion);
        color1 = (EditText) findViewById(R.id.txtColor);
        marco1 = (EditText) findViewById(R.id.txtNumero);
        Cedula = (EditText) findViewById(R.id.txtCedula);

        ArrayAdapter<CharSequence > adapter = ArrayAdapter.createFromResource(this,R.array.TiposCiclas,android.R.layout.simple_spinner_item);
        TiposCiclas.setAdapter(adapter);
        TiposCiclas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),
                        "Seleccionado: " + parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
                String Ciudad3;
                Clase.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void Subir(View view) {
        cargarimagen();
    }

    private void cargarimagen() {
        Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Seleccione la Aplicacion"),10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode ==RESULT_OK)
        {
            Uri patch = data.getData();
            imagen.setImageURI(patch);
        }
    }

    public void Subir_Bici(View view) {
        try {
            String propietario,de,marca2,calse,dim,color2,marco;
            int cedula;
            Drawable Imagen;
            propietario = Propietario.getText().toString();
            de = De.getText().toString();
            marca2 = Marca.getText().toString();
            calse = Clase.getText().toString();
            dim = Dim.getText().toString();
            marco = marco1.getText().toString();
            cedula = Integer.parseInt(Cedula.getText().toString());
            Imagen = imagen.getDrawable();

            Bicy.setImagen(Imagen);
            Bicy.setPropietario(propietario);
            Bicy.setDe(de);
            Bicy.setMarca(marca2);
            Bicy.setClase(calse);
            Bicy.setDim(dim);
            Bicy.setMarc(marco);
            Bicy.setCedula(cedula);
            Funciones.insertar2(getApplicationContext(),Bicy);
            LIMPIAR();
            Toast.makeText(this, "Bicicleta Registrada", Toast.LENGTH_SHORT).show();

            Intent Subir1= new Intent(Cicla.this, principal.class);
            startActivity(Subir1);



        }
        catch (Exception ex){
            Toast.makeText(this, "Llena todos los campos", Toast.LENGTH_SHORT).show();
        }

    }

    public void LIMPIAR(){

        Propietario.setText(" ");
        De.setText(" ");
        Marca.setText(" ");
        Clase.setText(" ");
        Dim.setText(" ");
        color1.setText(" ");
        marco1.setText(" ");
        Cedula.setText(" ");
        imagen.clearAnimation();

    }
}
