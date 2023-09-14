package Modelo;

import java.sql.Date;

public class ModeloProblema {

    private int idProblema;
    private String NombreProb;
    private String DetalleProb;
    private Date FechaCreacion;
    private int RefIdPrioridad;
    private int RefAreaProb;
    private int RefTipoProb;
    private int RefSTipoProb;
    private int RefSSTipoProb;
    private int RefEstado;
    private int RefPersona;
    private int RefSolucion;
    private int RefAvances;

    public ModeloProblema() {
    }

    public ModeloProblema(int idProblema, String NombreProb, String DetalleProb, Date FechaCreacion, int RefIdPrioridad, int RefAreaProb, int RefTipoProb, int RefSTipoProb, int RefSSTipoProb, int RefEstado, int RefPersona, int RefSolucion, int RefAvances) {
        this.idProblema = idProblema;
        this.NombreProb = NombreProb;
        this.DetalleProb = DetalleProb;
        this.FechaCreacion = FechaCreacion;
        this.RefIdPrioridad = RefIdPrioridad;
        this.RefAreaProb = RefAreaProb;
        this.RefTipoProb = RefTipoProb;
        this.RefSTipoProb = RefSTipoProb;
        this.RefSSTipoProb = RefSSTipoProb;
        this.RefEstado = RefEstado;
        this.RefPersona = RefPersona;
        this.RefSolucion = RefSolucion;
        this.RefAvances = RefAvances;
    }
    
    public int getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(int idProblema) {
        this.idProblema = idProblema;
    }

    public String getNombreProb() {
        return NombreProb;
    }

    public void setNombreProb(String NombreProb) {
        this.NombreProb = NombreProb;
    }

    public String getDetalleProb() {
        return DetalleProb;
    }

    public void setDetalleProb(String DetalleProb) {
        this.DetalleProb = DetalleProb;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public int getRefIdPrioridad() {
        return RefIdPrioridad;
    }

    public void setRefIdPrioridad(int RefIdPrioridad) {
        this.RefIdPrioridad = RefIdPrioridad;
    }

    public int getRefAreaProb() {
        return RefAreaProb;
    }

    public void setRefAreaProb(int RefAreaProb) {
        this.RefAreaProb = RefAreaProb;
    }

    public int getRefTipoProb() {
        return RefTipoProb;
    }

    public void setRefTipoProb(int RefTipoProb) {
        this.RefTipoProb = RefTipoProb;
    }

    public int getRefSTipoProb() {
        return RefSTipoProb;
    }

    public void setRefSTipoProb(int RefSTipoProb) {
        this.RefSTipoProb = RefSTipoProb;
    }

    public int getRefSSTipoProb() {
        return RefSSTipoProb;
    }

    public void setRefSSTipoProb(int RefSSTipoProb) {
        this.RefSSTipoProb = RefSSTipoProb;
    }

    public int getRefEstado() {
        return RefEstado;
    }

    public void setRefEstado(int RefEstado) {
        this.RefEstado = RefEstado;
    }

    public int getRefPersona() {
        return RefPersona;
    }

    public void setRefPersona(int RefPersona) {
        this.RefPersona = RefPersona;
    }

    public int getRefSolucion() {
        return RefSolucion;
    }

    public void setRefSolucion(int RefSolucion) {
        this.RefSolucion = RefSolucion;
    }

    public int getRefAvances() {
        return RefAvances;
    }

    public void setRefAvances(int RefAvances) {
        this.RefAvances = RefAvances;
    }

}
