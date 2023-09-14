package Vista;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AñadirProblema extends javax.swing.JFrame {

    PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();
    Connection conexion = con.getConnection();

    public AñadirProblema() throws SQLException {
        initComponents();
        CargarTipo();
        CargarSubTipo();
        CargarSubSubTipo();
        CargarArea();
        CargarPrioridad();
        System.out.println("Conexion Exitosa\n");
    }

    //Mostrar TipoDeProblema de la BD en JComboBox
    public void CargarTipo() throws SQLException {
        try {
            ps = conexion.prepareStatement("SELECT * FROM TipoProb");
            rs = ps.executeQuery();

            while (rs.next()) {
                JCTipoSolicitud.addItem(rs.getString("TipoProb"));
            }

            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }
    
        public void CargarSubTipo() throws SQLException {
        try {
            ps = conexion.prepareStatement("SELECT * FROM STipoProb");
            rs = ps.executeQuery();

            while (rs.next()) {
                JCSubTipoSol.addItem(rs.getString("STipoProb"));
            }

            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }
        
            public void CargarSubSubTipo() throws SQLException {
        try {
            ps = conexion.prepareStatement("SELECT * FROM SSTipoProb");
            rs = ps.executeQuery();

            while (rs.next()) {
                JCSubSubTipo.addItem(rs.getString("SSTipoProb"));
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
                JCArea.addItem(rs.getString("AreaProb"));
            }

            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }

    //Mostrar Prioridad de la BD en JComboBox
    public void CargarPrioridad() throws SQLException {
        try {
            ps = conexion.prepareStatement("SELECT * FROM Prioridad");
            rs = ps.executeQuery();

            while (rs.next()) {
                JCPrioridad.addItem(rs.getString("Prioridad"));
            }

            rs.close();

        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JCTipoSolicitud = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        TxtTituloSolicitud = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtDetalleSolicitud = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        JCPrioridad = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        JCArea = new javax.swing.JComboBox<>();
        BtnCategorizar = new javax.swing.JButton();
        BtnVerProb = new javax.swing.JButton();
        TxtID = new javax.swing.JTextField();
        TxtFecha = new javax.swing.JTextField();
        BtnVerAvan = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        TxtCorreo = new javax.swing.JTextField();
        JCSubTipoSol = new javax.swing.JComboBox<>();
        JCSubSubTipo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tipo de solicitud");

        jLabel2.setText("Titulo");

        jLabel3.setText("Detalle");

        jScrollPane2.setViewportView(TxtDetalleSolicitud);

        jLabel5.setText("Prioridad");

        JCPrioridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCPrioridadActionPerformed(evt);
            }
        });

        jLabel6.setText("Area");

        BtnCategorizar.setText("Categorizar");

        BtnVerProb.setText("Cancelar");

        BtnVerAvan.setText("Ver Avances");

        jLabel4.setText("Correo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JCPrioridad, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JCArea, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BtnCategorizar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnVerProb, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(BtnVerAvan, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(TxtCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TxtTituloSolicitud, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(JCSubTipoSol, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCSubSubTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JCTipoSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(TxtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JCTipoSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCSubTipoSol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCSubSubTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtTituloSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JCArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(BtnCategorizar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(JCPrioridad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnVerProb))
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnVerAvan)
                        .addGap(96, 96, 96))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCPrioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCPrioridadActionPerformed
        //int index = JCPrioridad.getSelectedIndex();
        //this.Index.setText(String.valueOf(index));
    }//GEN-LAST:event_JCPrioridadActionPerformed

    public static void main(String args[]) throws SQLException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new AñadirProblema().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AñadirProblema.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnCategorizar;
    public javax.swing.JButton BtnVerAvan;
    public javax.swing.JButton BtnVerProb;
    public javax.swing.JComboBox<String> JCArea;
    public javax.swing.JComboBox<String> JCPrioridad;
    public javax.swing.JComboBox<String> JCSubSubTipo;
    public javax.swing.JComboBox<String> JCSubTipoSol;
    public javax.swing.JComboBox<String> JCTipoSolicitud;
    public javax.swing.JTextField TxtCorreo;
    public javax.swing.JTextPane TxtDetalleSolicitud;
    public javax.swing.JTextField TxtFecha;
    public javax.swing.JTextField TxtID;
    public javax.swing.JTextField TxtTituloSolicitud;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
