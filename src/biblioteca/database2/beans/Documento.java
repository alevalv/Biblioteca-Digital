/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.beans;

/**
 *
 * @author Eduardo
 */
public class Documento {
    String id_documento;    
    String editorial;
    String derechosAutor;
    String idioma;
    String descripcion;
    String tituloPrincipal;
    String tituloSecundario;
    String fechaCreacion;
    String fechaPublicacion;
    String fechaCatalogacion;
    String tipoDocumento;

    public void Documento(){ }

     public void setID_documento(String id_documento) {
        this.id_documento = id_documento;
    }

      public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
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

     public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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

     public String getID_documento() {
        return id_documento;
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

     public String getFechaCreacion() {
        return fechaCreacion;
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




}