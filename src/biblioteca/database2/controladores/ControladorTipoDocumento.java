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
package biblioteca.database2.controladores;

import biblioteca.database2.accesoDatos.DaoTipoDocumento;
import biblioteca.database2.beans.TipoDocumento;
import java.util.ArrayList;

/**
 *
 * @author Alejandro Valdés
 */
public class ControladorTipoDocumento {
    public void agregarTipoDocumento(String nombre, String descripcion){
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setTipoDocumento(nombre);
        tipoDocumento.setDescripcion(descripcion);
        DaoTipoDocumento daoTipoDocumento = new DaoTipoDocumento();
        daoTipoDocumento.agregarTipoDocumento(tipoDocumento);
        
        //seguridad?
        tipoDocumento=null;
        daoTipoDocumento=null;
    }
    public void modificarTipoDocumento(String nombre, String descripcion){
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setTipoDocumento(nombre);
        tipoDocumento.setDescripcion(descripcion);
        DaoTipoDocumento daoTipoDocumento = new DaoTipoDocumento();
        daoTipoDocumento.modificarTipoDocumento(tipoDocumento);
        
        //seguridad?
        tipoDocumento=null;
        daoTipoDocumento=null;
    }
    
    public TipoDocumento consultarTipoDocumento(String nombre){
        DaoTipoDocumento daoTipoDocumento = new DaoTipoDocumento();
        TipoDocumento salida=daoTipoDocumento.consultarTipoDocumento(nombre);
        return salida;
    }
    
    public ArrayList<TipoDocumento> consultarTodosLosTipoDocumento(){
        return new DaoTipoDocumento().consultarTodosLosTipoDocumento();
    }
}
