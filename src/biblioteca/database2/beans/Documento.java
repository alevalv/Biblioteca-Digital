/*
 * This file is part of Biblioteca-Digital de Univalle.
 *
 * Biblioteca-Digital de Univalle is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Biblioteca-Digital de Univalle is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with Biblioteca-Digital de Univalle.  If not, see <http://www.gnu.org/licenses/>.
 * 
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

    /**
     * Construye un objeto vacio de tipo Documento
     */
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