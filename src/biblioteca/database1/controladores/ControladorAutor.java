/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database1.controladores;

import biblioteca.database1.accesoDatos.*;
import biblioteca.database1.beans.*;

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

          public boolean comprobarExistenciaAutor(String correo) {
         boolean respuesta;
         DaoAutor daoArea= new DaoAutor();
         respuesta= daoArea.comprobarExistenciaAutor(correo);
         return respuesta;
    }

}
