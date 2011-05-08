/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database1.accesoDatos;

import biblioteca.database1.beans.*;
import biblioteca.database1.fachada.Fachada;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Eduardo
 */
public class DaoMaterial {

     Fachada fachada;

   public DaoMaterial(){
        fachada= new Fachada();
    }

//     public int guardarDocumento(Documento doc){
//        String sql_guardar;
//        sql_guardar="INSERT INTO material(id_material,login, nombre_tipo, descripcion_tipo, editorial, idioma,derechos_autor,resumen,titulo_principal,titulo_secundario,fecha_creacion,fecha_publicacion,fecha_catalogacion,tamano,resolucion,formato,software_adecuado) VALUES ('" +
//                doc.getID_documento() + "', '"  + doc.getLogin() +  "', '"   + doc.getTipoMaterial() +  "', '" +
//                   doc.getDescripcionTipo() + "', '"  + doc.getEditorial()+ "', '" +
//                   doc.getIdioma() + "', '"  +
//                   doc.getDerechosAutor() + "', '"+
//                   doc.getResumen() + "', '"+
//                   doc.getTituloPrincipal() + "', '" +
//                   doc.getTituloSecundario() + "', '" +
//                   doc.getFechaCreacion() + "', '" +
//                   doc.getFechaPublicacion() + "', '"+
//                   doc.getFechaCatalogacion() + "', '"+
//                   doc.getTamaño() + "', '"+
//                   doc.getResolucion() + "', '"+
//                   doc.getFormato() + "', '"+
//                   doc.getSoftwareAdecuado() + "', '"
//                   +"');";
//        try{
//            Connection conect= fachada.conectar();
//            Statement sentencia = conect.createStatement();
//            int numFilas = sentencia.executeUpdate(sql_guardar);
//            System.out.println("se guardo exitosamente!!!!");
//            conect.close();
//            System.out.println("Conexion cerrada");
//            return numFilas;
//        }
//        catch(SQLException e){ System.out.println(e); }
//        catch(Exception e){ System.out.println(e); }
//        return -1;
//    }

    public Documento consultarDocumento(String id_doc){
        Documento doc= new Documento();
        String sql_consultar;
        sql_consultar="SELECT id_material,login,nombre_tipo,descripcion_tipo,editorial,idioma,derechos_autor,resumen,titulo_principal,titulo_secundario,fecha_creacion,fecha_publicacion,fecha_catalogacion,tamano,resolucion,formato,software_adecuado FROM material WHERE id_material= '" +id_doc+ "';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultar);
            System.out.println("consultando en la bd");

            while(tabla.next()){
              doc.setID_documento(tabla.getString(1));
              doc.setLogin(tabla.getString(2));
              doc.setTipoMaterial(tabla.getString(3));
              doc.setDescripcionTipo(tabla.getString(4));
              doc.setEditorial(tabla.getString(5));
              doc.setIdioma(tabla.getString(6));
              doc.setDerechosAutor(tabla.getString(7));
              doc.setResumen(tabla.getString(8));
              doc.setTituloPrincipal(tabla.getString(9));
              doc.setTituloSecundario(tabla.getString(10));
              doc.setFechaCreacion(tabla.getString(11));
              doc.setFechaPublicacion(tabla.getString(12));
              doc.setFechaCatalogacion(tabla.getString(13));
              doc.setTamaño(tabla.getString(14));
              doc.setResolucion(tabla.getString(15));
              doc.setFormato(tabla.getString(16));
              doc.setSoftwareAdecuado(tabla.getString(17));
              System.out.println("ok");
            }
            conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return doc;
    }


    public int modificarDocumento(Documento documento)
    {
        String sql_modificar;
        sql_modificar="UPDATE material SET id_material = '"+documento.getID_documento()+ 
                "', login = '" +documento.getLogin()+
                "',nombre_tipo= '"  +documento.getTipoMaterial()+
                "', descripcion_tipo = '"+documento.getDescripcionTipo()+
                "', editorial  = '"+documento.getEditorial()+
                "', idioma  = '"+documento.getIdioma()+
                "', derechos_autor  = '"+documento.getDerechosAutor()+
                "', resumen  = '"+documento.getResumen()+
                "', titulo_principal = '"+documento.getTituloPrincipal()+
                "', titulo_secundario = '"+documento.getTituloSecundario()+
                "', fecha_creacion  = '"+documento.getFechaCreacion()+
                "', fecha_publicacion  = '"+documento.getFechaPublicacion()+
                "', fecha_catalogacion = '"+documento.getFechaCatalogacion()+
                "', tamano = '"+documento.getTamaño()+
                "', resolucion = '"+documento.getResolucion()+
                "',formato = '"+documento.getFormato()+
                "', software_adecuado = '"+documento.getSoftwareAdecuado()+
                "' WHERE id_material = '"+documento.getID_documento()+"';";

        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_modificar);
            System.out.println("se modifico exitosamente!!!!");
            conn.close();
            System.out.println("Conexion cerrada");
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }

        return -1;
    }

//    public int eliminarDocumneto(String id_doc)
//    {
//        String sql_eliminar;
//        sql_eliminar="DELETE FROM documento WHERE id_material = '"+id_doc+"'";
//
//        try{
//            Connection conn= fachada.conectar();
//            Statement sentencia = conn.createStatement();
//            int numFilas = sentencia.executeUpdate(sql_eliminar);
//            System.out.println("se elimino exitosamente!!!!");
//            conn.close();
//            System.out.println("Conexion cerrada");
//            return numFilas;
//        }
//        catch(SQLException e){ System.out.println(e); }
//
//        return -1;
//    }

      public int insertarAreas(ArrayList<String> areas, String id_documento)
    {
        String sql_insertarAreas;
        for(int i=0;i<areas.size();i++)
        {
            sql_insertarAreas="INSERT INTO mat_pertenece_area(id_material, id_area) VALUES ('" +
                    id_documento + "', '" + areas.get(i)+"')";
            try{
                Connection conn= fachada.conectar();
                Statement sentencia = conn.createStatement();
                int numFilas = sentencia.executeUpdate(sql_insertarAreas);
                System.out.println("se guardo exitosamente!!!!");
                conn.close();
                System.out.println("Conexion cerrada");

            }
            catch(SQLException e){ System.out.println(e); }
        }

        return 1;
    }

    public int insertarPalabrasClaves(ArrayList<String> PC, String id_documento)
    {
        String sql_insertarPalabrasClaves;
        for(int i=0;i<PC.size();i++)
        {
            sql_insertarPalabrasClaves="INSERT INTO mat_posee_palclave(id_material, nombre_palclave) VALUES ('" +
                    id_documento + "', '" + PC.get(i)+"');";
            try{
                Connection conn= fachada.conectar();
                Statement sentencia = conn.createStatement();
                int numFilas = sentencia.executeUpdate(sql_insertarPalabrasClaves);
                System.out.println("se guardo exitosamente!!!!");
                conn.close();
                System.out.println("Conexion cerrada");

            }
            catch(SQLException e){ System.out.println(e); }
        }

        return 1;

    }

    public int insertarAutor(String correo_autor, String id_documento)
    {
        String sql_insertarAutor;
        sql_insertarAutor="INSERT INTO mat_tiene_autor (id_material, correo_autor) VALUES ('" +
                id_documento + "', '" + correo_autor+"')";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_insertarAutor);
            System.out.println("se guardo exitosamente!!!!");
            conn.close();
            System.out.println("Conexion cerrada");
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }

        return -1;

    }

    public int eliminarAreas(ArrayList<String> areas, String id_documento)
    {
        String sql_eliminarAreas;
        for(int i=0; i< areas.size();i++)
        {
            sql_eliminarAreas="DELETE FROM mat_pertenece_area  WHERE id_material = '"+id_documento+"' AND id_area = '"+areas.get(i)+"';";//rebisar no se si esta malo o bno

            try{
                Connection conn= fachada.conectar();
                Statement sentencia = conn.createStatement();
                int numFilas = sentencia.executeUpdate(sql_eliminarAreas);
                System.out.println("Se esta eliminando areas");
                conn.close();
                System.out.println("Conexion cerrada");
            }
            catch(SQLException e){ System.out.println(e); }

        }
        return -1;
    }

    public int eliminarPalabrasClaves(ArrayList<String> PC, String id_documento)
    {
        String sql_eliminarPalabrasClaves;
        for(int i=0; i< PC.size();i++)
        {
            sql_eliminarPalabrasClaves="DELETE FROM mat_posee_palclave WHERE id_material = '"+id_documento+"' AND nombre_palclave = '"+PC.get(i)+"';";//rebisar no se si esta malo o bno

            try{
                Connection conn= fachada.conectar();
                Statement sentencia = conn.createStatement();
                int numFilas = sentencia.executeUpdate(sql_eliminarPalabrasClaves);
                System.out.println("Se esta eliminando palabras clave");
                conn.close();
                System.out.println("Conexion cerrada");
            }
            catch(SQLException e){ System.out.println(e); }

        }

        return -1;

    }

    public int eliminarAutor(String email, String id_documento)
    {
        String sql_eliminarAutor;
        sql_eliminarAutor="DELETE FROM mat_tiene_autor WHERE id_material = '"+id_documento+"' AND correo_autor = '"+email+"';";//rebisar no se si esta malo o bno

        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_eliminarAutor);
            conn.close();
            System.out.println("Conexion cerrada");
        }
        catch(SQLException e){ System.out.println(e); }

        return -1;
    }

    public boolean comprobarExistenciaDocumento(String id_doc)
    {
        String id_docRecibido= new String();
        String sql_comprobar;
        sql_comprobar="SELECT id_material FROM material WHERE id_material= '"+id_doc+"';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            System.out.println("se esta buscando si esta disponible!!!!");
            ResultSet tabla = sentencia.executeQuery(sql_comprobar);
            while(tabla.next()){
                id_docRecibido=tabla.getString(1);
            }
             conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }

        if(id_doc.equals(id_docRecibido))
        {
            System.out.println("NO esta disponible");
            return false;

        }
        System.out.println("SI esta disponible");
        return true;
    }

    public int descargaDocumento(String usuario, Documento documento)
    {
        return -1;
    }

     public int catalogaDocumento(String login, Documento documento)
    {
        String sql_catalogar;
        sql_catalogar="INSERT INTO material(id_material, login, nombre_tipo, descripcion_tipo, editorial, idioma, derechos_autor, resumen, titulo_principal, titulo_secundario, fecha_creacion , "
                + "fecha_publicacion, fecha_catalogacion, tamano, resolucion, formato, software_adecuado) VALUES ('" +
                documento.getID_documento() + "', '"+ 
                login+ "', '" +
                documento.getTipoMaterial() +  "', '" +
                 documento.getDescripcionTipo() + "', '"  +
                 documento.getEditorial() +"', '"+
                 documento.getIdioma()+"', '"+
                 documento.getDerechosAutor() +"', '"  +
                 documento.getResumen()+ "', '" +
                 documento.getTituloPrincipal() +"', '"  +
                 documento.getTituloSecundario()+ "', '"  +
                 documento.getFechaCreacion()+ "', '"  +
                 documento.getFechaPublicacion()+ "', '"  +
                 documento.getFechaCatalogacion()+ "', '"  +
                 documento.getTamaño()+ "', '"  +
                 documento.getResolucion() +"', '"+
                 documento.getFormato() +"', '"+
                 documento.getSoftwareAdecuado() +"');";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_catalogar);
            System.out.println("se esta catalogando");
            conn.close();
            System.out.println("Conexion cerrada");
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }

        return -1;

    }

}