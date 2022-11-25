package com.example.proyectolomb.ui.libro.listarLibros;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectolomb.R;
import com.example.proyectolomb.classes.entities.Libro;
import com.example.proyectolomb.databinding.FragmentListarLibrosBinding;

import java.util.ArrayList;
import java.util.Date;

public class listar_libro extends Fragment {
    private FragmentListarLibrosBinding binding;
    private RecyclerView mRecyclerView;
    // esto es para mostrar lo de las listas
    private adapterLibrosView adapterLibrosView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        /*HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);*/


        binding = FragmentListarLibrosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mRecyclerView=root.findViewById(R.id.recyclerView);

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // RecyclerView imageView = (RecyclerView) getView().findViewById(R.id.recyclerView);

        // Esto no es necesario se puede eliminar pero mejora el rendimiento.


        // Nuestro RecyclerView usará un linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        // Asociamos un adapter (ver más adelante cómo definirlo)

        ArrayList<Libro> listaLibros = new ArrayList<>();

        Date hoy = new Date();

        Libro libro = new Libro("1","El Quijote",hoy);
        listaLibros.add(libro);
         libro = new Libro("1","El principito",hoy);
        listaLibros.add(libro);
       libro = new Libro("1","El manifiesto comunista",hoy);
        listaLibros.add(libro);

        adapterLibrosView = new adapterLibrosView(listaLibros);
        mRecyclerView.setAdapter(adapterLibrosView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}