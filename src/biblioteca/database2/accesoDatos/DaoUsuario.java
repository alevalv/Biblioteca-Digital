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

import biblioteca.database2.beans.*;
import biblioteca.database2.fachada.Fachada;
import java.sql.*;

/**
 *  Esta clase forma parte de los controladores creados para cumplir con el Patrón
 * de diseño DAO.
 * 
 * <br>DaoUsuario crea el sql que se ejecutará a través de una conexión de una Fachada,
 * este dao tiene que ver con todo lo relacionado con la administración de usuarios
 * en la aplicación
 * 
 * @see <a href="http://www.proactiva-calidad.com/java/patrones/DAO.html">Patrón "Data Access Object"</a>
 *
 * @author María Cristina Bustos Rodríguez
 * @author Alejandro Valdés Villada
 */
public class DaoUsuario {

    Fachada fachada;

   public DaoUsuario(){
        fachada= new Fachada();
    }

   /**
    * Inserta un nuevo usuario en la base de datos
    * @param usuario Usuario con los datos a insertar
    * @return -1 si la operación no fue exitosa
    */
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
        catch(Exception e){ System.err.println(e); }
        return -1;
    }

     /**
      * Consulta los datos de un usuario dando su login(username) 
      * @param login String con el login(username) del usuario a consultar
      * @return Usuario con los datos del usuario relacionado con el login dado
      */
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
         catch(SQLException e){ System.err.println(e); }
         catch(Exception e){ System.err.println(e); }
        return usuario;
    }


    /**
     * Modifica un usuario pasando los datos viejos y nuevos en el Usuario, el 
     * usuario se busca por el username, que es la primary key de los usuarios
     * @param usuario Usuario con los datos para modificar
     * @return -1 si la operación no fue exitosa
     */
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
        catch(SQLException e){ System.err.println(e); }

        return -1;
    }

    /**
     * Desactiva un usuario, dando el username
     * @param login String con el login(username) del usuario a desactivar
     * @return -1 si la operación no fue exitosa
     * @deprecated Use cambiarEstadoCuenta(String, String)
     */
    @Deprecated
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
        catch(SQLException e){ System.err.println(e); }

        return -1;
    }

    /**
     * Agrega un área a un usuario en particular
     * @param login String con el username del usuario a modificar
     * @param id_area String con el identificador del área a insertar
     * @return -1 si la operación no fue exitosa
     */
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
        catch(SQLException e){ System.err.println(e); }

        return -1;
    }

    /**
     * Elimina un área de un usuario en particular
     * @param login String con el username del usuario a modificar
     * @param id_area String con el identificador del área a modificar
     * @return -1 si la operación no fue exitosa
     */
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
        catch(SQLException e){ System.err.println(e); }

        return -1;
    }

    /**
     * Autentica un usuario en la base de datos
     * @param login String con el login(username) a autenticar
     * @param contrasena String con la contraseña del usuario a autenticar
     * @return boolean indicando si la autenticación es correcta
     */
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
         catch(SQLException e){ System.err.println(e); }
         catch(Exception e){ System.err.println(e); }

        if(contrasena.equals(passwordRecibido))
        {
            return true;

        }
        return false;
    }

    /**
     * Verifica si el username pasado está disponible para ser usado
     * @param login String con el login(username) a comprobar
     * @return boolean indicando si el login está disponible o no
     */
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
         catch(SQLException e){ System.err.println(e); }
         catch(Exception e){ System.err.println(e); }

        if(login.equals(loginRecibido))
        {
            return false;

        }
        return true;
    }
    
    /**
     * Obtiene el tipo de un usuario dando su username
     * @param username String con el login(username) del usuario
     * @return String con el tipo de usuario
     */
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
         catch(SQLException e){ System.err.println(e); }
         catch(Exception e){ System.err.println(e); }

        return tipoRecibido;
    }

    /**
     * Obtiene el valor de activo de un usuario seleccionado
     * @param username String con el login(username) del usuario a consultar
     * @return String con el valor de activo del usuario, puede ser "t" o "f"
     */
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
         catch(SQLException e){ System.err.println(e); }
         catch(Exception e){ System.err.println(e); }

        return activoRecibido;
    }

    /**
     * Cambia el tipo de un usuario por el especificado en el parametro
     * @param username String con el username del usuario a modificar
     * @param tipo String con el nuevo tipo del usuario, puede ser "1", "2" o "3"
     * @return -1 si la operación no fue exitosa
     */
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
        catch(SQLException e){ System.err.println(e); }

        return -1;
    }
    
    /**
     * Cambia el estado de una cuenta al especificado
     * @param username String con el username del usuario a modificar
     * @param estado String con el nuevo estado, puede ser "t" o "f"
     * @return -1 si la operación no fue exitosa
     */
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
        catch(SQLException e){ System.err.println(e); }

        return -1;
    }

    /**
     * Cambia la fecha de ultimo acceso por la especificada en los parametos
     * @param username String con el login(username) del usuario a modificar
     * @param ultimo_acceso String con la fecha (timestamp) del nuevo ultimo acceso
     * @return -1 si la operación no fue exitosa
     */
    public int cambiarUltimoAcceso(String username, String ultimo_acceso){
        String sql_update;
        sql_update="UPDATE usuarios SET ultimo_acceso='"+ultimo_acceso+"' WHERE "
                + "username='"+username+"';";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_update);
            conn.close();
            return numFilas;
        }
        catch(SQLException e){ System.err.println(e); }

        return -1;
                
    }
    
    /**
     * Obtiene el ultimo acceso de un usuario especificando su username
     * @param username String con el login(username) del usuario a consultar
     * @return String con el ultimo acceso en formato timestamp
     */
    public String obtenerUltimoAcceso(String username){
        String ultimoAcceso= null;
        String sql_consultar;
        sql_consultar="SELECT ultimo_acceso FROM usuarios WHERE username= '"+username+"';";
         try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultar);
            ultimoAcceso="";
            if(tabla.next()){
                ultimoAcceso=tabla.getString(1);
            }
             conn.close();
         }
         catch(SQLException e){ System.err.println(e); }
         catch(Exception e){ System.err.println(e); }

        return ultimoAcceso;
    }

}
