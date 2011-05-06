/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database1.accesoDatos;

package accesoDatos;

import beans.*;
import java.sql.*;

/**
 *
 * @author Eduardo
 */
public class DaoPalabraClave {

      Fachada fachada;

   public DaoPalabraClave(){
        fachada= new Fachada();
    }

     public int guardarPalabraClave(PalabraClave palabra){
        String sql_guardar;
        sql_guardar="INSERT INTO palabra_clave(nombre, descripcion) VALUES ('" +
                palabra.getNombre() + "', '" + palabra.getDescripcion() +  "')";
        try{
            Connection conect= fachada.conectar();
            Statement sentencia = conect.createStatement();
            int numFilas = sentencia.executeUpdate(sql_guardar);
            System.out.println("se guardo exitosamente!!!!");
            conect.close();
            System.out.println("Conexion cerrada");
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }

    public PalabraClave consultarPalabraClave(String nombre_pal){
        PalabraClave palabra= new PalabraClave();
        String sql_consultar;
        sql_consultar="SELECT nombre, descripcion FROM palabra_clave WHERE nombre= '" +nombre_pal+ "';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultar);
            System.out.println("consultando en la bd");

            while(tabla.next()){
               System.out.println("nombre: " + tabla.getString(1) + " descripcion: " + tabla.getString(2) );
              palabra.setNombre(tabla.getString(1));
              palabra.setDescripcion(tabla.getString(2));
              System.out.println("ok");
            }
            conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return palabra;
    }


    public int modificarPalabraClave(PalabraClave palabra)
    {
        String sql_modificar;
        sql_modificar="UPDATE palabra_clave  SET nombre = '"+palabra.getNombre()+"', descripcion = '"+palabra.getDescripcion()+
                 "' WHERE nombre = '"+palabra.getNombre()+"';";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_modificar);
            System.out.println("se modifico exitosamente!!!!");
            conn.close();
            System.out.println("Conexion cerrada");
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }

        return -1;
    }

    public int eliminarPalabraClave(String nombre_pal)
    {
        String sql_eliminar;
        sql_eliminar="DELETE FROM palabra_clave WHERE nombre = '"+nombre_pal+"';";

        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_eliminar);
            System.out.println("se elimino exitosamente!!!!");
            conn.close();
            System.out.println("Conexion cerrada");
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }

        return -1;
    }

     public boolean comprobarExistenciaPalabraClave(String nombre)
    {
        String nombreRecibido= new String();
        String sql_comprobar;
        sql_comprobar="SELECT nombre FROM palabra_clave WHERE nombre= '"+nombre+"';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            System.out.println("se esta buscando si esta disponible!!!!");
            ResultSet tabla = sentencia.executeQuery(sql_comprobar);
            while(tabla.next()){
                nombreRecibido=tabla.getString(1);
            }
             conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }

        if(nombre.equals(nombreRecibido))
        {
            System.out.println("NO esta disponible");
            return false;

        }
        System.out.println("SI esta disponible");
        return true;
    }

}
