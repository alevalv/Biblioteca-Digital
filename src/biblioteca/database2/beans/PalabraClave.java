/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.beans;

/**
 *  Esta clase forma parte de los beans creados para cumplir con el Patrón
 * de diseño DAO.
 * 
 * PalabraClave representa la relación palabras_clave de la base de datos.
 *
 * Es una clase de getters y setters.
 * 
 * @see <a href="http://www.proactiva-calidad.com/java/patrones/DAO.html">Patrón "Data Access Object"</a>
 * 
 * @author María Cristina Bustos Rodríguez
 * @author Alejandro Valdés Villada
 */

public class PalabraClave {

    String nombre;
    String descripcion;

    public PalabraClave(){}

     public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }



}