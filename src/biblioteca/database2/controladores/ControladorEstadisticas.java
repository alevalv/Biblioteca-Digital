/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.controladores;

import biblioteca.database2.accesoDatos.DaoEstadisticas;
import com.itextpdf.text.pdf.PdfPTable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alejandro
 */
public class ControladorEstadisticas {

    public ControladorEstadisticas() {
    }
    
    public PdfPTable estadisticasDocumentosDescargados(String dow,String dom,String month,String year,String tipo_usuario,
       String[] franja,String[] desde,String[] hasta,String area,String autor,String doc_tipo,String usuario, boolean todos, int salida){
        ResultSet rs = new DaoEstadisticas().documentosMasDescargados(dow, dom, month, year, tipo_usuario, franja, desde, hasta, area, autor, doc_tipo, usuario, todos);
        int total=0;
        ArrayList<ArrayList<String>> resultadosTabla = biblioteca.Main.PdfCreator.resultSetToArrayList(rs);
        for(int i=1;i<resultadosTabla.size();i++){
            total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
        }
        PdfPTable tabla=biblioteca.Main.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
        return tabla;
    }
    
    public PdfPTable estadisticasDocumentosConsultados(String dow,String dom,String month,String year,String tipo_usuario,
       String[] franja,String[] desde,String[] hasta,String area,String autor,String doc_tipo,String usuario, boolean todos, int salida){
        ResultSet rs = new DaoEstadisticas().documentosMasConsultados(dow, dom, month, year, tipo_usuario, franja, desde, hasta, area, autor, doc_tipo, usuario, todos);
        int total=0;
        ArrayList<ArrayList<String>> resultadosTabla = biblioteca.Main.PdfCreator.resultSetToArrayList(rs);
        for(int i=1;i<resultadosTabla.size();i++){
            total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
        }
        PdfPTable tabla=biblioteca.Main.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
        return tabla;
    }
    
}
