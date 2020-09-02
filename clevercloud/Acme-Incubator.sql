-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: acme-incubator
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `accounting_record`
--

DROP TABLE IF EXISTS `accounting_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounting_record` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `body` varchar(255) DEFAULT NULL,
  `creation_moment` datetime(6) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `bookkeeper_id` int(11) NOT NULL,
  `investment_round_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDXhwforwdu8n1h9l7gxea3vxdvj` (`status`),
  KEY `FK41jm4vk7runvmg5tderffrele` (`bookkeeper_id`),
  KEY `FKk1pmfnppwk0kav7xloy8u71uq` (`investment_round_id`),
  CONSTRAINT `FK41jm4vk7runvmg5tderffrele` FOREIGN KEY (`bookkeeper_id`) REFERENCES `bookkeeper` (`id`),
  CONSTRAINT `FKk1pmfnppwk0kav7xloy8u71uq` FOREIGN KEY (`investment_round_id`) REFERENCES `investment_round` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounting_record`
--

LOCK TABLES `accounting_record` WRITE;
/*!40000 ALTER TABLE `accounting_record` DISABLE KEYS */;
INSERT INTO `accounting_record` VALUES (907,0,'This is a test accounting record','2020-03-24 09:30:00.000000',0,'A good Title',906,894),(908,0,'This is a test accounting record for the same investment round','2020-03-24 14:30:00.000000',1,'A good Title 2',906,895),(909,0,'This is the last test accounting record for the same investment round','2020-01-14 09:30:00.000000',1,'A good Title 3',904,895);
/*!40000 ALTER TABLE `accounting_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity`
--

DROP TABLE IF EXISTS `activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `budget_amount` double DEFAULT NULL,
  `budget_currency` varchar(255) DEFAULT NULL,
  `deadline` datetime(6) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `investment_round_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1ufotopeofii4jlefyk9c7os5` (`investment_round_id`),
  CONSTRAINT `FK1ufotopeofii4jlefyk9c7os5` FOREIGN KEY (`investment_round_id`) REFERENCES `investment_round` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity`
--

LOCK TABLES `activity` WRITE;
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` VALUES (897,0,214.99,'€','2021-02-20 22:00:00.000000','2020-01-31 23:00:00.000000','Activity 1',894),(898,0,123.5,'€','2021-04-14 21:00:00.000000','2020-04-18 14:00:00.000000','Activity 2',894),(899,0,142.1,'€','2021-05-03 20:25:00.000000','2020-03-21 11:40:00.000000','Activity 3',895);
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrator` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_2a5vcjo3stlfcwadosjfq49l1` (`user_account_id`),
  CONSTRAINT `FK_2a5vcjo3stlfcwadosjfq49l1` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES (4,0,3);
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `anonymous`
--

DROP TABLE IF EXISTS `anonymous`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anonymous` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6lnbc6fo3om54vugoh8icg78m` (`user_account_id`),
  CONSTRAINT `FK_6lnbc6fo3om54vugoh8icg78m` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anonymous`
--

LOCK TABLES `anonymous` WRITE;
/*!40000 ALTER TABLE `anonymous` DISABLE KEYS */;
INSERT INTO `anonymous` VALUES (2,0,1);
/*!40000 ALTER TABLE `anonymous` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `application` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `justification` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `money_offer_amount` double DEFAULT NULL,
  `money_offer_currency` varchar(255) DEFAULT NULL,
  `statement` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `ticker` varchar(255) DEFAULT NULL,
  `entrepreneur_id` int(11) NOT NULL,
  `investment_round_id` int(11) NOT NULL,
  `investor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX2q2747fhp099wkn3j2yt05fhs` (`status`),
  KEY `FKp6hc01e2bc6ly2q8rv4b7ubro` (`entrepreneur_id`),
  KEY `FKk5ibe41quxsif8im882xv4afo` (`investment_round_id`),
  KEY `FKl4fp0cd8c008ma79n6w58xhk9` (`investor_id`),
  CONSTRAINT `FKk5ibe41quxsif8im882xv4afo` FOREIGN KEY (`investment_round_id`) REFERENCES `investment_round` (`id`),
  CONSTRAINT `FKl4fp0cd8c008ma79n6w58xhk9` FOREIGN KEY (`investor_id`) REFERENCES `investor` (`id`),
  CONSTRAINT `FKp6hc01e2bc6ly2q8rv4b7ubro` FOREIGN KEY (`entrepreneur_id`) REFERENCES `entrepreneur` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
INSERT INTO `application` VALUES (900,0,'','2020-03-26 14:30:00.000000',1400,'€','Application 1',2,'SOF-20-698032',887,894,891),(901,0,'','2019-08-25 11:59:00.000000',1000,'€','Application 2',0,'SOF-20-826016',887,895,891),(902,0,'Epic justification','2019-03-14 13:15:00.000000',500,'€','Application 3',1,'SOF-19-391683',889,895,893);
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authenticated`
--

DROP TABLE IF EXISTS `authenticated`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authenticated` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_h52w0f3wjoi68b63wv9vwon57` (`user_account_id`),
  CONSTRAINT `FK_h52w0f3wjoi68b63wv9vwon57` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authenticated`
--

LOCK TABLES `authenticated` WRITE;
/*!40000 ALTER TABLE `authenticated` DISABLE KEYS */;
INSERT INTO `authenticated` VALUES (5,0,3),(910,0,886),(911,0,888),(912,0,890),(913,0,892),(914,0,903),(915,0,905);
/*!40000 ALTER TABLE `authenticated` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `banner`
--

DROP TABLE IF EXISTS `banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `banner` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `slogan` varchar(255) DEFAULT NULL,
  `targeturl` varchar(255) DEFAULT NULL,
  `credit_card_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr19baq0bri0akndc7ruwhngy4` (`credit_card_id`),
  CONSTRAINT `FKr19baq0bri0akndc7ruwhngy4` FOREIGN KEY (`credit_card_id`) REFERENCES `credit_card` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banner`
--

LOCK TABLES `banner` WRITE;
/*!40000 ALTER TABLE `banner` DISABLE KEYS */;
INSERT INTO `banner` VALUES (866,0,'https://i.imgur.com/NGLSjk6.png','EjemploBanner','http://example4.com',863),(867,0,'https://caritas-web.s3.amazonaws.com/main-files/uploads/2018/12/logo_2x_caritas.png','EjemploCBanner2','http://example2.com',864),(868,0,'https://pbs.twimg.com/profile_images/855142032066695173/GGdhnJvg_400x400.jpg','EjemploCBanner3','http://example3.com',865);
/*!40000 ALTER TABLE `banner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookkeeper`
--

DROP TABLE IF EXISTS `bookkeeper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookkeeper` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `firm` varchar(255) DEFAULT NULL,
  `responsability_statement` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_krvjp9eaqyapewl2igugbo9o8` (`user_account_id`),
  CONSTRAINT `FK_krvjp9eaqyapewl2igugbo9o8` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookkeeper`
--

LOCK TABLES `bookkeeper` WRITE;
/*!40000 ALTER TABLE `bookkeeper` DISABLE KEYS */;
INSERT INTO `bookkeeper` VALUES (904,0,903,'Bookkeeper1','I will take responsability for what i\'ve done'),(906,0,905,'Bookkeeper2','If i must fall, i will rise each time a better man.');
/*!40000 ALTER TABLE `bookkeeper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookkeeper_request`
--

DROP TABLE IF EXISTS `bookkeeper_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookkeeper_request` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `firm` varchar(255) DEFAULT NULL,
  `responsability_statement` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_account_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrkmyfaktfktoo2v26a9qu4ebb` (`user_account_id`),
  CONSTRAINT `FKrkmyfaktfktoo2v26a9qu4ebb` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookkeeper_request`
--

LOCK TABLES `bookkeeper_request` WRITE;
/*!40000 ALTER TABLE `bookkeeper_request` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookkeeper_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caceres_bulletin`
--

DROP TABLE IF EXISTS `caceres_bulletin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `caceres_bulletin` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caceres_bulletin`
--

LOCK TABLES `caceres_bulletin` WRITE;
/*!40000 ALTER TABLE `caceres_bulletin` DISABLE KEYS */;
INSERT INTO `caceres_bulletin` VALUES (859,0,20,'David Caceres','2019-09-05 23:00:00.000000','http://www.example.com'),(860,0,57,'David Caceres','2019-09-07 07:00:00.000000','https://www.twitter.com/');
/*!40000 ALTER TABLE `caceres_bulletin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `challenge`
--

DROP TABLE IF EXISTS `challenge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `challenge` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `average_goal` varchar(255) DEFAULT NULL,
  `average_reward_amount` double DEFAULT NULL,
  `average_reward_currency` varchar(255) DEFAULT NULL,
  `deadline` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `expert_goal` varchar(255) DEFAULT NULL,
  `expert_reward_amount` double DEFAULT NULL,
  `expert_reward_currency` varchar(255) DEFAULT NULL,
  `rookie_goal` varchar(255) DEFAULT NULL,
  `rookie_reward_amount` double DEFAULT NULL,
  `rookie_reward_currency` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `challenge`
--

LOCK TABLES `challenge` WRITE;
/*!40000 ALTER TABLE `challenge` DISABLE KEYS */;
INSERT INTO `challenge` VALUES (881,0,'You stopped the excercise time for 10 days or more.',500,'€','2021-01-09 23:00:00.000000','You must play sport 5 hours in a day. If you don´t play 10 days, the expert goal will be failed. If you don´t play for 25 days, the average goal will be failed.','You didn´t stop the excercise.',1000,'€','You stopped the excercise time for 25 days or more.',100,'€','Sport'),(882,0,'Read 2 books.',300,'€','2021-02-01 22:30:00.000000','You have to read 3 Brandon Sanderson´s books. If you read only 1, you will receive the rookie money. If you read 2, then you will receive the average goal. If you read 3, you will receive the expert goal.','Read 3 books.',600,'€','Read 1 book.',100,'€','Reading'),(883,0,'Draw 2 self-protrait.',300,'€','2020-02-01 22:30:00.000000','You must draw at least three self-portrait in different styles.','Draw 3 self-protrait.',600,'€','Draw 1 self-protrait.',100,'€','Draw');
/*!40000 ALTER TABLE `challenge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumer`
--

DROP TABLE IF EXISTS `consumer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consumer` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6cyha9f1wpj0dpbxrrjddrqed` (`user_account_id`),
  CONSTRAINT `FK_6cyha9f1wpj0dpbxrrjddrqed` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumer`
--

LOCK TABLES `consumer` WRITE;
/*!40000 ALTER TABLE `consumer` DISABLE KEYS */;
/*!40000 ALTER TABLE `consumer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credit_card`
--

DROP TABLE IF EXISTS `credit_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credit_card` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `credit_card_cvv` varchar(255) DEFAULT NULL,
  `credit_card_number` varchar(255) DEFAULT NULL,
  `expiration_date` datetime(6) DEFAULT NULL,
  `holder_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit_card`
--

LOCK TABLES `credit_card` WRITE;
/*!40000 ALTER TABLE `credit_card` DISABLE KEYS */;
INSERT INTO `credit_card` VALUES (863,0,'Servired','957','5224746025394443','2021-09-14 13:30:00.000000','Fernando'),(864,0,'Servired','111','5224746025394443','2021-09-14 13:30:00.000000','Maria'),(865,0,'Ceca','989','5224746025394443','2021-09-14 13:30:00.000000','Alexandra');
/*!40000 ALTER TABLE `credit_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customisation_parameters`
--

DROP TABLE IF EXISTS `customisation_parameters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customisation_parameters` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `activity_sectors` varchar(255) DEFAULT NULL,
  `spam_threshold` float NOT NULL,
  `spam_words` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customisation_parameters`
--

LOCK TABLES `customisation_parameters` WRITE;
/*!40000 ALTER TABLE `customisation_parameters` DISABLE KEYS */;
INSERT INTO `customisation_parameters` VALUES (869,0,'Technology,Science,Arts,Business,Health',2.5,'sex,sexo,hard core,viagra,cialis,nigeria,you\'ve won,has ganado,million dollar,millon de dolares,millon de euros');
/*!40000 ALTER TABLE `customisation_parameters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discussion_forum`
--

DROP TABLE IF EXISTS `discussion_forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discussion_forum` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `creator_id` int(11) NOT NULL,
  `investment_round_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbfag2xg62p5csp5sfcf99thfd` (`creator_id`),
  KEY `FKmcgrpw22g3baap51wq319v1bp` (`investment_round_id`),
  CONSTRAINT `FKbfag2xg62p5csp5sfcf99thfd` FOREIGN KEY (`creator_id`) REFERENCES `authenticated` (`id`),
  CONSTRAINT `FKmcgrpw22g3baap51wq319v1bp` FOREIGN KEY (`investment_round_id`) REFERENCES `investment_round` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discussion_forum`
--

LOCK TABLES `discussion_forum` WRITE;
/*!40000 ALTER TABLE `discussion_forum` DISABLE KEYS */;
INSERT INTO `discussion_forum` VALUES (916,0,910,894),(922,0,911,895);
/*!40000 ALTER TABLE `discussion_forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrepreneur`
--

DROP TABLE IF EXISTS `entrepreneur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrepreneur` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `qualification_record` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  `skills_record` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_r6tqltqvrlh1cyy8rsj5pev1q` (`user_account_id`),
  CONSTRAINT `FK_r6tqltqvrlh1cyy8rsj5pev1q` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrepreneur`
--

LOCK TABLES `entrepreneur` WRITE;
/*!40000 ALTER TABLE `entrepreneur` DISABLE KEYS */;
INSERT INTO `entrepreneur` VALUES (887,0,886,'Entrepreneur1','C++','Software','Graphic designer'),(889,0,888,'Entrepreneur2','R','Software','Graphic designer');
/*!40000 ALTER TABLE `entrepreneur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gonzalez_bulletin`
--

DROP TABLE IF EXISTS `gonzalez_bulletin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gonzalez_bulletin` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `commentary` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `screenshot` varchar(255) DEFAULT NULL,
  `video` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gonzalez_bulletin`
--

LOCK TABLES `gonzalez_bulletin` WRITE;
/*!40000 ALTER TABLE `gonzalez_bulletin` DISABLE KEYS */;
INSERT INTO `gonzalez_bulletin` VALUES (861,0,'Look at this. I think it will help you!','2019-09-14 13:30:00.000000','https://imgur.com/gallery/ubA7F','https://www.youtube.com/watch?v=qI1nswEsCsM'),(862,0,'I found that on YouTube and I like it!','2019-12-24 16:45:00.000000','https://imgur.com/gallery/VJHANKr','https://www.youtube.com/watch?v=MpsgEMvSNHw');
/*!40000 ALTER TABLE `gonzalez_bulletin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (929);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inquirie`
--

DROP TABLE IF EXISTS `inquirie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inquirie` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `creation_date` datetime(6) DEFAULT NULL,
  `deadline` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `max_money_amount` double DEFAULT NULL,
  `max_money_currency` varchar(255) DEFAULT NULL,
  `min_money_amount` double DEFAULT NULL,
  `min_money_currency` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inquirie`
--

LOCK TABLES `inquirie` WRITE;
/*!40000 ALTER TABLE `inquirie` DISABLE KEYS */;
INSERT INTO `inquirie` VALUES (878,0,'2020-03-24 09:30:00.000000','2022-01-01 00:00:00.000000','We need the vaccine against Coronavirus to play Volleyball. Help us donating to the cause.','alex9951.a@gmail.com',10000,'€',400,'€','Coronavirus vaccine'),(879,0,'2020-04-10 11:00:00.000000','2020-12-01 11:00:00.000000','The people is buying toilet paper and is a total chaos, so help donating us to put more in the supermarkets.','mercadona@gmail.com',200,'€',50,'€','Toilet paper'),(880,0,'2020-04-10 11:00:00.000000','2020-02-01 11:00:00.000000','The queue for the local cinema is always too noisy. Please, help us keeping silence.','zonaeste@gmail.com',200,'€',70,'€','Cinema queue');
/*!40000 ALTER TABLE `inquirie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `investment_round`
--

DROP TABLE IF EXISTS `investment_round`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `investment_round` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `amount_amount` double DEFAULT NULL,
  `amount_currency` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `final_mode` bit(1) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `round` int(11) DEFAULT NULL,
  `ticker` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `entrepreneur_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkj1l8c2ftn9c65y061me6t37j` (`entrepreneur_id`),
  CONSTRAINT `FKkj1l8c2ftn9c65y061me6t37j` FOREIGN KEY (`entrepreneur_id`) REFERENCES `entrepreneur` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `investment_round`
--

LOCK TABLES `investment_round` WRITE;
/*!40000 ALTER TABLE `investment_round` DISABLE KEYS */;
INSERT INTO `investment_round` VALUES (894,0,250.25,'€','Epic description 1',_binary '\0','http://link.com','2020-07-30 13:30:00.000000',1,'SOF-19-592214','Investment 1',887),(895,0,232.46,'€','Epic description 2',_binary '\0','http://link.com','2019-09-13 14:45:00.000000',2,'SOF-19-114631','Investment 2',889),(896,0,111.25,'€','Epic description 3',_binary '','http://link.com','2020-06-30 13:30:00.000000',1,'LFP-02-592214','Investment 3',887);
/*!40000 ALTER TABLE `investment_round` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `investor`
--

DROP TABLE IF EXISTS `investor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `investor` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `profile` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dcek5rr514s3rww0yy57vvnpq` (`user_account_id`),
  CONSTRAINT `FK_dcek5rr514s3rww0yy57vvnpq` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `investor`
--

LOCK TABLES `investor` WRITE;
/*!40000 ALTER TABLE `investor` DISABLE KEYS */;
INSERT INTO `investor` VALUES (891,0,890,'Investor1','Profile','Software'),(893,0,892,'Investor','Profile','Software');
/*!40000 ALTER TABLE `investor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `body` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `creator_id` int(11) NOT NULL,
  `discussion_forum_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd8wmf6nghttk2h9gq7v8p9lqo` (`creator_id`),
  KEY `FKr2om5f6tefk2fg0fyl53q2kgd` (`discussion_forum_id`),
  CONSTRAINT `FKd8wmf6nghttk2h9gq7v8p9lqo` FOREIGN KEY (`creator_id`) REFERENCES `authenticated` (`id`),
  CONSTRAINT `FKr2om5f6tefk2fg0fyl53q2kgd` FOREIGN KEY (`discussion_forum_id`) REFERENCES `discussion_forum` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (919,0,'Acabo de crear un Message de ejemplo.','2019-10-27 22:59:00.000000',NULL,'Mensaje 1 Forum 1',910,916),(920,0,'Continúo con el Forum.','2019-10-28 13:00:00.000000',NULL,'Mensaje 2 forum 1',912,916),(921,0,'Continúo con el forum una vez  mas.','2019-10-29 13:00:00.000000',NULL,'Mensaje 3 forum 1',912,916),(926,0,'Acabo de crear un Message de ejemplo.','2019-10-27 22:59:00.000000',NULL,'Mensaje 1 Forum 2',911,922),(927,0,'Continúo con el Forum.','2019-10-28 13:00:00.000000',NULL,'Mensaje 2 forum 2',913,922),(928,0,'Continúo con el forum una vez  mas.','2019-10-29 13:00:00.000000',NULL,'Mensaje 3 forum 3',912,922);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `body` varchar(255) DEFAULT NULL,
  `creation_moment` datetime(6) DEFAULT NULL,
  `deadline` datetime(6) DEFAULT NULL,
  `header_picture` varchar(255) DEFAULT NULL,
  `links` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (870,0,'TS Online Marketing. An Oklahoma City Company','2020-08-01 18:00:00.000000','2021-02-01 22:00:00.000000','https://www.pinterest.es/pin/413768284513851403/','','Notice 1'),(871,0,'Gesunde Eiscreme: 2 Zutaten ohne Zucker','2020-06-01 18:00:00.000000','2020-07-14 19:30:00.000000','https://www.pinterest.es/pin/556194622730273652/','','Notice 2');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `overture`
--

DROP TABLE IF EXISTS `overture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `overture` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `deadline` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `max_money_amount` double DEFAULT NULL,
  `max_money_currency` varchar(255) DEFAULT NULL,
  `min_money_amount` double DEFAULT NULL,
  `min_money_currency` varchar(255) DEFAULT NULL,
  `moment` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `overture`
--

LOCK TABLES `overture` WRITE;
/*!40000 ALTER TABLE `overture` DISABLE KEYS */;
INSERT INTO `overture` VALUES (875,0,'2021-02-10 11:00:00.000000','Description of Overture 1','overture1@gmail.com',100,'€',50,'€','2020-04-14 12:00:00.000000','Title 1'),(876,0,'2020-12-16 19:00:00.000000','Description of Overture 2','overture2@gmail.com',1000,'€',500,'€','2019-11-18 14:30:00.000000','Title 2'),(877,0,'2020-02-16 19:00:00.000000','Description of Overture 3','overture3@gmail.com',1000,'€',500,'€','2019-11-18 14:30:00.000000','Title 3');
/*!40000 ALTER TABLE `overture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participant`
--

DROP TABLE IF EXISTS `participant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participant` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `authenticated_id` int(11) NOT NULL,
  `discussion_forum_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK80gruu22vbyiojed5sawtqc6a` (`authenticated_id`),
  KEY `FK2rgdydjuquk8s9d5tqijli0hy` (`discussion_forum_id`),
  CONSTRAINT `FK2rgdydjuquk8s9d5tqijli0hy` FOREIGN KEY (`discussion_forum_id`) REFERENCES `discussion_forum` (`id`),
  CONSTRAINT `FK80gruu22vbyiojed5sawtqc6a` FOREIGN KEY (`authenticated_id`) REFERENCES `authenticated` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participant`
--

LOCK TABLES `participant` WRITE;
/*!40000 ALTER TABLE `participant` DISABLE KEYS */;
INSERT INTO `participant` VALUES (917,0,910,916),(918,0,912,916),(923,0,911,922),(924,0,912,922),(925,0,913,922);
/*!40000 ALTER TABLE `participant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provider`
--

DROP TABLE IF EXISTS `provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provider` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `user_account_id` int(11) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_b1gwnjqm6ggy9yuiqm0o4rlmd` (`user_account_id`),
  CONSTRAINT `FK_b1gwnjqm6ggy9yuiqm0o4rlmd` FOREIGN KEY (`user_account_id`) REFERENCES `user_account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provider`
--

LOCK TABLES `provider` WRITE;
/*!40000 ALTER TABLE `provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tech_record`
--

DROP TABLE IF EXISTS `tech_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tech_record` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `activity_sector` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `inventor_name` varchar(255) DEFAULT NULL,
  `open` bit(1) NOT NULL,
  `stars` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `web_site` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tech_record`
--

LOCK TABLES `tech_record` WRITE;
/*!40000 ALTER TABLE `tech_record` DISABLE KEYS */;
INSERT INTO `tech_record` VALUES (872,0,'Video','Video platform','email1@gmail.com','Yawed Karim',_binary '',-4,'Youtube','https://www.youtube.com/'),(873,0,'Video','Video and Streaming platform','email2@gmail.com','Emmett Shear',_binary '',3,'Twitch','https://www.twitch.com/'),(874,0,'Text messages','Social Network to share messages','email3@gmail.com','Jack Dorsey',_binary '\0',5,'Twitter','https://www.twitter.com/');
/*!40000 ALTER TABLE `tech_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tool_record`
--

DROP TABLE IF EXISTS `tool_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tool_record` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `inventor` varchar(255) DEFAULT NULL,
  `open` bit(1) NOT NULL,
  `sector` varchar(255) DEFAULT NULL,
  `stars` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `web` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tool_record`
--

LOCK TABLES `tool_record` WRITE;
/*!40000 ALTER TABLE `tool_record` DISABLE KEYS */;
INSERT INTO `tool_record` VALUES (884,0,'Tool record from Alejandro Gonzalez','alejandro@gmail.com','Alejandro Gonzalez',_binary '','Sector 1',2,'Tool Record 1','https://www.alegonmar2.com/'),(885,0,'Tool record from David Caceres','davile@gmail.com','David Caceres',_binary '\0','Sector 2',-3,'Tool Record 2','https://www.davcacrom.com/');
/*!40000 ALTER TABLE `tool_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_account` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `identity_email` varchar(255) DEFAULT NULL,
  `identity_name` varchar(255) DEFAULT NULL,
  `identity_surname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_castjbvpeeus0r8lbpehiu0e4` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES (1,0,_binary '\0','john.doe@acme.com','John','Doe','$2a$05$Dz.zjNCVAbGlogtdlriOcuop.63WIpB2SHAte8vMqVUAtq9qAemj.','anonymous'),(3,0,_binary '','administrator@acme.com','Administrator','Acme.com','$2a$05$KawfYr4j9sgn0yUxwWUxEu8zW8mZE.HShk4jl5Dy/4RA3rsLU6Wam','administrator'),(886,0,_binary '','entrepreneur1@acme.com','Entrepreneur1','Entrepreneur1','$2a$05$GEKIL87lzx9/7pDlVqHyY.EHzIqSMRAGem54b2qr4S/Q2SfeCNTJO','entrepreneur1'),(888,0,_binary '','entrepreneur2@acme.com','Entrepreneur2','Entrepreneur2','$2a$05$jqq9ytKUAGxnpIJRwgHZs.4A9jIwTeDdAfGd/VXhea0RGOhbXXdKu','entrepreneur2'),(890,0,_binary '','investor1@acme.com','Investor1','Investor1','$2a$05$nGSbQZeYujN.MZapXCTUu.Fa6YiUzRNWdtWMywQREVpWoEnxCz.SO','investor1'),(892,0,_binary '','investor2@acme.com','Investor2','Investor2','$2a$05$4dBFQMmIc1J4gTFVoGOBEOV54P74Ds733KU4nLcuY.JFpzgILz7cG','investor2'),(903,0,_binary '','bookkeeper@acme.com','Bookkeeper1','Bookkeeper1','$2a$05$78sL.pFtS7bTYiEETxhScOH03twM4wQqScOB9KLsIZ0b73j5REnn2','bookkeeper1'),(905,0,_binary '','bookkeeper2@acme.com','Bookkeeper2','Bookkeeper2','$2a$05$YOXIt7t3vXcAwvHa/p6tKOT3tDfT96L15wyZKIo/qFI7Erev/XUsa','bookkeeper2');
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-02 16:07:57
