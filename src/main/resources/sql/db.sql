CREATE DATABASE  IF NOT EXISTS `spring_demo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `spring_demo`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_demo
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goods` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,'water',2),(2,'bread',8),(3,'knief',59);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `operator_id` int DEFAULT NULL,
  `create_at` datetime(1) DEFAULT NULL,
  `method_name` varchar(255) DEFAULT NULL,
  `method_args` varchar(255) DEFAULT NULL,
  `return_value` longtext,
  `cost` bigint DEFAULT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (1,1,'2024-05-01 00:00:00.0','query','[]','[{\"age\":1,\"id\":1,\"name\":\"cfd\"},{\"age\":2,\"id\":2,\"name\":\"lh\"},{\"age\":3,\"id\":3,\"name\":\"glz\"},{\"age\":21,\"id\":6,\"name\":\"yzy\"},{\"age\":21,\"id\":7,\"name\":\"yzy\"},{\"age\":21,\"id\":8,\"name\":\"yzy\"},{\"age\":21,\"id\":9,\"name\":\"yzy\"},{\"age\":18,\"id\":10,\"name\":\"love\"},{\"age\":18,\"id\":11,\"name\":\"yzy\"},{\"age\":21,\"id\":15,\"name\":\"yzy\"},{\"age\":21,\"id\":16,\"name\":\"yzy\"},{\"age\":21,\"id\":17,\"name\":\"yzy\"},{\"age\":21,\"id\":18,\"name\":\"yzy\"},{\"age\":21,\"id\":20,\"name\":\"yzy\"},{\"age\":21,\"id\":21,\"name\":\"yzy\"}]',9,'com.example.springbootappdemo.demos.Contorller.MybatisController'),(2,1,'2024-05-01 00:00:00.0','query','[]','[{\"age\":1,\"id\":1,\"name\":\"cfd\"},{\"age\":2,\"id\":2,\"name\":\"lh\"},{\"age\":3,\"id\":3,\"name\":\"glz\"},{\"age\":21,\"id\":6,\"name\":\"yzy\"},{\"age\":21,\"id\":7,\"name\":\"yzy\"},{\"age\":21,\"id\":8,\"name\":\"yzy\"},{\"age\":21,\"id\":9,\"name\":\"yzy\"},{\"age\":18,\"id\":10,\"name\":\"love\"},{\"age\":18,\"id\":11,\"name\":\"yzy\"},{\"age\":21,\"id\":15,\"name\":\"yzy\"},{\"age\":21,\"id\":16,\"name\":\"yzy\"},{\"age\":21,\"id\":17,\"name\":\"yzy\"},{\"age\":21,\"id\":18,\"name\":\"yzy\"},{\"age\":21,\"id\":20,\"name\":\"yzy\"},{\"age\":21,\"id\":21,\"name\":\"yzy\"}]',151,'com.example.springbootappdemo.demos.Contorller.MybatisController'),(3,1,'2024-05-01 21:32:38.3','query','[]','[{\"age\":1,\"id\":1,\"name\":\"cfd\"},{\"age\":2,\"id\":2,\"name\":\"lh\"},{\"age\":3,\"id\":3,\"name\":\"glz\"},{\"age\":21,\"id\":6,\"name\":\"yzy\"},{\"age\":21,\"id\":7,\"name\":\"yzy\"},{\"age\":21,\"id\":8,\"name\":\"yzy\"},{\"age\":21,\"id\":9,\"name\":\"yzy\"},{\"age\":18,\"id\":10,\"name\":\"love\"},{\"age\":18,\"id\":11,\"name\":\"yzy\"},{\"age\":21,\"id\":15,\"name\":\"yzy\"},{\"age\":21,\"id\":16,\"name\":\"yzy\"},{\"age\":21,\"id\":17,\"name\":\"yzy\"},{\"age\":21,\"id\":18,\"name\":\"yzy\"},{\"age\":21,\"id\":20,\"name\":\"yzy\"},{\"age\":21,\"id\":21,\"name\":\"yzy\"}]',12,'com.example.springbootappdemo.demos.Contorller.MybatisController'),(4,1,'2024-05-02 14:10:35.2','find','[1]','{\"age\":1,\"id\":1,\"name\":\"cfd\"}',8,'com.example.springbootappdemo.demos.Contorller.MybatisController');
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `good_id` int NOT NULL,
  `amount` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,1,5),(2,2,2),(3,3,1),(4,3,1),(5,3,100);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT 'common_user',
  `key` varchar(45) NOT NULL DEFAULT 'common_user',
  `sort` int NOT NULL DEFAULT '10',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin','1',1),(2,'common_user','10',10),(3,'black_list','black_list',100);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint NOT NULL,
  `name` varchar(45) NOT NULL,
  `age` int NOT NULL DEFAULT '0',
  `avatar` varchar(255) DEFAULT '"cfd"',
  `account` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,'cfd',21,'','123456','123456'),(2,1,'lh',84,NULL,'1234567','123456');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-06 17:38:14
