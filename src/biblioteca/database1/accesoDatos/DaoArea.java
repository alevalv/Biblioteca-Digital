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
public class DaoArea {

    Fachada fachada;

   public DaoArea(){
        fachada= new Fachada();
    }

     public int guardarArea(Area are){
        String sql_guardar;
        sql_guardar="INSERT INTO area(descripcion, nombre, id_area, id_subarea) VALUES ('" +
                are.getDescripcion() + "', '" + are.getNombre() +  "', '" +
                  are.getID() + "', '"  +
                 are.getIDSubarea()+ "');";
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

    public Area consultarArea(String id){
        Area a= new Area();
        String sql_consultar;
        sql_consultar="SELECT id_area, nombre, descripcion,id_subarea FROM area WHERE id_area= '" +id+ "';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultar);
            System.out.println("consultando en la bd");
            
            //
            while(tabla.next()){
               System.out.println("id_area: " + tabla.getString(1) + " Nombre: " + tabla.getString(2) + " Descripcion:" +  tabla.getString(3)+ " Id subarea:" +  tabla.getString(4));
              a.setID(tabla.getString(1));
              a.setNombre(tabla.getString(2));
              a.setDescripcion(tabla.getString(3));
              a.setIDSubarea(tabla.getString(4));

              System.out.println("ok");
            }
            conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return a;
    }


    public int modificarArea(Area area)
    {
        String sql_modificar;
        sql_modificar="UPDATE area  SET descripcion = '"+area.getDescripcion()+"', nombre = '"+area.getNombre()+
                 "' WHERE id_area = '"+area.getID()+"';";
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

//    public int eliminarArea(String idArea)
//    {
//        String sql_eliminar;
//        sql_eliminar="DELETE FROM area WHERE id_area = '"+idArea+"';";
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

     public boolean comprobarExistenciaArea(String id_area)
    {
        String id_areaRecibido= new String();
        String sql_comprobar;
        sql_comprobar="SELECT id_area FROM area WHERE id_area= '"+id_area+"';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            System.out.println("se esta buscando si esta disponible!!!!");
            ResultSet tabla = sentencia.executeQuery(sql_comprobar);
            while(tabla.next()){
                id_areaRecibido=tabla.getString(1);
            }
             conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }

        if(id_area.equals(id_areaRecibido))
        {
            System.out.println("NO esta disponible");
            return false;

        }
        System.out.println("SI esta disponible");
        return true;
    }
}

