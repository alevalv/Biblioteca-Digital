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
package biblioteca.Main;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
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
 * (iText)
 * 
 * @author Alejandro Valdés Villada
 * @author María Cristina Bustos Rodríguez
 */
public class PdfCreator {
    
    static java.util.Date actual=new java.util.Date();
    static java.sql.Timestamp fecha=new java.sql.Timestamp(actual.getTime());
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
                if(i==entrada.size()-1){
                    int porcentaje=(int) (Integer.parseInt(entrada.get(j).get(i))*100)/total;
                    salida.addCell(porcentaje+"%");
                }
            }
            counter++;
        }
        return salida;
    }
    
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
}
