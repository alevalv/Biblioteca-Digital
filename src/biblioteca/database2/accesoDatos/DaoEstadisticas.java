/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.accesoDatos;

import biblioteca.database2.fachada.Fachada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alejandro
 */
public class DaoEstadisticas {
    Fachada Fachada;

    public DaoEstadisticas() {
        Fachada=new Fachada();
    }
    
    public ResultSet documentosMasDescargados(String dow,String dom,String month,String year,String tipo_usuario,
       String[] franja,String[] desde,String[] hasta,String area,String autor,String doc_tipo,String usuario, boolean todos){
        String sql_descargados="";
        if(todos){
            sql_descargados="SELECT doc_id as Identificación, documentos."
                    + "titulo_principal as Titulo, count(*) as Descargas FROM usuario_descarga_documento NATURAL JOIN "
                    + "documentos JOIN usuarios ON usuario_descarga_documento.username=usuarios.username ";
            if(franja!=null){
                sql_descargados+="WHERE date_part('hour',fecha_hora)>="+franja[0]+" and date_part('hour',fecha_hora)<="+franja[1]+" ";
            }
            sql_descargados+="GROUP BY Identificación, Titulo ORDER BY  descargas DESC; ";
                    
        }
        else{
            sql_descargados="SELECT doc_id as Identificación, documentos."
                    + "titulo_principal as Titulo, count(*) as Descargas FROM usuario_descarga_documento NATURAL JOIN "
                    + "documentos JOIN usuarios ON usuario_descarga_documento.username=usuarios.username WHERE ";
            ArrayList<String> condiciones = new ArrayList<String>(12);
            if(dow!=null){
                condiciones.add("date_part('dow', fecha_hora)="+dow+" ");
            }
            if(dom!=null){
                condiciones.add("date_part('day',fecha_hora)="+dom+" ");
            }
            if(month!=null){
                condiciones.add("date_part('month',fecha_hora)="+month+" ");
            }
            if(year!=null){
                condiciones.add("date_part('year',fecha_hora)="+year+" ");
            }
            if(tipo_usuario!=null){
                if(tipo_usuario.equals("1"))
                    condiciones.add("usuarios.tipo_usuario='3' ");
                else  condiciones.add("usuarios.tipo_usuario='2' ");
            }
            if(franja!=null){
                condiciones.add("date_part('hour',fecha_hora)>="+franja[0]+" and date_part('hour',fecha_hora)<="+franja[1]+" ");
            }
            if(desde!=null && hasta!=null){
                condiciones.add("fecha_hora between '"+desde[0]+"-"+desde[1]+"-"+desde[2]+"' AND '"
                    +hasta[0]+"-"+hasta[1]+"-"+hasta[2]+"' ");
            }
            
            
            
            for(int i=0;i<condiciones.size();i++){
                sql_descargados+=(i!=(condiciones.size()-1)) ? condiciones.get(i)+"AND " : condiciones.get(i);
            }
            sql_descargados+="GROUP BY Identificación, Titulo ORDER BY  descargas DESC; ";
        }
        System.out.println(sql_descargados);
        try {
            Connection conn = Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet salida = sentencia.executeQuery(sql_descargados);
            conn.close();
            return salida;
        }
        catch (SQLException e) {
            System.err.println(e);
        } 
        catch (Exception e) {
            System.err.println(e);
        }
        return null;
       
    }
    
    public ResultSet documentosMasConsultados(String dow,String dom,String month,String year,String tipo_usuario,
       String[] franja,String[] desde,String[] hasta,String area,String autor,String doc_tipo,String usuario, boolean todos){
        String sql_descargados="";
        if(todos){
            sql_descargados="SELECT doc_id as Identificación, documentos."
                    + "titulo_principal as Titulo, count(*) as Descargas FROM usuario_consulta_documento NATURAL JOIN "
                    + "documentos JOIN usuarios ON usuario_consulta_documento.username=usuarios.username ";
            if(franja!=null){
                sql_descargados+="WHERE date_part('hour',fecha_hora)>="+franja[0]+" and date_part('hour',fecha_hora)<="+franja[1]+" ";
            }
            sql_descargados+="GROUP BY Identificación, Titulo ORDER BY  descargas DESC; ";
        }
        else{
            sql_descargados="SELECT doc_id as Identificación, documentos."
                    + "titulo_principal as Titulo, count(*) as Descargas FROM usuario_consulta_documento NATURAL JOIN "
                    + "documentos JOIN usuarios ON usuario_consulta_documento.username=usuarios.username WHERE ";
            ArrayList<String> condiciones = new ArrayList<String>(12);
            if(dow!=null){
                condiciones.add("date_part('dow', fecha_hora)="+dow+" ");
            }
            if(dom!=null){
                condiciones.add("date_part('day',fecha_hora)="+dom+" ");
            }
            if(month!=null){
                condiciones.add("date_part('month',fecha_hora)="+month+" ");
            }
            if(year!=null){
                condiciones.add("date_part('year',fecha_hora)="+year+" ");
            }
            if(tipo_usuario!=null){
                if(tipo_usuario.equals("1"))
                    condiciones.add("usuarios.tipo_usuario='3' ");
                else  condiciones.add("usuarios.tipo_usuario='2' ");
            }
            if(franja!=null){
                condiciones.add("date_part('hour',fecha_hora)>="+franja[0]+" and date_part('hour',fecha_hora)<="+franja[1]+" ");
            }
            if(desde!=null && hasta!=null){
                condiciones.add("fecha_hora between '"+desde[0]+"-"+desde[1]+"-"+desde[2]+"' AND '"
                    +hasta[0]+"-"+hasta[1]+"-"+hasta[2]+"' ");
            }
            
            
            
            for(int i=0;i<condiciones.size();i++){
                sql_descargados+=(i!=(condiciones.size()-1)) ? condiciones.get(i)+"AND " : condiciones.get(i);
            }
            sql_descargados+="GROUP BY Identificación, Titulo ORDER BY  descargas DESC; ";
        }
        System.out.println(sql_descargados);
        try {
            Connection conn = Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet salida = sentencia.executeQuery(sql_descargados);
            conn.close();
            return salida;
        }
        catch (SQLException e) {
            System.err.println(e);
        } 
        catch (Exception e) {
            System.err.println(e);
        }
        return null;
       
    }
    
}
