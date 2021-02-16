package com.oscarbermejo.proyectodefinitivo.pojos;

import android.content.Intent;

/**
 * Pojo que almacena todos los datos de un tag de usuario
 * Un tag es una opcion que el usuario tiene dentro de su pantalla
 *   y este tag contiene un texto, una imagen y una actividad que puede lanzar
 */
public class TagUsuario implements Tag{
    private Class clase;
    private String texto;
    private int imagen;

    public TagUsuario() {
        //Constructor vacio
    }

    public TagUsuario(String texto, int imagen, Class clase) {
        this.clase = clase;
        this.texto = texto;
        this.imagen = imagen;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public Class getClase() {
        return clase;
    }

    public void setClase(Class clase) {
        this.clase = clase;
    }
}
