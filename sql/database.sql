-- This file is part of Biblioteca-Digital de Univalle.
--
-- Biblioteca-Digital de Univalle is free software: you can redistribute it and/or modify
-- it under the terms of the GNU General Public License as published by
-- the Free Software Foundation, either version 3 of the License, or
-- (at your option) any later version.
--
-- Biblioteca-Digital de Univalle is distributed in the hope that it will be useful,
-- but WITHOUT ANY WARRANTY; without even the implied warranty of
-- MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
-- GNU General Public License for more details.
--
-- You should have received a copy of the GNU General Public License
-- along with Biblioteca-Digital de Univalle.  If not, see <http://www.gnu.org/licenses/>.

--Creado por:
--Maria Cristina Bustos Rodriguez
--Alejandro Valdes Villada


DROP TABLE usuarios CASCADE;
DROP TABLE areas_computacion CASCADE;
DROP TABLE documentos CASCADE;
DROP TABLE palabras_clave CASCADE;
DROP TABLE tipo_material CASCADE;
DROP TABLE autor CASCADE;
DROP TABLE usuario_areas_computacion CASCADE;
DROP TABLE usuario_consulta_documento CASCADE;
DROP TABLE usuario_descarga_documento CASCADE;
DROP TABLE documento_areas_computacion CASCADE;
DROP TABLE documento_autor CASCADE;
DROP TABLE documento_palabras_clave CASCADE;
DROP SEQUENCE documento_indice CASCADE;
DROP SEQUENCE areas_indice CASCADE;

CREATE TABLE usuarios(
username varchar(30) PRIMARY KEY,
password varchar(30) NOT NULL,
activo boolean DEFAULT 'true',
nombres varchar(30) NOT NULL,
apellidos varchar(30) NOT NULL,
fecha_nacimiento date NOT NULL,
pregunta_secreta varchar(50) NOT NULL,
respuesta_secreta varchar(50) NOT NULL,
vinculo_con_univalle varchar(10) NOT NULL,
tipo_usuario char(1) DEFAULT '3',
correo_electronico varchar(40) NOT NULL,
nivel_escolaridad varchar(15),
genero char(1) NOT NULL,
fecha_registro timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
ultimo_acceso timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE SEQUENCE areas_indice INCREMENT BY 1 MINVALUE 1;

CREATE TABLE areas_computacion(
area_id int PRIMARY KEY DEFAULT nextval('areas_indice'::regclass),
nombre varchar(70) NOT NULL,
descripcion varchar(200),
area_padre int NOT NULL,
FOREIGN KEY (area_padre) REFERENCES areas_computacion (area_id));

CREATE TABLE tipo_material(
tipo_documento varchar(20) PRIMARY KEY,
descripcion varchar(200));

CREATE SEQUENCE documento_indice INCREMENT BY 1 MINVALUE 1;

CREATE TABLE documentos(
doc_id int PRIMARY KEY DEFAULT nextval('documento_indice'::regclass),
activo boolean NOT NULL DEFAULT 'true',
titulo_principal varchar(200) NOT NULL,
titulo_secundario varchar(200) NOT NULL,
tipo_documento varchar(20) NOT NULL,
descripcion varchar(1000),
idioma varchar(10),
editorial varchar(30),
fecha_publicacion date NOT NULL,
derechos_autor varchar(40) NOT NULL,
ubicacion varchar(512),
catalogador varchar(30) NOT NULL,
fecha_catalogacion timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (catalogador) REFERENCES usuarios (username),
FOREIGN KEY (tipo_documento) REFERENCES tipo_material (tipo_documento));

CREATE TABLE palabras_clave(
nombre varchar(20) PRIMARY KEY,
descripcion varchar(200));

CREATE TABLE autor(
autor_correo varchar(40) PRIMARY KEY,
acronimo varchar(6) NOT NULL,
nombre varchar(30) NOT NULL,
apellido varchar(30) NOT NULL);

CREATE TABLE usuario_areas_computacion (
username varchar(30) NOT NULL,
area_id int NOT NULL,
FOREIGN KEY (username) REFERENCES usuarios (username),
FOREIGN KEY (area_id) REFERENCES areas_computacion (area_id));


CREATE TABLE usuario_consulta_documento (
doc_id int NOT NULL,
username varchar(30) NOT NULL,
fecha_hora timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (doc_id) REFERENCES documentos(doc_id),
FOREIGN KEY (username) REFERENCES usuarios(username));

CREATE TABLE usuario_descarga_documento (
doc_id int  NOT NULL,
username varchar(30) NOT NULL,
fecha_hora timestamp NOT NULL  DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (doc_id) REFERENCES documentos(doc_id) ,
FOREIGN KEY (username) REFERENCES usuarios(username));

CREATE TABLE documento_areas_computacion(
area_id int NOT NULL,
doc_id int  NOT NULL,
FOREIGN KEY (area_id) REFERENCES areas_computacion (area_id),
FOREIGN KEY (doc_id) REFERENCES documentos(doc_id));

CREATE TABLE documento_autor(
doc_id int NOT NULL,
autor_correo varchar(40) NOT NULL,
FOREIGN KEY (doc_id) REFERENCES documentos(doc_id),
FOREIGN KEY (autor_correo) REFERENCES autor(autor_correo));

CREATE TABLE documento_palabras_clave(
doc_id int NOT NULL,
nombre varchar(20) NOT NULL,
FOREIGN KEY (doc_id) REFERENCES documentos(doc_id),
FOREIGN KEY (nombre) REFERENCES palabras_clave(nombre)
);

INSERT INTO areas_computacion VALUES (0, 'void', 'void', 0); --creado para las areas de computación que no tienen padre

INSERT INTO usuarios VALUES ('dummyuser','void', 'false', 'dummy', 'user', '19000101','dummy', 'user', 'Ninguno', '0', 'dummy', 'dummy', 'N'); --creado para guardar información de los usuarios no registrados

INSERT INTO usuarios(username, nombres,  apellidos, password, pregunta_secreta, respuesta_secreta, vinculo_con_univalle, tipo_usuario, correo_electronico, nivel_escolaridad, genero, fecha_nacimiento) VALUES ('root', 'Admin', 'Admin', 'root', 'Admin', 'root', 'Ninguno', '1', 'admin@bibliotecadigital.com', 'Ninguno', 'M', '2005-01-01');
