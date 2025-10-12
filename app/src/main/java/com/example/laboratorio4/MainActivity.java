package com.example.laboratorio4;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.laboratorio4.fragments.HomeFragment;
import com.example.laboratorio4.fragments.ListaEdificacionesFragment;
import com.example.laboratorio4.fragments.MapaEdificacionesFragment;
import com.example.laboratorio4.viewmodel.SharedViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private SharedViewModel modeloCompartido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modeloCompartido = new ViewModelProvider(this).get(SharedViewModel.class);
        BottomNavigationView bottom = findViewById(R.id.bottomNavigation);

        bottom.setOnItemSelectedListener(item -> {
            Fragment seleccionado = null;
            int id = item.getItemId();
            if (id == R.id.nav_home) seleccionado = new HomeFragment();
            else if (id == R.id.nav_lista) seleccionado = new ListaEdificacionesFragment();
            else if (id == R.id.nav_mapa) seleccionado = new MapaEdificacionesFragment();

            if (seleccionado != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contenedorFragments, seleccionado)
                        .commit();
                return true;
            }
            return false;
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contenedorFragments, new HomeFragment())
                    .commit();
            bottom.setSelectedItemId(R.id.nav_home);
        }
    }
}
