package com.oscarbermejo.proyectodefinitivo;

import android.app.Application;

import com.oscarbermejo.proyectodefinitivo.pojos.Tag;
import com.oscarbermejo.proyectodefinitivo.pojos.TagUsuario;
import com.oscarbermejo.proyectodefinitivo.pojos.Usuario;

import java.util.ArrayList;

public class Aplicacion extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private TagUsuario[] crearTags(){
        //Imagenes de los tags
        Integer[] imagenes = {
                R.drawable.ic_favorite,
                R.drawable.ic_email,
                R.drawable.ic_baseline_history
        };

        //Textos de los tags
        String[] tags = {
                "Favoritos",
                "Conversaciones",
                "Historial"
        };

        //Clases que lanza cada tag al ser clicados
        Class[] clasesTags = {
                MainActivity.class,
                MainActivity.class,
                MainActivity.class
        };

        //creamos los tags nuevos
        TagUsuario[] tagsNuevos = new TagUsuario[imagenes.length];
        for(int i = 0; i < tagsNuevos.length; i++){
            tagsNuevos[i] = new TagUsuario(tags[i], imagenes[i], clasesTags[i]);
        }

        return tagsNuevos;
    }

    /**
     * Metodo que devuelve los datos que puede buscar el buscador
     * @return String[] con los datos que puede buscar
     */
    public String[] getSeacherBarOptions(){
        return new String[]{
                "Centros",
                "Lugares",
                "Grados",
                "Alumnos",
                "Profesores"
        };
    }

    /**
     * Optiene los datos del usuario
     * @return Usuario con sus datos correspondientes
     */
    private Usuario getUsuario(){
        return new Usuario("Oscar", "oscbermedomi@gmail.com", R.drawable.carcel, MainActivity.class);
    }

    public ArrayList<Tag> getTagsUsuarios(){
        ArrayList<Tag> tagsO = new ArrayList<Tag>();
        //Optenemos los tag añadidos
        tagsO.add(getUsuario());
        Tag[] tagO = crearTags();

        for(int i = 0; i < tagO.length; i++){
            tagsO.add(tagO[i]);
        }



        return tagsO;
    }

}
