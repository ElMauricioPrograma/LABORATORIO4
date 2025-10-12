package com.example.laboratorio4.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.laboratorio4.R;
import com.example.laboratorio4.adapter.EdificacionAdapter;
import com.example.laboratorio4.model.Edificacion;
import com.example.laboratorio4.viewmodel.SharedViewModel;
import java.util.ArrayList;
import java.util.List;

public class ListaEdificacionesFragment extends Fragment {

    private RecyclerView recycler;
    private SharedViewModel modelo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lista_edificaciones, container, false);
        recycler = v.findViewById(R.id.recyclerEdificaciones);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        modelo = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        List<Edificacion> datos = generarDatosEjemplo();

        EdificacionAdapter adapter = new EdificacionAdapter(datos, e -> {
            modelo.seleccionarEdificacion(e);
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contenedorFragments, new MapaEdificacionesFragment())
                    .addToBackStack(null)
                    .commit();
        });

        recycler.setAdapter(adapter);
        return v;
    }

    private List<Edificacion> generarDatosEjemplo() {
        List<Edificacion> lista = new ArrayList<>();
        lista.add(new Edificacion("Biblioteca Central", "Av. Universitaria 123", -16.4090, -71.5375));
        lista.add(new Edificacion("Facultad de Ingeniería", "Jr. Ingeniería 456", -16.4095, -71.5368));
        lista.add(new Edificacion("Centro Cultural", "Plaza Principal", -16.4101, -71.5370));
        return lista;
    }
}
