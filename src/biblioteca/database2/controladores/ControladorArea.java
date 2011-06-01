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
 *
 * @author Eduardo
 */
public class ControladorArea {


     public void insertarArea(String descrpcion, String nombre, String Area_Padre)
    {
        Area area= new Area();
        DaoArea daoArea= new DaoArea();
        area.setDescripcion(descrpcion);
        area.setNombre(nombre);
        area.setAreaPadre(Area_Padre);

        daoArea.guardarArea(area);
    }

    public void modificarArea(String idArea, String descrpcion, String nombre, String Area_Padre)
    {
        Area area= new Area();
        DaoArea daoArea= new DaoArea();

        area.setID(idArea);
        area.setDescripcion(descrpcion);
        area.setNombre(nombre);
        area.setAreaPadre(Area_Padre);

        daoArea.modificarArea(area);

    }

    public Area consultarArea(String idArea)
    {
        Area area= new Area();
        DaoArea daoArea= new DaoArea();
        area= daoArea.consultarArea(idArea);
        return area;
    }
    
    public ArrayList<Area> consultarTodasLasAreas(){
        return new DaoArea().consultarTodasLasAreas();
    }

//    public void eliminarArea(String idArea)
//    {
//        DaoArea daoArea= new DaoArea();
//        daoArea.eliminarArea(idArea);
//    }

    public boolean comprobarExistenciaArea(String id_area) {
         boolean respuesta;
         DaoArea daoArea= new DaoArea();
         respuesta= daoArea.comprobarExistenciaArea(id_area);
         return respuesta;
    }

    ///para la relacion usuarios con area
     public ArrayList<Area> consultarAreasporUsuario(String Username){
        return new DaoArea().consultarAreasporUsuario(Username);
    }

     public int agregarAreasporUsuario(String Username, ArrayList<Area> areas){
         return new DaoArea().agregarAreasporUsuario(Username,areas);
     }

     public int eliminarAreasporUsuario(String Username, ArrayList<Area> areas){
         return new DaoArea().eliminarAreasporUsuario(Username, areas);
     }
}
