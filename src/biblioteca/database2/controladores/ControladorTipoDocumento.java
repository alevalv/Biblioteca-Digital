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

import biblioteca.database2.accesoDatos.DaoTipoDocumento;
import biblioteca.database2.beans.TipoDocumento;
import java.util.ArrayList;

/**
 *  Esta clase forma parte de los controladores creados para cumplir con el Patrón
 * de diseño DAO.
 * 
 * ControladorTipoDocumento es una de las interfaces entre los Dao y las GUI de la aplicación.
 * ControladorTipoDocumento se encarga de administrar los tipos de documento de la base de datos
 * La llave primaria de un tipo de documento es el nombre de este.
 * 
 * @see <a href="http://www.proactiva-calidad.com/java/patrones/DAO.html">Patrón "Data Access Object"</a>
 *
 * @author María Cristina Bustos Rodríguez
 * @author Alejandro Valdés Villada
 */
public class ControladorTipoDocumento {
    
    /**
     * Inserta un nuevo tipo de documento a la base de datos con los parametros dados
     * @param nombre String con el nombre del tipo de documento
     * @param descripcion String con la descripción del tipo de documento
     */
    public int agregarTipoDocumento(String nombre, String descripcion){
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setTipoDocumento(nombre);
        tipoDocumento.setDescripcion(descripcion);
        DaoTipoDocumento daoTipoDocumento = new DaoTipoDocumento();
        return daoTipoDocumento.agregarTipoDocumento(tipoDocumento);
    }
    
    /**
     * Modifica un tipo de documento de la base de datos con el nombre especificado
     * @param nombre String con el nombre del tipo de documento a modificar
     * @param descripcion String con la nueva descripción para el tipo de documento nuevo
     */
    public int modificarTipoDocumento(String nombre, String descripcion){
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setTipoDocumento(nombre);
        tipoDocumento.setDescripcion(descripcion);
        DaoTipoDocumento daoTipoDocumento = new DaoTipoDocumento();
        return daoTipoDocumento.modificarTipoDocumento(tipoDocumento);
    }
    
    /**
     * Consulta el tipo de documento especificado por el nombre dado
     * @param nombre String con el nombre del tipo de documento
     * @return TipoDocumento con los datos encontrados en la base de datos
     */
    public TipoDocumento consultarTipoDocumento(String nombre){
        DaoTipoDocumento daoTipoDocumento = new DaoTipoDocumento();
        TipoDocumento salida=daoTipoDocumento.consultarTipoDocumento(nombre);
        return salida;
    }
    
    /**
     * Consulta todos los tipos de documento existentes en la base de datos
     * @return ArrayList de TipoDocumento
     */
    public ArrayList<TipoDocumento> consultarTodosLosTipoDocumento(){
        return new DaoTipoDocumento().consultarTodosLosTipoDocumento();
    }
}
