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

package biblioteca.database2.fachada;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *  Esta clase forma parte de los beans creados para cumplir con el Patrón
 * de diseño DAO.
 * 
 * Fachada es la conexión entre la aplicación y la base de datos a bajo nivel.
 *
 * Unicamente es accedida por los Dao de cada una de las relaciones de la base de datos
 * 
 * @see <a href="http://www.proactiva-calidad.com/java/patrones/DAO.html">Patrón "Data Access Object"</a>
 * 
 * @author María Cristina Bustos Rodríguez
 * @author Alejandro Valdés Villada
 */
public class Fachada {
    String url, usuario, password;
        Connection conexion;
        Statement instruccion;
        ResultSet tabla;
        /**
         * Construye un objeto de fachada con los valores definidos.
         */
        public Fachada(){
            url="jdbc:postgresql://localhost:5432/alevalvi";
            usuario="postgres";
            password="root";
        }

        /**
         * Obtiene una conexión a la base de datos acual
         * @return Connection hacia la base de datos
         */
        public Connection conectar(){
            try {
            // Se carga el driver
            Class.forName("org.postgresql.Driver");
            //System.out.println( "Driver Cargado" );
            } catch( Exception e ) {
                System.err.println( "No se pudo cargar el driver." );
            }

            try{
                     //Crear el objeto de conexion a la base de datos
                     conexion = DriverManager.getConnection(url, usuario, password);
                     System.err.println( "Conexion Abierta" );
                     return conexion;
                  //Crear objeto Statement para realizar queries a la base de datos
             } catch( Exception e ) {
                System.err.println( "No se pudo abrir." );
                return null;
             }

        }//end connectar

        /**
         * Cierra la conexión que es enviada como parametro
         * @param c Connection hacia la base de datos
         */
        public void cerrarConexion(Connection c){
            try{
                 c.close();
            } catch( Exception e ) {
                System.err.println( "No se pudo cerrar la BD" );
            }
        }
}
