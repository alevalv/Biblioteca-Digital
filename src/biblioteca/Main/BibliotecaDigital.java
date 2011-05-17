/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.Main;

//import biblioteca.gui.GUIModificarUsuario;

import biblioteca.database2.fachada.Fachada;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author alejandro
 */
public class BibliotecaDigital {

    static public String LOGGED_USER;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
        
        LOGGED_USER="dummyuser";
        String path=System.getProperty("user.dir")+"/repository/";
        File dir= new File(path);
        if(!dir.exists()){
            dir.mkdir();
        }
        try {
	    // Set System L&F
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }
        try{      
        Connection test;
        Comprobador ventanita=new Comprobador();
        ventanita.setVisible(true);
        test = new Fachada().conectar();
        ventanita.dispose();
        if(test==null){
            JOptionPane.showMessageDialog(null, "No se ha podido conectar a la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        else{
            test.close();
        }
        }catch(SQLException sqlex){
            System.err.println(sqlex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new biblioteca.gui.GUIBusqueda().setVisible(true);
            }
        });
        
        // TODO code application logic here
    }
}

final class Comprobador extends javax.swing.JFrame {

    public Comprobador() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Comprobando si el servidor está ONLINE...");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(30, 30, 30, 30);
        getContentPane().add(jLabel1, gridBagConstraints);
        this.setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Biblioteca Digital: Comprobador");
        pack();
        this.setLocationRelativeTo(null);
    }
    private javax.swing.JLabel jLabel1;
}

