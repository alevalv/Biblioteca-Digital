/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database1.controladores;

import biblioteca.database1.accesoDatos.DaoMaterial;
import biblioteca.database1.beans.Material;
import java.util.ArrayList;

/**
 *
 * @author Eduardo
 */
public class ControladorMaterial {

//     public void insertarMaterial(String ID_Material, String editorial, String idioma, String derechosAutor, String resumen, String tituloPrincipal, String tituloSecundario, String fechaCreacion, String fechaPublicacion, String fechaCatalogacion, String tamaño, String resolucion, String formato, String softwareAdecuado, String tipo_Material, String descripcion_tipo)
//    {
//        DaoMaterial daoMaterial= new DaoMaterial();
//
//        Material Material = new Material();
//
//        Material.setID_Material(ID_Material);
//
//        Material.setEditorial(editorial);
//        Material.setIdioma(idioma);
//        Material.setDerechosAutor(derechosAutor);
//        Material.setResumen(resumen);
//        Material.setTituloPrincipal(tituloPrincipal);
//        Material.setTituloSecundario(tituloSecundario);
//        Material.setFechaCreacion(fechaCreacion);
//        Material.setFechaPublicacion(fechaPublicacion);
//        Material.setFechaCatalogacion(fechaCatalogacion);
//        Material.setTamaño(tamaño);
//        Material.setResolucion(resolucion);
//        Material.setFormato(formato);
//        Material.setSoftwareAdecuado(softwareAdecuado);
//        Material.setTipoMaterial(tipo_Material);
//        Material.setDescripcionTipo(descripcion_tipo);
//
//        daoMaterial.guardarMaterial(Material);
//    }

     public void modificarMaterial( String ID_Material, String editorial, String idioma, String derechosAutor, String resumen, String tituloPrincipal, String tituloSecundario, String fechaCreacion, String fechaPublicacion, String fechaCatalogacion, String tamaño, String resolucion, String formato, String softwareAdecuado, String tipo_Material, String descripcion_tipo)
    {
        DaoMaterial daoMaterial= new DaoMaterial();

        Material Material = new Material();
      
        Material.setID_material(ID_Material);
        
        Material.setEditorial(editorial);
        Material.setIdioma(idioma);
        Material.setDerechosAutor(derechosAutor);
        Material.setResumen(resumen);
        Material.setTituloPrincipal(tituloPrincipal);
        Material.setTituloSecundario(tituloSecundario);
        Material.setFechaCreacion(fechaCreacion);
        Material.setFechaPublicacion(fechaPublicacion);
        Material.setFechaCatalogacion(fechaCatalogacion);
        Material.setTamaño(tamaño);
        Material.setResolucion(resolucion);
        Material.setFormato(formato);
        Material.setSoftwareAdecuado(softwareAdecuado);
        Material.setTipoMaterial(tipo_Material);
        Material.setDescripcionTipo(descripcion_tipo);

        daoMaterial.modificarMaterial(Material);
    }

     public boolean verificarExistencia(String ID_Material)
    {
        return true;
    }

     public Material verdatosMaterial(String ID_Material)
    {
        Material Material= new Material();
        DaoMaterial daoMaterial= new DaoMaterial();

        Material=daoMaterial.consultarMaterial(ID_Material);

        return Material;
    }

     public void insertarPalabrasClavesMaterial(String ID_Material, ArrayList<String> PC)
    {
        DaoMaterial daoMaterial= new DaoMaterial();
        daoMaterial.insertarPalabrasClaves(PC, ID_Material);
    }

    public void insertarAreasMaterial(String ID_Material, ArrayList<String> areas)
    {
        DaoMaterial daoMaterial= new DaoMaterial();
        daoMaterial.insertarAreas(areas, ID_Material);
    }

    public void insertarAutorMaterial(String ID_Material, String email)
    {
        DaoMaterial daoMaterial= new DaoMaterial();
        daoMaterial.insertarAutor(email, ID_Material);
    }

    public void eliminarPalabrasClavesMaterial(String ID_Material, ArrayList<String> PC)
    {
        DaoMaterial daoMaterial= new DaoMaterial();
        daoMaterial.eliminarPalabrasClaves(PC, ID_Material);
    }

    public void eliminarAreasMaterial(String ID_Material, ArrayList<String> areas)
    {
        DaoMaterial daoMaterial= new DaoMaterial();
        daoMaterial.eliminarAreas(areas, ID_Material);
    }

    public void eliminarAutor(String ID_Material, String correo)
    {
        DaoMaterial daoMaterial= new DaoMaterial();
        daoMaterial.eliminarAutor(correo, ID_Material);
    }

    public void catalogaMaterial(String username, String ID_Material, String editorial, String idioma, String derechosAutor, String resumen, String tituloPrincipal, String tituloSecundario, String fechaCreacion, String fechaPublicacion, String fechaCatalogacion, String tamaño, String resolucion, String formato, String softwareAdecuado, String tipo_Material, String descripcion_tipo)
    {
        DaoMaterial daoMaterial= new DaoMaterial();
        Material Material = new Material();
        
        Material.setID_material(ID_Material);
       
        Material.setEditorial(editorial);
        Material.setIdioma(idioma);
        Material.setDerechosAutor(derechosAutor);
        Material.setResumen(resumen);
        Material.setTituloPrincipal(tituloPrincipal);
        Material.setTituloSecundario(tituloSecundario);
        Material.setFechaCreacion(fechaCreacion);
        Material.setFechaPublicacion(fechaPublicacion);
        Material.setFechaCatalogacion(fechaCatalogacion);
        Material.setTamaño(tamaño);
        Material.setResolucion(resolucion);
        Material.setFormato(formato);
        Material.setSoftwareAdecuado(softwareAdecuado);
        Material.setTipoMaterial(tipo_Material);
        Material.setDescripcionTipo(descripcion_tipo);

        daoMaterial.catalogaMaterial(username,Material);
    }


}
