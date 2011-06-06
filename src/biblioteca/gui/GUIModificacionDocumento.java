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
 * GUICatalogacion.java
 *
 * Created on 7/05/2011, 03:59:19 PM
 */
package biblioteca.gui;

import biblioteca.database2.beans.Documento;
import biblioteca.database2.controladores.ControladorDocumento;
import biblioteca.database2.controladores.ControladorUsuario;
import javax.swing.JOptionPane;

/**
 *
 * @author alejandro
 */
public class GUIModificacionDocumento extends javax.swing.JFrame {
    static public Documento documento;
    static public boolean Informacion_Basica_Guardada;
    static public boolean Autores_Guardado;
    static public boolean Areas_Guardadas;
    static public boolean Palabras_Clave_Guardadas;
    static public boolean Tipo_Documento_Guardado;
    biblioteca.gui.GUIBusqueda parent;
    biblioteca.gui.modificacion.Informacion_Basica informacionBasica;
    biblioteca.gui.modificacion.Autores autores;
    biblioteca.gui.modificacion.Selecc_Areas areas;
    biblioteca.gui.modificacion.Selecc_Pal_Clave pc;
    biblioteca.gui.modificacion.Subir_Archivo sa;
    biblioteca.gui.modificacion.Tipo_Documento td;
    /** Creates new form GUICatalogacion */
    public GUIModificacionDocumento(biblioteca.gui.GUIBusqueda parent) {
        Informacion_Basica_Guardada=false;
        Autores_Guardado=false;
        Areas_Guardadas=false;
        Palabras_Clave_Guardadas=false;
        Tipo_Documento_Guardado=false;
        this.parent = parent;
        informacionBasica = new biblioteca.gui.modificacion.Informacion_Basica(documento, this);
        autores = new biblioteca.gui.modificacion.Autores();
        areas = new biblioteca.gui.modificacion.Selecc_Areas();
        pc = new biblioteca.gui.modificacion.Selecc_Pal_Clave();
        sa = new biblioteca.gui.modificacion.Subir_Archivo(this);
        td = new biblioteca.gui.modificacion.Tipo_Documento();
        initComponents();
        this.setLocationRelativeTo(parent);
        this.setResizable(false);
    }
    
    public void catalogar(){
        if(Informacion_Basica_Guardada && Autores_Guardado && Areas_Guardadas
                && Palabras_Clave_Guardadas && Tipo_Documento_Guardado){
            if(new ControladorUsuario().verificarTipoUsuario("2", biblioteca.Main.BibliotecaDigital.LOGGED_USER)
                || new ControladorUsuario().verificarTipoUsuario("1", biblioteca.Main.BibliotecaDigital.LOGGED_USER)){
                ControladorDocumento controladorDocumento = new ControladorDocumento();
                controladorDocumento.modificarDocumento(documento.getID_documento(), documento.getTituloPrincipal(), documento.getTituloSecundario(), documento.getEditorial(), documento.getDerechosAutor(), documento.getIdioma(), documento.getDescripcion(), documento.getTipoMaterial(), documento.getFechaPublicacion(), documento.getActivo());
                //RELACIONES CON OTRAS TABLAS.
                
                //autores
                controladorDocumento.insertarAutores(documento.getID_documento(), biblioteca.gui.modificacion.Autores.autoresSeleccionados);
                controladorDocumento.insertarAreas(documento.getID_documento(), biblioteca.gui.modificacion.Selecc_Areas.areasSeleccionadas);
                controladorDocumento.insertarPalabrasClave(documento.getID_documento(), biblioteca.gui.modificacion.Selecc_Pal_Clave.palabrasClaveSeleccionadas);
                JOptionPane.showMessageDialog(this, "El documento "+documento.getTituloPrincipal()+ " ha sido agregado", "Notificación", JOptionPane.INFORMATION_MESSAGE);
            
                //seguridad
                destroyAll();
                
                //cerramos la ventana
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "El usuario no es un catalogador", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        else{
            JOptionPane.showMessageDialog(this, "No se puede guardar el documento por que no están completos todos los pasos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void documentoAbierto(){
        this.areas.inicializarDocumento();
        this.autores.inicializarDocumento();
        this.pc.inicializarDocumento();
        this.sa.inicializarDocumento();
        this.td.inicializarDocumento();
    }

    static public void destroyAll(){
        documento=null;
        biblioteca.gui.modificacion.Autores.autoresSeleccionados=null;
        biblioteca.gui.modificacion.Selecc_Areas.areasSeleccionadas=null;
        biblioteca.gui.modificacion.Selecc_Pal_Clave.palabrasClaveSeleccionadas=null;
        Informacion_Basica_Guardada=false;
        Autores_Guardado=false;
        Areas_Guardadas=false;
        Palabras_Clave_Guardadas=false;
        Tipo_Documento_Guardado=false;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Catalogación de Documentos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jTabbedPane1.add("Información Basica", informacionBasica);
        jTabbedPane1.add("Autores", autores);
        jTabbedPane1.add("Areas de la Computación", areas);
        jTabbedPane1.add("Palabras Clave", pc);
        jTabbedPane1.add("Tipo de Documento", td);
        jTabbedPane1.add("Subir Archivo", sa);
        getContentPane().add(jTabbedPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parent.setVisible(true);
        destroyAll();
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
