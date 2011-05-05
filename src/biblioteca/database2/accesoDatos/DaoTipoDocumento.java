/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.accesoDatos;

/**
 *
 * @author Julián David Rodríguez
 */

import java.sql.*;
import biblioteca.database2.beans.TipoDocumento;
import biblioteca.database2.fachada.fachada;

public class DaoTipoDocumento {
    fachada fachada;

    public DaoTipoDocumento()
    {
        fachada = new fachada();
    }

    public int agregarTipoDocumento(TipoDocumento tipoDocumento)
    {
       String sql_agregar;
       sql_agregar = "INSERT INTO tipo_material(tipo_documento, descripcion) VALUES ('" +
               tipoDocumento.getTipoDocumento() + "','" + tipoDocumento.getDescripcion() + "')";

       try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_agregar);
            conn.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }

       return -1;
    }

    public int modificarTipoDocumento(TipoDocumento tipoDocumento){
        String sql_modificar;
        sql_modificar="UPDATE tipo_material SET tipo_documento = '"+ 
                tipoDocumento.getTipoDocumento() + "' WHERE descripcion = '"
                + tipoDocumento.getDescripcion() + "';";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_modificar);
            conn.close();
            return numFilas;

        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }
    
    public TipoDocumento consultarDocumento(String nombre){
        String sql_consultar;
        sql_consultar="SELECT FROM  tipo_material WHERE tipo_documento = '" +
                nombre + "';";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultar);
            
            TipoDocumento tipoDocumento=null;
            if(!tabla.wasNull()){
                tipoDocumento.setTipoDocumento(tabla.getString(1));
                tipoDocumento.setDescripcion(tabla.getString(2));
            }
            conn.close();
            return tipoDocumento;

        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }
}