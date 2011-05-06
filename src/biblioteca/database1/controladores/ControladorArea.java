/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database1.controladores;

package controlador;

import accesoDatos.DaoArea;
import beans.Area;

/**
 *
 * @author Eduardo
 */
public class ControladorArea {


     public void insertarArea(String idArea, String descrpcion, String nombre, String idSubarea)
    {
        Area area= new Area();
        DaoArea daoArea= new DaoArea();

        area.setID(idArea);
        area.setDescripcion(descrpcion);
        area.setNombre(nombre);
        area.setIDSubarea(idSubarea);

        daoArea.guardarArea(area);
    }

    public void modficarArea(String idArea, String descrpcion, String nombre, String idSubarea)
    {
        Area area= new Area();
        DaoArea daoArea= new DaoArea();

        area.setID(idArea);
        area.setDescripcion(descrpcion);
        area.setNombre(nombre);
        area.setIDSubarea(idSubarea);

        daoArea.modificarArea(area);

    }

    public Area consultarArea(String idArea)
    {
        Area area= new Area();
        DaoArea daoArea= new DaoArea();
        area= daoArea.consultarArea(idArea);
        return area;
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
