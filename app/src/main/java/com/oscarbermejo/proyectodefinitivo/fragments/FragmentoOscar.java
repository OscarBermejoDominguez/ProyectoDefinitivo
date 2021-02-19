package com.oscarbermejo.proyectodefinitivo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oscarbermejo.proyectodefinitivo.R;


public class FragmentoOscar extends Fragment {
    private String texto;
    public FragmentoOscar() {
        // Required empty public constructor
    }

    public FragmentoOscar(String texto){
        this.texto = texto;
    }

    public static FragmentoOscar newInstance(String param1, String param2) {
        FragmentoOscar fragment = new FragmentoOscar();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //no se que cojones es esto
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista = inflater.inflate(R.layout.fragment_fragmento_oscar, container, false);

        ((TextView)vista.findViewById(R.id.textoFragmento)).setText(texto);
        return vista;
    }
}