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

import biblioteca.database2.accesoDatos.DaoReportesEstadisticas;
import com.itextpdf.text.pdf.PdfPTable;
import java.sql.SQLException;
import java.util.ArrayList;


public class ControladorReportesEstadisticas {
        
   public PdfPTable ConsultarListaUsuario(String dow, String dom, String month, String year, String[] franja, String[] desde, String[] Hasta, String tipo,
            String genero, String Estado, String area){
       return bibioteca.reportes.PdfCreator.resultSetToTable(new DaoReportesEstadisticas().ConsultarListaUsuario(dow, dom, month, year, franja, desde, Hasta, tipo, genero, Estado, area));
    }

    public PdfPTable ConsultarListaDocumentosExistentes(String area, String autor, String tipo, String editorial, String idioma, String estado, String[] desde, String[] hasta) {
       return bibioteca.reportes.PdfCreator.resultSetToTable(new DaoReportesEstadisticas().ConsultarListaDocumentosExistentes(area, autor, tipo, editorial, idioma, estado, desde, hasta));
    }

    public PdfPTable ConsultarListaDocumentosConsultados(String dow, String dom, String month, String year, String tipo_usuario, String[] franja, String[] desde, String[] Hasta, String area, String autor, String doc_tipo, String usuario) {
       return bibioteca.reportes.PdfCreator.resultSetToTable(new DaoReportesEstadisticas().ConsultarListaDocumentosConsultados(dow, dom, month, year, tipo_usuario, franja, desde, Hasta, area, autor, doc_tipo, usuario));
    }

    public PdfPTable ConsultarListaDocumentosDescargados(String dow, String dom, String month, String year, String tipo_usuario, String[] franja, String[] desde, String[] Hasta, String area, String autor, String doc_tipo, String usuario) {
       return bibioteca.reportes.PdfCreator.resultSetToTable(new DaoReportesEstadisticas().ConsultarListaDocumentosDescargados(dow, dom, month, year, tipo_usuario, franja, desde, Hasta, area, autor, doc_tipo, usuario));
    }

    public PdfPTable ConsultarListaDocumentosCatalogados(String dow, String dom, String month, String year, String[] franja, String[] desde, String[] Hasta, String area, String autor, String doc_tipo, String usuario) {
        return bibioteca.reportes.PdfCreator.resultSetToTable(new DaoReportesEstadisticas().ConsultarListaDocumentosCatalogados(dow, dom, month, year, franja, desde, Hasta, area, autor, doc_tipo, usuario));
    }
   
    //Resultados intersectados
   
    public ArrayList<PdfPTable> ConsultarListaSeparadaUsuario(String dow, String dom, String month, String year, String[] franja, String[] desde, String[] Hasta, String tipo,
            String genero, String Estado, String area) throws SQLException{
       return bibioteca.reportes.PdfCreator.resultSetsToTables(new DaoReportesEstadisticas().ConsultarListaSeparadaUsuario(dow, dom, month, year, franja, desde, Hasta, tipo, genero, Estado, area));
     }
    public ArrayList<PdfPTable> ConsultarListaSeparadaDocumentosExistentes(String area, String autor, String tipo, String editorial, String idioma, String estado, String[] desde, String[] hasta) {
       return bibioteca.reportes.PdfCreator.resultSetsToTables(new DaoReportesEstadisticas().ConsultarListaSeparadaDocumentosExistentes(area, autor, tipo, editorial, idioma, estado, desde, hasta));
    }

    public ArrayList<PdfPTable> ConsultarListaSeparadaDocumentosConsultados(String dow, String dom, String month, String year, String tipo_usuario, String[] franja, String[] desde, String[] Hasta, String area, String autor, String doc_tipo, String usuario) {
       return bibioteca.reportes.PdfCreator.resultSetsToTables(new DaoReportesEstadisticas().ConsultarListaSeparadaDocumentosConsultados(dow, dom, month, year, tipo_usuario, franja, desde, Hasta, area, autor, doc_tipo, usuario));
    }

    public ArrayList<PdfPTable> ConsultarListaSeparadaDocumentosDescargados(String dow, String dom, String month, String year, String tipo_usuario, String[] franja, String[] desde, String[] Hasta, String area, String autor, String doc_tipo, String usuario) {
       return bibioteca.reportes.PdfCreator.resultSetsToTables(new DaoReportesEstadisticas().ConsultarListaSeparadaDocumentosDescargados(dow, dom, month, year, tipo_usuario, franja, desde, Hasta, area, autor, doc_tipo, usuario));
    }

    public ArrayList<PdfPTable> ConsultarListaSeparadaDocumentosCatalogados(String dow, String dom, String month, String year, String[] franja, String[] desde, String[] Hasta, String area, String autor, String doc_tipo, String usuario) {
        return bibioteca.reportes.PdfCreator.resultSetsToTables(new DaoReportesEstadisticas().ConsultarListaSeparadaDocumentosCatalogados(dow, dom, month, year, franja, desde, Hasta, area, autor, doc_tipo, usuario));
    }
   
}
