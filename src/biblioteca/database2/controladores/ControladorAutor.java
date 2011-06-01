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
 *
 * @author Eduardo
 */
public class ControladorAutor {

      public void insertarAutor(String nombre, String apellido, String correo_e, String acronimo)
    {
        DaoAutor daoAutor= new DaoAutor();
        Autor autor= new Autor();

        autor.setAcronimo(acronimo);
        autor.setApellido(apellido);
        autor.setCorreo(correo_e);
        autor.setNombre(nombre);

        daoAutor.guardarAutor(autor);
    }

//      public void eliminarAutor(String correo_e)
//    {
//        DaoAutor daoAutor= new DaoAutor();
//        daoAutor.eliminarAutor(correo_e);
//    }

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

        public Autor consultarAutor(String correo_e)
    {
        DaoAutor daoAutor= new DaoAutor();
        Autor autor= new Autor();
        autor=daoAutor.consultarAutor(correo_e);
        return autor;
    }
        
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
