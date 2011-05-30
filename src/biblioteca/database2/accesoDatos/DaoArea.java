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
public class DaoArea {

    Fachada fachada;

   public DaoArea(){
        fachada= new Fachada();
    }

     public int guardarArea(Area are){
        String sql_guardar;
        sql_guardar="INSERT INTO areas_computacion(descripcion, nombre, area_padre) VALUES ('" +
                are.getDescripcion() + "', '" + are.getNombre() 
                + "', '"  + are.getAreaPadre()+ "');";
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
    
     public ArrayList<Area> consultarTodasLasAreas(){
         String sql_consultar;
         sql_consultar="SELECT * FROM areas_computacion ORDER BY area_id ASC;";
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
//        catch(SQLException e){ System.err.println(e); }
//
//        return -1;
//    }

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

    public int agregarAreasporUsuario(String Username, ArrayList<Area> areas) {
       String sql_agregar="";
       for(int i=0;i<areas.size();i++){
        sql_agregar+="INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('" +
                areas.get(i).getID() + "', '" +  Username
                + "');";
        }
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

