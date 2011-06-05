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
package biblioteca.database2.accesoDatos;

import biblioteca.database2.fachada.Fachada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *  Esta clase forma parte de los controladores creados para cumplir con el Patrón
 * de diseño DAO.
 * 
 * <br>DaoEstadisticas crea el sql que se ejecutará a través de una conexión de una Fachada,
 * este dao tiene que ver con todo lo relacionado con la generación de estadisticas sobre
 * la base de datos
 * 
 * @see <a href="http://www.proactiva-calidad.com/java/patrones/DAO.html">Patrón "Data Access Object"</a>
 *
 * @author María Cristina Bustos Rodríguez
 * @author Alejandro Valdés Villada
 */
public class DaoEstadisticas {
    Fachada Fachada;

    /**
     * Crea un objeto DaoEstadisticas, inicializando la fachada
     */
    public DaoEstadisticas() {
        Fachada=new Fachada();
    }
    
    public ResultSet documentosMasDescargados(String dow,String dom,String month,String year,String tipo_usuario,
       String[] franja,String[] desde,String[] hasta,String area,String autor,String doc_tipo,String usuario, boolean todos){
        String sql_descargados="";
        if(todos){
            sql_descargados="SELECT doc_id as Identificacion, documentos."
                    + "titulo_principal as Titulo, count(*) as Descargas FROM usuario_descarga_documento NATURAL JOIN "
                    + "documentos JOIN usuarios ON usuario_descarga_documento.username=usuarios.username ";
            if(franja!=null){
                sql_descargados+="WHERE date_part('hour',fecha_hora)>="+franja[0]+" and date_part('hour',fecha_hora)<="+franja[1]+" ";
            }       
        }
        else{
            sql_descargados="SELECT doc_id as Identificacion, documentos."
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
        }
        
        sql_descargados+=crearCondicionesEspecialesDescargados(tipo_usuario, area, autor, doc_tipo, usuario);
        sql_descargados+=" GROUP BY Identificacion, Titulo ORDER BY  descargas DESC; ";
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
    
    private String crearCondicionesEspecialesDescargados(String tipo_usuario, String area,String autor,String doc_tipo,String usuario){
        String salida="";
        ArrayList condiciones = new ArrayList(5);
        if(tipo_usuario!=null){
            String temp;
            temp="(SELECT DISTINCT doc_id FROM usuario_descarga"
                    + "_documento NATURAL JOIN usuarios WHERE tipo_usuario="+
                    ((tipo_usuario.equals("Usuario Normal")) ? "'3'" : "'2'") +
                    ((usuario!=null) ? " AND username='"+usuario : "")+")";
            condiciones.add(temp);
        }
        if(area!=null){
            String temp;
            temp="(SELECT DISTINCT doc_id FROM documento_areas"
                    + "_computacion WHERE area_id='" + area +"')";
            condiciones.add(temp);
        }
        if(autor!=null){
            String temp;
            temp="(SELECT DISTINCT doc_id FROM documento_autor"
                    +" WHERE autor_correo='"+autor+"')";
            condiciones.add(temp);
        }
        if(doc_tipo!=null){
            String temp;
            temp="(SELECT DISTINCT doc_id FROM documentos WHERE "
                    +"tipo_documento='"+doc_tipo+"')";
            condiciones.add(temp);
        }
        if(!condiciones.isEmpty())
            salida+=" AND doc_id IN(";
        for(int i=0;i<condiciones.size();i++){
            salida+=(i!=(condiciones.size()-1)) ? (condiciones.get(i) + " INTERSECT ") : condiciones.get(i) + ")";
        }
        return salida;
    }
    
    public ResultSet documentosMasConsultados(String dow,String dom,String month,String year,String tipo_usuario,
       String[] franja,String[] desde,String[] hasta,String area,String autor,String doc_tipo,String usuario, boolean todos){
        String sql_descargados="";
        if(todos){
            sql_descargados="SELECT doc_id as Identificacion, documentos."
                    + "titulo_principal as Titulo, count(*) as Descargas FROM usuario_consulta_documento NATURAL JOIN "
                    + "documentos JOIN usuarios ON usuario_consulta_documento.username=usuarios.username ";
            if(franja!=null){
                sql_descargados+="WHERE date_part('hour',fecha_hora)>="+franja[0]+" and date_part('hour',fecha_hora)<="+franja[1]+" ";
            }
        }
        else{
            sql_descargados="SELECT doc_id as Identificacion, documentos."
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
        }
        sql_descargados+=crearCondicionesEspecialesConsultados(tipo_usuario, area, autor, doc_tipo, usuario);
        sql_descargados+=" GROUP BY Identificacion, Titulo ORDER BY  descargas DESC; ";
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
    
    private String crearCondicionesEspecialesConsultados(String tipo_usuario, String area,String autor,String doc_tipo,String usuario){
        String salida="";
        ArrayList condiciones = new ArrayList(5);
        if(tipo_usuario!=null){
            String temp;
            temp="(SELECT DISTINCT doc_id FROM usuario_consulta"
                    + "_documento NATURAL JOIN usuarios WHERE tipo_usuario="+
                    ((tipo_usuario.equals("Usuario Normal")) ? "'3'" : "'2'") +
                    ((usuario!=null) ? " AND username='"+usuario : "")+")";
            condiciones.add(temp);
        }
        if(area!=null){
            String temp;
            temp="(SELECT DISTINCT doc_id FROM documento_areas"
                    + "_computacion WHERE area_id='" + area +"')";
            condiciones.add(temp);
        }
        if(autor!=null){
            String temp;
            temp="(SELECT DISTINCT doc_id FROM documento_autor"
                    +" WHERE autor_correo='"+autor+"')";
            condiciones.add(temp);
        }
        if(doc_tipo!=null){
            String temp;
            temp="(SELECT DISTINCT doc_id FROM documentos WHERE "
                    +"tipo_documento='"+doc_tipo+"')";
            condiciones.add(temp);
        }
        if(!condiciones.isEmpty())
            salida+=" AND doc_id IN(";
        for(int i=0;i<condiciones.size();i++){
            salida+=(i!=(condiciones.size()-1)) ? (condiciones.get(i) + " INTERSECT ") : condiciones.get(i) + ")";
        }
        return salida;
    }
}
