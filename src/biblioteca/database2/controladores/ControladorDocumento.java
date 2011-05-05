/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.controladores;

import biblioteca.database2.accesoDatos.DaoDocumento;
import biblioteca.database2.beans.Documento;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author alejandro
 */
public class ControladorDocumento {
    
    public void insertarDocumento(String id_documento, String editorial,
            String derechosAutor, String idioma, String descripcion, String tipoMaterial,
            String tituloPrincipal, String tituloSecundario, String fechaCreacion,
            String fechaPublicacion, String fechaCatalogacion, String tipoDocumento,
            String catalogador){
        Documento documento = new Documento();
        documento.setID_documento(id_documento);
        documento.setDerechosAutor(derechosAutor);
        documento.setDescripcion(descripcion);
        documento.setEditorial(editorial);
        documento.setFechaCatalogacion(fechaCatalogacion);
        documento.setFechaCreacion(fechaCreacion);
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
    
    public void modificarDocumento(String id_documento, String editorial,
            String derechosAutor, String idioma, String descripcion, String tipoMaterial,
            String tituloPrincipal, String tituloSecundario, String fechaCreacion,
            String fechaPublicacion, String tipoDocumento){
        Documento documento = new Documento();
        documento.setID_documento(id_documento);
        documento.setDerechosAutor(derechosAutor);
        documento.setDescripcion(descripcion);
        documento.setEditorial(editorial);
        documento.setFechaCreacion(fechaCreacion);
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
    
    public boolean verificarExistencia(String id_documento){
        DaoDocumento daoDocumento = new DaoDocumento();
        int numero=daoDocumento.verificarExistencia(id_documento);
        if(numero!=-1){
            return true;
        }
        else return false;
    }
    
    public ResultSet verDatos(String id_documento, String usuario){
        //TODO
    }
    
    public void insertarPalabrasClave(String id_documento, ArrayList<String> PC){
        
    }
    
    public void insertarAreas(String id_documento, ArrayList<String> Areas){
        
    }
    
    public void insertarAutor(String id_documento, String email){
        
    }
    
    public void eliminarPalabrasClave(String id_documento, ArrayList<String> PC){
        
    }
    public void eliminarAreas(String id_documento, ArrayList<String> Areas){
        
    }
    
    public void eliminarAutor(String id_documento, String email){
        
    }
    
    public ResultSet consultaDocumentoGeneral(String metadatos){
        
    }
    
    public ResultSet consultaDocumentoAvanzada(String titulo, String autor, 
            String pc, int opcion1, int opcion2, int opcion3, String area, 
            String idioma, int fecha, String formato){
        
    }
    
    public void descargarDocumento(String documento, String usuario){
        
    }
}