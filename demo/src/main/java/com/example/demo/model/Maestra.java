package com.example.demo.model;

import java.time.LocalDate;

public class Maestra {
    private int idSabana;
    private String nombre;
    private LocalDate fecha;
    private String comentario;

    public int getIdsabana() {
        return idSabana;
    }

    public void setIdSabana(int idSabana) {
        this.idSabana = idSabana;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}

