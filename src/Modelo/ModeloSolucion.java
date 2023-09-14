package Modelo;

public class ModeloSolucion {

    private int idSolucion;
    private String Solucion;

    public ModeloSolucion() {
    }

    public ModeloSolucion(int idSolucion, String Solucion) {
        this.idSolucion = idSolucion;
        this.Solucion = Solucion;
    }

    public int getIdSolucion() {
        return idSolucion;
    }

    public void setIdSolucion(int idSolucion) {
        this.idSolucion = idSolucion;
    }

    public String getSolucion() {
        return Solucion;
    }

    public void setSolucion(String Solucion) {
        this.Solucion = Solucion;
    }

}
