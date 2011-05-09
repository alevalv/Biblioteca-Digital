/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.beans;
import java.sql.Timestamp;
import java.sql.Date;
/**
 *
 * @author Eduardo
 */
public class Usuario {

    String login;
    String nombre;
    String activo;
    String apellido;
    String contraseña;
    String preguntaSecreta;
    String respuestaSecreta;
    String genero;
    String fechaNacimiento;
    String escolaridad;
    String vinculoUnivalle;
    String fechaRegistro;
    String perfil;
    String correo_electronico;


    public Usuario(){}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     public void setLogin(String login) {
        this.login = login;
    }
     
     public void setActivo(String activo) {
         this.activo=activo;
     }

      public void setApellido(String apellido) {
        this.apellido = apellido;
    }

      public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

      public void setPreguntaSecreta(String preguntaSecreta) {
        this.preguntaSecreta = preguntaSecreta;
    }

     public void setRespuestaSecreta(String respuestaSecreta) {
        this.respuestaSecreta = respuestaSecreta;
    }

     public void setGenero(String genero) {
        this.genero = genero;
    }

     public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

     public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

     public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

     public void setVinculoUnivalle(String vinculoUnivalle) {
        this.vinculoUnivalle = vinculoUnivalle;
    }

     public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

     public void setCorreoElectronico(String correo_electronico){
         this.correo_electronico=correo_electronico;
     }


     public String getNombre() {
        return nombre;
    }

     public String getLogin() {
        return login;
     }
     
     public String getActivo() {
         return activo;
     }

     public String getApellido() {
        return apellido;
     }

     public String getContraseña() {
        return contraseña;
     }

     public String getPreguntaSecreta() {
        return preguntaSecreta;
     }

     public String getRespuestaSecreta() {
        return respuestaSecreta;
     }

     public String getFechaNacimiento() {
        return fechaNacimiento;
     }

     public String getGenero() {
        return genero;
     }

     public String getEscolaridad() {
        return escolaridad;
     }

     public String getVinculoUnivalle() {
        return vinculoUnivalle;
     }

     public String getFechaRegistro() {
        return fechaRegistro;
     }

     public String getPerfil() {
        return perfil;
     }

     public String getCorreoElectronico(){
         return correo_electronico;
     }
}

