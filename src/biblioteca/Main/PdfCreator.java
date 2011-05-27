/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.Main;

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

/**
 *
 * @author alejandro
 */
public class PdfCreator {
    static public PdfPTable resultSetToTable(ResultSet entrada){
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
    
    static public void createPdf(String path, String titulo, String encabezado, PdfPTable tabla){
        Document document = new Document();
        // step 2
        try{
        PdfWriter.getInstance(document, new FileOutputStream(path));
        Font myFontTitle = new Font();
        myFontTitle.setFamily("Arial");
        myFontTitle.setStyle(Font.BOLD);
        myFontTitle.setSize(10);
        Paragraph pTitulo = new Paragraph(titulo, myFontTitle);
        pTitulo.setAlignment(Paragraph.ALIGN_CENTER);
        document.open();
        // step 4
        document.add(pTitulo);        
        document.add(new Paragraph(encabezado+tabla.getRows().size()+"\n"));
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
