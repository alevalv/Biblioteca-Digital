/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.controladores;

import biblioteca.database2.accesoDatos.DaoDocumento;
import biblioteca.database2.beans.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

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
    
    public Documento consultarDocumento(String id_documento){
        return new DaoDocumento().consultarDocumento(id_documento);
    }
    
    public void insertarUbicacion(String id_documento, String ubicacion){
        new DaoDocumento().insertarUbicacion(id_documento, ubicacion);
    }
    
    public void modificarDocumento(String id_documento, String tituloPrincipal, String tituloSecundario,
             String editorial, String derechosAutor, String idioma, String descripcion,
             String tipoMaterial,String fechaPublicacion, boolean activo){
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
        daoDocumento.modificarDocumento(documento);
        
        //seguridad?
        daoDocumento= null;
        documento= null;
    }
    
    public String obtenerId(String tituloPrincipal, String tituloSecundario,
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
        return daoDocumento.obtenerDocumentoID(documento, catalogador);
    }
    
    @Deprecated
    public boolean verificarExistencia(String id_documento){
        DaoDocumento daoDocumento = new DaoDocumento();
        return daoDocumento.verificarExistencia(id_documento);
    }
    
    public Documento usuarioConsultaDocumento(String id_documento, String usuario){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.UsuarioConsultaDocumento(id_documento, usuario);
        return daoDocumento.consultarDocumento(id_documento);
    }
    
    public void usuarioDescargaDocumento(String documento, String usuario){
        new DaoDocumento().UsuarioDescargaDocumento(documento, usuario);
    }
    
    public void insertarPalabrasClave(String id_documento, ArrayList<PalabraClave> PC){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.insertarPalabrasClave(PC, id_documento);
    }
    
    public void insertarAreas(String id_documento, ArrayList<Area> Areas){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.insertarAreas(Areas, id_documento);
    }
    
    public void insertarAutores(String id_documento, ArrayList<Autor> emails){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.insertarAutores(emails, id_documento);
    }
    
    public void eliminarPalabrasClave(String id_documento, ArrayList<PalabraClave> PC){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.eliminarPalabrasClave(PC, id_documento);
    }
    public void eliminarAreas(String id_documento, ArrayList<Area> Areas){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.eliminarAreas(Areas, id_documento);
    }
    
    public void eliminarAutores(String id_documento, ArrayList<Autor> emails){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.eliminarAutores(emails, id_documento);
    }
    
    public ArrayList<PalabraClave> obtenerPalabrasClave(String id_documento){
        return new DaoDocumento().consultarPalabrasClaveDocumento(id_documento);
    }
    
    public ArrayList<Autor> obtenerAutores(String id_documento){
        return new DaoDocumento().consultarAutoresDocumento(id_documento);
    }
    
    public ArrayList<Area> obtenerAreas(String id_documento){
        return new DaoDocumento().consultarAreasDocumento(id_documento);
    }
    /*
     * 
     * La Salida es un ArrayList, donde se metera primero el id del documento, 
     * luego el titulo principal, titulo secundario y autor
     */
    
    public ArrayList<String> consultaDocumentoGeneral(String entrada){
        StringTokenizer Stk = new StringTokenizer(entrada, " ");
        ArrayList<String> metadatos = new ArrayList<String>();
        while(Stk.hasMoreTokens()){
            metadatos.add(Stk.nextToken());
        }
        return new DaoDocumento().consultarDocumento(metadatos);
    }
    
    public void consultaAvanzada(String titulo, String autor, String pc, int tituloopcion, int autoropcion, int pcopcion, String area, String editorial, String tipo_material, String idioma, int fecha, int formato) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    
}