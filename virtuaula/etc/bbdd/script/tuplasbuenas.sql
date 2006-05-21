DELETE FROM isavisos_has_isusuario;
DELETE FROM isficha;
DELETE FROM isusuario;
DELETE FROM isprofesor;
DELETE FROM ishorario_has_isaula;
DELETE FROM ishorario;
DELETE FROM iscurso_has_isalumno;
DELETE FROM iscurso;
DELETE FROM iscontrato;
DELETE FROM isavisos;
DELETE FROM isaula;
DELETE FROM isarea;
DELETE FROM isalumno;


INSERT INTO `isalumno` VALUES ('11111111','Pedro','Ruiz','Santos',914095454,'yotu@hotmail.com','Alcala n 49 2A','04/09/79','Varon');
INSERT INTO `isalumno` VALUES ('22222222','Juan','Sanchez','Sanchez',918569545,'juans@hotmail.com','Avenida de Brasil 12 1C','08/05/90','Varon');
INSERT INTO `isalumno` VALUES ('33333333','Ana','Gonzalez','Garcia',917775264,'anag@hotmail.com','Serrano 12 1C','04/03/89','Mujer');
INSERT INTO `isalumno` VALUES ('44444444','Belen','Gutierrez','Jimenez',912648579,'beleng@gmail.com','Agastia 12 1C','04/04/79','Mujer');
INSERT INTO `isalumno` VALUES ('55555555','Pepe','Gonzalez','Medina',914582564,'pepeg@hotmail.com','Pase del Prado 12 1C','07/07/89','Varon');




INSERT INTO `isarea` VALUES (1,'Tecnologias WEB');
INSERT INTO `isarea` VALUES (2,'Servidores');
INSERT INTO `isarea` VALUES (3,'Programacion');
INSERT INTO `isarea` VALUES (4,'Arquitectura de computadores');
INSERT INTO `isarea` VALUES (5,'Idiomas');




INSERT INTO `isaula` VALUES (1,'aula1',60,'primera planta');
INSERT INTO `isaula` VALUES (2,'aula2',30,'sotano');
INSERT INTO `isaula` VALUES (3,'aula3',45,'primera planta');
INSERT INTO `isaula` VALUES (4,'aula4',20,'planta baja');




INSERT INTO `isavisos` VALUES (1,NULL,NULL,'aviso automatico','Ha sido seleccionado para impartir un curso',NULL);
INSERT INTO `isavisos` VALUES (2,NULL,NULL,'aviso de secretaria','La clase del dia 9 ha sido cancelada',NULL);
INSERT INTO `isavisos` VALUES (3,NULL,NULL,'urgente','Pongase en contacto con la secretaria de la academia lo mas pronto posible',NULL);


INSERT INTO `iscontrato` VALUES ('',0,NULL);



INSERT INTO `iscurso` VALUES (1,'50000000',1,'Dreamweaver',10,'activo',NULL,NULL,300);
INSERT INTO `iscurso` VALUES (2,'51111111',2,'Curso basico de internet',10,'activo',NULL,NULL,150);
INSERT INTO `iscurso` VALUES (3,'52222222',3,'Introduccion a C',5,'activo',NULL,NULL,350);
INSERT INTO `iscurso` VALUES (4,'52222222',3,'Introduccion a Java',20,'inactivo',NULL,NULL,350);



INSERT INTO `iscurso_has_isalumno` VALUES (1,'11111111',10,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (2,'11111111',11,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (3,'22222222',12,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (4,'22222222',13,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (2,'44444444',14,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (5,'44444444',15,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (1,'55555555',16,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (4,'55555555',17,NULL);



INSERT INTO `ishorario` VALUES (1,'M',NULL,'M',NULL,NULL);
INSERT INTO `ishorario` VALUES (2,'T',NULL,'T',NULL,NULL);
INSERT INTO `ishorario` VALUES (3,'T',NULL,'T',NULL,NULL);
INSERT INTO `ishorario` VALUES (4,NULL,NULL,'T','T',NULL);
INSERT INTO `ishorario` VALUES (5,'T','T','T',NULL,NULL);
INSERT INTO `ishorario` VALUES (6,'T',NULL,'T',NULL,'M');
INSERT INTO `ishorario` VALUES (7,'M',NULL,'M',NULL,'M');



INSERT INTO `ishorario_has_isaula` VALUES (1,1,1);
INSERT INTO `ishorario_has_isaula` VALUES (1,2,2);
INSERT INTO `ishorario_has_isaula` VALUES (2,3,3);
INSERT INTO `ishorario_has_isaula` VALUES (7,4,4);



INSERT INTO `isprofesor` VALUES ('50000000',1,'Paquita','Gomez','Gomez',636555555,'Paquita@hotmail.com');
INSERT INTO `isprofesor` VALUES ('51111111',1,'Pepe','Perez','Gomez',6598877,'Pepe@gmail.com');
INSERT INTO `isprofesor` VALUES ('52222222',2,'Paco','Jimenez','Sanchez',6002548,'Paco@gmail.com');
INSERT INTO `isprofesor` VALUES ('53333333',3,'Javi','Sanchez','Gomez',912563548,'Javi@hotmail.com');


INSERT INTO `isusuario` VALUES ('50000000','Gomez','profesor');
INSERT INTO `isusuario` VALUES ('51111111','Perez','profesor');
INSERT INTO `isusuario` VALUES ('52222222','Jimenez','profesor');
INSERT INTO `isusuario` VALUES ('53333333','Sanchez','profesor');
INSERT INTO `isusuario` VALUES ('11111111','11111111','secretaria');
INSERT INTO `isusuario` VALUES ('123','123','secretaria');
INSERT INTO `isusuario` values ('789','789','profesor');
INSERT INTO `isusuario` values ('anonimo','anonimo','publico');

INSERT INTO `isficha` values (10,'5','Falta repetidamente a clase',5.5);
INSERT INTO `isficha` values (11,'8','Va progresando',8.5);
INSERT INTO `isficha` values (12,'5','Necesita mas apoyo',4.5);
INSERT INTO `isficha` values (13,'5','Falta entrega de ejercicios',6.5);
INSERT INTO `isficha` values (14,'5','Entregado trabajo opcional',7);
INSERT INTO `isficha` values (15,'5','Muy activo en clase',9.5);
INSERT INTO `isficha` values (16,'5','Nunca hace los ejercicios',2);
INSERT INTO `isficha` values (17,'5','',5.5);

INSERT INTO `isavisos_has_isusuario` (`ISAVISOS_IDISAVISOS`,`ISUSUARIO_DNI`) values (1,'789'), (2,'789'), (3,'789');
