/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.accesoDatos;

import biblioteca.database2.beans.*;
import biblioteca.database2.fachada.Fachada;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Alejandro Valdés Villada
 */
public class DaoPalabraClave {

      Fachada fachada;

   public DaoPalabraClave(){
        fachada= new Fachada();
    }

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
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }

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
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return palabra;
    }

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
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return Palabras;
    }
    

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
        catch(SQLException e){ System.out.println(e); }

        return -1;
    }

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
        catch(SQLException e){ System.out.println(e); }

        return -1;
    }

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
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }

        if(nombre.equals(nombreRecibido))
        {
            return false;

        }
        return true;
    }

}
