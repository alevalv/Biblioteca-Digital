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
    
    public ArrayList<PalabraClave> consultarTodasLasPalabrasClaves(){
        return new DaoPalabraClave().consultarTodasLasPalabraClave();
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
