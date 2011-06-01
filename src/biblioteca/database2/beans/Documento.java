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
     
     /**
      * Cambia el estado del documento seleccionado
      * @param activo boolean con el valor para el campo activo
      */
     public void setActivo(boolean activo){
         this.activo=activo;
     }

     /**
      * Cambia la editorial del documento seleccionado
      * @param editorial String con la editorial
      */
     public void setEditorial(String editorial) {
        this.editorial = editorial;
     }

     /**
      * Cambia los derechos de Autor del documento seleccionado
      * @param derechosAutor String con el derecho de autor para el documento
      */
      public void setDerechosAutor(String derechosAutor) {
        this.derechosAutor = derechosAutor;
      }

     /**
       * Cambia el idioma del docuemnto seleccionado
       * @param idioma String con el idioma del documento
       */ 
     public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

     /**
      * Cambia la descripción del documento seleccionado
      * @param descripcion String con la nueva descripción para el documento
      */
     public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

     /**
      * Cambia el titulo principal del documento seleccionado
      * @param tituloPrincipal String con el titulo principal del documento
      */
     public void setTituloPrincipal(String tituloPrincipal) {
        this.tituloPrincipal = tituloPrincipal;
    }

     /**
      * Cambia el titulo secundario del documento seleccionado
      * @param tituloSecundario String con el titulo secundario del documento
      */
     public void setTituloSecundario(String tituloSecundario) {
        this.tituloSecundario = tituloSecundario;
    }

     /**
      * Cambia la fecha de publicación del documento seleccionado
      * @param fechaPublicacion String con la fecha de publicación, la fecha debe estar en un formato aceptado por SQL
      */
     public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

     /**
      * Cambia la fecha de catalogacion del documento seleccionado
      * es recomendable no modificar esta fecha debido a que es generada
      * automaticamente por la base de datos
      * @param fechaCatalogacion String con la fecha de catalogación, la fecha debe estar en un formato aceptado por SQL
      */
     public void setFechaCatalogacion(String fechaCatalogacion) {
        this.fechaCatalogacion = fechaCatalogacion;
    }
     
     /**
      * cambia el tipo de material del documento, este tipo de material
      * debe existir en la tabla tipo_material
      * @param tipoMaterial String que representa el tipo de material
      */
     public void setTipoMaterial(String tipoMaterial) {
        this.tipoDocumento = tipoMaterial;
    }
     
     /**
      * Cambia la ubicación del documento (el path) que se guarda en la base de datos
      * @param ubicacion String representando el path del documento seleccionado
      */
     public void setUbicacion(String ubicacion) {
         this.ubicacion=ubicacion;
     }

     /**
      * Obtiene el identificador unico del documento
      * @return String que representa el identificador numerico del documento seleccionado
      */
     public String getID_documento() {
        return id_documento;
     }
     
     /**
      * Obtiene el valor de Activo del documento seleccionado
      * @return boolean representando el valor de Activo del documento
      */
     public boolean getActivo() {
         return activo;
     }

     /**
      * Obtiene la descripción del documento seleccionado
      * @return String que contiene la descripción del documento
      */
     public String getDescripcion() {
        return descripcion;
     }

     /**
      * Obtiene los derechos de Autor del documento seleccionado
      * @return String que contiene los derechos de Autor del documento seleccionado
      */
     public String getDerechosAutor() {
        return derechosAutor;
     }

     /**
      * Obtiene la editorial del documento seleccionado
      * @return String que contiene la editorial del documento seleccionado
      */
     public String getEditorial() {
        return editorial;
     }

     /**
      * Obtiene el idioma del documento seleccionado
      * @return String que contiene el idioma del documento seleccionado
      */
     public String getIdioma() {
        return idioma;
     }

     /**
      * Obtiene el titulo principal del documento seleccionado
      * @return String que contiene el titulo principal del documento seleccionado
      */
     public String getTituloPrincipal() {
        return tituloPrincipal;
     }

     /**
      * Obtiene el titulo secundario del documento seleccionado
      * @return String que contiene el titulo secundario del documento seleccionado
      */
     public String getTituloSecundario() {
        return tituloSecundario;
     }

     /**
      * Obtiene la fecha de publicación del documento seleccionado,
      * esta fecha esta en el formato YYYY-MM-DD
      * @return String que contiene la fecha de publicación del documento seleccionado
      */
     public String getFechaPublicacion() {
        return fechaPublicacion;
     }

     /**
      * Obtiene la fecha de catalogación del documento seleccionado,
      * esta fecha esta en el formato YYYY-MM-DD
      * @return String que contiene la fecha de catalogación del documento seleccionado
      */
     public String getFechaCatalogacion() {
        return fechaCatalogacion;
     }

     /**
      * Obtiene el tipo de material del documento seleccionado,
      * este, es una <b>foreign key</b> de la tabla tipo_material
      * @return String que contiene el tipo de material relacionado con el documento seleccionado
      */
     public String getTipoMaterial() {
        return tipoDocumento;
     }
     
     /**
      * Obtiene la ubicación del documento seleccionado
      * @return String que contiene la ubicación del documento seleccionado
      */
     public String getUbicacion() {
         return ubicacion;
     }
}