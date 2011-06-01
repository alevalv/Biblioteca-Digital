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
 * TipoDocumento representa la relación tipo_documento de la base de datos.
 *
 * Es una clase de getters y setters.
 * 
 * @see <a href="http://www.proactiva-calidad.com/java/patrones/DAO.html">Patrón "Data Access Object"</a>
 * 
 * @author María Cristina Bustos Rodríguez
 * @author Alejandro Valdés Villada
 */
public class TipoDocumento {
        String tipoDocumento;
        String descripcion;
        
        /**
        * Construye un objeto vacio de tipo TipoDocumento
        */
        public TipoDocumento(){}

        public void setTipoDocumento(String tipoDocumento)
        {
            this.tipoDocumento = tipoDocumento;
        }

        public void setDescripcion(String descripcion)
        {
            this.descripcion = descripcion;
        }
        
        public String getTipoDocumento()
        {
            return tipoDocumento;
        }

        public String getDescripcion()
        {
            return descripcion;
        }

}
