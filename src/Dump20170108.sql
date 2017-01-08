-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: railwaydb
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `schedulId` int(11) NOT NULL,
  `arrivalTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `price` int(11) NOT NULL,
  `train_idTrain` int(11) NOT NULL,
  `stationStart_idstation` int(11) NOT NULL,
  `stationEnd_idstation` int(11) NOT NULL,
  `departureTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`schedulId`,`train_idTrain`,`stationStart_idstation`,`stationEnd_idstation`),
  KEY `fk_schedule_train1_idx` (`train_idTrain`),
  KEY `fk_schedule_station1_idx` (`stationStart_idstation`),
  KEY `fk_schedule_station2_idx` (`stationEnd_idstation`),
  CONSTRAINT `fk_schedule_station1` FOREIGN KEY (`stationStart_idstation`) REFERENCES `station` (`idStation`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_schedule_station2` FOREIGN KEY (`stationEnd_idstation`) REFERENCES `station` (`idStation`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_schedule_train1` FOREIGN KEY (`train_idTrain`) REFERENCES `train` (`idTrain`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'2018-11-10 11:55:03',2000,1,1,2,'2019-11-09 21:00:00'),(2,'2018-01-04 14:14:45',2000,1,1,2,'2018-01-04 17:15:07'),(3,'2018-01-04 14:32:48',2500,2,1,2,'2018-01-04 14:33:05'),(4,'2018-01-04 16:02:37',2000,1,1,4,'2018-01-04 16:04:55');
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_ticket`
--

DROP TABLE IF EXISTS `schedule_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule_ticket` (
  `schedulId` int(11) NOT NULL,
  `ticketId` int(11) NOT NULL,
  PRIMARY KEY (`schedulId`,`ticketId`),
  KEY `fk_schedule_has_ticket_ticket1_idx` (`ticketId`),
  KEY `fk_schedule_has_ticket_schedule1_idx` (`schedulId`),
  CONSTRAINT `fk_schedule_has_ticket_schedule1` FOREIGN KEY (`schedulId`) REFERENCES `schedule` (`schedulId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_schedule_has_ticket_ticket1` FOREIGN KEY (`ticketId`) REFERENCES `ticket` (`idTicket`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_ticket`
--

LOCK TABLES `schedule_ticket` WRITE;
/*!40000 ALTER TABLE `schedule_ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station`
--

DROP TABLE IF EXISTS `station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `station` (
  `idStation` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `name_ru` varchar(40) NOT NULL,
  PRIMARY KEY (`idStation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station`
--

LOCK TABLES `station` WRITE;
/*!40000 ALTER TABLE `station` DISABLE KEYS */;
INSERT INTO `station` VALUES (1,'Gomel','Гомель'),(2,'Minsk','Минск'),(3,'Grondo','Гродно'),(4,'Brest','Брест');
/*!40000 ALTER TABLE `station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `idTicket` int(11) NOT NULL AUTO_INCREMENT,
  `user_idUser` int(11) NOT NULL,
  PRIMARY KEY (`idTicket`),
  KEY `fk_ticket_user_idx` (`user_idUser`),
  CONSTRAINT `fk_ticket_user` FOREIGN KEY (`user_idUser`) REFERENCES `user` (`idUser`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,4),(2,4),(3,4),(4,4),(25,4),(26,4),(27,4),(28,4);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train`
--

DROP TABLE IF EXISTS `train`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train` (
  `idTrain` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `numberFreePlaces` int(11) NOT NULL,
  PRIMARY KEY (`idTrain`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train`
--

LOCK TABLES `train` WRITE;
/*!40000 ALTER TABLE `train` DISABLE KEYS */;
INSERT INTO `train` VALUES (1,'K42',163),(2,'EX 35',29),(3,'f',3);
/*!40000 ALTER TABLE `train` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `birthDay` date NOT NULL,
  `patronymic` varchar(45) DEFAULT NULL,
  `identificationNumber` varchar(45) NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` int(3) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,'Eugene','Shpenty','1996-11-18','Alekseevich','HB 2563383','shpetny.eugene@gmail.com','123',1),(5,'Tayson','Mike','2017-01-01','','sdfsd','mike@tayson.df','dfds',2),(7,'Snow','John','2017-01-08','','1111','john@yandex.ru','1111',2),(8,'Hard','Die','2017-01-08','','fg','die@hard.df','gfh',2),(9,'а','','2017-01-08','пп','','','',2);
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

-- Dump completed on 2017-01-08 16:26:22
