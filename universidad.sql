-- MySQL dump 10.13  Distrib 5.6.11, for osx10.7 (x86_64)
--
-- Host: localhost    Database: universidad
-- ------------------------------------------------------
-- Server version	5.6.11

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
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumnos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(45) DEFAULT NULL,
  `nombres` varchar(45) DEFAULT NULL,
  `dni` varchar(45) DEFAULT NULL,
  `legajo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,'León','Federico','1234','1234');
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carreras`
--

DROP TABLE IF EXISTS `carreras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carreras` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carreras`
--

LOCK TABLES `carreras` WRITE;
/*!40000 ALTER TABLE `carreras` DISABLE KEYS */;
INSERT INTO `carreras` VALUES (1,'Ingeniería en Software');
/*!40000 ALTER TABLE `carreras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrerasxalumno`
--

DROP TABLE IF EXISTS `carrerasxalumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrerasxalumno` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idCarrera` int(11) NOT NULL,
  `idAlumno` int(11) NOT NULL,
  `fechaRegistro` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idCarrera_UNIQUE` (`idCarrera`,`idAlumno`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrerasxalumno`
--

LOCK TABLES `carrerasxalumno` WRITE;
/*!40000 ALTER TABLE `carrerasxalumno` DISABLE KEYS */;
INSERT INTO `carrerasxalumno` VALUES (1,1,1,NULL);
/*!40000 ALTER TABLE `carrerasxalumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materiasxcarrera`
--

DROP TABLE IF EXISTS `materiasxcarrera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materiasxcarrera` (
  `idMateria` int(10) NOT NULL AUTO_INCREMENT,
  `idCarrera` int(10) NOT NULL,
  `anioDictado` int(10) NOT NULL,
  `semestreDictado` int(10) NOT NULL,
  `nombreMateria` varchar(200) NOT NULL,
  PRIMARY KEY (`idMateria`),
  UNIQUE KEY `anioSemestreId` (`idCarrera`,`anioDictado`,`semestreDictado`,`idMateria`),
  KEY `carrera_idx` (`idCarrera`),
  CONSTRAINT `carrera` FOREIGN KEY (`idCarrera`) REFERENCES `carreras` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiasxcarrera`
--

LOCK TABLES `materiasxcarrera` WRITE;
/*!40000 ALTER TABLE `materiasxcarrera` DISABLE KEYS */;
INSERT INTO `materiasxcarrera` VALUES (1,1,1,1,'Desarrollo emprendedor'),(2,1,1,1,'Herramientas matemáticas I - Álgebra'),(3,1,1,1,'Herramientas matemáticas II - Análisis'),(4,1,1,1,'Idioma Extranjero I'),(5,1,1,1,'Introducción a los algoritmos'),(6,1,1,1,'Sistemas de información'),(7,1,1,2,'Arquitectura del computador'),(8,1,1,2,'Cálculo avanzado'),(9,1,1,2,'Idioma extranjero II'),(10,1,1,2,'Matemática discreta'),(11,1,1,2,'Programación orientada a objetos'),(12,1,2,1,'Algoritmos y estructuras de datos I'),(13,1,2,1,'Grupo y liderazgo'),(14,1,2,1,'Herramientas matemáticas III - Estadística'),(15,1,2,1,'Idioma extranjero III'),(16,1,2,1,'Lógica simbólica'),(17,1,2,1,'Taller de algoritmos y estructuras de datos I'),(18,1,2,2,'Algoritmos y estructuras de datos II'),(19,1,2,2,'Idioma extranjero IV'),(20,1,2,2,'Paradigmas de programación'),(21,1,2,2,'Principios de economía'),(22,1,2,2,'Taller de algoritmos y estructuras de datos II'),(23,1,3,1,'Análisis y diseño de software'),(24,1,3,1,'Herramientas matemáticas V - Estadística II'),(25,1,3,1,'Idioma extranjero V'),(26,1,3,1,'Sistemas operativos'),(27,1,3,1,'Taller de análisis y diseño de software'),(28,1,3,1,'Ética y deontología profesional'),(29,1,3,2,'Bases de datos'),(30,1,3,2,'Idioma extranjero VI'),(31,1,3,2,'Ingeniería de software'),(32,1,3,2,'Seminario de práctica de Analista en software'),(33,1,3,2,'Taller de ingeniería de software'),(34,1,4,1,'Calidad de software'),(35,1,4,1,'Seguridad informática'),(36,1,4,1,'Sistemas operativos II'),(37,1,4,2,'Administración de proyectos'),(38,1,4,2,'Base de datos II'),(39,1,4,2,'Construcción de software'),(40,1,4,2,'Herramientas matemáticas VI - Modelos de simulación'),(41,1,4,2,'Taller de construcción de software'),(42,1,5,1,'Emprendimientos universitarios'),(43,1,5,1,'Métodos formales'),(44,1,5,1,'Práctica profesional de Ingeniería en software'),(45,1,5,1,'Práctica solidaria'),(46,1,5,2,'Seminario final de Ingeniería en software');
/*!40000 ALTER TABLE `materiasxcarrera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dni` int(10) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `ultimoAcceso` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,1234,NULL,'db912be0d7a6ac9ca307d1fb80758bcd',NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-30 20:52:04
