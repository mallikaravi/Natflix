-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: natflix
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `additional_details`
--

DROP TABLE IF EXISTS `additional_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `additional_details` (
  `ID` int NOT NULL  AUTO_INCREMENT,
  `BANNER_URL` varchar(255) DEFAULT NULL,
  `LOGO_URL` varchar(255) DEFAULT NULL,
  `SUMMARY` varchar(255) DEFAULT NULL,
  `THUMBNAIL_URL` varchar(255) DEFAULT NULL,
  `TITLE` varchar(255) DEFAULT NULL,
  `VIDEO_CODE` varchar(255) DEFAULT NULL,
  `POSTER_URL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `additional_details`
--

LOCK TABLES `additional_details` WRITE;
/*!40000 ALTER TABLE `additional_details` DISABLE KEYS */;
INSERT INTO `additional_details` VALUES (1,'/fake-images/banners/1.png','/fake-images/logos/1.png','The show about nothing is a sitcom landmark, with comic Jerry and his three sardonic friends finding laughs in both the mundane and the ridiculous','/fake-images/thumbnails/1.png','Seinfield','siayIFZx1Jw','/fake-images/posters/1.png'),(2,'','','Kido Senshi Gandamu Tsū Ai Senshi-hen is  a 1981 anime film directed by Yoshiyuki Tomino and animated by Sunrise. It is the second Mobile Suit Gundam compilation movie','/fake-images/thumbnails/2.png','Gundam II','2002157687',' '),(3,'','','A man has had his life turned upside down after his partner walks out on him after 17 years.','/fake-images/thumbnails/3.png','Uncoupled','dKW47roZYvo',''),(4,'','','Lauren Pierce is admitted to a correctional facility after she hits her friend\'s abusive boyfriend. She plots to escape when she realises the extent of corruption in the facility','/fake-images/thumbnails/4.png','Archer','pXSJKllkuk4',''),(5,'','','After a global financial crisis, the world is engulfed in an AI-driven war, and it\'s up to Section 9 to counter new forms of cyber threats.','/fake-images/thumbnails/5.png','Ghost in the Shell SAC 2045','5HK_l9NHBw4',''),(6,'','','Aboard the spaceship Bebop, a bounty hunter and his group of skilled comrades embark on adventures across the Solar System to capture criminals','/fake-images/thumbnails/6.png','Cowboy Bebop','_JDWm1f6-M0',''),(7,'','','Eight thieves take hostages and lock themselves in the Royal Mint of Spain as a criminal mastermind manipulates the police to carry out his plan','/fake-images/thumbnails/7.png','Money Heist','Uafg97czxeQ',''),(8,'','','Narcos: Mexico is an American-Mexican crime drama streaming television series created and produced by Chris Brancato, Carlo Bernard','/fake-images/thumbnails/8.png','Narcos Mexico','u-nactjYKb8',''),(9,'','','Amuro and Char try to blast each other with bombs and rockets while Amuro believes that Char is trying to cause a foolish revolution','/fake-images/thumbnails/9.png','Gundam Char\'s Counter Attack','6KKNoaHHf4M',''),(10,'','','Neon Genesis Evangelion is a Japanese mecha anime television series produced by Gainax and animated by Tatsunoko, directed by Hideaki Anno','/fake-images/thumbnails/10.png','Neon Genesis Evangelion','dKW47roZYvo',''),(11,'','','Designated Survivor is an American political thriller drama television series created by David Guggenheim. It aired for three seasons','/fake-images/thumbnails/11.png','Designated Survivor','zTJbUVjS--M',''),(12,'','','The Queen\'s Gambit is a 2020 American coming-of-age period drama streaming television miniseries based on the 1983 novel of the same name by Walter Tevis.','/fake-images/thumbnails/12.png','Queen\'s Gambit','v8LCMFpC7xY',''),(13,'','','A lawyer, whose law degree has been revoked, is compelled to join the Greendale Community College. Students of diverse temperaments join his study group which leads to quirky and memorable encounters.','/fake-images/thumbnails/13.png','Community','C4W4L9TLJa8',''),(14,'','','Vikings is a historical drama television series created and written by Michael Hirst for the History channel, a Canadian network.','/fake-images/thumbnails/14.png','Vikings','tsRx52ctsaY',''),(15,'','','Better Call Saul is an American crime and legal drama television series created by Vince Gilligan and Peter Gould','/fake-images/thumbnails/15.png','Better Call Saul','HN4oydykJFc',''),(16,'/fake-images/banners/16.png','','A political satire comedy about a high-school history teacher in his thirties who is unexpectedly elected President after a viral video filmed by one of his students shows him making a profane rant against government corruption.','/fake-images/thumbnails/16.png','Servant of the people','K7dpw5cAxcM',''),(17,'','','A group of terrorists plans to detonate three plutonium cores for a simultaneous nuclear attack on different cities','/fake-images/thumbnails/17.png','Mission Impossible Fallout','d9xABu3ApIQ',''),(18,'','','Two low-level astronomers must go on a giant media tour to warn mankind of an approaching comet that will destroy planet Earth.','/fake-images/thumbnails/18.png','Don\'t Look Up','PLuRMtyoj1Q',''),(19,'','','Lieutenant Hanna, a detective, decides to catch a highly intelligent seasonal criminal who has vowed to pull off one last robbery before he retires for good.','/fake-images/thumbnails/19.png','Heat','zhnGC7vz9KQ',''),(20,'','','Phil, a self-centred weatherman, goes to the town of Punxsutawney for an assignment.','/fake-images/thumbnails/20.png','Groundhog Day','XmwHdsiTuXU',''),(21,'','','Billy Beane, a baseball general manager, and Peter Brand, an economics graduate, challenge convention as they try to form a competitive sports team using computer-based methods.','/fake-images/thumbnails/21.png','Moneyball','lgyVS2NYz7E',''),(22,'/fake-images/banners/22.png','','In the fall of 1997, Michael Jordan and the Chicago Bulls allowed a film crew to follow them as they went for their sixth NBA title in eight seasons','/fake-images/thumbnails/22.png','The last dance','JQk2hJs2ToA',''),(23,'','','Tilikum, a captive killer whale, has taken the lives of three people. This impassioned documentary tells his story to unravel the consequences of keeping orcas in captivity','/fake-images/thumbnails/23.png','Blackfish','mIoUSaX0CWU',''),(24,'','','Five Mafia families controlled New York in the 1970s and 80s, until a group of federal agents work to take them down.','/fake-images/thumbnails/24.png','Fear city','FkMqFTyYnns',''),(25,'','','A group of elite Greek soldiers is assigned an impossible task of taking out the powerful German cannons on the Aegean island with the help of guerrilla fighters.','/fake-images/thumbnails/25.png','The Guns of Navarrone','QwK6BxR-nbI',''),(26,'','','Claire Beauchamp Randall, a nurse in World War II, mysteriously goes back in time to Scotland in 1743. There, she meets a dashing Highland warrior and gets drawn into an epic rebellion.','/fake-images/thumbnails/26.png','Outlander','Olx1Qenc4GE',''),(27,'','','The story of how kung-fu films became a huge phenomenon around the world, including interviews with action stars and industry figures.','/fake-images/thumbnails/27.png','Iron fist Kung fu Kicks','GjZ50faxCAg',''),(28,'/fake-images/banners/28.png','/fake-images/logos/28.png','Cyberpunk 2770 is an action role-playing video game developed by CD Projekt Red and published by CD Projekt. The story takes place in Night City, an open world set in the Cyberpunk universe.','','Cyberpunk 2770: Edgerunners','JtqIas3bYhg',''),(29,'','','A woman Jerry met in Michigan flies into New York and asks to stay with him, but he\'s unsure if it\'s intended to be a romantic situation.','/fake-images/episodes/1.png','Seinfeld (pilot)','A72K4M1R1tg',''),(30,'','','After recently breaking up with Elaine, Jerry meets a woman at a party but only learns where she works, leading him to stake out her office.','/fake-images/episodes/2.png','The Stake Out','jVJ7Vs3Y10w',''),(31,'','','Jerry\'s apartment gets robbed, leading him to want to move to a different place and give his current apartment to Elaine.','/fake-images/episodes/3.png','The Robbery','hQXKyIG_NS4',''),(32,'','','After George breaks up with a woman he finds annoying, Jerry dates her and also finds her grating, yet he can\'t bring himself to end the relationship.','/fake-images/episodes/4.png','The Ex-Girlfriend','PaPxSsK6ZQA',''),(33,'','','When Jerry\'s parents visit New York, Jerry upsets a family member with a remark about ponies. Kramer wants to build \"levels\" in his apartment.','/fake-images/episodes/5.png','The Pony Remark','uzda2bjj6YI',''),(34,'','','Jerry buys an expensive suede jacket with an odd lining. Jerry and George get stuck alone with Elaine\'s intimidating father.','/fake-images/episodes/6.png','The Jacket','9tyGHnm_9Rc',''),(35,'','','George goes to great lengths to prevent a woman he\'s dating from hearing an answering machine message. Jerry\'s date likes a commercial he hates.','/fake-images/episodes/7.png','The Phone Message','kjAkpnR3Ptg',''),(36,'','','Jerry scares a massage therapist, while George questions his sexuality after a massage. Kramer insists he saw Joe DiMaggio at a donut shop.','/fake-images/episodes/8.png','The Note','ptbw05iuYq0',''),(37,'','','George breaks up with his girlfriend, who happens to be in the middle of helping Jerry with a tax audit. Kramer dates Elaine\'s roommate.','/fake-images/episodes/9.png','The Truth','JVte31KnZis','');
/*!40000 ALTER TABLE `additional_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content`
--

DROP TABLE IF EXISTS `content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `content` (
  `ID` int NOT NULL  AUTO_INCREMENT,
  `CONTENT_TYPE_ID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `CONT_TYPE_ID` (`CONTENT_TYPE_ID`),
  CONSTRAINT `CONT_TYPE_ID` FOREIGN KEY (`CONTENT_TYPE_ID`) REFERENCES `content_type` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content`
--

LOCK TABLES `content` WRITE;
/*!40000 ALTER TABLE `content` DISABLE KEYS */;
INSERT INTO `content` VALUES (1,1),(2,2),(3,3);
/*!40000 ALTER TABLE `content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content_category`
--

DROP TABLE IF EXISTS `content_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `content_category` (
  `ID` int NOT NULL  AUTO_INCREMENT,
  `CATEGORY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content_category`
--

LOCK TABLES `content_category` WRITE;
/*!40000 ALTER TABLE `content_category` DISABLE KEYS */;
INSERT INTO `content_category` VALUES (1,'Horror'),(2,'Action'),(3,'Comedy'),(4,'Drama'),(5,'Other');
/*!40000 ALTER TABLE `content_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content_type`
--

DROP TABLE IF EXISTS `content_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `content_type` (
  `ID` int NOT NULL  AUTO_INCREMENT,
  `TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content_type`
--

LOCK TABLES `content_type` WRITE;
/*!40000 ALTER TABLE `content_type` DISABLE KEYS */;
INSERT INTO `content_type` VALUES (1,'Series'),(2,'Movies'),(3,'Documentaries');
/*!40000 ALTER TABLE `content_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documentaries`
--

DROP TABLE IF EXISTS `documentaries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `documentaries` (
  `ID` int NOT NULL  AUTO_INCREMENT,
  `ADDITIONAL_ID` int DEFAULT NULL,
  `CATEGORY_ID` int DEFAULT NULL,
  `CONTENT_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `DOC_ADD_ID` (`ADDITIONAL_ID`),
  KEY `DOC_CAT_ID` (`CATEGORY_ID`),
  KEY `DOC_CONTENT_ID` (`CONTENT_ID`),
  CONSTRAINT `DOC_ADD_ID` FOREIGN KEY (`ADDITIONAL_ID`) REFERENCES `additional_details` (`ID`),
  CONSTRAINT `DOC_CAT_ID` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `content_category` (`ID`),
  CONSTRAINT `DOC_CONTENT_ID` FOREIGN KEY (`CONTENT_ID`) REFERENCES `content` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documentaries`
--

LOCK TABLES `documentaries` WRITE;
/*!40000 ALTER TABLE `documentaries` DISABLE KEYS */;
INSERT INTO `documentaries` VALUES (1,22,5,3),(2,23,5,3),(3,24,5,3),(4,25,5,3),(5,26,5,3),(6,27,5,3);
/*!40000 ALTER TABLE `documentaries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `episodes`
--

DROP TABLE IF EXISTS `episodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `episodes` (
  `ID` int NOT NULL  AUTO_INCREMENT,
  `EPISODE_NUMBER` int DEFAULT NULL,
  `ADDITIONAL_ID` int DEFAULT NULL,
  `SEASON_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `EPISODE_ADD_ID` (`ADDITIONAL_ID`),
  KEY `EPI_SEASON_ID` (`SEASON_ID`),
  CONSTRAINT `EPI_SEASON_ID` FOREIGN KEY (`SEASON_ID`) REFERENCES `seasons` (`ID`),
  CONSTRAINT `EPISODE_ADD_ID` FOREIGN KEY (`ADDITIONAL_ID`) REFERENCES `additional_details` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `episodes`
--

LOCK TABLES `episodes` WRITE;
/*!40000 ALTER TABLE `episodes` DISABLE KEYS */;
INSERT INTO `episodes` VALUES (1,1,29,1),(2,2,30,1),(3,3,31,1),(4,1,32,2),(5,2,33,2),(6,3,34,2),(7,4,35,2),(8,2,36,3),(9,3,37,3);
/*!40000 ALTER TABLE `episodes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `ID` int NOT NULL  AUTO_INCREMENT,
  `OSCAR_WON` int DEFAULT NULL,
  `ADDITIONAL_ID` int DEFAULT NULL,
  `CATEGORY_ID` int DEFAULT NULL,
  `CONTENT_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `MOVIE_ADD_ID` (`ADDITIONAL_ID`),
  KEY `MOVIE_CAT_ID` (`CATEGORY_ID`),
  KEY `MOVIE_CONT_ID` (`CONTENT_ID`),
  CONSTRAINT `MOVIE_ADD_ID` FOREIGN KEY (`ADDITIONAL_ID`) REFERENCES `additional_details` (`ID`),
  CONSTRAINT `MOVIE_CAT_ID` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `content_category` (`ID`),
  CONSTRAINT `MOVIE_CONT_ID` FOREIGN KEY (`CONTENT_ID`) REFERENCES `content` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,3,16,2,2),(2,2,17,2,2),(3,1,18,3,2),(4,2,19,2,2),(5,4,20,4,2),(6,1,21,2,2);
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `ID` int NOT NULL  AUTO_INCREMENT,
  `ROLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_CUSTOMER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seasons`
--

DROP TABLE IF EXISTS `seasons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seasons` (
  `ID` int NOT NULL  AUTO_INCREMENT,
  `SEASON_NUMBER` int DEFAULT NULL,
  `SERIES_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `SEASON_SERIES_ID` (`SERIES_ID`),
  CONSTRAINT `SEASON_SERIES_ID` FOREIGN KEY (`SERIES_ID`) REFERENCES `series` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seasons`
--

LOCK TABLES `seasons` WRITE;
/*!40000 ALTER TABLE `seasons` DISABLE KEYS */;
INSERT INTO `seasons` VALUES (1,1,1),(2,2,1),(3,3,1);
/*!40000 ALTER TABLE `seasons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `series`
--

DROP TABLE IF EXISTS `series`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `series` (
  `ID` int NOT NULL  AUTO_INCREMENT,
  `ADDITIONAL_ID` int DEFAULT NULL,
  `CATEGORY_ID` int DEFAULT NULL,
  `CONTENT_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `SERIES_ADD_ID` (`ADDITIONAL_ID`),
  KEY `SERIES_CAT_ID` (`CATEGORY_ID`),
  KEY `SER_CONTENT_ID` (`CONTENT_ID`),
  CONSTRAINT `SER_CONTENT_ID` FOREIGN KEY (`CONTENT_ID`) REFERENCES `content` (`ID`),
  CONSTRAINT `SERIES_ADD_ID` FOREIGN KEY (`ADDITIONAL_ID`) REFERENCES `additional_details` (`ID`),
  CONSTRAINT `SERIES_CAT_ID` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `content_category` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `series`
--

LOCK TABLES `series` WRITE;
/*!40000 ALTER TABLE `series` DISABLE KEYS */;
INSERT INTO `series` VALUES (1,1,3,1),(2,2,2,1),(3,3,3,1),(4,4,3,1),(5,5,2,1),(6,6,2,1),(7,7,2,1),(8,8,4,1),(9,9,2,1),(10,10,2,1),(11,11,4,1),(12,12,4,1),(13,13,3,1),(14,14,2,1),(15,15,4,1),(28,28,3,1);
/*!40000 ALTER TABLE `series` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `CREATED_ON` datetime DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `FULL_NAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `STATUS` int DEFAULT NULL,
  `ROLE_ID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`),
  KEY `USER_ROLE_ID` (`ROLE_ID`),
  CONSTRAINT `USER_ROLE_ID` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,'admin@natflix.com','Administrator','$2a$10$5FUob7BmC96vDNA82Lnkle6NifkKP0bsxUgK7m2Q60JGsEbiL7odm',1,1);
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

-- Dump completed on 2022-10-22 12:03:25
