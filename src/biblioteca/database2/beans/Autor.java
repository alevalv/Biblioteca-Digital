/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.beans;

/**
 *  Esta clase forma parte de los beans creados para cumplir con el Patrón
 * de diseño DAO.
 * 
 * Autor representa la relación autores de la base de datos.
 *
 * Es una clase de getters y setters.
 * 
 * @see <a href="http://www.proactiva-calidad.com/java/patrones/DAO.html">Patrón "Data Access Object"</a>
 * 
 * @author María Cristina Bustos Rodríguez
 * @author Alejandro Valdés Villada
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
    
    @Override
    public String toString(){
        return correo+" - "+nombre+" "+apellido+" - "+acronimo;
    }

}