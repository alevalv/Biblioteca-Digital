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
package biblioteca.database2.controladores;

import biblioteca.database2.accesoDatos.DaoUsuario;
import biblioteca.database2.beans.Usuario;

/**
 *  Esta clase forma parte de los controladores creados para cumplir con el Patrón
 * de diseño DAO.
 * 
 * ControladorUsuario es una de las interfaces entre los Dao y las GUI de la aplicación.
 * ControladorAutor se encarga de administrar todo lo relacionado con los usuarios de la
 * aplicación
 * La llave primaria de los autores es su correo electronico
 * 
 * @see <a href="http://www.proactiva-calidad.com/java/patrones/DAO.html">Patrón "Data Access Object"</a>
 *
 * @author María Cristina Bustos Rodríguez
 * @author Alejandro Valdés Villada
 */
public class ControladorUsuario {

    /**
     * Inserta un usuario nuevo a la base de datos con los parametros dados
     * @param Username String con el login(username) del usuario a insertar
     * @param Nombre String con el/los nombre(s) del usuario a insertar
     * @param Apellido String con el/los apellido(s) del usuario a insertar
     * @param genero String con el genero del usuario a insertar, puede ser "M" o "F"
     * @param Email String con el correo electronico del usuario a insertar
     * @param Password String con el password del usuario a insertar
     * @param Fecha_Nacimiento String con la fecha de nacimiento del usuario, debe cumplir el formato SQL de PostgreSQL
     * @param Pregunta_secreta String con la pregunta secreta del usuario a insertar
     * @param Respuesta_secreta String con la respuesta secreta del usuario a insertar
     * @param Vinculo_univalle String con el vinculo que tiene el usuario a insertar con univalle
     * @param Tipo_usuario String con el tipo de usuario a insertar, por defecto será "3"
     * @param Nivel_escolaridad String con el nivel de escolaridad del usuario a insertar
     * @param fechaRegistro String con la fecha de registro del usuario a insertar
     * @return 1 si se inserto el usuario correctamente, -1 si hubo algún error
     */
    public int guardarUsuario(String Username, String Nombre, String Apellido,String genero, String Email, String Password, String Fecha_Nacimiento, String Pregunta_secreta, String Respuesta_secreta, String Vinculo_univalle, String Tipo_usuario, String Nivel_escolaridad,String fechaRegistro)
    {
        Usuario usuario= new Usuario();
        DaoUsuario daoUsuario= new DaoUsuario();

        usuario.setNombre(Nombre);
        usuario.setLogin(Username);
        usuario.setApellido(Apellido);
        usuario.setCorreoElectronico(Email);
        usuario.setContraseña(Password);
        usuario.setFechaNacimiento(Fecha_Nacimiento);
        usuario.setPreguntaSecreta(Pregunta_secreta);
        usuario.setRespuestaSecreta(Respuesta_secreta);
        usuario.setVinculoUnivalle(Vinculo_univalle);
        usuario.setPerfil(Tipo_usuario);
        usuario.setEscolaridad(Nivel_escolaridad);
        usuario.setGenero(genero);
        usuario.setFechaRegistro(fechaRegistro);

        return daoUsuario.guardarUsuario(usuario);
    }

    /**
     * Modifica los datos de un usuario según el username indicado
     * @param Username String con el login(username) del usuario
     * @param Nombre String con el/los nombre(s) del usuario a modificar
     * @param Apellido String con el/los apellido(s) del usuario a modificar
     * @param genero String con el genero del usuario a insertar, puede ser "M" o "F"
     * @param Email String con el correo electronico del usuario a modificar
     * @param Password String con el password del usuario a modificar
     * @param Fecha_Nacimiento String con la fecha de nacimiento del usuario, debe cumplir el formato SQL de PostgreSQL
     * @param Pregunta_secreta String con la pregunta secreta del usuario a modificar
     * @param Respuesta_secreta String con la respuesta secreta del usuario a modificar
     * @param Vinculo_univalle String con el vinculo que tiene el usuario con univalle
     * @param Nivel_escolaridad String con el nivel de escolaridad del usuario a insertar
     * @param estado String que indica el estado del usuario, puede ser "t" o "f"
     * @return -1 si la modificación del usuario fue incorrecta
     */
    public int modificarUsuario(String Username, String Nombre, String Apellido,String genero, String Email, String Password, String Fecha_Nacimiento, String Pregunta_secreta, String Respuesta_secreta, String Vinculo_univalle, String Nivel_escolaridad, String estado)
    {
        Usuario usuario= new Usuario();
        DaoUsuario daoUsuario= new DaoUsuario();

        usuario.setNombre(Nombre);
        usuario.setLogin(Username);
        usuario.setApellido(Apellido);
        usuario.setCorreoElectronico(Email);
        usuario.setContraseña(Password);
        usuario.setFechaNacimiento(Fecha_Nacimiento);
        usuario.setPreguntaSecreta(Pregunta_secreta);
        usuario.setRespuestaSecreta(Respuesta_secreta);
        usuario.setVinculoUnivalle(Vinculo_univalle);
        usuario.setEscolaridad(Nivel_escolaridad);
        usuario.setGenero(genero);
        usuario.setGenero(genero);
        usuario.setActivo(estado);

        return daoUsuario.modificarUsuario(usuario);
    }

    /**
     * Verifica si el username está disponible en la base de datos
     * @param Username String con el username
     * @return true si el username está disponible, false si no
     */
    public boolean verificarDisponibilidadUsuario(String Username)
    {
        boolean respuesta;
         DaoUsuario daoUsuario= new DaoUsuario();
         respuesta= daoUsuario.verificarUsuarioDisponible(Username);
         return respuesta;
    }
    
    /**
     * Verifica si el tipo de usuario dado es igual al del username
     * @param Tipo String con el tipo de usuario a comprobar
     * @param username String con el login(username) del usuario a comprobar
     * @return boolean indicando si el tipo de usuario dado es igual al del username
     */
    public boolean verificarTipoUsuario(String Tipo, String username){
        String tipoRecibido=new DaoUsuario().obtenerTipoUsuario(username);
        if(tipoRecibido.equals(Tipo)){
            return true;
        }
        else return false;
    }
    
    /**
     * Verifica si un usuario está activo o no
     * @param username String con el login(username) del usuario a comprobar
     * @return boolean indicando si el usuario activo o no
     */
    public boolean verificarActivo(String username){
        String activo=new DaoUsuario().obtenerActivoUsuario(username);
        if(activo.equals("t") || activo.equals("true"))
            return true;
        else return false;
    }

    /**
     * Cambia el tipo de usuario por el indicado en los parametros
     * @param username String con el login(username) del usuario a modificar
     * @param tipo String con el tipo nuevo para el usuario
     * @return -1 si la consulta fue ejecutada incorrectamente
     */
    public int cambiarTipoUsuario(String username, String tipo){
        return new DaoUsuario().cambiarTipoUsuario(username, tipo);

    }

    /**
     * Cambia el estado del usuario seleccionado por medio del username
     * @param username String con el login(username) del usuario a modificar
     * @param estado String con el nuevo estado para el usuario, puede ser "t" o "f"
     * @return -1 si la consulta fue ejecutada incorrectamente
     */
     public int cambiarEstadoCuenta(String username, String estado){
        return new DaoUsuario().cambiarEstadoCuenta(username, estado);

    }

     /**
      * Autentica un usuario en la base de datos, pasando el username y el password
      * @param Username String que contiene el username del usuario que se quiere autenticar
      * @param Password String con el password del usuario que se quiere autenticar
      * @return boolean indicando si la autenticación fue correcta o no
      */
    public boolean autenticarUsuario(String Username, String Password)
    {
         boolean respuesta;
         DaoUsuario daoUsuario= new DaoUsuario();
         respuesta= daoUsuario.AutenticarUsuario(Username, Password);
         return respuesta;
    }

    /**
     * Consulta los datos personales de un usuario indicando su username
     * @param username String con el login(username) del usuario a consultar
     * @return Usuario con los datos del usuario consultado
     */
    public Usuario consultarUsuario(String username)
    {
        Usuario usuario= new Usuario();
        DaoUsuario daoUsuario= new DaoUsuario();
        usuario= daoUsuario.consultarUsuario(username);
        return usuario;
    }

    /**
     * Desactiva un usuario de la aplicación
     * @param username String con el login(username) del usuario a desactivar
     */
    public void desactivarUsuario(String username)
    {
        DaoUsuario daoUsuario= new DaoUsuario();
        daoUsuario.desactivarUsuario(username);
    }
    
    /**
     * Actualiza el ultimo acceso (ultima vez conectado) del usuario con el username dado
     * @param username String con el login(username) del usuario a modificar
     * @return -1 si no se pudo realizar la modificación
     */
    public int actualizarUltimoAcceso(String username){
        java.util.Date actual=new java.util.Date();
        java.sql.Timestamp fechaderegistro=new java.sql.Timestamp(actual.getTime());
        return new DaoUsuario().cambiarUltimoAcceso(username, fechaderegistro.toString());
    }
    
    /**
     * Obtiene la fecha del ultimo acceso del usuario especificado
     * @param username String con el login(username) del usuario a modificar
     * @return String con la fecha del ultimo acceso, está en formato timestamp: <b>YYYY-MM-DD HH:MM:SS.SSS</b>
     */
    public String obtenerUltimoAcceso(String username){
        return new DaoUsuario().obtenerUltimoAcceso(username);
    }


}
