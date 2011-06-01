/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.beans;

/**
 *  Esta clase forma parte de los beans creados para cumplir con el Patrón
 * de diseño DAO.
 * 
 * Area representa la relación area_computacion de la base de datos.
 *
 * Es una clase de getters y setters.
 * 
 * @see <a href="http://www.proactiva-calidad.com/java/patrones/DAO.html">Patrón "Data Access Object"</a>
 * 
 * @author María Cristina Bustos Rodríguez
 * @author Alejandro Valdés Villada
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