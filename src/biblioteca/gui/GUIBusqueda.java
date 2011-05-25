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

import biblioteca.database2.beans.Autor;
import biblioteca.database2.controladores.ControladorDocumento;
import javax.swing.JOptionPane;
import biblioteca.database2.controladores.ControladorUsuario;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author alejandro
 */
public class GUIBusqueda extends javax.swing.JFrame {
    ArrayList<String> resultados;
    /** Creates new form GUIBusqueda */
    public GUIBusqueda() {
        initComponents();
       this.setLocationRelativeTo(null);
        this.setExtendedState(this.MAXIMIZED_BOTH);        
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

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Resultados = new javax.swing.JTable();
        Consultar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(300, 0), new java.awt.Dimension(300, 0), new java.awt.Dimension(300, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(300, 0), new java.awt.Dimension(300, 0), new java.awt.Dimension(300, 32767));
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Texto_Busqueda = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Cambiar = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(300, 0), new java.awt.Dimension(300, 0), new java.awt.Dimension(300, 32767));
        jMenuBar1 = new javax.swing.JMenuBar();
        Archivo = new javax.swing.JMenu();
        Agregar_Documento = new javax.swing.JMenuItem();
        Modificar_Documento = new javax.swing.JMenuItem();
        Estadisticas = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        Autenticarse = new javax.swing.JMenu();
        Registrarse = new javax.swing.JMenuItem();
        Modificar_Datos = new javax.swing.JMenuItem();
        Gestion = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        RecomendacionesDocumentos = new javax.swing.JMenuItem();
        Iniciar_Sesion = new javax.swing.JMenu();
        Cerrar_Sesion = new javax.swing.JMenu();

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jScrollPane2.setMinimumSize(new java.awt.Dimension(800, 400));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(800, 400));

        Resultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Resultados);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 10, 20);
        jPanel2.add(jScrollPane2, gridBagConstraints);

        Consultar.setText("Consultar Documento Seleccionado");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 20, 20);
        jPanel2.add(Consultar, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 24));
        jLabel6.setText("Resultados de Busqueda");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 10, 10);
        jPanel2.add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel2.add(filler2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel2.add(filler3, gridBagConstraints);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca Digital");
        setMinimumSize(new java.awt.Dimension(600, 300));

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/gui/resources/logo.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 24));
        jLabel5.setText("Biblioteca Digital");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(jLabel5, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 24));
        jLabel4.setText("Busqueda Normal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        jPanel1.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 481;
        gridBagConstraints.insets = new java.awt.Insets(5, 20, 5, 20);
        jPanel1.add(Texto_Busqueda, gridBagConstraints);

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        jPanel1.add(Buscar, gridBagConstraints);

        jLabel1.setText("Introduzca cualquier metadato que conozca del documento que desea");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setText("buscar, como una parte del nombre, el autor o una palabra clave");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        jPanel1.add(jLabel2, gridBagConstraints);

        Cambiar.setText("Busqueda Avanzada");
        Cambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 20, 20);
        jPanel1.add(Cambiar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel1.add(filler1, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        Archivo.setMnemonic('a');
        Archivo.setText("Archivo");

        Agregar_Documento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
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

        jMenu1.setMnemonic('v');
        jMenu1.setText("Ver");

        RecomendacionesDocumentos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        RecomendacionesDocumentos.setText("Recomendaciones de documentos");
        RecomendacionesDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecomendacionesDocumentosActionPerformed(evt);
            }
        });
        jMenu1.add(RecomendacionesDocumentos);

        jMenuBar1.add(jMenu1);

        Iniciar_Sesion.setText("Iniciar Sesión");
        Iniciar_Sesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Iniciar_Sesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Iniciar_Sesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Iniciar_SesionMousePressed(evt);
            }
        });
        jMenuBar1.add(Iniciar_Sesion);

        Cerrar_Sesion.setText("Cerrar Sesión");
        Cerrar_Sesion.setEnabled(false);
        Cerrar_Sesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cerrar_Sesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Cerrar_Sesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Cerrar_SesionMousePressed(evt);
            }
        });
        jMenuBar1.add(Cerrar_Sesion);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Agregar_DocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar_DocumentoActionPerformed
        if(new ControladorUsuario().verificarTipoUsuario("2", biblioteca.Main.BibliotecaDigital.LOGGED_USER) ||
                new ControladorUsuario().verificarTipoUsuario("1", biblioteca.Main.BibliotecaDigital.LOGGED_USER)){
            
            new biblioteca.gui.GUICatalogacion(this).setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, "Esta opción solo está disponible para catalogadores", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Agregar_DocumentoActionPerformed

    private void Modificar_DocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Modificar_DocumentoActionPerformed
         if(new ControladorUsuario().verificarTipoUsuario("2", biblioteca.Main.BibliotecaDigital.LOGGED_USER) ||
                new ControladorUsuario().verificarTipoUsuario("1", biblioteca.Main.BibliotecaDigital.LOGGED_USER)){
            
            new biblioteca.gui.GUIModificacionDocumento(this).setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, "Esta opción solo está disponible para catalogadores", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Modificar_DocumentoActionPerformed

    private void EstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadisticasActionPerformed
       new biblioteca.gui.GUIEstadisticas(this).setVisible(true);
    }//GEN-LAST:event_EstadisticasActionPerformed

    private void RegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarseActionPerformed
        if(biblioteca.Main.BibliotecaDigital.LOGGED_USER.equals("dummyuser")){
           new biblioteca.gui.GUIRegistroUsuarios(this).setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, "Usted ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_RegistrarseActionPerformed

    private void Modificar_DatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Modificar_DatosActionPerformed
        if(!biblioteca.Main.BibliotecaDigital.LOGGED_USER.equals("dummyuser")){
            new biblioteca.gui.GUIModificarUsuario(this, false).setVisible(true);
        }
        else{
           JOptionPane.showMessageDialog(this, "Tiene que autenticarse para modificar sus datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Modificar_DatosActionPerformed

    private void GestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionActionPerformed
        if(new ControladorUsuario().verificarTipoUsuario("1", biblioteca.Main.BibliotecaDigital.LOGGED_USER)){
            new biblioteca.gui.GUIModificarUsuario(this, true).setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, "Esta opción solo está disponible para administradores", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_GestionActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        if(Texto_Busqueda.getText().equals("")|| Texto_Busqueda.getText() ==null){
            JOptionPane.showMessageDialog(this, "El texto de busqueda no puede estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
        } else{
            resultados = new ControladorDocumento().consultaDocumentoGeneral(Texto_Busqueda.getText());
            if(!resultados.isEmpty()){
                NoEditableTableModel modelo =new NoEditableTableModel();
                modelo.addColumn("Titulo");
            modelo.addColumn("Autores");
            for(int i=0;i<(int) resultados.size()/2;i++){
                String[] row = new String[2];
                row[0] =resultados.get(i*2+1);
                String autores="";
                ArrayList<Autor> obtenerAutores = new ControladorDocumento().obtenerAutores(resultados.get(i*2));
                for(int j=0;j<obtenerAutores.size();j++){
                    autores+=obtenerAutores.get(j).getNombre()+" "+obtenerAutores.get(j).getApellido();
                    if(j!=(obtenerAutores.size()-1))
                        autores+=", ";
                }
                row[1]=autores;
                modelo.addRow(row);
            }
            Resultados.setModel(modelo);
            this.getContentPane().add(jPanel2, "Center");
            this.getContentPane().invalidate();
            this.getContentPane().repaint();
            this.pack();
            this.setExtendedState(this.MAXIMIZED_BOTH);        
            }
                
            else
                JOptionPane.showMessageDialog(this, "La busqueda no ha retornado resultados", "Erorr", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BuscarActionPerformed

    private void CambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarActionPerformed
        this.setVisible(false);
        new GUIBusquedaAvanzada(this).setVisible(true);
    }//GEN-LAST:event_CambiarActionPerformed

    private void Iniciar_SesionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Iniciar_SesionMousePressed
        if(Iniciar_Sesion.isEnabled()){
            new biblioteca.gui.GUIAutenticacion(this).setVisible(true);
        }
    }//GEN-LAST:event_Iniciar_SesionMousePressed

    private void Cerrar_SesionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cerrar_SesionMousePressed
        if(Cerrar_Sesion.isEnabled()){
            new ControladorUsuario().actualizarUltimoAcceso(biblioteca.Main.BibliotecaDigital.LOGGED_USER);
            biblioteca.Main.BibliotecaDigital.LOGGED_USER="dummyuser";
            habilitarBotones(true);
            this.setTitle("Biblioteca Digital");
            JOptionPane.showMessageDialog(this, "Su sesión ha sido cerrada", "Notificación", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_Cerrar_SesionMousePressed

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
        int numeroSelecc=Resultados.getSelectedRow();
        if(numeroSelecc==-1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila", "Error", JOptionPane.ERROR_MESSAGE);
        } else{
            
            new biblioteca.gui.GUIInformacionDocumento(this, resultados.get(numeroSelecc*2)).setVisible(true);
        }
}//GEN-LAST:event_ConsultarActionPerformed

    private void ResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultadosMouseClicked
        if(evt.getClickCount()==2){
            int numeroSelecc=Resultados.getSelectedRow();
            new biblioteca.gui.GUIInformacionDocumento(this, resultados.get(numeroSelecc*2)).setVisible(true);
        }
    }//GEN-LAST:event_ResultadosMouseClicked

    private void RecomendacionesDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecomendacionesDocumentosActionPerformed
        if(!biblioteca.Main.BibliotecaDigital.LOGGED_USER.equals("dummyuser")){
            new GUIRecomendaciones(this).setVisible(true);
            this.setVisible(false);
        }
        else
            JOptionPane.showMessageDialog(this, "Debe ingresar al sistema para obtener sus recomendaciones", "Error", JOptionPane.ERROR_MESSAGE);
            
    }//GEN-LAST:event_RecomendacionesDocumentosActionPerformed

    public void habilitarBotones(boolean b){
        Iniciar_Sesion.setEnabled(b);
        Cerrar_Sesion.setEnabled(!b);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Agregar_Documento;
    private javax.swing.JMenu Archivo;
    private javax.swing.JMenu Autenticarse;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Cambiar;
    private javax.swing.JMenu Cerrar_Sesion;
    private javax.swing.JButton Consultar;
    private javax.swing.JMenuItem Estadisticas;
    private javax.swing.JMenuItem Gestion;
    private javax.swing.JMenu Iniciar_Sesion;
    private javax.swing.JMenuItem Modificar_Datos;
    private javax.swing.JMenuItem Modificar_Documento;
    private javax.swing.JMenuItem RecomendacionesDocumentos;
    private javax.swing.JMenuItem Registrarse;
    private javax.swing.JTable Resultados;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JTextField Texto_Busqueda;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}


class NoEditableTableModel extends DefaultTableModel {
    NoEditableTableModel(){
        super();
    }
    @Override
    public boolean isCellEditable(int row, int cols){
        return false;
    }
}