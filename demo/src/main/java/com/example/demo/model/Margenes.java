package com.example.demo.model;

import java.math.BigDecimal;

public class Margenes {
    private int idMargen;
    private int idSabana;
    private int idTipoMargen;
    private BigDecimal margen;

    public int getIdMargen() {
        return idMargen;
    }

    public void setIdMargen(int idMargen) {
        this.idMargen = idMargen;
    }

    public int getIdSabana() {
        return idSabana;
    }

    public void setIdSabana(int idSabana) {
        this.idSabana = idSabana;
    }

    public int getIdTipoMargen() {
        return idTipoMargen;
    }

    public void setIdTipoMargen(int idTipoMargen) {
        this.idTipoMargen = idTipoMargen;
    }

    public BigDecimal getMargen() {
        return margen;
    }

    public void setMargen(BigDecimal margen) {
        this.margen = margen;
    }

}
