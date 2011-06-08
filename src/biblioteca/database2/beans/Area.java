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
 * Area representa la relación area_computacion de la base de datos.
 *
 * Es una clase de getters y setters.
 * 
 * @see <a href="http://www.proactiva-calidad.com/java/patrones/DAO.html">Patrón "Data Access Object"</a>
 * 
 * @author María Cristina Bustos Rodríguez
 * @author Alejandro Valdés Villada
 */
public class Area {

    String area_id;
    String nombre;
    String descripcion;
    String Area_Padre;
    
    /**
     * Construye un objeto vacio de tipo Area
     */
    public Area(){}

    /**
     * Modifica el campo nombre del objeto Area seleccionado
     * @param nombre el nuevo nombre para el Area
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Modifica el id del Area seleccionada.
     * Este metodo <b>no</b> se debería utilizar debido a que el ID es establecido
     * por la base de datos
     * @param id el nuevo id para el Area (Numerico)
     */
    public void setID(String id) {
        this.area_id = id;
    }

    /**
     * Modifica el areaPadre del Area seleccionada, la entrada es la id del area padre
     * @param Area_Padre el String que representa el id del Area Padre
     */
    public void setAreaPadre(String Area_Padre) {
        this.Area_Padre = Area_Padre;
    }

    /**
     * Modifica la Descripción del Area seleccionada
     * @param descripcion la nueva descripción del Area seleccionada
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el nombre del Area seleccionada
     * @return el String con el nombre del Area
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el id del area Seleccionada
     * @return String que representa el id (numerico)
     */
    public String getID() {
        return area_id;
    }

    /**
     * Obtiene el id del area padre. Si el area no tiene padre, el id será 0
     * @return String que representa el id del area padre
     */
    public String getAreaPadre() {
        return Area_Padre;
    }

    /**
     * Obtiene la descripción del area seleccionada
     * @return String con la descripción del area
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene una representación en String de un objeto Area
     * @return String con los atributos del Area
     */
    @Override
    public String toString(){
        return nombre;
    }
}