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

import biblioteca.database2.accesoDatos.DaoEstadisticas;
import com.itextpdf.text.pdf.PdfPTable;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ControladorEstadisticas {

    public ControladorEstadisticas() {
    }
    
    public PdfPTable estadisticasDocumentosDescargados(String dow,String dom,String month,String year,String tipo_usuario,
       String[] franja,String[] desde,String[] hasta,String area,String autor,String doc_tipo,String usuario, boolean todos, int salida){
        ResultSet rs = new DaoEstadisticas().documentosMasDescargados(dow, dom, month, year, tipo_usuario, franja, desde, hasta, area, autor, doc_tipo, usuario, todos);
        int total=0;
        ArrayList<ArrayList<String>> resultadosTabla = bibioteca.reportes.PdfCreator.resultSetToArrayList(rs);
        for(int i=1;i<resultadosTabla.size();i++){
            total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
        }
        PdfPTable tabla=bibioteca.reportes.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
        return tabla;
    }
    
    public PdfPTable estadisticasDocumentosConsultados(String dow,String dom,String month,String year,String tipo_usuario,
       String[] franja,String[] desde,String[] hasta,String area,String autor,String doc_tipo,String usuario, boolean todos, int salida){
        ResultSet rs = new DaoEstadisticas().documentosMasConsultados(dow, dom, month, year, tipo_usuario, franja, desde, hasta, area, autor, doc_tipo, usuario, todos);
        int total=0;
        ArrayList<ArrayList<String>> resultadosTabla = bibioteca.reportes.PdfCreator.resultSetToArrayList(rs);
        for(int i=1;i<resultadosTabla.size();i++){
            total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
        }
        PdfPTable tabla=bibioteca.reportes.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
        return tabla;
    }
    
}
