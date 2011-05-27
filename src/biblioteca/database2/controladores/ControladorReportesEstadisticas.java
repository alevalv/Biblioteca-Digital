/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.controladores;

import biblioteca.database2.accesoDatos.DaoReportesEstadisticas;
import biblioteca.database2.beans.Area;
import java.sql.ResultSet;

/**
 *
 * @author alejandro
 */

/*
 * Leyendo el diagrama de clases de los reportes, parece que no hay mucho cambio entre
 * el controlador y la clase DAO, tienen los mismos metodos con entradas similares y
 * salidas similares, solo con nombres diferentes, creo que esta clase debe ser eliminada
 * y usar directamente el DAO.
 */
public class ControladorReportesEstadisticas {

    
   public void ConsultarListaUsuario(String dow, String dom, String month, String year, String[] franja, String[] desde, String[] Hasta, String tipo,
            String genero, String Estado, String area){
       ///Esto debe retornar una result set!!
       ResultSet salida= new DaoReportesEstadisticas().ConsultarListaUsuario(dow, dom, month, year, franja, desde, Hasta, tipo, genero, Estado, area);
    }

    public void ConsultarListaDocumentosExistentes(String area, String autor, String tipo, String editorial, String idioma, String estado, String[] desde, String[] hasta) {
       new DaoReportesEstadisticas().ConsultarListaDocumentosExistentes(area, autor, tipo, editorial, idioma, estado, desde, hasta);
    }
   
   
}
