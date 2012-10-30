/*
 */
package udadevdemo;

import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 * View Class UdaDevDemoGUI
 *
 * Clase que representa la interfaz grafica del utilitario que permite registrar
 * multiples documentos o columnas en motores de base de datos no relacional.
 */
public class UdaDevDemoGUI extends javax.swing.JFrame {

    private DataAccessProvider dataAccessProvider;

    private Logger logger = Logger.getLogger(UdaDevDemoGUI.class);

    /**
     * 
     * @param jTable 
     */
    private void limpiarTabla(JTable jTable) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable.getModel();
        
        for(int i = 0; i < defaultTableModel.getRowCount(); i++) {
            defaultTableModel.removeRow(i);
        }
    }
    
    /**
     * Creates new form UdaDevDemoGUI
     */
    public UdaDevDemoGUI() {
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
        jPanel1 = new javax.swing.JPanel();
        guardarItemButton = new javax.swing.JButton();
        deleteAttributeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAtributosItem = new javax.swing.JTable();
        addAttributeBUtton = new javax.swing.JButton();
        textFamiliaColeccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableListado = new javax.swing.JTable();
        actualizarListadoButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        textFamiliaColeccionListado = new javax.swing.JTextField();
        conectarButton = new javax.swing.JButton();
        desconectarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UdaDevDemo - NoSQL");

        jLabel3.setText("Nombre de la Base de Datos:");

        jLabel5.setText("Motor NoSQL a Utilizar:");

        motorNoSQLComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MongoDB", "Cassandra" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Nuevo Item"));

        guardarItemButton.setText("Guardar");
        guardarItemButton.setEnabled(false);
        guardarItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarItemButtonActionPerformed(evt);
            }
        });

        deleteAttributeButton.setMnemonic('E');
        deleteAttributeButton.setText("Eliminar Atributo");
        deleteAttributeButton.setToolTipText("haz click aqui para eliminar el ultimo atributo asociado");
        deleteAttributeButton.setEnabled(false);
        deleteAttributeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAttributeButtonActionPerformed(evt);
            }
        });

        tableAtributosItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Atributo", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableAtributosItem);

        addAttributeBUtton.setMnemonic('A');
        addAttributeBUtton.setText("Agregar Atributo");
        addAttributeBUtton.setToolTipText("Haz click aquí para agregar un nuevo atributo");
        addAttributeBUtton.setEnabled(false);
        addAttributeBUtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAttributeBUttonActionPerformed(evt);
            }
        });

        textFamiliaColeccion.setEnabled(false);

        jLabel4.setText("Nombre de la Familia/Coleccion de Datos:");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 282, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(textFamiliaColeccion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 266, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 137, Short.MAX_VALUE)
                        .add(addAttributeBUtton)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(deleteAttributeButton))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(guardarItemButton))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(textFamiliaColeccion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(addAttributeBUtton)
                    .add(deleteAttributeButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .add(24, 24, 24)
                .add(guardarItemButton))
        );

        jTabbedPane1.addTab("Registro de Items", jPanel1);

        tableListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableListado);

        actualizarListadoButton.setText("Actualizar");
        actualizarListadoButton.setEnabled(false);
        actualizarListadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarListadoButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Nombre de la Familia/Coleccion de Datos:");

        textFamiliaColeccionListado.setEnabled(false);

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 282, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(textFamiliaColeccionListado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 277, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(actualizarListadoButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .add(jLabel8)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(textFamiliaColeccionListado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(actualizarListadoButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
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

    private void deleteAttributeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAttributeButtonActionPerformed

        DefaultTableModel model = (DefaultTableModel) tableAtributosItem.getModel();

        if (model.getRowCount() > 0) {

            deleteAttributeButton.setEnabled(true);

            model.removeRow(model.getRowCount() - 1);

            tableAtributosItem.setModel(model);

            jScrollPane1.setViewportView(tableAtributosItem);

        } else {
            deleteAttributeButton.setEnabled(false);

            guardarItemButton.setEnabled(false);
        }

    }//GEN-LAST:event_deleteAttributeButtonActionPerformed

    private void addAttributeBUttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAttributeBUttonActionPerformed

        DefaultTableModel model = (DefaultTableModel) tableAtributosItem.getModel();

        model.addRow(new Object[]{"", ""});

        tableAtributosItem.setModel(model);

        jScrollPane1.setViewportView(tableAtributosItem);

        deleteAttributeButton.setEnabled(true);

        guardarItemButton.setEnabled(true);
    }//GEN-LAST:event_addAttributeBUttonActionPerformed

    private void guardarItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarItemButtonActionPerformed

        DefaultTableModel model = (DefaultTableModel) tableAtributosItem.getModel();

        HashMap<String, Object> itemsARegistrar = new HashMap<String, Object>();

        for (int i = 0; i < model.getRowCount(); i++) {

            itemsARegistrar.put(model.getValueAt(i, 0).toString(), model.getValueAt(i, 1));
        }

        try {
            dataAccessProvider.registrarDocumento(itemsARegistrar, textFamiliaColeccion.getText());

            limpiarTabla(tableAtributosItem);
            
            JOptionPane.showMessageDialog(this, 
                    "El registro del nuevo elemento fue exitoso",
                    "UDADevDemo", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (DataAccessException dae) {

            logger.error(dae.getMessage(), dae);

            JOptionPane.showMessageDialog(this, dae.getMessage(),
                    "Error - UDADevDemo", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_guardarItemButtonActionPerformed

    private void actualizarListadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarListadoButtonActionPerformed

        try {
            Object[][] items = dataAccessProvider.buscarItems(textFamiliaColeccionListado.getText());

            int maximoColumnas = 0;

            for (Object[] fila : items) {
                if (fila.length > maximoColumnas) {
                    maximoColumnas = fila.length;
                }
            }

            Object[] nombreDeColumnas = new Object[maximoColumnas];

            for (int i = 1; i <= maximoColumnas; i++) {
                nombreDeColumnas[i - 1] = "Columna/Atributo " + i;
            }

            DefaultTableModel dtm = new DefaultTableModel();
            dtm.setDataVector(items, nombreDeColumnas);
            tableListado.setModel(dtm);
            jScrollPane2.setViewportView(tableListado);

        } catch (DataAccessException dae) {

            logger.error(dae.getMessage(), dae);

            JOptionPane.showMessageDialog(this, dae.getMessage(),
                    "Error - UDADevDemo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_actualizarListadoButtonActionPerformed

    private void conectarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conectarButtonActionPerformed

        try {

            if (motorNoSQLComboBox.getSelectedItem().toString().equals("MongoDB")) {

                dataAccessProvider = new MongoDataAccessProvider(textDbName.getText());

            } else if (motorNoSQLComboBox.getSelectedItem().toString().equals("Cassandra")) {

                dataAccessProvider = new CassandraDataAccessProvider(textDbName.getText());
            }

            conectarButton.setEnabled(false);
            desconectarButton.setEnabled(true);

            textDbName.setEnabled(false);
            addAttributeBUtton.setEnabled(true);
            actualizarListadoButton.setEnabled(true);
            textFamiliaColeccion.setEnabled(true);
            textFamiliaColeccionListado.setEnabled(true);

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
        limpiarTabla(tableAtributosItem);
        
        dataAccessProvider.closeConnection();
        dataAccessProvider = null;
        
        conectarButton.setEnabled(true);
        desconectarButton.setEnabled(false);
        

        textDbName.setEnabled(true);
        addAttributeBUtton.setEnabled(false);
        deleteAttributeButton.setEnabled(false);
        actualizarListadoButton.setEnabled(false);
        textFamiliaColeccion.setEnabled(false);
        textFamiliaColeccionListado.setEnabled(false);

        textFamiliaColeccion.setText("");
        textFamiliaColeccionListado.setText("");
        
        JOptionPane.showMessageDialog(this, "Se ha cancelado la conexion "
                + "con el servicio " + motorNoSQLComboBox.getSelectedItem().toString(),
                "UDADevDemo", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_desconectarButtonActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new UdaDevDemoGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarListadoButton;
    private javax.swing.JButton addAttributeBUtton;
    private javax.swing.JButton conectarButton;
    private javax.swing.JButton deleteAttributeButton;
    private javax.swing.JButton desconectarButton;
    private javax.swing.JButton guardarItemButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox motorNoSQLComboBox;
    private javax.swing.JTable tableAtributosItem;
    private javax.swing.JTable tableListado;
    private javax.swing.JTextField textDbName;
    private javax.swing.JTextField textFamiliaColeccion;
    private javax.swing.JTextField textFamiliaColeccionListado;
    // End of variables declaration//GEN-END:variables

}
