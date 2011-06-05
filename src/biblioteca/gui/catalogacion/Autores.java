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
 * GUICAT_Autores.java
 *
 * Created on 7/05/2011, 04:50:06 PM
 */
package biblioteca.gui.catalogacion;


import biblioteca.database2.beans.Autor;
import biblioteca.database2.beans.Documento;
import biblioteca.database2.controladores.ControladorAutor;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author alejandro
 */
public class Autores extends javax.swing.JPanel {
    Documento documento;
    private ArrayList<Autor> autoresExistentes;
    public static ArrayList<Autor> autoresSeleccionados;
    /** Creates new form GUICAT_Autores */
    public Autores(Documento documento) {
        initComponents();
        this.documento=documento;
        autoresSeleccionados = new ArrayList<Autor>();
        biblioteca.gui.GUICatalogacion.Autores_Guardado=false;
        initAuthorComboBox();
    }
    
    private void initAuthorComboBox(){
        Autores.removeAllItems();
        autoresExistentes = new ControladorAutor().obtenerTodosLosAutores();
        if(!(autoresExistentes==null)){
            for(int i=0;i<autoresExistentes.size();i++){
                Autores.insertItemAt(autoresExistentes.get(i), i);
            }        
            Autores.setSelectedIndex(-1);
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Autores = new javax.swing.JComboBox();
        Agregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Cancelar = new javax.swing.JButton();
        Autor_Correo = new javax.swing.JTextField();
        Autor_Nombre = new javax.swing.JTextField();
        Autor_Apellido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Autor_Acronimo = new javax.swing.JTextField();
        Estado = new javax.swing.JLabel();
        Siguiente = new javax.swing.JButton();
        Agregar_Autor = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Autores_Agregados = new javax.swing.JTextArea();

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18));
        jLabel1.setText("Autores Existentes: ");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/gui/resources/logo.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 24));
        jLabel4.setText("Autores");

        Agregar.setText("Agregar Autor al Documento");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        jSeparator1.setMinimumSize(new java.awt.Dimension(150, 6));
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18));
        jLabel2.setText("Agregar un Nuevo Autor: ");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18));
        jLabel5.setText("Autores Agregados: ");

        jLabel6.setText("Correo Electronico: ");

        jLabel7.setText("Nombre(s): ");

        jLabel8.setText("Apellido(s): ");

        Cancelar.setText("Cancelar Operación");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        jLabel9.setText("Acronimo: ");

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

        Agregar_Autor.setText("Agregar Autor");
        Agregar_Autor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar_AutorActionPerformed(evt);
            }
        });

        jSeparator2.setMinimumSize(new java.awt.Dimension(150, 6));
        jSeparator2.setPreferredSize(new java.awt.Dimension(200, 10));

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 18));
        jLabel10.setText("Autores Existentes: ");

        Autores_Agregados.setColumns(20);
        Autores_Agregados.setRows(5);
        Autores_Agregados.setMinimumSize(new java.awt.Dimension(200, 200));
        Autores_Agregados.setPreferredSize(new java.awt.Dimension(300, 500));
        jScrollPane1.setViewportView(Autores_Agregados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addComponent(jLabel4))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addGap(7, 7, 7)
                .addComponent(Autor_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel7)
                .addGap(36, 36, 36)
                .addComponent(Autor_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel8)
                .addGap(37, 37, 37)
                .addComponent(Autor_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel9)
                .addGap(40, 40, 40)
                .addComponent(Autor_Acronimo, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(Agregar_Autor))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(248, 248, 248)
                        .addComponent(Cancelar))
                    .addComponent(Autores, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(182, 182, 182)
                        .addComponent(Agregar)))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Estado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Siguiente))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel10))
                    .addComponent(Cancelar))
                .addGap(10, 10, 10)
                .addComponent(Autores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Agregar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel6))
                    .addComponent(Autor_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel7))
                    .addComponent(Autor_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel8))
                    .addComponent(Autor_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel9))
                    .addComponent(Autor_Acronimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(Agregar_Autor)
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Siguiente)
                    .addComponent(Estado))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        if(!autoresSeleccionados.contains((Autor)Autores.getSelectedItem())){
            autoresSeleccionados.add((Autor)Autores.getSelectedItem());
            refreshAutoresSeleccionados();
            biblioteca.gui.GUICatalogacion.Autores_Guardado=false;
        }
    }//GEN-LAST:event_AgregarActionPerformed

    private void SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteActionPerformed
        if(!autoresSeleccionados.isEmpty()){
            biblioteca.gui.GUICatalogacion.Autores_Guardado=true;
            Estado.setForeground(Color.green);
            Estado.setText("[Guardado]");
            JTabbedPane parent =(JTabbedPane) this.getParent();
            parent.setSelectedIndex(2);
            Autores.setEnabled(false);
            Agregar.setEnabled(false);
        }
        else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar almenos un autor", "Error", JOptionPane.ERROR_MESSAGE);
        }
}//GEN-LAST:event_SiguienteActionPerformed

    private void Agregar_AutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar_AutorActionPerformed
        if(checkEmptyFieldsAuthor()){
            if(new ControladorAutor().insertarAutor(Autor_Nombre.getText(), Autor_Apellido.getText(), Autor_Correo.getText().toLowerCase(), Autor_Acronimo.getText())!=-1){
                JOptionPane.showMessageDialog(this, "El autor con correo "+Autor_Correo.getText()+ " ha sido agregado", "Notificación", JOptionPane.INFORMATION_MESSAGE);
                Autor_Correo.setText("");
                Autor_Apellido.setText("");
                Autor_Acronimo.setText("");
                Autor_Nombre.setText("");
                initAuthorComboBox();
            }
            else{
                JOptionPane.showMessageDialog(this, "El autor con correo "+Autor_Correo.getText()+ " ya existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_Agregar_AutorActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        autoresSeleccionados.clear();
        refreshAutoresSeleccionados();
        biblioteca.gui.GUICatalogacion.Autores_Guardado=false;
        Estado.setForeground(Color.red);
        Estado.setText("[Sin Guardar]");
        Autores.setEnabled(true);
        Agregar.setEnabled(true);
    }//GEN-LAST:event_CancelarActionPerformed

    private boolean checkEmptyFieldsAuthor(){
        if(Autor_Correo.getText()==null || Autor_Correo.getText().equals("")){
            JOptionPane.showMessageDialog(this, "El campo Autor Correo no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(Autor_Nombre.getText()==null || Autor_Nombre.getText().equals("")){
            JOptionPane.showMessageDialog(this, "El campo Autor_Nombre no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(Autor_Apellido.getText()==null || Autor_Apellido.getText().equals("")){
            JOptionPane.showMessageDialog(this, "El campo Autor_Apellido no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if(Autor_Acronimo.getText()==null || Autor_Acronimo.getText().equals("")){
            JOptionPane.showMessageDialog(this, "El campo Autor_Acronimo no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else return true;
    }    
    
    private void refreshAutoresSeleccionados(){
        String nuevoTexto="";
        for(int i=0;i<autoresSeleccionados.size();i++){
            nuevoTexto+=autoresExistentes.get(i).getCorreo()+" - "+autoresExistentes.get(i).getNombre()
                    +" "+autoresExistentes.get(i).getApellido()+" - "+autoresExistentes.get(i).getAcronimo();
            if(i!=(autoresSeleccionados.size()-1))
                nuevoTexto+="\n";
        }
        Autores_Agregados.setText(nuevoTexto);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Agregar_Autor;
    private javax.swing.JTextField Autor_Acronimo;
    private javax.swing.JTextField Autor_Apellido;
    private javax.swing.JTextField Autor_Correo;
    private javax.swing.JTextField Autor_Nombre;
    private javax.swing.JComboBox Autores;
    private javax.swing.JTextArea Autores_Agregados;
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel Estado;
    private javax.swing.JButton Siguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
