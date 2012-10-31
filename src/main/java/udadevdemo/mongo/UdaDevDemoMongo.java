/*
 */
package udadevdemo.mongo;

import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;
import udadevdemo.DataAccessException;

/**
 * View Class UdaDevDemoMongo
 *
 * Clase que representa la interfaz grafica del utilitario que permite registrar
 * multiples documentos en el motor de datos no relacional MongoDB
 */
public class UdaDevDemoMongo extends javax.swing.JFrame {

    private ProblemaDAOMongo dataAccessProvider;

    private Logger logger = Logger.getLogger(UdaDevDemoMongo.class);

    /**
     *
     * @param jTable
     */
    private void limpiarTabla(JTable jTable) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable.getModel();

        for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
            defaultTableModel.removeRow(i);
        }
    }

    /**
     * Creates new form UdaDevDemoGUI
     */
    public UdaDevDemoMongo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textDbName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        motorNoSQLComboBox = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableListado = new javax.swing.JTable();
        buscarProblemasButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        comboEstatus = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        conectarButton = new javax.swing.JButton();
        desconectarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UdaDevDemo - NoSQL");

        jLabel3.setText("Nombre de la Base de Datos:");

        jLabel5.setText("Motor NoSQL a Utilizar:");

        motorNoSQLComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MongoDB" }));

        tableListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableListado);

        buscarProblemasButton.setText("Buscar");
        buscarProblemasButton.setEnabled(false);
        buscarProblemasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarProblemasButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 153));
        jLabel8.setText("Criterios de Búsqueda");

        comboEstatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "todos", "SOLUCIONADO", "NO_SOLUCIONADO" }));
        comboEstatus.setEnabled(false);

        jLabel6.setText("Estatus:");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "todos" }));
        comboTipo.setEnabled(false);

        jLabel7.setText("Tipo de Problema:");

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 282, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 180, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(46, 46, 46)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel3Layout.createSequentialGroup()
                                .add(6, 6, 6)
                                .add(jLabel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 180, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(comboTipo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 214, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(0, 0, Short.MAX_VALUE))
            .add(jPanel3Layout.createSequentialGroup()
                .add(comboEstatus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 214, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(buscarProblemasButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .add(jLabel8)
                .add(18, 18, 18)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jLabel7)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel6)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(comboEstatus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(comboTipo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(buscarProblemasButton))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Listado de Items", jPanel3);

        conectarButton.setText("Conectar");
        conectarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conectarButtonActionPerformed(evt);
            }
        });

        desconectarButton.setText("Desconectar");
        desconectarButton.setEnabled(false);
        desconectarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desconectarButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(layout.createSequentialGroup()
                                .add(6, 6, 6)
                                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 736, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, motorNoSQLComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                        .add(6, 6, 6)
                                        .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 180, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .add(53, 53, 53)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel3)
                                    .add(layout.createSequentialGroup()
                                        .add(textDbName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 180, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(43, 43, 43)
                                        .add(conectarButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 129, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(18, 18, 18)
                                        .add(desconectarButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .add(0, 0, Short.MAX_VALUE))
                    .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(22, 22, 22)
                        .add(textDbName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel5)
                            .add(jLabel3))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(motorNoSQLComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(conectarButton)
                            .add(desconectarButton))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conectarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conectarButtonActionPerformed

        try {
            dataAccessProvider = new ProblemaDAOMongo(textDbName.getText());

            comboEstatus.setEnabled(true);
            comboTipo.setEnabled(true);
            
            conectarButton.setEnabled(false);
            desconectarButton.setEnabled(true);

            textDbName.setEnabled(false);
            buscarProblemasButton.setEnabled(true);

            for(TipoProblema tipo : dataAccessProvider.listarTipoProblemas()) {
                comboTipo.addItem(tipo.getNombre());
            }            
            
            JOptionPane.showMessageDialog(this, "Se ha iniciado una conexion "
                    + "con el servicio " + motorNoSQLComboBox.getSelectedItem().toString(),
                    "UDADevDemo", JOptionPane.INFORMATION_MESSAGE);

        } catch (DataAccessException dae) {

            logger.error(dae.getMessage(), dae);

            JOptionPane.showMessageDialog(this, dae.getMessage(),
                    "Error - UDADevDemo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_conectarButtonActionPerformed

    private void desconectarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desconectarButtonActionPerformed

        limpiarTabla(tableListado);

        conectarButton.setEnabled(true);
        desconectarButton.setEnabled(false);


        textDbName.setEnabled(true);
        buscarProblemasButton.setEnabled(false);

        JOptionPane.showMessageDialog(this, "Se ha cancelado la conexion "
                + "con el servicio " + motorNoSQLComboBox.getSelectedItem().toString(),
                "UDADevDemo", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_desconectarButtonActionPerformed

    private void buscarProblemasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarProblemasButtonActionPerformed

        HashMap<String, Object> criterios = new HashMap<String, Object>();

        if (!comboEstatus.getSelectedItem().toString().equals("todos")) {
            criterios.put("estatus", comboEstatus.getSelectedItem().toString());
        }

        if (!comboTipo.getSelectedItem().toString().equals("todos")) {
            
            for(TipoProblema tipo : dataAccessProvider.listarTipoProblemas()) {
                if (tipo.getNombre().equals(comboTipo.getSelectedItem().toString())) {
                    criterios.put("id_tipo_problema", tipo.getId());
                }
            }
        }

        try {
            List<Problema> problemas = dataAccessProvider.listarProblemasPorCriterio(criterios);

            int maximoColumnas = 0;

            Object[] nombreDeColumnas = new Object[]{"ID Problema", "Estatus",
                "Fecha de Registro", "CoordX", "CoordY", "Tipo de Problema"};

            Object[][] itemsModelo = new Object[problemas.size()][6];

            for (Problema problema : problemas) {
                itemsModelo[maximoColumnas][0] = problema.getId();
                itemsModelo[maximoColumnas][1] = problema.getEstatus();
                itemsModelo[maximoColumnas][2] = problema.getFechaDeRegistro();
                itemsModelo[maximoColumnas][3] = problema.getCoordenadaX();
                itemsModelo[maximoColumnas][4] = problema.getCoordenadaY();
                itemsModelo[maximoColumnas][5] = problema.getTipoProblema().getNombre();
                
                maximoColumnas++;
            }

            DefaultTableModel dtm = new DefaultTableModel();
            dtm.setDataVector(itemsModelo, nombreDeColumnas);
            tableListado.setModel(dtm);
            jScrollPane2.setViewportView(tableListado);

        } catch (DataAccessException dae) {

            logger.error(dae.getMessage(), dae);

            JOptionPane.showMessageDialog(this, dae.getMessage(),
                    "Error - UDADevDemo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buscarProblemasButtonActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new UdaDevDemoMongo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarProblemasButton;
    private javax.swing.JComboBox comboEstatus;
    private javax.swing.JComboBox comboTipo;
    private javax.swing.JButton conectarButton;
    private javax.swing.JButton desconectarButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox motorNoSQLComboBox;
    private javax.swing.JTable tableListado;
    private javax.swing.JTextField textDbName;
    // End of variables declaration//GEN-END:variables

}
