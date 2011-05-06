/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database1.controladores;

package controlador;


import accesoDatos.DaoPalabraClave;
import beans.PalabraClave;

/**
 *
 * @author Eduardo
 */
public class ControladorPalabraClave {

     public void InsertarPalabraClave(String nombre, String descripcion)
    {
        DaoPalabraClave daoPalabraClave = new DaoPalabraClave();
        PalabraClave palabra= new PalabraClave();
        palabra.setNombre(nombre);
        palabra.setDescripcion(descripcion);

        daoPalabraClave.guardarPalabraClave(palabra);
    }

    public void modificarPalabra(String nombre, String descripcion)
    {
        DaoPalabraClave daoPalabraClave = new DaoPalabraClave();
        PalabraClave palabra= new PalabraClave();
        palabra.setNombre(nombre);
        palabra.setDescripcion(descripcion);

        daoPalabraClave.modificarPalabraClave(palabra);
    }

    public PalabraClave consultarPalabra(String nombre)
    {
        DaoPalabraClave daoPalabraClave = new DaoPalabraClave();
        PalabraClave palabra= new PalabraClave();
        palabra = daoPalabraClave.consultarPalabraClave(nombre);
        return palabra;
    }

    public void eliminarPalabraClave(String nombre)
    {
        DaoPalabraClave daoPalabraClave = new DaoPalabraClave();
        daoPalabraClave.eliminarPalabraClave(nombre);
    }

      public boolean comprobarExistenciaPalabraClave(String nombre) {
         boolean respuesta;
         DaoPalabraClave daoPalabraClave= new DaoPalabraClave();
         respuesta= daoPalabraClave.comprobarExistenciaPalabraClave(nombre);
         return respuesta;
    }
}
