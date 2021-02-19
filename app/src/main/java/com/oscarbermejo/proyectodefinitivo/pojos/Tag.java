package com.oscarbermejo.proyectodefinitivo.pojos;

import com.oscarbermejo.proyectodefinitivo.MainActivity;
import com.oscarbermejo.proyectodefinitivo.R;

/**
 * Interfaz Tag que contiene una clase que
 * corresponde a la actividad que va a lanzar el tag una vez
 * seleccionado
 *
 * Un tag es una opcion que el usuario tiene dentro de su pantalla
 *  *   y este tag contiene un texto, una imagen y una actividad que puede lanzar
 */
public class Tag {
    protected Class clase;
    protected String texto;
    protected int imagen;

    /**
     * Permite crear un constructor vacio del tag
     */
    public Tag(){
        //Constructor vacio del tag
        this.texto = "Tag";
        this.clase = MainActivity.class;
        this.imagen = R.drawable.ic_home;
    }

    public Tag(String texto, int imagen, Class clase) {
        this.clase = clase;
        this.texto = texto;
        this.imagen = imagen;
    }




}
