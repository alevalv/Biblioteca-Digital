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
package biblioteca.database2.beans;

/**
 *  Esta clase forma parte de los beans creados para cumplir con el Patrón
 * de diseño DAO.
 * 
 * Usuario representa la relación usuarios de la base de datos.
 *
 * Es una clase de getters y setters.
 * 
 * @see <a href="http://www.proactiva-calidad.com/java/patrones/DAO.html">Patrón "Data Access Object"</a>
 * 
 * @author María Cristina Bustos Rodríguez
 * @author Alejandro Valdés Villada
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

    /**
     * Construye un objeto vacio de tipo Usuario
     */
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

    @Override
     public String toString(){
         String result="";
         result+=getLogin()+"-"+getNombre()+"-"+getPerfil();
         return result;
     }
}

