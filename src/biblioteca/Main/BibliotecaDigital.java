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
package biblioteca.Main;

import biblioteca.database2.fachada.Fachada;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 * Esta es la clase principal de Biblioteca-Digital, aca se comprueba
 * si el servidor de la base de datos está online y si la carpeta de los
 * documentos existe. También tiene la variable estatica LOGGED_USER
 * que tiene el username que está autenticado actualmente. Incluye la 
 * clase comprobador que es un JFrame con un texto
 * 
 * @author Alejandro Valdés Villada
 * @author María Cristina Bustos Rodríguez
 */
public class BibliotecaDigital {

    static public String LOGGED_USER;
    /**
     * Metodo main del programa, no recibe parametros por consola
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
                //new biblioteca.gui.GUIStatistics(null).setVisible(true);
            }
        });
        
        // TODO code application logic here
    }
}

/**
 * Comprobador es una clase simple que muestra una JFrame con un texto
 * mientras se comprueba si el servidor que esta especificado en fachada
 * es accesible.
 * @author Alejandro Valdés Villada
 */
final class Comprobador extends javax.swing.JFrame {

    /**
     * Crea un clase Comprobador
     */
    public Comprobador() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        getContentPane().setLayout(new java.awt.GridBagLayout());
        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18));
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

