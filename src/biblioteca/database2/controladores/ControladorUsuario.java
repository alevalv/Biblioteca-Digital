/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.controladores;

import biblioteca.database2.accesoDatos.DaoUsuario;
import biblioteca.database2.beans.Usuario;
import java.sql.Timestamp;
import java.sql.Date;

public class ControladorUsuario {

    public ControladorUsuario(){
        
    }

    public void guardarUsuario(String Username, String Nombre, String Apellido,String genero, String Email, String Password, Date Fecha_Nacimiento, String Pregunta_secreta, String Respuesta_secreta, String Vinculo_univalle, String Tipo_usuario, String Nivel_escolaridad,Timestamp fechaRegistro)
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

        int u=daoUsuario.guardarUsuario(usuario);
    }

    public void modificarUsuario(String Username, String Nombre, String Apellido,String genero, String Email, String Password, Date Fecha_Nacimiento, String Pregunta_secreta, String Respuesta_secreta, String Vinculo_univalle, String Tipo_usuario, String Nivel_escolaridad,Timestamp fechaRegistro)
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

        usuario.setFechaRegistro(fechaRegistro);
        usuario.setGenero(genero);

        daoUsuario.modificarUsuario(usuario);
    }

    public boolean verificarDisponibilidadUsuario(String Username)
    {
        boolean respuesta;
         DaoUsuario daoUsuario= new DaoUsuario();
         respuesta= daoUsuario.verificarUsuarioDisponible(Username);
         return respuesta;
    }

    public boolean autenticarUsuario(String Username, String Password,String perfil)
    {
         boolean respuesta;
         DaoUsuario daoUsuario= new DaoUsuario();
         respuesta= daoUsuario.AutenticarUsuario(Username, Password,perfil);
         return respuesta;
    }
/*
    public Usuario consultarUsuario(String username)
    {
        Usuario usuario= new Usuario();
        DaoUsuario daoUsuario= new DaoUsuario();
        usuario= daoUsuario.consultarUsuario(username);
        return usuario;
    }
*/
    public void desactivarrUsuario(String username)
    {
        DaoUsuario daoUsuario= new DaoUsuario();
        daoUsuario.desactivarUsuario(username);
    }

    public void agregarAreasCompuacion(String Username, String Nombre)
    {
        DaoUsuario daoUsuario= new DaoUsuario();
        daoUsuario.agregarAreasComputacion(Username, Nombre);
    }

    public void eliminarAreasCompuacion(String username, String nombre)
    {
        DaoUsuario daoUsuario= new DaoUsuario();
        daoUsuario.eliminarAreasComputacion(username, nombre);
    }
}
