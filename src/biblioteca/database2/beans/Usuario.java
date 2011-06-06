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
    String ultimo_acceso;

    public String getUltimo_acceso() {
        return ultimo_acceso;
    }

    public void setUltimo_acceso(String ultimo_acceso) {
        this.ultimo_acceso = ultimo_acceso;
    }

    /**
     * Construye un objeto vacio de tipo Usuario
     */
    public Usuario(){}

    /**
     * Modifica el atributo nombre del objeto Usuario seleccionado
     * @param nombre String que contiene el nuevo nombre para el Usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Modifica el login(username) del Usuario seleccionado
     * @param login String que contiene el nuevo login del objeto Usuario seleccionado
     */
     public void setLogin(String login) {
        this.login = login;
    }
     
     /**
      * Modifica el estado(activo) del objeto Usuario seleccionado
      * debe ser un String aceptado por SQL, como "t" o "true", "f" o "false"
      * @param activo String que contiene el estado del objeto Usuario seleccionado
      */
     public void setActivo(String activo) {
         this.activo=activo;
     }

     /**
      * Modifica el Apellido(s) del objeto Usuario seleccionado
      * @param apellido String que contiene el/los apellido(s) del objeto Usuario seleccionado
      */
     public void setApellido(String apellido) {
        this.apellido = apellido;
    }

     /**
      * Modifica la contraseña del objeto Usuario seleccionado
      * @param contraseña String que contiene la contraseña nueva del objeto Usuario seleccionado
      */
     public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

     /**
      * Modifica la Pregunta secreta del objeto Usuario seleccionado
      * @param preguntaSecreta String que contiene la pregunta secreta del objeto Usuario seleccionado
      */
     public void setPreguntaSecreta(String preguntaSecreta) {
        this.preguntaSecreta = preguntaSecreta;
    }

     /**
      * Modifica la respuesta secreta del objeto Usuario seleccionado
      * @param respuestaSecreta String que contiene la respuesta secreta del objeto Usuario seleccionado
      */
     public void setRespuestaSecreta(String respuestaSecreta) {
        this.respuestaSecreta = respuestaSecreta;
    }

     /**
      * Modifica el genero del objeto Usuario seleccionado
      * este es un String con los valores de "M" o "F"
      * @param genero String que contiene el nuevo genero del objeto Usuario seleccionado
      */
     public void setGenero(String genero) {
        this.genero = genero;
    }

     /**
      * Modifica la fecha de nacimiento del objeto Usuario seleccionado
      * esta debe estar en formato SQL, es decir <b>YYYY-MM-DD</b>
      * @param fechaNacimiento String que contiene la nueva fecha de nacimiento del objeto Usuario seleccionado
      */
     public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

     /**
      * Modifica la escolaridad del objeto Usuario seleccionado
      * está definida en varios valores predefinidos: Ninguno, Primaria, Bachiller, Universidad, Maestria y Doctorado
      * @param escolaridad String que contiene la nueva escolaridad del objeto Usuario seleccionado
      */
     public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

     /**
      * Modifica la fecha de registro del Usuario seleccionado
      * esta fecha no debería ser modificada debido a que es generada al momento de crear
      * un usuario en la base de datos.
      * la fechaRegistro debe estar en formato SQL, es decir <b>YYYY-MM-DD</b>
      * @param fechaRegistro String que contiene la nueva fecha de registro del objeto Usuario seleccionado
      */
     public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
     }

     /**
      * Modifica el vinculo con univalle del objeto Usuario seleccionado
      * están predefinidos como: pregrado, postgrado, doctorado, egresado, profesor y jubilado
      * @param vinculoUnivalle String que contiene el nuevo vinculo con univalle del objeto Usuario seleccionado
      */
     public void setVinculoUnivalle(String vinculoUnivalle) {
        this.vinculoUnivalle = vinculoUnivalle;
    }

     /**
      * Modifica el tipo de perfil del objeto Usuario seleccionado
      * este esta definido de las siguiente manera:
      * <b>1</b> para administradores
      * <b>2</b> para catalogadores
      * <b>3</b> para usuarios normales
      * @param perfil String que contiene el nuevo perfil del objeto Usuario seleccionado
      */
     public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

     /**
      * Modifica el correo electronico del objeto Usuario seleccionado
      * @param correo_electronico String con el nuevo correo electronico del objeto Usuario seleccionado
      */
     public void setCorreoElectronico(String correo_electronico){
         this.correo_electronico=correo_electronico;
     }

     /**
      * Obtiene el nombre del objeto Usuario seleccionado
      * @return String que contiene el nombre del objeto Usuario seleccionado
      */
     public String getNombre() {
        return nombre;
    }

     /**
      * Obtiene el login(username) del objeto Usuario seleccionado
      * @return String que contiene el login del objeto Usuario seleccionado
      */
     public String getLogin() {
        return login;
     }
     
     /**
      * Obtiene el estado(activo) del objeto Usuario seleccionado
      * Esta función puede retornar "t" o "f" en el caso de PostgreSQL
      * @return El String representando si el usuario está activo
      */
     public String getActivo() {
         return activo;
     }

     /**
      * Obtiene el apellido del objeto Usuario seleccionado
      * @return String que contiene el/los apellido(s) del objeto Usuario seleccionado
      */
     public String getApellido() {
        return apellido;
     }

     /**
      * Obtiene la contraseña del objeto Usuario seleccionado
      * @return String que contiene la contraseña del objeto Usuario seleccionado
      */
     public String getContraseña() {
        return contraseña;
     }

     /**
      * Obtiene la pregunta secreta del objeto Usuario seleccionado
      * @return String que contiene la pregunta secreta del objeto Usuario seleccionado
      */
     public String getPreguntaSecreta() {
        return preguntaSecreta;
     }

     /**
      * Obtiene la respuesta secreta del objeto Usuario seleccionado
      * @return String que contiene la respuesta secreta del objeto Usuario seleccionado
      */
     public String getRespuestaSecreta() {
        return respuestaSecreta;
     }

     /**
      * Obtiene la fecha de nacimiento del objeto Usuario seleccionado
      * la fechaRegistro debe estar en formato SQL, es decir <b>YYYY-MM-DD</b>
      * @return String que contiene la fecha de nacimiento del objeto Usuario seleccionado
      */
     public String getFechaNacimiento() {
        return fechaNacimiento;
     }

     /**
      * Obtiene el genero del objeto Usuario seleccionado
      * este puede ser "M" o "F"
      * @return String que contiene el genero del objeto Usuario seleccionado
      */
     public String getGenero() {
        return genero;
     }

     /**
      * Obtiene la escolaridad del objeto Usuario seleccionado
      * @return String que contiene la escolaridad del objeto Usuario seleccionado
      */
     public String getEscolaridad() {
        return escolaridad;
     }

     /**
      * Obtiene el vinculo de univalle del objeto Usuario seleccionado
      * @return String que contiene el vinculo con univalle del objeto Usuario seleccionado
      */
     public String getVinculoUnivalle() {
        return vinculoUnivalle;
     }

     /**
      * Obtiene la fecha de registro del objeto Usuario seleccionado
      * está en formato SQL, es decir <b>YYYY-MM-DD</b>
      * @return String con la fecha de registro del objeto Usuario seleccionado
      */
     public String getFechaRegistro() {
        return fechaRegistro;
     }

     /**
      * Obtiene el tipo de perfil del objeto Usuario seleccionado
      * @return String con el tipo de perfil del objeto Usuario seleccionado
      */
     public String getPerfil() {
        return perfil;
     }

     /**
      * Obtiene el correo electronico del objeto Usuario seleccionado
      * @return 
      */
     public String getCorreoElectronico(){
         return correo_electronico;
     }

     /**
      * Obtiene una representación en String del objeto Usuario seleccionado
      * @return String que contiene el login, el nombre y el perfil del objeto Usuario seleccionado
      */
    @Override
     public String toString(){
         String result="";
         result+=getLogin()+"-"+getNombre()+"-"+getPerfil();
         return result;
     }
}

