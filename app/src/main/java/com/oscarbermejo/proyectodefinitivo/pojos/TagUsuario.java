package com.oscarbermejo.proyectodefinitivo.pojos;

import android.content.Intent;

/**
 * Tag que permite almacenar una opcion que tiene disponible el usuario para clicar
 */
public class TagUsuario extends Tag{


    public TagUsuario() {
        //Constructor vacio
    }

    public TagUsuario(String texto, int imagen, Class clase) {
        super(texto, imagen, clase);
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

    @Override
    public Class getClase() {
        return clase;
    }

    public void setClase(Class clase) {
        this.clase = clase;
    }
}
