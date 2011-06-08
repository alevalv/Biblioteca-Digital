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

INSERT INTO areas_computacion VALUES (1, 'Computacion centrada en la red', '',0);
INSERT INTO areas_computacion VALUES (2, 'Construccion de Aplicaciones Web', '', 1);
INSERT INTO areas_computacion VALUES (3, 'Metodos Numericos Computacionales', '', 0);
INSERT INTO areas_computacion VALUES (4, 'Modelos de Simulacion', '', 3);
INSERT INTO areas_computacion VALUES (5, 'Investigacion de operaciones', '', 3);
INSERT INTO areas_computacion VALUES (6, 'Ingenieria de Software', '', 0);
INSERT INTO areas_computacion VALUES (7, 'Diseno de software', '', 6);
INSERT INTO areas_computacion VALUES (8,'Gestion de informacion','',0);
INSERT INTO areas_computacion VALUES (9,'Hipermedia e hipertexto','',8);
INSERT INTO areas_computacion VALUES (10,'Modelo de sistemas de informacion','',8);
INSERT INTO areas_computacion VALUES (11,'Lenguajes de consulta de bases de datos','',8);
INSERT INTO areas_computacion VALUES (12,'Bibliotecas digitales','',8);
INSERT INTO areas_computacion VALUES (13,'Recuperacion de informacion','',8);
INSERT INTO areas_computacion VALUES (14,'Redes de comunicacion','',1);
INSERT INTO areas_computacion VALUES (15,'Diseno fisico de bases de datos','',8);
INSERT INTO areas_computacion VALUES (16,'Lenguajes de programacion','',0);
INSERT INTO areas_computacion VALUES (17,'Programacion orientada a objetos','',16);
INSERT INTO areas_computacion VALUES (18,'Sistemas inteligentes','',0);
INSERT INTO areas_computacion VALUES (19,'Busqueda por satisfaccion de restricciones','',18);
INSERT INTO areas_computacion VALUES (20,'Entornos de desarrollo de software','',6);
INSERT INTO areas_computacion VALUES (21,'Diseno de bases de datos relacionales','',8);
INSERT INTO areas_computacion VALUES (22,'Validacion de software','',6);
INSERT INTO areas_computacion VALUES (23,'Computacion Web cliente servidor','',1);
INSERT INTO areas_computacion VALUES (24,'Tecnologias multimedia','',1);
INSERT INTO areas_computacion VALUES (25,'Computacion inalambrica','',1);
INSERT INTO areas_computacion VALUES (26,'Procesamiento de lenguaje natural','',18);
INSERT INTO areas_computacion VALUES (27,'Sistemas multimedia','',8);
INSERT INTO areas_computacion VALUES (28,'Fundamentos de programacion','',0);
INSERT INTO areas_computacion VALUES (29,'Programacion orientada por eventos','',28);
INSERT INTO areas_computacion VALUES (30,'Robotica','',18);
INSERT INTO areas_computacion VALUES (31,'Algoritmos y complejidad','',0);
INSERT INTO areas_computacion VALUES (32,'Algoritmos paralelos','',31);
INSERT INTO areas_computacion VALUES (33,'Interaccion humano-computador','',0);
INSERT INTO areas_computacion VALUES (34,'Aspectos de comunicacion','',33);
INSERT INTO areas_computacion VALUES (35,'Desarrollo de software centrado en humano','',33);
INSERT INTO areas_computacion VALUES (36,'Diseno de interfaces graficas de usuario','',33);
INSERT INTO areas_computacion VALUES (37,'Procesamiento de transacciones','',8);
INSERT INTO areas_computacion VALUES (38,'Mineria de datos','',8);
INSERT INTO areas_computacion VALUES (39,'Computacion visual y grafica','',0);
INSERT INTO areas_computacion VALUES (40,'Rendering avanzado','',39);
INSERT INTO areas_computacion VALUES (41,'Animacion por computador','',39);
INSERT INTO areas_computacion VALUES (42,'Realidad virtual','',39);
INSERT INTO areas_computacion VALUES (43,'Arquitectura y organizacion','',0);
INSERT INTO areas_computacion VALUES (44,'Arquitectura para redes en sistemas distribuidos','',43);
INSERT INTO areas_computacion VALUES (45,'Analisis numerico','',3);
INSERT INTO areas_computacion VALUES (46,'Modelamiento de datos','',8);
INSERT INTO areas_computacion VALUES (47,'Bases de datos relacionales','',8);
INSERT INTO areas_computacion VALUES (48,'Bases de datos distribuidas','',8);
INSERT INTO areas_computacion VALUES (49,'Seguridad en redes','',1);
INSERT INTO areas_computacion VALUES (50,'Bioinformatica','',0);
INSERT INTO areas_computacion VALUES (51,'Estructuras discretas','',0);
INSERT INTO areas_computacion VALUES (52,'Grafos y arboles','',51);
INSERT INTO areas_computacion VALUES (53,'Sistemas de bases de datos','',8);
INSERT INTO areas_computacion VALUES (54,'Representacion de conocimiento','',18);
INSERT INTO areas_computacion VALUES (55,'Probabilidad discreta','',51);
INSERT INTO areas_computacion VALUES (56,'Visualizacion','',39);
INSERT INTO areas_computacion VALUES (57,'Sistemas operativos','',0);
INSERT INTO areas_computacion VALUES (58,'Sistemas en tiempo real','',57);
INSERT INTO areas_computacion VALUES (59,'Tolerancia a fallas','',57);
INSERT INTO areas_computacion VALUES (60,'Algoritmos criptograficos','',31);
INSERT INTO areas_computacion VALUES (61,'Maquinas virtuales','',16);
INSERT INTO areas_computacion VALUES (62,'Programacion funcional','',16);
INSERT INTO areas_computacion VALUES (63,'Aprendizaje - Redes neuronales','',18);

ALTER SEQUENCE areas_indice RESTART WITH 64;
