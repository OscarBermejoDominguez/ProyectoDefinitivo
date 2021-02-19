package com.oscarbermejo.proyectodefinitivo.pojos;

public class Usuario implements Tag {
    //Nombre y correo del usuario
    private String nombre, cuenta;
    //Imagen representativa del usuario
    private int imagen;
    //Actividad que se lanza cuando el usuario clica en el panel
    private Class actividad;


    public Usuario(String nombre, String cuenta, int imagen, Class actividad) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.imagen = imagen;
        this.actividad = actividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public Class getClase() {
        return actividad;
    }

    public void setClase(Class actividad) {
        this.actividad = actividad;
    }
}
