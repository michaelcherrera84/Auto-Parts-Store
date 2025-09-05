-- MySQL dump 10.13  Distrib 8.4.5, for macos14.5 (arm64)
--
-- Host: 127.0.0.1    Database: auto_parts
-- ------------------------------------------------------
-- Server version	8.4.5

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `country` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `currency` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`country`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--


--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` binary(16) NOT NULL,
  `address1` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address2` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `zip_code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq66qt93h2o1ogvxnpa8uqrqt` (`zip_code`),
  CONSTRAINT `FKq66qt93h2o1ogvxnpa8uqrqt` FOREIGN KEY (`zip_code`) REFERENCES `zip_code` (`zip_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--


--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` binary(16) NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone_number` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `role` enum('ADMINISTRATOR','SALESMAN') COLLATE utf8mb4_general_ci DEFAULT NULL,
  `supervisor` binary(16) DEFAULT NULL,
  `zip_code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5amfhprgb3rrhxjx7rq3al980` (`supervisor`),
  KEY `FK267hmbs14d6a6ubda8o7xofp2` (`zip_code`),
  CONSTRAINT `FK267hmbs14d6a6ubda8o7xofp2` FOREIGN KEY (`zip_code`) REFERENCES `zip_code` (`zip_code`),
  CONSTRAINT `FK5amfhprgb3rrhxjx7rq3al980` FOREIGN KEY (`supervisor`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--


--
-- Table structure for table `order_part`
--

DROP TABLE IF EXISTS `order_part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_part` (
  `quantity` int DEFAULT NULL,
  `orders` bigint NOT NULL,
  `part` binary(16) NOT NULL,
  PRIMARY KEY (`orders`,`part`),
  KEY `FK16aisnm3pr14gdr59ijhnwher` (`part`),
  CONSTRAINT `FK16aisnm3pr14gdr59ijhnwher` FOREIGN KEY (`part`) REFERENCES `part` (`id`),
  CONSTRAINT `FK6404tkw5d6e5m7uuen18j0phs` FOREIGN KEY (`orders`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_part`
--


--
-- Table structure for table `order_salesman`
--

DROP TABLE IF EXISTS `order_salesman`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_salesman` (
  `salesman` binary(16) NOT NULL,
  `orders` bigint NOT NULL,
  PRIMARY KEY (`salesman`,`orders`),
  UNIQUE KEY `UK3g6n4q0rkde59x7jca85w4umy` (`orders`),
  CONSTRAINT `FK2l2nu261mlnojdv773vp1ibmn` FOREIGN KEY (`salesman`) REFERENCES `employee` (`id`),
  CONSTRAINT `FKll8bvkfxc4q9punojgo7gxmuj` FOREIGN KEY (`orders`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_salesman`
--


--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `expected_ship_date` datetime(6) DEFAULT NULL,
  `order_date` datetime(6) DEFAULT NULL,
  `shipped_date` datetime(6) DEFAULT NULL,
  `customer` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp1mlwxe5nhua51hv0fo39ywbw` (`customer`),
  CONSTRAINT `FKp1mlwxe5nhua51hv0fo39ywbw` FOREIGN KEY (`customer`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--


--
-- Table structure for table `part`
--

DROP TABLE IF EXISTS `part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `part` (
  `id` binary(16) NOT NULL,
  `make` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `model` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `year` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part`
--


--
-- Table structure for table `part_country`
--

DROP TABLE IF EXISTS `part_country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `part_country` (
  `part` binary(16) NOT NULL,
  `country` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  KEY `FK71v9yfya9cdnh323nt0ly7b7u` (`country`),
  KEY `FKdi77h3rp1e6n6ed2lc5fwxop6` (`part`),
  CONSTRAINT `FK71v9yfya9cdnh323nt0ly7b7u` FOREIGN KEY (`country`) REFERENCES `country` (`country`),
  CONSTRAINT `FKdi77h3rp1e6n6ed2lc5fwxop6` FOREIGN KEY (`part`) REFERENCES `part` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part_country`
--


--
-- Table structure for table `part_inventory`
--

DROP TABLE IF EXISTS `part_inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `part_inventory` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `sold` bit(1) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `country` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `part` binary(16) DEFAULT NULL,
  `supplier` binary(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl1raxyf5prrp8hj7p5sexysdx` (`country`),
  KEY `FKmu14o1pgp2ynpa5mjnklh0nw0` (`part`),
  KEY `FK9lke2glpg5tli9j03rl24aso0` (`supplier`),
  CONSTRAINT `FK9lke2glpg5tli9j03rl24aso0` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`id`),
  CONSTRAINT `FKl1raxyf5prrp8hj7p5sexysdx` FOREIGN KEY (`country`) REFERENCES `country` (`country`),
  CONSTRAINT `FKmu14o1pgp2ynpa5mjnklh0nw0` FOREIGN KEY (`part`) REFERENCES `part` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part_inventory`
--


--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `id` binary(16) NOT NULL,
  `address1` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address2` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone_number` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `zip_code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3i6xwie5hr1j8mryv70wqvsws` (`zip_code`),
  CONSTRAINT `FK3i6xwie5hr1j8mryv70wqvsws` FOREIGN KEY (`zip_code`) REFERENCES `zip_code` (`zip_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--


--
-- Table structure for table `supplier_part`
--

DROP TABLE IF EXISTS `supplier_part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier_part` (
  `price` double DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `supplier` binary(16) NOT NULL,
  `part` binary(16) NOT NULL,
  PRIMARY KEY (`part`,`supplier`),
  KEY `FK99foaxfyrb1yt1bfj4j74my3d` (`supplier`),
  CONSTRAINT `FK99foaxfyrb1yt1bfj4j74my3d` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`id`),
  CONSTRAINT `FKirnjmup0xw2jjlouduefpjbal` FOREIGN KEY (`part`) REFERENCES `part` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_part`
--


--
-- Table structure for table `zip_code`
--

DROP TABLE IF EXISTS `zip_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zip_code` (
  `zip_code` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `city` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `state` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`zip_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zip_code`
--

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-05 11:38:35
