/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUIBusqueda.java
 *
 * Created on 9/05/2011, 11:21:18 PM
 */
package biblioteca.gui;

import biblioteca.gui.busquedas.*;
import javax.swing.JOptionPane;
/**
 *
 * @author alejandro
 */
public class GUIBusqueda extends javax.swing.JFrame {
    BusquedaNormal normal;
    BusquedaAvanzada avanzada;
    /** Creates new form GUIBusqueda */
    public GUIBusqueda() {
        initComponents();
        normal = new BusquedaNormal();
        avanzada = new BusquedaAvanzada();
        this.getContentPane().add(normal);
        this.setSize(normal.getPreferredSize());
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

        Cambiar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        Archivo = new javax.swing.JMenu();
        Agregar_Documento = new javax.swing.JMenuItem();
        Modificar_Documento = new javax.swing.JMenuItem();
        Estadisticas = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        Autenticarse = new javax.swing.JMenu();
        Registrarse = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        Modificar_Datos = new javax.swing.JMenuItem();
        Gestion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca Digital");
        setMinimumSize(new java.awt.Dimension(600, 300));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        Cambiar.setText("Cambiar busqueda");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        getContentPane().add(Cambiar, gridBagConstraints);

        Archivo.setMnemonic('a');
        Archivo.setText("Archivo");

        Agregar_Documento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        Agregar_Documento.setMnemonic('o');
        Agregar_Documento.setText("Agregar un Documento");
        Agregar_Documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar_DocumentoActionPerformed(evt);
            }
        });
        Archivo.add(Agregar_Documento);

        Modificar_Documento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        Modificar_Documento.setMnemonic('m');
        Modificar_Documento.setText("Modificar un Documento");
        Modificar_Documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Modificar_DocumentoActionPerformed(evt);
            }
        });
        Archivo.add(Modificar_Documento);

        Estadisticas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        Estadisticas.setMnemonic('e');
        Estadisticas.setText("Reportes y Estadisticas");
        Estadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstadisticasActionPerformed(evt);
            }
        });
        Archivo.add(Estadisticas);

        Salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        Salir.setMnemonic('s');
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        Archivo.add(Salir);

        jMenuBar1.add(Archivo);

        Autenticarse.setMnemonic('o');
        Autenticarse.setText("Opciones");

        Registrarse.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        Registrarse.setMnemonic('r');
        Registrarse.setText("Registrarse");
        Registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarseActionPerformed(evt);
            }
        });
        Autenticarse.add(Registrarse);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setMnemonic('a');
        jMenuItem1.setText("Autenticarse");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Autenticarse.add(jMenuItem1);

        Modificar_Datos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        Modificar_Datos.setMnemonic('m');
        Modificar_Datos.setText("Modificar tus datos");
        Modificar_Datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Modificar_DatosActionPerformed(evt);
            }
        });
        Autenticarse.add(Modificar_Datos);

        Gestion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        Gestion.setMnemonic('g');
        Gestion.setText("Gestionar Usuarios");
        Gestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionActionPerformed(evt);
            }
        });
        Autenticarse.add(Gestion);

        jMenuBar1.add(Autenticarse);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Agregar_DocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar_DocumentoActionPerformed
        this.setVisible(false);
        new biblioteca.gui.GUICatalogacion(this).setVisible(true);
    }//GEN-LAST:event_Agregar_DocumentoActionPerformed

    private void Modificar_DocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Modificar_DocumentoActionPerformed
        unsupportedOperation();
    }//GEN-LAST:event_Modificar_DocumentoActionPerformed

    private void EstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadisticasActionPerformed
        unsupportedOperation();
    }//GEN-LAST:event_EstadisticasActionPerformed

    private void RegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarseActionPerformed
        this.setVisible(false);
        new biblioteca.gui.GUIRegistroUsuarios(this).setVisible(true);
    }//GEN-LAST:event_RegistrarseActionPerformed

    private void Modificar_DatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Modificar_DatosActionPerformed
        unsupportedOperation();
    }//GEN-LAST:event_Modificar_DatosActionPerformed

    private void GestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionActionPerformed
        unsupportedOperation();
    }//GEN-LAST:event_GestionActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setVisible(false);
        new biblioteca.gui.GUIAutenticacion(this).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void unsupportedOperation(){
        JOptionPane.showMessageDialog(this, "Esta operación aún no ha sido implementada", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Agregar_Documento;
    private javax.swing.JMenu Archivo;
    private javax.swing.JMenu Autenticarse;
    private javax.swing.JButton Cambiar;
    private javax.swing.JMenuItem Estadisticas;
    private javax.swing.JMenuItem Gestion;
    private javax.swing.JMenuItem Modificar_Datos;
    private javax.swing.JMenuItem Modificar_Documento;
    private javax.swing.JMenuItem Registrarse;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}