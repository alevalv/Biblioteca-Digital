/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database1.controladores;

package controlador;

import accesoDatos.DaoDocumento;
import beans.Documento;
import java.util.Vector;

/**
 *
 * @author Eduardo
 */
public class ControladorDocumento {

//     public void insertarDocumento(String ID_Documento, String editorial, String idioma, String derechosAutor, String resumen, String tituloPrincipal, String tituloSecundario, String fechaCreacion, String fechaPublicacion, String fechaCatalogacion, String tamaño, String resolucion, String formato, String softwareAdecuado, String tipo_Documento, String descripcion_tipo)
//    {
//        DaoDocumento daoDocumento= new DaoDocumento();
//
//        Documento documento = new Documento();
//
//        documento.setID_documento(ID_Documento);
//
//        documento.setEditorial(editorial);
//        documento.setIdioma(idioma);
//        documento.setDerechosAutor(derechosAutor);
//        documento.setResumen(resumen);
//        documento.setTituloPrincipal(tituloPrincipal);
//        documento.setTituloSecundario(tituloSecundario);
//        documento.setFechaCreacion(fechaCreacion);
//        documento.setFechaPublicacion(fechaPublicacion);
//        documento.setFechaCatalogacion(fechaCatalogacion);
//        documento.setTamaño(tamaño);
//        documento.setResolucion(resolucion);
//        documento.setFormato(formato);
//        documento.setSoftwareAdecuado(softwareAdecuado);
//        documento.setTipoMaterial(tipo_Documento);
//        documento.setDescripcionTipo(descripcion_tipo);
//
//        daoDocumento.guardarDocumento(documento);
//    }

     public void modificarDocumento( String ID_Documento, String editorial, String idioma, String derechosAutor, String resumen, String tituloPrincipal, String tituloSecundario, String fechaCreacion, String fechaPublicacion, String fechaCatalogacion, String tamaño, String resolucion, String formato, String softwareAdecuado, String tipo_Documento, String descripcion_tipo)
    {
        DaoDocumento daoDocumento= new DaoDocumento();

        Documento documento = new Documento();
      
        documento.setID_documento(ID_Documento);
        
        documento.setEditorial(editorial);
        documento.setIdioma(idioma);
        documento.setDerechosAutor(derechosAutor);
        documento.setResumen(resumen);
        documento.setTituloPrincipal(tituloPrincipal);
        documento.setTituloSecundario(tituloSecundario);
        documento.setFechaCreacion(fechaCreacion);
        documento.setFechaPublicacion(fechaPublicacion);
        documento.setFechaCatalogacion(fechaCatalogacion);
        documento.setTamaño(tamaño);
        documento.setResolucion(resolucion);
        documento.setFormato(formato);
        documento.setSoftwareAdecuado(softwareAdecuado);
        documento.setTipoMaterial(tipo_Documento);
        documento.setDescripcionTipo(descripcion_tipo);

        daoDocumento.modificarDocumento(documento);
    }

     public boolean verificarExistencia(String ID_Documento)
    {
        return true;
    }

     public Documento verdatosDocumento(String ID_Documento)
    {
        Documento documento= new Documento();
        DaoDocumento daoDocumento= new DaoDocumento();

        documento=daoDocumento.consultarDocumento(ID_Documento);

        return documento;
    }

     public void insertarPalabrasClavesDocumento(String ID_Documento, Vector<String> PC)
    {
        DaoDocumento daoDocumento= new DaoDocumento();
        daoDocumento.insertarPalabrasClaves(PC, ID_Documento);
    }

    public void insertarAreasDocumento(String ID_Documento, Vector<String> areas)
    {
        DaoDocumento daoDocumento= new DaoDocumento();
        daoDocumento.insertarAreas(areas, ID_Documento);
    }

    public void insertarAutorDocumento(String ID_Documento, String email)
    {
        DaoDocumento daoDocumento= new DaoDocumento();
        daoDocumento.insertarAutor(email, ID_Documento);
    }

    public void eliminarPalabrasClavesDocumento(String ID_Documento, Vector<String> PC)
    {
        DaoDocumento daoDocumento= new DaoDocumento();
        daoDocumento.eliminarPalabrasClaves(PC, ID_Documento);
    }

    public void eliminarAreasDocumento(String ID_Documento, Vector<String> areas)
    {
        DaoDocumento daoDocumento= new DaoDocumento();
        daoDocumento.eliminarAreas(areas, ID_Documento);
    }

    public void eliminarAutor(String ID_Documento, String correo)
    {
        DaoDocumento daoDocumento= new DaoDocumento();
        daoDocumento.eliminarAutor(correo, ID_Documento);
    }

    public void catalogaDocumento(String username, String ID_Documento, String editorial, String idioma, String derechosAutor, String resumen, String tituloPrincipal, String tituloSecundario, String fechaCreacion, String fechaPublicacion, String fechaCatalogacion, String tamaño, String resolucion, String formato, String softwareAdecuado, String tipo_Documento, String descripcion_tipo)
    {
        DaoDocumento daoDocumento= new DaoDocumento();
        Documento documento = new Documento();
        
        documento.setID_documento(ID_Documento);
       
        documento.setEditorial(editorial);
        documento.setIdioma(idioma);
        documento.setDerechosAutor(derechosAutor);
        documento.setResumen(resumen);
        documento.setTituloPrincipal(tituloPrincipal);
        documento.setTituloSecundario(tituloSecundario);
        documento.setFechaCreacion(fechaCreacion);
        documento.setFechaPublicacion(fechaPublicacion);
        documento.setFechaCatalogacion(fechaCatalogacion);
        documento.setTamaño(tamaño);
        documento.setResolucion(resolucion);
        documento.setFormato(formato);
        documento.setSoftwareAdecuado(softwareAdecuado);
        documento.setTipoMaterial(tipo_Documento);
        documento.setDescripcionTipo(descripcion_tipo);

        daoDocumento.catalogaDocumento(username,documento);
    }


}
