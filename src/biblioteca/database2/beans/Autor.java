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

    /**
     * Construye un objeto vacio de tipo Autor
     */
    public Autor(){}

    /**
     * Modifica el campo nombre del objeto Autor
     * @param nombre El nombre del Autor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Modifica el campo correo del objeto Autor
     * @param correo El correo del autor
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Modifica el acronimo del objeto Autor
     * @param acronimo El acronimo del autor
     */
    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    /**
     * Modifica el apellido del objeto autor
     * @param apellido Los apellido(s) del autor
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el nombre del objeto Autor seleccionado
     * @return el nombre del Autor
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el correo del objeto Autor seleccionado
     * @return el correo del autor
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Obtiene el acronimo del objeto Autor selccionado
     * @return el acronimo del autor
     */
    public String getAcronimo() {
        return acronimo;
    }

    /**
     * Obtiene el apellido del objeto Autor seleccionado
     * @return el apellido del autor
     */
    public String getApellido() {
        return apellido;
    }
    
    /**
     * Muestra una representación en String del objeto String
     * @see java.lang.String
     * @return una representación en cadena de caracteres del Objeto Autor
     */
    @Override
    public String toString(){
        return nombre+" "+apellido+" - "+acronimo;
    }

}