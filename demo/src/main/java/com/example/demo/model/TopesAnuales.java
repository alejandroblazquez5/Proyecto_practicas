package com.example.demo.model;

import java.math.BigDecimal;

public class TopesAnuales {
    private int idTopeAnual;
    private int idTopes;
    private int anos;
    private BigDecimal coste;
    private BigDecimal pvp;
    private int gp;
    private int gpPct;

    public int getIdTopeAnual() { 
        return idTopeAnual; 
    }

    public void setIdTopeAnual(int idTopeAnual) { 
        this.idTopeAnual = idTopeAnual; 
    }

    public int getIdTopes() { 
        return idTopes; 
    }

    public void setIdTopes(int idTopes) {
        this.idTopes = idTopes; 
    }

    public int getAnos() {
        return anos; 
    }

    public void setAnos(int anos) {
        this.anos = anos;
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
