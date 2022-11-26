package com.example.proyectolomb.classes.entities;

import java.time.LocalDate;
import java.util.Date;

public class Libro {
    private String ISBN;
    private String nombre;
    private String autor;
    private String categoria;
    private String editorial;
    private Date fechaPublicacion;
    private String idioma;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

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

    public Libro(String ISBN, String nombre, String autor, String categoria, String editorial, Date fechaPublicacion, String idioma) {
        this.ISBN = ISBN;
        this.nombre = nombre;
        this.autor = autor;
        this.categoria = categoria;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
        this.idioma = idioma;
    }
}
