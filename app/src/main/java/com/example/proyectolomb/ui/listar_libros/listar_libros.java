package com.example.proyectolomb.ui.listar_libros;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectolomb.MyAdapter;
import com.example.proyectolomb.classes.entities.Libro;
import com.example.proyectolomb.databinding.FragmentListarLibrosBinding;
import com.example.proyectolomb.ui.home.HomeViewModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class listar_libros extends Fragment {
    private static final String[] myDataSet = {
            "PHP",
            "Javascript",
            "Go",
            "Python"};
    private FragmentListarLibrosBinding binding;
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    // esto es para mostrar lo de las listas
    private adapterEquipos  adapterEquipos;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentListarLibrosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

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

        ArrayList<Libro> listaEquipos = new ArrayList<>();

        Date hoy = new Date();

        Libro equipo = new Libro("1","2",hoy);
        listaEquipos.add(equipo);
         equipo = new Libro("1","3",hoy);
        listaEquipos.add(equipo);
       equipo = new Libro("1","4",hoy);
        listaEquipos.add(equipo);

        listaEquipos.add(equipo);
        adapterEquipos = new adapterEquipos(listaEquipos);
        mRecyclerView.setAdapter(adapterEquipos);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}