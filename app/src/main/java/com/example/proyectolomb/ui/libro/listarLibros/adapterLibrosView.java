package com.example.proyectolomb.ui.libro.listarLibros;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectolomb.ExpandAndCollapseViewUtil;
import com.example.proyectolomb.R;
import com.example.proyectolomb.classes.entities.Libro;
import com.example.proyectolomb.ui.libro.modificar_libro;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class adapterLibrosView extends RecyclerView.Adapter<adapterLibrosView.VistaHolder> implements View.OnClickListener {

    private ArrayList<Libro> mDataSet;
    private ViewGroup linearLayoutDetails;
    private static final int DURATION = 250;
    private ImageView imageViewExpand;
    private ExpandableListView expListView;
    private ArrayList<ViewGroup> linearlayouts =new ArrayList<ViewGroup>();
    private ArrayList<ImageView> imageExpands =new ArrayList<ImageView>();
    private ArrayList<ImageButton> imageBotonesExpandir =new ArrayList<ImageButton>();
    private ArrayList<Button> botonesEliminar =new ArrayList<Button>();
    private ArrayList<Button> botonesModificar =new ArrayList<Button>();




    // Obtener referencias de los componentes visuales para cada elemento
    // Es decir, referencias de los EditText, TextViews, Buttons
    public static class VistaHolder extends RecyclerView.ViewHolder {
        // en este ejemplo cada elemento consta solo de un título
        private ViewGroup linearLayoutDetails;
        private ImageView imageViewExpand;
        TextView tituloCabecera;
        TextView ISBN;
        TextView autor;
        TextView categoria;
        TextView editorial;
        TextView fecha;
        TextView idioma;
        Button botonEliminar;
        Button botonModificar;
        ImageButton expandir;


        public VistaHolder(View v) {
            super(v);
            tituloCabecera= v.findViewById(R.id.presentacionTitulo);
            ISBN = v.findViewById(R.id.contenidoISBN);
            autor= v.findViewById(R.id.contenidoAutor);
            categoria=v.findViewById(R.id.contenidoCategoria);
            editorial=v.findViewById(R.id.contenidoEditorial);
            fecha = v.findViewById(R.id.contenidoFechaPubli);
            idioma=v.findViewById(R.id.contenidoIdioma);

            botonEliminar =  v.findViewById(R.id.btnEliminar_item_libro);
            botonModificar =  v.findViewById(R.id.btnModificar_item_libro);
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
        holder.autor.setText(libro.getAutor().isEmpty() ? "Autor: " :  "Autor: "+libro.getAutor());
        holder.categoria.setText(libro.getCategoria().isEmpty() ? "Categoria: " :  "Categoria: "+libro.getCategoria());
        holder.editorial.setText(libro.getEditorial().isEmpty() ? "Editorial: " :  "Editorial: "+libro.getEditorial());
        holder.fecha.setText(libro.getFechaPublicacion().toString().isEmpty() ? "Fecha: " :  "Fecha: "+libro.getFechaPublicacion().toString());
        holder.idioma.setText(libro.getIdioma().isEmpty() ? "Idioma: " :  "Idioma: "+libro.getIdioma());

        holder.botonEliminar.setText("Eliminar");
        holder.botonEliminar.setOnClickListener(this);
        holder.botonModificar.setText("Modificar");
        holder.botonModificar.setOnClickListener(this);


        //Listas dinamicas
        linearlayouts.add(holder.linearLayoutDetails);
        imageExpands.add(holder.imageViewExpand);
        imageBotonesExpandir.add(holder.expandir);
        botonesEliminar.add(holder.botonEliminar);
        botonesModificar.add(holder.botonModificar);

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
        if(view.getId()==R.id.imageViewExpand) {
            toggleDetails(contarBotonExpandir(view));
        }else if(view.getId()==R.id.btnEliminar_item_libro){
            Snackbar.make(view, "Eliminar por implementar", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
        else if(view.getId()==R.id.btnModificar_item_libro){
            Snackbar.make(view, "Modificar por implementar", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            //crearModificarLibro(añadirElementoModificarLibros(contarBotonModificar(view)));
        }
    }

    // Método que define la cantidad de elementos del RecyclerView
    // Puede ser más complejo (por ejem, si implementamos filtros o búsquedas)
    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void toggleDetails(int i) {
        linearLayoutDetails= linearlayouts.get(i);
        imageViewExpand= imageExpands.get(i);
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
    private int contarBotonExpandir(View view){
        int posicion=0;
        for (ImageButton imageButon: imageBotonesExpandir) {
            if (imageButon==view){
                break;
            }
            posicion++;
        }
        return posicion;
    }
    private int contarBotonEliminar(View view){
        int posicion=0;
        for (Button buton: botonesEliminar) {
            if (buton==view){
                break;
            }
            posicion++;
        }
        return posicion;
    }
    private int contarBotonModificar(View view){
        int posicion=0;
        for (Button buton: botonesModificar) {
            if (buton==view){
                break;
            }
            posicion++;
        }
        return posicion;
    }
    private Fragment añadirElementoModificarLibros(int i){
        Fragment fragment=new modificar_libro();
        View view=fragment.getView();
        Libro libro=mDataSet.get(i);

        EditText ISBN = view.findViewById(R.id.txtbox_ISBN_modificar);
        ISBN.setText(libro.getISBN());
        EditText titulo= view.findViewById(R.id.txtbox_nombre_modificar);
        titulo.setText(libro.getNombre());
        EditText autor= view.findViewById(R.id.txtbox_autor_modificar);
        autor.setText(libro.getAutor());
        EditText categoria=view.findViewById(R.id.txtbox_categoria_modificar);
        categoria.setText(libro.getCategoria());
        EditText editorial=view.findViewById(R.id.txtbox_editorial_modificar);
        editorial.setText(libro.getEditorial());
        EditText fecha = view.findViewById(R.id.txtbox_fecha_publi_modificar);
        fecha.setText(libro.getFechaPublicacion().toString());
        EditText idioma=view.findViewById(R.id.txtbox_idioma_modificar);
        idioma.setText(libro.getIdioma());

        return fragment;
    }
    private void crearModificarLibro(Fragment fragment) {

        //FragmentManager fragmentManager = fragment.getParentFragmentManager();
        //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.replace(R.id.nav_host_fragment_content_principal, fragment);
        //fragmentTransaction.addToBackStack(null);
        //fragmentTransaction.commit();
    }
}
