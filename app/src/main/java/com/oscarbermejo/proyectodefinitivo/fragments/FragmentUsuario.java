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
 */
public class FragmentUsuario extends Fragment {
    private MainActivity mainActivity;

    //Lista de tags que va contener la pestaña usuario
    private ArrayList<Tag> tagsLista;

    //contexto de la aplicacion
    private Context context;

    public FragmentUsuario(){
        //constructor necesario vacio
    }

    public FragmentUsuario(MainActivity mainActivity, Context context, ArrayList<Tag> datosLista) {
        this.mainActivity = mainActivity;
        this.context = context;
        this.tagsLista = datosLista;
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


        ListView listaTags = vista.findViewById(R.id.lista_tags_usuario);
        listaTags.setAdapter(new AdaptadorFragmentUsuario(context, tagsLista));
        listaTags.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tag tagSe = (Tag)listaTags.getItemAtPosition(position);
                mainActivity.lanzarActividad(tagSe.getClase());
            }
        });


        return vista;
    }
}