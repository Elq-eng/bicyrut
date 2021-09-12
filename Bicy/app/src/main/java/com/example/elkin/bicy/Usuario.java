package com.example.elkin.bicy;

public class Usuario {

    private String name;
    private String Apellido;
    private String Ciudad;
    private int Edad;
    private int Contraseña;
    private String Sexo;
    private String Mujer;
    private String Hombre;
    private String Usuario2;
    private int Contra;

    public Usuario(){

    }

    public Usuario(String name, String apellido, String ciudad, int edad, int contraseña, String sexo, String mujer, String hombre, String usuario, int contra) {
        this.name = name;
        Apellido = apellido;
        Ciudad = ciudad;
        Edad = edad;
        Contraseña = contraseña;
        Sexo = sexo;
        Mujer = mujer;
        Hombre = hombre;
        Usuario2 = usuario;
        Contra = contra;
    }

    public String getUsuario() {
        return Usuario2;
    }

    public void setUsuario(String usuario) {
        Usuario2 = usuario;
    }

    public int getContra() {
        return Contra;
    }

    public void setContra(int contra) {
        Contra = contra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public int getContraseña() {
        return Contraseña;
    }

    public void setContraseña(int contraseña) {
        Contraseña = contraseña;
    }

    public String getMujer() {
        return Mujer;
    }

    public void setMujer(String mujer) {
        Mujer = mujer;
    }

    public String getHombre() {
        return Hombre;
    }

    public void setHombre(String hombre) {
        Hombre = hombre;
    }
}
