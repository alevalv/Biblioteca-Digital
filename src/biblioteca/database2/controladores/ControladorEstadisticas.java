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
import biblioteca.reportes.ChartCreator;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.encoders.EncoderUtil;


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
    
    public /*PdfPTable*/ ArrayList<Element> estadisticasDocumentosConsultados(String dow,String dom,String month,String year,String tipo_usuario,
        String[] franja,String[] desde,String[] hasta,String area,String autor,String doc_tipo,String usuario, boolean todos, int salida) throws BadElementException, MalformedURLException, IOException{
       
        ArrayList<Element> Salida=  new ArrayList<Element>(5);
        BufferedImage bufferedImage;
        Image image;
        ResultSet rs = new DaoEstadisticas().documentosMasConsultados(dow, dom, month, year, tipo_usuario, franja, desde, hasta, area, autor, doc_tipo, usuario, todos);
        int total=0;
        ArrayList<ArrayList<String>> resultadosTabla = biblioteca.reportes.PdfCreator.resultSetToArrayList(rs);
        ArrayList<String> Array2DtoArrayPlane = biblioteca.reportes.PdfCreator.Array2DtoArrayPlane(resultadosTabla);
        for(int i=1;i<resultadosTabla.size();i++){
            total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
        }
        PdfPTable tabla=biblioteca.reportes.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
       
        
       Salida.add(tabla);
       Salida.add(new Paragraph("\r\n"));
       Salida.add(new Paragraph("* Diagrama de Pastel y Diagrama de Barras: Documentos Consultados"));
       JFreeChart chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(Array2DtoArrayPlane),"Documentos Consultados");
       bufferedImage = chart.createBufferedImage(400, 300);
       image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
       Salida.add(image);
       
        //return tabla;
        return Salida;
    }
    
    public ArrayList<Element> estadisticasUsuariosRegistradosMultiplesTablas(boolean dow, boolean dom, boolean mes, String Year, String[] franja, String desde[], String[] hasta) throws BadElementException, MalformedURLException, IOException{
        
        BufferedImage bufferedImage;
        Image image;
        ArrayList<Element> salida=  new ArrayList<Element>(30);
        ArrayList<Element> images=new ArrayList<Element>(10);
        DaoEstadisticas controlador = new DaoEstadisticas();
        if(dow){
            ArrayList<String> tmp= controlador.consultarUsuariosRegistradosPorDoW();
            float promedio=promedio(tmp,2);
            salida.add(new Paragraph("Resultados para los días de la semana"));
            salida.add(new Paragraph("\r\n"));
            salida.add(biblioteca.reportes.PdfCreator.plainArrayListToPdfPTable(agregarPorcentajesALista(tmp, 2), 3));
            salida.add(new Paragraph("Promedio "+promedio));
            salida.add(new Paragraph("\r\n"));
            salida.add(new Paragraph("* Ver Anexo: Diagrama de Pastel: Usuarios Registrados para los dias de la Semana"));
            salida.add(new Paragraph("\r\n"));
            JFreeChart chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(tmp),"Usuarios Registrados para los días de la semana");
            bufferedImage = chart.createBufferedImage(400, 300);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            images.add(image);
            images.add(new Paragraph("\r\n"));
            salida.add(new Paragraph("* Ver Anexo: Diagrama de Barras: Usuarios Registrados para los dias de la Semana"));
            salida.add(new Paragraph("\r\n"));
            chart = ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(tmp), "Usuarios Registrados para los días de la semana", "Días de la Semana", "Cantidad de usuarios");
            bufferedImage = chart.createBufferedImage(400, 300);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            images.add(image);
            images.add(new Paragraph("\r\n"));
        }
        if(dom){
            ArrayList<String> tmp= controlador.consultarUsuariosRegistradosPorDoM();
            salida.add(new Paragraph("Resultados para los días del mes"));
            salida.add(new Paragraph("\r\n"));
            float promedio=promedio(tmp,2);
            salida.add(biblioteca.reportes.PdfCreator.plainArrayListToPdfPTable(agregarPorcentajesALista(tmp, 2), 3));
            salida.add(new Paragraph("Promedio "+promedio));
            salida.add(new Paragraph("\r\n"));
            salida.add(new Paragraph("* Ver Anexo: Diagrama de Pastel: Usuarios Registrados para los dias del mes"));
            salida.add(new Paragraph("\r\n"));
            JFreeChart chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(tmp),"Usuarios Registrados para los días del mes");
            bufferedImage = chart.createBufferedImage(400, 300);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            images.add(image);
            images.add(new Paragraph("\r\n"));
            chart = ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(tmp), "Usuarios Registrados para los días del Mes", "Días del mes", "Cantidad de usuarios");
            bufferedImage = chart.createBufferedImage(400, 300);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            salida.add(new Paragraph("* Ver Anexo: Diagrama de Barras: Usuarios Registrados para los dias del mes"));
            salida.add(new Paragraph("\r\n"));
            images.add(image);
            images.add(new Paragraph("\r\n"));
        }
        if(mes){
            ArrayList<String> tmp= controlador.consultarUsuariosRegistradosPorMes();
            salida.add(new Paragraph("Resultados para los meses"));
            salida.add(new Paragraph("\r\n"));
            float promedio=promedio(tmp,2);
            salida.add(biblioteca.reportes.PdfCreator.plainArrayListToPdfPTable(agregarPorcentajesALista(tmp, 2), 3));
            salida.add(new Paragraph("Promedio "+promedio));
            salida.add(new Paragraph("\r\n"));
            salida.add(new Paragraph("* Ver Anexo: Diagrama de Pastel: Usuarios Registrados para los meses"));
            salida.add(new Paragraph("\r\n"));
            JFreeChart chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(tmp),"Usuarios Registrados para los meses");
            bufferedImage = chart.createBufferedImage(400, 300);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            images.add(image);
            images.add(new Paragraph("\r\n"));
            salida.add(new Paragraph("* Ver Anexo: Diagrama de Barras: Usuarios Registrados para los meses"));
            salida.add(new Paragraph("\r\n"));
            chart = ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(tmp), "Usuarios Registrados para los Meses", "Meses", "Cantidad de usuarios");
            bufferedImage = chart.createBufferedImage(400, 300);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            images.add(image);
            images.add(new Paragraph("\r\n"));
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
        
        if(!images.isEmpty()){
            salida.add(new Paragraph("Anexos:"));
            salida.add(new Paragraph("\r\n"));
        }
        for(int i=0;i<images.size();i++){
            salida.add(images.get(i));
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
