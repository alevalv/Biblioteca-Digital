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
public class DaoAutor {


    Fachada fachada;

    public DaoAutor(){
        fachada= new Fachada();
    }

     public int guardarAutor(Autor autor){
        String sql_guardar;
        sql_guardar="INSERT INTO autor(autor_correo, nombre, apellido, acronimo) VALUES ('" +
                autor.getCorreo() + "', '" + autor.getNombre() +  "', '" +
                  autor.getApellido() + "', '"  + autor.getAcronimo()+ "');";
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

    public Autor consultarAutor(String correo){
        Autor autor= new Autor();
        String sql_consultar;
        sql_consultar="SELECT * FROM autor WHERE correo= '" +correo+ "';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultar);
            while(tabla.next()){
              autor.setCorreo(tabla.getString(1));
              autor.setAcronimo(tabla.getString(2));
              autor.setApellido(tabla.getString(3));
              autor.setNombre(tabla.getString(4));
            }
            conn.close();

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return autor;
    }
    
    public ArrayList<Autor> consultarTodos(){
        ArrayList<Autor> autores = null;
        String sql_consultar;
        sql_consultar="SELECT * FROM autor ORDER BY autor_correo ASC;";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultar);
            autores = new ArrayList<Autor>();
            while(tabla.next()){
              Autor autor = new Autor();
              autor.setCorreo(tabla.getString(1));
              autor.setAcronimo(tabla.getString(2));
              autor.setApellido(tabla.getString(3));
              autor.setNombre(tabla.getString(4));
              autores.add(autor);
            }
            conn.close();

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return autores;
    }

    public int modificarAutor(Autor autor)
    {
        String sql_modificar;
        sql_modificar="UPDATE autor  SET autor_correo = '"+autor.getCorreo()+"', nombre = '"+autor.getNombre()+"', apellido = '"+autor.getApellido()+"', acronimo = '"+autor.getAcronimo()+
                 "' WHERE autor_correo = '"+autor.getCorreo()+"';";
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
        sql_comprobar="SELECT autor_correo FROM autor WHERE autor_correo= '"+correo+"';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_comprobar);
            while(tabla.next()){
                correoRecibido=tabla.getString(1);
            }
             conn.close();

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }

        if(correo.equals(correoRecibido))
        {
            return false;

        }
        return true;
    }

}

