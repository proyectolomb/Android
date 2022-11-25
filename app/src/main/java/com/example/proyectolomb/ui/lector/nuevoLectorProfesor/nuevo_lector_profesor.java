package com.example.proyectolomb.ui.lector.nuevoLectorProfesor;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectolomb.R;

public class nuevo_lector_profesor extends Fragment {

    private NuevoLectorProfesorViewModel mViewModel;

    public static nuevo_lector_profesor newInstance() {
        return new nuevo_lector_profesor();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nuevo_lector_profesor, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NuevoLectorProfesorViewModel.class);
        // TODO: Use the ViewModel
    }

}