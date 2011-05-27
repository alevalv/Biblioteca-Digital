/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.controladores;

import biblioteca.database2.accesoDatos.DaoReportesEstadisticas;
import com.itextpdf.text.pdf.PdfPTable;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 *
 * @author alejandro
 */

public class ControladorReportesEstadisticas {
        
   public PdfPTable ConsultarListaUsuario(String dow, String dom, String month, String year, String[] franja, String[] desde, String[] Hasta, String tipo,
            String genero, String Estado, String area){
       ///Esto debe retornar una result set!!
       return biblioteca.Main.PdfCreator.resultSetToTable(new DaoReportesEstadisticas().ConsultarListaUsuario(dow, dom, month, year, franja, desde, Hasta, tipo, genero, Estado, area));
    }

    public PdfPTable ConsultarListaDocumentosExistentes(String area, String autor, String tipo, String editorial, String idioma, String estado, String[] desde, String[] hasta) {
       return biblioteca.Main.PdfCreator.resultSetToTable(new DaoReportesEstadisticas().ConsultarListaDocumentosExistentes(area, autor, tipo, editorial, idioma, estado, desde, hasta));
    }

    public PdfPTable ConsultarListaDocumentosConsultados(String dow, String dom, String month, String year, String tipo_usuario, String[] franja, String[] desde, String[] Hasta, String area, String autor, String doc_tipo, String usuario) {
       return biblioteca.Main.PdfCreator.resultSetToTable(new DaoReportesEstadisticas().ConsultarListaDocumentosConsultados(dow, dom, month, year, tipo_usuario, franja, desde, Hasta, area, autor, doc_tipo, usuario));
    }
   
   
}
