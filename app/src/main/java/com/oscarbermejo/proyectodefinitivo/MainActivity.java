package com.oscarbermejo.proyectodefinitivo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.QuickContactBadge;
import android.widget.SearchView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.oscarbermejo.proyectodefinitivo.fragments.FragmentUsuario;
import com.oscarbermejo.proyectodefinitivo.fragments.FragmentoOscar;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private Aplicacion aplicacion;
    private MainActivity mainActivity;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.aplicacion = (Aplicacion)this.getApplication();

        BottomNavigationView navigation = findViewById(R.id.bottomNavigationView_main);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.parte_home);

//        toolbar = findViewById(R.id.toolbar_main);
//        setSupportActionBar(toolbar);

        ArrayAdapter<String> datosLista = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        mainActivity = this;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_toolbar_main, menu);
//        //Insertamos el buscador que permite buscar por datos de la aplicacion
//        MenuItem menuItem = menu.findItem(R.id.search_bar);
//
//        SearchView searchView =  (SearchView)menuItem.getActionView();
////        searchView.setQueryHint("Buscador!!!!");
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return true;
//            }
//        });

        return onCreateOptionsMenu(menu);
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
//        ft.setCustomAnimations(R.anim.fragment_fast_out_extra_slow_in, R.anim.nav_default_exit_anim, R.anim.nav_default_enter_anim, R.anim.nav_default_exit_anim);
        ft.addToBackStack(null);
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