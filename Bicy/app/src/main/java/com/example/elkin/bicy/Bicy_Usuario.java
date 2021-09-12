package com.example.elkin.bicy;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ListView;

public class Bicy_Usuario
{

    private String Propietario,de,marca,clase,color, dim ,marc;
    private int cedula;
    private Drawable imagen;


    public Bicy_Usuario()
    {
    }

    public Bicy_Usuario(String propietario, String de, String marca, String clase, String color, String dim, String marc, int cedula, Drawable imagen) {
        Propietario = propietario;
        this.de = de;
        this.marca = marca;
        this.clase = clase;
        this.color = color;
        this.dim = dim;
        this.marc = marc;
        this.cedula = cedula;
        this.imagen = imagen;
    }

    public String getPropietario() {
        return Propietario;
    }

    public void setPropietario(String propietario) {
        Propietario = propietario;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDim() {
        return dim;
    }

    public void setDim(String dim) {
        this.dim = dim;
    }

    public String getMarc() {
        return marc;
    }

    public void setMarc(String marc) {
        this.marc = marc;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }
}
