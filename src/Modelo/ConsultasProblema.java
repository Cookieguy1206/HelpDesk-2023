package Modelo;

import Conexion.*;
import Controlador.*;
import Vista.*;
//import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import java.io.IOException;
import java.sql.*;
import java.util.logging.*;
import javax.mail.MessagingException;
import javax.mail.Message;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ConsultasProblema {

    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    AñadirProblema AñadirProblema = new AñadirProblema();
    VerProblema VistaProblema = new VerProblema();
    VistaTicket VistaTicket = new VistaTicket();
    VistaAvances VistaAvances = new VistaAvances();
    ControladorRecibirEmail RecibirEmail = new ControladorRecibirEmail();
    ModeloCorreo ModeloCorreo = new ModeloCorreo();
    ControladorProblema Problema;
    Conexion con = new Conexion();
    Connection conexion;

    public ConsultasProblema() throws SQLException, MessagingException {
        this.conexion = con.getConnection();
    }

    //Funcion para insertar el porblema en la BD
    public boolean Categorizar(ModeloProblema Modelo, AñadirProblema AñadirProblema) {
        try {
            ps = conexion.prepareStatement("UPDATE Problema SET NombreProb = ?, "
                    + "DetalleProb = ?, "
                    + "RefIdPrioridad = ?, "
                    + "RefAreaProb = ?, "
                    + "RefTipoProb = ?, "
                    + "RefEstado = ? "
                    + "WHERE (idProblema = ? )");

            ps.setString(1, Modelo.getNombreProb());
            ps.setString(2, Modelo.getDetalleProb());
            ps.setInt(3, Modelo.getRefIdPrioridad());
            ps.setInt(4, Modelo.getRefAreaProb());
            ps.setInt(5, Modelo.getRefTipoProb());
            ps.setInt(6, Modelo.getRefEstado());
            ps.setString(7, AñadirProblema.TxtID.getText());

            System.out.println(ps);

            int Resultado = ps.executeUpdate();
            return Resultado > 0;

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
            return false;
        }
    }

    //Funcion para mostrar datos en el JTable
    public void Mostrar(JTable TablaProblema) {
        DefaultTableModel ModeloTabla = new DefaultTableModel();
        TablaProblema.setModel(ModeloTabla);
        TablaProblema.setRowHeight(20);

        TablaProblema.setDefaultRenderer(Object.class, new RenderTabla());

        try {
            ps = conexion.prepareStatement("SELECT * FROM TablaProblema");
            rs = ps.executeQuery();
            System.out.println(ps);

            ModeloTabla.addColumn("Tiket");
            ModeloTabla.addColumn("Correo");
            ModeloTabla.addColumn("Nombre");
            ModeloTabla.addColumn("Detalle");
            ModeloTabla.addColumn("Fecha De Creación");
            ModeloTabla.addColumn("Area");
            ModeloTabla.addColumn("Estado");
            ModeloTabla.addColumn("Solucion");
            ModeloTabla.addColumn("Imagen");

            ResultSetMetaData rsMD = rs.getMetaData();
            int CantidadColumnas = rsMD.getColumnCount();

            while (rs.next()) {
                Object fila[] = new Object[CantidadColumnas];
                
                for (int i = 0; i < CantidadColumnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }

                ModeloTabla.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error" + e);
        }
    }

    //Funcion para mostrar datos en el JTable
    public void MostrarAvances(JTable TablaAvances, VistaAvances VistaAvances) {
        DefaultTableModel ModeloTabla = new DefaultTableModel();
        TablaAvances.setModel(ModeloTabla);

        try {
            ps = conexion.prepareStatement("SELECT * FROM TablaAvances WHERE idProblema = " + VistaAvances.TxtIDAvance.getText() + " ORDER BY idAvances ASC");
            rs = ps.executeQuery();

            ModeloTabla.addColumn("idAvance");
            ModeloTabla.addColumn("idProblema");
            ModeloTabla.addColumn("Avance");
            ModeloTabla.addColumn("Fecha De Avance");
            ModeloTabla.addColumn("Estado");

            ResultSetMetaData rsMD = rs.getMetaData();
            int CantidadColumnas = rsMD.getColumnCount();

            while (rs.next()) {
                Object fila[] = new Object[CantidadColumnas];

                for (int i = 0; i < CantidadColumnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }

                ModeloTabla.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error" + e);
        }
    }

    //Modificar
    public boolean CambiarEstado(ModeloProblema Modelo, VistaTicket VistaTicket) {
        try {
            ps = conexion.prepareStatement("UPDATE Problema SET RefEstado = ?  WHERE idProblema = " + VistaTicket.TxtIDTicket.getText() + "");

            ps.setInt(1, Modelo.getRefEstado());

            int Resultado = ps.executeUpdate();
            System.out.println("Modificado Exitoso:");
            System.out.println(ps);

            if (Resultado > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
            return false;
        }
    }

    //Insertar la solucion
    public boolean InsertarSolucion(ModeloSolucion ModeloS, VistaTicket VistaTicket, ModeloProblema Modelo) {
        try {
            ps = conexion.prepareStatement("UPDATE Soluciones SET Solucion = ? WHERE idSolucion = " + VistaTicket.TxtIDSolucion.getText() + "");
            ps.setString(1, ModeloS.getSolucion());

            System.out.println("\nModificado Exitoso:");
            System.out.println(ps);

            int Resultado = ps.executeUpdate();
            return Resultado > 0;

        } catch (SQLException ex) {
            System.out.println("Error" + ex);
            return false;
        }
    }

    //Insertar Avance
    public boolean InsertarAvance(ModeloAvances ModeloA, VistaTicket VistaTicket, ModeloProblema Modelo) {
        try {
            ps = conexion.prepareStatement("UPDATE Avances SET Avance = ? WHERE idAvances = " + VistaTicket.TxtIDAvance.getText() + "");
            ps.setString(1, VistaTicket.TxtAvance.getText());

            System.out.println("\nModificado Exitoso:");
            System.out.println(ps);

            int Resultado = ps.executeUpdate();
            return Resultado > 0;

        } catch (SQLException ex) {
            System.out.println("Error" + ex);
            return false;
        }
    }

    //Listar Avances
    public boolean ListarAvances(ModeloAvances ModeloA, VistaTicket VistaTicket, ModeloProblema Modelo) {
        try {
            int idAvances = con.AutoIncrementA() + 2;
            int idAvancesS = idAvances;
            int idEstado = VistaTicket.JCEstadoTicket.getSelectedIndex();
            ps = conexion.prepareStatement("INSERT INTO Avances (idAvances, Avance, idAvanceProb, FechaAvance, RefEstado) "
                    + "\nSELECT * FROM (SELECT " + idAvances + "," + "?" + "," + "?" + "," + "CURRENT_TIMESTAMP" + "," + idEstado + ") AS TMP "
                    + "\nWHERE NOT EXISTS(SELECT idAvances FROM Avances WHERE idAvances = " + idAvancesS + ") "
                    + "\nLIMIT 1");
            ps.setString(1, VistaTicket.TxtAvance.getText());
            ps.setString(2, VistaTicket.TxtIDAvance.getText());

            System.out.println("\nModificado Exitoso:");
            System.out.println(ps);

            int Resultado = ps.executeUpdate();
            return Resultado > 0;

        } catch (SQLException ex) {
            System.out.println("Error" + ex);
            return false;
        }
    }

    //Busca si hay algún registro repetido en la BD
    public int BuscaRepetido(Message msg) throws SQLException {
        try {
            ps = conexion.prepareStatement("SELECT count(idPersona) FROM Persona WHERE idPersona = " + msg.getMessageNumber()
                    + "");

            rs = ps.executeQuery();
            System.out.println(ps);

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 1;

        } catch (SQLException ex) {
            System.out.println("Error " + ex);
            return 1;
        }
    }

    //Generar reporte
    public void GenerarReportePen() {
        try {
            JasperReport Reporte = null;

            String Path = "src\\Vista\\ReportePendientes.jasper";

            Reporte = (JasperReport) JRLoader.loadObjectFromFile(Path);

            JasperPrint JPrint = JasperFillManager.fillReport(Reporte, null, conexion);

            JasperViewer view = new JasperViewer(JPrint, false);

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            view.setVisible(true);

        } catch (JRException ex) {
            System.out.println("Error " + ex);
        }
    }

    //Generar reporte
    public void GenerarReporteProc() {
        try {
            JasperReport Reporte = null;

            String Path = "src\\Vista\\ReporteProcesos.jasper";

            Reporte = (JasperReport) JRLoader.loadObjectFromFile(Path);

            JasperPrint JPrint = JasperFillManager.fillReport(Reporte, null, conexion);

            JasperViewer view = new JasperViewer(JPrint, false);

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            view.setVisible(true);

        } catch (JRException ex) {
            System.out.println("Error " + ex);
        }
    }

    //Generar reporte
    public void GenerarReporteSol() {
        try {
            JasperReport Reporte = null;

            String Path = "src\\Vista\\ReporteSoluciones.jasper";

            Reporte = (JasperReport) JRLoader.loadObjectFromFile(Path);

            JasperPrint JPrint = JasperFillManager.fillReport(Reporte, null, conexion);

            JasperViewer view = new JasperViewer(JPrint, false);

            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            view.setVisible(true);

        } catch (JRException ex) {
            System.out.println("Error " + ex);
        }
    }

    //Actualizar correos
    public void ActualizarEmail() {
        System.out.println("Insertando...");
        try {
            RecibirEmail.RecibirEmail();
            Mostrar(VistaProblema.JTablaProblema);
        } catch (javax.mail.MessagingException | IOException | SQLException /*com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException*/ ex) {
            Logger.getLogger(ControladorRecibirEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Apariencia para la interfaz gráfica
    public void Estetica() {
        //Diseño para que se vea más bonita la vista
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AñadirProblema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
