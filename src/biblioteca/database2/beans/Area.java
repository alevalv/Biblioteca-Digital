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

    String area_id;
    String nombre;
    String descripcion;
    String Area_Padre;

    public Area(){}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setID(String id) {
        this.area_id = id;
    }

    public void setAreaPadre(String Area_Padre) {
        this.Area_Padre = Area_Padre;
    }

   public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getID() {
        return area_id;
    }

    public String getAreaPadre() {
        return Area_Padre;
    }

      public String getDescripcion() {
        return descripcion;
    }

      @Override
      public String toString(){
        return area_id+";\""+nombre+"\";"+Area_Padre;
    }
}