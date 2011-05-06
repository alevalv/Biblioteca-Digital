/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database1.beans;

package beans;

/**
 *
 * @author Eduardo
 */
public class Autor {

    String nombre;
    String correo;
    String acronimo;
    String apellido;

    public Autor(){}


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public String getApellido() {
        return apellido;
    }

}
