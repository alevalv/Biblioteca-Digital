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
 * <br>DaoPalabraClave crea el sql que se ejecutará a través de una conexión de una Fachada,
 * este dao administra todo lo relacionado con los palabras claves de la base de datos
 * 
 * @see <a href="http://www.proactiva-calidad.com/java/patrones/DAO.html">Patrón "Data Access Object"</a>
 *
 * @author María Cristina Bustos Rodríguez
 * @author Alejandro Valdés Villada
 */
public class DaoPalabraClave {

      Fachada fachada;

      /**
       * Crea un objeto DaoPalabraClave, inicializando fachada
       */
   public DaoPalabraClave(){
        fachada= new Fachada();
    }

   /**
    * Inserta una nueva palabra clave a la base de datos
    * @param palabra PalabraClave con los datos de la nueva palabra clave
    * @return -1 si la consulta no fue exitosa
    */
     public int guardarPalabraClave(PalabraClave palabra){
        String sql_guardar;
        sql_guardar="INSERT INTO palabras_clave(nombre, descripcion) VALUES ('" +
                palabra.getNombre() + "', '" + palabra.getDescripcion() +  "')";
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
      * Consulta los datos relacionados con el nombre de la palabra clave dado
      * @param nombre_pal String con el nombre de la palabra clave a consultar
      * @return PalabraClave con los datos relacionados al nombre
      */
    public PalabraClave consultarPalabraClave(String nombre_pal){
        PalabraClave palabra= new PalabraClave();
        String sql_consultar;
        sql_consultar="SELECT * FROM palabras_clave WHERE nombre= '" +nombre_pal+ "';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultar);
            if(tabla.next()){
                palabra.setNombre(tabla.getString(1));
                palabra.setDescripcion(tabla.getString(2));
            }
            conn.close();
         }
         catch(SQLException e){ System.err.println(e); }
         catch(Exception e){ System.err.println(e); }
        return palabra;
    }

    /**
     * Consulta todas las palabras claves existentes en la base de datos
     * @return ArrayList de PalabraClave con todas las palabras clave
     */
    public ArrayList<PalabraClave> consultarTodasLasPalabraClave(){
        ArrayList<PalabraClave> Palabras = null;
        String sql_consultar;
        sql_consultar="SELECT * FROM palabras_clave ORDER BY nombre ASC;";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultar);
            Palabras = new ArrayList<PalabraClave>();
            while(tabla.next()){
                PalabraClave palabra= new PalabraClave();
                palabra.setNombre(tabla.getString(1));
                palabra.setDescripcion(tabla.getString(2));
                Palabras.add(palabra);
            }
            conn.close();
         }
         catch(SQLException e){ System.err.println(e); }
         catch(Exception e){ System.err.println(e); }
        return Palabras;
    }
    
    /**
     * Modifica la palabra clave, según el nombre dado.
     * @param palabra PalabraClave con el nombre y la descripcion de la palabra clave
     * @return -1 si la consulta no fue exitosa
     */
    public int modificarPalabraClave(PalabraClave palabra)
    {
        String sql_modificar;
        sql_modificar="UPDATE palabras_clave  SET nombre = '"+palabra.getNombre()+"', descripcion = '"+palabra.getDescripcion()+
                 "' WHERE nombre = '"+palabra.getNombre()+"';";
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
     * Elimina la palabra clave con el nombre especificado
     * @param nombre_pal String con el nombre de la palabra clave a eliminar
     * @return -1 si la operación no fue exitosa
     * @deprecated No se recomienda eliminar palabras clave de la base de datos, genera perdida de información
     */
    @Deprecated
    public int eliminarPalabraClave(String nombre_pal)
    {
        String sql_eliminar;
        sql_eliminar="DELETE FROM palabras_clave WHERE nombre = '"+nombre_pal+"';";

        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_eliminar);
            conn.close();
            return numFilas;
        }
        catch(SQLException e){ System.err.println(e); }

        return -1;
    }

    /**
     * Comprueba si la palabra clave con el nombre dado, existe en la base de datos
     * @param nombre String con el nombre de la palabra clave a consultar
     * @return boolean indicando si la palabra clave existe o no
     * @deprecated Use consultarPalabraClave(String) verificando si lo retornado es nulo
     */
    @Deprecated
    public boolean comprobarExistenciaPalabraClave(String nombre)
    {
        String nombreRecibido= new String();
        String sql_comprobar;
        sql_comprobar="SELECT nombre FROM palabras_clave WHERE nombre= '"+nombre+"';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_comprobar);
            while(tabla.next()){
                nombreRecibido=tabla.getString(1);
            }
             conn.close();

         }
         catch(SQLException e){ System.err.println(e); }
         catch(Exception e){ System.err.println(e); }

        if(nombre.equals(nombreRecibido))
        {
            return false;

        }
        return true;
    }

}
