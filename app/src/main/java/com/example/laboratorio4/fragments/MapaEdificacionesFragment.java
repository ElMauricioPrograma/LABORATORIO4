package com.example.laboratorio4.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.laboratorio4.R;
import com.example.laboratorio4.model.Edificacion;
import com.example.laboratorio4.viewmodel.SharedViewModel;
import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class MapaEdificacionesFragment extends Fragment {

    private MapView mapView;
    private TextView textoPlaceholder;
    private SharedViewModel modelo;
    private static final double DEFAULT_LAT = -16.4090;
    private static final double DEFAULT_LNG = -71.5375;
    private static final int DEFAULT_ZOOM = 15;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Configuration.getInstance().setUserAgentValue(requireActivity().getApplicationContext().getPackageName());
        View v = inflater.inflate(R.layout.fragment_mapa, container, false);
        mapView = v.findViewById(R.id.osmMapView);
        textoPlaceholder = v.findViewById(R.id.textMapaPlaceholder);
        modelo = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        mapView.setMultiTouchControls(true);
        mapView.getController().setZoom(DEFAULT_ZOOM);
        mapView.getController().setCenter(new GeoPoint(DEFAULT_LAT, DEFAULT_LNG));
        modelo.getEdificacionSeleccionada().observe(getViewLifecycleOwner(), ed -> {
            if (ed != null) {
                mostrarEdificacionEnMapa(ed);
            } else {
                textoPlaceholder.setVisibility(View.VISIBLE);
            }
        });
        return v;
    }

    private void mostrarEdificacionEnMapa(Edificacion ed) {
        textoPlaceholder.setVisibility(View.GONE);
        mapView.getOverlays().clear();
        GeoPoint punto = new GeoPoint(ed.getLat(), ed.getLng());
        Marker marcador = new Marker(mapView);
        marcador.setPosition(punto);
        marcador.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marcador.setTitle(ed.getNombre());
        marcador.setSnippet(ed.getDireccion());
        mapView.getOverlays().add(marcador);
        mapView.getController().animateTo(punto);
        mapView.getController().setZoom(16.0);
        mapView.invalidate();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mapView != null) mapView.onResume();
    }

    @Override
    public void onPause() {
        if (mapView != null) mapView.onPause();
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        if (mapView != null) mapView.onDetach();
        super.onDestroyView();
    }
}
