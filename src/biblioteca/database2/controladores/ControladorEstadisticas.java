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
    
    public ArrayList<Element> estadisticasDocumentosDescargados(String dow,String dom,String month,String year,String tipo_usuario,
       String[] franja,String[] desde,String[] hasta,String area,String autor,String doc_tipo,String usuario, boolean todos, int salida)throws BadElementException, MalformedURLException, IOException{
         
        ArrayList<Element> Salida=  new ArrayList<Element>(6);
        BufferedImage bufferedImage;
        Image image;
        ResultSet rs = new DaoEstadisticas().documentosMasDescargados(dow, dom, month, year, tipo_usuario, franja, desde, hasta, area, autor, doc_tipo, usuario, todos);
        int total=0;
        ArrayList<ArrayList<String>> resultadosTabla = biblioteca.reportes.PdfCreator.resultSetToArrayList(rs);
        ArrayList<String> Array2DtoArrayPlane = biblioteca.reportes.PdfCreator.Array2DtoArrayPlane(resultadosTabla,1,2);
        for(int i=1;i<resultadosTabla.size();i++){
            total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
        }
        PdfPTable tabla=biblioteca.reportes.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
        
       Salida.add(tabla);
       Salida.add(new Paragraph("\r\n"));
       Salida.add(new Paragraph("* Diagrama de Pastel y Diagrama de Barras: Documentos Descargados"));
       JFreeChart chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(Array2DtoArrayPlane),"Documentos Descargados");
       bufferedImage = chart.createBufferedImage(500, 600);
       image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
       image.scaleAbsolute(250, 300);
       image.setAlignment(Image.MIDDLE);
       Salida.add(image);
       Salida.add(new Paragraph("\r\n"));
       chart=ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(Array2DtoArrayPlane), "Documentos Descargados", "Identificador Documento", "Numero de Descargados");
       bufferedImage = chart.createBufferedImage(1000, 500);
       image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
       image.scaleAbsolute(500, 250);
       image.setAlignment(Image.MIDDLE);
       Salida.add(image);
       return Salida;
    }
    
    public ArrayList<Element> estadisticasDocumentosConsultados(String dow,String dom,String month,String year,String tipo_usuario,
        String[] franja,String[] desde,String[] hasta,String area,String autor,String doc_tipo,String usuario, boolean todos, int salida) throws BadElementException, MalformedURLException, IOException{
       
        ArrayList<Element> Salida=  new ArrayList<Element>(6);
        BufferedImage bufferedImage;
        Image image;
        ResultSet rs = new DaoEstadisticas().documentosMasConsultados(dow, dom, month, year, tipo_usuario, franja, desde, hasta, area, autor, doc_tipo, usuario, todos);
        int total=0;
        ArrayList<ArrayList<String>> resultadosTabla = biblioteca.reportes.PdfCreator.resultSetToArrayList(rs);
        ArrayList<String> Array2DtoArrayPlane = biblioteca.reportes.PdfCreator.Array2DtoArrayPlane(resultadosTabla,0,2);
        for(int i=1;i<resultadosTabla.size();i++){
            total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
        }
        PdfPTable tabla=biblioteca.reportes.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
       
        
       Salida.add(tabla);
       Salida.add(new Paragraph("\r\n"));
       Salida.add(new Paragraph("* Diagrama de Pastel y Diagrama de Barras: Documentos Consultados"));
       JFreeChart chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(Array2DtoArrayPlane),"Documentos Consultados");
       bufferedImage = chart.createBufferedImage(500, 600);
       image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
       image.scaleAbsolute(250, 300);
       image.setAlignment(Image.MIDDLE);
       Salida.add(image);
       Salida.add(new Paragraph("\r\n"));
       chart=ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(Array2DtoArrayPlane), "Documentos Consultados", "Identificador Documento", "Numero de Consultas");
       bufferedImage = chart.createBufferedImage(1000, 500);
       image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
       image.scaleAbsolute(500, 250);
       image.setAlignment(Image.MIDDLE);
       Salida.add(image);
        return Salida;
    }
    
    public ArrayList<Element> estadisticasUsuariosRegistradosMultiplesTablas(boolean dow, boolean dom, boolean mes, String Year, String[] franja, String desde[], String[] hasta, boolean genero, boolean vinculo, boolean tipo, boolean estado, boolean area, int salida) throws BadElementException, MalformedURLException, IOException{
        BufferedImage bufferedImage;
        Image image;
        ResultSet rs;
        ArrayList<Element> Salida=  new ArrayList<Element>(100);
        ArrayList<Element> images=new ArrayList<Element>(100);
        DaoEstadisticas controlador = new DaoEstadisticas();
        JFreeChart chart;
        ArrayList<ArrayList<String>> resultadosTabla;
        ArrayList<String> Array2DtoArrayPlane;
        PdfPTable tabla=null;
        int total=0;
        if(dow){
            ArrayList<String> tmp= controlador.consultarUsuariosRegistradosPorDoW();
            float promedio=promedio(tmp,2);
            Salida.add(new Paragraph("Resultados para los días de la semana"));
            Salida.add(new Paragraph("\r\n"));
            Salida.add(biblioteca.reportes.PdfCreator.plainArrayListToPdfPTable(agregarPorcentajesALista(tmp, 2), 3));
            Salida.add(new Paragraph("Promedio "+promedio));
            Salida.add(new Paragraph("\r\n"));
            Salida.add(new Paragraph("* Ver Anexo: Diagrama de Pastel: Usuarios Registrados para los dias de la Semana"));
            Salida.add(new Paragraph("\r\n"));
            chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(tmp),"Usuarios Registrados para los días de la semana");
            bufferedImage = chart.createBufferedImage(400, 300);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            image.scaleAbsolute(300, 200);
            image.setAlignment(Image.MIDDLE);
            images.add(image);
            images.add(new Paragraph("\r\n"));
            Salida.add(new Paragraph("* Ver Anexo: Diagrama de Barras: Usuarios Registrados para los dias de la Semana"));
            Salida.add(new Paragraph("\r\n"));
            chart = ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(tmp), "Usuarios Registrados para los días de la semana", "Días de la Semana", "Cantidad de usuarios");
            bufferedImage = chart.createBufferedImage(700, 300);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            image.scaleAbsolute(400, 200);
            image.setAlignment(Image.MIDDLE);
            images.add(image);
            images.add(new Paragraph("\r\n"));
        }
        if(dom){
           rs=controlador.consultarUsuariosRegistradosPorDoM();
           resultadosTabla = biblioteca.reportes.PdfCreator.resultSetToArrayList(rs);
           Array2DtoArrayPlane = biblioteca.reportes.PdfCreator.Array2DtoArrayPlane(resultadosTabla,0,1);
           for(int i=1;i<resultadosTabla.size();i++)
               total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
            tabla=biblioteca.reportes.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
            Salida.add(new Paragraph("Resultados para los días del mes"));
            Salida.add(new Paragraph("\r\n"));
            Salida.add(tabla);
            Salida.add(new Paragraph("\r\n"));
            Salida.add(new Paragraph("* Ver Anexo: Diagrama de Pastel: Usuarios Registrados para los dias del mes"));
            Salida.add(new Paragraph("\r\n"));
            chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(Array2DtoArrayPlane),"Usuarios Registrados para los días del mes");
            bufferedImage = chart.createBufferedImage(500, 600);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            image.scaleAbsolute(250, 300);
            image.setAlignment(Image.MIDDLE);
            images.add(image);
            images.add(new Paragraph("\r\n"));
            chart = ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(Array2DtoArrayPlane), "Usuarios Registrados para los días del Mes", "Días del mes", "Cantidad de usuarios");
            bufferedImage = chart.createBufferedImage(1000, 500);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            image.scaleAbsolute(500, 250);
            image.setAlignment(Image.MIDDLE);
            Salida.add(new Paragraph("* Ver Anexo: Diagrama de Barras: Usuarios Registrados para los dias del mes"));
            Salida.add(new Paragraph("\r\n"));
            images.add(image);
            images.add(new Paragraph("\r\n"));
        }
        if(mes){
            ArrayList<String> tmp= controlador.consultarUsuariosRegistradosPorMes();
            Salida.add(new Paragraph("Resultados para los meses"));
            Salida.add(new Paragraph("\r\n"));
            float promedio=promedio(tmp,2);
            Salida.add(biblioteca.reportes.PdfCreator.plainArrayListToPdfPTable(agregarPorcentajesALista(tmp, 2), 3));
            Salida.add(new Paragraph("Promedio "+promedio));
            Salida.add(new Paragraph("\r\n"));
            Salida.add(new Paragraph("* Ver Anexo: Diagrama de Pastel: Usuarios Registrados para los meses"));
            Salida.add(new Paragraph("\r\n"));
            chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(tmp),"Usuarios Registrados para los meses");
            bufferedImage = chart.createBufferedImage(500, 300);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            image.scaleAbsolute(350, 200);
            image.setAlignment(Image.MIDDLE);
            images.add(image);
            images.add(new Paragraph("\r\n"));
            Salida.add(new Paragraph("* Ver Anexo: Diagrama de Barras: Usuarios Registrados para los meses"));
            Salida.add(new Paragraph("\r\n"));
            chart = ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(tmp), "Usuarios Registrados para los Meses", "Meses", "Cantidad de usuarios");
            bufferedImage = chart.createBufferedImage(1000, 600);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            image.scaleAbsolute(500, 300);
            image.setAlignment(Image.MIDDLE);
            images.add(image);
            images.add(new Paragraph("\r\n"));
        }
        if(Year!=null){
            ArrayList<String> tmp= controlador.consultarUsuariosRegistradosPorYear(Year);
            Salida.add(new Paragraph("Resultados para el año seleccionado"));
            Salida.add(new Paragraph("\r\n"));
            Salida.add(new Paragraph("Año:"+tmp.get(0)+", Resultados:"+tmp.get(1)));
            Salida.add(new Paragraph("\r\n"));
        }
        if(franja!=null){
            ArrayList<String> tmp= controlador.consultarUsuariosRegistradosPorFranja(franja[0],franja[1]);
            Salida.add(new Paragraph("Resultados para la franja seleccionada"));
            Salida.add(new Paragraph("\r\n"));
            Salida.add(new Paragraph("Franja:"+tmp.get(0)+", Resultados:"+tmp.get(1)));
            Salida.add(new Paragraph("\r\n"));
        }
        if(desde!=null && hasta !=null){
            ArrayList<String> tmp= controlador.consultarUsuariosRegistradosPorIntervalo(desde[0]+"-"+desde[1]+"-"+desde[2],
                    hasta[0]+"-"+hasta[1]+"-"+hasta[2]);
            Salida.add(new Paragraph("Resultados para el intervalo de tiempo seleccionado"));
            Salida.add(new Paragraph("\r\n"));
            Salida.add(new Paragraph("Intervalo de Tiempo: "+tmp.get(0)+", Resultados:"+tmp.get(1)));
            Salida.add(new Paragraph("\r\n"));
        }
        if(genero){
           rs=controlador.consultarUsuariosRegistradosPorGenero();
           resultadosTabla = biblioteca.reportes.PdfCreator.resultSetToArrayList(rs);
         for(int i=0;i<resultadosTabla.size();i++){
              if(resultadosTabla.get(i).get(0).equals("F") || resultadosTabla.get(i).get(0).equals("f")) resultadosTabla.get(i).set(0, "Femenino");
              if(resultadosTabla.get(i).get(0).equals("M") || resultadosTabla.get(i).get(0).equals("m")) resultadosTabla.get(i).set(0, "Masculino");
              if(resultadosTabla.get(i).get(0).equals("N") || resultadosTabla.get(i).get(0).equals("n")) {
                  resultadosTabla.remove(i);
              }
           }
           Array2DtoArrayPlane = biblioteca.reportes.PdfCreator.Array2DtoArrayPlane(resultadosTabla,0,1);
           for(int i=1;i<resultadosTabla.size();i++)
               total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
            tabla=biblioteca.reportes.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
            Salida.add(new Paragraph("Estadisticas de Usuarios Registrados por Genero"));
            Salida.add(new Paragraph("\r\n"));
            Salida.add(tabla);
            Salida.add(new Paragraph("\r\n"));
            Salida.add(new Paragraph("* Ver Anexo: Diagrama de Pastel: Estadisticas de Usuarios Registrados por Genero"));
            Salida.add(new Paragraph("\r\n"));
            chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(Array2DtoArrayPlane),"Estadisticas de Usuarios Registrados por Genero");
            bufferedImage = chart.createBufferedImage(450, 400);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
             image.scaleAbsolute(250, 200);
            image.setAlignment(Image.MIDDLE);
            images.add(image);
            images.add(new Paragraph("\r\n"));
            chart = ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(Array2DtoArrayPlane), "Estadisticas de Usuarios Registrados por Genero", "Genero", "Cantidad de Usuarios");
            bufferedImage = chart.createBufferedImage(400, 400);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            image.scaleAbsolute(200, 200);
            image.setAlignment(Image.MIDDLE);
            Salida.add(new Paragraph("* Ver Anexo: Diagrama de Barras: Estadisticas de Usuarios Registrados por Genero"));
            Salida.add(new Paragraph("\r\n"));
            images.add(image);
            images.add(new Paragraph("\r\n"));
        }
         if(vinculo){
           rs=controlador.consultarUsuariosRegistradosPorVinculo();
           resultadosTabla = biblioteca.reportes.PdfCreator.resultSetToArrayList(rs); Array2DtoArrayPlane = biblioteca.reportes.PdfCreator.Array2DtoArrayPlane(resultadosTabla,0,1);
           for(int i=1;i<resultadosTabla.size();i++)
               total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
            tabla=biblioteca.reportes.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
            Salida.add(new Paragraph("Estadisticas de Usuarios Registrados por Vinculo"));
            Salida.add(new Paragraph("\r\n"));
            Salida.add(tabla);
            Salida.add(new Paragraph("\r\n"));
            Salida.add(new Paragraph("* Ver Anexo: Diagrama de Pastel: Estadisticas de Usuarios Registrados por Vinculo"));
            Salida.add(new Paragraph("\r\n"));
            chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(Array2DtoArrayPlane),"Estadisticas de Usuarios Registrados por Vinculo");
            bufferedImage = chart.createBufferedImage(500, 500);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            image.scaleAbsolute(300, 200);
            image.setAlignment(Image.MIDDLE);
            images.add(image);
            images.add(new Paragraph("\r\n"));
            chart = ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(Array2DtoArrayPlane), "Estadisticas de Usuarios Registrados por Vinculo", "Vinculo", "Cantidad de Usuarios");
            bufferedImage = chart.createBufferedImage(500, 400);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            image.scaleAbsolute(200, 200);
            image.setAlignment(Image.MIDDLE);
            Salida.add(new Paragraph("* Ver Anexo: Diagrama de Barras: Estadisticas de Usuarios Registrados por Vinculo"));
            Salida.add(new Paragraph("\r\n"));
            images.add(image);
            images.add(new Paragraph("\r\n"));
        }
        if(tipo){
           rs=controlador.consultarUsuariosRegistradosPorTipoUsuario();
           resultadosTabla = biblioteca.reportes.PdfCreator.resultSetToArrayList(rs);
         for(int i=0;i<resultadosTabla.size();i++){
              if(resultadosTabla.get(i).get(0).equals("3")) resultadosTabla.get(i).set(0, "Normal");
              if(resultadosTabla.get(i).get(0).equals("2")) resultadosTabla.get(i).set(0, "Catalogador");
              if(resultadosTabla.get(i).get(0).equals("1")) resultadosTabla.get(i).set(0, "Administrador");
              if(resultadosTabla.get(i).get(0).equals("0")) resultadosTabla.remove(i);
           }
           Array2DtoArrayPlane = biblioteca.reportes.PdfCreator.Array2DtoArrayPlane(resultadosTabla,0,1);
           for(int i=1;i<resultadosTabla.size();i++)
               total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
            tabla=biblioteca.reportes.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
            Salida.add(new Paragraph("Estadisticas de Usuarios Registrados por Tipo de Usuario"));
            Salida.add(new Paragraph("\r\n"));
            Salida.add(tabla);
            Salida.add(new Paragraph("\r\n"));
            Salida.add(new Paragraph("* Ver Anexo: Diagrama de Pastel: Estadisticas de Usuarios Tipo de Usuario"));
            Salida.add(new Paragraph("\r\n"));
            chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(Array2DtoArrayPlane),"Estadisticas de Usuarios Tipo de Usuario");
            bufferedImage = chart.createBufferedImage(450, 400);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
             image.scaleAbsolute(250, 200);
            image.setAlignment(Image.MIDDLE);
            images.add(image);
            images.add(new Paragraph("\r\n"));
            chart = ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(Array2DtoArrayPlane), "Estadisticas de Usuarios Registrados por Tipo de Usuario", "Tipo de Usuario", "Cantidad de Usuarios");
            bufferedImage = chart.createBufferedImage(600, 400);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            image.scaleAbsolute(300, 200);
            image.setAlignment(Image.MIDDLE);
            Salida.add(new Paragraph("* Ver Anexo: Diagrama de Barras: Estadisticas de Usuarios Registrados por Genero"));
            Salida.add(new Paragraph("\r\n"));
            images.add(image);
            images.add(new Paragraph("\r\n"));
        }
        if(estado){
           rs=controlador.consultarUsuariosRegistradosPorEstado();
           resultadosTabla = biblioteca.reportes.PdfCreator.resultSetToArrayList(rs);
           for(int i=0;i<resultadosTabla.size();i++){
              if(resultadosTabla.get(i).get(0).equals("t") || resultadosTabla.get(i).get(0).equals("T")) resultadosTabla.get(i).set(0, "Activo");
              if(resultadosTabla.get(i).get(0).equals("f") || resultadosTabla.get(i).get(0).equals("F")) resultadosTabla.get(i).set(0, "Inactivo");
           }
           Array2DtoArrayPlane = biblioteca.reportes.PdfCreator.Array2DtoArrayPlane(resultadosTabla,0,1);
           for(int i=1;i<resultadosTabla.size();i++)
               total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
            tabla=biblioteca.reportes.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
            Salida.add(new Paragraph("Estadisticas de Usuarios Registrados por Estado de Cuenta"));
            Salida.add(new Paragraph("\r\n"));
            Salida.add(tabla);
            Salida.add(new Paragraph("\r\n"));
            Salida.add(new Paragraph("* Ver Anexo: Diagrama de Pastel: Estadisticas de Usuarios por Estado de Cuenta"));
            Salida.add(new Paragraph("\r\n"));
            chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(Array2DtoArrayPlane),"Estadisticas de Usuarios por Estado de Cuenta");
            bufferedImage = chart.createBufferedImage(450, 400);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
             image.scaleAbsolute(250, 200);
            image.setAlignment(Image.MIDDLE);
            images.add(image);
            images.add(new Paragraph("\r\n"));
            chart = ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(Array2DtoArrayPlane), "Estadisticas de Usuarios Registrados por Estado de Cuenta", "Estado de Cuenta", "Cantidad de Usuarios");
            bufferedImage = chart.createBufferedImage(600, 400);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            image.scaleAbsolute(300, 200);
            image.setAlignment(Image.MIDDLE);
            Salida.add(new Paragraph("* Ver Anexo: Diagrama de Barras: Estadisticas de Usuarios Registrados por Estado de Cuenta"));
            Salida.add(new Paragraph("\r\n"));
            images.add(image);
            images.add(new Paragraph("\r\n"));
        }
        if(area){
            total=0;
           rs=controlador.consultarUsuariosRegistradosPorArea();
           resultadosTabla = biblioteca.reportes.PdfCreator.resultSetToArrayList(rs);
           Array2DtoArrayPlane = biblioteca.reportes.PdfCreator.Array2DtoArrayPlane(resultadosTabla,0,2);
           for(int i=1;i<resultadosTabla.size();i++)
               total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
           tabla=biblioteca.reportes.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
           Salida.add(new Paragraph("Areas con más Documentos Catalogados"));
           Salida.add(new Paragraph("\r\n"));
           Salida.add(tabla);
           Salida.add(new Paragraph("\r\n"));
           Salida.add(new Paragraph("* Ver Anexo Diagrama de Pastel y Diagrama de Barras para Areas con más Documentos Catalogados"));
           Salida.add(new Paragraph("\r\n"));
           chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(Array2DtoArrayPlane),"Areas con más Documentos Catalogados");
           bufferedImage = chart.createBufferedImage(600, 600);
           image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
           image.scaleAbsolute(300, 300);
           image.setAlignment(Image.MIDDLE);
           images.add(image);
           images.add(new Paragraph("\r\n"));
           chart=ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(Array2DtoArrayPlane), "Areas con más Documentos Catalogados", "Area_ID", "Numero de Documentos Catalogados");
           bufferedImage = chart.createBufferedImage(900, 500);
           image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
           image.scaleAbsolute(450, 250);
           image.setAlignment(Image.MIDDLE);
           images.add(image);
           images.add(new Paragraph("\r\n"));
        }
        if(!images.isEmpty()){
            Salida.add(new Paragraph("Anexos:"));
            Salida.add(new Paragraph("\r\n"));
        }
        for(int i=0;i<images.size();i++){
            Salida.add(images.get(i));
        }
        return Salida;
    }
    
    
    public ArrayList<Element> ConsultarDocumentosCatalogados(boolean dow, boolean dom, boolean month, String year, String[] franja, String[] desde, String[] Hasta, boolean area, boolean autor, boolean doc_tipo, boolean pc, boolean usuario, int salida)  throws BadElementException, MalformedURLException, IOException{
       
       ArrayList<Element> Salida=  new ArrayList<Element>(100);
       ArrayList<Element> Images=  new ArrayList<Element>(100);
       DaoEstadisticas controlador=new DaoEstadisticas();
       ResultSet rs;
       JFreeChart chart;
       BufferedImage bufferedImage;
       Image image;
       ArrayList<ArrayList<String>> resultadosTabla;
       ArrayList<String> Array2DtoArrayPlane;
       PdfPTable tabla=null;
       int total=0;  
       if(dow){
            ArrayList<String> tmp= controlador.consultarDocumentosCatalogadosPorDoW();
            float promedio=promedio(tmp,2);
            Salida.add(new Paragraph("Resultados de Documentos Catalogados para los días de la semana"));
            Salida.add(new Paragraph("\r\n"));
            Salida.add(biblioteca.reportes.PdfCreator.plainArrayListToPdfPTable(agregarPorcentajesALista(tmp, 2), 3));
            Salida.add(new Paragraph("Promedio "+promedio));
            Salida.add(new Paragraph("\r\n"));
            Salida.add(new Paragraph("* Ver Anexo: Diagrama de Pastel: Documentos Catalogados para los dias de la Semana"));
            Salida.add(new Paragraph("\r\n"));
            chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(tmp),"Documentos Catalogados para los Días de la Semana");
            bufferedImage = chart.createBufferedImage(400, 300);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            image.scaleAbsolute(300, 200);
            image.setAlignment(Image.MIDDLE);
            Images.add(image);
            Images.add(new Paragraph("\r\n"));
            Salida.add(new Paragraph("* Ver Anexo: Diagrama de Barras: Documentos Catalogados para los Días de la Semana"));
            Salida.add(new Paragraph("\r\n"));
            chart = ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(tmp), "Documentos Catalogados para los Días de la Semana", "Días de la Semana", "Cantidad de Documentos Catalogados");
            bufferedImage = chart.createBufferedImage(700, 300);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            image.scaleAbsolute(400, 200);
            image.setAlignment(Image.MIDDLE);
            Images.add(image);
            Images.add(new Paragraph("\r\n"));
        }
       if(dom){
            rs=controlador.consultarDocumentosCatalogadosPorDoM();
           resultadosTabla = biblioteca.reportes.PdfCreator.resultSetToArrayList(rs);
           Array2DtoArrayPlane = biblioteca.reportes.PdfCreator.Array2DtoArrayPlane(resultadosTabla,0,1);
           for(int i=1;i<resultadosTabla.size();i++)
               total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
            tabla=biblioteca.reportes.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
            Salida.add(new Paragraph("Resultados de Documentos Catalogados para los días del mes"));
            Salida.add(new Paragraph("\r\n"));
            Salida.add(tabla);
           Salida.add(new Paragraph("\r\n"));
            Salida.add(new Paragraph("* Ver Anexo: Diagrama de Pastel: Documentos Catalogados para los dias del mes"));
            Salida.add(new Paragraph("\r\n"));
            chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(Array2DtoArrayPlane),"Documentos Catalogados para los días del mes");
            bufferedImage = chart.createBufferedImage(500, 600);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            image.scaleAbsolute(250, 300);
            image.setAlignment(Image.MIDDLE);
            Images.add(image);
            Images.add(new Paragraph("\r\n"));
            chart = ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(Array2DtoArrayPlane), "Documentos Catalogados para los días del Mes", "Días del mes", "Documentos Catalogados");
            bufferedImage = chart.createBufferedImage(1000, 500);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            image.scaleAbsolute(500, 250);
            image.setAlignment(Image.MIDDLE);
            Salida.add(new Paragraph("* Ver Anexo: Diagrama de Barras: Documentos Catalogados para los dias del mes"));
            Salida.add(new Paragraph("\r\n"));
            Images.add(image);
            Images.add(new Paragraph("\r\n"));
        }
        if(month){
            ArrayList<String> tmp= controlador.consultarDocumentosCatalogadosPorMes();
            Salida.add(new Paragraph("Resultados de Documentos Catalogados para los meses"));
            Salida.add(new Paragraph("\r\n"));
            float promedio=promedio(tmp,2);
            Salida.add(biblioteca.reportes.PdfCreator.plainArrayListToPdfPTable(agregarPorcentajesALista(tmp, 2), 3));
            Salida.add(new Paragraph("Promedio "+promedio));
            Salida.add(new Paragraph("\r\n"));
            Salida.add(new Paragraph("* Ver Anexo: Diagrama de Pastel: Documentos Catalogados para los meses"));
            Salida.add(new Paragraph("\r\n"));
            chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(tmp),"Documentos Catalogados para los meses");
            bufferedImage = chart.createBufferedImage(500, 300);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            image.scaleAbsolute(350, 200);
            image.setAlignment(Image.MIDDLE);
            Images.add(image);
            Images.add(new Paragraph("\r\n"));
            Salida.add(new Paragraph("* Ver Anexo: Diagrama de Barras: Documentos Catalogados para los meses"));
            Salida.add(new Paragraph("\r\n"));
            chart = ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(tmp), "Documentos Catalogados para los Meses", "Meses", "Documentos Catalogados");
            bufferedImage = chart.createBufferedImage(1000, 600);
            image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
            image.scaleAbsolute(500, 300);
            image.setAlignment(Image.MIDDLE);
            Images.add(image);
            Images.add(new Paragraph("\r\n"));
        }
        if(year!=null){
            ArrayList<String> tmp= controlador.consultarDocumentosCatalogadosPorYear(year);
            Salida.add(new Paragraph("Resultados para el año seleccionado"));
            Salida.add(new Paragraph("\r\n"));
            Salida.add(new Paragraph("Año: "+tmp.get(0)+", Resultados:"+tmp.get(1)));
            Salida.add(new Paragraph("\r\n"));
        }
        if(franja!=null){
            ArrayList<String> tmp= controlador.consultarDocumentosCatalogadosPorFranja(franja[0], franja[1]);
            Salida.add(new Paragraph("Resultados para la franja seleccionada"));
            Salida.add(new Paragraph("\r\n"));
            Salida.add(new Paragraph("Franja:"+tmp.get(0)+", Resultados:"+tmp.get(1)));
            Salida.add(new Paragraph("\r\n"));
        }
        if(desde!=null && Hasta !=null){
            ArrayList<String> tmp= controlador.consultarDocumentosCatalogadosPorIntervalo(desde[0]+"-"+desde[1]+"-"+desde[2],
                    Hasta[0]+"-"+Hasta[1]+"-"+Hasta[2]);
            Salida.add(new Paragraph("Resultados para el intervalo de tiempo seleccionado"));
            Salida.add(new Paragraph("\r\n"));
            Salida.add(new Paragraph("Intervalo de Tiempo: "+tmp.get(0)+", Resultados:"+tmp.get(1)));
            Salida.add(new Paragraph("\r\n"));
        }
       if(area){
           total=0;
           rs=controlador.consultarDocumentosCatalogadosPorArea();
           resultadosTabla = biblioteca.reportes.PdfCreator.resultSetToArrayList(rs);
           Array2DtoArrayPlane = biblioteca.reportes.PdfCreator.Array2DtoArrayPlane(resultadosTabla,0,2);
           for(int i=1;i<resultadosTabla.size();i++)
               total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
           tabla=biblioteca.reportes.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
           Salida.add(new Paragraph("Areas con más Documentos Catalogados"));
           Salida.add(new Paragraph("\r\n"));
           Salida.add(tabla);
           Salida.add(new Paragraph("\r\n"));
           Salida.add(new Paragraph("* Ver Anexo Diagrama de Pastel y Diagrama de Barras para Areas con más Documentos Catalogados"));
           Salida.add(new Paragraph("\r\n"));
           chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(Array2DtoArrayPlane),"Areas con más Documentos Catalogados");
           bufferedImage = chart.createBufferedImage(600, 600);
           image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
           image.scaleAbsolute(300, 300);
           image.setAlignment(Image.MIDDLE);
           Images.add(image);
           Images.add(new Paragraph("\r\n"));
           chart=ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(Array2DtoArrayPlane), "Areas con más Documentos Catalogados", "Area_ID", "Numero de Documentos Catalogados");
           bufferedImage = chart.createBufferedImage(900, 500);
           image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
           image.scaleAbsolute(450, 250);
           image.setAlignment(Image.MIDDLE);
           Images.add(image);
           Images.add(new Paragraph("\r\n"));
       }
       
       if(autor){
           total=0;
           rs=controlador.consultarDocumentosCatalogadosPorAutor();
           resultadosTabla = biblioteca.reportes.PdfCreator.resultSetToArrayList(rs);
           Array2DtoArrayPlane = biblioteca.reportes.PdfCreator.Array2DtoArrayPlane(resultadosTabla,1,3);
           for(int i=1;i<resultadosTabla.size();i++)
               total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
           tabla=biblioteca.reportes.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
           Salida.add(new Paragraph("Autores con más Documentos Catalogados"));
           Salida.add(new Paragraph("\r\n"));
           Salida.add(tabla);
           Salida.add(new Paragraph("\r\n"));
           Salida.add(new Paragraph("* Ver Anexo Diagrama de Pastel y Diagrama de Barras para Autores con más Documentos Catalogados"));
           Salida.add(new Paragraph("\r\n"));
           chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(Array2DtoArrayPlane),"Autores con más Documentos Catalogados");
           bufferedImage = chart.createBufferedImage(600, 600);
           image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
           image.scaleAbsolute(300, 300);
           image.setAlignment(Image.MIDDLE);
           Images.add(image);
           Images.add(new Paragraph("\r\n"));
           chart=ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(Array2DtoArrayPlane), "Autores con más Documentos Catalogados", "Nombre Autor", "Numero de Documentos Catalogados");
           bufferedImage = chart.createBufferedImage(1000, 600);
           image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
           image.scaleAbsolute(400, 300);
           image.setAlignment(Image.MIDDLE);
           Images.add(image);
           Images.add(new Paragraph("\r\n"));
       }
       if(doc_tipo){
           total=0;
           rs=controlador.consultarDocumentosCatalogadosPorTipoMaterial();
           resultadosTabla = biblioteca.reportes.PdfCreator.resultSetToArrayList(rs);
           Array2DtoArrayPlane = biblioteca.reportes.PdfCreator.Array2DtoArrayPlane(resultadosTabla,0,1);
           for(int i=1;i<resultadosTabla.size();i++)
               total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
           tabla=biblioteca.reportes.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
           Salida.add(new Paragraph("Tipos de Material con más Documentos Catalogados"));
           Salida.add(new Paragraph("\r\n"));
           Salida.add(tabla);
           Salida.add(new Paragraph("\r\n"));
           Salida.add(new Paragraph("* Ver Anexo Diagrama de Pastel y Diagrama de Barras para Tipos de Material con más Documentos Catalogados"));
           Salida.add(new Paragraph("\r\n"));
           chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(Array2DtoArrayPlane),"Tipos de Material con más Documentos Catalogados");
           bufferedImage = chart.createBufferedImage(600, 600);
           image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
           bufferedImage = chart.createBufferedImage(300, 300);
           image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
           image.setAlignment(Image.MIDDLE);
           Images.add(image);
           Images.add(new Paragraph("\r\n"));
           chart=ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(Array2DtoArrayPlane), "Tipos de Material con más Documentos Catalogados", "Tipo de Material", "Numero de Documentos Catalogados");
           bufferedImage = chart.createBufferedImage(900, 500);
           image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
           image.scaleAbsolute(450, 250);
           image.setAlignment(Image.MIDDLE);
           Images.add(image);
           Images.add(new Paragraph("\r\n"));
       }
         if(pc){
           total=0;
           rs=controlador.consultarDocumentosCatalogadosPorPalabraClave();
           resultadosTabla = biblioteca.reportes.PdfCreator.resultSetToArrayList(rs);
           Array2DtoArrayPlane = biblioteca.reportes.PdfCreator.Array2DtoArrayPlane(resultadosTabla,0,1);
           for(int i=1;i<resultadosTabla.size();i++)
               total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
           tabla=biblioteca.reportes.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
           Salida.add(new Paragraph("Palabras Clave con más Documentos Catalogados"));
           Salida.add(new Paragraph("\r\n"));
           Salida.add(tabla);
           Salida.add(new Paragraph("\r\n"));
           Salida.add(new Paragraph("* Ver Anexo Diagrama de Pastel y Diagrama de Barras para Palabras Clave con más Documentos Catalogados"));
           Salida.add(new Paragraph("\r\n"));
           chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(Array2DtoArrayPlane),"Palabras Clave con más Documentos Catalogados");
           bufferedImage = chart.createBufferedImage(500, 500);
           image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
           image.scaleAbsolute(250, 250);
           image.setAlignment(Image.MIDDLE);
           Images.add(image);
           Images.add(new Paragraph("\r\n"));
           chart=ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(Array2DtoArrayPlane), "Palabras Clave con más Documentos Catalogados", "Palabras Clave", "Numero de Documentos Catalogados");
           bufferedImage = chart.createBufferedImage(900, 500);
           image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
           image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
           image.scaleAbsolute(450, 250);
           Images.add(image);
           Images.add(new Paragraph("\r\n"));
       }
       if(usuario){
           total=0;
           rs=controlador.consultarDocumentosCatalogadosPorUsuarios();
           resultadosTabla = biblioteca.reportes.PdfCreator.resultSetToArrayList(rs);
           Array2DtoArrayPlane = biblioteca.reportes.PdfCreator.Array2DtoArrayPlane(resultadosTabla,0,2);
           for(int i=1;i<resultadosTabla.size();i++)
               total+=Integer.parseInt(resultadosTabla.get(i).get(resultadosTabla.get(i).size()-1));
           tabla=biblioteca.reportes.PdfCreator.arrayListToStatisticTable(resultadosTabla, total, salida);
           Salida.add(new Paragraph("Usuarios que mas Catalogan Documentos"));
           Salida.add(new Paragraph("\r\n"));
           Salida.add(tabla);
           Salida.add(new Paragraph("\r\n"));
           Salida.add(new Paragraph("* Ver Anexo Diagrama de Pastel y Diagrama de Barras para Usuarios que mas Catalogan"));
           Salida.add(new Paragraph("\r\n"));
           chart = ChartCreator.generatePieChart(ChartCreator.asignarPieDataset(Array2DtoArrayPlane),"Usuarios que mas Catalogan");
           bufferedImage = chart.createBufferedImage(500, 500);
           image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
           image.scaleAbsolute(250, 250);
           image.setAlignment(Image.MIDDLE);
           Images.add(image);
           Images.add(new Paragraph("\r\n"));
           chart=ChartCreator.generateBarChart(ChartCreator.asignarBarDataset(Array2DtoArrayPlane), "Usuarios que mas Catalogan", "Username", "Numero de Documentos Catalogados");
           bufferedImage = chart.createBufferedImage(900, 500);
           image = Image.getInstance(EncoderUtil.encode(bufferedImage, "png"));
           image.scaleAbsolute(450, 250);
           image.setAlignment(Image.MIDDLE);
           Images.add(image);
           Images.add(new Paragraph("\r\n"));
       }
       if(!Images.isEmpty()){
            Salida.add(new Paragraph("Anexos:"));
            Salida.add(new Paragraph("\r\n"));
        }
        for(int i=0;i<Images.size();i++){
            Salida.add(Images.get(i));
        }
        return Salida;
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
        return salida;
    }

    
    
}
