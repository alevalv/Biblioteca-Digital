/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.beans;

/**
 *
 * @author Eduardo
 */
public class Area {

    String idArea;
    String nombre;
    String descripcion;
    String idSubarea;

    public Area(){}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setID(String id) {
        this.idArea = id;
    }

    public void setIDSubarea(String idSubarea) {
        this.idSubarea = idSubarea;
    }

   public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getID() {
        return idArea;
    }

    public String getIDSubarea() {
        return idSubarea;
    }

      public String getDescripcion() {
        return descripcion;
    }


}