/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database1.accesoDatos;

import biblioteca.database1.beans.*;
import biblioteca.database1.fachada.Fachada;
import java.sql.*;

/**
 *
 * @author Eduardo
 */
public class DaoAutor {


    Fachada fachada;

    public DaoAutor(){
        fachada= new Fachada();
    }

     public int guardarAutor(Autor autor){
        String sql_guardar;
        sql_guardar="INSERT INTO autor(correo, nombre, apellido, acronimo) VALUES ('" +
                autor.getCorreo() + "', '" + autor.getNombre() +  "', '" +
                  autor.getApellido() + "', '"  + autor.getAcronimo()+ "');";
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

    public Autor consultarAutor(String correo){
        Autor autor= new Autor();
        String sql_consultar;
        sql_consultar="SELECT correo, nombre, apellido,acronimo FROM autor WHERE correo= '" +correo+ "';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultar);
            System.out.println("consultando en la bd");
            
            while(tabla.next()){
               System.out.println("correo: " + tabla.getString(1) + " Nombre: " + tabla.getString(2) + " apellido:" +  tabla.getString(3)+ " acronimo:" +  tabla.getString(4));
              autor.setCorreo(tabla.getString(1));
              autor.setNombre(tabla.getString(2));
              autor.setApellido(tabla.getString(3));
              autor.setAcronimo(tabla.getString(4));

              System.out.println("ok");
            }
            conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return autor;
    }


    public int modificarAutor(Autor autor)
    {
        String sql_modificar;
        sql_modificar="UPDATE autor  SET correo = '"+autor.getCorreo()+"', nombre = '"+autor.getNombre()+"', apellido = '"+autor.getApellido()+"', acronimo = '"+autor.getAcronimo()+
                 "' WHERE correo = '"+autor.getCorreo()+"';";
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

//    public int eliminarAutor(String correo)
//    {
//        String sql_eliminar;
//        sql_eliminar="DELETE FROM autor WHERE correo = '"+correo+"';";
//
//        try{
//            Connection conn= fachada.conectar();
//            Statement sentencia = conn.createStatement();
//            int numFilas = sentencia.executeUpdate(sql_eliminar);
//            System.out.println("se elimino exitosamente!!!!");
//            conn.close();
//            System.out.println("Conexion cerrada");
//            return numFilas;
//        }
//        catch(SQLException e){ System.out.println(e); }
//
//        return -1;
//    }


    public boolean comprobarExistenciaAutor(String correo)
    {
        String correoRecibido= new String();
        String sql_comprobar;
        sql_comprobar="SELECT correo FROM autor WHERE correo= '"+correo+"';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            System.out.println("se esta buscando si esta disponible!!!!");
            ResultSet tabla = sentencia.executeQuery(sql_comprobar);
            while(tabla.next()){
                correoRecibido=tabla.getString(1);
            }
             conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }

        if(correo.equals(correoRecibido))
        {
            System.out.println("NO esta disponible");
            return false;

        }
        System.out.println("SI esta disponible");
        return true;
    }

}
