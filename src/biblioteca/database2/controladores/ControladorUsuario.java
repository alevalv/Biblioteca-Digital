/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.controladores;

import biblioteca.database2.accesoDatos.DaoUsuario;
import biblioteca.database2.beans.Usuario;

public class ControladorUsuario {

    public ControladorUsuario(){
        
    }

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

    public boolean verificarDisponibilidadUsuario(String Username)
    {
        boolean respuesta;
         DaoUsuario daoUsuario= new DaoUsuario();
         respuesta= daoUsuario.verificarUsuarioDisponible(Username);
         return respuesta;
    }
    
    public boolean verificarTipoUsuario(String Tipo, String username){
        String tipoRecibido=new DaoUsuario().obtenerTipoUsuario(username);
        if(tipoRecibido.equals(Tipo)){
            return true;
        }
        else return false;
    }
    
    public boolean verificarActivo(String username){
        String activo=new DaoUsuario().obtenerActivoUsuario(username);
        if(activo.equals("t") || activo.equals("true"))
            return true;
        else return false;
    }

    public int cambiarTipoUsuario(String username, String tipo){
        return new DaoUsuario().cambiarTipoUsuario(username, tipo);

    }

     public int cambiarEstadoCuenta(String username, String estado){
        return new DaoUsuario().cambiarEstadoCuenta(username, estado);

    }

    public boolean autenticarUsuario(String Username, String Password)
    {
         boolean respuesta;
         DaoUsuario daoUsuario= new DaoUsuario();
         respuesta= daoUsuario.AutenticarUsuario(Username, Password);
         return respuesta;
    }

    public Usuario consultarUsuario(String username)
    {
        Usuario usuario= new Usuario();
        DaoUsuario daoUsuario= new DaoUsuario();
        usuario= daoUsuario.consultarUsuario(username);
        return usuario;
    }

    public void desactivarUsuario(String username)
    {
        DaoUsuario daoUsuario= new DaoUsuario();
        daoUsuario.desactivarUsuario(username);
    }
    
    public int actualizarUltimoAcceso(String username){
        java.util.Date actual=new java.util.Date();
        java.sql.Timestamp fechaderegistro=new java.sql.Timestamp(actual.getTime());
        return new DaoUsuario().cambiarUltimoAcceso(username, fechaderegistro.toString());
    }


}
