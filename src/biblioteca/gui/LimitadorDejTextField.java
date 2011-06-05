/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.gui;

import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;

/**
 *
 * @author Cris
 * @author Alejandro
 */
public class LimitadorDejTextField extends DefaultStyledDocument {
        int caracteresMaximos;

    public LimitadorDejTextField( int caracteresMaximos ) {
        this.caracteresMaximos = caracteresMaximos;
        }

    @Override
    public void insertString(int offs, String str, AttributeSet a)
        throws BadLocationException {
        if ( str.indexOf("?") == -1 && str.indexOf("?") == -1 && (getLength() + str.length()) <= caracteresMaximos)
        super.insertString(offs, str, a);
        else
        Toolkit.getDefaultToolkit().beep();
        }

}
