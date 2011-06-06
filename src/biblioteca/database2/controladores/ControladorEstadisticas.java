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
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
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
        ArrayList<ArrayList<String>> resultadosTabla = biblioteca.reportes.PdfCreator.resultSetToArrayList(rs);
        for(int i=1;i<resultadosTabla.size();i++){
            total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
        }
        PdfPTable tabla=biblioteca.reportes.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
        return tabla;
    }
    
    public PdfPTable estadisticasDocumentosConsultados(String dow,String dom,String month,String year,String tipo_usuario,
       String[] franja,String[] desde,String[] hasta,String area,String autor,String doc_tipo,String usuario, boolean todos, int salida){
        ResultSet rs = new DaoEstadisticas().documentosMasConsultados(dow, dom, month, year, tipo_usuario, franja, desde, hasta, area, autor, doc_tipo, usuario, todos);
        int total=0;
        ArrayList<ArrayList<String>> resultadosTabla = biblioteca.reportes.PdfCreator.resultSetToArrayList(rs);
        for(int i=1;i<resultadosTabla.size();i++){
            total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
        }
        PdfPTable tabla=biblioteca.reportes.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
        return tabla;
    }
    
    public ArrayList<Element> estadisticasUsuariosRegistradosMultiplesTablas(boolean dow, boolean dom, boolean mes, String Year, String[] franja, String desde[], String[] hasta){
        ArrayList<Element> salida=  new ArrayList<Element>(24);
        DaoEstadisticas controlador = new DaoEstadisticas();
        if(dow){
            ArrayList<String> tmp= controlador.consultarUsuariosRegistradosPorDoW();
            float promedio=promedio(tmp,2);
            salida.add(new Paragraph("Resultados para los días de la semana"));
            salida.add(new Paragraph("\r\n"));
            salida.add(biblioteca.reportes.PdfCreator.plainArrayListToPdfPTable(agregarPorcentajesALista(tmp, 2), 3));
            salida.add(new Paragraph("Promedio "+promedio));
            salida.add(new Paragraph("\r\n"));
        }
        if(dom){
            ArrayList<String> tmp= controlador.consultarUsuariosRegistradosPorDoM();
            salida.add(new Paragraph("Resultados para los días del mes"));
            salida.add(new Paragraph("\r\n"));
            float promedio=promedio(tmp,2);
            salida.add(biblioteca.reportes.PdfCreator.plainArrayListToPdfPTable(agregarPorcentajesALista(tmp, 2), 3));
            salida.add(new Paragraph("Promedio "+promedio));
            salida.add(new Paragraph("\r\n"));
        }
        if(mes){
            ArrayList<String> tmp= controlador.consultarUsuariosRegistradosPorMes();
            salida.add(new Paragraph("Resultados para los meses"));
            salida.add(new Paragraph("\r\n"));
            float promedio=promedio(tmp,2);
            salida.add(biblioteca.reportes.PdfCreator.plainArrayListToPdfPTable(agregarPorcentajesALista(tmp, 2), 3));
            salida.add(new Paragraph("Promedio "+promedio));
            salida.add(new Paragraph("\r\n"));
        }
        if(Year!=null){
            ArrayList<String> tmp= controlador.consultarUsuariosRegistradosPorYear(Year);
            salida.add(new Paragraph("Resultados para el año seleccionado"));
            salida.add(new Paragraph("\r\n"));
            salida.add(new Paragraph(tmp.get(0)+" "+tmp.get(1)));
            salida.add(new Paragraph("\r\n"));
        }
        if(franja!=null){
            ArrayList<String> tmp= controlador.consultarUsuariosRegistradosPorFranja(franja[0],franja[1]);
            salida.add(new Paragraph("Resultados para la franja seleccionada"));
            salida.add(new Paragraph("\r\n"));
            salida.add(new Paragraph(tmp.get(0)+" "+tmp.get(1)));
            salida.add(new Paragraph("\r\n"));
        }
        if(desde!=null && hasta !=null){
            ArrayList<String> tmp= controlador.consultarUsuariosRegistradosPorIntervalo(desde[0]+"-"+desde[1]+"-"+desde[2],
                    hasta[0]+"-"+hasta[1]+"-"+hasta[2]);
            salida.add(new Paragraph("Resultados para el intervalo de tiempo seleccionado"));
            salida.add(new Paragraph("\r\n"));
            salida.add(new Paragraph(tmp.get(0)+" "+tmp.get(1)));
            salida.add(new Paragraph("\r\n"));
        }
        return salida;
    }
    
    private float promedio(ArrayList<String> datos, int columnas){
        int total=0, n=0;
        for(int i=columnas+1; i<datos.size();i+=columnas){
            total+=Integer.parseInt(datos.get(i));
            n++;
        }
        return (float) total/n;
    }
    
    private ArrayList<String> agregarPorcentajesALista(ArrayList<String> datos, int columnas){
        int total=0;
        ArrayList<String> salida = new ArrayList<String>((int) (datos.size()*1.5));
        for(int i=columnas+1; i<datos.size();i+=columnas){
            total+=Integer.parseInt(datos.get(i));
        }
        for(int i=0;i<columnas;i++){
            salida.add(datos.get(i));
        }
        salida.add("Porcentaje");
        for(int i=columnas;i<datos.size();i++){
            salida.add(datos.get(i));
            if(i%(columnas)==columnas-1){
                salida.add(((int) ((Integer.parseInt(datos.get(i))*100)/total))+"%");
            }
        }
        System.out.println(salida);
        return salida;
    }
    
}
