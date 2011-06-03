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
package biblioteca.database2.controladores;

import biblioteca.database2.accesoDatos.DaoArea;
import biblioteca.database2.beans.Area;
import java.util.ArrayList;

/**
 *  Esta clase forma parte de los controladores creados para cumplir con el Patrón
 * de diseño DAO.
 * 
 * ControladorArea es una de las interfaces entre los Dao y las GUI de la aplicación.
 * Se incluyeron manejadores para la relación usuario_areas_computacion que indica
 * las áreas de interes de un usuario particular. Las identificaciones de las áreas
 * están dadas por un entero consecutivo, que la base de datos lo asigna automaticamente
 * 
 * @see <a href="http://www.proactiva-calidad.com/java/patrones/DAO.html">Patrón "Data Access Object"</a>
 *
 * @author María Cristina Bustos Rodríguez
 * @author Alejandro Valdés Villada
 */
public class ControladorArea {
    
    /**
     * inserta un área en la base de datos recibiendo 3 Strings que representan los datos
     * del área a insertar; está función utiliza el DaoArea para acceder a la base de datos
     * @param descripcion La descripción del área a insertar
     * @param nombre El nombre de la nueva área de computación
     * @param Area_Padre El identificador del área padre. Por defecto deberá ser "0"
     */
    public void insertarArea(String descripcion, String nombre, String Area_Padre){
        Area area= new Area();
        DaoArea daoArea= new DaoArea();
        area.setDescripcion(descripcion);
        area.setNombre(nombre);
        area.setAreaPadre(Area_Padre);

        daoArea.guardarArea(area);
    }

    /**
     * Modifica los datos de un área especifica seleccionada por medio del idArea
     * , modificando su descripción, nombre y Área_Padre; está función utiliza 
     * el DaoArea para acceder a la base de datos
     * @param idArea String que contiene el identificador de la base de datos
     * @param descripcion La descripción del área a insertar
     * @param nombre El nombre de la nueva área de computación
     * @param Area_Padre El identificador del área padre. Por defecto deberá ser "0"
     */
    public void modificarArea(String idArea, String descripcion, String nombre, String Area_Padre)
    {
        Area area= new Area();
        DaoArea daoArea= new DaoArea();

        area.setID(idArea);
        area.setDescripcion(descripcion);
        area.setNombre(nombre);
        area.setAreaPadre(Area_Padre);

        daoArea.modificarArea(area);

    }

    /**
     * Obtiene los datos de un area especifica por medio de idArea. Se retorna
     * un bean de tipo Area
     * @param idArea String con el identificador del Area Seleccionada
     * @return un Area con los datos del área que se obtuvo con el idArea
     */
    public Area consultarArea(String idArea)
    {
        Area area= new Area();
        DaoArea daoArea= new DaoArea();
        area= daoArea.consultarArea(idArea);
        return area;
    }
    
    /**
     * Obtiene todas las áreas existentes en la base de datos, esto con el fin de
     * ayudar en los procesos de catalogación y modificación de documentos
     * @return ArrayList de Area con todas las áreas de la computación de la base de datos
     */
    public ArrayList<Area> consultarTodasLasAreas(){
        return new DaoArea().consultarTodasLasAreas();
    }

    /**
     * Elimina de la base de datos el Area que tiene el idArea seleccionado
     * @param idArea String con el identificador de Área a eliminar
     * @deprecated Por motivos de conservación de información, no se recomienda eliminar Áreas
     */
    @Deprecated
    public void eliminarArea(String idArea)
    {
        DaoArea daoArea= new DaoArea();
        daoArea.eliminarArea(idArea);
    }

    /**
     * Comprueba si el Área con id_area existe en la base de datos
     * @param id_area String con el identificador de Área a comprobar
     * @return boolean reportando si el área existe o no
     */
    public boolean comprobarExistenciaArea(String id_area) {
         boolean respuesta;
         DaoArea daoArea= new DaoArea();
         respuesta= daoArea.comprobarExistenciaArea(id_area);
         return respuesta;
    }

    /**
     * Obtiene todas las áreas que tiene seleccionadas un usuario con Username
     * @param Username String con el login(username) del usuario a consultar
     * @return ArrayList de Area con las áreas que tiene un usuario particular
     */
     public ArrayList<Area> consultarAreasporUsuario(String Username){
        return new DaoArea().consultarAreasporUsuario(Username);
    }

     /**
      * Agrega un conjunto de áreas a un usuario particular
      * @param Username String con el login(username) del usuario a modificar
      * @param areas ArrayList de Area que contiene las areas a insertar al usuario
      * @return int indicando las filas modificadas, si la consulta es erronea, será -1
      */
     public int agregarAreasporUsuario(String Username, ArrayList<Area> areas){
         return new DaoArea().agregarAreasporUsuario(Username,areas);
     }

     /**
      * Elimina un conjunto de áreas de un usuario seleccionado
      * @param Username String con el login(username) del usuario a modificar
      * @param areas ArrayList de Area que contiene las areas a eliminar del usuario
      * @return int indicando las filas modificadas, si la consulta es erronea, será -1
      */
     public int eliminarAreasporUsuario(String Username, ArrayList<Area> areas){
         return new DaoArea().eliminarAreasporUsuario(Username, areas);
     }
}
