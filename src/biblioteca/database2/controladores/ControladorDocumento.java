/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.controladores;

import biblioteca.database2.accesoDatos.DaoDocumento;
import biblioteca.database2.beans.Documento;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.StringTokenizer;

/**
 *
 * @author Alejandro Valdés Villada
 */
public class ControladorDocumento {
    
    public void insertarDocumento(String tituloPrincipal, String tituloSecundario,
             String editorial, String derechosAutor, String idioma, String descripcion,
             String tipoMaterial,String fechaPublicacion, String catalogador){
        Documento documento = new Documento();
        documento.setActivo(true);
        documento.setDerechosAutor(derechosAutor);
        documento.setDescripcion(descripcion);
        documento.setEditorial(editorial);
        documento.setFechaPublicacion(fechaPublicacion);
        documento.setIdioma(idioma);
        documento.setTipoMaterial(tipoMaterial);
        documento.setTituloPrincipal(tituloPrincipal);
        documento.setTituloSecundario(tituloSecundario);
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.insertarDocumento(documento, catalogador);
        
        //seguridad?
        daoDocumento= null;
        documento= null;
    }
    
    public void deshabilitarDocumento(String id_documento){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.deshabilitarDocumento(id_documento);
    }
    
    public void modificarDocumento(String id_documento, boolean activo,
            String editorial, String derechosAutor, String idioma, 
            String descripcion, String tipoMaterial, String tituloPrincipal,
            String tituloSecundario, String fechaPublicacion, String tipoDocumento){
        Documento documento = new Documento();
        documento.setID_documento(id_documento);
        documento.setDerechosAutor(derechosAutor);
        documento.setActivo(activo);
        documento.setDescripcion(descripcion);
        documento.setEditorial(editorial);
        documento.setFechaPublicacion(fechaPublicacion);
        documento.setIdioma(idioma);
        documento.setTipoMaterial(tipoMaterial);
        documento.setTituloPrincipal(tituloPrincipal);
        documento.setTituloSecundario(tituloSecundario);
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.actualizarDocumento(documento);
        
        //seguridad?
        daoDocumento= null;
        documento= null;
    }
    
    @Deprecated
    public boolean verificarExistencia(String id_documento){
        DaoDocumento daoDocumento = new DaoDocumento();
        return daoDocumento.verificarExistencia(id_documento);
    }
    
    public Documento verDatos(String id_documento, String usuario){
        DaoDocumento daoDocumento = new DaoDocumento();
        return daoDocumento.verDatosDocumento(id_documento, usuario);
        //TODO
    }
    
    public void insertarPalabrasClave(String id_documento, ArrayList<String> PC){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.insertarPalabrasClave(PC, id_documento);
    }
    
    public void insertarAreas(String id_documento, ArrayList<String> Areas){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.insertarAreas(Areas, id_documento);
    }
    
    public void insertarAutores(String id_documento, ArrayList<String> emails){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.insertarAutores(emails, id_documento);
    }
    
    public void eliminarPalabrasClave(String id_documento, ArrayList<String> PC){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.eliminarPalabrasClave(PC, id_documento);
    }
    public void eliminarAreas(String id_documento, ArrayList<String> Areas){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.eliminarAreas(Areas, id_documento);
    }
    
    public void eliminarAutores(String id_documento, ArrayList<String> emails){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.eliminarAutores(emails, id_documento);
    }
    /*
     * 
     * La Salida es un ArrayList, donde se metera primero el id del documento, 
     * luego el titulo principal, titulo secundario y autor
     */
    /*
    public ArrayList<String> consultaDocumentoGeneral(String metadatos){
        StringTokenizer Stk = new StringTokenizer(metadatos, " ");
        ArrayList<String> ListMetadatos = new ArrayList<String>();
        while(Stk.hasMoreTokens()){
            ListMetadatos.add(Stk.nextToken());
        }
        DaoDocumento daoDocumento = new DaoDocumento();
        ResultSet salida=daoDocumento.consultarDocumento(ListMetadatos);
        ArrayList<String> ResultadoConsulta = new ArrayList<String>();
        try{
            while(salida.next()){
                ResultadoConsulta.add(salida.getString(1));
                ResultadoConsulta.add(salida.getString(2));
                ResultadoConsulta.add(salida.getString(3));
                ResultadoConsulta.add(salida.getString(4));
            }
        }catch(SQLException se){
            System.err.println(se);
        }
        return ResultadoConsulta;
    }
    
    public ArrayList<String> consultaDocumentoAvanzada(String titulo, String autor, 
            String pc, int opcion1, int opcion2, int opcion3, String area, 
            String idioma, int fecha, String formato){
        
    }*/
    
    public void descargarDocumento(String documento, String usuario){
        
    }
}