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
    
    public void printResultSet(ResultSet salida) throws SQLException{
      ResultSetMetaData rs=salida.getMetaData();
      int Cols=rs.getColumnCount();
      while(salida.next()){
      for(int i=1; i<=Cols;i++){
          System.out.print(salida.getString(i)+"  ");
      }
        System.out.println();
      }
    }
    
    ///Para panel usuarios
    public void ConsultarListaUsuario(String dow, String dom, String month, String year, String[] franja, String[] desde, String[] Hasta, String tipo,
            String genero, String Estado, String area){
      
      String sql_consultar="Select username, nombres, apellidos, fecha_registro from usuarios where ";
     
      
      sql_consultar+=ConsultarDowUsuarios(dow);
      sql_consultar+=ConsultarDomUsuarios(dom);
      sql_consultar+=ConsultarMonthUsuarios(month);
      sql_consultar+=ConsultarYearUsuarios(year);
      sql_consultar+=ConsultarIntervaloUsuarios(desde,Hasta);
      sql_consultar+=";";
      
      System.out.println(sql_consultar);
      try {
            Connection conn = Fachada.conectar();
            java.sql.Statement sentencia = conn.createStatement();
            ResultSet salida = sentencia.executeQuery(sql_consultar);
            printResultSet(salida);
            conn.close();
      }        
        catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public String ConsultarDowUsuarios(String dow){
        String consultar="";
        if(dow != null){
            consultar="date_part('dow',fecha_registro)="+dow+" "; }
        return consultar;
    }
    public String ConsultarDomUsuarios(String dom){
        String consultar="";
        if(dom != null){
            consultar="date_part('day',fecha_registro)="+dom+" "; }
        return consultar;
    }
    public String ConsultarMonthUsuarios(String month){
        String consultar="";
        if(month != null){
            consultar="date_part('month',fecha_registro)="+month+" "; }
        return consultar;
    }
    public String ConsultarYearUsuarios(String year){
        String consultar="";
        if(year != null){
            consultar="date_part('year',fecha_registro)="+year+" "; }
        return consultar;
    }
    /*public String ConsultarFranjaUsuarios(String[] franja){
        String consultar="";
        if(franja != null){
            consultar="date_part('year',fecha_registro)="+franja+" "; }
        return consultar;
    }*/
    public String ConsultarIntervaloUsuarios(String[] desde, String[] Hasta){
        String consultar="";
        if(desde != null && Hasta != null){
            consultar="fecha_registro between '"+desde[0]+"-"+desde[1]+"-"+desde[2]+"' AND '"
                    +Hasta[0]+"-"+Hasta[1]+"-"+Hasta[2]+"' ";
        }
        return consultar;
    }
    
    
    /*
    public ResultSet consultarDocumentosPorArea(String area){
        return 1;
    }
    public ResultSet consultarUsuariosPorTipo(String tipo){
        return 1;
    }
    
    public ResultSet consultarUsuariosRegistradosPorMes(int mes){
        return 1;
    }
    public ResultSet consultarDocumentosMasConsultados(){
        return 1;
    }
    public ResultSet consultarDocumentosPorTipoUsuario(String tipo){
        return 1;
    }
    public ResultSet consultarDocumentosPorArea(ArrayList<String> areas){
        return 1;
    }
    public ResultSet consultarDocumentosPorFormato(String formato){
        return 1;
    }
    public ResultSet consultarDocumentoCatalogadoPorMes(int mes){
        return 1;
    }
    public ResultSet consultarDocumentoCatalogadoPorArea(String area){
        return 1;
    }
    public ResultSet consultarCatalogadoPorMesyArea(int mes, String area){
        return 1;
    }
    public ResultSet consultarDocumentosMasDescargados(){
        return 1;
    }
    public ResultSet consultarDocumentosMasDescargadosPorTipoUsuario(String tipo){
        return 1;
    }
    public ResultSet consultarDocumentosMasDescargadosPorArea(ArrayList<String> areas){
        return 1;
    }
    public ResultSet consultarUsuariosMayorAreaDeInteres(){
        return 1;
    }
    public ResultSet consultarFranjasHorariasMasUsuarios(int franja){
        return 1;
    }
    */
}