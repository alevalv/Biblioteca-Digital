/*
 * This file is part of Biblioteca-Digital de Univalle.
 *
 * Biblioteca-Digital de Univalle is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Biblioteca-Digital de Univalle is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with Biblioteca-Digital de Univalle.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

/*
 * Subir_Archivo.java
 *
 * Created on 7/05/2011, 08:56:00 PM
 */
package biblioteca.gui.modificacion;

import biblioteca.gui.LimitadorDejTextField;
import javax.swing.JFileChooser;

/**
 * Este panel hace parte de la interfaz GUIModificacionDocumento. Finaliza
 * el proceso de modificación de documento, no se permite subir un nuevo archivo
 *
 * @see biblioteca.gui.GUIModificacionDocumento;
 * @author María Cristina Bustos Rodríguez
 * @author Alejandro Valdés Villada
 */
public class Subir_Archivo extends javax.swing.JPanel {
    biblioteca.gui.GUIModificacionDocumento MainGui;
    /** Creates new form Subir_Archivo */
    public Subir_Archivo(biblioteca.gui.GUIModificacionDocumento Parent) {
        initComponents();
        MainGui=Parent;
    }
    
    /**
     * Carga la información del documento a modificar
     */
    public void inicializarDocumento(){
        Path.setEnabled(false);
        Path.setEditable(false);
        Seleccionar_Archivo.setEnabled(false);
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

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Path = new javax.swing.JTextField();
        Seleccionar_Archivo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Finalizar = new javax.swing.JButton();
        Estado = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 24));
        jLabel4.setText("Subir un Archivo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 150, 0);
        add(jLabel4, gridBagConstraints);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/gui/resources/logo.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = -27;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jLabel3, gridBagConstraints);

        LimitadorDejTextField PathL=new LimitadorDejTextField(512);
        Path.setDocument(PathL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 415;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        add(Path, gridBagConstraints);

        Seleccionar_Archivo.setText("Seleccionar Archivo");
        Seleccionar_Archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seleccionar_ArchivoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        add(Seleccionar_Archivo, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18));
        jLabel5.setText("Por favor, seleccione el archivo o digite su path:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 15);
        add(jLabel5, gridBagConstraints);

        Finalizar.setFont(new java.awt.Font("Ubuntu", 1, 15));
        Finalizar.setText("Finalizar");
        Finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalizarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(160, 42, 0, 10);
        add(Finalizar, gridBagConstraints);

        Estado.setFont(new java.awt.Font("Ubuntu", 0, 24));
        Estado.setForeground(new java.awt.Color(255, 0, 0));
        Estado.setText("[Sin Guardar]");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 38;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(150, 15, 20, 0);
        add(Estado, gridBagConstraints);

        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setText("*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        add(jLabel20, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizarActionPerformed
        MainGui.catalogar();
}//GEN-LAST:event_FinalizarActionPerformed

    private void Seleccionar_ArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seleccionar_ArchivoActionPerformed
        JFileChooser JFC= new JFileChooser();
        JFC.showOpenDialog(this);
        Path.setText(JFC.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_Seleccionar_ArchivoActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Estado;
    private javax.swing.JButton Finalizar;
    private javax.swing.JTextField Path;
    private javax.swing.JButton Seleccionar_Archivo;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
