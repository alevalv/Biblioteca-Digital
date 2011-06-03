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


import biblioteca.database2.accesoDatos.*;
import biblioteca.database2.beans.*;
import java.util.ArrayList;

/**
 *  Esta clase forma parte de los controladores creados para cumplir con el Patrón
 * de diseño DAO.
 * 
 * ControladorAutor es una de las interfaces entre los Dao y las GUI de la aplicación.
 * ControladorAutor se encarga de administrar los autores existentes, agregar nuevos,
 * consultarlos, etc.
 * La llave primaria de los autores es su correo electronico
 * 
 * @see <a href="http://www.proactiva-calidad.com/java/patrones/DAO.html">Patrón "Data Access Object"</a>
 *
 * @author María Cristina Bustos Rodríguez
 * @author Alejandro Valdés Villada
 */
public class ControladorAutor {

    /**
     * inserta un usuario en la base de datos con los datos especificados.
     * @param nombre String con el nombre del autor
     * @param apellido String con el/los apellido(s) del autor
     * @param correo_e String con el correo electronico del autor (unico)
     * @param acronimo String con el acronimo del autor
     */
      public int insertarAutor(String nombre, String apellido, String correo_e, String acronimo)
    {
        DaoAutor daoAutor= new DaoAutor();
        Autor autor= new Autor();

        autor.setAcronimo(acronimo);
        autor.setApellido(apellido);
        autor.setCorreo(correo_e);
        autor.setNombre(nombre);

        return daoAutor.guardarAutor(autor);
    }

      /**
       * Elimina un autor de la base de datos, dado su correo electronico
       * @param correo_e String con el correo electronico del autor a eliminar
       * @deprecated No es recomendable eliminar autores de la base de datos, se generaría perdida de información
       */
      @Deprecated
      public void eliminarAutor(String correo_e)
    {
        DaoAutor daoAutor= new DaoAutor();
        daoAutor.eliminarAutor(correo_e);
    }

      /**
       * Modifica un autor con los parametros seleccionados, el autor es selecccionado por el correo electronico que se entrega
       * @param correo_e String con el correo electronico del autor a modificar
       * @param nombre String con el/los nuevo(s) nombre(s) para el autor
       * @param acronimo String con el nuevo acronimo para el autor
       * @param apellido String con el/los nuevo(s) apellido(s) para el autor
       */
       public void modificarAutor(String correo_e, String nombre, String acronimo, String apellido)
    {
        DaoAutor daoAutor= new DaoAutor();
        Autor autor= new Autor();

        autor.setAcronimo(acronimo);
        autor.setApellido(apellido);
        autor.setCorreo(correo_e);
        autor.setNombre(nombre);

        daoAutor.modificarAutor(autor);
    }

       /**
        * Consulta la información de un autor de la base de datos según el correo electronico especificado
        * @param correo_e String con el correo electronico del autor a modificar
        * @return Autor con la información obtenida del autor en la base de datos
        */
        public Autor consultarAutor(String correo_e)
    {
        DaoAutor daoAutor= new DaoAutor();
        Autor autor= new Autor();
        autor=daoAutor.consultarAutor(correo_e);
        return autor;
    }
        
        /**
         * Obtiene todos los autores existentes de la base de datos
         * @return ArrayList de Autor con los autores existentes en la base de datos
         */
        public ArrayList<Autor> obtenerTodosLosAutores(){
            return new DaoAutor().consultarTodos();
        }

          public boolean comprobarExistenciaAutor(String correo) {
         boolean respuesta;
         DaoAutor daoArea= new DaoAutor();
         respuesta= daoArea.comprobarExistenciaAutor(correo);
         return respuesta;
    }

}
