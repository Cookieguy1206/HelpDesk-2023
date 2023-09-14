package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ModeloArea {

    private int idAreaProb;
    private String AreaProb;

    public int getIdAreaProb() {
        return idAreaProb;
    }

    public void setIdAreaProb(int idAreaProb) {
        this.idAreaProb = idAreaProb;
    }

    public String getAreaProb() {
        return AreaProb;
    }

    public void setAreaProb(String AreaProb) {
        this.AreaProb = AreaProb;
    }

    public String toString() {
        return this.AreaProb;
    }

    public Vector<ModeloArea> MostrarArea() {
        PreparedStatement ps;
        ResultSet rs;

        Vector<ModeloArea> VectorArea = new Vector<ModeloArea>();
        ModeloArea Area;

        try {
            Conexion con = new Conexion();
            Connection conexion = con.getConnection();

            ps = conexion.prepareStatement("SELECT * FROM AreaProb");
            rs = ps.executeQuery();

            Area = new ModeloArea();

            while (rs.next()) {
                Area = new ModeloArea();
                Area.setIdAreaProb(rs.getInt("idAreaProb"));
                Area.setAreaProb(rs.getString("AreaProb"));
                VectorArea.add(Area);
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }

        return VectorArea;
    }
}
