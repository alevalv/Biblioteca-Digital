/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.Main;

//import biblioteca.gui.GUIModificarUsuario;

import java.io.File;
import java.util.Calendar;
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
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
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
                new biblioteca.gui.GUIBusqueda().setVisible(true);
            }
        });
        
        // TODO code application logic here
    }
}
