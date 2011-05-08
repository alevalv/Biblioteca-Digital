/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database1.accesoDatos;

import biblioteca.database1.beans.*;
import biblioteca.database1.fachada.Fachada;
import java.sql.*;

/**
 *
 * @author Eduardo
 */
public class DaoUsuario {

    Fachada fachada;

   public DaoUsuario(){
        fachada= new Fachada();
    }

     public int guardarUsuario(Usuario usuario){
        String sql_guardar;
        sql_guardar="INSERT INTO usuario(login, contrasena, pregunta_secreta, respuesta_secreta, nombres, apellidos, genero, fecha_nacimiento, nivel_escolaridad, vinculo_univalle, "
                + "perfil, fecha_registro,correo) VALUES ('" +
                usuario.getLogin() + "', '" +
                usuario.getContraseña() +  "', '" +
                usuario.getPreguntaSecreta() + "', '"  +
                usuario.getRespuestaSecreta() +"', '"  +
                usuario.getNombre()+ "', '" +
                usuario.getApellido() + "', '"  +
                usuario.getGenero()+ "', '"  +
                usuario.getFechaNacimiento()+ "', '"  +
                usuario.getEscolaridad()+ "', '"  +
                usuario.getVinculoUnivalle()+ "', '"  +
                usuario.getPerfil()+ "', '"  +
                usuario.getCorreo()+"', '"+
                usuario.getFechaRegistro() +"');";
        try{
            Connection conect= fachada.conectar();
            Statement sentencia = conect.createStatement();
            int numFilas = sentencia.executeUpdate(sql_guardar);
            System.out.println("se guardo exitosamente!!!!");
            conect.close();
            System.out.println("Conexion cerrada");
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }

    public Usuario consultarUsuario(String login){
        Usuario usuario= new Usuario();
        
        String sql_consultar;
        sql_consultar="SELECT login, contrasena, pregunta_secreta, respuesta_secreta, nombres, apellidos, genero, fecha_nacimiento, nivel_escolaridad, vinculo_univalle, "
                + "perfil, fecha_registro,estado,correo FROM usuario WHERE login= '" +login+ "';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultar);
            System.out.println("consultando en la bd");

            while(tabla.next()){
             usuario.setLogin( tabla.getString(1));
               usuario.setContraseña(tabla.getString(2));
               usuario.setPreguntaSecreta(tabla.getString(3));
               usuario.setRespuestaSecreta(tabla.getString(4));
               usuario.setNombre(tabla.getString(5));
               usuario.setApellido(tabla.getString(6));
               usuario.setGenero( tabla.getString(7));
               usuario.setFechaNacimiento(tabla.getString(8));
               usuario.setEscolaridad(tabla.getString(9));
               usuario.setVinculoUnivalle(tabla.getString(10));
               usuario.setPerfil(tabla.getString(11));
               usuario.setFechaRegistro(tabla.getString(12));
               usuario.setEstado(tabla.getString(13));
               usuario.setCorreo(tabla.getString(14));
              System.out.println("ok");
            }
            conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return usuario;
    }


    public int modificarUsuario(Usuario usuario)
    {
        String sql_modificar;
        sql_modificar="UPDATE usuario SET login= '"+usuario.getLogin()+
                "',contrasena= '"+usuario.getContraseña()+
                "', pregunta_secreta= '"+usuario.getPreguntaSecreta()+
                "', respuesta_secreta= '"+usuario.getRespuestaSecreta()+
                "', nombres= '"+usuario.getNombre()+
                "', apellidos= '"+usuario.getApellido()+
                "', genero= '"+usuario.getGenero() +
                "', fecha_nacimiento = '"+usuario.getFechaNacimiento()+
                "', nivel_escolaridad= '"+usuario.getEscolaridad()+
                "', vinculo_univalle= '"+usuario.getVinculoUnivalle()+
                "', perfil= '"+usuario.getPerfil()+
                "', fecha_registro= '"+usuario.getFechaRegistro()+
                "', correo= '"+usuario.getCorreo()+
                "' WHERE login= '"+usuario.getLogin()+"';";

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

    public int desactivarUsuario(String login)
    {
        String sql_desactivar;
        sql_desactivar="UPDATE usuario SET estado='inactivo' WHERE login = '"+login+"';";

        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_desactivar);
            System.out.println("se elimino exitosamente!!!!");
            conn.close();
            System.out.println("Conexion cerrada");
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }

        return -1;
    }


    public int agregarAreasComputacion(String login, String id_area)
    {
        String sql_guardar;
        sql_guardar="INSERT INTO usu_tiene_areainteres(login, id_area) VALUES ('" +
                login + "', '" + id_area +"');";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_guardar);
            System.out.println("se agrego exitosamente!!!!");
            conn.close();
            System.out.println("Conexion cerrada");
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }

        return -1;
    }

    public int eliminarAreasComputacion(String login, String id_area)
    {
        String sql_eliminarArea;
        sql_eliminarArea="DELETE FROM usu_tiene_areainteres  WHERE login= '"+login+"';";

        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_eliminarArea);
            System.out.println("se elimino exitosamente!!!!");
            conn.close();
            System.out.println("Conexion cerrada");
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }

        return -1;
    }

  
    

    public boolean AutenticarUsuario(String login, String contraseña,String perfil)
    {
        String passwordRecibido="";
        String estadoRecibido="";
        String perfilRecibido="";
        String sql_autenticar;
        sql_autenticar="SELECT contrasena,estado,perfil FROM usuario WHERE login= '"+login+"';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            System.out.println("se esta buscando si estas!!!!");
            ResultSet tabla = sentencia.executeQuery(sql_autenticar);
            while(tabla.next()){
                passwordRecibido=tabla.getString(1);
                estadoRecibido=tabla.getString(2);
                perfilRecibido=tabla.getString(3);

            }
             conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }

        if(contraseña.equals(passwordRecibido) && estadoRecibido.equals("activo") && perfil.equals(perfilRecibido))
        {
            System.out.println("SI estas en la BD");
            return true;

        }
        System.out.println("NO estas en la BD");
        return false;
    }


    public boolean verificarUsuarioDisponible(String login)
    {
        String loginRecibido= new String();
        String sql_verificarUsuario;
        sql_verificarUsuario="SELECT login FROM usuario WHERE login= '"+login+"';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            System.out.println("se esta buscando si estas disponible!!!!");
            ResultSet tabla = sentencia.executeQuery(sql_verificarUsuario);
            while(tabla.next()){
                loginRecibido=tabla.getString(1);
            }
             conn.close();
             System.out.println("Conexion cerrada");

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }

        if(login.equals(loginRecibido))
        {
            System.out.println("NO estas disponible");
            return false;

        }
        System.out.println("SI estas disponible");
        return true;
    }


}
