package com.example.proyectolomb.classes.entities;

import java.time.LocalDate;
import java.util.Date;

public class Libro {
    private String ISBN;
    private String nombre;
    private Date fechaPublicacion;
    //private Idioma idioma;
    //private Editorial editorial;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Libro(String ISBN, String nombre, Date fechaPublicacion) {
        this.ISBN = ISBN;
        this.nombre = nombre;
        this.fechaPublicacion = fechaPublicacion;
    }
}
