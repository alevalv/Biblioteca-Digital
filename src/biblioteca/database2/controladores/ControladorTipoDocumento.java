/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
        TipoDocumento salida=daoTipoDocumento.consultarDocumento(nombre);
        return salida;
    }
    
    public ArrayList<TipoDocumento> consultarTodosLosTipoDocumento(){
        return new DaoTipoDocumento().consultarTodosLosTipoDocumento();
    }
}
