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


import biblioteca.database2.accesoDatos.DaoPalabraClave;
import biblioteca.database2.beans.PalabraClave;
import java.util.ArrayList;

/**
 *  Esta clase forma parte de los controladores creados para cumplir con el Patrón
 * de diseño DAO.
 * 
 * ControladorPalabraClave es una de las interfaces entre los Dao y las GUI de la aplicación.
 * ControladorPalabraClave se encarga de administrar los autores existentes, agregar nuevos,
 * consultarlos, etc.
 * La llave primaria de las palabras clave es el nombre de estas.
 * 
 * @see <a href="http://www.proactiva-calidad.com/java/patrones/DAO.html">Patrón "Data Access Object"</a>
 *
 * @author María Cristina Bustos Rodríguez
 * @author Alejandro Valdés Villada
 */
public class ControladorPalabraClave {

    /**
     * Inserta una nueva palabra clave en la base de datos con el nombre y la descripción dada
     * @param nombre String con el nombre de la palabra clave
     * @param descripcion String con la descripción de la palabra clave
     */
     public int InsertarPalabraClave(String nombre, String descripcion)
    {
        DaoPalabraClave daoPalabraClave = new DaoPalabraClave();
        PalabraClave palabra= new PalabraClave();
        palabra.setNombre(nombre);
        palabra.setDescripcion(descripcion);

        return daoPalabraClave.guardarPalabraClave(palabra);
    }

     /**
      * Modifica la palabra clave con el nombre dado
      * @param nombre String con el nombre de la palabra clave
      * @param descripcion String con la descripción de la palabra clave
      */
    public void modificarPalabra(String nombre, String descripcion)
    {
        DaoPalabraClave daoPalabraClave = new DaoPalabraClave();
        PalabraClave palabra= new PalabraClave();
        palabra.setNombre(nombre);
        palabra.setDescripcion(descripcion);

        daoPalabraClave.modificarPalabraClave(palabra);
    }

    /**
     * Consulta la palabra clave con el nombre especificado
     * @param nombre String con el nombre de la palabra clave
     * @return Un objeto PalabraClave con el nombre y la descripción de esta
     */
    public PalabraClave consultarPalabra(String nombre)
    {
        DaoPalabraClave daoPalabraClave = new DaoPalabraClave();
        PalabraClave palabra= new PalabraClave();
        palabra = daoPalabraClave.consultarPalabraClave(nombre);
        return palabra;
    }
    
    /**
     * Consulta todas las palabras clave existentes en la base de datos
     * @return ArrayList de PalabraClave con todas las palabras clave existentes
     */
    public ArrayList<PalabraClave> consultarTodasLasPalabrasClaves(){
        return new DaoPalabraClave().consultarTodasLasPalabraClave();
    }

    /**
     * Elimina una palabra clave de la base de datos,
     * @param nombre String con el nombre de la palabra clave a eliminar
     * @deprecated Para conservar la integridad de la información de la base de datos, no se recomienda eliminar palabras clave
     */
    @Deprecated
    public void eliminarPalabraClave(String nombre)
    {
        DaoPalabraClave daoPalabraClave = new DaoPalabraClave();
        daoPalabraClave.eliminarPalabraClave(nombre);
    }

    /**
     * Comprueba si la palabra clave con el nombre dado, existe en la base de datos
     * @param nombre String con el nombre de la palabra clave a comprobar
     * @return boolean indicando si la palabra clave existe en la base de datos
     * @deprecated Se puede usar consultarPalabra y comprobar si lo retornado es null
     */
    @Deprecated
    public boolean comprobarExistenciaPalabraClave(String nombre) {
         boolean respuesta;
         DaoPalabraClave daoPalabraClave= new DaoPalabraClave();
         respuesta= daoPalabraClave.comprobarExistenciaPalabraClave(nombre);
         return respuesta;
    }
}
