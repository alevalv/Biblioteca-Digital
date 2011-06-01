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

/**
 *
 * @author Julián David Rodríguez
 */

import java.sql.*;
import biblioteca.database2.beans.TipoDocumento;
import biblioteca.database2.fachada.Fachada;
import java.util.ArrayList;

public class DaoTipoDocumento {
    Fachada fachada;

    public DaoTipoDocumento()
    {
        fachada = new Fachada();
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
        catch(SQLException e){ System.err.println(e); }
        catch(Exception e){ System.err.println(e); }

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
        catch(SQLException e){ System.err.println(e); }
        catch(Exception e){ System.err.println(e); }
        return -1;
    }
    
    public TipoDocumento consultarTipoDocumento(String nombre){
        String sql_consultar;
        sql_consultar="SELECT * FROM  tipo_material WHERE tipo_documento = '" +
                nombre + "';";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultar);
            
            TipoDocumento tipoDocumento=null;
            if(tabla.next()){
                tipoDocumento.setTipoDocumento(tabla.getString(1));
                tipoDocumento.setDescripcion(tabla.getString(2));
            }
            conn.close();
            return tipoDocumento;

        }
        catch(SQLException e){ System.err.println(e); }
        catch(Exception e){ System.err.println(e); }
        return null;
    }
    
    public ArrayList<TipoDocumento> consultarTodosLosTipoDocumento(){
        String sql_consultar;
        sql_consultar="SELECT * FROM  tipo_material ORDER BY tipo_documento ASC;";
        ArrayList<TipoDocumento> Tipos = null;
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultar);
            
            Tipos = new ArrayList<TipoDocumento>();
            while(tabla.next()){
                TipoDocumento tipoDocumento=new TipoDocumento();
                tipoDocumento.setTipoDocumento(tabla.getString(1));
                tipoDocumento.setDescripcion(tabla.getString(2));
                Tipos.add(tipoDocumento);
            }
            conn.close();
            return Tipos;

        }
        catch(SQLException e){ System.err.println(e); }
        catch(Exception e){ System.err.println(e); }
        return null;
    }
}