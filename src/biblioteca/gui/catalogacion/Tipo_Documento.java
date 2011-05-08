/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Tipo_Documento.java
 *
 * Created on 8/05/2011, 04:04:42 PM
 */
package biblioteca.gui.catalogacion;

import biblioteca.database2.accesoDatos.DaoTipoDocumento;
import biblioteca.database2.beans.Documento;
import biblioteca.database2.beans.TipoDocumento;
import biblioteca.database2.controladores.ControladorTipoDocumento;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author alejandro
 */
public class Tipo_Documento extends javax.swing.JPanel {
    Documento documento;
    ArrayList<TipoDocumento> TiposExistentes;
    static public TipoDocumento tipoSeleccionado;
    /** Creates new form Tipo_Documento */
    public Tipo_Documento(Documento documento) {
        initComponents();
        this.documento=documento;
        TiposExistentes = new ArrayList<TipoDocumento>();
        tipoSeleccionado=null;
        initComboBox();
        biblioteca.gui.GUICatalogacion.Tipo_Documento_Guardado=false;
    }

    private void initComboBox(){
        Tipos_Documento.removeAllItems();
        TiposExistentes.clear();
        TiposExistentes=new DaoTipoDocumento().consultarTodosLosTipoDocumento();
        for(int i=0;i<TiposExistentes.size();i++){
            Tipos_Documento.insertItemAt(TiposExistentes.get(i).getTipoDocumento(), i);
        }
        Tipos_Documento.setSelectedIndex(-1);
        biblioteca.gui.GUICatalogacion.Tipo_Documento_Guardado=false;
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Tipos_Documento = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        Obtener_Descripcion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Descripcion = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Tipo_Nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tipo_Descripcion = new javax.swing.JTextArea();
        Agregar = new javax.swing.JButton();
        Estado = new javax.swing.JLabel();
        Siguiente = new javax.swing.JButton();

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/gui/resources/logo.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 24));
        jLabel4.setText("Tipo de Documento");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 18));
        jLabel10.setText("Descripción:");

        Obtener_Descripcion.setText("Obtener Descripción");
        Obtener_Descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Obtener_DescripcionActionPerformed(evt);
            }
        });

        Descripcion.setColumns(20);
        Descripcion.setRows(5);
        jScrollPane1.setViewportView(Descripcion);

        jSeparator1.setMinimumSize(new java.awt.Dimension(150, 6));
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 18));
        jLabel11.setText("Tipos de documento existentes (seleccionar uno): ");

        jLabel12.setFont(new java.awt.Font("Ubuntu", 0, 18));
        jLabel12.setText("Agregar un nuevo Tipo de Documento: ");

        jLabel1.setText("Nombre: ");

        jLabel2.setText("Descripción: ");

        Tipo_Descripcion.setColumns(20);
        Tipo_Descripcion.setRows(5);
        jScrollPane2.setViewportView(Tipo_Descripcion);

        Agregar.setText("Agregar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        Estado.setFont(new java.awt.Font("Ubuntu", 0, 24));
        Estado.setForeground(new java.awt.Color(255, 0, 0));
        Estado.setText("[Sin Guardar]");

        Siguiente.setFont(new java.awt.Font("Ubuntu", 1, 15));
        Siguiente.setText("Siguiente Paso");
        Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel4))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel10)
                .addGap(85, 85, 85)
                .addComponent(Obtener_Descripcion)
                .addContainerGap(231, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Tipos_Documento, 0, 567, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                                .addComponent(Agregar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1)
                                .addGap(2, 2, 2)
                                .addComponent(Tipo_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(Estado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
                .addComponent(Siguiente)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jLabel11)
                    .addContainerGap(169, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(50, 50, 50)
                .addComponent(Tipos_Documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(2, 2, 2))
                    .addComponent(Obtener_Descripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(Agregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Tipo_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Siguiente)
                    .addComponent(Estado))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addComponent(jLabel11)
                    .addContainerGap(464, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Obtener_DescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Obtener_DescripcionActionPerformed
        
    }//GEN-LAST:event_Obtener_DescripcionActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        if(checkEmptyFieldsTipo()){
            new ControladorTipoDocumento().agregarTipoDocumento(Tipo_Nombre.getText(), Tipo_Descripcion.getText());
            JOptionPane.showMessageDialog(this, "El Tipo con nombre "+Tipo_Nombre.getText()+" ha sido agregado", "Notificaición", JOptionPane.INFORMATION_MESSAGE);
            Tipo_Nombre.setText("");
            Tipo_Descripcion.setText("");
            initComboBox();
        }
    }//GEN-LAST:event_AgregarActionPerformed

    private void SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteActionPerformed
        tipoSeleccionado = new DaoTipoDocumento().consultarDocumento((String)Tipos_Documento.getItemAt(Tipos_Documento.getSelectedIndex()));
        biblioteca.gui.GUICatalogacion.Tipo_Documento_Guardado=true;
        Tipos_Documento.setEnabled(false);
        JTabbedPane parent =(JTabbedPane) this.getParent();
        parent.setSelectedIndex(5);
}//GEN-LAST:event_SiguienteActionPerformed

    private boolean checkEmptyFieldsTipo(){
        if(Tipo_Nombre.getText()==null || Tipo_Nombre.getText().equals("")){
            JOptionPane.showMessageDialog(this, "El campo Nombre no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(Tipo_Descripcion.getText()==null || Tipo_Descripcion.getText().equals("")){
            JOptionPane.showMessageDialog(this, "El campo Descripcion no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else return true;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JTextArea Descripcion;
    private javax.swing.JLabel Estado;
    private javax.swing.JButton Obtener_Descripcion;
    private javax.swing.JButton Siguiente;
    private javax.swing.JTextArea Tipo_Descripcion;
    private javax.swing.JTextField Tipo_Nombre;
    private javax.swing.JComboBox Tipos_Documento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
