package com.oscarbermejo.proyectodefinitivo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.oscarbermejo.proyectodefinitivo.fragments.FragmentoOscar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.bottomNavigationView_main);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.parte_home);


    }


    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            String texto = "FRAGMENTO ";
            switch (item.getItemId()) {
                case R.id.parte_noticias:
                    texto += "NOTICIAS";
                    break;
                case R.id.parte_home:
                    texto += "HOME";
                    break;
                case R.id.parte_usuario:
                    texto += "USUARIO";
                    break;
            }
            loadFragment(new FragmentoOscar(texto));

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
}