/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.accesoDatos;

import biblioteca.database2.fachada.fachada;
import biblioteca.database2.beans.Documento;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author alejandro
 */
public class DaoDocumento {
    fachada Fachada;
    public DaoDocumento(){
    Fachada = new fachada();
    }
    
    public void insertarDocumento(Documento documento, String usuario){
        //TODO insertarDocumento
    }
    public void deshabilitarDocumento(Documento documento){
        //TODO deshabilitarDocumento
    }
    public int modificarDocumento(Documento documento){
        //TODO modificarDocumento
        return -1;
    }
    public int verificarExistencia(String id_documento){
        //TODO verificarDocumento
        return -1;
    }
    public Documento verDatosDocumento(String id_documento, String usuario){
        //TODO verDatosDocumento
        return new Documento();
    }
    public int actualizarDocumento(Documento documento){
        //TODO actualizarDocumento
        return -1;
    }
    public int insertarAreas(ArrayList<String> areas, String documento){
        //TODO insertarAreas
        return -1;
    }
    public int insertarPalabrasClave(ArrayList<String> PC, String documento){
        //TODO insertarPalabrasClave
        return -1;
    }
    public int insertarAutor(String email, String id_documento){
        //TODO insertarAutor
        return -1;
    }
    public int eliminarAreas(ArrayList<String> areas, String documento){
        //TODO eliminarAreas
        return -1;
    }
    public int eliminarPalabrasClave(ArrayList<String> PC, String documento){
        //TODO eliminarPalabrasClave
        return -1;
    }
    public int eliminarAutor(String email, String id_documento){
        //TODO eliminarAutor
        return -1;
    }
    public ResultSet consultarDocumento(String datos){
        return 1;
    }
    public ResultSet consultarDocumento(ArrayList<String> datos){
        return 1;
    }
    public int descargarDocumento(String id_documento, String usuario){
        return -1;
    }
    
    
}
