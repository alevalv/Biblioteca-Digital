/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.accesoDatos;

import biblioteca.database2.beans.*;
import biblioteca.database2.fachada.Fachada;
import java.sql.*;


public class DaoUsuario {

    Fachada fachada;

   public DaoUsuario(){
        fachada= new Fachada();
    }

     public int guardarUsuario(Usuario usuario){
        
        String sql_guardar;
        sql_guardar="INSERT INTO usuarios(username, nombres,  apellidos, password, pregunta_secreta, respuesta_secreta, vinculo_con_univalle, tipo_usuario, correo_electronico, nivel_escolaridad, genero, "
                + "fecha_nacimiento, fecha_registro) VALUES ('" +
                usuario.getLogin() + "', '" +
                usuario.getNombre()+ "', '" +
                usuario.getApellido() + "', '"  +
                usuario.getContraseña() +  "', '" +
                usuario.getPreguntaSecreta() + "', '"  +
                usuario.getRespuestaSecreta() +"', '"  +
                usuario.getVinculoUnivalle()+ "', '"  +
                usuario.getPerfil()+ "', '"  +
                usuario.getCorreoElectronico()+"', '" +
                usuario.getEscolaridad()+ "', '"  +
                usuario.getGenero()+ "', '"  +
                usuario.getFechaNacimiento()+ "', '"  +
                usuario.getFechaRegistro()+"');";

        try{
            Connection conect= fachada.conectar();
            Statement sentencia = conect.createStatement();
            int numFilas = sentencia.executeUpdate(sql_guardar);
            conect.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println("SQL EXception"); }
        catch(Exception e){ System.out.println(e); }
        return -1;
    }

    public Usuario consultarUsuario(String login){
        Usuario usuario= new Usuario();
        
        String sql_consultar;
        sql_consultar="SELECT username, nombres,  apellidos, password, pregunta_secreta, respuesta_secreta, vinculo_con_univalle, tipo_usuario, correo_electronico, nivel_escolaridad, genero, "
                + "fecha_nacimiento, fecha_registro, activo FROM usuarios WHERE username= '" +login+ "';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultar);
            while(tabla.next()){
             usuario.setLogin( tabla.getString(1));
             usuario.setNombre(tabla.getString(2));
             usuario.setApellido(tabla.getString(3));
             usuario.setContraseña(tabla.getString(4));
             usuario.setPreguntaSecreta(tabla.getString(5));
             usuario.setRespuestaSecreta(tabla.getString(6));
             usuario.setVinculoUnivalle(tabla.getString(7));
             usuario.setPerfil(tabla.getString(8));
             usuario.setCorreoElectronico(tabla.getString(9));
             usuario.setEscolaridad(tabla.getString(10));
             usuario.setGenero( tabla.getString(11));
             usuario.setFechaNacimiento(tabla.getString(12));
             usuario.setFechaRegistro(tabla.getString(13));
             usuario.setActivo(tabla.getString(14));
            }
            conn.close();

         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return usuario;
    }


    public int modificarUsuario(Usuario usuario)
    {
        String sql_modificar;
        sql_modificar="UPDATE usuarios SET username= '"+usuario.getLogin()+
                "',password= '"+usuario.getContraseña()+
                "', pregunta_secreta= '"+usuario.getPreguntaSecreta()+
                "', respuesta_secreta= '"+usuario.getRespuestaSecreta()+
                "', nombres= '"+usuario.getNombre()+
                "', apellidos= '"+usuario.getApellido()+
                "', genero= '"+usuario.getGenero() +
                "', fecha_nacimiento = '"+usuario.getFechaNacimiento()+
                "', nivel_escolaridad= '"+usuario.getEscolaridad()+
                "', vinculo_con_univalle= '"+usuario.getVinculoUnivalle()+
                "', correo_electronico= '"+usuario.getCorreoElectronico()+
                "', activo="+ usuario.getActivo()+
                "' WHERE username= '"+usuario.getLogin()+"';";

        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_modificar);
            conn.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }

        return -1;
    }

    public int desactivarUsuario(String login)
    {
        String sql_desactivar;
        sql_desactivar="UPDATE usuarios SET activo='false' WHERE username = '"+login+"';";

        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_desactivar);
            conn.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }

        return -1;
    }


    public int agregarAreasComputacion(String login, String id_area)
    {
        String sql_guardar;
        sql_guardar="INSERT INTO usuario_areas_computacion(username, area_id) VALUES ('" +
                login + "', '" + id_area +"');";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_guardar);
            conn.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }

        return -1;
    }

    public int eliminarAreasComputacion(String login, String id_area)
    {
        String sql_eliminarArea;
        sql_eliminarArea="DELETE FROM usuario_areas_computacion  WHERE username= '"+login+"';";

        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_eliminarArea);
            conn.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }

        return -1;
    }

  
    

    public boolean AutenticarUsuario(String login, String contrasena)
    {
        String passwordRecibido="";
        String LoginRecibido="";
        String sql_autenticar;
        sql_autenticar="SELECT  password FROM usuarios WHERE username= '"+login+"';";
        
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_autenticar);
            while(tabla.next()){
                passwordRecibido=tabla.getString(1);

            }
             conn.close();
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }

        if(contrasena.equals(passwordRecibido))
        {
            return true;

        }
        return false;
    }


    public boolean verificarUsuarioDisponible(String login)
    {
        String loginRecibido= new String();
        String sql_verificarUsuario;
        sql_verificarUsuario="SELECT username FROM usuarios WHERE username= '"+login+"';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_verificarUsuario);
            while(tabla.next()){
                loginRecibido=tabla.getString(1);
            }
             conn.close();
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }

        if(login.equals(loginRecibido))
        {
            return false;

        }
        return true;
    }
    
    public String obtenerTipoUsuario(String username){
        String tipoRecibido= null;
        String sql_verificarUsuario;
        sql_verificarUsuario="SELECT tipo_usuario FROM usuarios WHERE username= '"+username+"';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_verificarUsuario);
            tipoRecibido="";
            if(tabla.next()){
                tipoRecibido=tabla.getString(1);
            }
             conn.close();
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }

        return tipoRecibido;
    }

    public String obtenerActivoUsuario(String username){
        String activoRecibido= null;
        String sql_verificarUsuario;
        sql_verificarUsuario="SELECT activo FROM usuarios WHERE username= '"+username+"';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_verificarUsuario);
            activoRecibido="";
            if(tabla.next()){
                activoRecibido=tabla.getString(1);
            }
             conn.close();
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }

        return activoRecibido;
    }

    public int cambiarTipoUsuario(String username, String tipo) {
        String sql_asignar;
        sql_asignar="UPDATE usuarios SET tipo_usuario='"+tipo+"'  WHERE username= '"+username+"';";

        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_asignar);
            conn.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }

        return -1;
    }
    
    public int cambiarEstadoCuenta(String username, String estado) {
        String sql_asignar;
        sql_asignar="UPDATE usuarios SET activo='"+estado+"'  WHERE username= '"+username+"';";

        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_asignar);
            conn.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }

        return -1;
    }



}
