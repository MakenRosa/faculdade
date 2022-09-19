CREATE DATABASE  IF NOT EXISTS `e_stock` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `e_stock`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: e_stock
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'323.453.232-43','Lauana Silva','(32)3243-3245'),(2,'658.322.345-66','Alvarez Cartel','(44)2323-3344'),(3,'984.475.343-22','Carla Selena','(45)3213-4534'),(4,'232.343.231-11','Lyanna Inês','(22)4543-2314');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `item_entrada`
--

LOCK TABLES `item_entrada` WRITE;
/*!40000 ALTER TABLE `item_entrada` DISABLE KEYS */;
INSERT INTO `item_entrada` VALUES (1,'2020-03-23','2022-12-20','amcS32#',120,50,4),(2,'2022-09-10','2023-05-10','AxC2#s',200,40,1),(3,'2022-09-05','2023-09-05','1#scxz#2',90,30,5),(4,'2021-12-18','2023-06-18','NDnd23',180,60,7),(5,'2022-03-22','2023-09-12','MK!ls#4',350,70,3),(6,'2022-08-28','2023-10-13','Jx3#saE',150,30,1);
/*!40000 ALTER TABLE `item_entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `item_saida`
--

LOCK TABLES `item_saida` WRITE;
/*!40000 ALTER TABLE `item_saida` DISABLE KEYS */;
INSERT INTO `item_saida` VALUES (1,'2022-09-13','AxC2#s',19,3,2,1),(2,'2022-05-27','NDnd23',40,10,3,7),(3,'2022-09-14','Jx3#saE',36,6,2,3);
/*!40000 ALTER TABLE `item_saida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Coca cola zero 2l ','Refrigerante 2L'),(2,'Sprite 1.5 L diet','Refrigerante 1.5L'),(3,'Pureza 2L','Refrigerante 2L'),(4,'Água Crystal 500ML','Água mineral 500ml'),(5,'Caixa de leite mumu 1L UHT','Caixa de Leite'),(6,'Caixa de Leite Condensado Piracanjuba 395g ','Leite Condensado'),(7,'Lata de Leite Condensado Moça 395g','Leite Condensado');
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-19 16:38:05
