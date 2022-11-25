package com.example.proyectolomb.ui.autor.nuevoAutorPersona;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectolomb.R;

public class nuevo_autor_persona extends Fragment {

    private NuevoAutorPersonaViewModel mViewModel;

    public static nuevo_autor_persona newInstance() {
        return new nuevo_autor_persona();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nuevo_autor_persona, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NuevoAutorPersonaViewModel.class);
        // TODO: Use the ViewModel
    }

}