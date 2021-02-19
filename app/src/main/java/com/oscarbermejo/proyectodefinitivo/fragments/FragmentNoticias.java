package com.oscarbermejo.proyectodefinitivo.fragments;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.oscarbermejo.proyectodefinitivo.R;

/**
 * Fragmento que permite visualizar las ultimas noticias sobre
 * la educacion de la rioja y sus centros
 * Este fragment comprueba si tiene conexion a internet y dependiendo si
 * tiene conexion o no va a sacar un layout u otro
 * Ademas este fragment es el responsable de controlar el permiso de INTERNET
 */
public class FragmentNoticias extends Fragment {
    //booleano que indica si el usuario tiene conexion a internet o no
    private boolean conexionInternet;

    //Contexto necesario para el navegador
    private Context context;

    public FragmentNoticias() {
        // Required empty public constructor
    }

    public FragmentNoticias(Context context, boolean conexionInternet) {
        //Asignamos tanto la conexion a internet como el contexto
        this.conexionInternet = conexionInternet;
        this.context = context;
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Dependiendo de la conexion que tengamos nos saldra una vista u otra
        View vista = null;
        //comprobamos si tenemos permisos de internet y conexion a internet
        if ((ContextCompat.checkSelfPermission(
                context, Manifest.permission.INTERNET) ==
                PackageManager.PERMISSION_GRANTED) && conexionInternet){

            //Inflamos la vista que contiene el navegador de noticias
            vista = inflater.inflate(R.layout.fragment_noticias, container, false);
            //Conseguimos el navegador e insertamos la url de las noticias
            WebView navegador = vista.findViewById(R.id.webView);
            String url = getResources().getString(R.string.url_noticias);
            navegador.loadUrl(url);
        }
        else//No tenemos conexion por ello iniciamos la pantalla si internet
            vista = inflater.inflate(R.layout.fragment_noticias_sin_internet, container, false);

        return vista;
    }
}