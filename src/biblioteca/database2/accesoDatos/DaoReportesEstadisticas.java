/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.accesoDatos;


import biblioteca.database2.fachada.Fachada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DaoReportesEstadisticas {
    Fachada Fachada;
    
    public DaoReportesEstadisticas(){
        Fachada = new Fachada();
    }
    
//    public void printResultSet(ResultSet salida) throws SQLException{
//      ResultSetMetaData rs=salida.getMetaData();
//      int Cols=rs.getColumnCount();
//      while(salida.next()){
//      for(int i=1; i<=Cols;i++){
//          System.out.print(salida.getString(i)+"  ");
//      }
//        System.out.println();
//      }
//    }
    
    ///Para panel usuarios
    public ResultSet ConsultarListaUsuario(String dow, String dom, String month, String year, String[] franja, String[] desde, String[] Hasta, String tipo,
            String genero, String Estado, String area){
      
      String sql_consultar="", inter=" intersect ";
      int cont=0;
      
      sql_consultar+=ConsultarDowUsuarios(dow);
      if(!ConsultarDomUsuarios(dom).isEmpty())  {
          cont++;
      sql_consultar+=ConsultarDomUsuarios(dom);}
      
      if(!ConsultarMonthUsuarios(month).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarMonthUsuarios(month);}
      
      if(!ConsultarYearUsuarios(year).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarYearUsuarios(year);}
      
      if(!ConsultarFranjaUsuarios(franja).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarFranjaUsuarios(franja);}
      
      if(!ConsultarIntervaloUsuarios(desde,Hasta).isEmpty())  {
         if(cont>0)  sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarIntervaloUsuarios(desde,Hasta);}
      
      if(!ConsultarTipoUsuarios(tipo).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarTipoUsuarios(tipo);}
      
       if(!ConsultarGeneroUsuarios(genero).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarGeneroUsuarios(genero);}
       
        if(!ConsultarEstadoUsuarios(Estado).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarEstadoUsuarios(Estado);}
        
        if(!ConsultarAreasUsuarios(area).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarAreasUsuarios(area);}
           
      if(cont>0) sql_consultar+=";";
      
      System.out.println(sql_consultar);
      try {
            Connection conn = Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet salida = sentencia.executeQuery(sql_consultar);
            //printResultSet(salida);
            conn.close();
            return salida;
      }        
        catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
      return null;
    }
    
    public String ConsultarDowUsuarios(String dow){
        String consultar="";
        if(dow != null){
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios where date_part('dow',fecha_registro)="+dow+" "; }
        return consultar;
    }
    public String ConsultarDomUsuarios(String dom){
        String consultar="";
        if(dom != null){
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios where date_part('day',fecha_registro)="+dom+" "; }
        return consultar;
    }
    public String ConsultarMonthUsuarios(String month){
        String consultar="";
        if(month != null){
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios where date_part('month',fecha_registro)="+month+" "; }
        return consultar;
    }
    public String ConsultarYearUsuarios(String year){
        String consultar="";
        if(year != null){
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios where date_part('year',fecha_registro)="+year+" "; }
        return consultar;
    }
    public String ConsultarTipoUsuarios(String tipo){
        String consultar="";
        if(tipo != null){
            if(tipo.equals("1"))
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios where tipo_usuario='3' ";
            else  consultar="tipo_usuario='"+tipo+"' ";
        }
        return consultar;
    }
    public String ConsultarGeneroUsuarios(String genero){
        String consultar="";
        if(genero != null){
            if(genero.equals("1"))
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios where genero='M' ";
            else  consultar="Select username, nombres, apellidos, fecha_registro from usuarios where genero='F' ";
        }
        return consultar;
    }
    public String ConsultarEstadoUsuarios(String Estado){
        String consultar="";
        if(Estado != null){
            if(Estado.equals("1"))
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios where activo='t' ";
            else  consultar="Select username, nombres, apellidos, fecha_registro from usuarios where activo='f' ";
        }
        return consultar;
    }
    public String ConsultarFranjaUsuarios(String[] franja){
        String consultar="";
        if(franja != null){
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios where date_part('hour',fecha_registro)>="+franja[0]+" and date_part('hour',fecha_registro)<="+franja[1]+" "; }
        return consultar;
    }
    public String ConsultarIntervaloUsuarios(String[] desde, String[] Hasta){
        String consultar="";
        if(desde != null && Hasta != null){
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios where fecha_registro between '"+desde[0]+"-"+desde[1]+"-"+desde[2]+"' AND '"
                    +Hasta[0]+"-"+Hasta[1]+"-"+Hasta[2]+"' ";
        }
        return consultar;
    }
    public String ConsultarAreasUsuarios(String id_area){
        String consultar="";
        if(id_area != null){
            consultar="Select username, nombres, apellidos, fecha_registro from usuarios natural join usuario_areas_computacion where area_id='"+id_area+"' ";}
        return consultar;
    }

    public ResultSet ConsultarListaDocumentosExistentes(String area, String autor, String tipo, String editorial, String idioma, String estado, String[] desde, String[] hasta) {
     String sql_consultar="", inter=" intersect ";
      int cont=0;
      
      if(!ConsultarAreasDocumentosExistentes(area).isEmpty())  {
          cont++;
      sql_consultar+=ConsultarAreasDocumentosExistentes(area);}
           
      if(!ConsultarAutorDocumentosExistentes(autor).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarAutorDocumentosExistentes(autor);}
       
      if(!ConsultarTipoDocumentosExistentes(tipo).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarTipoDocumentosExistentes(tipo);}
       
      if(!ConsultarEditorialDocumentosExistentes(editorial).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarEditorialDocumentosExistentes(editorial);}
      
      if(!ConsultarIdiomaDocumentosExistentes(idioma).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarIdiomaDocumentosExistentes(idioma);}
      
      if(!ConsultarEstadoDocumentosExistentes(estado).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarEstadoDocumentosExistentes(estado);}
     
      
      if(!ConsultarIntervaloDocumentosExistentes(desde,hasta).isEmpty())  {
          if(cont>0) sql_consultar+=inter;
          cont++;
      sql_consultar+=ConsultarIntervaloDocumentosExistentes(desde,hasta);}
      
      if(cont>0) sql_consultar+=";";
      
      System.out.println(sql_consultar);
      try {
            Connection conn = Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet salida = sentencia.executeQuery(sql_consultar);
            //printResultSet(salida);
            conn.close();
            return salida;
      }        
        catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
       return null;
    }
    
    public String ConsultarAreasDocumentosExistentes(String id_area){
        String consultar="";
        if(id_area != null){
            consultar="Select doc_id, titulo_principal from documentos natural join documento_areas_computacion where area_id='"+id_area+"' ";}
        return consultar;
    }
    public String ConsultarAutorDocumentosExistentes(String correo){
        String consultar="";
        if(correo != null){
            consultar="Select doc_id, titulo_principal from documentos natural join documento_autor where autor_correo='"+correo+"' ";}
        return consultar;
    }
   public String ConsultarTipoDocumentosExistentes(String tipo){
        String consultar="";
        if(tipo != null){
            consultar="Select doc_id, titulo_principal from documentos where tipo_documento='"+tipo+"' ";}
        return consultar;
    }
   public String ConsultarEditorialDocumentosExistentes(String editorial){
        String consultar="";
        if(editorial != null){
            consultar="Select doc_id, titulo_principal from documentos where editorial ilike '"+editorial+"' ";}
        return consultar;
    }
   public String ConsultarIdiomaDocumentosExistentes(String idioma){
        String consultar="";
        if(idioma != null){
            consultar="Select doc_id, titulo_principal from documentos where idioma='"+idioma+"' ";}
        return consultar;
    }
   public String ConsultarEstadoDocumentosExistentes(String estado){
        String consultar="";
        if(estado != null){
            if(estado.equals("1"))
            consultar="Select doc_id, titulo_principal from documentos where activo='t' ";
            else  consultar="Select doc_id, titulo_principal from documentoswhere activo='f' ";
        }
        return consultar;
    }
   public String ConsultarIntervaloDocumentosExistentes(String[] desde, String[] Hasta){
        String consultar="";
        if(desde != null && Hasta != null){
            consultar="Select doc_id, titulo_principal from documentos where fecha_publicacion between '"+desde[0]+"-"+desde[1]+"-"+desde[2]+"' AND '"
                    +Hasta[0]+"-"+Hasta[1]+"-"+Hasta[2]+"' ";
        }
        return consultar;
    }
}