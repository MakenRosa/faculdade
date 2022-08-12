-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: prego
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(145) NOT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `rg` varchar(45) DEFAULT NULL,
  `salario` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Carlos Machado','248.611.309-18','81438638',3.327),(2,'Lizandra Mattes','045.417.488-15','95142958',6.892),(3,'Elizangela Costa','791.317.319-93','81263175',7.59),(4,'Luan Rodrigues','900.140.794-12','46317575',2.322),(5,'Maken da Rosa','959.861.510-77','08345738',4.215),(6,'Ruan da Rosa','281.663.762-54','40086265',2.525),(7,'Carlos Costa','781.152.721-96','43099617',1.902),(8,'Lucas Neto','178.688.738-29','50002299',3.333),(9,'Lucas Medeiros','153.422.292-25','15223702',6.095),(10,'Carlos Silva','498.047.786-12','36521410',7.991),(11,'Ruan Neto','750.114.981-44','76873558',3.929),(12,'Carlos Silva','689.070.316-38','00774851',9.954),(13,'Elizangela Costa','063.967.922-39','49435757',1.332),(14,'Junior Henrique','331.750.799-21','32346392',1.605),(15,'Maken Costa','822.792.328-05','71463687',8.661),(16,'Renaldo Machado','640.895.074-42','53346757',9.828),(17,'Lucas Paulo','306.394.572-87','01797820',1.972),(18,'Carlos Rolva','094.480.225-26','83882765',7.624),(19,'Renaldo Faria','484.489.721-44','07031698',3.895),(20,'Elizangela Neto','563.811.461-81','17025481',4.983),(21,'João Costa','421.831.358-11','83611642',0.092);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(145) NOT NULL,
  `login` varchar(145) NOT NULL,
  `senha` varchar(245) NOT NULL,
  `ultimo_acesso` date DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Luan Rolva','@perla_xavier','3sWe6Gr3',NULL),(2,'Ana Rinchens','@perla_rolva','h2BRxLCD',NULL),(37,'Ana Holanda','@tiago_silva','qsOvDOxn',NULL),(38,'Elizangela Faria','@ricardo_costa','2qKb9Tfs',NULL),(40,'Ricardo da Rosa','@eva_faria','mfxIPTIC',NULL),(41,'Silvio Medeiros','@silvio_vieira','IYQ5KenW',NULL),(42,'Tiago Xavier','@maken_mattes','EqkvVEn1',NULL),(43,'João Mattes','@perla_abreu','wdGehv4P',NULL),(44,'Carlos Rolva','@joão_freitas','4zRlJ0v0',NULL),(45,'Carlos Silva','@luan_machado','nr0DBYiD',NULL),(46,'Eva Paulo','@lucas_neto','vGAmDK6i',NULL),(47,'Perla Silva','@joão_machado','JMj9M8T2',NULL),(48,'Ana Xavier','@carlos_silva','w7edgVti',NULL),(49,'Ana Vieira','@pedro_silva','o2v3JBvW',NULL),(50,'Pedro Xavier','@pedro_rolva','D73AfiZg',NULL),(51,'Renaldo da Rosa','@lizandra_paulo','fisjnwLr',NULL),(52,'Carla Rolva','@tiago_xavier','Oy5fbbN6',NULL),(53,'Ana Abreu','@carla_machado','MdUoejhu',NULL),(54,'Tiago Costa','@junior_holanda','COXzcBvs',NULL),(55,'Ruan Henrique','@maken_henrique','MjnK3iU2',NULL),(56,'Maken Mattes','@joão_paulo','QEUsXSef',NULL),(57,'Ana Paulo','@ana_costa','qDzt4MMF',NULL),(58,'Silvio Schmitz','@junior_silva','Jcmllk6o',NULL),(61,'Ana Neto','@ana_schmitz','C7hS7LJ5',NULL),(63,'Tiago da Rosa','@junior_paulo','ksT47io6',NULL),(64,'Luan Medeiros','@perla_faria','jdkeYavS',NULL),(67,'Carlos Mattes','@pedro_henrique','Wniiz6bt',NULL),(68,'Pedro Xavier','@lucas_freitas','Zub7Cz9N',NULL),(69,'Pedro Holanda','@luan_mattes','31Pw4Xda',NULL),(70,'Ana Henrique','@pedro_rodrigues','e8gISOni',NULL),(71,'Silvio Paulo','@renaldo_machado','hPXbdTYL',NULL),(72,'Tiago Neto','@lucas_silva','BZKMrEfW',NULL),(73,'Pedro Costa','@pedro_machado','7rAkGiq3',NULL),(74,'Ana Rolva','@lucas_mattes','Ct71e08H',NULL),(76,'Carlos Rinchens','@renaldo_rodrigues','L9I3MQrg',NULL),(78,'Ruan Vieira','@leonardo_rodrigues','yTztB9Jt',NULL),(80,'João Silva','@perla_henrique','rkfvMayB',NULL),(81,'Maken Rinchens','@tiago_abreu','Jbh8tbnp',NULL),(83,'Ana Silva','@ruan_vieira','CSW55cOd',NULL),(84,'Silvio Medeiros','@leonardo_rolva','JqE8C32H',NULL),(85,'Carla Rodrigues','@junior_rolva','g27ugBym',NULL),(86,'Ruan Paulo','@carlos_freitas','qqVDikvE',NULL),(87,'Carla Machado','@elizangela_abreu','hPoF4Y3k',NULL),(88,'Lizandra Rodrigues','@pedro_rinchens','fsPdLvtk',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-11 21:41:09
