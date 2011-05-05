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

    String nombre;
    String id_documento;
    String descripcion;
    String editorial;
    String derechosAutor;
    String idioma;
    String resumen;
    String tituloPrincipal;
    String tituloSecundario;
    String fechaCreacion;
    String fechaPublicacion;
    String fechaCatalogacion;
    String tamaño;
    String resolucion;
    String formato;
    String softwareAdecuado;
    String tipoMaterial;
    String descripcion_tipo;


    public Documento(){ }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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

     public void setResumen(String resumen) {
        this.resumen = resumen;
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

     public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

     public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

     public void setFormato(String formato) {
        this.formato = formato;
    }
     
     public void setSoftwareAdecuado(String softwareAdecuado) {
        this.softwareAdecuado = softwareAdecuado;
    }
     
     public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }
     
     public void setDescripcionTipo(String descripcion_tipo) {
        this.descripcion_tipo = descripcion_tipo;
    }


     public String getNombre() {
        return nombre;
    }

     public String getID_documento() {
        return id_documento;
     }

     public String getDescripcion() {
        return descripcion;
     }

     public String getFormato() {
        return formato;
     }

     public String getDerechosAutor() {
        return derechosAutor;
     }

     public String getEditorial() {
        return editorial;
     }

     public String getResumen() {
        return resumen;
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

     public String getResolucion() {
        return resolucion;
     }

     public String getTamaño() {
        return tamaño;
     }

     public String getSoftwareAdecuado() {
        return softwareAdecuado;
     }

     public String getTipoMaterial() {
        return tipoMaterial;
     }

     public String getDescripcionTipo() {
        return descripcion_tipo;
     }




}