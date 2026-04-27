package com.example.demo.model;

import java.math.BigDecimal;

public class MargenesAnuales {
    private int idMargenAnual;
    private int idMargen;
    private int ano;
    private BigDecimal coste;
    private BigDecimal pvp;
    private int gp;
    private int gpPct;

    public int getIdMargenAnual() { 
        return idMargenAnual; 
    }

    public void setIdMargenAnual(int idMargenAnual) {
        this.idMargenAnual = idMargenAnual; 
    }

    public int getIdMargen() {
        return idMargen; 
    }

    public void setIdMargen(int idMargen) {
        this.idMargen = idMargen; 
    }

    public int getAno() {
        return ano; 
    }

    public void setAno(int ano) { 
        this.ano = ano; 
    }

    public BigDecimal getCoste() {
        return coste; 
    }

    public void setCoste(BigDecimal coste) {
        this.coste = coste; 
    }

    public BigDecimal getPvp() {
        return pvp; 
    }

    public void setPvp(BigDecimal pvp) {
        this.pvp = pvp; 
    }

    public int getGp() {
        return gp; 
    }

    public void setGp(int gp) {
        this.gp = gp; 
    }

    public int getGpPct() {
        return gpPct; 
    }

    public void setGpPct(int gpPct) {
        this.gpPct = gpPct; 
    }

}
