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

    private PdfPTable resultSetToTable(ResultSet entrada){
        PdfPTable salida = null;
        try{
            ResultSetMetaData rsmd = entrada.getMetaData();
        
            salida = new PdfPTable(rsmd.getColumnCount());
            for(int i=1;i<=rsmd.getColumnCount();i++){
                salida.addCell(rsmd.getColumnName(i));
            }
            while(entrada.next()){
                for(int i=1;i<=rsmd.getColumnCount();i++){
                    salida.addCell(entrada.getString(i));
                }
            }
        }catch(java.sql.SQLException sqlex){
            System.err.println(sqlex);
        }
        return salida;
    }
    
    
   public PdfPTable ConsultarListaUsuario(String dow, String dom, String month, String year, String[] franja, String[] desde, String[] Hasta, String tipo,
            String genero, String Estado, String area){
       ///Esto debe retornar una result set!!
       return resultSetToTable(new DaoReportesEstadisticas().ConsultarListaUsuario(dow, dom, month, year, franja, desde, Hasta, tipo, genero, Estado, area));
    }

    public void ConsultarListaDocumentosExistentes(String area, String autor, String tipo, String editorial, String idioma, String estado, String[] desde, String[] hasta) {
       new DaoReportesEstadisticas().ConsultarListaDocumentosExistentes(area, autor, tipo, editorial, idioma, estado, desde, hasta);
    }
   
   
}
