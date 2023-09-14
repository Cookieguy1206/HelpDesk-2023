package Vista;

import Conexion.*;
import Modelo.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.mail.MessagingException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VerProblema extends javax.swing.JFrame {
    
    public VerProblema() throws SQLException, MessagingException {
        initComponents();
        String SQL = "SELECT * FROM Filtro";
        LlenarCombo(JCFiltro, SQL, 2);
    }

    ResultSet rs;
    Statement st;
    PreparedStatement ps;
    Conexion con = new Conexion();
    Connection conexion = con.getConnection();

    //Metodo para llenar los filtros y anidarlos
    public void LlenarCombo(JComboBox ComboBox, String SQL, int Columna) {
        try {
            ComboBox.removeAllItems();

            st = conexion.createStatement();
            rs = st.executeQuery(SQL);

            while (rs.next()) {
                ComboBox.addItem(rs.getString(Columna));
            }

            ComboBox.setSelectedIndex(0);

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    //Buscar por estado
    public void Anidar() {
        switch (JCFiltro.getSelectedIndex()) {
            case 1: {
                ModeloArea Area = new ModeloArea();
                DefaultComboBoxModel ModeloCombo = new DefaultComboBoxModel(Area.MostrarArea());
                JCFiltro2.setModel(ModeloCombo);
                break;
            }
            case 2: {
                ModeloEstado Estado = new ModeloEstado();
                DefaultComboBoxModel ModeloCombo = new DefaultComboBoxModel(Estado.MostrarEstado());
                JCFiltro2.setModel(ModeloCombo);
                break;
            }
            default:
                break;
        }
    }

    //Filtrar por Area o Estado
    public void Filtrar(java.awt.event.ItemEvent evt, JTable TablaProblema) {
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            
            if (JCFiltro.getSelectedIndex() == 1) {
                DefaultTableModel ModeloTabla = new DefaultTableModel();
                TablaProblema.setModel(ModeloTabla);

                try {
                    ps = conexion.prepareStatement("SELECT * FROM TablaProblema WHERE AreaProb = '" + JCFiltro2.getSelectedItem().toString() + "'");
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
            } else if (evt.getStateChange() == ItemEvent.SELECTED) {
                DefaultTableModel ModeloTabla = new DefaultTableModel();
                TablaProblema.setModel(ModeloTabla);

                try {
                    ps = conexion.prepareStatement("SELECT * FROM TablaProblema WHERE Estado = '" + JCFiltro2.getSelectedItem().toString() + "'");
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
        }
    }

    //Al escribir en el JTextField se buscará lo deseado
    public void Buscar(String Buscar) throws SQLException {
        String[] Columnas = {"Tiket", "Correo", "Nombre", "Detalle", "Fecha De Creacion", "Area", "Estado", "Solucion", "Imagen"};
        String[] Registros = new String[9];

        DefaultTableModel ModeloTabla = new DefaultTableModel(null, Columnas);

        switch (JCBuscar.getSelectedIndex()) {
            case 1:
                con.getConnection();
                ps = conexion.prepareStatement("SELECT * FROM TablaProblema WHERE idProblema LIKE '%" + Buscar + "%' ");
                System.out.println(ps);
                break;
            case 2:
                Connection conexion2 = con.getConnection();
                ps = conexion2.prepareStatement("SELECT * FROM TablaProblema WHERE NombreProb LIKE '%" + Buscar + "%' ");
                System.out.println(ps);
                break;
            case 3:
                Connection conexion3 = con.getConnection();
                ps = conexion3.prepareStatement("SELECT * FROM TablaProblema WHERE DetalleProb LIKE '%" + Buscar + "%' ");
                System.out.println(ps);
                break;
        }

        try {

            rs = ps.executeQuery();

            while (rs.next()) {
                Registros[0] = rs.getString("idProblema");
                Registros[1] = rs.getString("CorreoPersona");
                Registros[2] = rs.getString("NombreProb");
                Registros[3] = rs.getString("DetalleProb");
                Registros[4] = rs.getString("FechaCreacion");
                Registros[5] = rs.getString("Areaprob");
                Registros[6] = rs.getString("Estado");
                Registros[7] = rs.getString("Solucion");
                Registros[8] = rs.getString("Imagen");

                ModeloTabla.addRow(Registros);
            }

            JTablaProblema.setModel(ModeloTabla);

        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPMenuVer = new javax.swing.JPopupMenu();
        JMenuVer = new javax.swing.JMenuItem();
        JMenuVerAv = new javax.swing.JMenuItem();
        JMenuCategorizar = new javax.swing.JMenuItem();
        TxtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        JCBuscar = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTablaProblema = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        BtnRepSol = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BtnRepProc = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        BtnRepPen = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        JCFiltro = new javax.swing.JComboBox<>();
        JCFiltro2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        BtnActualizarEmail = new javax.swing.JButton();
        LblImgVP = new javax.swing.JLabel();

        JMenuVer.setText("Ver");
        JPMenuVer.add(JMenuVer);

        JMenuVerAv.setText("Ver Avances");
        JPMenuVer.add(JMenuVerAv);

        JMenuCategorizar.setText("Categorizar");
        JPMenuVer.add(JMenuCategorizar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscarKeyReleased(evt);
            }
        });

        jLabel1.setText("Buscar");

        JCBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Seleccione>", "Tiket", "Nombre", "Detalle" }));
        JCBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBuscarActionPerformed(evt);
            }
        });

        JTablaProblema.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JTablaProblema.setComponentPopupMenu(JPMenuVer);
        jScrollPane1.setViewportView(JTablaProblema);

        jLabel2.setText("Ver solucionados");

        BtnRepSol.setText("Solucionados");

        jLabel3.setText("Ver en proceso");

        BtnRepProc.setText("En proceso");

        jLabel4.setText("Ver pendientes");

        BtnRepPen.setText("Pendientes");

        jLabel5.setText("Filtro");

        JCFiltro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCFiltroItemStateChanged(evt);
            }
        });

        JCFiltro2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCFiltro2ItemStateChanged(evt);
            }
        });
        JCFiltro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCFiltro2ActionPerformed(evt);
            }
        });
        JCFiltro2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JCFiltro2KeyReleased(evt);
            }
        });

        jLabel6.setText("Actualizar tabla");

        BtnActualizarEmail.setText("↺");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnRepSol, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnRepProc, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnRepPen, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(JCFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JCFiltro2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnActualizarEmail))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(6, 6, 6)
                                .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addComponent(LblImgVP, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JCBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(JCFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCFiltro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(BtnActualizarEmail)))
                    .addComponent(LblImgVP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(BtnRepPen))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(BtnRepProc))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(BtnRepSol)))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyReleased
        try {
            Buscar(TxtBuscar.getText());
        } catch (SQLException ex) {
            Logger.getLogger(VerProblema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TxtBuscarKeyReleased

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void JCBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBuscarActionPerformed

    }//GEN-LAST:event_JCBuscarActionPerformed

    private void JCFiltroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCFiltroItemStateChanged
        Anidar();
    }//GEN-LAST:event_JCFiltroItemStateChanged

    private void JCFiltro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCFiltro2ActionPerformed

    }//GEN-LAST:event_JCFiltro2ActionPerformed

    private void JCFiltro2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JCFiltro2KeyReleased

    }//GEN-LAST:event_JCFiltro2KeyReleased

    private void JCFiltro2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCFiltro2ItemStateChanged
        Filtrar(evt, JTablaProblema);
        System.out.println(ps);
    }//GEN-LAST:event_JCFiltro2ItemStateChanged

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerProblema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new VerProblema().setVisible(true);
            } catch (SQLException | MessagingException ex) {
                Logger.getLogger(VerProblema.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnActualizarEmail;
    public javax.swing.JButton BtnRepPen;
    public javax.swing.JButton BtnRepProc;
    public javax.swing.JButton BtnRepSol;
    public javax.swing.JComboBox<String> JCBuscar;
    public javax.swing.JComboBox<String> JCFiltro;
    public javax.swing.JComboBox<String> JCFiltro2;
    public javax.swing.JMenuItem JMenuCategorizar;
    public javax.swing.JMenuItem JMenuVer;
    public javax.swing.JMenuItem JMenuVerAv;
    public javax.swing.JPopupMenu JPMenuVer;
    public javax.swing.JTable JTablaProblema;
    public javax.swing.JLabel LblImgVP;
    public javax.swing.JTextField TxtBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
