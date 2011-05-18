/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUIEstadisticas.java
 *
 * Created on 7/05/2011, 11:28:16 PM
 */
package biblioteca.gui;

import biblioteca.database2.beans.Area;
import biblioteca.database2.beans.Autor;
import biblioteca.database2.beans.TipoDocumento;
import biblioteca.database2.controladores.ControladorArea;
import biblioteca.database2.controladores.ControladorAutor;
import biblioteca.database2.controladores.ControladorTipoDocumento;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alejandro
 */
public class GUIEstadisticas extends javax.swing.JFrame {
    private ArrayList<Area> areasExistentes;
    private ArrayList<Autor> autoresExistentes;
    private ArrayList<TipoDocumento> tdExistentes;
    biblioteca.gui.GUIBusqueda parent;
    /** Creates new form GUIEstadisticas */
    public GUIEstadisticas(biblioteca.gui.GUIBusqueda parent) {
        initComponents();
        initAreas();
        initAutores();
        initTipoDocumento();
        this.parent=parent;
        this.setLocationRelativeTo(parent);
    }
    
    private void initAreas() {
        Documentos_Areas.removeAllItems();
        Catalogados_Areas.removeAllItems();
        Descargas_Areas.removeAllItems();
        areasExistentes= new ControladorArea().consultarTodasLasAreas();
        if(areasExistentes!=null){
            for(int i=1;i<areasExistentes.size();i++){
                Documentos_Areas.insertItemAt(areasExistentes.get(i).toString(), i-1);
                Catalogados_Areas.insertItemAt(areasExistentes.get(i).toString(), i-1);
                Descargas_Areas.insertItemAt(areasExistentes.get(i).toString(), i-1);
            }
            Documentos_Areas.setSelectedIndex(-1);
            Catalogados_Areas.setSelectedIndex(-1);
            Descargas_Areas.setSelectedIndex(-1);
        }
    }
    
    private void initAutores() {
        Documentos_Autor.removeAllItems();
        autoresExistentes = new ControladorAutor().obtenerTodosLosAutores();
        if(autoresExistentes!=null){
            for(int i=1;i<autoresExistentes.size();i++){
                Documentos_Autor.insertItemAt(autoresExistentes.get(i).toString(), i-1);
            }
        }
        Documentos_Autor.setSelectedIndex(-1);
    }
    
    private void initTipoDocumento() {
        Documentos_Tipo.removeAllItems();
        tdExistentes = new ControladorTipoDocumento().consultarTodosLosTipoDocumento();
        if(tdExistentes!=null){
            for(int i=1;i<tdExistentes.size();i++){
                Documentos_Tipo.insertItemAt(tdExistentes.get(i).getTipoDocumento(), i-1);
            }
        }
        Documentos_Tipo.setSelectedIndex(-1);
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

        Panel_Principal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Panel_Documentos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Documentos_Areas = new javax.swing.JComboBox();
        Documentos_Autor = new javax.swing.JComboBox();
        Documentos_Tipo = new javax.swing.JComboBox();
        Reporte_Documentos_Area = new javax.swing.JButton();
        Reporte_Documentos_Autor = new javax.swing.JButton();
        Reporte_Documento_Tipo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        Documento_Mes = new javax.swing.JComboBox();
        Reporte_Documento_Mes = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        Panel_Usuarios = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Reporte_Usuarios_Mes = new javax.swing.JButton();
        Usuarios_Mes = new javax.swing.JComboBox();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        Reporte_Usuarios_Tipo = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Reporte_Usuario_Areas = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        Panel_Documentos_Catalogados = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        Catalogados_Areas = new javax.swing.JComboBox();
        Reporte_Documentos_Area1 = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        Documentos_Autor1 = new javax.swing.JComboBox();
        Reporte_Documentos_Autor1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        Panel_Documentos_Descargados = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        Reporte_Documento_Descargados = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        Reporte_Usuarios_Descargas = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        Descargas_Areas = new javax.swing.JComboBox();
        Reporte_Descargas_Areas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        Panel_Principal.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 11));
        jLabel1.setText("Reporte de Usuarios existentes: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        Panel_Principal.add(jLabel1, gridBagConstraints);

        Panel_Documentos.setOpaque(false);
        Panel_Documentos.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Documentos por Área: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos.add(jLabel2, gridBagConstraints);

        jLabel5.setText("Documentos por Autor: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos.add(jLabel5, gridBagConstraints);

        jLabel6.setText("Documentos por Tipo: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos.add(jLabel6, gridBagConstraints);

        Documentos_Areas.setMinimumSize(new java.awt.Dimension(240, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        Panel_Documentos.add(Documentos_Areas, gridBagConstraints);

        Documentos_Autor.setMinimumSize(new java.awt.Dimension(240, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        Panel_Documentos.add(Documentos_Autor, gridBagConstraints);

        Documentos_Tipo.setMinimumSize(new java.awt.Dimension(240, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        Panel_Documentos.add(Documentos_Tipo, gridBagConstraints);

        Reporte_Documentos_Area.setText("Generar Reporte");
        Reporte_Documentos_Area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte_Documentos_AreaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 70, 5, 10);
        Panel_Documentos.add(Reporte_Documentos_Area, gridBagConstraints);

        Reporte_Documentos_Autor.setText("Generar Reporte");
        Reporte_Documentos_Autor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte_Documentos_AutorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 70, 5, 10);
        Panel_Documentos.add(Reporte_Documentos_Autor, gridBagConstraints);

        Reporte_Documento_Tipo.setText("Generar Reporte");
        Reporte_Documento_Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte_Documento_TipoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 70, 5, 10);
        Panel_Documentos.add(Reporte_Documento_Tipo, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 449;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Panel_Documentos.add(jSeparator1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 449;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Panel_Documentos.add(jSeparator2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 449;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Panel_Documentos.add(jSeparator7, gridBagConstraints);

        jLabel8.setText("Documentos más descargados por mes: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos.add(jLabel8, gridBagConstraints);

        Documento_Mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        Documento_Mes.setMinimumSize(new java.awt.Dimension(45, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        Panel_Documentos.add(Documento_Mes, gridBagConstraints);

        Reporte_Documento_Mes.setText("Generar Reporte");
        Reporte_Documento_Mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte_Documento_MesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 70, 5, 10);
        Panel_Documentos.add(Reporte_Documento_Mes, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        Panel_Principal.add(Panel_Documentos, gridBagConstraints);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        Panel_Principal.add(jSeparator3, gridBagConstraints);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        Panel_Principal.add(jSeparator4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        Panel_Principal.add(jSeparator5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        Panel_Principal.add(jSeparator6, gridBagConstraints);

        Panel_Usuarios.setLayout(new java.awt.GridBagLayout());

        jLabel7.setText("Usuarios registrados por mes: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Usuarios.add(jLabel7, gridBagConstraints);

        Reporte_Usuarios_Mes.setText("Generar Reporte");
        Reporte_Usuarios_Mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte_Usuarios_MesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 70, 5, 10);
        Panel_Usuarios.add(Reporte_Usuarios_Mes, gridBagConstraints);

        Usuarios_Mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        Usuarios_Mes.setMinimumSize(new java.awt.Dimension(45, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        Panel_Usuarios.add(Usuarios_Mes, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        Panel_Usuarios.add(jSeparator8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        Panel_Usuarios.add(jSeparator9, gridBagConstraints);

        jLabel9.setText("Total Usuarios Registrados por Tipo: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        Panel_Usuarios.add(jLabel9, gridBagConstraints);

        Reporte_Usuarios_Tipo.setText("Generar Reporte");
        Reporte_Usuarios_Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte_Usuarios_TipoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 70, 5, 10);
        Panel_Usuarios.add(Reporte_Usuarios_Tipo, gridBagConstraints);

        jLabel10.setText("jLabel10");
        Panel_Usuarios.add(jLabel10, new java.awt.GridBagConstraints());

        jLabel11.setText("Areas del conocimiento más seleccionadas: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        Panel_Usuarios.add(jLabel11, gridBagConstraints);

        Reporte_Usuario_Areas.setText("Generar Reporte");
        Reporte_Usuario_Areas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte_Usuario_AreasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 70, 5, 10);
        Panel_Usuarios.add(Reporte_Usuario_Areas, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        Panel_Principal.add(Panel_Usuarios, gridBagConstraints);

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 11));
        jLabel12.setText("Reporte de Documentos descargados: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        Panel_Principal.add(jLabel12, gridBagConstraints);

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        Panel_Principal.add(jSeparator10, gridBagConstraints);

        Panel_Documentos_Catalogados.setLayout(new java.awt.GridBagLayout());

        jLabel13.setText("Catalogados por Área: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos_Catalogados.add(jLabel13, gridBagConstraints);

        Catalogados_Areas.setMinimumSize(new java.awt.Dimension(240, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        Panel_Documentos_Catalogados.add(Catalogados_Areas, gridBagConstraints);

        Reporte_Documentos_Area1.setText("Generar Reporte");
        Reporte_Documentos_Area1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte_Documentos_Area1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 70, 5, 10);
        Panel_Documentos_Catalogados.add(Reporte_Documentos_Area1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        Panel_Documentos_Catalogados.add(jSeparator11, gridBagConstraints);

        jLabel15.setText("Catalogados por Mes: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos_Catalogados.add(jLabel15, gridBagConstraints);

        Documentos_Autor1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        Documentos_Autor1.setMinimumSize(new java.awt.Dimension(45, 24));
        Documentos_Autor1.setPreferredSize(new java.awt.Dimension(50, 26));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        Panel_Documentos_Catalogados.add(Documentos_Autor1, gridBagConstraints);

        Reporte_Documentos_Autor1.setText("Generar Reporte");
        Reporte_Documentos_Autor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte_Documentos_Autor1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 70, 5, 10);
        Panel_Documentos_Catalogados.add(Reporte_Documentos_Autor1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        Panel_Principal.add(Panel_Documentos_Catalogados, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 11));
        jLabel14.setText("Reporte de Documentos existentes: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        Panel_Principal.add(jLabel14, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        Panel_Principal.add(jSeparator12, gridBagConstraints);

        jLabel16.setFont(new java.awt.Font("Ubuntu", 1, 11));
        jLabel16.setText("Reporte de Documentos catalogados: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        Panel_Principal.add(jLabel16, gridBagConstraints);

        Panel_Documentos_Descargados.setLayout(new java.awt.GridBagLayout());

        jLabel17.setText("Documentos más descargados: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        Panel_Documentos_Descargados.add(jLabel17, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        Panel_Documentos_Descargados.add(jSeparator13, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        Panel_Documentos_Descargados.add(jSeparator14, gridBagConstraints);

        Reporte_Documento_Descargados.setText("Generar Reporte");
        Reporte_Documento_Descargados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte_Documento_DescargadosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 70, 5, 10);
        Panel_Documentos_Descargados.add(Reporte_Documento_Descargados, gridBagConstraints);

        jLabel18.setText("Usuarios con más descargas: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        Panel_Documentos_Descargados.add(jLabel18, gridBagConstraints);

        Reporte_Usuarios_Descargas.setText("Generar Reporte");
        Reporte_Usuarios_Descargas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte_Usuarios_DescargasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 70, 5, 10);
        Panel_Documentos_Descargados.add(Reporte_Usuarios_Descargas, gridBagConstraints);

        jLabel19.setText("Descargas por Área: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos_Descargados.add(jLabel19, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        Panel_Documentos_Descargados.add(Descargas_Areas, gridBagConstraints);

        Reporte_Descargas_Areas.setText("Generar Reporte");
        Reporte_Descargas_Areas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reporte_Descargas_AreasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 70, 5, 10);
        Panel_Documentos_Descargados.add(Reporte_Descargas_Areas, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        Panel_Principal.add(Panel_Documentos_Descargados, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(Panel_Principal, gridBagConstraints);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/gui/resources/logo.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 24));
        jLabel4.setText("Reportes y Estadisticas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Reporte_Documento_MesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte_Documento_MesActionPerformed
        unsupportedOperation();
    }//GEN-LAST:event_Reporte_Documento_MesActionPerformed

    private void Reporte_Usuarios_MesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte_Usuarios_MesActionPerformed
        unsupportedOperation();
    }//GEN-LAST:event_Reporte_Usuarios_MesActionPerformed

    private void Reporte_Documento_DescargadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte_Documento_DescargadosActionPerformed
        unsupportedOperation();
    }//GEN-LAST:event_Reporte_Documento_DescargadosActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void Reporte_Documentos_AreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte_Documentos_AreaActionPerformed
        unsupportedOperation();
    }//GEN-LAST:event_Reporte_Documentos_AreaActionPerformed

    private void Reporte_Documentos_AutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte_Documentos_AutorActionPerformed
        unsupportedOperation();
    }//GEN-LAST:event_Reporte_Documentos_AutorActionPerformed

    private void Reporte_Documento_TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte_Documento_TipoActionPerformed
        unsupportedOperation();
    }//GEN-LAST:event_Reporte_Documento_TipoActionPerformed

    private void Reporte_Documentos_Area1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte_Documentos_Area1ActionPerformed
        unsupportedOperation();
    }//GEN-LAST:event_Reporte_Documentos_Area1ActionPerformed

    private void Reporte_Documentos_Autor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte_Documentos_Autor1ActionPerformed
        unsupportedOperation();
    }//GEN-LAST:event_Reporte_Documentos_Autor1ActionPerformed

    private void Reporte_Usuarios_TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte_Usuarios_TipoActionPerformed
        unsupportedOperation();
    }//GEN-LAST:event_Reporte_Usuarios_TipoActionPerformed

    private void Reporte_Usuario_AreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte_Usuario_AreasActionPerformed
        unsupportedOperation();
    }//GEN-LAST:event_Reporte_Usuario_AreasActionPerformed

    private void Reporte_Usuarios_DescargasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte_Usuarios_DescargasActionPerformed
        unsupportedOperation();
    }//GEN-LAST:event_Reporte_Usuarios_DescargasActionPerformed

    private void Reporte_Descargas_AreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reporte_Descargas_AreasActionPerformed
        unsupportedOperation();
    }//GEN-LAST:event_Reporte_Descargas_AreasActionPerformed

    private void unsupportedOperation(){
        JOptionPane.showMessageDialog(this, "Esta operación aún no ha sido implementada", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Catalogados_Areas;
    private javax.swing.JComboBox Descargas_Areas;
    private javax.swing.JComboBox Documento_Mes;
    private javax.swing.JComboBox Documentos_Areas;
    private javax.swing.JComboBox Documentos_Autor;
    private javax.swing.JComboBox Documentos_Autor1;
    private javax.swing.JComboBox Documentos_Tipo;
    private javax.swing.JPanel Panel_Documentos;
    private javax.swing.JPanel Panel_Documentos_Catalogados;
    private javax.swing.JPanel Panel_Documentos_Descargados;
    private javax.swing.JPanel Panel_Principal;
    private javax.swing.JPanel Panel_Usuarios;
    private javax.swing.JButton Reporte_Descargas_Areas;
    private javax.swing.JButton Reporte_Documento_Descargados;
    private javax.swing.JButton Reporte_Documento_Mes;
    private javax.swing.JButton Reporte_Documento_Tipo;
    private javax.swing.JButton Reporte_Documentos_Area;
    private javax.swing.JButton Reporte_Documentos_Area1;
    private javax.swing.JButton Reporte_Documentos_Autor;
    private javax.swing.JButton Reporte_Documentos_Autor1;
    private javax.swing.JButton Reporte_Usuario_Areas;
    private javax.swing.JButton Reporte_Usuarios_Descargas;
    private javax.swing.JButton Reporte_Usuarios_Mes;
    private javax.swing.JButton Reporte_Usuarios_Tipo;
    private javax.swing.JComboBox Usuarios_Mes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
