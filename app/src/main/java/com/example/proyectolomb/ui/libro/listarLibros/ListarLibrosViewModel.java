package com.example.proyectolomb.ui.libro.listarLibros;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ListarLibrosViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public ListarLibrosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is ListarLibros fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}