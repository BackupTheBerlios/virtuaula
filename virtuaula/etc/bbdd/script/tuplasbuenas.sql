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
DELETE FROM isnomina;


INSERT INTO `isalumno` VALUES ('00000000','Pedro','Ruiz','Santos',914095454,'yotu@hotmail.com','Alcala n 49 2A','04/09/79','Varon');
INSERT INTO `isalumno` VALUES ('22222222','Juan','Sanchez','Sanchez',918569545,'juans@hotmail.com','Avenida de Brasil 12 1C','08/05/90','Varon');
INSERT INTO `isalumno` VALUES ('33333333','Ana','Gonzalez','Garcia',917775264,'anag@hotmail.com','Serrano 85 1C','04/03/89','Mujer');
INSERT INTO `isalumno` VALUES ('44444444','Belen','Gutierrez','Jimenez',912648579,'beleng@gmail.com','Agastia 42 1C','04/04/79','Mujer');
INSERT INTO `isalumno` VALUES ('55555555','Pepe','Gonzalez','Medina',914582564,'pepeg@hotmail.com','Paseo del Prado 12 1C','07/07/89','Varon');
INSERT INTO `isalumno` VALUES ('66666666','Paco','Porras','Gomez',914646544,'eloga@hotmail.com','Alcala 212 1C','09/11/90','Varon');
INSERT INTO `isalumno` VALUES ('77777777','Laura','Benitez','Arizmendi',915486434,'lalilohotmail.com','Canillejas 12 1C','25/05/85','Varon');
INSERT INTO `isalumno` VALUES ('88888888','Alberto','Tirado','Solis',915484534,'spaci@hotmail.com','Genova 24 1C','08/12/80','Varon');
INSERT INTO `isalumno` VALUES ('99999999','Daniel','Rodriguez','Manada',914556464,'espai@hotmail.com','Castellana 145 1C','12/07/89','Varon');



INSERT INTO `isarea` VALUES (1,'Tecnologias WEB');
INSERT INTO `isarea` VALUES (2,'Servidores');
INSERT INTO `isarea` VALUES (3,'Programacion');
INSERT INTO `isarea` VALUES (4,'Arquitectura de computadores');
INSERT INTO `isarea` VALUES (5,'Idiomas');
INSERT INTO `isarea` VALUES (6,'Redes');
INSERT INTO `isarea` VALUES (7,'Programacion Avanzada');
INSERT INTO `isarea` VALUES (8,'Lenguajes de programacion');
INSERT INTO `isarea` VALUES (9,'Tecnologia HW');
INSERT INTO `isarea` VALUES (10,'Algoritmia');
INSERT INTO `isarea` VALUES (11,'Sistemas Operativos');



INSERT INTO `isaula` VALUES (1,'aula1',60,'primera planta');
INSERT INTO `isaula` VALUES (2,'aula2',30,'sotano');
INSERT INTO `isaula` VALUES (3,'aula3',45,'primera planta');
INSERT INTO `isaula` VALUES (4,'aula4',20,'planta baja');
INSERT INTO `isaula` VALUES (5,'aula5',60,'primera planta');
INSERT INTO `isaula` VALUES (6,'aula6',30,'sotano');
INSERT INTO `isaula` VALUES (7,'aula7',45,'primera planta');
INSERT INTO `isaula` VALUES (8,'aula8',20,'planta baja');
INSERT INTO `isaula` VALUES (9,'aula9',15,'planta baja');
INSERT INTO `isaula` VALUES (10,'aula10',25,'planta baja');


INSERT INTO `isavisos` VALUES (1,'25/04/06',NULL,'aviso automatico','Ha sido seleccionado para impartir un curso',NULL);
INSERT INTO `isavisos` VALUES (2,'08/04/06',NULL,'aviso de secretaria','La clase del dia 9 ha sido cancelada',NULL);
INSERT INTO `isavisos` VALUES (3,'12/04/06',NULL,'urgente','Pongase en contacto con la secretaria de la academia lo mas pronto posible',NULL);
INSERT INTO `isavisos` VALUES (4,'12/04/06',NULL,'urgente','Pongase en contacto con la secretaria de la academia lo mas pronto posible',NULL);
INSERT INTO `isavisos` VALUES (5,'12/04/06',NULL,'urgente','Pongase en contacto con la secretaria de la academia lo mas pronto posible',NULL);
INSERT INTO `isavisos` VALUES (6,'12/04/06',NULL,'urgente','Pongase en contacto con la secretaria de la academia lo mas pronto posible',NULL);
INSERT INTO `isavisos` VALUES (7,'12/04/06',NULL,'urgente','Pongase en contacto con la secretaria de la academia lo mas pronto posible',NULL);
INSERT INTO `isavisos` VALUES (8,'12/04/06',NULL,'urgente','Pongase en contacto con la secretaria de la academia lo mas pronto posible',NULL);



INSERT INTO `iscontrato` VALUES ('51111111',1,'fijo');
INSERT INTO `iscontrato` VALUES ('52222222',2,'beca de colaboracion');
INSERT INTO `iscontrato` VALUES ('53333333',3,'fijo');
INSERT INTO `iscontrato` VALUES ('50000000',4,'por obra y servicio');
INSERT INTO `iscontrato` VALUES ('54444444',1,'fijo');
INSERT INTO `iscontrato` VALUES ('89898989',7,'fijo');
INSERT INTO `iscontrato` VALUES ('56666666',6,'temporal');
INSERT INTO `iscontrato` VALUES ('57777777',4,'por obra y servicio');
INSERT INTO `iscontrato` VALUES ('58888888',5,'fijo');
INSERT INTO `iscontrato` VALUES ('59999999',6,'temporal');
INSERT INTO `iscontrato` VALUES ('78787878',7,'fijo');




INSERT INTO `isnomina` VALUES (1,'346736734345','1600');
INSERT INTO `isnomina` VALUES (2,'235683632224','900');
INSERT INTO `isnomina` VALUES (3,'667835673567','1100');
INSERT INTO `isnomina` VALUES (4,'236256256262','1200');
INSERT INTO `isnomina` VALUES (5,'235683632224','950');
INSERT INTO `isnomina` VALUES (6,'532466234562','1800');
INSERT INTO `isnomina` VALUES (7,'236253456262','1300');





INSERT INTO `iscurso` VALUES (1,'50000000',1,'Dreamweaver',10,'activo','01/08/06','15/02/07',300);
INSERT INTO `iscurso` VALUES (2,'51111111',2,'Curso basico de internet',10,'activo','01/08/06','05/02/07',150);
INSERT INTO `iscurso` VALUES (3,'52222222',8,'Introduccion a C',5,'activo','01/08/06','05/02/07',350);
INSERT INTO `iscurso` VALUES (4,'53333333',8,'Introduccion a Java',20,'inactivo','01/08/06','05/02/07',350);
INSERT INTO `iscurso` VALUES (5,'54444444',8,'Introduccion a C',5,'activo','01/08/06','05/02/07',350);
INSERT INTO `iscurso` VALUES (6,'56666666',8,'Java avanzado',5,'activo','01/08/06','05/02/07',850);
INSERT INTO `iscurso` VALUES (7,'57777777',8,'Java principiantes',5,'inactivo','01/08/05','05/02/06',850);
INSERT INTO `iscurso` VALUES (8,'58888888',6,'Redes',5,'activo','01/08/06','05/02/07',250);
INSERT INTO `iscurso` VALUES (9,'59999999',11,'Linux',5,'activo','01/08/06','05/02/07',180);


INSERT INTO `iscurso_has_isalumno` VALUES (1,'00000000',10,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (2,'00000000',11,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (3,'22222222',12,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (4,'22222222',13,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (2,'44444444',14,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (5,'44444444',15,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (1,'55555555',16,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (4,'55555555',17,NULL);

INSERT INTO `iscurso_has_isalumno` VALUES (6,'66666666',18,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (9,'66666666',19,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (8,'77777777',20,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (9,'77777777',21,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (8,'88888888',22,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (9,'88888888',23,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (5,'99999999',24,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (6,'99999999',25,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (9,'00000000',26,NULL);
INSERT INTO `iscurso_has_isalumno` VALUES (3,'00000000',27,NULL);



INSERT INTO `ishorario` VALUES (1,'M',NULL,'M',NULL,NULL);
INSERT INTO `ishorario` VALUES (2,'T',NULL,'T',NULL,NULL);
INSERT INTO `ishorario` VALUES (3,'T',NULL,'T','M',NULL);
INSERT INTO `ishorario` VALUES (4,NULL,NULL,'T','T',NULL);
INSERT INTO `ishorario` VALUES (5,'T','T','T',NULL,NULL);
INSERT INTO `ishorario` VALUES (6,'T',NULL,'T',NULL,'M');
INSERT INTO `ishorario` VALUES (7,'M','T','M',NULL,'M');
INSERT INTO `ishorario` VALUES (8,'M',NULL,'M',NULL,NULL);
INSERT INTO `ishorario` VALUES (9,'T',NULL,'T','M',NULL);
INSERT INTO `ishorario` VALUES (10,'T','M','T',NULL,'M');
INSERT INTO `ishorario` VALUES (11,'M',NULL,'T','T',NULL);
INSERT INTO `ishorario` VALUES (12,'T','T','T',NULL,NULL);
INSERT INTO `ishorario` VALUES (13,'T',NULL,'T','M','M');
INSERT INTO `ishorario` VALUES (14,'M',NULL,'M',NULL,'M');



INSERT INTO `ishorario_has_isaula` VALUES (1,1,1);
INSERT INTO `ishorario_has_isaula` VALUES (1,2,2);
INSERT INTO `ishorario_has_isaula` VALUES (2,3,3);
INSERT INTO `ishorario_has_isaula` VALUES (7,4,4);

INSERT INTO `ishorario_has_isaula` VALUES (2,5,5);
INSERT INTO `ishorario_has_isaula` VALUES (3,6,6);
INSERT INTO `ishorario_has_isaula` VALUES (4,7,7);
INSERT INTO `ishorario_has_isaula` VALUES (5,8,8);
INSERT INTO `ishorario_has_isaula` VALUES (6,9,9);



INSERT INTO `isprofesor` VALUES ('50000000',1,'Paquita','Gomez','Gomez',636555555,'Paquita@hotmail.com');
INSERT INTO `isprofesor` VALUES ('51111111',2,'Pepe','Perez','Gomez',6598877,'Pepe@gmail.com');
INSERT INTO `isprofesor` VALUES ('52222222',2,'Paco','Jimenez','Sanchez',6002548,'Paco@gmail.com');
INSERT INTO `isprofesor` VALUES ('53333333',3,'Javi','Sanchez','Gomez',912563548,'Javi@hotmail.com');
INSERT INTO `isprofesor` VALUES ('54444444',1,'Paquita','Gomez','Gomez',636555555,'Paquita@hotmail.com');
INSERT INTO `isprofesor` VALUES ('89898989',3,'Pepe','Perez','Gomez',6598877,'Pepe157@gmail.com');
INSERT INTO `isprofesor` VALUES ('56666666',6,'Paco','Jimenez','Sanchez',917645648,'loriy@gmail.com');
INSERT INTO `isprofesor` VALUES ('57777777',7,'Alberto','Sanchez','Helm',912456548,'alty@hotmail.com');
INSERT INTO `isprofesor` VALUES ('58888888',8,'Jorge','Alvarez','Vlissides',912843548,'pleoa@hotmail.com');
INSERT INTO `isprofesor` VALUES ('59999999',5,'Daniel','Seneca','Gamma',918863588,'plirti@hotmail.com');
INSERT INTO `isprofesor` VALUES ('78787878',8,'Sergio','Benitez','Wesley',915235648,'laurity@hotmail.com');
INSERT INTO `isprofesor` VALUES ('789',6,'David','Sanz','Escobar',916546468,'lelorai@hotmail.com');

INSERT INTO `isusuario` VALUES ('50000000','Gomez','profesor');
INSERT INTO `isusuario` VALUES ('51111111','Perez','profesor');
INSERT INTO `isusuario` VALUES ('52222222','Jimenez','profesor');
INSERT INTO `isusuario` VALUES ('53333333','Sanchez','profesor');
INSERT INTO `isusuario` VALUES ('54444444','123','profesor');
INSERT INTO `isusuario` VALUES ('89898989','123','profesor');
INSERT INTO `isusuario` VALUES ('56666666','123','profesor');
INSERT INTO `isusuario` VALUES ('57777777','123','profesor');
INSERT INTO `isusuario` VALUES ('58888888','123','profesor');
INSERT INTO `isusuario` VALUES ('59999999','123','profesor');
INSERT INTO `isusuario` VALUES ('78787878','123','profesor');
INSERT INTO `isusuario` VALUES ('11111111','11111111','secretaria');
INSERT INTO `isusuario` VALUES ('123','123','secretaria');
INSERT INTO `isusuario` values ('789','789','profesor');
INSERT INTO `isusuario` values ('anonimo','anonimo','publico');
INSERT INTO `isusuario` values ('000','000','contable');
INSERT INTO `isusuario` values ('111','111','rrhh');
INSERT INTO `isusuario` values ('00000000','111','alumno');
INSERT INTO `isusuario` values ('22222222','111','alumno');
INSERT INTO `isusuario` values ('33333333','111','alumno');
INSERT INTO `isusuario` values ('44444444','111','alumno');
INSERT INTO `isusuario` values ('55555555','111','alumno');
INSERT INTO `isusuario` values ('66666666','111','alumno');
INSERT INTO `isusuario` values ('77777777','111','alumno');
INSERT INTO `isusuario` values ('88888888','111','alumno');
INSERT INTO `isusuario` values ('99999999','111','alumno');



INSERT INTO `isficha` values (10,'5','Falta repetidamente a clase',5.5);
INSERT INTO `isficha` values (11,'8','Va progresando',8.5);
INSERT INTO `isficha` values (12,'5','Necesita mas apoyo',4.5);
INSERT INTO `isficha` values (13,'5','Falta entrega de ejercicios',6.5);
INSERT INTO `isficha` values (14,'5','Entregado trabajo opcional',7);
INSERT INTO `isficha` values (15,'6','Muy activo en clase',9.5);
INSERT INTO `isficha` values (16,'7','Nunca hace los ejercicios',2);
INSERT INTO `isficha` values (17,'8','No entrega los ejercicios',6);
INSERT INTO `isficha` values (18,'4','No va a clase',8);
INSERT INTO `isficha` values (19,'7','Habla mucho en clase',3);
INSERT INTO `isficha` values (20,'9','Me cae mal',9);
INSERT INTO `isficha` values (21,'9','Es un genio',5.5);
INSERT INTO `isficha` values (22,'5','Falta repetidamente a clase',5.5);
INSERT INTO `isficha` values (23,'8','Va progresando',8.5);
INSERT INTO `isficha` values (24,'9','Necesita mas apoyo',4.5);
INSERT INTO `isficha` values (25,'5','Falta entrega de ejercicios',6.5);
INSERT INTO `isficha` values (26,'3','Entregado trabajo opcional',7);
INSERT INTO `isficha` values (27,'8','Muy activo en clase',9.5);

INSERT INTO `isavisos_has_isusuario` (`ISAVISOS_IDISAVISOS`,`ISUSUARIO_DNI`) values (1,'789'), (2,'789'), (3,'789');
INSERT INTO `isavisos_has_isusuario` (`ISAVISOS_IDISAVISOS`,`ISUSUARIO_DNI`) values (4,'54444444');
INSERT INTO `isavisos_has_isusuario` (`ISAVISOS_IDISAVISOS`,`ISUSUARIO_DNI`) values (5,'58888888');
INSERT INTO `isavisos_has_isusuario` (`ISAVISOS_IDISAVISOS`,`ISUSUARIO_DNI`) values (6,'53333333');
INSERT INTO `isavisos_has_isusuario` (`ISAVISOS_IDISAVISOS`,`ISUSUARIO_DNI`) values (7,'50000000');
INSERT INTO `isavisos_has_isusuario` (`ISAVISOS_IDISAVISOS`,`ISUSUARIO_DNI`) values (8,'52222222');
