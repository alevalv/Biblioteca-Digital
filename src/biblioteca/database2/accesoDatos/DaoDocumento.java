/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.accesoDatos;

import biblioteca.database2.fachada.fachada;
import biblioteca.database2.beans.Documento;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Alejandro Valdés
 */
public class DaoDocumento {
    fachada Fachada;
    public DaoDocumento(){
    Fachada = new fachada();
    }
    
    public int insertarDocumento(Documento documento, String usuario){
        String sql_agregar;
        sql_agregar = "INSERT INTO documentos(activo, titulo_principal, "+
                "titulo_secundario, descripcion, idioma, editorial, fecha_publicacion, " +
                "derechos_autor, ubicacion, tipo_documento, catalogador)"+
                "VALUES ('" + "true" + "','" + documento.getTituloPrincipal() + "','" 
                + documento.getTituloSecundario() + "','"+ documento.getDescripcion() + "','"
                + documento.getIdioma() + "','" + documento.getEditorial() + "','" 
                + documento.getFechaPublicacion() + "','" + documento.getDerechosAutor() + "','"
                + documento.getUbicacion() + "','" + documento.getTipoMaterial() + "','"
                + usuario + "')";

       try{
            Connection conn= Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            int num_filas=sentencia.executeUpdate(sql_agregar);
            conn.close();
            return num_filas;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }

       return -1;
    }
    
    public int deshabilitarDocumento(String id_documento){
        String sql_modificar;
        sql_modificar="UPDATE documento SET activo = 'false' WHERE doc_id = '"
                + id_documento + "';";
        try{
            Connection conn= Fachada.conectar();
            Statement sentencia = conn.createStatement();
            int num_filas = sentencia.executeUpdate(sql_modificar);
            conn.close();
            return num_filas;

        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }
    
    public int modificarDocumento(Documento documento){
        //TODO modificarDocumento
        return -1;
    }
    public int verificarExistencia(String id_documento){
        //TODO verificarDocumento
        return -1;
    }
    public Documento verDatosDocumento(String id_documento, String usuario){
        //TODO verDatosDocumento
        return new Documento();
    }
    public int actualizarDocumento(Documento documento){
        //TODO actualizarDocumento
        return -1;
    }
    public int insertarAreas(ArrayList<String> areas, String documento){
        //TODO insertarAreas
        return -1;
    }
    public int insertarPalabrasClave(ArrayList<String> PC, String documento){
        //TODO insertarPalabrasClave
        return -1;
    }
    public int insertarAutor(String email, String id_documento){
        //TODO insertarAutor
        return -1;
    }
    public int eliminarAreas(ArrayList<String> areas, String documento){
        //TODO eliminarAreas
        return -1;
    }
    public int eliminarPalabrasClave(ArrayList<String> PC, String documento){
        //TODO eliminarPalabrasClave
        return -1;
    }
    public int eliminarAutor(String email, String id_documento){
        //TODO eliminarAutor
        return -1;
    }
    public ResultSet consultarDocumento(String datos){
        return 1;
    }
    public ResultSet consultarDocumento(ArrayList<String> datos){
        return 1;
    }
    public int descargarDocumento(String id_documento, String usuario){
        return -1;
    }
    
    
}
