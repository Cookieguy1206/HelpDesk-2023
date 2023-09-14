package Modelo;

import java.sql.Date;

public class ModeloAvances {

    private int idAvances;
    private int idAvanceProb;
    private String Avance;
    private Date FechaAvance;
    private int RefEstado;

    public ModeloAvances() {
    }

    public ModeloAvances(int idAvances, int idAvanceProb, String Avance, Date FechaAvance, int RefEstado) {
        this.idAvances = idAvances;
        this.idAvanceProb = idAvanceProb;
        this.Avance = Avance;
        this.FechaAvance = FechaAvance;
        this.RefEstado = RefEstado;
    }

    public int getIdAvances() {
        return idAvances;
    }

    public void setIdAvances(int idAvances) {
        this.idAvances = idAvances;
    }

    public int getIdAvanceProb() {
        return idAvanceProb;
    }

    public void setIdAvanceProb(int idAvanceProb) {
        this.idAvanceProb = idAvanceProb;
    }

    public String getAvance() {
        return Avance;
    }

    public void setAvance(String Avance) {
        this.Avance = Avance;
    }

    public Date getFechaAvance() {
        return FechaAvance;
    }

    public void setFechaAvance(Date FechaAvance) {
        this.FechaAvance = FechaAvance;
    }

    public int getRefEstado() {
        return RefEstado;
    }

    public void setRefEstado(int RefEstado) {
        this.RefEstado = RefEstado;
    }

}
