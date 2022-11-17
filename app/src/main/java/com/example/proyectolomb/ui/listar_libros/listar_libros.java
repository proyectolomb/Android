package com.example.proyectolomb.ui.listar_libros;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectolomb.MyAdapter;
import com.example.proyectolomb.databinding.FragmentListarLibrosBinding;
import com.example.proyectolomb.ui.home.HomeViewModel;

public class listar_libros extends Fragment {
    private static final String[] myDataSet = {
            "PHP",
            "Javascript",
            "Go",
            "Python"};
    private FragmentListarLibrosBinding binding;
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentListarLibrosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}