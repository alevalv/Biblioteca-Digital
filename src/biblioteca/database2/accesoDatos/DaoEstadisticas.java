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
    
    /**
     * Genera el sql para obtener la lista de los documento más descargados, según los parametros
     * seleccionados por el usuario.
     * <br>Esta función se apoya en crearCondicionesEspecialesDescargados para 
     * generar consultas aún más especificas usando una subconsulta
     * @param dow Dia del año seleccionado
     * @param dom Dia del mes seleccionado
     * @param month Mes seleccionado
     * @param year Año seleccionado
     * @param tipo_usuario Tipo de usuario selccionado
     * @param franja Franja horaria seleccionada, es un String[] con dos fechas en sql
     * @param desde fecha de inicio de la franja de descargas
     * @param hasta fecha de fin de la franja de descargas
     * @param area id del area seleccionada por el usuario
     * @param autor correo del autor seleccionado por el usuario
     * @param doc_tipo Tipo de documento seleccionado por el usuario
     * @param usuario El username especifico que el usuario selecciona
     * @param todos Indica si el usuario quiere una consulta general (respecto a fechas) o una consulta más especifica
     * @return ResultSet con el resultado de la consulta
     */
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
    
    /**
     * Crea una subconsulta que se agrega a la consulta creada en documentosMasDescargados
     * en el caso de que sea necesario para el usuario
     * @param tipo_usuario String con el tipo de usuario selccionado
     * @param area String con el id area seleccionada
     * @param autor String con el autor del documento
     * @param doc_tipo String con el tipo de documento
     * @param usuario String con el nombre de usuario a consultar
     * @return String con la subconsulta para ser agregada a la consulta principal
     */
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
    
    /**
     * Genera el sql para obtener la lista de los documento más consultados, según los parametros
     * seleccionados por el usuario.
     * <br>Esta función se apoya en crearCondicionesEspecialesConsultados para 
     * generar consultas aún más especificas usando una subconsulta
     * @param dow Dia del año seleccionado
     * @param dom Dia del mes seleccionado
     * @param month Mes seleccionado
     * @param year Año seleccionado
     * @param tipo_usuario Tipo de usuario selccionado
     * @param franja Franja horaria seleccionada, es un String[] con dos fechas en sql
     * @param desde fecha de inicio de la franja de descargas
     * @param hasta fecha de fin de la franja de descargas
     * @param area id del area seleccionada por el usuario
     * @param autor correo del autor seleccionado por el usuario
     * @param doc_tipo Tipo de documento seleccionado por el usuario
     * @param usuario El username especifico que el usuario selecciona
     * @param todos Indica si el usuario quiere una consulta general (respecto a fechas) o una consulta más especifica
     * @return ResultSet con el resultado de la consulta
     */
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
                    + "titulo_principal as Titulo, count(*) as Consultas FROM usuario_consulta_documento NATURAL JOIN "
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
        sql_descargados+=" GROUP BY Identificacion, Titulo ORDER BY  Consultas DESC; ";
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
    
    /**
     * Crea una subconsulta que se agrega a la consulta creada en documentosMasConsultados
     * en el caso de que sea necesario para el usuario
     * @param tipo_usuario String con el tipo de usuario selccionado
     * @param area String con el id area seleccionada
     * @param autor String con el autor del documento
     * @param doc_tipo String con el tipo de documento
     * @param usuario String con el nombre de usuario a consultar
     * @return String con la subconsulta para ser agregada a la consulta principal
     */
    private String crearCondicionesEspecialesConsultados(String tipo_usuario, String area,String autor,String doc_tipo,String usuario){
        String salida="";
        ArrayList condiciones = new ArrayList(5);
        if(tipo_usuario!=null){
            String temp;
            temp="(SELECT DISTINCT doc_id FROM usuario_consulta"
                    + "_documento NATURAL JOIN usuarios WHERE tipo_usuario="+
                    ((tipo_usuario.equals("Usuario Normal")) ? "'3'" : "'2'") +
                    ((usuario!=null) ? " AND username='"+usuario+"'" : "")+")";
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
    
    
    /**
     * Consulta la cantidad de usuarios registrados por el Day of The Week,
     * retorna un ArrayList de String con el nombre del día y la cantidad de
     * usuarios registrados por cada día de la semana, son 16 elementos retornados
     * de los cuales los dos primeros son los nombres de las columnas
     * @return ArrayList de String con los datos de usuarios registrados
     */
    public ArrayList<String> consultarUsuariosRegistradosPorDoW(){
        final String[] dias = {"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
        final String consulta_base="SELECT count(*) FROM usuarios WHERE date_part('dow', fecha_registro) = '0";
        ArrayList<String> salida = new ArrayList<String>(16);
        salida.add("Días");
        salida.add("Cantidad");
        for(int i=0;i<=6;i++){
            try {
                String sql=consulta_base+i+"';";
                Connection conn = Fachada.conectar();
                java.sql.Statement sentencia = conn.createStatement();
                ResultSet tabla = sentencia.executeQuery(sql);
                salida.add(dias[i]);
                tabla.next();
                salida.add(tabla.getString(1));
                conn.close();
            }
            catch (SQLException e) {
                System.err.println(e);
            } 
            catch (Exception e) {
                System.err.println(e);
            }
        }
        return salida;
    }
    
    /**
     * Consulta la cantidad de usuarios registrados por el Day of The Month,
     * retorna un ArrayList de String con el nombre del día y la cantidad de
     * usuarios registrados por cada día de la semana, son 64 elementos retornados
     * de los cuales los dos primeros son los nombres de las columnas
     * @return ArrayList de String con los datos de usuarios registrados
     */
    public ArrayList<String> consultarUsuariosRegistradosPorDoM(){
        final String consulta_base="SELECT count(*) FROM usuarios WHERE date_part('day', fecha_registro) = '";
        ArrayList<String> salida = new ArrayList<String>(64);
        salida.add("Día del mes");
        salida.add("Cantidad");
        for(int i=1;i<=31;i++){
            try {
                String sql=consulta_base+i+"';";
                Connection conn = Fachada.conectar();
                java.sql.Statement sentencia = conn.createStatement();
                ResultSet tabla = sentencia.executeQuery(sql);
                salida.add("Día "+i);
                tabla.next();
                salida.add(tabla.getString(1));
                conn.close();
            }
            catch (SQLException e) {
                System.err.println(e);
            } 
            catch (Exception e) {
                System.err.println(e);
            }
        }
        return salida;
    }
    
    /**
     * Consulta la cantidad de usuarios registrados por el Mes,
     * retorna un ArrayList de String con el nombre del día y la cantidad de
     * usuarios registrados por cada día de la semana, son 26 elementos retornados
     * @return ArrayList de String con los datos de usuarios registrados
     */
    public ArrayList<String> consultarUsuariosRegistradosPorMes(){
        final String[] dias = {"Enero", "Febrero", "Marzo","Abril","Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Nombiembre", "Diciembre"};
        final String consulta_base="SELECT count(*) FROM usuarios WHERE date_part('month', fecha_registro) = '";
        ArrayList<String> salida = new ArrayList<String>(26);
        salida.add("Mes");
        salida.add("Cantidad");
        for(int i=1;i<=12;i++){
            try {
                String sql=consulta_base+i+"';";
                Connection conn = Fachada.conectar();
                java.sql.Statement sentencia = conn.createStatement();
                ResultSet tabla = sentencia.executeQuery(sql);
                salida.add(dias[i-1]);
                tabla.next();
                salida.add(tabla.getString(1));
                conn.close();
            }
            catch (SQLException e) {
                System.err.println(e);
            } 
            catch (Exception e) {
                System.err.println(e);
            }
        }
        return salida;
    }
    
    /**
     * Consulta la cantidad de usuarios registrados según el parametro dado
     * @param Year String con el año a consultar
     * @return ArrayList de String con dos elementos, el año y el conteo
     */
    public ArrayList<String> consultarUsuariosRegistradosPorYear(String Year){
        ArrayList<String> salida= new ArrayList<String>(2);
        final String sql="SELECT count(*) FROM usuarios WHERE date_part('year', fecha_registro) = '"+Year+"';";
        try {
            Connection conn = Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql);
            salida.add("Año: "+Year);
            tabla.next();
            salida.add(tabla.getString(1));
            conn.close();
        }
        catch (SQLException e) {
            System.err.println(e);
        } 
        catch (Exception e) {
            System.err.println(e);
        }
        return salida;
    }
    
    /**
     * Consulta la cantidad de usuarios registrados en una franja horaria dada,
     * retorna un ArrayList de String con dos elementos, la franja y el resultado
     * @param desde String con el inicio de la franja horaria
     * @param hasta String con el final de la franja horaria
     * @return ArrayList de String con los resultados
     */
    public ArrayList<String> consultarUsuariosRegistradosPorFranja(String desde, String hasta){
        final String sql="SELECT count(*) FROM usuarios WHERE date_part('hour',fecha_registro)>="+desde+" and date_part('hour',fecha_registro)<="+hasta+" ";
        System.out.println(sql);
        ArrayList<String> salida= new ArrayList<String>(2);
        try {
            Connection conn = Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql);
            salida.add("Franja: "+desde+" - "+hasta);
            tabla.next();
            salida.add(tabla.getString(1));
            conn.close();
        }
        catch (SQLException e) {
            System.err.println(e);
        } 
        catch (Exception e) {
            System.err.println(e);
        }
        return salida;
    }
    
    public ArrayList<String> consultarUsuariosRegistradosPorIntervalo(String desde, String hasta){
        final String sql="SELECT count(*) FROM usuarios WHERE fecha_registro between '"+desde+"' and '"+hasta+"';";
        System.out.println(sql);
        ArrayList<String> salida= new ArrayList<String>(2);
        try {
            Connection conn = Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql);
            salida.add("Intervalo: "+desde+" - "+hasta);
            tabla.next();
            salida.add(tabla.getString(1));
            conn.close();
        }
        catch (SQLException e) {
            System.err.println(e);
        } 
        catch (Exception e) {
            System.err.println(e);
        }
        return salida;
    }

    
    public void ConsultarDocumentosCatalogados(boolean dow, boolean dom, boolean month, String year, String[] franja, String[] desde, String[] Hasta, boolean area, boolean autor, boolean doc_tipo, boolean usuario) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
  
    public ArrayList<String> consultarDocumentosCatalogadosPorDoW(){
        final String[] dias = {"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
        final String consulta_base="SELECT count(*) FROM documentos WHERE date_part('dow', fecha_catalogacion) = '0";
        ArrayList<String> salida = new ArrayList<String>(16);
        salida.add("Días");
        salida.add("Cantidad");
        for(int i=0;i<=6;i++){
            try {
                String sql=consulta_base+i+"';";
                Connection conn = Fachada.conectar();
                java.sql.Statement sentencia = conn.createStatement();
                ResultSet tabla = sentencia.executeQuery(sql);
                salida.add(dias[i]);
                tabla.next();
                salida.add(tabla.getString(1));
                conn.close();
            }
            catch (SQLException e) {
                System.err.println(e);
            } 
            catch (Exception e) {
                System.err.println(e);
            }
        }
        return salida;
    }
    
    public ArrayList<String> consultarDocumentosCatalogadosPorDoM(){
        final String consulta_base="SELECT count(*) FROM documentos WHERE date_part('day', fecha_catalogacion) = '";
        ArrayList<String> salida = new ArrayList<String>(64);
        salida.add("Día del mes");
        salida.add("Cantidad");
        for(int i=1;i<=31;i++){
            try {
                String sql=consulta_base+i+"';";
                Connection conn = Fachada.conectar();
                java.sql.Statement sentencia = conn.createStatement();
                ResultSet tabla = sentencia.executeQuery(sql);
                salida.add("Día "+i);
                tabla.next();
                salida.add(tabla.getString(1));
                conn.close();
            }
            catch (SQLException e) {
                System.err.println(e);
            } 
            catch (Exception e) {
                System.err.println(e);
            }
        }
        return salida;
    }
    
    public ArrayList<String> consultarDocumentosCatalogadosPorMes(){
        final String[] dias = {"Enero", "Febrero", "Marzo","Abril","Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Nombiembre", "Diciembre"};
        final String consulta_base="SELECT count(*) FROM documentos WHERE date_part('month', fecha_catalogacion) = '";
        ArrayList<String> salida = new ArrayList<String>(26);
        salida.add("Mes");
        salida.add("Cantidad");
        for(int i=1;i<=12;i++){
            try {
                String sql=consulta_base+i+"';";
                Connection conn = Fachada.conectar();
                java.sql.Statement sentencia = conn.createStatement();
                ResultSet tabla = sentencia.executeQuery(sql);
                salida.add(dias[i-1]);
                tabla.next();
                salida.add(tabla.getString(1));
                conn.close();
            }
            catch (SQLException e) {
                System.err.println(e);
            } 
            catch (Exception e) {
                System.err.println(e);
            }
        }
        return salida;
    }
    
    public ArrayList<String> consultarDocumentosCatalogadosPorYear(String Year){
        ArrayList<String> salida= new ArrayList<String>(2);
        final String sql="SELECT count(*) FROM documentos WHERE date_part('year', fecha_catalogacion) = '"+Year+"';";
        try {
            Connection conn = Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql);
            salida.add("Año: "+Year);
            tabla.next();
            salida.add(tabla.getString(1));
            conn.close();
        }
        catch (SQLException e) {
            System.err.println(e);
        } 
        catch (Exception e) {
            System.err.println(e);
        }
        return salida;
    }
    
    public ArrayList<String> consultarDocumentosCatalogadosPorFranja(String desde, String hasta){
        final String sql="SELECT count(*) FROM documentos WHERE date_part('hour',fecha_catalogacion)>="+desde+" and date_part('hour',fecha_catalogacion)<="+hasta+" ";
        System.out.println(sql);
        ArrayList<String> salida= new ArrayList<String>(2);
        try {
            Connection conn = Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql);
            salida.add("Franja: "+desde+" - "+hasta);
            tabla.next();
            salida.add(tabla.getString(1));
            conn.close();
        }
        catch (SQLException e) {
            System.err.println(e);
        } 
        catch (Exception e) {
            System.err.println(e);
        }
        return salida;
    }
    
    public ArrayList<String> consultarDocumentosCatalogadosPorIntervalo(String desde, String hasta){
        final String sql="SELECT count(*) FROM documentos WHERE fecha_catalogacion between '"+desde+"' and '"+hasta+"';";
        System.out.println(sql);
        ArrayList<String> salida= new ArrayList<String>(2);
        try {
            Connection conn = Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql);
            salida.add("Intervalo: "+desde+" - "+hasta);
            tabla.next();
            salida.add(tabla.getString(1));
            conn.close();
        }
        catch (SQLException e) {
            System.err.println(e);
        } 
        catch (Exception e) {
            System.err.println(e);
        }
        return salida;
    }
    
    public ResultSet consultarDocumentosCatalogadosPorArea(){
       try {
                String sql="SELECT nombre AS Nombre_Area, count(doc_id) AS Cantidad_de_Documentos_Catalogados FROM documento_areas_computacion NATURAL JOIN areas_computacion GROUP BY nombre ORDER BY Cantidad_de_Documentos_Catalogados DESC;";
                Connection conn = Fachada.conectar();
                java.sql.Statement sentencia = conn.createStatement();
                ResultSet tabla = sentencia.executeQuery(sql);
                conn.close();
                return tabla;
            }
            catch (SQLException e) {
                System.err.println(e);
            } 
            catch (Exception e) {
                System.err.println(e);
            }
        return null;   
     }
    
   public ResultSet consultarDocumentosCatalogadosPorAutor(){
       try {
                String sql="SELECT nombre AS Nombre_Autor, count(doc_id) AS Cantidad_de_Documentos_Catalogados FROM documento_autor "
                        + "NATURAL JOIN autor GROUP BY nombre ORDER BY Cantidad_de_Documentos_Catalogados DESC;";
                Connection conn = Fachada.conectar();
                java.sql.Statement sentencia = conn.createStatement();
                ResultSet tabla = sentencia.executeQuery(sql);
                conn.close();
                return tabla;
            }
            catch (SQLException e) {
                System.err.println(e);
            } 
            catch (Exception e) {
                System.err.println(e);
            }
        return null;   
     }
     
  public ResultSet consultarDocumentosCatalogadosPorPalabraClave(){
       try {
                String sql="SELECT nombre AS Palabra_Clave, count(doc_id) AS Cantidad_de_Documentos_Catalogados FROM "
                        + "documento_palabras_clave NATURAL JOIN palabras_clave GROUP BY nombre ORDER BY Cantidad_de_Documentos_Catalogados DESC;";
                Connection conn = Fachada.conectar();
                java.sql.Statement sentencia = conn.createStatement();
                ResultSet tabla = sentencia.executeQuery(sql);
                conn.close();
                return tabla;
            }
            catch (SQLException e) {
                System.err.println(e);
            } 
            catch (Exception e) {
                System.err.println(e);
            }
        return null;   
     }
      
 public ResultSet consultarDocumentosCatalogadosPorTipoMaterial(){
       try {
                String sql="SELECT tipo_material.tipo_documento AS Tipo_Material, count(doc_id) AS Cantidad_de_Documentos_Catalogados FROM documentos INNER "
                        + "JOIN tipo_material ON documentos.tipo_documento=tipo_material.tipo_documento GROUP BY tipo_material.tipo_documento ORDER BY Cantidad_de_Documentos_Catalogados DESC;";
                Connection conn = Fachada.conectar();
                java.sql.Statement sentencia = conn.createStatement();
                ResultSet tabla = sentencia.executeQuery(sql);
                conn.close();
                return tabla;
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
