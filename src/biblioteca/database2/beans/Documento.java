/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.beans;

/**
 *  Esta clase forma parte de los beans creados para cumplir con el Patrón
 * de diseño DAO.
 * 
 * Documento representa la relación documentos de la base de datos.
 *
 * Es una clase de getters y setters.
 * 
 * @see <a href="http://www.proactiva-calidad.com/java/patrones/DAO.html">Patrón "Data Access Object"</a>
 * 
 * @author María Cristina Bustos Rodríguez
 * @author Alejandro Valdés Villada
 */

public class Documento {
    String id_documento;
    boolean activo;
    String editorial;
    String derechosAutor;
    String idioma;
    String descripcion;
    String tituloPrincipal;
    String tituloSecundario;
    String fechaPublicacion;
    String fechaCatalogacion;
    String tipoDocumento;
    String ubicacion;

    public void Documento(){ }

     public void setID_documento(String id_documento) {
        this.id_documento = id_documento;
    }
     
     public void setActivo(boolean activo){
         this.activo=activo;
    }

      public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

      public void setDerechosAutor(String derechosAutor) {
        this.derechosAutor = derechosAutor;
    }

     public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

     public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

     public void setTituloPrincipal(String tituloPrincipal) {
        this.tituloPrincipal = tituloPrincipal;
    }

     public void setTituloSecundario(String tituloSecundario) {
        this.tituloSecundario = tituloSecundario;
    }

     public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

     public void setFechaCatalogacion(String fechaCatalogacion) {
        this.fechaCatalogacion = fechaCatalogacion;
    }
     
     public void setTipoMaterial(String tipoMaterial) {
        this.tipoDocumento = tipoMaterial;
    }
     
     public void setUbicacion(String ubicacion) {
         this.ubicacion=ubicacion;
     }

     public String getID_documento() {
        return id_documento;
     }
     
     public boolean getActivo() {
         return activo;
     }

     public String getDescripcion() {
        return descripcion;
     }

     public String getDerechosAutor() {
        return derechosAutor;
     }

     public String getEditorial() {
        return editorial;
     }

     public String getIdioma() {
        return idioma;
     }

     public String getTituloPrincipal() {
        return tituloPrincipal;
     }

     public String getTituloSecundario() {
        return tituloSecundario;
     }

     public String getFechaPublicacion() {
        return fechaPublicacion;
     }

     public String getFechaCatalogacion() {
        return fechaCatalogacion;
     }

     public String getTipoMaterial() {
        return tipoDocumento;
     }
     
     public String getUbicacion() {
         return ubicacion;
     }
}