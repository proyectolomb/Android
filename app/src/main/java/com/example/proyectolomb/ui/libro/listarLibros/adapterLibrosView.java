package com.example.proyectolomb.ui.libro.listarLibros;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectolomb.ExpandAndCollapseViewUtil;
import com.example.proyectolomb.R;
import com.example.proyectolomb.classes.entities.Libro;

import java.util.ArrayList;

public class adapterLibrosView extends RecyclerView.Adapter<adapterLibrosView.VistaHolder> implements View.OnClickListener {

    private ArrayList<Libro> mDataSet;
    private ViewGroup linearLayoutDetails;
    private static final int DURATION = 250;
    private ImageView imageViewExpand;
    private ExpandableListView expListView;
    private ArrayList<ViewGroup> lldS=new ArrayList<ViewGroup>();
    private ArrayList<ImageView> ivs=new ArrayList<ImageView>();
    private ArrayList<ImageButton> ibs=new ArrayList<ImageButton>();


    // Obtener referencias de los componentes visuales para cada elemento
    // Es decir, referencias de los EditText, TextViews, Buttons
    public static class VistaHolder extends RecyclerView.ViewHolder {
        // en este ejemplo cada elemento consta solo de un título
        private ViewGroup linearLayoutDetails;
        private ImageView imageViewExpand;
        TextView tituloCabecera;
         TextView ISBN;
         TextView Fecha;
         Button boton;
        Button boton2;
        ImageButton expandir;


        public VistaHolder(View v) {
            super(v);
            tituloCabecera= v.findViewById(R.id.presentacionTitulo);
            ISBN = v.findViewById(R.id.contenidoISBN);
            Fecha = v.findViewById(R.id.contenidoFechaPubli);
            boton   =  v.findViewById(R.id.contenidoBoton);
            boton2   =  v.findViewById(R.id.contenidoBoton2);
            expandir=v.findViewById(R.id.imageViewExpand);
            linearLayoutDetails=v.findViewById(R.id.linearLayoutDetails);
            imageViewExpand=v.findViewById(R.id.imageViewExpand);
        }
    }

    // Este es nuestro constructor (puede variar según lo que queremos mostrar)
    public adapterLibrosView(ArrayList<Libro> myDataSet) {
        mDataSet = myDataSet;
    }

    // El layout manager invoca este método
    // para renderizar cada elemento del RecyclerView
    @Override
    public VistaHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // Creamos una nueva vista
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_libro, parent, false);
        return new VistaHolder(v);
    }



    // Este método asigna valores para cada elemento de la lista
    @Override
    public void onBindViewHolder(@NonNull VistaHolder holder, int position) {
        // - obtenemos un elemento del dataset según su posición
        // - reemplazamos el contenido usando tales datos
        Libro libro = mDataSet.get(position);

        // Hay que activar cuando tenga la conexion a la api y tengo que recibir la categoria
        // holder.dispositivo.setText(libro.getIdCategoria().isEmpty() ? "" :  libro.getIdCategoria());
        holder.tituloCabecera.setText(libro.getNombre().isEmpty() ? "" :  libro.getNombre());
        holder.ISBN.setText(libro.getISBN().isEmpty() ? "ISBN: "+"" :  "ISBN: "+libro.getISBN());
        holder.Fecha.setText(libro.getFechaPublicacion().toString().isEmpty() ? "" :  libro.getFechaPublicacion().toString());
        holder.boton.setText("Eliminar");
        holder.boton2.setText("Modificar");
        lldS.add(holder.linearLayoutDetails);
        ivs.add(holder.imageViewExpand);
        ibs.add(holder.expandir);

        //eventos
        holder.expandir.setOnClickListener(this);

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
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.imageViewExpand){
            toggleDetails(contarBoton(view));
        }
    }
    // Método que define la cantidad de elementos del RecyclerView
    // Puede ser más complejo (por ejem, si implementamos filtros o búsquedas)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void toggleDetails(int i) {
        linearLayoutDetails=lldS.get(i);
        imageViewExpand=ivs.get(i);
        if (linearLayoutDetails.getVisibility() == View.GONE) {
            ExpandAndCollapseViewUtil.expand(linearLayoutDetails, DURATION);
            imageViewExpand.setImageResource(R.mipmap.more);
            rotate(-180.0f);
        } else {
            ExpandAndCollapseViewUtil.collapse(linearLayoutDetails, DURATION);
            imageViewExpand.setImageResource(R.mipmap.less);
            rotate(180.0f);
        }
    }

    private void rotate(float angle) {
        Animation animation = new RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(DURATION);
        imageViewExpand.startAnimation(animation);
    }
    private int contarBoton(View view){
        int posicion=0;
        for (ImageButton imageButon:ibs) {
            if (imageButon==view){
                break;
            }
            posicion++;
        }
        return posicion;
    }
}
