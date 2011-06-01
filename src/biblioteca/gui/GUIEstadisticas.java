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
import biblioteca.database2.controladores.ControladorReportesEstadisticas;
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
        //this.setResizable(false);
    }
    
  private void initAreas() {
        AreasComboBoxPU.removeAllItems();
        AreasComboBoxPDE.removeAllItems();
        AreasComboBoxPDC.removeAllItems();
        AreasComboBoxPDD.removeAllItems();
        AreasComboBoxPDC1.removeAllItems();
        areasExistentes= new ControladorArea().consultarTodasLasAreas();
        AreasComboBoxPU.insertItemAt("Cualquiera", 0);
        AreasComboBoxPDE.insertItemAt("Cualquiera", 0);
        AreasComboBoxPDC.insertItemAt("Cualquiera", 0);
        AreasComboBoxPDD.insertItemAt("Cualquiera", 0);
        AreasComboBoxPDC1.insertItemAt("Cualquiera", 0);
        if(areasExistentes!=null){
            for(int i=0;i<areasExistentes.size();i++){
                AreasComboBoxPU.insertItemAt(areasExistentes.get(i).toString(), i+1);
                AreasComboBoxPDE.insertItemAt(areasExistentes.get(i).toString(), i+1);
                AreasComboBoxPDC.insertItemAt(areasExistentes.get(i).toString(), i+1);
                AreasComboBoxPDD.insertItemAt(areasExistentes.get(i).toString(), i+1);
                AreasComboBoxPDC1.insertItemAt(areasExistentes.get(i).toString(), i+1);
            }
        }
         AreasComboBoxPU.setSelectedIndex(0);
         AreasComboBoxPDE.setSelectedIndex(0);
         AreasComboBoxPDC.setSelectedIndex(0);
         AreasComboBoxPDD.setSelectedIndex(0);
         AreasComboBoxPDC1.setSelectedIndex(0);
    }
    
  private void initAutores() {
        AutorComboBoxPDE.removeAllItems();
        AutorComboBoxPDC.removeAllItems();
        AutorComboBoxPDD.removeAllItems();
        AutorComboBoxPDC1.removeAllItems();
        AutorComboBoxPDE.insertItemAt("Cualquiera",0);
        AutorComboBoxPDC.insertItemAt("Cualquiera", 0);
        AutorComboBoxPDD.insertItemAt("Cualquiera", 0);
        AutorComboBoxPDC1.insertItemAt("Cualquiera", 0);
        autoresExistentes = new ControladorAutor().obtenerTodosLosAutores();
        if(autoresExistentes!=null){
            for(int i=0;i<autoresExistentes.size();i++){
                AutorComboBoxPDE.insertItemAt(autoresExistentes.get(i).toString(), i+1);
                AutorComboBoxPDC.insertItemAt(autoresExistentes.get(i).toString(), i+1);
                AutorComboBoxPDD.insertItemAt(autoresExistentes.get(i).toString(), i+1);
                AutorComboBoxPDC1.insertItemAt(autoresExistentes.get(i).toString(), i+1);
            }
        }
        AutorComboBoxPDE.setSelectedIndex(0);
        AutorComboBoxPDC.setSelectedIndex(0);
        AutorComboBoxPDD.setSelectedIndex(0);
        AutorComboBoxPDC1.setSelectedIndex(0);
    }
  
  private void initTipoDocumento() {
        DocTipoComboBoxPDE.removeAllItems();
        DocTipoComboBoxPDC.removeAllItems();
        DocTipoComboBoxPDD.removeAllItems();
        DocTipoComboBoxPDC1.removeAllItems();
        DocTipoComboBoxPDE.insertItemAt("Cualquiera", 0);
        DocTipoComboBoxPDC.insertItemAt("Cualquiera", 0);
        DocTipoComboBoxPDD.insertItemAt("Cualquiera", 0);
        DocTipoComboBoxPDC1.insertItemAt("Cualquiera", 0);
        tdExistentes = new ControladorTipoDocumento().consultarTodosLosTipoDocumento();
        if(tdExistentes!=null){
            for(int i=0;i<tdExistentes.size();i++){
                DocTipoComboBoxPDE.insertItemAt(tdExistentes.get(i).getTipoDocumento(), i+1);
                DocTipoComboBoxPDC.insertItemAt(tdExistentes.get(i).getTipoDocumento(), i+1);
                DocTipoComboBoxPDD.insertItemAt(tdExistentes.get(i).getTipoDocumento(), i+1);
                DocTipoComboBoxPDC1.insertItemAt(tdExistentes.get(i).getTipoDocumento(), i+1);
            }
        }
        DocTipoComboBoxPDE.setSelectedIndex(0);
        DocTipoComboBoxPDC.setSelectedIndex(0);
        DocTipoComboBoxPDD.setSelectedIndex(0);
        DocTipoComboBoxPDC1.setSelectedIndex(0);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        Panel_Usuarios = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jComboBox9 = new javax.swing.JComboBox();
        jComboBox10 = new javax.swing.JComboBox();
        jComboBox11 = new javax.swing.JComboBox();
        jComboBox12 = new javax.swing.JComboBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jComboBox13 = new javax.swing.JComboBox();
        jComboBox14 = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jCheckBox9 = new javax.swing.JCheckBox();
        jComboBox15 = new javax.swing.JComboBox();
        jComboBox16 = new javax.swing.JComboBox();
        jComboBox17 = new javax.swing.JComboBox();
        jComboBox18 = new javax.swing.JComboBox();
        jComboBox19 = new javax.swing.JComboBox();
        jComboBox20 = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        jComboBox23 = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jComboBox24 = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        jComboBox25 = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jComboBox26 = new javax.swing.JComboBox();
        AreasComboBoxPU = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Panel_Documentos2 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        AreasComboBoxPDE = new javax.swing.JComboBox();
        AutorComboBoxPDE = new javax.swing.JComboBox();
        DocTipoComboBoxPDE = new javax.swing.JComboBox();
        jLabel55 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jComboBox68 = new javax.swing.JComboBox();
        jLabel57 = new javax.swing.JLabel();
        jCheckBox29 = new javax.swing.JCheckBox();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jComboBox69 = new javax.swing.JComboBox();
        jComboBox70 = new javax.swing.JComboBox();
        jComboBox71 = new javax.swing.JComboBox();
        jComboBox72 = new javax.swing.JComboBox();
        jComboBox73 = new javax.swing.JComboBox();
        jComboBox74 = new javax.swing.JComboBox();
        jLabel60 = new javax.swing.JLabel();
        jComboBox75 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Panel_Documentos_Catalogados1 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jCheckBox31 = new javax.swing.JCheckBox();
        jComboBox76 = new javax.swing.JComboBox();
        jCheckBox32 = new javax.swing.JCheckBox();
        jCheckBox33 = new javax.swing.JCheckBox();
        jComboBox77 = new javax.swing.JComboBox();
        jCheckBox34 = new javax.swing.JCheckBox();
        jComboBox78 = new javax.swing.JComboBox();
        jCheckBox35 = new javax.swing.JCheckBox();
        jCheckBox36 = new javax.swing.JCheckBox();
        jLabel63 = new javax.swing.JLabel();
        jComboBox79 = new javax.swing.JComboBox();
        jComboBox80 = new javax.swing.JComboBox();
        jLabel64 = new javax.swing.JLabel();
        jComboBox81 = new javax.swing.JComboBox();
        jCheckBox37 = new javax.swing.JCheckBox();
        jLabel65 = new javax.swing.JLabel();
        jComboBox82 = new javax.swing.JComboBox();
        jComboBox83 = new javax.swing.JComboBox();
        jComboBox84 = new javax.swing.JComboBox();
        jComboBox87 = new javax.swing.JComboBox();
        jComboBox88 = new javax.swing.JComboBox();
        jComboBox89 = new javax.swing.JComboBox();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jComboBox90 = new javax.swing.JComboBox();
        jLabel68 = new javax.swing.JLabel();
        AreasComboBoxPDC = new javax.swing.JComboBox();
        jLabel69 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        AutorComboBoxPDC = new javax.swing.JComboBox();
        DocTipoComboBoxPDC = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        Panel_Documentos_Descargados1 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        AreasComboBoxPDD = new javax.swing.JComboBox();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jComboBox93 = new javax.swing.JComboBox();
        jComboBox94 = new javax.swing.JComboBox();
        jComboBox95 = new javax.swing.JComboBox();
        jComboBox96 = new javax.swing.JComboBox();
        jComboBox98 = new javax.swing.JComboBox();
        jComboBox100 = new javax.swing.JComboBox();
        jComboBox101 = new javax.swing.JComboBox();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jCheckBox39 = new javax.swing.JCheckBox();
        jLabel75 = new javax.swing.JLabel();
        jComboBox102 = new javax.swing.JComboBox();
        jComboBox103 = new javax.swing.JComboBox();
        jLabel76 = new javax.swing.JLabel();
        jCheckBox40 = new javax.swing.JCheckBox();
        jCheckBox41 = new javax.swing.JCheckBox();
        jComboBox104 = new javax.swing.JComboBox();
        jComboBox105 = new javax.swing.JComboBox();
        jCheckBox42 = new javax.swing.JCheckBox();
        jCheckBox43 = new javax.swing.JCheckBox();
        jComboBox106 = new javax.swing.JComboBox();
        jComboBox107 = new javax.swing.JComboBox();
        jCheckBox44 = new javax.swing.JCheckBox();
        jLabel77 = new javax.swing.JLabel();
        jCheckBox45 = new javax.swing.JCheckBox();
        jLabel78 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        AutorComboBoxPDD = new javax.swing.JComboBox();
        DocTipoComboBoxPDD = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        Panel_Documentos_Catalogados2 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jCheckBox38 = new javax.swing.JCheckBox();
        jComboBox85 = new javax.swing.JComboBox();
        jCheckBox46 = new javax.swing.JCheckBox();
        jCheckBox47 = new javax.swing.JCheckBox();
        jComboBox86 = new javax.swing.JComboBox();
        jCheckBox48 = new javax.swing.JCheckBox();
        jComboBox91 = new javax.swing.JComboBox();
        jCheckBox49 = new javax.swing.JCheckBox();
        jCheckBox50 = new javax.swing.JCheckBox();
        jLabel82 = new javax.swing.JLabel();
        jComboBox92 = new javax.swing.JComboBox();
        jComboBox97 = new javax.swing.JComboBox();
        jLabel83 = new javax.swing.JLabel();
        jComboBox99 = new javax.swing.JComboBox();
        jCheckBox51 = new javax.swing.JCheckBox();
        jLabel84 = new javax.swing.JLabel();
        jComboBox108 = new javax.swing.JComboBox();
        jComboBox109 = new javax.swing.JComboBox();
        jComboBox110 = new javax.swing.JComboBox();
        jComboBox111 = new javax.swing.JComboBox();
        jComboBox112 = new javax.swing.JComboBox();
        jComboBox113 = new javax.swing.JComboBox();
        jLabel85 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        AreasComboBoxPDC1 = new javax.swing.JComboBox();
        jLabel88 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        AutorComboBoxPDC1 = new javax.swing.JComboBox();
        DocTipoComboBoxPDC1 = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(650, 750));

        Panel_Usuarios.setLayout(new java.awt.GridBagLayout());

        jLabel11.setText("Fecha de Registro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Usuarios.add(jLabel11, gridBagConstraints);

        jLabel12.setText("Por Interes a Áreas de Conocimiento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Usuarios.add(jLabel12, gridBagConstraints);

        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Cualquiera");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        Panel_Usuarios.add(jCheckBox3, gridBagConstraints);

        jCheckBox4.setText("Por dia de la Semana:");
        jCheckBox4.setEnabled(false);
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        Panel_Usuarios.add(jCheckBox4, gridBagConstraints);

        jCheckBox5.setText("Por dia del Mes");
        jCheckBox5.setEnabled(false);
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        Panel_Usuarios.add(jCheckBox5, gridBagConstraints);

        jCheckBox6.setText("Por Mes:");
        jCheckBox6.setEnabled(false);
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        Panel_Usuarios.add(jCheckBox6, gridBagConstraints);

        jCheckBox7.setText("Por Año:");
        jCheckBox7.setEnabled(false);
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        Panel_Usuarios.add(jCheckBox7, gridBagConstraints);

        jComboBox9.setMaximumRowCount(7);
        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));
        jComboBox9.setEnabled(false);
        jComboBox9.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        Panel_Usuarios.add(jComboBox9, gridBagConstraints);

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox10.setEnabled(false);
        jComboBox10.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        Panel_Usuarios.add(jComboBox10, gridBagConstraints);

        jComboBox11.setMaximumRowCount(12);
        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBox11.setEnabled(false);
        jComboBox11.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        Panel_Usuarios.add(jComboBox11, gridBagConstraints);

        jComboBox12.setMaximumRowCount(3);
        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2011", "2010", "2009" }));
        jComboBox12.setEnabled(false);
        jComboBox12.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        Panel_Usuarios.add(jComboBox12, gridBagConstraints);

        jCheckBox8.setText("Por Franja Horaria:");
        jCheckBox8.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        Panel_Usuarios.add(jCheckBox8, gridBagConstraints);

        jLabel24.setText("Desde:");
        jLabel24.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        Panel_Usuarios.add(jLabel24, gridBagConstraints);

        jLabel25.setText("Hasta:");
        jLabel25.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        Panel_Usuarios.add(jLabel25, gridBagConstraints);

        jComboBox13.setMaximumRowCount(12);
        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));
        jComboBox13.setEnabled(false);
        jComboBox13.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Usuarios.add(jComboBox13, gridBagConstraints);

        jComboBox14.setMaximumRowCount(12);
        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));
        jComboBox14.setEnabled(false);
        jComboBox14.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Usuarios.add(jComboBox14, gridBagConstraints);

        jLabel26.setText("Desde:");
        jLabel26.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        Panel_Usuarios.add(jLabel26, gridBagConstraints);

        jLabel27.setText("Hasta:");
        jLabel27.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        Panel_Usuarios.add(jLabel27, gridBagConstraints);

        jCheckBox9.setText("Intervalo de Tiempo");
        jCheckBox9.setEnabled(false);
        jCheckBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox9ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        Panel_Usuarios.add(jCheckBox9, gridBagConstraints);

        jComboBox15.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox15.setEnabled(false);
        jComboBox15.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 2);
        Panel_Usuarios.add(jComboBox15, gridBagConstraints);

        jComboBox16.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox16.setEnabled(false);
        jComboBox16.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 2);
        Panel_Usuarios.add(jComboBox16, gridBagConstraints);

        jComboBox17.setMaximumRowCount(12);
        jComboBox17.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBox17.setEnabled(false);
        jComboBox17.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Usuarios.add(jComboBox17, gridBagConstraints);

        jComboBox18.setMaximumRowCount(12);
        jComboBox18.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBox18.setEnabled(false);
        jComboBox18.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Usuarios.add(jComboBox18, gridBagConstraints);

        jComboBox19.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2011", "2010", "2009" }));
        jComboBox19.setEnabled(false);
        jComboBox19.setPreferredSize(new java.awt.Dimension(50, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Usuarios.add(jComboBox19, gridBagConstraints);

        jComboBox20.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2011", "2010", "2009" }));
        jComboBox20.setEnabled(false);
        jComboBox20.setPreferredSize(new java.awt.Dimension(50, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Usuarios.add(jComboBox20, gridBagConstraints);

        jLabel28.setText("Por Tipo de Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Usuarios.add(jLabel28, gridBagConstraints);

        jComboBox23.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cualquiera", "Usuario Normal", "Usuario Catalogador" }));
        jComboBox23.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Usuarios.add(jComboBox23, gridBagConstraints);

        jLabel29.setText("Por Genero:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Usuarios.add(jLabel29, gridBagConstraints);

        jComboBox24.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cualquiera", "Activa", "Inactiva" }));
        jComboBox24.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Usuarios.add(jComboBox24, gridBagConstraints);

        jLabel30.setText("Por Edad:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Usuarios.add(jLabel30, gridBagConstraints);

        jComboBox25.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cualquiera", "Menores de 18 años", "Entre 18 y 25 años", "Entre 25 y 35 años", "Mayores de 35 años" }));
        jComboBox25.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Usuarios.add(jComboBox25, gridBagConstraints);

        jLabel13.setText("Por Estado de Cuenta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Usuarios.add(jLabel13, gridBagConstraints);

        jComboBox26.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cualquiera", "Masculino", "Femenino" }));
        jComboBox26.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Usuarios.add(jComboBox26, gridBagConstraints);

        AreasComboBoxPU.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Usuarios.add(AreasComboBoxPU, gridBagConstraints);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/gui/resources/logo.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Panel_Usuarios.add(jLabel14, gridBagConstraints);

        jLabel15.setFont(new java.awt.Font("Ubuntu", 1, 24));
        jLabel15.setText("Reportes ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        Panel_Usuarios.add(jLabel15, gridBagConstraints);

        jLabel80.setFont(new java.awt.Font("Ubuntu", 1, 11));
        jLabel80.setText("Reporte de Usuarios Registrados: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Usuarios.add(jLabel80, gridBagConstraints);

        jButton1.setText("Generar Reportes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        Panel_Usuarios.add(jButton1, gridBagConstraints);

        jPanel1.add(Panel_Usuarios);

        jTabbedPane1.addTab("Usuarios Registrados", jPanel1);

        Panel_Documentos2.setOpaque(false);
        Panel_Documentos2.setLayout(new java.awt.GridBagLayout());

        jLabel52.setText("Documentos por Área: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos2.add(jLabel52, gridBagConstraints);

        jLabel53.setText("Documentos por Autor: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos2.add(jLabel53, gridBagConstraints);

        jLabel54.setText("Documentos por Tipo: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos2.add(jLabel54, gridBagConstraints);

        AreasComboBoxPDE.setMinimumSize(new java.awt.Dimension(240, 24));
        AreasComboBoxPDE.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        Panel_Documentos2.add(AreasComboBoxPDE, gridBagConstraints);

        AutorComboBoxPDE.setMinimumSize(new java.awt.Dimension(240, 24));
        AutorComboBoxPDE.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        Panel_Documentos2.add(AutorComboBoxPDE, gridBagConstraints);

        DocTipoComboBoxPDE.setMinimumSize(new java.awt.Dimension(240, 24));
        DocTipoComboBoxPDE.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        Panel_Documentos2.add(DocTipoComboBoxPDE, gridBagConstraints);

        jLabel55.setText("Editorial:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos2.add(jLabel55, gridBagConstraints);

        jTextField5.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        Panel_Documentos2.add(jTextField5, gridBagConstraints);

        jLabel56.setText("Idioma:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos2.add(jLabel56, gridBagConstraints);

        jComboBox68.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cualquiera", "Español", "Inglés", "Francés", "Aleman", "Portugués", "Otro" }));
        jComboBox68.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        Panel_Documentos2.add(jComboBox68, gridBagConstraints);

        jLabel57.setText("Fecha de Publicación: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos2.add(jLabel57, gridBagConstraints);

        jCheckBox29.setSelected(true);
        jCheckBox29.setText("Cualquiera");
        jCheckBox29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox29ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        Panel_Documentos2.add(jCheckBox29, gridBagConstraints);

        jLabel58.setText("Desde:");
        jLabel58.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        Panel_Documentos2.add(jLabel58, gridBagConstraints);

        jLabel59.setText("Hasta:");
        jLabel59.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        Panel_Documentos2.add(jLabel59, gridBagConstraints);

        jComboBox69.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox69.setEnabled(false);
        jComboBox69.setPreferredSize(new java.awt.Dimension(50, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        Panel_Documentos2.add(jComboBox69, gridBagConstraints);

        jComboBox70.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox70.setEnabled(false);
        jComboBox70.setPreferredSize(new java.awt.Dimension(50, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        Panel_Documentos2.add(jComboBox70, gridBagConstraints);

        jComboBox71.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBox71.setEnabled(false);
        jComboBox71.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        Panel_Documentos2.add(jComboBox71, gridBagConstraints);

        jComboBox72.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBox72.setEnabled(false);
        jComboBox72.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        Panel_Documentos2.add(jComboBox72, gridBagConstraints);

        jComboBox73.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2011", "2010. 2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950" }));
        jComboBox73.setEnabled(false);
        jComboBox73.setPreferredSize(new java.awt.Dimension(50, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        Panel_Documentos2.add(jComboBox73, gridBagConstraints);

        jComboBox74.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2011", "2010. 2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950" }));
        jComboBox74.setEnabled(false);
        jComboBox74.setPreferredSize(new java.awt.Dimension(50, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        Panel_Documentos2.add(jComboBox74, gridBagConstraints);

        jLabel60.setText("Documentos por Estado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos2.add(jLabel60, gridBagConstraints);

        jComboBox75.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cualquiera", "Activo", "Inactivo" }));
        jComboBox75.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        Panel_Documentos2.add(jComboBox75, gridBagConstraints);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/gui/resources/logo.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Panel_Documentos2.add(jLabel9, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 24));
        jLabel10.setText("Reportes ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        Panel_Documentos2.add(jLabel10, gridBagConstraints);

        jLabel79.setFont(new java.awt.Font("Ubuntu", 1, 11));
        jLabel79.setText("Reporte de Documentos Existentes: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos2.add(jLabel79, gridBagConstraints);

        jButton2.setText("Generar Reportes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        Panel_Documentos2.add(jButton2, gridBagConstraints);

        jPanel2.add(Panel_Documentos2);

        jTabbedPane1.addTab("Documentos Existentes", jPanel2);

        Panel_Documentos_Catalogados1.setLayout(new java.awt.GridBagLayout());

        jLabel61.setText("Fecha de Consulta:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos_Catalogados1.add(jLabel61, gridBagConstraints);

        jCheckBox31.setSelected(true);
        jCheckBox31.setText("Cualquiera");
        jCheckBox31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox31ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Catalogados1.add(jCheckBox31, gridBagConstraints);

        jComboBox76.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));
        jComboBox76.setEnabled(false);
        jComboBox76.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Catalogados1.add(jComboBox76, gridBagConstraints);

        jCheckBox32.setText("Por dia de la Semana:");
        jCheckBox32.setEnabled(false);
        jCheckBox32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox32ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        Panel_Documentos_Catalogados1.add(jCheckBox32, gridBagConstraints);

        jCheckBox33.setText("Por dia del Mes");
        jCheckBox33.setEnabled(false);
        jCheckBox33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox33ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        Panel_Documentos_Catalogados1.add(jCheckBox33, gridBagConstraints);

        jComboBox77.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox77.setEnabled(false);
        jComboBox77.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Catalogados1.add(jComboBox77, gridBagConstraints);

        jCheckBox34.setText("Por Mes:");
        jCheckBox34.setEnabled(false);
        jCheckBox34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox34ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        Panel_Documentos_Catalogados1.add(jCheckBox34, gridBagConstraints);

        jComboBox78.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBox78.setEnabled(false);
        jComboBox78.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Catalogados1.add(jComboBox78, gridBagConstraints);

        jCheckBox35.setText("Por Año:");
        jCheckBox35.setEnabled(false);
        jCheckBox35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox35ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        Panel_Documentos_Catalogados1.add(jCheckBox35, gridBagConstraints);

        jCheckBox36.setText("Por Franja Horaria:");
        jCheckBox36.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos_Catalogados1.add(jCheckBox36, gridBagConstraints);

        jLabel63.setText("Desde:");
        jLabel63.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Catalogados1.add(jLabel63, gridBagConstraints);

        jComboBox79.setMaximumRowCount(12);
        jComboBox79.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));
        jComboBox79.setEnabled(false);
        jComboBox79.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Catalogados1.add(jComboBox79, gridBagConstraints);

        jComboBox80.setMaximumRowCount(12);
        jComboBox80.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));
        jComboBox80.setEnabled(false);
        jComboBox80.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Catalogados1.add(jComboBox80, gridBagConstraints);

        jLabel64.setText("Hasta:");
        jLabel64.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Catalogados1.add(jLabel64, gridBagConstraints);

        jComboBox81.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2011", "2010", "2009" }));
        jComboBox81.setEnabled(false);
        jComboBox81.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Catalogados1.add(jComboBox81, gridBagConstraints);

        jCheckBox37.setText("Intervalo de Tiempo");
        jCheckBox37.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos_Catalogados1.add(jCheckBox37, gridBagConstraints);

        jLabel65.setText("Desde:");
        jLabel65.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Catalogados1.add(jLabel65, gridBagConstraints);

        jComboBox82.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox82.setEnabled(false);
        jComboBox82.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Catalogados1.add(jComboBox82, gridBagConstraints);

        jComboBox83.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBox83.setEnabled(false);
        jComboBox83.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Catalogados1.add(jComboBox83, gridBagConstraints);

        jComboBox84.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2011", "2010", "2009" }));
        jComboBox84.setEnabled(false);
        jComboBox84.setPreferredSize(new java.awt.Dimension(50, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Catalogados1.add(jComboBox84, gridBagConstraints);

        jComboBox87.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2011", "2010", "2009" }));
        jComboBox87.setEnabled(false);
        jComboBox87.setPreferredSize(new java.awt.Dimension(50, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Catalogados1.add(jComboBox87, gridBagConstraints);

        jComboBox88.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBox88.setEnabled(false);
        jComboBox88.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Catalogados1.add(jComboBox88, gridBagConstraints);

        jComboBox89.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox89.setEnabled(false);
        jComboBox89.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Catalogados1.add(jComboBox89, gridBagConstraints);

        jLabel66.setText("Hasta:");
        jLabel66.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Catalogados1.add(jLabel66, gridBagConstraints);

        jLabel67.setText("Por Tipo de Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Catalogados1.add(jLabel67, gridBagConstraints);

        jComboBox90.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cualquiera", "Usuario Normal", "Usuario Catalogador" }));
        jComboBox90.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Catalogados1.add(jComboBox90, gridBagConstraints);

        jLabel68.setText("Por Áreas de Conocimiento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Catalogados1.add(jLabel68, gridBagConstraints);

        AreasComboBoxPDC.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Catalogados1.add(AreasComboBoxPDC, gridBagConstraints);

        jLabel69.setText("Por un Usuario Particular:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Catalogados1.add(jLabel69, gridBagConstraints);

        jTextField6.setEditable(false);
        jTextField6.setText("Digite su Username");
        jTextField6.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField6.setEnabled(false);
        jTextField6.setPreferredSize(new java.awt.Dimension(110, 20));
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Catalogados1.add(jTextField6, gridBagConstraints);

        jLabel62.setFont(new java.awt.Font("Ubuntu", 1, 11));
        jLabel62.setText("Reporte de Documentos Consultados: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos_Catalogados1.add(jLabel62, gridBagConstraints);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/gui/resources/logo.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Panel_Documentos_Catalogados1.add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 24));
        jLabel8.setText("Reportes ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        Panel_Documentos_Catalogados1.add(jLabel8, gridBagConstraints);

        jLabel3.setText("Por Autor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Catalogados1.add(jLabel3, gridBagConstraints);

        AutorComboBoxPDC.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Catalogados1.add(AutorComboBoxPDC, gridBagConstraints);

        DocTipoComboBoxPDC.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Catalogados1.add(DocTipoComboBoxPDC, gridBagConstraints);

        jLabel4.setText("Por Tipo de Documento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Catalogados1.add(jLabel4, gridBagConstraints);

        jButton3.setText("Generar Reportes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        Panel_Documentos_Catalogados1.add(jButton3, gridBagConstraints);

        jPanel3.add(Panel_Documentos_Catalogados1);

        jTabbedPane1.addTab("Documentos Consultados", jPanel3);

        Panel_Documentos_Descargados1.setLayout(new java.awt.GridBagLayout());

        jLabel70.setText("Por un Usuario Particular:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Descargados1.add(jLabel70, gridBagConstraints);

        jTextField7.setEditable(false);
        jTextField7.setText("Digite su Username");
        jTextField7.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField7.setPreferredSize(new java.awt.Dimension(110, 20));
        jTextField7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField7MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Descargados1.add(jTextField7, gridBagConstraints);

        AreasComboBoxPDD.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Descargados1.add(AreasComboBoxPDD, gridBagConstraints);

        jLabel71.setText("Por Áreas de Conocimiento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Descargados1.add(jLabel71, gridBagConstraints);

        jLabel72.setText("Por Tipo de Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Descargados1.add(jLabel72, gridBagConstraints);

        jComboBox93.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cualquiera", "Usuario Normal", "Usuario Catalogador" }));
        jComboBox93.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Descargados1.add(jComboBox93, gridBagConstraints);

        jComboBox94.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox94.setEnabled(false);
        jComboBox94.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Descargados1.add(jComboBox94, gridBagConstraints);

        jComboBox95.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBox95.setEnabled(false);
        jComboBox95.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Descargados1.add(jComboBox95, gridBagConstraints);

        jComboBox96.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2011", "2010", "2009" }));
        jComboBox96.setEnabled(false);
        jComboBox96.setPreferredSize(new java.awt.Dimension(50, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Descargados1.add(jComboBox96, gridBagConstraints);

        jComboBox98.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2011", "2010", "2009" }));
        jComboBox98.setEnabled(false);
        jComboBox98.setPreferredSize(new java.awt.Dimension(50, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Descargados1.add(jComboBox98, gridBagConstraints);

        jComboBox100.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBox100.setEnabled(false);
        jComboBox100.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Descargados1.add(jComboBox100, gridBagConstraints);

        jComboBox101.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox101.setEnabled(false);
        jComboBox101.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Descargados1.add(jComboBox101, gridBagConstraints);

        jLabel73.setText("Desde:");
        jLabel73.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Descargados1.add(jLabel73, gridBagConstraints);

        jLabel74.setText("Hasta:");
        jLabel74.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Descargados1.add(jLabel74, gridBagConstraints);

        jCheckBox39.setText("Intervalo de Tiempo");
        jCheckBox39.setEnabled(false);
        jCheckBox39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox39ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        Panel_Documentos_Descargados1.add(jCheckBox39, gridBagConstraints);

        jLabel75.setText("Hasta:");
        jLabel75.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Descargados1.add(jLabel75, gridBagConstraints);

        jComboBox102.setMaximumRowCount(12);
        jComboBox102.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));
        jComboBox102.setEnabled(false);
        jComboBox102.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Descargados1.add(jComboBox102, gridBagConstraints);

        jComboBox103.setMaximumRowCount(12);
        jComboBox103.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));
        jComboBox103.setEnabled(false);
        jComboBox103.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Descargados1.add(jComboBox103, gridBagConstraints);

        jLabel76.setText("Desde:");
        jLabel76.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Descargados1.add(jLabel76, gridBagConstraints);

        jCheckBox40.setText("Por Franja Horaria:");
        jCheckBox40.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        Panel_Documentos_Descargados1.add(jCheckBox40, gridBagConstraints);

        jCheckBox41.setText("Por Año:");
        jCheckBox41.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        Panel_Documentos_Descargados1.add(jCheckBox41, gridBagConstraints);

        jComboBox104.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2011", "2010", "2009" }));
        jComboBox104.setEnabled(false);
        jComboBox104.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        Panel_Documentos_Descargados1.add(jComboBox104, gridBagConstraints);

        jComboBox105.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBox105.setEnabled(false);
        jComboBox105.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        Panel_Documentos_Descargados1.add(jComboBox105, gridBagConstraints);

        jCheckBox42.setText("Por Mes:");
        jCheckBox42.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        Panel_Documentos_Descargados1.add(jCheckBox42, gridBagConstraints);

        jCheckBox43.setText("Por dia del Mes");
        jCheckBox43.setEnabled(false);
        jCheckBox43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox43ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        Panel_Documentos_Descargados1.add(jCheckBox43, gridBagConstraints);

        jComboBox106.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox106.setEnabled(false);
        jComboBox106.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        Panel_Documentos_Descargados1.add(jComboBox106, gridBagConstraints);

        jComboBox107.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));
        jComboBox107.setEnabled(false);
        jComboBox107.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        Panel_Documentos_Descargados1.add(jComboBox107, gridBagConstraints);

        jCheckBox44.setText("Por dia de la Semana:");
        jCheckBox44.setEnabled(false);
        jCheckBox44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox44ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        Panel_Documentos_Descargados1.add(jCheckBox44, gridBagConstraints);

        jLabel77.setText("Fecha de Descarga:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos_Descargados1.add(jLabel77, gridBagConstraints);

        jCheckBox45.setSelected(true);
        jCheckBox45.setText("Cualquiera");
        jCheckBox45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox45ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        Panel_Documentos_Descargados1.add(jCheckBox45, gridBagConstraints);

        jLabel78.setFont(new java.awt.Font("Ubuntu", 1, 11));
        jLabel78.setText("Reporte de Documentos Descargados: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos_Descargados1.add(jLabel78, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 24));
        jLabel6.setText("Reportes ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        Panel_Documentos_Descargados1.add(jLabel6, gridBagConstraints);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/gui/resources/logo.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Panel_Documentos_Descargados1.add(jLabel5, gridBagConstraints);

        jLabel1.setText("Por Autor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Descargados1.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Por Tipo de Documento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Descargados1.add(jLabel2, gridBagConstraints);

        AutorComboBoxPDD.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Descargados1.add(AutorComboBoxPDD, gridBagConstraints);

        DocTipoComboBoxPDD.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Descargados1.add(DocTipoComboBoxPDD, gridBagConstraints);

        jButton4.setText("Generar Reportes");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        Panel_Documentos_Descargados1.add(jButton4, gridBagConstraints);

        jPanel4.add(Panel_Documentos_Descargados1);

        jTabbedPane1.addTab("Documentos Descargados", jPanel4);

        Panel_Documentos_Catalogados2.setLayout(new java.awt.GridBagLayout());

        jLabel81.setText("Fecha de Catalogación:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos_Catalogados2.add(jLabel81, gridBagConstraints);

        jCheckBox38.setSelected(true);
        jCheckBox38.setText("Cualquiera");
        jCheckBox38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox38ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Catalogados2.add(jCheckBox38, gridBagConstraints);

        jComboBox85.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));
        jComboBox85.setEnabled(false);
        jComboBox85.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Catalogados2.add(jComboBox85, gridBagConstraints);

        jCheckBox46.setText("Por dia de la Semana:");
        jCheckBox46.setEnabled(false);
        jCheckBox46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox46ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        Panel_Documentos_Catalogados2.add(jCheckBox46, gridBagConstraints);

        jCheckBox47.setText("Por dia del Mes");
        jCheckBox47.setEnabled(false);
        jCheckBox47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox47ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        Panel_Documentos_Catalogados2.add(jCheckBox47, gridBagConstraints);

        jComboBox86.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox86.setEnabled(false);
        jComboBox86.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Catalogados2.add(jComboBox86, gridBagConstraints);

        jCheckBox48.setText("Por Mes:");
        jCheckBox48.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        Panel_Documentos_Catalogados2.add(jCheckBox48, gridBagConstraints);

        jComboBox91.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBox91.setEnabled(false);
        jComboBox91.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Catalogados2.add(jComboBox91, gridBagConstraints);

        jCheckBox49.setText("Por Año:");
        jCheckBox49.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 0, 0);
        Panel_Documentos_Catalogados2.add(jCheckBox49, gridBagConstraints);

        jCheckBox50.setText("Por Franja Horaria:");
        jCheckBox50.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos_Catalogados2.add(jCheckBox50, gridBagConstraints);

        jLabel82.setText("Desde:");
        jLabel82.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Catalogados2.add(jLabel82, gridBagConstraints);

        jComboBox92.setMaximumRowCount(12);
        jComboBox92.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));
        jComboBox92.setEnabled(false);
        jComboBox92.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Catalogados2.add(jComboBox92, gridBagConstraints);

        jComboBox97.setMaximumRowCount(12);
        jComboBox97.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));
        jComboBox97.setEnabled(false);
        jComboBox97.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Catalogados2.add(jComboBox97, gridBagConstraints);

        jLabel83.setText("Hasta:");
        jLabel83.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Catalogados2.add(jLabel83, gridBagConstraints);

        jComboBox99.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2011", "2010", "2009" }));
        jComboBox99.setEnabled(false);
        jComboBox99.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Catalogados2.add(jComboBox99, gridBagConstraints);

        jCheckBox51.setText("Intervalo de Tiempo");
        jCheckBox51.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos_Catalogados2.add(jCheckBox51, gridBagConstraints);

        jLabel84.setText("Desde:");
        jLabel84.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Catalogados2.add(jLabel84, gridBagConstraints);

        jComboBox108.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox108.setEnabled(false);
        jComboBox108.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Catalogados2.add(jComboBox108, gridBagConstraints);

        jComboBox109.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBox109.setEnabled(false);
        jComboBox109.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Catalogados2.add(jComboBox109, gridBagConstraints);

        jComboBox110.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2011", "2010", "2009" }));
        jComboBox110.setEnabled(false);
        jComboBox110.setPreferredSize(new java.awt.Dimension(50, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Catalogados2.add(jComboBox110, gridBagConstraints);

        jComboBox111.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2011", "2010", "2009" }));
        jComboBox111.setEnabled(false);
        jComboBox111.setPreferredSize(new java.awt.Dimension(50, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Catalogados2.add(jComboBox111, gridBagConstraints);

        jComboBox112.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        jComboBox112.setEnabled(false);
        jComboBox112.setPreferredSize(new java.awt.Dimension(70, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Catalogados2.add(jComboBox112, gridBagConstraints);

        jComboBox113.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox113.setEnabled(false);
        jComboBox113.setPreferredSize(new java.awt.Dimension(60, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 5);
        Panel_Documentos_Catalogados2.add(jComboBox113, gridBagConstraints);

        jLabel85.setText("Hasta:");
        jLabel85.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        Panel_Documentos_Catalogados2.add(jLabel85, gridBagConstraints);

        jLabel87.setText("Por Áreas de Conocimiento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Catalogados2.add(jLabel87, gridBagConstraints);

        AreasComboBoxPDC1.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Catalogados2.add(AreasComboBoxPDC1, gridBagConstraints);

        jLabel88.setText("Por un Catalogador Particular:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Catalogados2.add(jLabel88, gridBagConstraints);

        jTextField8.setEditable(false);
        jTextField8.setText("Digite su Username");
        jTextField8.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField8.setEnabled(false);
        jTextField8.setPreferredSize(new java.awt.Dimension(110, 20));
        jTextField8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField8MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Catalogados2.add(jTextField8, gridBagConstraints);

        jLabel89.setFont(new java.awt.Font("Ubuntu", 1, 11)); // NOI18N
        jLabel89.setText("Reporte de Documentos Catalogados: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        Panel_Documentos_Catalogados2.add(jLabel89, gridBagConstraints);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/gui/resources/logo.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        Panel_Documentos_Catalogados2.add(jLabel16, gridBagConstraints);

        jLabel17.setFont(new java.awt.Font("Ubuntu", 1, 24));
        jLabel17.setText("Reportes ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        Panel_Documentos_Catalogados2.add(jLabel17, gridBagConstraints);

        jLabel18.setText("Por Autor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Catalogados2.add(jLabel18, gridBagConstraints);

        AutorComboBoxPDC1.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Catalogados2.add(AutorComboBoxPDC1, gridBagConstraints);

        DocTipoComboBoxPDC1.setPreferredSize(new java.awt.Dimension(180, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Catalogados2.add(DocTipoComboBoxPDC1, gridBagConstraints);

        jLabel19.setText("Por Tipo de Documento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 10, 5);
        Panel_Documentos_Catalogados2.add(jLabel19, gridBagConstraints);

        jButton5.setText("Generar Reportes");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        Panel_Documentos_Catalogados2.add(jButton5, gridBagConstraints);

        jPanel5.add(Panel_Documentos_Catalogados2);

        jTabbedPane1.addTab("Documentos Catalogados", jPanel5);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void jCheckBox39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox39ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
      if(jCheckBox4.isSelected()){
          jCheckBox5.setEnabled(false);
      }
      else{
          jCheckBox5.setEnabled(true);
      }
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
      if(jCheckBox3.isSelected()){
          jCheckBox4.setEnabled(false);
          jCheckBox5.setEnabled(false);
          jCheckBox6.setEnabled(false);
          jCheckBox7.setEnabled(false);
          jCheckBox8.setEnabled(false);
          jCheckBox9.setEnabled(false);
          jComboBox9.setEnabled(false);
          jComboBox10.setEnabled(false);
          jComboBox11.setEnabled(false);
          jComboBox12.setEnabled(false);
          jComboBox13.setEnabled(false);
          jComboBox14.setEnabled(false);
          jComboBox15.setEnabled(false);
          jComboBox16.setEnabled(false);
          jComboBox17.setEnabled(false);
          jComboBox18.setEnabled(false);
          jComboBox19.setEnabled(false);
          jComboBox20.setEnabled(false);
          jLabel24.setEnabled(false);
          jLabel25.setEnabled(false);
          jLabel26.setEnabled(false);
          jLabel27.setEnabled(false);
          
      }
      else {
          jCheckBox4.setEnabled(true);
          jCheckBox5.setEnabled(true);
          jCheckBox6.setEnabled(true);
          jCheckBox7.setEnabled(true);
          jCheckBox8.setEnabled(true);
          jCheckBox9.setEnabled(true);
          jComboBox9.setEnabled(true);
          jComboBox10.setEnabled(true);
          jComboBox11.setEnabled(true);
          jComboBox12.setEnabled(true);
          jComboBox13.setEnabled(true);
          jComboBox14.setEnabled(true);
          jComboBox15.setEnabled(true);
          jComboBox16.setEnabled(true);
          jComboBox17.setEnabled(true);
          jComboBox18.setEnabled(true);
          jComboBox19.setEnabled(true);
          jComboBox20.setEnabled(true);
          jLabel24.setEnabled(true);
          jLabel25.setEnabled(true);
          jLabel26.setEnabled(true);
          jLabel27.setEnabled(true);
      }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
       if(jCheckBox5.isSelected()){
          jCheckBox4.setEnabled(false);
          jCheckBox9.setEnabled(false);
          jComboBox15.setEnabled(false);
          jComboBox16.setEnabled(false);
          jComboBox17.setEnabled(false);
          jComboBox18.setEnabled(false);
          jComboBox19.setEnabled(false);
          jComboBox20.setEnabled(false);
          jLabel26.setEnabled(false);
          jLabel27.setEnabled(false);
       }
      else if(!jCheckBox7.isSelected() && !jCheckBox6.isSelected() && !jCheckBox5.isSelected()){
           jCheckBox4.setEnabled(true);
          jCheckBox9.setEnabled(true);
          jComboBox15.setEnabled(true);
          jComboBox16.setEnabled(true);
          jComboBox17.setEnabled(true);
          jComboBox18.setEnabled(true);
          jComboBox19.setEnabled(true);
          jComboBox20.setEnabled(true);
          jLabel26.setEnabled(true);
          jLabel27.setEnabled(true);
       
       }
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox29ActionPerformed
        if(jCheckBox29.isSelected()){
            jLabel58.setEnabled(false);
            jLabel59.setEnabled(false);
            jComboBox69.setEnabled(false);
            jComboBox70.setEnabled(false);
            jComboBox71.setEnabled(false);
            jComboBox72.setEnabled(false);
            jComboBox73.setEnabled(false);
            jComboBox74.setEnabled(false);
        }
        else{
            jLabel58.setEnabled(true);
            jLabel59.setEnabled(true);
            jComboBox69.setEnabled(true);
            jComboBox70.setEnabled(true);
            jComboBox71.setEnabled(true);
            jComboBox72.setEnabled(true);
            jComboBox73.setEnabled(true);
            jComboBox74.setEnabled(true);
            
        }
    }//GEN-LAST:event_jCheckBox29ActionPerformed

    private void jCheckBox32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox32ActionPerformed
          if(jCheckBox32.isSelected())
          jCheckBox33.setEnabled(false);
      else jCheckBox33.setEnabled(true);
    }//GEN-LAST:event_jCheckBox32ActionPerformed

    private void jCheckBox33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox33ActionPerformed
       if(jCheckBox33.isSelected()){
          jCheckBox32.setEnabled(false);
          jCheckBox37.setEnabled(false);
          jComboBox82.setEnabled(false);
          jComboBox83.setEnabled(false);
          jComboBox84.setEnabled(false);
          jComboBox89.setEnabled(false);
          jComboBox88.setEnabled(false);
          jComboBox87.setEnabled(false);
          jLabel65.setEnabled(false);
          jLabel66.setEnabled(false);
       }
      else if(!jCheckBox33.isSelected() && !jCheckBox34.isSelected() && !jCheckBox35.isSelected()){
          jCheckBox32.setEnabled(true);
          jCheckBox37.setEnabled(true);
          jComboBox82.setEnabled(true);
          jComboBox83.setEnabled(true);
          jComboBox84.setEnabled(true);
          jComboBox89.setEnabled(true);
          jComboBox88.setEnabled(true);
          jComboBox87.setEnabled(true);
          jLabel65.setEnabled(true);
          jLabel66.setEnabled(true);}
      
    }//GEN-LAST:event_jCheckBox33ActionPerformed

    private void jCheckBox43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox43ActionPerformed
        if(jCheckBox43.isSelected())
             jCheckBox44.setEnabled(false);
          else jCheckBox44.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox43ActionPerformed

    private void jCheckBox44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox44ActionPerformed
          if(jCheckBox44.isSelected())
          jCheckBox43.setEnabled(false);
      else jCheckBox43.setEnabled(true);
    }//GEN-LAST:event_jCheckBox44ActionPerformed

    private void jCheckBox45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox45ActionPerformed
         if(jCheckBox45.isSelected()){
          jCheckBox39.setEnabled(false);
          jCheckBox40.setEnabled(false);
          jCheckBox41.setEnabled(false);
          jCheckBox42.setEnabled(false);
          jCheckBox43.setEnabled(false);
          jCheckBox44.setEnabled(false);
          jLabel73.setEnabled(false);
          jLabel74.setEnabled(false);
          jLabel75.setEnabled(false);
          jLabel76.setEnabled(false);
          jComboBox107.setEnabled(false);
          jComboBox106.setEnabled(false);
          jComboBox105.setEnabled(false);
          jComboBox104.setEnabled(false);
          jComboBox103.setEnabled(false);
          jComboBox102.setEnabled(false);
          jComboBox101.setEnabled(false);
          jComboBox100.setEnabled(false);
          jComboBox98.setEnabled(false);
          jComboBox94.setEnabled(false);
          jComboBox95.setEnabled(false);
          jComboBox96.setEnabled(false);
         }
         else{ 
          jCheckBox39.setEnabled(true);
          jCheckBox40.setEnabled(true);
          jCheckBox41.setEnabled(true);
          jCheckBox42.setEnabled(true);
          jCheckBox43.setEnabled(true);
          jCheckBox44.setEnabled(true);
          jLabel73.setEnabled(true);
          jLabel74.setEnabled(true);
          jLabel75.setEnabled(true);
          jLabel76.setEnabled(true);
           jComboBox107.setEnabled(true);
          jComboBox106.setEnabled(true);
          jComboBox105.setEnabled(true);
          jComboBox104.setEnabled(true);
          jComboBox103.setEnabled(true);
          jComboBox102.setEnabled(true);
          jComboBox101.setEnabled(true);
          jComboBox100.setEnabled(true);
          jComboBox98.setEnabled(true);
          jComboBox94.setEnabled(true);
          jComboBox95.setEnabled(true);
          jComboBox96.setEnabled(true);
         }
    }//GEN-LAST:event_jCheckBox45ActionPerformed

    private void jCheckBox31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox31ActionPerformed
         if(jCheckBox31.isSelected()){
          jCheckBox32.setEnabled(false);
          jCheckBox33.setEnabled(false);
          jCheckBox34.setEnabled(false);
          jCheckBox35.setEnabled(false);
          jCheckBox36.setEnabled(false);
          jCheckBox37.setEnabled(false);
          jLabel63.setEnabled(false);
          jLabel64.setEnabled(false);
          jLabel65.setEnabled(false);
          jLabel66.setEnabled(false);
          jComboBox76.setEnabled(false);
          jComboBox77.setEnabled(false);
          jComboBox78.setEnabled(false);
          jComboBox79.setEnabled(false);
          jComboBox80.setEnabled(false);
          jComboBox81.setEnabled(false);
          jComboBox82.setEnabled(false);
          jComboBox83.setEnabled(false);
          jComboBox84.setEnabled(false);
          jComboBox87.setEnabled(false);
          jComboBox88.setEnabled(false);
          jComboBox89.setEnabled(false);
          
          
         }
         else{ 
          jCheckBox32.setEnabled(true);
          jCheckBox33.setEnabled(true);
          jCheckBox34.setEnabled(true);
          jCheckBox35.setEnabled(true);
          jCheckBox36.setEnabled(true);
          jCheckBox37.setEnabled(true);
          jLabel63.setEnabled(true);
          jLabel64.setEnabled(true);
          jLabel65.setEnabled(true);
          jLabel66.setEnabled(true);
          jComboBox76.setEnabled(true);
          jComboBox77.setEnabled(true);
          jComboBox78.setEnabled(true);
          jComboBox79.setEnabled(true);
          jComboBox80.setEnabled(true);
          jComboBox81.setEnabled(true);
          jComboBox82.setEnabled(true);
          jComboBox83.setEnabled(true);
          jComboBox84.setEnabled(true);
          jComboBox87.setEnabled(true);
          jComboBox88.setEnabled(true);
          jComboBox89.setEnabled(true);
         }
    }//GEN-LAST:event_jCheckBox31ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      String dow = null, dom = null, month = null, year = null, tipo = null, genero = null, Estado = null;
      String area = null;
      String[] franja = null, desde = null, Hasta = null;
      
      if(!jCheckBox3.isSelected()){
          if(jCheckBox4.isSelected()) dow=jComboBox9.getSelectedIndex()+"";
          if(jCheckBox5.isSelected()) dom=jComboBox10.getSelectedItem()+"";
          if(jCheckBox6.isSelected()) month=(jComboBox11.getSelectedIndex()+1)+"";
          if(jCheckBox7.isSelected()) year=jComboBox12.getSelectedItem()+"";
          
          if(jCheckBox8.isSelected()){
          franja=new String[2];
          franja[0]=jComboBox13.getSelectedIndex()+"";
          franja[1]=jComboBox14.getSelectedIndex()+"";
          }
          
          if(jCheckBox9.isSelected()){
          desde=new String[3];
          desde[0]=jComboBox15.getSelectedItem()+"";
          desde[1]=jComboBox17.getSelectedIndex()+"";
          desde[2]=jComboBox19.getSelectedItem()+"";
          Hasta=new String[3];
          Hasta[0]=jComboBox16.getSelectedItem()+"";
          Hasta[1]=jComboBox18.getSelectedIndex()+"";
          Hasta[2]=jComboBox20.getSelectedItem()+"";
          }
      }
          if(jComboBox23.getSelectedIndex()!=0) tipo=jComboBox23.getSelectedIndex()+"";
          if(jComboBox26.getSelectedIndex()!=0) genero=jComboBox26.getSelectedIndex()+"";
          if(jComboBox24.getSelectedIndex()!=0) Estado=jComboBox24.getSelectedIndex()+"";
          if(AreasComboBoxPU.getSelectedIndex()!=0) area=areasExistentes.get(AreasComboBoxPU.getSelectedIndex()-1).getID();
       
      
      System.out.println("tipo "+tipo);
        biblioteca.Main.PdfCreator.createPdf("usuarios.pdf", "Reporte de Usuarios Registrados", "Total de usuarios registrados: ", 
                new ControladorReportesEstadisticas().ConsultarListaUsuario(dow, dom, month, year, franja, desde, Hasta, tipo,
             genero, Estado, area));
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox9ActionPerformed
        if(jCheckBox9.isSelected()){
            jCheckBox5.setEnabled(false);
            jCheckBox6.setEnabled(false);
            jCheckBox7.setEnabled(false);
            jComboBox10.setEnabled(false);
            jComboBox11.setEnabled(false);
            jComboBox12.setEnabled(false);
        }
        else{
             jCheckBox5.setEnabled(true);
            jCheckBox6.setEnabled(true);
            jCheckBox7.setEnabled(true);
            jComboBox10.setEnabled(true);
          jComboBox11.setEnabled(true);
          jComboBox12.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox9ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        if(jCheckBox6.isSelected()){
          jCheckBox9.setEnabled(false);
          jComboBox15.setEnabled(false);
          jComboBox16.setEnabled(false);
          jComboBox17.setEnabled(false);
          jComboBox18.setEnabled(false);
          jComboBox19.setEnabled(false);
          jComboBox20.setEnabled(false);
          jLabel26.setEnabled(false);
          jLabel27.setEnabled(false);
        }
    else if(!jCheckBox7.isSelected() && !jCheckBox6.isSelected() && !jCheckBox5.isSelected()){
            jCheckBox9.setEnabled(true);
          jComboBox15.setEnabled(true);
          jComboBox16.setEnabled(true);
          jComboBox17.setEnabled(true);
          jComboBox18.setEnabled(true);
          jComboBox19.setEnabled(true);
          jComboBox20.setEnabled(true);
          jLabel26.setEnabled(true);
          jLabel27.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        if(jCheckBox7.isSelected()){
          jCheckBox9.setEnabled(false);
          jComboBox15.setEnabled(false);
          jComboBox16.setEnabled(false);
          jComboBox17.setEnabled(false);
          jComboBox18.setEnabled(false);
          jComboBox19.setEnabled(false);
          jComboBox20.setEnabled(false);
          jLabel26.setEnabled(false);
          jLabel27.setEnabled(false);
        }
        else if(!jCheckBox7.isSelected() && !jCheckBox6.isSelected() && !jCheckBox5.isSelected()){
            jCheckBox9.setEnabled(true);
          jComboBox15.setEnabled(true);
          jComboBox16.setEnabled(true);
          jComboBox17.setEnabled(true);
          jComboBox18.setEnabled(true);
          jComboBox19.setEnabled(true);
          jComboBox20.setEnabled(true);
          jLabel26.setEnabled(true);
          jLabel27.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String area=null, autor=null, tipo=null,  editorial=null, idioma=null, estado=null;
       String[] desde=null, hasta=null;
       
       if(AreasComboBoxPDE.getSelectedIndex()!=0) area=areasExistentes.get(AreasComboBoxPDE.getSelectedIndex()-1).getID(); 
       if(AutorComboBoxPDE.getSelectedIndex()!=0) autor=autoresExistentes.get(AutorComboBoxPDE.getSelectedIndex()-1).getCorreo();
       if(DocTipoComboBoxPDE.getSelectedIndex()!=0) tipo=tdExistentes.get(DocTipoComboBoxPDE.getSelectedIndex()-1).getTipoDocumento(); 
       if(!jTextField5.getText().isEmpty()) editorial=jTextField5.getText();
       if(jComboBox68.getSelectedIndex()!=0) idioma=jComboBox68.getSelectedItem()+"";
       if(jComboBox75.getSelectedIndex()!=0) estado=jComboBox75.getSelectedIndex()+"";
       if(!jCheckBox29.isSelected()){
          desde=new String[3];
          desde[0]=jComboBox69.getSelectedItem()+"";
          desde[1]=(jComboBox71.getSelectedIndex()+1)+"";
          desde[2]=jComboBox73.getSelectedItem()+"";
          hasta=new String[3];
          hasta[0]=jComboBox70.getSelectedItem()+"";
          hasta[1]=(jComboBox72.getSelectedIndex()+1)+"";
          hasta[2]=jComboBox74.getSelectedItem()+"";
          }
       biblioteca.Main.PdfCreator.createPdf("documentosExistentes.pdf", "Reporte de Documentos Existentes", "Total de documentos existentes en este reporte: ", 
                new ControladorReportesEstadisticas().ConsultarListaDocumentosExistentes(area, autor, tipo, editorial, idioma, estado,
       desde, hasta));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String dow = null, dom = null, month = null, year = null, tipo_usuario = null;
        String[] franja = null, desde = null, Hasta = null;
        String area = null, autor=null, doc_tipo=null, usuario=null;
      
      
      if(!jCheckBox31.isSelected()){
          if(jCheckBox32.isSelected()) dow=jComboBox76.getSelectedIndex()+"";
          if(jCheckBox33.isSelected()) dom=jComboBox77.getSelectedItem()+"";
          if(jCheckBox34.isSelected()) month=(jComboBox78.getSelectedIndex()+1)+"";
          if(jCheckBox35.isSelected()) year=jComboBox81.getSelectedItem()+"";
          if(jCheckBox36.isSelected()){
          franja=new String[2];
          franja[0]=jComboBox79.getSelectedIndex()+"";
          franja[1]=jComboBox80.getSelectedIndex()+"";
          }
          if(jCheckBox37.isSelected()){
          desde=new String[3];
          desde[0]=jComboBox82.getSelectedItem()+"";
          desde[1]=jComboBox83.getSelectedIndex()+"";
          desde[2]=jComboBox84.getSelectedItem()+"";
          Hasta=new String[3];
          Hasta[0]=jComboBox89.getSelectedItem()+"";
          Hasta[1]=jComboBox88.getSelectedIndex()+"";
          Hasta[2]=jComboBox87.getSelectedItem()+"";
          }
      }
          if(jComboBox90.getSelectedIndex()!=0) tipo_usuario=jComboBox90.getSelectedIndex()+"";
          if(AreasComboBoxPDC.getSelectedIndex()!=0) area=areasExistentes.get(AreasComboBoxPDC.getSelectedIndex()-1).getID();
          if(AutorComboBoxPDC.getSelectedIndex()!=0) autor=autoresExistentes.get(AutorComboBoxPDC.getSelectedIndex()-1).getCorreo();
          if(DocTipoComboBoxPDC.getSelectedIndex()!=0) doc_tipo=tdExistentes.get(DocTipoComboBoxPDC.getSelectedIndex()-1).getTipoDocumento();
          if(jTextField6.isCursorSet() && !jTextField6.getText().isEmpty()) usuario=jTextField6.getText();
          
          biblioteca.Main.PdfCreator.createPdf("documentosConsultados.pdf", "Reporte de Documentos Consultados", "Total de documentos consultados en este reporte: ", 
                new ControladorReportesEstadisticas().ConsultarListaDocumentosConsultados(dow, dom, month, year, tipo_usuario,
               franja, desde,Hasta,area, autor, doc_tipo, usuario));
          
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String dow = null, dom = null, month = null, year = null, tipo_usuario = null;
        String[] franja = null, desde = null, Hasta = null;
        String area = null, autor=null, doc_tipo=null, usuario=null;
      
      if(!jCheckBox45.isSelected()){
          if(jCheckBox44.isSelected()) dow=jComboBox107.getSelectedIndex()+"";
          if(jCheckBox43.isSelected()) dom=jComboBox106.getSelectedItem()+"";
          if(jCheckBox42.isSelected()) month=(jComboBox105.getSelectedIndex()+1)+"";
          if(jCheckBox41.isSelected()) year=jComboBox104.getSelectedItem()+"";
          if(jCheckBox40.isSelected()){
          franja=new String[2];
          franja[0]=jComboBox103.getSelectedIndex()+"";
          franja[1]=jComboBox104.getSelectedIndex()+"";
          }
          if(jCheckBox39.isSelected()){
          desde=new String[3];
          desde[0]=jComboBox101.getSelectedItem()+"";
          desde[1]=jComboBox100.getSelectedIndex()+"";
          desde[2]=jComboBox98.getSelectedItem()+"";
          Hasta=new String[3];
          Hasta[0]=jComboBox94.getSelectedItem()+"";
          Hasta[1]=jComboBox95.getSelectedIndex()+"";
          Hasta[2]=jComboBox96.getSelectedItem()+"";
          }
      }
          if(jComboBox93.getSelectedIndex()!=0) tipo_usuario=jComboBox93.getSelectedIndex()+"";
          if(AreasComboBoxPDD.getSelectedIndex()!=0) area=areasExistentes.get(AreasComboBoxPDD.getSelectedIndex()-1).getID();
          if(AutorComboBoxPDD.getSelectedIndex()!=0) autor=autoresExistentes.get(AutorComboBoxPDD.getSelectedIndex()-1).getCorreo();
          if(DocTipoComboBoxPDD.getSelectedIndex()!=0) doc_tipo=tdExistentes.get(DocTipoComboBoxPDD.getSelectedIndex()-1).getTipoDocumento();
          if(jTextField7.isCursorSet() && !jTextField7.getText().isEmpty()) usuario=jTextField7.getText();
          
          biblioteca.Main.PdfCreator.createPdf("documentosDescargados.pdf", "Reporte de Documentos Descargados", "Total de documentos consultados en este reporte: ",new ControladorReportesEstadisticas().ConsultarListaDocumentosDescargados(dow, dom, month, year, tipo_usuario,
               franja, desde,Hasta,area, autor, doc_tipo, usuario));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        jTextField6.setEnabled(true);
        jTextField6.setEditable(true);
        jTextField6.setText("");
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseClicked
        jTextField7.setEnabled(true);
        jTextField7.setEditable(true);
        jTextField7.setText("");
        
    }//GEN-LAST:event_jTextField7MouseClicked

    private void jCheckBox38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox38ActionPerformed
        if(jCheckBox38.isSelected()){
          jCheckBox46.setEnabled(false);
          jCheckBox47.setEnabled(false);
          jCheckBox48.setEnabled(false);
          jCheckBox49.setEnabled(false);
          jCheckBox50.setEnabled(false);
          jCheckBox51.setEnabled(false);
          jLabel82.setEnabled(false);
          jLabel83.setEnabled(false);
          jLabel84.setEnabled(false);
          jLabel85.setEnabled(false);
          jComboBox85.setEnabled(false);
          jComboBox86.setEnabled(false);
          jComboBox91.setEnabled(false);
          jComboBox99.setEnabled(false);
          jComboBox92.setEnabled(false);
          jComboBox97.setEnabled(false);
          jComboBox108.setEnabled(false);
          jComboBox109.setEnabled(false);
          jComboBox110.setEnabled(false);
          jComboBox113.setEnabled(false);
          jComboBox112.setEnabled(false);
          jComboBox111.setEnabled(false);
         }
         else{ 
          jCheckBox46.setEnabled(true);
          jCheckBox47.setEnabled(true);
          jCheckBox48.setEnabled(true);
          jCheckBox49.setEnabled(true);
          jCheckBox50.setEnabled(true);
          jCheckBox51.setEnabled(true);
          jLabel82.setEnabled(true);
          jLabel83.setEnabled(true);
          jLabel84.setEnabled(true);
          jLabel85.setEnabled(true);
          jComboBox85.setEnabled(true);
          jComboBox86.setEnabled(true);
          jComboBox91.setEnabled(true);
          jComboBox99.setEnabled(true);
          jComboBox92.setEnabled(true);
          jComboBox97.setEnabled(true);
          jComboBox108.setEnabled(true);
          jComboBox109.setEnabled(true);
          jComboBox110.setEnabled(true);
          jComboBox113.setEnabled(true);
          jComboBox112.setEnabled(true);
          jComboBox111.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox38ActionPerformed

    private void jCheckBox46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox46ActionPerformed
          if(jCheckBox46.isSelected())
             jCheckBox47.setEnabled(false);
          else jCheckBox47.setEnabled(true);  
    }//GEN-LAST:event_jCheckBox46ActionPerformed

    private void jCheckBox47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox47ActionPerformed
        if(jCheckBox47.isSelected())
             jCheckBox46.setEnabled(false);
          else jCheckBox46.setEnabled(true);  
    }//GEN-LAST:event_jCheckBox47ActionPerformed

    private void jTextField8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField8MouseClicked
        jTextField8.setEnabled(true);
        jTextField8.setEditable(true);
        jTextField8.setText("");
    }//GEN-LAST:event_jTextField8MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String dow = null, dom = null, month = null, year = null;
        String[] franja = null, desde = null, Hasta = null;
        String area = null, autor=null, doc_tipo=null, usuario=null;
      
      if(!jCheckBox38.isSelected()){
          if(jCheckBox46.isSelected()) dow=jComboBox85.getSelectedIndex()+"";
          if(jCheckBox47.isSelected()) dom=jComboBox86.getSelectedItem()+"";
          if(jCheckBox48.isSelected()) month=(jComboBox91.getSelectedIndex()+1)+"";
          if(jCheckBox49.isSelected()) year=jComboBox99.getSelectedItem()+"";
          if(jCheckBox50.isSelected()){
          franja=new String[2];
          franja[0]=jComboBox92.getSelectedIndex()+"";
          franja[1]=jComboBox97.getSelectedIndex()+"";
          }
          if(jCheckBox51.isSelected()){
          desde=new String[3];
          desde[0]=jComboBox108.getSelectedItem()+"";
          desde[1]=jComboBox109.getSelectedIndex()+"";
          desde[2]=jComboBox110.getSelectedItem()+"";
          Hasta=new String[3];
          Hasta[0]=jComboBox113.getSelectedItem()+"";
          Hasta[1]=jComboBox112.getSelectedIndex()+"";
          Hasta[2]=jComboBox111.getSelectedItem()+"";
          }
      }
          if(AreasComboBoxPDC1.getSelectedIndex()!=0) area=areasExistentes.get(AreasComboBoxPDC1.getSelectedIndex()-1).getID();
          if(AutorComboBoxPDC1.getSelectedIndex()!=0) autor=autoresExistentes.get(AutorComboBoxPDC1.getSelectedIndex()-1).getCorreo();
          if(DocTipoComboBoxPDC1.getSelectedIndex()!=0) doc_tipo=tdExistentes.get(DocTipoComboBoxPDC1.getSelectedIndex()-1).getTipoDocumento();
          if(jTextField8.isCursorSet() && !jTextField8.getText().isEmpty()) usuario=jTextField8.getText();
          
          biblioteca.Main.PdfCreator.createPdf("documentosCatalogados.pdf", "Reporte de Documentos Catalogados", "Total de documentos catalogados en este reporte: ",new ControladorReportesEstadisticas().ConsultarListaDocumentosCatalogados(dow, dom, month, year, franja, desde, Hasta, area, autor, doc_tipo, usuario));
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jCheckBox34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox34ActionPerformed
        if(jCheckBox34.isSelected()){
          jCheckBox37.setEnabled(false);
          jComboBox82.setEnabled(false);
          jComboBox83.setEnabled(false);
          jComboBox84.setEnabled(false);
          jComboBox89.setEnabled(false);
          jComboBox88.setEnabled(false);
          jComboBox87.setEnabled(false);
          jLabel65.setEnabled(false);
          jLabel66.setEnabled(false);
        }
    else if(!jCheckBox33.isSelected() && !jCheckBox34.isSelected() && !jCheckBox33.isSelected()){
          jCheckBox37.setEnabled(true);
          jComboBox82.setEnabled(true);
          jComboBox83.setEnabled(true);
          jComboBox84.setEnabled(true);
          jComboBox89.setEnabled(true);
          jComboBox88.setEnabled(true);
          jComboBox87.setEnabled(true);
          jLabel65.setEnabled(true);
          jLabel66.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox34ActionPerformed

    private void jCheckBox35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox35ActionPerformed
       
 if(jCheckBox35.isSelected()){
          jCheckBox37.setEnabled(false);
          jComboBox82.setEnabled(false);
          jComboBox83.setEnabled(false);
          jComboBox84.setEnabled(false);
          jComboBox89.setEnabled(false);
          jComboBox88.setEnabled(false);
          jComboBox87.setEnabled(false);
          jLabel65.setEnabled(false);
          jLabel66.setEnabled(false);
        }
    else if(!jCheckBox33.isSelected() && !jCheckBox34.isSelected() && !jCheckBox35.isSelected()){
          jCheckBox37.setEnabled(true);
          jComboBox82.setEnabled(true);
          jComboBox83.setEnabled(true);
          jComboBox84.setEnabled(true);
          jComboBox89.setEnabled(true);
          jComboBox88.setEnabled(true);
          jComboBox87.setEnabled(true);
          jLabel65.setEnabled(true);
          jLabel66.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox35ActionPerformed

    private void unsupportedOperation(){
        JOptionPane.showMessageDialog(this, "Esta operación aún no ha sido implementada", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox AreasComboBoxPDC;
    private javax.swing.JComboBox AreasComboBoxPDC1;
    private javax.swing.JComboBox AreasComboBoxPDD;
    private javax.swing.JComboBox AreasComboBoxPDE;
    private javax.swing.JComboBox AreasComboBoxPU;
    private javax.swing.JComboBox AutorComboBoxPDC;
    private javax.swing.JComboBox AutorComboBoxPDC1;
    private javax.swing.JComboBox AutorComboBoxPDD;
    private javax.swing.JComboBox AutorComboBoxPDE;
    private javax.swing.JComboBox DocTipoComboBoxPDC;
    private javax.swing.JComboBox DocTipoComboBoxPDC1;
    private javax.swing.JComboBox DocTipoComboBoxPDD;
    private javax.swing.JComboBox DocTipoComboBoxPDE;
    private javax.swing.JPanel Panel_Documentos2;
    private javax.swing.JPanel Panel_Documentos_Catalogados1;
    private javax.swing.JPanel Panel_Documentos_Catalogados2;
    private javax.swing.JPanel Panel_Documentos_Descargados1;
    private javax.swing.JPanel Panel_Usuarios;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox29;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox31;
    private javax.swing.JCheckBox jCheckBox32;
    private javax.swing.JCheckBox jCheckBox33;
    private javax.swing.JCheckBox jCheckBox34;
    private javax.swing.JCheckBox jCheckBox35;
    private javax.swing.JCheckBox jCheckBox36;
    private javax.swing.JCheckBox jCheckBox37;
    private javax.swing.JCheckBox jCheckBox38;
    private javax.swing.JCheckBox jCheckBox39;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox40;
    private javax.swing.JCheckBox jCheckBox41;
    private javax.swing.JCheckBox jCheckBox42;
    private javax.swing.JCheckBox jCheckBox43;
    private javax.swing.JCheckBox jCheckBox44;
    private javax.swing.JCheckBox jCheckBox45;
    private javax.swing.JCheckBox jCheckBox46;
    private javax.swing.JCheckBox jCheckBox47;
    private javax.swing.JCheckBox jCheckBox48;
    private javax.swing.JCheckBox jCheckBox49;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox50;
    private javax.swing.JCheckBox jCheckBox51;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox jComboBox10;
    private javax.swing.JComboBox jComboBox100;
    private javax.swing.JComboBox jComboBox101;
    private javax.swing.JComboBox jComboBox102;
    private javax.swing.JComboBox jComboBox103;
    private javax.swing.JComboBox jComboBox104;
    private javax.swing.JComboBox jComboBox105;
    private javax.swing.JComboBox jComboBox106;
    private javax.swing.JComboBox jComboBox107;
    private javax.swing.JComboBox jComboBox108;
    private javax.swing.JComboBox jComboBox109;
    private javax.swing.JComboBox jComboBox11;
    private javax.swing.JComboBox jComboBox110;
    private javax.swing.JComboBox jComboBox111;
    private javax.swing.JComboBox jComboBox112;
    private javax.swing.JComboBox jComboBox113;
    private javax.swing.JComboBox jComboBox12;
    private javax.swing.JComboBox jComboBox13;
    private javax.swing.JComboBox jComboBox14;
    private javax.swing.JComboBox jComboBox15;
    private javax.swing.JComboBox jComboBox16;
    private javax.swing.JComboBox jComboBox17;
    private javax.swing.JComboBox jComboBox18;
    private javax.swing.JComboBox jComboBox19;
    private javax.swing.JComboBox jComboBox20;
    private javax.swing.JComboBox jComboBox23;
    private javax.swing.JComboBox jComboBox24;
    private javax.swing.JComboBox jComboBox25;
    private javax.swing.JComboBox jComboBox26;
    private javax.swing.JComboBox jComboBox68;
    private javax.swing.JComboBox jComboBox69;
    private javax.swing.JComboBox jComboBox70;
    private javax.swing.JComboBox jComboBox71;
    private javax.swing.JComboBox jComboBox72;
    private javax.swing.JComboBox jComboBox73;
    private javax.swing.JComboBox jComboBox74;
    private javax.swing.JComboBox jComboBox75;
    private javax.swing.JComboBox jComboBox76;
    private javax.swing.JComboBox jComboBox77;
    private javax.swing.JComboBox jComboBox78;
    private javax.swing.JComboBox jComboBox79;
    private javax.swing.JComboBox jComboBox80;
    private javax.swing.JComboBox jComboBox81;
    private javax.swing.JComboBox jComboBox82;
    private javax.swing.JComboBox jComboBox83;
    private javax.swing.JComboBox jComboBox84;
    private javax.swing.JComboBox jComboBox85;
    private javax.swing.JComboBox jComboBox86;
    private javax.swing.JComboBox jComboBox87;
    private javax.swing.JComboBox jComboBox88;
    private javax.swing.JComboBox jComboBox89;
    private javax.swing.JComboBox jComboBox9;
    private javax.swing.JComboBox jComboBox90;
    private javax.swing.JComboBox jComboBox91;
    private javax.swing.JComboBox jComboBox92;
    private javax.swing.JComboBox jComboBox93;
    private javax.swing.JComboBox jComboBox94;
    private javax.swing.JComboBox jComboBox95;
    private javax.swing.JComboBox jComboBox96;
    private javax.swing.JComboBox jComboBox97;
    private javax.swing.JComboBox jComboBox98;
    private javax.swing.JComboBox jComboBox99;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
