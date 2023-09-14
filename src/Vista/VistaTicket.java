package Vista;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VistaTicket extends javax.swing.JFrame {

    PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();
    Connection conexion = con.getConnection();

    public VistaTicket() throws SQLException {
        initComponents();
        CargarEstado();
        CargarArea();
    }

    //Mostrar TipoDeProblema de la BD en JComboBox
    public void CargarEstado() throws SQLException {
        try {
            ps = conexion.prepareStatement("SELECT * FROM Estado");
            rs = ps.executeQuery();

            while (rs.next()) {
                JCEstadoTicket.addItem(rs.getString("Estado"));
            }

            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }

    //Mostrar Area de la BD en JComboBox
    public void CargarArea() throws SQLException {
        try {
            ps = conexion.prepareStatement("SELECT * FROM AreaProb");
            rs = ps.executeQuery();

            while (rs.next()) {
                JCAreaTicket.addItem(rs.getString("AreaProb"));
            }

            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        PanelTicket = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        TxtIDTicket = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TxtCorreoTicket = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        BtnVolver = new javax.swing.JButton();
        JCEstadoTicket = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtDescripcion = new javax.swing.JTextPane();
        BtnGuardar = new javax.swing.JButton();
        JCAreaTicket = new javax.swing.JComboBox<>();
        txtTitulo = new javax.swing.JTextField();
        BtnVerImagen = new javax.swing.JButton();
        TxtRutaImagen = new javax.swing.JTextField();
        PanelSolucion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtSolucion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        TxtIDSolucion = new javax.swing.JTextField();
        TxtIDAvance = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TxtAvance = new javax.swing.JTextArea();
        JMenuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setText("ID Ticket");

        TxtIDTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIDTicketActionPerformed(evt);
            }
        });

        jLabel7.setText("Correo");

        jLabel8.setText("Area");

        BtnVolver.setText("Atras");

        jLabel9.setText("Estado");

        jLabel10.setText("Descripcion y titulo del problema");

        jScrollPane2.setViewportView(TxtDescripcion);

        BtnGuardar.setText("Guardar");

        BtnVerImagen.setText("Ver Imagen");

        javax.swing.GroupLayout PanelTicketLayout = new javax.swing.GroupLayout(PanelTicket);
        PanelTicket.setLayout(PanelTicketLayout);
        PanelTicketLayout.setHorizontalGroup(
            PanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTicketLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(PanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTicketLayout.createSequentialGroup()
                        .addGroup(PanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(PanelTicketLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(PanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(PanelTicketLayout.createSequentialGroup()
                                        .addGroup(PanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(TxtCorreoTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(103, 103, 103)
                                        .addGroup(PanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(JCAreaTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(PanelTicketLayout.createSequentialGroup()
                                        .addComponent(TxtRutaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BtnVerImagen)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BtnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BtnGuardar)))))
                        .addGap(79, 79, 79))
                    .addGroup(PanelTicketLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtIDTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTicketLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTicketLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(278, 278, 278))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTicketLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCEstadoTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193))))
        );
        PanelTicketLayout.setVerticalGroup(
            PanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTicketLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtIDTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(29, 29, 29)
                .addGroup(PanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGroup(PanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTicketLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(TxtCorreoTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelTicketLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCAreaTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addGroup(PanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCEstadoTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(41, 41, 41)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnVolver)
                    .addComponent(BtnGuardar)
                    .addComponent(BtnVerImagen)
                    .addComponent(TxtRutaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ticket", PanelTicket);

        TxtSolucion.setColumns(20);
        TxtSolucion.setRows(5);
        jScrollPane1.setViewportView(TxtSolucion);

        jLabel1.setText("Solucion");

        jLabel4.setText("Avance");

        TxtAvance.setColumns(20);
        TxtAvance.setRows(5);
        jScrollPane3.setViewportView(TxtAvance);

        javax.swing.GroupLayout PanelSolucionLayout = new javax.swing.GroupLayout(PanelSolucion);
        PanelSolucion.setLayout(PanelSolucionLayout);
        PanelSolucionLayout.setHorizontalGroup(
            PanelSolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSolucionLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(PanelSolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSolucionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(TxtIDAvance, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(TxtIDSolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSolucionLayout.setVerticalGroup(
            PanelSolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSolucionLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelSolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtIDSolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtIDAvance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Solucion", PanelSolucion);

        setJMenuBar(JMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtIDTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIDTicketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIDTicketActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            try {
                new VistaTicket().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(VistaTicket.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnGuardar;
    public javax.swing.JButton BtnVerImagen;
    public javax.swing.JButton BtnVolver;
    public javax.swing.JComboBox<String> JCAreaTicket;
    public javax.swing.JComboBox<String> JCEstadoTicket;
    public javax.swing.JMenuBar JMenuBar;
    private javax.swing.JPanel PanelSolucion;
    private javax.swing.JPanel PanelTicket;
    public javax.swing.JTextArea TxtAvance;
    public javax.swing.JTextField TxtCorreoTicket;
    public javax.swing.JTextPane TxtDescripcion;
    public javax.swing.JTextField TxtIDAvance;
    public javax.swing.JTextField TxtIDSolucion;
    public javax.swing.JTextField TxtIDTicket;
    public javax.swing.JTextField TxtRutaImagen;
    public javax.swing.JTextArea TxtSolucion;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
