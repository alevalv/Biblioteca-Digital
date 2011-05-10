/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.Main;

//import biblioteca.gui.GUIModificarUsuario;

import java.io.File;
import javax.swing.JOptionPane;


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
        int opcion=JOptionPane.showConfirmDialog(null, "Presione si para gestión, presione no para catalogar un documento");
        if(opcion==0){
            new biblioteca.gui.GUIRegistroUsuarios().setVisible(true);
            new biblioteca.gui.GUIModificarUsuario().setVisible(true);
        }
        else if(opcion==1){
            new biblioteca.gui.GUICatalogacion().setVisible(true);
        }
        else System.exit(0);
        
        // TODO code application logic here
    }
}
