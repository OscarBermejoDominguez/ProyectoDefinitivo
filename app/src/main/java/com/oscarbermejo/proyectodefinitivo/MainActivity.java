package com.oscarbermejo.proyectodefinitivo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.oscarbermejo.proyectodefinitivo.fragments.FragmentUsuario;
import com.oscarbermejo.proyectodefinitivo.fragments.FragmentoOscar;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private Aplicacion aplicacion;
    private MainActivity mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.aplicacion = (Aplicacion)this.getApplication();

        BottomNavigationView navigation = findViewById(R.id.bottomNavigationView_main);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.parte_home);

        mainActivity = this;
    }


    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragmento = null;
            switch (item.getItemId()) {
                case R.id.parte_noticias:
                    fragmento = new FragmentoOscar("Fragmento noticias");
                    break;
                case R.id.parte_home:
                    fragmento = new FragmentoOscar("Fragmento home");
                    break;
                case R.id.parte_usuario:
                    fragmento = new FragmentUsuario(mainActivity ,mainActivity.getBaseContext(),
                                    aplicacion.getTagsUsuarios());
                    break;
            }

            if(fragmento != null)
                loadFragment(fragmento);
            return true;
        }
    };

    /**
     * Permite cargar un fragment dentro del frameLayout que tenemos en la
     * actividad principal
     * @param fragment que queremos insertar en el frameLayout
     */
    public void loadFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentLayout_main, fragment);
        ft.commit();
    }

    public void clickFamilias(View view) {
        Intent intent = new Intent(this, FamiliasProfesionalesActivity.class);
        startActivity(intent);
    }

    public void lanzarActividad(Class clase){
        Intent i = new Intent(this, clase);
        startActivity(i);
    }
}