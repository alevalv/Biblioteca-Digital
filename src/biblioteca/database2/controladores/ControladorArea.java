/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
}
