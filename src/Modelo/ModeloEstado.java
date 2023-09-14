package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ModeloEstado {

    private int idEstado;
    private String Estado;

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return this.Estado;
    }

    public Vector<ModeloEstado> MostrarEstado() {
        PreparedStatement ps;
        ResultSet rs;

        Vector<ModeloEstado> VectorEstado = new Vector<ModeloEstado>();
        ModeloEstado Estados;

        try {
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("SELECT * FROM Estado");
            rs = ps.executeQuery();

            Estados = new ModeloEstado();

            while (rs.next()) {
                Estados = new ModeloEstado();
                Estados.setIdEstado(rs.getInt("idEstado"));
                Estados.setEstado(rs.getString("Estado"));
                VectorEstado.add(Estados);
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        
        return VectorEstado;
    }
}
