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
package biblioteca.database2.accesoDatos;
 
import biblioteca.database2.beans.*;
import biblioteca.database2.fachada.Fachada;
import java.sql.*;
import java.util.ArrayList;
/**
 *  Esta clase forma parte de los controladores creados para cumplir con el Patrón
 * de diseño DAO.
 * 
 * <br>DaoArea crea el sql que se ejecutará a través de una conexión de una Fachada,
 * este dao administra todo lo relacionado con las áreas en la aplicación
 * 
 * @see <a href="http://www.proactiva-calidad.com/java/patrones/DAO.html">Patrón "Data Access Object"</a>
 *
 * @author María Cristina Bustos Rodríguez
 * @author Alejandro Valdés Villada
 */
public class DaoArea {

    Fachada fachada;

    /**
     * Crea un nuevo objeto DaoArea, inicializando la fachada
     */
   public DaoArea(){
        fachada= new Fachada();
    }

   /**
    * Guarda un área en la base de datos
    * @param are Area con los datos del área a agregar
    * @return -1 si la operación no se pudo realizar
    */
     public int guardarArea(Area are){
        String sql_guardar;
        sql_guardar="INSERT INTO areas_computacion(descripcion, nombre, area_padre) VALUES ('" +
                are.getDescripcion() + "', '" + are.getNombre() 
                + "', '"  + are.getAreaPadre()+ "');";
        //System.out.println(sql_guardar);
        try{
            Connection conect= fachada.conectar();
            Statement sentencia = conect.createStatement();
            int numFilas = sentencia.executeUpdate(sql_guardar);
            conect.close();            
            return numFilas;
        }
        catch(SQLException e){ System.err.println(e); }
        catch(Exception e){ System.err.println(e); }
        return -1;
    }

     /**
      * Consulta en la base de datos el área a través del identificador especificado
      * @param id String con el identificador del área a consultar
      * @return Area con los datos del área encontrada
      */
    public Area consultarArea(String id){
        Area a= new Area();
        String sql_consultar;
        sql_consultar="SELECT * FROM areas_computacion WHERE area_id= '" +id+ "';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultar);
            
            //
            while(tabla.next()){
              a.setID(tabla.getString(1));
              a.setNombre(tabla.getString(2));
              a.setDescripcion(tabla.getString(3));
              a.setAreaPadre(tabla.getString(4));
            }
            conn.close();

         }
         catch(SQLException e){ System.err.println(e); }
         catch(Exception e){ System.err.println(e); }
        return a;
    }
    
    /**
     * Consulta todas las áreas existentes en la base de datos
     * @return ArrayList de Area con todas las áreas de la base de datos
     */
     public ArrayList<Area> consultarTodasLasAreas(){
         String sql_consultar;
         sql_consultar="SELECT * FROM areas_computacion WHERE NOT area_id='0' ORDER BY nombre ASC;";
         ArrayList<Area> Areas=null;
         try{
             Connection conn= fachada.conectar();
             Statement sentencia = conn.createStatement();
             ResultSet tabla = sentencia.executeQuery(sql_consultar);
             Areas= new ArrayList<Area>();
             while(tabla.next()){
                 Area a= new Area();
                 a.setID(tabla.getString(1));
                 a.setNombre(tabla.getString(2));
                 a.setDescripcion(tabla.getString(3));
                 a.setAreaPadre(tabla.getString(4));
                 Areas.add(a);
             }
            conn.close();

         }
         catch(SQLException e){ System.err.println(e); }
         catch(Exception e){ System.err.println(e); }
        return Areas;
    }

     /**
      * Modifica un área de la base de datos, especificando el identificador, que viene en area
      * @param area Area con los datos nuevos y el identificador
      * @return -1 si la operación no fue exitosa
      */
    public int modificarArea(Area area)
    {
        String sql_modificar;
        sql_modificar="UPDATE areas_computacion SET descripcion = '"+area.getDescripcion()+"', nombre = '"+area.getNombre()+
                 "', area_padre='"+area.getAreaPadre()+ "' WHERE area_id = '"+area.getID()+"';";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_modificar);
            conn.close();
            return numFilas;
        }
        catch(SQLException e){ System.err.println(e); }

        return -1;
    }

    /**
     * Elimina un área de la base de datos
     * @param idArea String con el identificador del área a eliminar
     * @return -1 si la operación no fue exitosa
     * @deprecated No es recomendable eliminar áreas de la base de datos, se pude generar perdida de información
     */
    @Deprecated
    public int eliminarArea(String idArea)
    {
        String sql_eliminar;
        sql_eliminar="DELETE FROM area WHERE id_area = '"+idArea+"';";

       try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_eliminar);
            System.out.println("se elimino exitosamente!!!!");
            conn.close();
            System.out.println("Conexion cerrada");
            return numFilas;
        }
        catch(SQLException e){ System.err.println(e); }

        return -1;
    }

    /**
     * Comprueba la existencia de un área en la base de datos
     * @param id_area String con el identificador del área a consultar
     * @return boolean indicando si el área existe o no
     * @deprecated Use consultarArea(String) y compruebe si lo retornado es null
     */
    @Deprecated
     public boolean comprobarExistenciaArea(String id_area)
    {
        String id_areaRecibido= new String();
        String sql_comprobar;
        sql_comprobar="SELECT area_id FROM areas_computacion WHERE area_id= '"+id_area+"';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_comprobar);
            while(tabla.next()){
                id_areaRecibido=tabla.getString(1);
            }
             conn.close();
         }
         catch(SQLException e){ System.err.println(e); }
         catch(Exception e){ System.err.println(e); }

        if(id_area.equals(id_areaRecibido))
        {
            return false;
        }
        return true;
    }

    /**
     * Consulta las áreas relacionadas a un usuario particular
     * @param Username String con el login(username) del usuario a consultar
     * @return ArrayList de Area con las áreas relacionadas al usuario seleccionado
     */
    public ArrayList<Area> consultarAreasporUsuario(String Username) {
       String sql_consultar;
         sql_consultar="SELECT area_id,nombre,descripcion,area_padre FROM usuario_areas_computacion natural join areas_computacion where username='"+Username+"';";
         ArrayList<Area> Areas=null;
         try{
             Connection conn= fachada.conectar();
             Statement sentencia = conn.createStatement();
             ResultSet tabla = sentencia.executeQuery(sql_consultar);
             Areas= new ArrayList<Area>();
             while(tabla.next()){
                 Area a= new Area();
                 a.setID(tabla.getString(1));
                 a.setNombre(tabla.getString(2));
                 a.setDescripcion(tabla.getString(3));
                 a.setAreaPadre(tabla.getString(4));
                 Areas.add(a);
             }
            conn.close();

         }
         catch(SQLException e){ System.err.println(e); }
         catch(Exception e){ System.err.println(e); }
        return Areas;
    }

    /**
     * Agrega un conjunto de áreas al usuario seleccionado
     * @param Username String con el login(username) del usuario a modificar
     * @param areas ArrayList de Area con las a insertar
     * @return -1 si la operación no fue exitosa
     */
    public int agregarAreasporUsuario(String Username, ArrayList<Area> areas) {
       String sql_agregar="";
       for(int i=0;i<areas.size();i++){
        sql_agregar+="INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('" +
                areas.get(i).getID() + "', '" +  Username
                + "');";
        }
       //System.out.println(sql_agregar);
        try{
            Connection conect= fachada.conectar();
            Statement sentencia = conect.createStatement();
            int numFilas = sentencia.executeUpdate(sql_agregar);
            conect.close();
            return numFilas;
        }
        catch(SQLException e){ System.err.println(e); }
        catch(Exception e){ System.err.println(e); }
        return -1;
    }

    /**
     * Elimina un conjunto de áreas relacionadas con un usuario
     * @param Username String con el login(username) del usuario a modificar
     * @param areas ArrayList de Area con las áreas a modificar
     * @return -1 si la operación no fue exitosa
     */
    public int eliminarAreasporUsuario(String Username, ArrayList<Area> areas) {
        String sql_eliminar="";
       for(int i=0;i<areas.size();i++){
        sql_eliminar+="DELETE FROM usuario_areas_computacion WHERE area_id='" +
                areas.get(i).getID() + "' and Username='" +  Username
                + "';";
        }
        try{
            Connection conect= fachada.conectar();
            Statement sentencia = conect.createStatement();
            int numFilas = sentencia.executeUpdate(sql_eliminar);
            conect.close();
            return numFilas;
        }
        catch(SQLException e){ System.err.println(e); }
        catch(Exception e){ System.err.println(e); }
        return -1;
    }
}

