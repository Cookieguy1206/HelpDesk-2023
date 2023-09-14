package Conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

    public static final String URL = "jdbc:mysql://localhost:3306/helpdesk?autoReconnect=true&useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "Cookie";
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    PreparedStatement ps;
    ResultSet rs;

    public Connection getConnection() throws SQLException {
        Connection conexion = null;

        try {
            Class.forName(DRIVER);
            conexion = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error" + ex);
        }

        return conexion;
    }

    public int AutoIncrement() {
        int id = 1;
        try {
            ps = getConnection().prepareStatement("SELECT MAX(idProblema) FROM Problema");
            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
        return id;
    }

    public int AutoIncrementI() {
        int id = 1;
        try {
            ps = getConnection().prepareStatement("SELECT MAX(idImagenes) FROM Imagenes");
            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
        return id;
    }

    public int AutoIncrementS() {
        int id = 1;
        try {
            ps = getConnection().prepareStatement("SELECT MAX(idSolucion) FROM Soluciones");
            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
        return id;
    }

    public int AutoIncrementA() {
        int id = 1;
        try {
            ps = getConnection().prepareStatement("SELECT MAX(idAvances) FROM Avances");
            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
        return id;
    }

    public int AutoIncrementP() {
        int id = 1;
        try {
            ps = getConnection().prepareStatement("SELECT MAX(idPersona) FROM Persona");
            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
        return id;
    }

    public int AutoIncrementRI() {
        int id = 1;
        try {
            ps = getConnection().prepareStatement("SELECT MAX(idProblema) FROM Problema");
            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
        return id;
    }
}
