/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.accesoDatos;

/**
 *
 * @author alejandro
 */

import biblioteca.database2.fachada.Fachada;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoReportesEstadisticas {
    Fachada Fachada;
    public void DaoReportesEstadisticas(){
        Fachada = new Fachada();
    }
    /*
    public ResultSet consultarDocumentosPorArea(String area){
        return 1;
    }
    public ResultSet consultarUsuariosPorTipo(String tipo){
        return 1;
    }
    
    public ResultSet consultarUsuariosRegistradosPorMes(int mes){
        return 1;
    }
    public ResultSet consultarDocumentosMasConsultados(){
        return 1;
    }
    public ResultSet consultarDocumentosPorTipoUsuario(String tipo){
        return 1;
    }
    public ResultSet consultarDocumentosPorArea(ArrayList<String> areas){
        return 1;
    }
    public ResultSet consultarDocumentosPorFormato(String formato){
        return 1;
    }
    public ResultSet consultarDocumentoCatalogadoPorMes(int mes){
        return 1;
    }
    public ResultSet consultarDocumentoCatalogadoPorArea(String area){
        return 1;
    }
    public ResultSet consultarCatalogadoPorMesyArea(int mes, String area){
        return 1;
    }
    public ResultSet consultarDocumentosMasDescargados(){
        return 1;
    }
    public ResultSet consultarDocumentosMasDescargadosPorTipoUsuario(String tipo){
        return 1;
    }
    public ResultSet consultarDocumentosMasDescargadosPorArea(ArrayList<String> areas){
        return 1;
    }
    public ResultSet consultarUsuariosMayorAreaDeInteres(){
        return 1;
    }
    public ResultSet consultarFranjasHorariasMasUsuarios(int franja){
        return 1;
    }
    */
}