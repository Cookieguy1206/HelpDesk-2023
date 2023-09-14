package Modelo;

public class ModeloPersona {

    private int idPersona;
    public String CorreoPersona;

    public ModeloPersona() {
    }

    public ModeloPersona(int idPersona, String CorreoPersona) {
        this.idPersona = idPersona;
        this.CorreoPersona = CorreoPersona;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getCorreoPersona() {
        return CorreoPersona;
    }

    public void setCorreoPersona(String CorreoPersona) {
        this.CorreoPersona = CorreoPersona;
    }

}
