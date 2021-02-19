package com.oscarbermejo.proyectodefinitivo.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.oscarbermejo.proyectodefinitivo.MainActivity;
import com.oscarbermejo.proyectodefinitivo.R;
import com.oscarbermejo.proyectodefinitivo.adaptadores.AdaptadorFragmentUsuario;
import com.oscarbermejo.proyectodefinitivo.pojos.Tag;
import com.oscarbermejo.proyectodefinitivo.pojos.TagUsuario;
import com.oscarbermejo.proyectodefinitivo.pojos.Usuario;

import java.util.ArrayList;

/**
 * Fragmento que muestra todos los datos relacionados con el usuario
 * Muestra una lista de tags junto con tag especial que contiene todos los datos del
 * usuario logeado
 */
public class FragmentUsuario extends Fragment {
    //main activity que nos permite lanzar diferentes pantallas dependiendo del tag
    /// seleccionado
    private MainActivity mainActivity;

    //Lista de tags que va contener la pestaña usuario
    private ArrayList<Tag> tagsLista;

    public FragmentUsuario(){
        //constructor necesario vacio
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // conseguimos la vista del fragment usuario
        View vista = inflater.inflate(R.layout.fragment_usuario, container, false);

        //Conseguimos de la vista los tags que tiene el usuario disponibles
        ListView listaTags = vista.findViewById(R.id.lista_tags_usuario);
        //Insertamos el adaptador a la lista
        listaTags.setAdapter(new AdaptadorFragmentUsuario(mainActivity.getBaseContext(), tagsLista));
        listaTags.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * Dependiendo del tag seleccionado nos sacara una actividad u otra
             * @param parent
             * @param view
             * @param position
             * @param id
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tag tagSe = (Tag)listaTags.getItemAtPosition(position); //Conseguimos el tag
                //Lanzamos la nueva actividad con la clase del tag
                mainActivity.lanzarActividad(tagSe.getClase());
            }
        });
        return vista; //Devolvemos la vista con todos los datos insertados
    }
}