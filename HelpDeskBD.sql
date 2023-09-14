CREATE DATABASE  IF NOT EXISTS `helpdesk` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `helpdesk`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: helpdesk
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `areaprob`
--

DROP TABLE IF EXISTS `areaprob`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `areaprob` (
  `idAreaProb` int NOT NULL,
  `AreaProb` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idAreaProb`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areaprob`
--

LOCK TABLES `areaprob` WRITE;
/*!40000 ALTER TABLE `areaprob` DISABLE KEYS */;
INSERT INTO `areaprob` VALUES (0,'<Seleccione>'),(1,'Planta'),(2,'Contabilidad'),(3,'Marcas'),(4,'Bodega'),(5,'Corte'),(6,'RRHH'),(7,'Calidad');
/*!40000 ALTER TABLE `areaprob` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avances`
--

DROP TABLE IF EXISTS `avances`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avances` (
  `idAvances` int NOT NULL,
  `Avance` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `idAvanceProb` int NOT NULL,
  `FechaAvance` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `RefEstado` int NOT NULL,
  PRIMARY KEY (`idAvances`),
  KEY `idProblema_FK_idx` (`idAvanceProb`),
  CONSTRAINT `idProblema_FK` FOREIGN KEY (`idAvanceProb`) REFERENCES `problema` (`idProblema`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avances`
--

LOCK TABLES `avances` WRITE;
/*!40000 ALTER TABLE `avances` DISABLE KEYS */;
/*!40000 ALTER TABLE `avances` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `idEstado` int NOT NULL,
  `Estado` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (0,'Pendiente'),(1,'En Proceso'),(2,'Resuelto');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filtro`
--

DROP TABLE IF EXISTS `filtro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `filtro` (
  `idFiltro` int NOT NULL,
  `Filtro` varchar(45) NOT NULL,
  PRIMARY KEY (`idFiltro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filtro`
--

LOCK TABLES `filtro` WRITE;
/*!40000 ALTER TABLE `filtro` DISABLE KEYS */;
INSERT INTO `filtro` VALUES (0,'<Seleccione>'),(1,'Area'),(2,'Estado');
/*!40000 ALTER TABLE `filtro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `idPersona` int NOT NULL,
  `CorreoPersona` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Cookie 1286 <iiklygamer89@gmail.com>'),(2,'Camilo Hurtado <camilohurtado256@gmail.com>'),(3,'SOAC Renovado <soacrenovado@gmail.com>'),(4,'Cookie 1286 <iiklygamer89@gmail.com>'),(5,'Camilo Hurtado <camilohurtado256@gmail.com>'),(6,'Cookieguy 1206 <camilohurtado982@gmail.com>'),(7,'Cookieguy 1206 <camilohurtado982@gmail.com>');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prioridad`
--

DROP TABLE IF EXISTS `prioridad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prioridad` (
  `idPrioridad` int NOT NULL,
  `Prioridad` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idPrioridad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prioridad`
--

LOCK TABLES `prioridad` WRITE;
/*!40000 ALTER TABLE `prioridad` DISABLE KEYS */;
INSERT INTO `prioridad` VALUES (0,'<Seleccione>'),(1,'Alta'),(2,'Media'),(3,'Baja');
/*!40000 ALTER TABLE `prioridad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `problema`
--

DROP TABLE IF EXISTS `problema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `problema` (
  `idProblema` int NOT NULL,
  `NombreProb` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `DetalleProb` varchar(300) COLLATE utf8mb4_general_ci NOT NULL,
  `FechaCreacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `RefIdPrioridad` int NOT NULL DEFAULT '0',
  `RefAreaProb` int NOT NULL DEFAULT '0',
  `RefTipoProb` int NOT NULL DEFAULT '0',
  `RefSTipoProb` int NOT NULL DEFAULT '0',
  `RefSSTipoProb` int NOT NULL DEFAULT '0',
  `RefEstado` int NOT NULL DEFAULT '0',
  `RefPersona` int NOT NULL DEFAULT '1',
  `RefSolucion` int NOT NULL,
  `RefAvances` int NOT NULL,
  `Imagen` varchar(700) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idProblema`),
  KEY `idPrioridad_FK_idx` (`RefIdPrioridad`),
  KEY `idTipoProb_FK_idx` (`RefTipoProb`),
  KEY `idEstado_FK_idx` (`RefEstado`),
  KEY `idPersona_FK_idx` (`RefPersona`),
  KEY `idSTipoProb_FK_idx` (`RefSTipoProb`),
  KEY `idSSTipoProb_FK_idx` (`RefSSTipoProb`),
  KEY `idImagen_FK_idx` (`Imagen`),
  CONSTRAINT `idEstado_FK` FOREIGN KEY (`RefEstado`) REFERENCES `estado` (`idEstado`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idPersona_FK` FOREIGN KEY (`RefPersona`) REFERENCES `persona` (`idPersona`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idPrioridad_FK` FOREIGN KEY (`RefIdPrioridad`) REFERENCES `prioridad` (`idPrioridad`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idSSTipoProb_FK` FOREIGN KEY (`RefSSTipoProb`) REFERENCES `sstipoprob` (`idSSTipoProb`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idSTipoProb_FK` FOREIGN KEY (`RefSTipoProb`) REFERENCES `stipoprob` (`idSTipoProb`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idTipoProb_FK` FOREIGN KEY (`RefTipoProb`) REFERENCES `tipoprob` (`idTipoProb`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problema`
--

LOCK TABLES `problema` WRITE;
/*!40000 ALTER TABLE `problema` DISABLE KEYS */;
INSERT INTO `problema` VALUES (2,'ERP','Hay problemas con el ERP\r\n','2020-12-02 19:32:11',0,0,0,0,0,0,1,2,1,'No Imagen'),(4,'Problemas con Gmail','Hay problemas con Gmail\r\n','2020-12-02 19:32:13',0,0,0,0,0,0,2,4,1,'C:\\Users\\admon\\Documents\\NetBeansProjects\\CRUD_Escuela\\Ruta\\Screenshot_2020-11-27-12-39-37-716_com.google.android.gm.jpg'),(6,'Prueba sin imagen','Sin imagen\r\n','2020-12-02 19:32:16',0,0,0,0,0,0,3,6,1,'No Imagen'),(8,'Prueba sin imagen','Sin imagen\r\n','2020-12-02 19:32:18',0,0,0,0,0,0,4,8,1,'No Imagen'),(10,'Prueba con imagen','Imagen\r\n','2020-12-02 19:32:19',0,0,0,0,0,0,5,10,1,'C:\\Users\\admon\\Documents\\NetBeansProjects\\CRUD_Escuela\\Ruta\\Screenshot_2020-11-30-12-54-33-907_com.supercell.brawlstars.jpg'),(12,'Prueba sin imagen','Sin imagen\r\n','2020-12-02 19:32:25',0,0,0,0,0,0,6,12,1,'No Imagen'),(14,'Prueba con imagen','Imagen\r\n','2020-12-02 19:32:26',0,0,0,0,0,0,7,14,1,'C:\\Users\\admon\\Documents\\NetBeansProjects\\CRUD_Escuela\\Ruta\\Screenshot_2020-11-28-17-48-49-701_com.android.chrome.jpg');
/*!40000 ALTER TABLE `problema` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `Audit_Prob_Sol` AFTER INSERT ON `problema` FOR EACH ROW INSERT INTO Soluciones(idSolucion, Solucion) VALUES (NEW.RefSolucion, '') */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `soluciones`
--

DROP TABLE IF EXISTS `soluciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `soluciones` (
  `idSolucion` int NOT NULL,
  `Solucion` varchar(45) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`idSolucion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soluciones`
--

LOCK TABLES `soluciones` WRITE;
/*!40000 ALTER TABLE `soluciones` DISABLE KEYS */;
INSERT INTO `soluciones` VALUES (2,''),(4,''),(6,''),(8,''),(10,''),(12,''),(14,'');
/*!40000 ALTER TABLE `soluciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sstipoprob`
--

DROP TABLE IF EXISTS `sstipoprob`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sstipoprob` (
  `idSSTipoProb` int NOT NULL,
  `SSTipoProb` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idSSTipoProb`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sstipoprob`
--

LOCK TABLES `sstipoprob` WRITE;
/*!40000 ALTER TABLE `sstipoprob` DISABLE KEYS */;
INSERT INTO `sstipoprob` VALUES (0,'<Seleccione>');
/*!40000 ALTER TABLE `sstipoprob` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stipoprob`
--

DROP TABLE IF EXISTS `stipoprob`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stipoprob` (
  `idSTipoProb` int NOT NULL,
  `STipoProb` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idSTipoProb`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stipoprob`
--

LOCK TABLES `stipoprob` WRITE;
/*!40000 ALTER TABLE `stipoprob` DISABLE KEYS */;
INSERT INTO `stipoprob` VALUES (0,'<Seleccione>');
/*!40000 ALTER TABLE `stipoprob` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `tablaavances`
--

DROP TABLE IF EXISTS `tablaavances`;
/*!50001 DROP VIEW IF EXISTS `tablaavances`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `tablaavances` AS SELECT 
 1 AS `idAvances`,
 1 AS `idProblema`,
 1 AS `Avance`,
 1 AS `FechaAvance`,
 1 AS `Estado`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `tablaproblema`
--

DROP TABLE IF EXISTS `tablaproblema`;
/*!50001 DROP VIEW IF EXISTS `tablaproblema`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `tablaproblema` AS SELECT 
 1 AS `idProblema`,
 1 AS `CorreoPersona`,
 1 AS `NombreProb`,
 1 AS `DetalleProb`,
 1 AS `FechaCreacion`,
 1 AS `AreaProb`,
 1 AS `Estado`,
 1 AS `Solucion`,
 1 AS `Imagen`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `tipoprob`
--

DROP TABLE IF EXISTS `tipoprob`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipoprob` (
  `idTipoProb` int NOT NULL,
  `TipoProb` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idTipoProb`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoprob`
--

LOCK TABLES `tipoprob` WRITE;
/*!40000 ALTER TABLE `tipoprob` DISABLE KEYS */;
INSERT INTO `tipoprob` VALUES (0,'<Seleccione>'),(1,'Internet'),(2,'Telefono'),(3,'Computador'),(4,'Compartidos'),(5,'ERP'),(6,'Impresora');
/*!40000 ALTER TABLE `tipoprob` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unionap`
--

DROP TABLE IF EXISTS `unionap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unionap` (
  `idUnionAP` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idUnionAP`),
  CONSTRAINT `idAreaProb_FK` FOREIGN KEY (`idUnionAP`) REFERENCES `areaprob` (`idAreaProb`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idProblema1_FK` FOREIGN KEY (`idUnionAP`) REFERENCES `problema` (`idProblema`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unionap`
--

LOCK TABLES `unionap` WRITE;
/*!40000 ALTER TABLE `unionap` DISABLE KEYS */;
/*!40000 ALTER TABLE `unionap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'helpdesk'
--

--
-- Dumping routines for database 'helpdesk'
--

--
-- Final view structure for view `tablaavances`
--

/*!50001 DROP VIEW IF EXISTS `tablaavances`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `tablaavances` AS select `av`.`idAvances` AS `idAvances`,`p`.`idProblema` AS `idProblema`,`av`.`Avance` AS `Avance`,`av`.`FechaAvance` AS `FechaAvance`,`es`.`Estado` AS `Estado` from ((`avances` `av` join `problema` `p` on((`av`.`idAvanceProb` = `p`.`idProblema`))) join `estado` `es` on((`p`.`RefEstado` = `es`.`idEstado`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `tablaproblema`
--

/*!50001 DROP VIEW IF EXISTS `tablaproblema`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `tablaproblema` AS select `p`.`idProblema` AS `idProblema`,`cr`.`CorreoPersona` AS `CorreoPersona`,`p`.`NombreProb` AS `NombreProb`,`p`.`DetalleProb` AS `DetalleProb`,`p`.`FechaCreacion` AS `FechaCreacion`,`ap`.`AreaProb` AS `AreaProb`,`es`.`Estado` AS `Estado`,`so`.`Solucion` AS `Solucion`,`p`.`Imagen` AS `Imagen` from (((((`problema` `p` join `estado` `es` on((`p`.`RefEstado` = `es`.`idEstado`))) join `persona` `pe` on((`p`.`RefPersona` = `pe`.`idPersona`))) join `areaprob` `ap` on((`p`.`RefAreaProb` = `ap`.`idAreaProb`))) join `soluciones` `so` on((`p`.`RefSolucion` = `so`.`idSolucion`))) join `persona` `cr` on((`p`.`RefPersona` = `cr`.`idPersona`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-03 10:25:19
