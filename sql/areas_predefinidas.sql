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
INSERT INTO areas_computacion VALUES (2, 'Construcción de Aplicaciones Web', '', 1);
INSERT INTO areas_computacion VALUES (3, 'Metodos Numericos Computacionales', '', 0);
INSERT INTO areas_computacion VALUES (4, 'Modelos de Simulación', '', 3);
INSERT INTO areas_computacion VALUES (5, 'Investigación de operaciones', '', 3);
INSERT INTO areas_computacion VALUES (6, 'Ingeniería de Software', '', 0);
INSERT INTO areas_computacion VALUES (7, 'Diseño de software', '', 6);
INSERT INTO areas_computacion VALUES (8,'Gestión de información','',0);
INSERT INTO areas_computacion VALUES (9,'Hipermedia e hipertexto','',8);
INSERT INTO areas_computacion VALUES (10,'Modelo de sistemas de información','',8);
INSERT INTO areas_computacion VALUES (11,'Lenguajes de consulta de bases de datos','',8);
INSERT INTO areas_computacion VALUES (12,'Bibliotecas digitales','',8);
INSERT INTO areas_computacion VALUES (13,'Recuperación de información','',8);
INSERT INTO areas_computacion VALUES (14,'Redes de comunicación','',1);
INSERT INTO areas_computacion VALUES (15,'Diseño físico de bases de datos','',8);
INSERT INTO areas_computacion VALUES (16,'Lenguajes de programación','',0);
INSERT INTO areas_computacion VALUES (17,'Programación orientada a objetos','',16);
INSERT INTO areas_computacion VALUES (18,'Sistemas inteligentes','',0);
INSERT INTO areas_computacion VALUES (19,'Búsqueda por satisfacción de restricciones','',18);
INSERT INTO areas_computacion VALUES (20,'Entornos de desarrollo de software','',6);
INSERT INTO areas_computacion VALUES (21,'Diseño de bases de datos relacionales','',8);
INSERT INTO areas_computacion VALUES (22,'Validación de software','',6);
INSERT INTO areas_computacion VALUES (23,'Computación Web cliente servidor','',1);
INSERT INTO areas_computacion VALUES (24,'Tecnologías multimedia','',1);
INSERT INTO areas_computacion VALUES (25,'Computación inalámbrica','',1);
INSERT INTO areas_computacion VALUES (26,'Procesamiento de lenguaje natural','',18);
INSERT INTO areas_computacion VALUES (27,'Sistemas multimedia','',8);
INSERT INTO areas_computacion VALUES (28,'Fundamentos de programación','',0);
INSERT INTO areas_computacion VALUES (29,'Programación orientada por eventos','',28);
INSERT INTO areas_computacion VALUES (30,'Robótica','',18);
INSERT INTO areas_computacion VALUES (31,'Algoritmos y complejidad','',0);
INSERT INTO areas_computacion VALUES (32,'Algoritmos paralelos','',31);
INSERT INTO areas_computacion VALUES (33,'Interacción humano-computador','',0);
INSERT INTO areas_computacion VALUES (34,'Aspectos de comunicación','',33);
INSERT INTO areas_computacion VALUES (35,'Desarrollo de software centrado en humano','',33);
INSERT INTO areas_computacion VALUES (36,'Diseño de interfaces gráficas de usuario','',33);
INSERT INTO areas_computacion VALUES (37,'Procesamiento de transacciones','',8);
INSERT INTO areas_computacion VALUES (38,'Minería de datos','',8);
INSERT INTO areas_computacion VALUES (39,'Computación visual y gráfica','',0);
INSERT INTO areas_computacion VALUES (40,'Rendering avanzado','',39);
INSERT INTO areas_computacion VALUES (41,'Animación por computador','',39);
INSERT INTO areas_computacion VALUES (42,'Realidad virtual','',39);
INSERT INTO areas_computacion VALUES (43,'Arquitectura y organización','',0);
INSERT INTO areas_computacion VALUES (44,'Arquitectura para redes en sistemas distribuidos','',43);
INSERT INTO areas_computacion VALUES (45,'Análisis numérico','',3);
INSERT INTO areas_computacion VALUES (46,'Modelamiento de datos','',8);
INSERT INTO areas_computacion VALUES (47,'Bases de datos relacionales','',8);
INSERT INTO areas_computacion VALUES (48,'Bases de datos distribuidas','',8);
INSERT INTO areas_computacion VALUES (49,'Seguridad en redes','',1);
INSERT INTO areas_computacion VALUES (50,'Bioinformática','',0);
INSERT INTO areas_computacion VALUES (51,'Estructuras discretas','',0);
INSERT INTO areas_computacion VALUES (52,'Grafos y árboles','',51);
INSERT INTO areas_computacion VALUES (53,'Sistemas de bases de datos','',8);
INSERT INTO areas_computacion VALUES (54,'Representación de conocimiento','',18);
INSERT INTO areas_computacion VALUES (55,'Probabilidad discreta','',51);
INSERT INTO areas_computacion VALUES (56,'Visualización','',39);
INSERT INTO areas_computacion VALUES (57,'Sistemas operativos','',0);
INSERT INTO areas_computacion VALUES (58,'Sistemas en tiempo real','',57);
INSERT INTO areas_computacion VALUES (59,'Tolerancia a fallas','',57);
INSERT INTO areas_computacion VALUES (60,'Algoritmos criptográficos','',31);
INSERT INTO areas_computacion VALUES (61,'Máquinas virtuales','',16);
INSERT INTO areas_computacion VALUES (62,'Programación funcional','',16);
INSERT INTO areas_computacion VALUES (63,'Aprendizaje - Redes neuronales','',18);

ALTER SEQUENCE areas_indice RESTART WITH 64;
