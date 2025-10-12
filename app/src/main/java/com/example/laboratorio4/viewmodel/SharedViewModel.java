package com.example.laboratorio4.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.laboratorio4.model.Edificacion;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Edificacion> edificacionSeleccionada = new MutableLiveData<>();

    public void seleccionarEdificacion(Edificacion e) {
        edificacionSeleccionada.setValue(e);
    }

    public LiveData<Edificacion> getEdificacionSeleccionada() {
        return edificacionSeleccionada;
    }
}

