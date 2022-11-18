package com.example.proyectolomb.ui.listar_libros;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectolomb.R;
import com.example.proyectolomb.classes.entities.Libro;

import java.util.ArrayList;

public class adapterEquipos extends RecyclerView.Adapter<adapterEquipos.VistaHolder>{

    private ArrayList<Libro> mDataSet;

    // Obtener referencias de los componentes visuales para cada elemento
    // Es decir, referencias de los EditText, TextViews, Buttons
    public static class VistaHolder extends RecyclerView.ViewHolder {
        // en este ejemplo cada elemento consta solo de un título
         TextView dispositivo;
         TextView estado;
         TextView localizacion;
         Button boton;
        Button boton2;
        public VistaHolder(View v) {
            super(v);
            dispositivo = v.findViewById(R.id.contenidoDispositivos);
            estado = v.findViewById(R.id.contenidoEstado);
            localizacion = v.findViewById(R.id.contenidoLocalizacion);
            boton   =  v.findViewById(R.id.contenidoBoton);
            boton2   =  v.findViewById(R.id.contenidoBoton2);
        }
    }

    // Este es nuestro constructor (puede variar según lo que queremos mostrar)
    public adapterEquipos(ArrayList<Libro> myDataSet) {
        mDataSet = myDataSet;
    }

    // El layout manager invoca este método
    // para renderizar cada elemento del RecyclerView
    @Override
    public VistaHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // Creamos una nueva vista
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_items, parent, false);
        return new VistaHolder(v);
    }



    // Este método asigna valores para cada elemento de la lista
    @Override
    public void onBindViewHolder(@NonNull VistaHolder holder, int position) {
        // - obtenemos un elemento del dataset según su posición
        // - reemplazamos el contenido usando tales datos
        Libro equipo = mDataSet.get(position);

        // Hay que activar cuando tenga la conexion a la api y tengo que recibir la categoria
        // holder.dispositivo.setText(equipo.getIdCategoria().isEmpty() ? "" :  equipo.getIdCategoria());
        holder.dispositivo.setText("Categoria");
        holder.estado.setText(equipo.getISBN().isEmpty() ? "" :  equipo.getISBN());
        holder.localizacion.setText(equipo.getNombre().isEmpty() ? "" :  equipo.getNombre());

        holder.boton.setText("Reservar");

        /*
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this, DetalleEquipo.class);

                intent.putExtra("id", id);
                contexto.startActivity(intent);
            }
        }); */
    }

    // Método que define la cantidad de elementos del RecyclerView
    // Puede ser más complejo (por ejem, si implementamos filtros o búsquedas)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
