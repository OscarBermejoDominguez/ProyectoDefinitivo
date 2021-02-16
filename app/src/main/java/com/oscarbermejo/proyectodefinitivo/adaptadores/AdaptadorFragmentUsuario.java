package com.oscarbermejo.proyectodefinitivo.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.oscarbermejo.proyectodefinitivo.R;
import com.oscarbermejo.proyectodefinitivo.pojos.Tag;
import com.oscarbermejo.proyectodefinitivo.pojos.TagUsuario;
import com.oscarbermejo.proyectodefinitivo.pojos.Usuario;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdaptadorFragmentUsuario extends BaseAdapter {
    private ArrayList<Tag> datosLista;
    private Context context;

    public AdaptadorFragmentUsuario(Context context, ArrayList<Tag> datosLista) {
        this.context = context;
        this.datosLista = datosLista;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Tag que corresponde a una opcion que NO ES la pestania usuario
        if(position != 0){
            //Inflamos el layout correspondiente al tag
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_tag, parent, false);
            //conseguimos el datos del tag siguiente
            TagUsuario tagS = (TagUsuario)datosLista.get(position);

            //Seteamos una imagen por defecto al tag
            if(tagS.getImagen() == 0)  tagS.setImagen(R.drawable.corazon_favorito);

            //Conseguimos la imagen del layout
            ((ImageView)convertView.findViewById(R.id.imagen_tag)).
                    setImageDrawable(context.getDrawable(tagS.getImagen())); //Setamos imagen
            ((TextView)convertView.findViewById(R.id.texto_tag)).
                    setText(tagS.getTexto());
        }
        //Tag que corresponde a los datos del usuario
        else{
            Usuario tagUsuario = (Usuario) datosLista.get(position);
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_pestania_usuario, parent, false);

            //Seteamos una imagen por defecto al tagUsuario
            if(tagUsuario.getImagen() == 0)  tagUsuario.setImagen(R.drawable.ic_account2);

            //Conseguimos la imagen del layout
            ((ImageView)convertView.findViewById(R.id.imagen_usario)).
                    setImageDrawable(context.getDrawable(tagUsuario.getImagen())); //Setamos imagen
            ((TextView)convertView.findViewById(R.id.texto_usuario_nombre)).
                    setText(tagUsuario.getNombre());
            ((TextView)convertView.findViewById(R.id.texto_usuario_cuenta)).
                    setText(tagUsuario.getCuenta());
        }

        //Devolvemos el layout correspondiente
        return convertView;
    }

    @Override
    public int getCount() {
        return datosLista.size();
    }

    @Override
    public Object getItem(int position) {
        return datosLista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
