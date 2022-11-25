package com.example.proyectolomb.ui.encargado.nuevoEncargado;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectolomb.R;

public class nuevo_encargado extends Fragment {

    private NuevoEncargadoViewModel mViewModel;

    public static nuevo_encargado newInstance() {
        return new nuevo_encargado();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nuevo_encargado, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NuevoEncargadoViewModel.class);
        // TODO: Use the ViewModel
    }

}