-- MySQL dump 10.10
--
-- Host: localhost    Database: prueba
-- ------------------------------------------------------
-- Server version	5.0.19-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `isalumno`
--

DROP TABLE IF EXISTS `isalumno`;
CREATE TABLE `isalumno` (
  `ISUSUARIO_DNI` varchar(9) NOT NULL,
  `NOMBRE` varchar(40) NOT NULL,
  `APELLIDO1` varchar(40) NOT NULL,
  `APELLIDO2` varchar(40) NOT NULL,
  `TELEFONO` int(9) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `DIRECCION` varchar(100) default NULL,
  `FECH_NACIMIENTO` varchar(20) default NULL,
  `SEXO` char(1) default NULL,
  PRIMARY KEY  (`ISUSUARIO_DNI`),
  KEY `ISALUMNO_FKIndex1` (`ISUSUARIO_DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `isalumno`
--


/*!40000 ALTER TABLE `isalumno` DISABLE KEYS */;
LOCK TABLES `isalumno` WRITE;
INSERT INTO `isalumno` VALUES ('46','caccota','po','pi',91409,'yotu','caca','12','m'),('50','paco','po','pi',91409,'yotu','caca','12','m'),('508556698','ramon','sanchez','perez',915524859,'mio@yo.com','calle poez','06/08/5897','M'),('51','pepito','po','pi',91409,'yotu','caca','12','m');
UNLOCK TABLES;
/*!40000 ALTER TABLE `isalumno` ENABLE KEYS */;

--
-- Table structure for table `isarea`
--

DROP TABLE IF EXISTS `isarea`;
CREATE TABLE `isarea` (
  `IDISAREA` int(10) unsigned NOT NULL auto_increment,
  `NOMBRE` varchar(100) default NULL,
  PRIMARY KEY  (`IDISAREA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `isarea`
--


/*!40000 ALTER TABLE `isarea` DISABLE KEYS */;
LOCK TABLES `isarea` WRITE;
INSERT INTO `isarea` VALUES (1040,'topotamad'),(1400,'jandepor');
UNLOCK TABLES;
/*!40000 ALTER TABLE `isarea` ENABLE KEYS */;

--
-- Table structure for table `isaula`
--

DROP TABLE IF EXISTS `isaula`;
CREATE TABLE `isaula` (
  `IDISAULA` int(10) unsigned NOT NULL auto_increment,
  `NOMBRE` varchar(50) default NULL,
  `CAPACIDAD` int(10) unsigned default NULL,
  `LOCALIZACION` varchar(100) default NULL,
  PRIMARY KEY  (`IDISAULA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `isaula`
--


/*!40000 ALTER TABLE `isaula` DISABLE KEYS */;
LOCK TABLES `isaula` WRITE;
INSERT INTO `isaula` VALUES (1,NULL,NULL,NULL),(5,'ocupada',32,'alli'),(1000,'aulatopotamad',45,NULL),(20000000,NULL,NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `isaula` ENABLE KEYS */;

--
-- Table structure for table `isavisos`
--

DROP TABLE IF EXISTS `isavisos`;
CREATE TABLE `isavisos` (
  `IDISAVISOS` int(10) unsigned NOT NULL auto_increment,
  `FECHA_AVISO` varchar(20) default NULL,
  `FECHA_CADUCIDAD` varchar(20) default NULL,
  `ASUNTO` varchar(255) default NULL,
  `TEXTO` varchar(255) default NULL,
  `ACTIVO` char(1) default NULL,
  PRIMARY KEY  (`IDISAVISOS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `isavisos`
--


/*!40000 ALTER TABLE `isavisos` DISABLE KEYS */;
LOCK TABLES `isavisos` WRITE;
INSERT INTO `isavisos` VALUES (1400,NULL,NULL,'cambiado',NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `isavisos` ENABLE KEYS */;

--
-- Table structure for table `isavisos_has_isusuario`
--

DROP TABLE IF EXISTS `isavisos_has_isusuario`;
CREATE TABLE `isavisos_has_isusuario` (
  `ISAVISOS_IDISAVISOS` int(10) unsigned NOT NULL,
  `ISUSUARIO_DNI` varchar(9) NOT NULL,
  PRIMARY KEY  (`ISAVISOS_IDISAVISOS`,`ISUSUARIO_DNI`),
  KEY `ISAVISOS_has_ISUSUARIO_FKIndex1` (`ISAVISOS_IDISAVISOS`),
  KEY `ISAVISOS_has_ISUSUARIO_FKIndex2` (`ISUSUARIO_DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `isavisos_has_isusuario`
--


/*!40000 ALTER TABLE `isavisos_has_isusuario` DISABLE KEYS */;
LOCK TABLES `isavisos_has_isusuario` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `isavisos_has_isusuario` ENABLE KEYS */;

--
-- Table structure for table `iscontrato`
--

DROP TABLE IF EXISTS `iscontrato`;
CREATE TABLE `iscontrato` (
  `ISUSUARIO_DNI` varchar(9) NOT NULL,
  `ISNOMINA_IDISNOMINA` int(10) unsigned NOT NULL,
  `TIPO` varchar(200) default NULL,
  PRIMARY KEY  (`ISUSUARIO_DNI`),
  KEY `ISCONTRATO_FKIndex1` (`ISUSUARIO_DNI`),
  KEY `ISCONTRATO_FKIndex2` (`ISNOMINA_IDISNOMINA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `iscontrato`
--


/*!40000 ALTER TABLE `iscontrato` DISABLE KEYS */;
LOCK TABLES `iscontrato` WRITE;
INSERT INTO `iscontrato` VALUES ('',0,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `iscontrato` ENABLE KEYS */;

--
-- Table structure for table `iscurso`
--

DROP TABLE IF EXISTS `iscurso`;
CREATE TABLE `iscurso` (
  `IDISCURSO` int(10) unsigned NOT NULL auto_increment,
  `ISPROFESOR_ISUSUARIO_DNI` varchar(9) NOT NULL,
  `ISAREA_IDISAREA` int(10) unsigned NOT NULL,
  `NOMBRE` varchar(50) default NULL,
  `NUMERO_PLAZAS` int(10) unsigned default NULL,
  `ESTADO` varchar(20) default NULL,
  `FECHA_INICIO` varchar(20) default NULL,
  `FECHA_FIN` varchar(20) default NULL,
  `PRECIO` float default NULL,
  PRIMARY KEY  (`IDISCURSO`),
  KEY `ISCURSO_FKIndex2` (`ISAREA_IDISAREA`),
  KEY `ISCURSO_FKIndex3` (`ISPROFESOR_ISUSUARIO_DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `iscurso`
--


/*!40000 ALTER TABLE `iscurso` DISABLE KEYS */;
LOCK TABLES `iscurso` WRITE;
INSERT INTO `iscurso` VALUES (2,'50000000',3,'bien',NULL,'activo',NULL,NULL,NULL),(1400,'50000000',1500,'papanatas',10,NULL,NULL,NULL,NULL),(1401,'52',1450,'topota',5,'yes','nor','per',1000);
UNLOCK TABLES;
/*!40000 ALTER TABLE `iscurso` ENABLE KEYS */;

--
-- Table structure for table `iscurso_has_isalumno`
--

DROP TABLE IF EXISTS `iscurso_has_isalumno`;
CREATE TABLE `iscurso_has_isalumno` (
  `ISCURSO_IDISCURSO` int(10) unsigned NOT NULL,
  `ISALUMNO_ISUSUARIO_DNI` varchar(9) NOT NULL,
  `ISFICHA_IDISFICHA` int(10) unsigned NOT NULL,
  `NOTA_FINAL` float default NULL,
  PRIMARY KEY  (`ISCURSO_IDISCURSO`,`ISALUMNO_ISUSUARIO_DNI`),
  KEY `ISCURSO_has_ISALUMNO_FKIndex1` (`ISCURSO_IDISCURSO`),
  KEY `ISCURSO_has_ISALUMNO_FKIndex2` (`ISALUMNO_ISUSUARIO_DNI`),
  KEY `ISCURSO_HAS_ISALUMNO_FKIndex3` (`ISFICHA_IDISFICHA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `iscurso_has_isalumno`
--


/*!40000 ALTER TABLE `iscurso_has_isalumno` DISABLE KEYS */;
LOCK TABLES `iscurso_has_isalumno` WRITE;
INSERT INTO `iscurso_has_isalumno` VALUES (2,'50',10,0),(2,'51',10,0),(1400,'508556698',14,0.5);
UNLOCK TABLES;
/*!40000 ALTER TABLE `iscurso_has_isalumno` ENABLE KEYS */;

--
-- Table structure for table `isficha`
--

DROP TABLE IF EXISTS `isficha`;
CREATE TABLE `isficha` (
  `IDISFICHA` int(10) unsigned NOT NULL auto_increment,
  `NOTAS` varchar(255) default NULL,
  `ANOTACIONES` varchar(255) default NULL,
  `NOTAS_EJERCICIOS` float default NULL,
  PRIMARY KEY  (`IDISFICHA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `isficha`
--


/*!40000 ALTER TABLE `isficha` DISABLE KEYS */;
LOCK TABLES `isficha` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `isficha` ENABLE KEYS */;

--
-- Table structure for table `ishorario`
--

DROP TABLE IF EXISTS `ishorario`;
CREATE TABLE `ishorario` (
  `IDISHORARIO` int(10) unsigned NOT NULL auto_increment,
  `LUNES` varchar(10) default NULL,
  `MARTES` varchar(10) default NULL,
  `MIERCOLES` varchar(10) default NULL,
  `JUEVES` varchar(10) default NULL,
  `VIERNES` varchar(10) default NULL,
  PRIMARY KEY  (`IDISHORARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ishorario`
--


/*!40000 ALTER TABLE `ishorario` DISABLE KEYS */;
LOCK TABLES `ishorario` WRITE;
INSERT INTO `ishorario` VALUES (100,'M',NULL,'M',NULL,NULL),(400,'M',NULL,'M',NULL,NULL),(1000,'B',NULL,'B',NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `ishorario` ENABLE KEYS */;

--
-- Table structure for table `ishorario_has_isaula`
--

DROP TABLE IF EXISTS `ishorario_has_isaula`;
CREATE TABLE `ishorario_has_isaula` (
  `ISHORARIO_IDISHORARIO` int(10) unsigned NOT NULL,
  `ISAULA_IDISAULA` int(10) unsigned NOT NULL,
  `ISCURSO_IDISCURSO` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`ISHORARIO_IDISHORARIO`,`ISAULA_IDISAULA`),
  KEY `ISHORARIO_has_ISAULA_FKIndex1` (`ISHORARIO_IDISHORARIO`),
  KEY `ISHORARIO_has_ISAULA_FKIndex2` (`ISAULA_IDISAULA`),
  KEY `ISHORARIO_has_ISAULA_FKIndex3` (`ISCURSO_IDISCURSO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ishorario_has_isaula`
--


/*!40000 ALTER TABLE `ishorario_has_isaula` DISABLE KEYS */;
LOCK TABLES `ishorario_has_isaula` WRITE;
INSERT INTO `ishorario_has_isaula` VALUES (100,5,2),(1,3,1400),(100,1,1400),(111111,222222,3333333);
UNLOCK TABLES;
/*!40000 ALTER TABLE `ishorario_has_isaula` ENABLE KEYS */;

--
-- Table structure for table `isnomina`
--

DROP TABLE IF EXISTS `isnomina`;
CREATE TABLE `isnomina` (
  `IDISNOMINA` int(10) unsigned NOT NULL auto_increment,
  `CUENTA_INGRESOS` varchar(30) default NULL,
  `CANTIDAD` float default NULL,
  PRIMARY KEY  (`IDISNOMINA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `isnomina`
--


/*!40000 ALTER TABLE `isnomina` DISABLE KEYS */;
LOCK TABLES `isnomina` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `isnomina` ENABLE KEYS */;

--
-- Table structure for table `isprofesor`
--

DROP TABLE IF EXISTS `isprofesor`;
CREATE TABLE `isprofesor` (
  `ISUSUARIO_DNI` varchar(9) NOT NULL,
  `ISAREA_IDISAREA` int(10) unsigned NOT NULL,
  `NOMBRE` varchar(40) default NULL,
  `APELLIDO1` varchar(40) default NULL,
  `APELLIDO2` varchar(40) default NULL,
  `TELEFONO` int(9) default NULL,
  `EMAIL` varchar(50) default NULL,
  PRIMARY KEY  (`ISUSUARIO_DNI`),
  KEY `ISPROFESOR_FKIndex1` (`ISUSUARIO_DNI`),
  KEY `ISPROFESOR_FKIndex2` (`ISAREA_IDISAREA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `isprofesor`
--


/*!40000 ALTER TABLE `isprofesor` DISABLE KEYS */;
LOCK TABLES `isprofesor` WRITE;
INSERT INTO `isprofesor` VALUES ('50000000',1400,'paquita',NULL,NULL,NULL,NULL),('50878552',1400,'pepe','perez','gomez',45,'yo');
UNLOCK TABLES;
/*!40000 ALTER TABLE `isprofesor` ENABLE KEYS */;

--
-- Table structure for table `isusuario`
--

DROP TABLE IF EXISTS `isusuario`;
CREATE TABLE `isusuario` (
  `DNI` varchar(9) NOT NULL,
  `CONTRASENIA` varchar(20) default NULL,
  `PERFIL` varchar(10) default NULL,
  PRIMARY KEY  (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `isusuario`
--


/*!40000 ALTER TABLE `isusuario` DISABLE KEYS */;
LOCK TABLES `isusuario` WRITE;
INSERT INTO `isusuario` VALUES ('50000000','password','alumno'),('50100000','',''),('51100000','','putilla'),('52100000','','putilla'),('null','passwordo','');
UNLOCK TABLES;
/*!40000 ALTER TABLE `isusuario` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

