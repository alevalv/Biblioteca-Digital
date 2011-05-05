/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.beans;

/**
 *
 * @author Julián David Rodríguez
 */
public class TipoDocumento {
        String tipoDocumento;
        String descripcion;

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
