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
package biblioteca.reportes;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

/**
 * Esta clase provee una interfaz entre los resultados de las consultas de la base
 * de datos para los reportes y estadisticas, y el módulo para la creación de pdf
 * (iText), provee metodos estaticos para crear tablas y pdf.
 * 
 * @author Alejandro Valdés Villada
 * @author María Cristina Bustos Rodríguez
 */
public class PdfCreator {
    
    static java.util.Date actual=new java.util.Date();
    static java.sql.Timestamp fecha=new java.sql.Timestamp(actual.getTime());
    /**
     * Dado un resultSet obtenido de una consulta, esta función convierte los datos
     * internos de este en una tabla que puede ser insertada en un Document de iText
     * esta PdfPTable tiene en su primera linea los nombres de las columnas del ResultSet
     * @param entrada ResultSet El resultado de una consulta a la base de datos
     * @return una PdfPTable para insertar en un documento de iText
     * @see com.itextpdf.text.pdf.PdfPTable;
     * @see java.sql.ResultSet;
     */
    static public PdfPTable resultSetToTable(ResultSet entrada){
        PdfPTable salida = null;
        try{
            ResultSetMetaData rsmd = entrada.getMetaData();
        
            salida = new PdfPTable(rsmd.getColumnCount());
            for(int i=1;i<=rsmd.getColumnCount();i++){
                salida.addCell(rsmd.getColumnName(i));
            }
            salida.setHeaderRows(1);
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
    
    static public PdfPTable plainArrayListToPdfPTable(ArrayList<String> entrada){
        PdfPTable salida= new PdfPTable(2);
        salida.addCell(entrada.get(0));
        salida.addCell(entrada.get(1));
        salida.setHeaderRows(1);
        for(int i=2;i<entrada.size();i++){
            salida.addCell(entrada.get(i));
        }
        return salida;
    }
    
    static public ArrayList<PdfPTable> resultSetsToTables(ArrayList<ResultSet> entrada){
        ArrayList<PdfPTable> Salida = new ArrayList<PdfPTable>(10);
        PdfPTable salida=null;
        for(int j=0;j<entrada.size();j++){
        try{
            ResultSetMetaData rsmd = entrada.get(j).getMetaData();
        
            salida = new PdfPTable(rsmd.getColumnCount());
            for(int i=1;i<=rsmd.getColumnCount();i++){
                salida.addCell(rsmd.getColumnName(i));
            }
            salida.setHeaderRows(1);
            while(entrada.get(j).next()){
                for(int i=1;i<=rsmd.getColumnCount();i++){
                    salida.addCell(entrada.get(j).getString(i));
                }
            }
        }catch(java.sql.SQLException sqlex){
            System.err.println(sqlex);
        }
         Salida.add(salida);
        }
        return Salida;
    }
    /**
     * Esta función convierte un arrayList en una PdfPTable y, agrega una columna
     * de estadisticas a esta. Funcionará si el arrayList tiene en su ultima columna
     * numeros
     * @param entrada Matriz con los datos estadisticos de la base de datos
     * @param total La suma de todos los datos de la ultima columna
     * @param rows El numero de columnas que se mostrarán en la PdfPTable
     * @return PdfPTable Contiene los datos del ArrayList más los porcentajes.
     */
    static public PdfPTable arrayListToStatisticTable(ArrayList<ArrayList<String>> entrada, int total, int rows){
        PdfPTable salida = null;
        
        salida = new PdfPTable(entrada.get(0).size() +1);
        for(int i=0;i<entrada.get(0).size();i++){
            salida.addCell(entrada.get(0).get(i));
        }
        salida.addCell("Porcentaje");
        salida.setHeaderRows(1);
        int counter=0;
        for(int j=1;j<entrada.size()&&counter<rows;j++){
            for(int i=0;i<entrada.get(j).size();i++){
                salida.addCell(entrada.get(j).get(i));
                if(i==entrada.get(j).size()-1){
                    int porcentaje=(int) (Integer.parseInt(entrada.get(j).get(i))*100)/total;
                    salida.addCell(porcentaje+"%");
                }
            }
            counter++;
        }
        if(entrada.size()-1>rows){
            int otros=0, otrospor;
            for(int i=counter;i<entrada.size();i++){
                otros+=Integer.parseInt(entrada.get(i).get(entrada.get(i).size()-1));
            }
            otrospor=otros*100;
            otrospor/=total;
            salida.addCell("-");
            salida.addCell("Otros");
            salida.addCell(otros+"");
            salida.addCell(otrospor+"%");
        }
        return salida;
    }
    
    /**
     * Dado un resultSet, se transforma en un ArrayList de ArrayList de String,
     * manteniendo la misma estructura de tabla que tenia el resultSet original,
     * y en su primera linea teniendo los nombres de las columnas del resultSet
     * @param entrada Un ResultSet obtenido de una consulta SQL
     * @return ArrayList<ArrayList<String>> que contiene los datos del ResultSet más los nombres de la columna
     */
    static public ArrayList<ArrayList<String>> resultSetToArrayList(ResultSet entrada){
        ArrayList<ArrayList<String>> salida = null;
        try{
            ResultSetMetaData rsmd = entrada.getMetaData();
            salida=new ArrayList<ArrayList<String>>();
            ArrayList<String> titulos = new ArrayList<String>(rsmd.getColumnCount());
            for(int i=1;i<=rsmd.getColumnCount();i++){
                titulos.add(rsmd.getColumnName(i));
            }
            salida.add(titulos);
            while(entrada.next()){
                ArrayList<String> temporal = new ArrayList<String>(rsmd.getColumnCount());
                for(int i=1;i<=rsmd.getColumnCount();i++){
                    temporal.add(entrada.getString(i));
                }
                salida.add(temporal);
                
            }
        }catch(java.sql.SQLException sqlex){
            System.err.println(sqlex);
        }
        return salida;
    }
    
    /**
     * createPdf es una función estatica que funciona como plantilla para generar
     * reportes dinamicos, según la necesidad del usuario.
     * @param path La dirección del archivo donde se guardará el pdf
     * @param titulo El Título que llevará el pdf
     * @param encabezado Un texto que se mostrará bajo el título
     * @param tabla La tabla de resultados que mostrará el pdf
     */
    static public void createPdf(String path, String titulo, String encabezado, PdfPTable tabla){
        Document document = new Document();
        // step 2
        try{
        PdfWriter.getInstance(document, new FileOutputStream(path));
        Font myFontTitle = new Font();
        myFontTitle.setFamily("Arial");
        myFontTitle.setStyle(Font.BOLD);
        myFontTitle.setSize(10);
        Font Univallef= new Font();
        Univallef.setColor(BaseColor.RED);
        Univallef.setFamily("Arial");
        Univallef.setSize(18);
        Paragraph Univalle = new Paragraph("Universidad del Valle", Univallef);
        Univalle.setAlignment(Paragraph.ALIGN_CENTER);
        Paragraph pTitulo = new Paragraph(titulo, myFontTitle);
        pTitulo.setAlignment(Paragraph.ALIGN_CENTER);
        Paragraph Fecha = new Paragraph("Fecha y Hora de Reporte: "+fecha,myFontTitle);
        document.open();
        // step 4
        document.add(Univalle);
        document.add(new Paragraph("\r\n"));
        document.add(pTitulo);        
        document.add(new Paragraph("\r\n"));
        document.add(Fecha);
        document.add(new Paragraph("\r\n"));
        document.add(new Paragraph(encabezado+(tabla.getRows().size()-1)));
        document.add(new Paragraph("\r\n"));
        document.add(tabla);
        // step 5
        document.close();
        }
        catch(DocumentException de){
            System.err.println(de);
        }
        catch(IOException ioex){
            System.err.println(ioex);
        }
    }
    
    static public void createArrayListPdf(String path, String titulo, String encabezado, ArrayList<PdfPTable> tablas){
        Document document = new Document();
       //step 2
        try{
        PdfWriter.getInstance(document, new FileOutputStream(path));
        Font myFontTitle = new Font();
        myFontTitle.setFamily("Arial");
        myFontTitle.setStyle(Font.BOLD);
        myFontTitle.setSize(10);
        Font Univallef= new Font();
        Univallef.setColor(BaseColor.RED);
        Univallef.setFamily("Arial");
        Univallef.setSize(18);
        Paragraph Univalle = new Paragraph("Universidad del Valle", Univallef);
        Univalle.setAlignment(Paragraph.ALIGN_CENTER);
        Paragraph pTitulo = new Paragraph(titulo, myFontTitle);
        pTitulo.setAlignment(Paragraph.ALIGN_CENTER);
        Paragraph Fecha = new Paragraph("Fecha y Hora de Reporte: "+fecha,myFontTitle);
        document.open();
        // step 4
        document.add(Univalle);
        document.add(new Paragraph("\r\n"));
        document.add(pTitulo);        
        document.add(new Paragraph("\r\n"));
        document.add(Fecha);
        document.add(new Paragraph("\r\n"));
        for(int i=0;i<tablas.size();i++){
        document.add(new Paragraph(encabezado+(tablas.get(i).getRows().size()-1)));
        document.add(new Paragraph("\r\n"));
        document.add(tablas.get(i));
        }
        // step 5
        document.close();
        }
        catch(DocumentException de){
            System.err.println(de);
        }
        catch(IOException ioex){
            System.err.println(ioex);
        }
    }
    
    static public void createDinamicPdf(String path, String titulo, String encabezado, ArrayList<Element> contenido){
        Document document = new Document();
       //step 2
        try{
        PdfWriter.getInstance(document, new FileOutputStream(path));
        Font myFontTitle = new Font();
        myFontTitle.setFamily("Arial");
        myFontTitle.setStyle(Font.BOLD);
        myFontTitle.setSize(10);
        Font Univallef= new Font();
        Univallef.setColor(BaseColor.RED);
        Univallef.setFamily("Arial");
        Univallef.setSize(18);
        Paragraph Univalle = new Paragraph("Universidad del Valle", Univallef);
        Univalle.setAlignment(Paragraph.ALIGN_CENTER);
        Paragraph pTitulo = new Paragraph(titulo, myFontTitle);
        pTitulo.setAlignment(Paragraph.ALIGN_CENTER);
        Paragraph Fecha = new Paragraph("Fecha y Hora de Reporte: "+fecha,myFontTitle);
        Paragraph Introduccion = new Paragraph("Reporte de usuarios registrados");
        document.open();
        // step 4
        document.add(Univalle);
        document.add(new Paragraph("\r\n"));
        document.add(pTitulo);        
        document.add(new Paragraph("\r\n"));
        document.add(Fecha);
        document.add(new Paragraph("\r\n"));
        document.add(Introduccion);
        document.add(new Paragraph("\r\n"));
        for(int i=0;i<contenido.size();i++){
        document.add(contenido.get(i).getClass().equals(new PdfPTable(2).getClass()) ? (PdfPTable) contenido.get(i) : contenido.get(i));
        }
        // step 5
        document.close();
        }
        catch(DocumentException de){
            System.err.println(de);
        }
        catch(IOException ioex){
            System.err.println(ioex);
        }
    }
}
