INSERT INTO usuarios(username, nombres,  apellidos, password, pregunta_secreta, respuesta_secreta, vinculo_con_univalle, tipo_usuario, correo_electronico, nivel_escolaridad, genero, fecha_nacimiento, fecha_registro) VALUES ('alevalv', 'Alejandro', 'Valdés Villada', 'root', 'root', 'rootroot', 'Pregrado', '3', 'alejandro.valdes@correounivalle.edu.co', 'Bachiller', 'M', '1992-10-26', '2011-05-05 22:39:43.603');
UPDATE usuarios SET tipo_usuario='2'  WHERE username= 'alevalv';
INSERT INTO autor(autor_correo, nombre, apellido, acronimo) VALUES ('ramelm@uta.edu', 'Ramez', 'Elmasri', 'RE');
INSERT INTO autor(autor_correo, nombre, apellido, acronimo) VALUES ('sham@git.edu', 'Shamkant', 'B. Navathe', 'SBN');
INSERT INTO palabras_clave(nombre, descripcion) VALUES ('bases', 'Relacionado a las conjuntos de información');
INSERT INTO tipo_material(tipo_documento, descripcion) VALUES ('Libro','Obra impresa o electronica de más de 49 paginas');
INSERT INTO documentos(activo, titulo_principal, titulo_secundario, descripcion, idioma, editorial, fecha_publicacion, derechos_autor, tipo_documento, fecha_catalogacion, catalogador)VALUES ('true','Fundamentos de Sistemas de Bases de Datos','www.librosite.net/elmasri','Como crear, modificar y usar aplicaciones y sistemas de bases de datos','Español','Pearson','20070720','Copyright','Libro','2011-06-05 22:45:16.562','alevalv');
UPDATE documentos SET ubicacion ='repository/1.pdf' WHERE doc_id = '1';
INSERT INTO documento_autor VALUES ('1','ramelm@uta.edu');
INSERT INTO documento_autor VALUES ('1','sham@git.edu');
INSERT INTO documento_areas_computacion VALUES ('8','1');
INSERT INTO documento_areas_computacion VALUES ('10','1');
INSERT INTO documento_areas_computacion VALUES ('11','1');
INSERT INTO documento_areas_computacion VALUES ('12','1');
INSERT INTO documento_areas_computacion VALUES ('13','1');
INSERT INTO documento_areas_computacion VALUES ('15','1');
INSERT INTO documento_areas_computacion VALUES ('37','1');
INSERT INTO documento_areas_computacion VALUES ('47','1');
INSERT INTO documento_areas_computacion VALUES ('48','1');
INSERT INTO documento_areas_computacion VALUES ('53','1');
INSERT INTO documento_palabras_clave VALUES ('1','bases');
INSERT INTO usuarios(username, nombres,  apellidos, password, pregunta_secreta, respuesta_secreta, vinculo_con_univalle, tipo_usuario, correo_electronico, nivel_escolaridad, genero, fecha_nacimiento, fecha_registro) VALUES ('mariacbr', 'María Cristina', 'Bustos Rodríguez', 'root', 'root', 'rootroot', 'Pregrado', '3', 'cristina.bustos@correounivalle.edu.co', 'Bachiller', 'M', '1992-06-16', '2011-04-05 22:47:17.722');
INSERT INTO usuarios(username, nombres,  apellidos, password, pregunta_secreta, respuesta_secreta, vinculo_con_univalle, tipo_usuario, correo_electronico, nivel_escolaridad, genero, fecha_nacimiento, fecha_registro) VALUES ('millan', 'Martha', 'Millan', 'millan', 'Martha', 'Del socorro', 'Profesor', '3', 'martha.millan@correounivalle.edu.co', 'Doctorado', 'F', '1966-07-12', '2011-03-05 22:50:18.683');
INSERT INTO usuarios(username, nombres,  apellidos, password, pregunta_secreta, respuesta_secreta, vinculo_con_univalle, tipo_usuario, correo_electronico, nivel_escolaridad, genero, fecha_nacimiento, fecha_registro) VALUES ('oswaldo', 'Oswaldo', 'Solarte', 'oswaldo', 'Oswaldo', 'Solarte', 'Profesor', '3', 'oswaldo.solarte@correounivalle.edu.co', 'Maestria', 'M', '2005-01-01', '2011-02-05 22:52:10.363');
INSERT INTO usuarios(username, nombres,  apellidos, password, pregunta_secreta, respuesta_secreta, vinculo_con_univalle, tipo_usuario, correo_electronico, nivel_escolaridad, genero, fecha_nacimiento, fecha_registro) VALUES ('juldarod', 'Julián David', 'Rodríguez', 'juldarod', 'Julda', 'rod', 'Pregrado', '3', 'juldarod10@gmail.com', 'Bachiller', 'M', '1992-10-16', '2011-01-05 22:53:13.347');
INSERT INTO autor(autor_correo, nombre, apellido, acronimo) VALUES ('daniel@mit.edu', 'Daniel', 'P. Friedman', 'DPF');
INSERT INTO autor(autor_correo, nombre, apellido, acronimo) VALUES ('mitchellw@mit.edu', 'Mitchell', 'Wand', 'MW');
INSERT INTO palabras_clave(nombre, descripcion) VALUES ('lenguajes', 'Forma de comunicación');
INSERT INTO documentos(activo, titulo_principal, titulo_secundario, descripcion, idioma, editorial, fecha_publicacion, derechos_autor, tipo_documento, fecha_catalogacion, catalogador)VALUES ('true','Essentials of Programming Languages','Third Edition','Información sobre los interpretes de codigo del computador','Inglés','MIT Press','20070723','Todos los derechos reservados','Libro','2011-06-05 23:03:12.437','alevalv');
UPDATE documentos SET ubicacion ='repository/2.pdf' WHERE doc_id = '2';
INSERT INTO documento_autor VALUES ('2','daniel@mit.edu');
INSERT INTO documento_autor VALUES ('2','mitchellw@mit.edu');
INSERT INTO documento_areas_computacion VALUES ('16','2');
INSERT INTO documento_palabras_clave VALUES ('2','lenguajes');

INSERT INTO autor(autor_correo, nombre, apellido, acronimo) VALUES ('joshertelo@univalle.edu.co', 'Jose Hernán', 'Trejos Lopez', 'JHTL');
INSERT INTO documentos(activo, titulo_principal, titulo_secundario, descripcion, idioma, editorial, fecha_publicacion, derechos_autor, tipo_documento, fecha_catalogacion, catalogador)VALUES ('true','Curso de bases de datos','Código 951027','Concepto fundamentales -- Conceptualización, diseño, implementación y administración de bases de datos -- Estudio de bases de datos comerciales','Español','Univalle, DINTEV','19960727','GPL','Libro','2011-06-05 23:08:33.102','alevalv');
UPDATE documentos SET ubicacion ='repository/3.pdf' WHERE doc_id = '3';
INSERT INTO documento_autor VALUES ('3','joshertelo@univalle.edu.co');
INSERT INTO documento_areas_computacion VALUES ('8','3');
INSERT INTO documento_palabras_clave VALUES ('3','bases');

INSERT INTO autor(autor_correo, nombre, apellido, acronimo) VALUES ('cisco@cisco.com', 'Cisco ', 'Systems', 'CS');
INSERT INTO palabras_clave(nombre, descripcion) VALUES ('redes', 'conexiones entre multiples objetos');
INSERT INTO documentos(activo, titulo_principal, titulo_secundario, descripcion, idioma, editorial, fecha_publicacion, derechos_autor, tipo_documento, fecha_catalogacion, catalogador)VALUES ('true','Advanced Cisco router configuration','student guide','Cisco internetwork operating system release 10.3','Inglés','Cisco Systems','19950723','Reservados','Libro','2011-06-05 23:15:33.892','alevalv');
UPDATE documentos SET ubicacion ='repository/4.pdf' WHERE doc_id = '4';
INSERT INTO documento_autor VALUES ('4','cisco@cisco.com');
INSERT INTO documento_areas_computacion VALUES ('49','4');
INSERT INTO documento_areas_computacion VALUES ('1','4');
INSERT INTO documento_palabras_clave VALUES ('4','redes');

INSERT INTO autor(autor_correo, nombre, apellido, acronimo) VALUES ('stesch@bibliotecadigital.com', 'Stephen R.', 'Schach', 'SRS');
INSERT INTO documentos(activo, titulo_principal, titulo_secundario, descripcion, idioma, editorial, fecha_publicacion, derechos_autor, tipo_documento, fecha_catalogacion, catalogador)VALUES ('true','Análisis y diseño orientado a objetos con UML y el proceso unificado','Introduction to object-oriented analysis and design with UML and the unified process',' Introducción al UML y el proceso unificado. -- Introducción a los sistema de información. -- Cómo se desarrollan los sistemas de información. -- El paradigma orientado a objetos, UML','Español','McGraw-Hill','20050722','Copyright','Libro','2011-06-05 23:20:54.633','alevalv');
UPDATE documentos SET ubicacion ='repository/5.pdf' WHERE doc_id = '5';
INSERT INTO documento_autor VALUES ('5','stesch@bibliotecadigital.com');
INSERT INTO documento_areas_computacion VALUES ('7','5');
INSERT INTO documento_areas_computacion VALUES ('6','5');
INSERT INTO documento_palabras_clave VALUES ('5','lenguajes');

INSERT INTO autor(autor_correo, nombre, apellido, acronimo) VALUES ('celiogil@unilibre.edu.co', 'Celio', 'Gil', 'CG');
INSERT INTO palabras_clave(nombre, descripcion) VALUES ('software', 'Programa de computadora');
INSERT INTO documentos(activo, titulo_principal, titulo_secundario, descripcion, idioma, editorial, fecha_publicacion, derechos_autor, tipo_documento, fecha_catalogacion, catalogador)VALUES ('true','La calidad del software como eje matemático de investigación','AVANCES: Investigación en Ingeniería ','No. 4, 2006: Investigación en Ingeniería','Español','Universidad Libre','20060120','Copyright','Libro','2011-06-05 23:25:35.213','alevalv');
UPDATE documentos SET ubicacion ='repository/6.pdf' WHERE doc_id = '6';
INSERT INTO documento_autor VALUES ('6','celiogil@unilibre.edu.co');
INSERT INTO documento_areas_computacion VALUES ('6','6');
INSERT INTO documento_areas_computacion VALUES ('16','6');
INSERT INTO documento_palabras_clave VALUES ('6','lenguajes');
INSERT INTO documento_palabras_clave VALUES ('6','software');

INSERT INTO autor(autor_correo, nombre, apellido, acronimo) VALUES ('bermey@bibliotecadigital.com', 'Bertrand', 'Meyer', 'BM');
INSERT INTO documentos(activo, titulo_principal, titulo_secundario, descripcion, idioma, editorial, fecha_publicacion, derechos_autor, tipo_documento, fecha_catalogacion, catalogador)VALUES ('true','Construcción de software orientado a objetos','2da Edición','Computadores; Software; Programación orientada a objetos;','Español','Prentice Hall','19990527','Copyright','Libro','2011-06-05 23:30:42.965','alevalv');
INSERT INTO documento_autor VALUES ('7','bermey@bibliotecadigital.com');
INSERT INTO documento_areas_computacion VALUES ('7','7');
INSERT INTO documento_areas_computacion VALUES ('16','7');
INSERT INTO documento_areas_computacion VALUES ('17','7');
INSERT INTO documento_palabras_clave VALUES ('7','lenguajes');
INSERT INTO documento_palabras_clave VALUES ('7','software');

INSERT INTO autor(autor_correo, nombre, apellido, acronimo) VALUES ('groro@bibliotecadigital.com', 'Robert', 'Groth', 'RG');
INSERT INTO documentos(activo, titulo_principal, titulo_secundario, descripcion, idioma, editorial, fecha_publicacion, derechos_autor, tipo_documento, fecha_catalogacion, catalogador)VALUES ('true','Data mining',' a hands-on approach for business professionals','Introduction to data mining, The data mining process, The data mining marketplace, A look at angoss: Knowledge seeker','Inglés','Prentice Hall','19980617','Copyright','Libro','2011-06-05 23:35:23.515','alevalv');
INSERT INTO documento_autor VALUES ('8','groro@bibliotecadigital.com');
INSERT INTO documento_areas_computacion VALUES ('8','8');
INSERT INTO documento_areas_computacion VALUES ('38','8');
INSERT INTO documento_palabras_clave VALUES ('8','bases');

INSERT INTO autor(autor_correo, nombre, apellido, acronimo) VALUES ('iansom@bibliotecadigital.com', 'Ian', 'Sommerville', 'IS');
INSERT INTO documentos(activo, titulo_principal, titulo_secundario, descripcion, idioma, editorial, fecha_publicacion, derechos_autor, tipo_documento, fecha_catalogacion, catalogador)VALUES ('true','Ingeniería de software','Software Enginering','Conceptos relacionados con el desarrollo del 	Software','Español','Addison-Wesley','19880910','Copyright','Libro','2011-06-05 23:49:58.588','alevalv');
UPDATE documentos SET ubicacion ='repository/9.pdf' WHERE doc_id = '9';
INSERT INTO documento_autor VALUES ('9','iansom@bibliotecadigital.com');
INSERT INTO documento_areas_computacion VALUES ('6','9');
INSERT INTO documento_areas_computacion VALUES ('7','9');
INSERT INTO documento_palabras_clave VALUES ('9','software');

INSERT INTO autor(autor_correo, nombre, apellido, acronimo) VALUES ('gsga@bibliotecadigital.com', 'Andrés', 'Gómes de Silva Garza', 'AGSG');
INSERT INTO palabras_clave(nombre, descripcion) VALUES ('progamación', 'Acción y efecto de programar');
INSERT INTO documentos(activo, titulo_principal, titulo_secundario, descripcion, idioma, editorial, fecha_publicacion, derechos_autor, tipo_documento, fecha_catalogacion, catalogador)VALUES ('true','Introducción a la computación','Introducción a la computación','Hardware -- Software -- Datos y algoritmos básicos -- Datos y algoritmos avanzados -- Bases de datos -- Sistemas operativos -- redes de computadoras -- Computacion formal -- Gráficas por computadora -- Teoria de la informacion ','Español','Cengage Learning Editores','20080910','Copyright','Libro','2011-06-05 23:57:30.926','alevalv');
UPDATE documentos SET ubicacion ='repository/10.pdf' WHERE doc_id = '10';
INSERT INTO documento_autor VALUES ('10','gsga@bibliotecadigital.com');
INSERT INTO documento_areas_computacion VALUES ('6','10');
INSERT INTO documento_areas_computacion VALUES ('8','10');
INSERT INTO documento_areas_computacion VALUES ('16','10');
INSERT INTO documento_areas_computacion VALUES ('28','10');
INSERT INTO documento_palabras_clave VALUES ('10','lenguajes');
INSERT INTO documento_palabras_clave VALUES ('10','progamación');

INSERT INTO autor(autor_correo, nombre, apellido, acronimo) VALUES ('miwool@bibliotecadigital.com', 'Michael J.', 'Wooldrifge', 'MJW');
INSERT INTO documentos(activo, titulo_principal, titulo_secundario, descripcion, idioma, editorial, fecha_publicacion, derechos_autor, tipo_documento, fecha_catalogacion, catalogador)VALUES ('true','An introduction to multiagent systems','Una introducción a un sistema multiagente','ntelligent agents -- Deductive reasoning agents -- Practical reasoning agents -- Reactive and hybrid agents -- Multiagent interactions -- Reaching agreements -- Communication -- Working together -- Methodologies -- Applications -- Logics for multiagent systems','Inglés','Jhon Wiley & Sons','20060615','Copyright','Libro','2011-06-06 00:09:23.693','alevalv');
UPDATE documentos SET ubicacion ='repository/11.pdf' WHERE doc_id = '11';
INSERT INTO documento_autor VALUES ('11','miwool@bibliotecadigital.com');
INSERT INTO documento_areas_computacion VALUES ('38','11');
INSERT INTO documento_palabras_clave VALUES ('11','bases');
INSERT INTO documento_palabras_clave VALUES ('11','progamación');
INSERT INTO documento_palabras_clave VALUES ('11','software');

INSERT INTO autor(autor_correo, nombre, apellido, acronimo) VALUES ('rafabor@bibliotecadigital.com', 'Rafael H.', 'Bordini', 'RHB');
INSERT INTO documentos(activo, titulo_principal, titulo_secundario, descripcion, idioma, editorial, fecha_publicacion, derechos_autor, tipo_documento, fecha_catalogacion, catalogador)VALUES ('true','Multi-agent programming','languages, platforms and applications','Software; Desarrollo de software para computadores; Diseño de sistemas;','Inglés','Springer-Verlag','20050220','Copyright','Libro','2011-06-06 00:14:08.092','alevalv');
UPDATE documentos SET ubicacion ='repository/12.pdf' WHERE doc_id = '12';
INSERT INTO documento_autor VALUES ('12','rafabor@bibliotecadigital.com');
INSERT INTO documento_areas_computacion VALUES ('8','12');
INSERT INTO documento_areas_computacion VALUES ('31','12');
INSERT INTO documento_areas_computacion VALUES ('38','12');
INSERT INTO documento_palabras_clave VALUES ('12','bases');
INSERT INTO documento_palabras_clave VALUES ('12','lenguajes');
INSERT INTO documento_palabras_clave VALUES ('12','progamación');
INSERT INTO documento_palabras_clave VALUES ('12','software');

INSERT INTO autor(autor_correo, nombre, apellido, acronimo) VALUES ('tanenbaumandrew@bibliotecadigital.com', 'Andrew S.', 'Tanenbaum', 'AST');
INSERT INTO documentos(activo, titulo_principal, titulo_secundario, descripcion, idioma, editorial, fecha_publicacion, derechos_autor, tipo_documento, fecha_catalogacion, catalogador)VALUES ('true','Sistemas operativos modernos. - 2 ed.','Modern operating systems','Contenido relacionado con los sistemas operativos, sus componentes funcionales','Español','Pearson Education','20030727','Copyright','Libro','2011-06-06 00:23:01.25','alevalv');
UPDATE documentos SET ubicacion ='repository/13.pdf' WHERE doc_id = '13';
INSERT INTO documento_autor VALUES ('13','tanenbaumandrew@bibliotecadigital.com');
INSERT INTO documento_areas_computacion VALUES ('18','13');
INSERT INTO documento_areas_computacion VALUES ('28','13');
INSERT INTO documento_areas_computacion VALUES ('33','13');
INSERT INTO documento_palabras_clave VALUES ('13','software');

INSERT INTO autor(autor_correo, nombre, apellido, acronimo) VALUES ('roger.pressman@bibliotecadigital.com', 'Roger S.', 'Pressman', 'RSP');
INSERT INTO documentos(activo, titulo_principal, titulo_secundario, descripcion, idioma, editorial, fecha_publicacion, derechos_autor, tipo_documento, fecha_catalogacion, catalogador)VALUES ('true','Software engineering: a practitioners approach.','sexta edición','Software; Ingeniería del software; Medición de software; Desarrollo de software; Diseño en ingeniería; Programación (Computadores electrónicos);','Inglés','McGraw-Hill','20051121','Copyright','Libro','2011-06-06 00:28:47.387','alevalv');
UPDATE documentos SET ubicacion ='repository/14.pdf' WHERE doc_id = '14';
INSERT INTO documento_autor VALUES ('14','roger.pressman@bibliotecadigital.com');
INSERT INTO documento_areas_computacion VALUES ('7','14');
INSERT INTO documento_areas_computacion VALUES ('6','14');
INSERT INTO documento_palabras_clave VALUES ('14','software');
INSERT INTO documento_palabras_clave VALUES ('14','progamación');

INSERT INTO autor(autor_correo, nombre, apellido, acronimo) VALUES ('martha.millan@correounivalle.edu.co', 'Martha', 'Millan', 'MM');
INSERT INTO documentos(activo, titulo_principal, titulo_secundario, descripcion, idioma, editorial, fecha_publicacion, derechos_autor, tipo_documento, fecha_catalogacion, catalogador)VALUES ('true','Diapositivas Subconsultas','Bases de datos 2011 Univalle','Diapositivas de clase de bases de datos','Español','Universidad del Valle','20110407','CreativeCommons v3','Libro','2011-06-06 00:32:33.437','alevalv');
UPDATE documentos SET ubicacion ='repository/15.pdf' WHERE doc_id = '15';
INSERT INTO documento_autor VALUES ('15','martha.millan@correounivalle.edu.co');
INSERT INTO documento_areas_computacion VALUES ('8','15');
INSERT INTO documento_palabras_clave VALUES ('15','bases');


--consultas y descargas

INSERT INTO usuario_consulta_documento (doc_id, username, fecha_hora)VALUES ('12','millan', '2011-01-05 23:32:33.437');
INSERT INTO usuario_descarga_documento (doc_id, username, fecha_hora)VALUES ('12','millan', '2011-02-04 20:32:33.437');
INSERT INTO usuario_consulta_documento (doc_id, username, fecha_hora)VALUES ('14','millan', '2011-03-03 09:32:33.437');
INSERT INTO usuario_consulta_documento (doc_id, username, fecha_hora)VALUES ('7','millan', '2011-04-02 14:32:33.437');
INSERT INTO usuario_consulta_documento (doc_id, username, fecha_hora)VALUES ('13','millan', '2011-05-01 10:32:33.437');
INSERT INTO usuario_consulta_documento (doc_id, username, fecha_hora)VALUES ('14','millan', '2011-06-06 15:32:33.437');
INSERT INTO usuario_consulta_documento (doc_id, username, fecha_hora)VALUES ('5','millan', '2010-07-20 21:32:33.437');
INSERT INTO usuario_consulta_documento (doc_id, username, fecha_hora)VALUES ('9','millan', '2011-09-07 12:32:33.437');
INSERT INTO usuario_consulta_documento (doc_id, username, fecha_hora)VALUES ('5','millan', '2011-08-10 18:32:33.437');
INSERT INTO usuario_consulta_documento (doc_id, username, fecha_hora)VALUES ('14','millan', '2011-10-15 17:32:33.437');
INSERT INTO usuario_consulta_documento (doc_id, username, fecha_hora)VALUES ('1','alevalv', '2010-11-21 06:32:33.437');
INSERT INTO usuario_consulta_documento (doc_id, username, fecha_hora)VALUES ('13','alevalv', '2009-12-25 03:32:33.437');
INSERT INTO usuario_consulta_documento (doc_id, username, fecha_hora)VALUES ('5','alevalv', '2011-01-30 13:32:33.437');
INSERT INTO usuario_consulta_documento (doc_id, username, fecha_hora)VALUES ('8','alevalv', '2011-02-04 17:32:33.437');
INSERT INTO usuario_consulta_documento (doc_id, username, fecha_hora)VALUES ('4','alevalv', '2011-03-13 18:32:33.437');
INSERT INTO usuario_consulta_documento (doc_id, username, fecha_hora)VALUES ('5','alevalv', '2011-04-06 01:32:33.437');
INSERT INTO usuario_consulta_documento (doc_id, username, fecha_hora)VALUES ('7','alevalv', '2008-05-09 19:32:33.437');
INSERT INTO usuario_consulta_documento (doc_id, username, fecha_hora)VALUES ('12','alevalv', '2011-06-11 20:32:33.437');
INSERT INTO usuario_descarga_documento (doc_id, username, fecha_hora)VALUES ('12','alevalv', '2011-07-22 18:40:33.437');
INSERT INTO usuario_consulta_documento (doc_id, username, fecha_hora)VALUES ('14','alevalv', '2009-08-11 15:32:33.437');
INSERT INTO usuario_consulta_documento (doc_id, username, fecha_hora)VALUES ('4','alevalv', '2011-09-30 09:32:33.437');
INSERT INTO usuario_descarga_documento (doc_id, username, fecha_hora)VALUES ('4','alevalv', '2011-06-29 13:32:33.437');
INSERT INTO usuario_consulta_documento (doc_id, username, fecha_hora)VALUES ('10','alevalv', '2011-06-28 14:32:33.437');
INSERT INTO usuario_descarga_documento (doc_id, username, fecha_hora)VALUES ('10','alevalv', '2010-09-16 16:32:33.437');
INSERT INTO usuario_descarga_documento (doc_id, username, fecha_hora)VALUES ('2','millan', '2011-06-03 21:32:33.437');
INSERT INTO usuario_descarga_documento (doc_id, username, fecha_hora)VALUES ('3','millan', '2011-01-04 18:32:33.437');
INSERT INTO usuario_descarga_documento (doc_id, username, fecha_hora)VALUES ('4','millan', '2011-03-19 22:32:33.437');
INSERT INTO usuario_descarga_documento (doc_id, username, fecha_hora)VALUES ('5','millan', '2011-04-22 18:32:33.437');
INSERT INTO usuario_descarga_documento (doc_id, username, fecha_hora)VALUES ('6','millan', '2011-05-01 21:32:33.437');
INSERT INTO usuario_descarga_documento (doc_id, username, fecha_hora)VALUES ('5','alevalv', '2011-04-26 19:32:33.437');
INSERT INTO usuario_descarga_documento (doc_id, username, fecha_hora)VALUES ('4','alevalv', '2011-07-03 22:32:33.437');
INSERT INTO usuario_descarga_documento (doc_id, username, fecha_hora)VALUES ('2','millan', '2011-11-06 20:32:33.437');
INSERT INTO usuario_descarga_documento (doc_id, username, fecha_hora)VALUES ('10','millan', '2011-10-20 17:32:33.437');
INSERT INTO usuario_descarga_documento (doc_id, username, fecha_hora)VALUES ('11','alevalv', '2011-12-18 19:32:33.437');

INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('12', 'alevalv');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('50', 'alevalv');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('8', 'alevalv');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('6', 'alevalv');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('3', 'alevalv');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('38', 'alevalv');

INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('24', 'juldarod');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('42', 'juldarod');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('17', 'juldarod');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('38', 'juldarod');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('6', 'juldarod');

INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('48', 'millan');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('47', 'millan');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('12', 'millan');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('19', 'millan');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('21', 'millan');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('15', 'millan');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('11', 'millan');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('38', 'millan');

INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('45', 'mariacbr');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('41', 'mariacbr');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('47', 'mariacbr');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('12', 'mariacbr');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('50', 'mariacbr');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('21', 'mariacbr');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('36', 'mariacbr');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('7', 'mariacbr');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('6', 'mariacbr');

INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('31', 'oswaldo');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('48', 'oswaldo');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('47', 'oswaldo');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('35', 'oswaldo');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('21', 'oswaldo');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('7', 'oswaldo');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('36', 'oswaldo');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('8', 'oswaldo');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('6', 'oswaldo');

INSERT INTO usuarios(username, nombres,  apellidos, password, pregunta_secreta, respuesta_secreta, vinculo_con_univalle, tipo_usuario, correo_electronico, nivel_escolaridad, genero, fecha_nacimiento, fecha_registro) VALUES ('juankv', 'Juan Camilo', 'Vasquez Vizquaino', 'juankv', 'juankv', 'camilovas', 'Pregrado', '3', 'camilovas@gmail.com', 'Bachiller', 'M', '2005-01-01', '2011-06-07 09:37:38.353');

INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('57', 'juankv');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('24', 'juankv');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('53', 'juankv');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('30', 'juankv');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('46', 'juankv');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('6', 'juankv');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('20', 'juankv');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('21', 'juankv');

INSERT INTO usuarios(username, nombres,  apellidos, password, pregunta_secreta, respuesta_secreta, vinculo_con_univalle, tipo_usuario, correo_electronico, nivel_escolaridad, genero, fecha_nacimiento, fecha_registro) VALUES ('Marcelote', 'Marcel', 'Sandoval Patiño', 'marcelote', 'root', 'rootroot', 'Pregrado', '3', 'marcelote@gmail.com', 'Bachiller', 'M', '2005-01-01', '2011-06-07 15:29:11.734');

INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('47', 'Marcelote');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('12', 'Marcelote');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('7', 'Marcelote');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('6', 'Marcelote');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('38', 'Marcelote');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('57', 'Marcelote');

INSERT INTO usuarios(username, nombres,  apellidos, password, pregunta_secreta, respuesta_secreta, vinculo_con_univalle, tipo_usuario, correo_electronico, nivel_escolaridad, genero, fecha_nacimiento, fecha_registro) VALUES ('manubb', 'Manuel', 'Barona Bolivar', 'emo', 'emo', 'emonitor', 'Pregrado', '3', 'manibar@hotmail.com', 'Bachiller', 'M', '2005-01-01', '2011-06-07 15:43:53.091');
INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('47', 'manubb');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('6', 'manubb');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('9', 'manubb');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('33', 'manubb');INSERT INTO usuario_areas_computacion(area_id,username) VALUES ('61', 'manubb');
