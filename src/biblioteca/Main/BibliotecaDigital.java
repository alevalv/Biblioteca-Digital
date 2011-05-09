/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.Main;

import biblioteca.gui.GUIModificarUsuario;

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
        new GUIModificarUsuario().setVisible(true);
        
        // TODO code application logic here
    }
}
