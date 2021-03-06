/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUIAgregarPC.java
 *
 * Created on 6/06/2011, 11:50:42 AM
 */
package biblioteca.gui;

import biblioteca.database2.controladores.ControladorPalabraClave;
import javax.swing.JOptionPane;

/**
 * Esta GUI permite crear palabras claves en la base de datos de la apliación, sin necesidad de
 * abrir la GUI de Catalogación o modificación de documento
 * 
 * <br> Es el mismo codigo que está en biblioteca.gui.catalogacion.Selecc_Pal_Clave, solo
 * adaptado para una interfaz aparte
 * 
 * @see biblioteca.gui.catalogacion.Selecc_Pal_Clave
 *
 * @author María Cristina Bustos Rodríguez
 * @author Alejandro Valdés Villada
 */
public class GUIAgregarPC extends javax.swing.JFrame {
    private javax.swing.JFrame parent;
    /** Creates new form GUIAgregarPC */
    public GUIAgregarPC(javax.swing.JFrame parent) {
        initComponents();
        this.parent=parent;
        this.setLocationRelativeTo(parent);
        this.setResizable(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        PC_Nombre = new javax.swing.JTextField();
        PC_Descripcion = new javax.swing.JTextField();
        Agregar_Palabra_Clave = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/gui/resources/logo.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = -5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 20, 10, 0);
        jPanel3.add(jLabel13, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 24));
        jLabel14.setText("Agregar Palabras Clave");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 15, 0);
        jPanel3.add(jLabel14, gridBagConstraints);

        jLabel15.setText("Nombre: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 10, 0);
        jPanel3.add(jLabel15, gridBagConstraints);

        jLabel2.setText("Descripción: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 10, 0);
        jPanel3.add(jLabel2, gridBagConstraints);

        jLabel24.setForeground(new java.awt.Color(255, 0, 0));
        jLabel24.setText("*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPanel3.add(jLabel24, gridBagConstraints);

        jLabel25.setForeground(new java.awt.Color(255, 0, 0));
        jLabel25.setText("*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        jPanel3.add(jLabel25, gridBagConstraints);

        LimitadorDejTextField PCL=new LimitadorDejTextField(70);
        PC_Nombre.setDocument(PCL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 350;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 20);
        jPanel3.add(PC_Nombre, gridBagConstraints);

        LimitadorDejTextField PC_DescripcionL=new LimitadorDejTextField(200);
        PC_Descripcion.setDocument(PC_DescripcionL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 350;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 20);
        jPanel3.add(PC_Descripcion, gridBagConstraints);

        Agregar_Palabra_Clave.setText("Agregar Palabra Clave");
        Agregar_Palabra_Clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar_Palabra_ClaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 15, 5);
        jPanel3.add(Agregar_Palabra_Clave, gridBagConstraints);

        jLabel48.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel48.setText("Biblioteca Digital");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 10, 20);
        jPanel3.add(jLabel48, gridBagConstraints);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Comprueba campos vacios en la interfaz y envia un mensaje de error
     * explicando cual es el error al usuario
     * @return boolean indicando si no hay campos vacios en la interfaz
     */
    private boolean checkEmptyFieldsPC(){
        if(PC_Nombre.getText()==null || PC_Nombre.getText().equals("")){
            JOptionPane.showMessageDialog(this, "El campo Nombre no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(PC_Descripcion.getText()==null || PC_Descripcion.getText().equals("")){
            JOptionPane.showMessageDialog(this, "El campo Descripcion no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else return true;
    }
    
    private void Agregar_Palabra_ClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar_Palabra_ClaveActionPerformed
        if(checkEmptyFieldsPC()){
            if(new ControladorPalabraClave().InsertarPalabraClave(PC_Nombre.getText().toLowerCase().replaceAll("[']", "`"), PC_Descripcion.getText().replaceAll("[']", "`"))!=-1){
                JOptionPane.showMessageDialog(this, PC_Nombre.getText()+ " ha sido agregada", "Notificaición", JOptionPane.INFORMATION_MESSAGE);
                PC_Nombre.setText("");
                PC_Descripcion.setText("");
            } else{
                JOptionPane.showMessageDialog(this, PC_Nombre.getText()+ " ya existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
}//GEN-LAST:event_Agregar_Palabra_ClaveActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
        parent.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar_Palabra_Clave;
    private javax.swing.JTextField PC_Descripcion;
    private javax.swing.JTextField PC_Nombre;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
