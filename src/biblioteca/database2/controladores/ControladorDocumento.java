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

import biblioteca.database2.accesoDatos.DaoDocumento;
import biblioteca.database2.beans.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  Esta clase forma parte de los controladores creados para cumplir con el Patrón
 * de diseño DAO.
 * 
 * ControladorDocumento es una de las interfaces entre los Dao y las GUI de la aplicación.
 * ControladorAutor se encarga de administrar todo lo relacionado con los documentos en la base
 * agregar autores a estos, palabras clave y áreas de la computación; se pueden agregar, modificar,
 * activar o desactivar documentos de la base de datos
 * 
 * La llave primaria de los documentos es un id único asignado por la base de datos en
 * el momento de agregar un nuevo documento a esta.
 * 
 * @see <a href="http://www.proactiva-calidad.com/java/patrones/DAO.html">Patrón "Data Access Object"</a>
 *
 * @author María Cristina Bustos Rodríguez
 * @author Alejandro Valdés Villada
 */
public class ControladorDocumento {
    
    /**
     * inserta un documento en la base de datos, con los datos dados.
     * @param tituloPrincipal String con el título principal del documento
     * @param tituloSecundario String con el título secundario del documento
     * @param editorial String con la editorial del documento
     * @param derechosAutor String con los derechos de autor del documento
     * @param idioma String con el idioma del documento
     * @param descripcion String con la descripción(resumen) del documento
     * @param tipoMaterial String con el tipo de Material del documento
     * @param fechaPublicacion String con la fecha de publicación del documento en formato SQL
     * @param catalogador String con el login(username) del catalogador del documento
     */
    public void insertarDocumento(String tituloPrincipal, String tituloSecundario,
             String editorial, String derechosAutor, String idioma, String descripcion,
             String tipoMaterial,String fechaPublicacion, String catalogador){
        Documento documento = new Documento();
        documento.setActivo(true);
        documento.setDerechosAutor(derechosAutor);
        documento.setDescripcion(descripcion);
        documento.setEditorial(editorial);
        documento.setFechaPublicacion(fechaPublicacion);
        documento.setIdioma(idioma);
        documento.setTipoMaterial(tipoMaterial);
        documento.setTituloPrincipal(tituloPrincipal);
        documento.setTituloSecundario(tituloSecundario);
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.insertarDocumento(documento, catalogador);
        
        //seguridad?
        daoDocumento= null;
        documento= null;
    }
    
    /**
     * Deshabilita un documento de la base de datos según su identificador unico (numerico)
     * @param id_documento String con el identificador del documento
     */
    public void deshabilitarDocumento(String id_documento){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.deshabilitarDocumento(id_documento);
    }
    
    /** 
     * Consulta los datos de un documento de la base de datos con el identificador de este
     * @param id_documento String con el identificador del documento
     * @return Documento con todos los datos del documento obtenidos de la base de datos
     */
    public Documento consultarDocumento(String id_documento){
        return new DaoDocumento().consultarDocumento(id_documento);
    }
    
    /**
     * Inserta al documento con identificación id_documento, la ubicación de su archivo.
     * @param id_documento String con el identificador unico de documento
     * @param ubicacion String con la dirección(path) del archivo del documento
     */
    public void insertarUbicacion(String id_documento, String ubicacion){
        new DaoDocumento().insertarUbicacion(id_documento, ubicacion);
    }
    
    /**
     * Modifica un documento con id_documento, con los parametros dados a la función
     * @param id_documento String con el identificador del documento a modificar
     * @param tituloPrincipal String con el título principal del documento
     * @param tituloSecundario String con el título secundario del documento
     * @param editorial String con la editorial del documento
     * @param derechosAutor String con los derechos de autor del documento
     * @param idioma String con el idioma del documento
     * @param descripcion String con la descripción(resumen) del documento
     * @param tipoMaterial String con el tipo de Material del documento
     * @param fechaPublicacion String con la fecha de publicación del documento en formato SQL
     * @param activo boolean indicando el estado (activo, inactivo) del documento
     */
    public void modificarDocumento(String id_documento, String tituloPrincipal, String tituloSecundario,
             String editorial, String derechosAutor, String idioma, String descripcion,
             String tipoMaterial,String fechaPublicacion, boolean activo){
        Documento documento = new Documento();
        documento.setID_documento(id_documento);
        documento.setDerechosAutor(derechosAutor);
        documento.setActivo(activo);
        documento.setDescripcion(descripcion);
        documento.setEditorial(editorial);
        documento.setFechaPublicacion(fechaPublicacion);
        documento.setIdioma(idioma);
        documento.setTipoMaterial(tipoMaterial);
        documento.setTituloPrincipal(tituloPrincipal);
        documento.setTituloSecundario(tituloSecundario);
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.modificarDocumento(documento);

    }
    
    /**
     * Obtiene el id de un documento de la base de datos con los parametros dados,
     * esta función es creada debido a que los identificadores se deben conocer al
     * momento de crear los documentos para poder insertar en otras tablas el contenido
     * de autores, palabras claves y áreas, y también, insertar la ubicación de este.
     * @param tituloPrincipal String con el título principal del documento
     * @param tituloSecundario String con el título secundario del documento
     * @param editorial String con la editorial del documento
     * @param derechosAutor String con los derechos de autor del documento
     * @param idioma String con el idioma del documento
     * @param descripcion String con la descripción(resumen) del documento
     * @param tipoMaterial String con el tipo de Material del documento
     * @param fechaPublicacion String con la fecha de publicación del documento en formato SQL
     * @param catalogador String con el login(username) del catalogador del documento
     * @return String con el identificador unico del documento que cumple esto.
     */
    public String obtenerId(String tituloPrincipal, String tituloSecundario,
             String editorial, String derechosAutor, String idioma, String descripcion,
             String tipoMaterial,String fechaPublicacion, String catalogador){
        Documento documento = new Documento();
        documento.setActivo(true);
        documento.setDerechosAutor(derechosAutor);
        documento.setDescripcion(descripcion);
        documento.setEditorial(editorial);
        documento.setFechaPublicacion(fechaPublicacion);
        documento.setIdioma(idioma);
        documento.setTipoMaterial(tipoMaterial);
        documento.setTituloPrincipal(tituloPrincipal);
        documento.setTituloSecundario(tituloSecundario);
        DaoDocumento daoDocumento = new DaoDocumento();
        return daoDocumento.obtenerDocumentoID(documento, catalogador);
    }
    
    /**
     * Comprueba si el documento con id_documento existe en la base de datos
     * @param id_documento String con el identificador unico del documento a verificar
     * @return boolean indicando si el documento existe en la base de datos o no
     * @deprecated esto no es necesario, en vez, use la consulta de documento comprobando si el objeto retornado es null
     */
    @Deprecated
    public boolean verificarExistencia(String id_documento){
        DaoDocumento daoDocumento = new DaoDocumento();
        return daoDocumento.verificarExistencia(id_documento);
    }
    
    /**
     * Agrega una nueva tupla a la tabla usuario_consulta_documento cuando un usuario
     * consulta un documento a través de la interfaz de busqueda, simultaneamente retorna
     * el documento con el identificador especificado
     * @param id_documento String con el identificador del documento consultado
     * @param usuario String con el login(username) del usuario que consultó el documento
     * @return Documento con los datos obtenidos de la base de datos
     */
    public Documento usuarioConsultaDocumento(String id_documento, String usuario){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.UsuarioConsultaDocumento(id_documento, usuario);
        return daoDocumento.consultarDocumento(id_documento);
    }
    
    /**
     * Agrega una nueva tupla a la tabla usuario_descarga_documento cuando un usuario
     * descarga un documento a través del boton de descarga del la interfaz de información
     * avanzada
     * @param documento String con el identificador del documento a descargar
     * @param usuario String con el login(username) del usuario que descargará el documento
     */
    public void usuarioDescargaDocumento(String documento, String usuario){
        new DaoDocumento().UsuarioDescargaDocumento(documento, usuario);
    }
    
    /**
     * Agrega un conjunto de palabras claves a un documento especifico
     * @param id_documento String con el identificador del documento a insertarle palabras claves
     * @param PC ArrayList de PalabraClave con las palabras claves que se le insertarán al documento
     */
    public void insertarPalabrasClave(String id_documento, ArrayList<PalabraClave> PC){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.insertarPalabrasClave(PC, id_documento);
    }
    
    /**
     * Agrega un conjunto de áreas de las ciencias de la computación a un documento
     * @param id_documento String con el identificador del documento
     * @param Areas ArrayList de Area con las areas de la computación a insertar al documento
     */
    public void insertarAreas(String id_documento, ArrayList<Area> Areas){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.insertarAreas(Areas, id_documento);
    }
    
    /**
     * Agrega un conjunto de autores a un documento en particular
     * @param id_documento String con el identificador del documento
     * @param emails ArrayList de Autor con los autores a insertar al documento
     */
    public void insertarAutores(String id_documento, ArrayList<Autor> emails){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.insertarAutores(emails, id_documento);
    }
    
    /**
     * Elimina un conjunto de palabras clave de un documento particular
     * @param id_documento String con el identificador del documento a insertarle palabras claves
     * @param PC ArrayList de PalabraClave con las palabras claves que se eliminarán del documento 
     */
    public void eliminarPalabrasClave(String id_documento, ArrayList<PalabraClave> PC){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.eliminarPalabrasClave(PC, id_documento);
    }
    
    /**
     * Elimina un conjunto de áreas de la computación de un documento
     * @param id_documento String con el identificador del documento
     * @param Areas ArrayList de Area con las areas de la computación a eliminar del documento
     */
    public void eliminarAreas(String id_documento, ArrayList<Area> Areas){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.eliminarAreas(Areas, id_documento);
    }
    
    /**
     * Elimina un conjunto de autores de un documento
     * @param id_documento String con el identificador del documento
     * @param emails ArrayList de Autor con los autores a eliminar del documento
     */
    public void eliminarAutores(String id_documento, ArrayList<Autor> emails){
        DaoDocumento daoDocumento = new DaoDocumento();
        daoDocumento.eliminarAutores(emails, id_documento);
    }
    
    /**
     * Obtiene las palabras claves asociadas con un documento
     * @param id_documento String con el identificador del documento a consultar
     * @return ArrayList de PalabraClave con las palabras claves asociadas a un documento
     */
    public ArrayList<PalabraClave> obtenerPalabrasClave(String id_documento){
        return new DaoDocumento().consultarPalabrasClaveDocumento(id_documento);
    }
    
    /**
     * Obtiene los autores asociados a un documento
     * @param id_documento String con el identificador del documento a consultar
     * @return ArrayList de Autor con los autores asociados al documento especificado
     */
    public ArrayList<Autor> obtenerAutores(String id_documento){
        return new DaoDocumento().consultarAutoresDocumento(id_documento);
    }
    
    /**
     * Obtiene las áreas de la computación asociadas a un documento
     * @param id_documento String con el identificador del documento a consultar
     * @return ArrayList de Area con las áreas de la computación asociadas al documento especificado
     */
    public ArrayList<Area> obtenerAreas(String id_documento){
        return new DaoDocumento().consultarAreasDocumento(id_documento);
    }
    /*
     * 
     * La Salida es un ArrayList, donde se metera primero el id del documento, 
     * luego el titulo principal, titulo secundario y autor
     */
    
    /**
     * Busca un conjunto de documentos que tengan las palabras contenidas en entrada
     * separadas por espacios. El resultado es un ArrayList donde se guardan dos Strings
     * de cada uno de los documentos resultantes, el identificador y el titulo principal
     * @param entrada ArrayList de String con los resultados
     * @return 
     */
    public ArrayList<String> consultaDocumentoGeneral(String entrada){
        StringTokenizer Stk = new StringTokenizer(entrada, " ");
        ArrayList<String> metadatos = new ArrayList<String>();
        while(Stk.hasMoreTokens()){
            metadatos.add(Stk.nextToken());
        }
        return new DaoDocumento().consultarDocumento(metadatos);
    }
    
    public ArrayList<String> consultaDocumentoAvanzada(ArrayList<String> titulo, ArrayList<String> autor,
            ArrayList<String> pc, int tituloopcion, int autoropcion, int pcopcion, String area,
            String editorial, String tipo_material, String idioma, int fecha){
                 return new DaoDocumento().consultaAvanzada(titulo, autor,
             pc,  tituloopcion,  autoropcion, pcopcion, area,
            editorial,  tipo_material, idioma, fecha);
    }

    public ArrayList<String> consultarRecomendaciones(String username){
        ControladorUsuario controlador = new ControladorUsuario();
        ArrayList<Area> usuarioAreas = new ControladorArea().consultarAreasporUsuario(username);
        ArrayList<String> codigoAreasUsuario = new ArrayList<String>(usuarioAreas.size());
        for(int i=0;i<usuarioAreas.size();i++){
            codigoAreasUsuario.add(usuarioAreas.get(i).getID());
        }
        return new DaoDocumento().consultarRecomendacionesDocumentos(username, controlador.obtenerUltimoAcceso(username), codigoAreasUsuario);
    }
    
    
}