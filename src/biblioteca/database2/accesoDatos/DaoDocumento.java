/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.accesoDatos;

import biblioteca.database2.fachada.Fachada;
import biblioteca.database2.beans.*;
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
    Fachada Fachada;
    public DaoDocumento(){
    Fachada = new Fachada();
    }
    
    public int insertarDocumento(Documento documento, String usuario){
        String sql_agregar;
        sql_agregar = "INSERT INTO documentos(activo, titulo_principal, "+
                "titulo_secundario, descripcion, idioma, editorial, fecha_publicacion, " +
                "derechos_autor, tipo_documento, catalogador)"+
                "VALUES ('" + "true" + "','" + documento.getTituloPrincipal() + "','" 
                + documento.getTituloSecundario() + "','"+ documento.getDescripcion() + "','"
                + documento.getIdioma() + "','" + documento.getEditorial() + "','" 
                + documento.getFechaPublicacion() + "','" + documento.getDerechosAutor() + "','"
                + documento.getTipoMaterial() + "','" + usuario + "');";

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
    
    public Documento consultarDocumento(String id_documento){
        String sql_consultar;
        sql_consultar="SELECT * FROM documentos WHERE doc_id='"+id_documento+"';";
        try{
            Connection conn= Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet salida=sentencia.executeQuery(sql_consultar);
            Documento documento = new Documento();
            while(salida.next()){
                documento.setActivo(true);
                documento.setID_documento(id_documento);
                documento.setTituloPrincipal(salida.getString("titulo_principal"));
                documento.setTituloSecundario(salida.getString("titulo_secundario"));
                documento.setDescripcion(salida.getString("descripcion"));
                documento.setTipoMaterial(salida.getString("tipo_documento"));
                documento.setIdioma(salida.getString("idioma"));
                documento.setEditorial(salida.getString("editorial"));
                documento.setFechaPublicacion(salida.getString("fecha_publicacion"));
                documento.setDerechosAutor(salida.getString("derechos_autor"));
                documento.setUbicacion(salida.getString("ubicacion"));
                documento.setFechaCatalogacion(salida.getString("fecha_catalogacion"));
            }
            conn.close();
            return documento;
            
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public String obtenerDocumentoID(Documento documento, String catalogador){
        String sql_consultar;
        sql_consultar="SELECT doc_id FROM documentos WHERE titulo_principal='"+
                documento.getTituloPrincipal()+"'AND titulo_secundario='"+
                documento.getTituloSecundario()+"'AND descripcion='"+
                documento.getDescripcion()+"'AND editorial='"+
                documento.getEditorial()+"'AND idioma='"+
                documento.getIdioma()+"'AND fecha_publicacion='"+
                documento.getFechaPublicacion()+"'AND derechos_autor='"+
                documento.getDerechosAutor()+"'AND catalogador='"+catalogador+"'";
        String id=null;
        try{
            Connection conn= Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet salida=sentencia.executeQuery(sql_consultar);
            if(salida.next()){
                id=salida.getString(1);
            }
            conn.close();
        }catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return id;
    }
    
    public int insertarUbicacion(String id_documento, String ubicacion){
        String sql_modificar;
        sql_modificar="UPDATE documentos SET ubicacion ='"+ubicacion+"' WHERE doc_id = '"
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
    public int deshabilitarDocumento(String id_documento){
        String sql_modificar;
        sql_modificar="UPDATE documentos SET activo = 'false' WHERE doc_id = '"
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
        String sql_modificar;
        sql_modificar = "UPDATE documentos SET activo ='" +documento.getActivo() +"',"+
                "titulo_principal='"+documento.getTituloPrincipal()+"',"+
                "titulo_secundario='"+ documento.getTituloSecundario() +"',"+
                "descripcion='" + documento.getDescripcion() +"',"+
                "idioma='" + documento.getIdioma() + "'," +
                "editorial='"+ documento.getEditorial() +"'," +
                "fecha_publicacion='" + documento.getFechaPublicacion() + "'," +
                "derechos_autor='"+ documento.getDerechosAutor() + "'," +
                "ubicacion='"+ documento.getUbicacion() + "'," +
                "tipo_documento='"+ documento.getTipoMaterial() + "'"+
                "WHERE doc_id='"+documento.getID_documento()+"'";

       try{
            Connection conn= Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            int num_filas=sentencia.executeUpdate(sql_modificar);
            conn.close();
            return num_filas;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }

       return -1;
    }
    //no le veo sentido a esta función.
    @Deprecated
    public boolean verificarExistencia(String id_documento){
        String sql_verificar;
        sql_verificar="SELECT * FROM documentos WHERE doc_id='"+id_documento+"';";
        try{
            Connection conn= Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet salida=sentencia.executeQuery(sql_verificar);
            conn.close();
            if(salida.next()){
                if(salida.wasNull()){
                    return false;
                }
                else return true;
            }
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return false;
    }
    //Esta función supone que el documento EXISTE y está ACTIVO
    public Documento verDatosDocumento(String id_documento, String usuario){
        String sql_consultar;
        sql_consultar="SELECT * FROM documentos WHERE doc_id='"+id_documento+"';";
        try{
            Connection conn= Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet salida=sentencia.executeQuery(sql_consultar);
            Documento documento = new Documento();
            while(salida.next()){
                documento.setActivo(true);
                documento.setID_documento(id_documento);
                documento.setTituloPrincipal(salida.getString("titulo_principal"));
                documento.setTituloSecundario(salida.getString("titulo_secundario"));
                documento.setDescripcion(salida.getString("descripcion"));
                documento.setTipoMaterial(salida.getString("tipo_documento"));
                documento.setIdioma(salida.getString("idioma"));
                documento.setEditorial(salida.getString("editorial"));
                documento.setFechaPublicacion(salida.getString("fecha_publicacion"));
                documento.setDerechosAutor(salida.getString("derechos_autor"));
                documento.setUbicacion(salida.getString("ubicacion"));
                documento.setFechaCatalogacion(salida.getString("fecha_catalogacion"));
            }
            conn.close();
            return documento;
            
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return null;
    }
    //identica a modificar documento
    @Deprecated
    public int actualizarDocumento(Documento documento){
        String sql_modificar;
        sql_modificar = "UPDATE documentos SET activo ='" +documento.getActivo() +"',"+
                "titulo_principal='"+documento.getTituloPrincipal()+"',"+
                "titulo_secundario='"+ documento.getTituloSecundario() +"',"+
                "descripcion='" + documento.getDescripcion() +"',"+
                "idioma='" + documento.getIdioma() + "'," +
                "editorial='"+ documento.getEditorial() +"'," +
                "fecha_publicacion='" + documento.getFechaPublicacion() + "'," +
                "derechos_autor='"+ documento.getDerechosAutor() + "'," +
                "ubicacion='"+ documento.getUbicacion() + "'," +
                "tipo_documento='"+ documento.getTipoMaterial() + "'"+
                "WHERE doc_id='"+documento.getID_documento()+"'";

       try{
            Connection conn= Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            int num_filas=sentencia.executeUpdate(sql_modificar);
            conn.close();
            return num_filas;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }

       return -1;
    }
    
    public void insertarAreas(ArrayList<Area> areas, String id_documento){
        try{
            Connection conn= Fachada.conectar();
            Statement sentencia = conn.createStatement();
            String sql_insertar;
            for(int i=0;i<areas.size();i++){
                sql_insertar="INSERT INTO documento_areas_computacion VALUES ('"+
                    areas.get(i).getID()+"','"+id_documento+"');";
                sentencia.addBatch(sql_insertar);
            }
            sentencia.executeBatch();
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
    }
    
    public void insertarPalabrasClave(ArrayList<PalabraClave> PC, String id_documento){
        try{
            Connection conn= Fachada.conectar();
            Statement sentencia = conn.createStatement();
            String sql_insertar;
            for(int i=0;i<PC.size();i++){
                sql_insertar="INSERT INTO documento_palabras_clave VALUES ('"+
                    id_documento+"','"+PC.get(i).getNombre() +"');";
                sentencia.addBatch(sql_insertar);
            }
            sentencia.executeBatch();
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
    }
    
    public void insertarAutores(ArrayList<Autor> emails, String id_documento){
        try{
            Connection conn= Fachada.conectar();
            Statement sentencia = conn.createStatement();
            String sql_insertar;
            for(int i=0;i<emails.size();i++){
                sql_insertar="INSERT INTO documento_autor VALUES ('"+
                    id_documento+"','"+emails.get(i).getCorreo() +"');";
                sentencia.addBatch(sql_insertar);
            }
            sentencia.executeBatch();
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
    }
    
    public void eliminarAreas(ArrayList<Area> areas, String id_documento){
        try{
            Connection conn= Fachada.conectar();
            Statement sentencia = conn.createStatement();
            String sql_eliminar;
            for(int i=0;i<areas.size();i++){
                sql_eliminar="DELETE FROM documento_areas_computacion WHERE"+
                        "area_id='"+ areas.get(i).getID()+"' AND doc_id='"+id_documento+"';";
                sentencia.addBatch(sql_eliminar);
            }
            sentencia.executeBatch();
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
    }
    
    public void eliminarPalabrasClave(ArrayList<PalabraClave> PC, String id_documento){
        try{
            Connection conn= Fachada.conectar();
            Statement sentencia = conn.createStatement();
            String sql_eliminar;
            for(int i=0;i<PC.size();i++){
                sql_eliminar="DELETE FROM documento_palabras_clave WHERE doc_id='"+
                    id_documento+"'AND nombre='"+PC.get(i).getNombre() +"';";
                sentencia.addBatch(sql_eliminar);
            }
            sentencia.executeBatch();
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
    }
    
    public void eliminarAutores(ArrayList<Autor> emails, String id_documento){
        try{
            Connection conn= Fachada.conectar();
            Statement sentencia = conn.createStatement();
            String sql_eliminar;
            for(int i=0;i<emails.size();i++){
                sql_eliminar="DELETE FROM documento_autor WHERE doc_id='"+
                    id_documento+"AND autor_correo='"+emails.get(i).getCorreo() +"';";
                sentencia.addBatch(sql_eliminar);
            }
            sentencia.executeBatch();
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
    }
    
    //public ResultSet consultarDocumento(ArrayList<String> datos){
        //TODO programar consultarDocumento
    //}
    
    //TODO programar consultaAvanzadaDocumento
    
    private void UsuarioConsultaDocumento(String id_documento, String usuario){
        String sql_insertar;
        sql_insertar="INSERT INTO usuario_consulta_documento (doc_id, username)"+
                "VALUES ('"+id_documento+"','"+usuario+"');";
        try{
            Connection conn= Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            sentencia.executeUpdate(sql_insertar);
            conn.close();
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
    }
    
    private void UsuarioDescargaDocumento(String id_documento, String usuario){
        String sql_insertar;
        sql_insertar="INSERT INTO usuario_descarga_documento (doc_id, username)"+
                "VALUES ('"+id_documento+"','"+usuario+"');";
        try{
            Connection conn= Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            sentencia.executeUpdate(sql_insertar);
            conn.close();
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
    }
    
    
}
