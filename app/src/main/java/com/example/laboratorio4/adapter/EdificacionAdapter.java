package com.example.laboratorio4.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.laboratorio4.R;
import com.example.laboratorio4.model.Edificacion;
import java.util.List;

public class EdificacionAdapter extends RecyclerView.Adapter<EdificacionAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Edificacion e);
    }

    private final List<Edificacion> lista;
    private final OnItemClickListener listener;

    public EdificacionAdapter(List<Edificacion> lista, OnItemClickListener listener) {
        this.lista = lista;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_edificacion, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Edificacion e = lista.get(position);
        holder.textNombre.setText(e.getNombre());
        holder.textDireccion.setText(e.getDireccion());
        holder.itemView.setOnClickListener(v -> listener.onItemClick(e));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textNombre, textDireccion;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textNombre = itemView.findViewById(R.id.textNombreEdificacion);
            textDireccion = itemView.findViewById(R.id.textDireccionEdificacion);
        }
    }
}
