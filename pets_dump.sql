-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: pets
-- ------------------------------------------------------
-- Server version	10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dogs`
--

DROP TABLE IF EXISTS `dogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dogs` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(63) NOT NULL,
  `description` varchar(511) NOT NULL,
  `breed` varchar(63) NOT NULL,
  `age` int(3) NOT NULL,
  `size` int(3) NOT NULL,
  `origin` varchar(80) NOT NULL,
  `price` int(9) NOT NULL,
  `image_url` varchar(300) NOT NULL,
  `origin_lat` decimal(9,6) NOT NULL,
  `origin_lng` decimal(9,6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dogs`
--

LOCK TABLES `dogs` WRITE;
/*!40000 ALTER TABLE `dogs` DISABLE KEYS */;
INSERT INTO `dogs` VALUES (1,'Bruno','Good boy','Golden Retriever',8,185,'Gnjilane',150,'https://plus.unsplash.com/premium_photo-1723709016897-3cc15635e618?q=80&w=1780&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',42.463890,21.466940),(2,'Dzoni','Goodest boy','Illyrian Shepherd',1,210,'Svrljig',95,'https://upload.wikimedia.org/wikipedia/commons/a/a6/Sarplaninac_k%C3%B6ly%C3%B6k.JPG',43.412220,22.123060),(3,'Roki','Strong boy','American Stafford',5,150,'Cacak',50,'https://cdn.pixabay.com/photo/2015/03/14/04/24/american-staffordshire-terrier-672699_1280.jpg',43.891390,20.349720),(4,'Dzeki','Cuddly boy','Mixed street dog',3,130,'Novi Pazar',10,'https://breed-assets.wisdompanel.com/dog/street-dog-india/Indian_Street_Dog1.jpg',43.136670,20.514440),(5,'Marek','Slovak boy','Poodle',6,120,'Novi Sad',20,'https://floridafurbabies.com/azure/sunshinestatepups/pups/white%20Poodle%20dog.png?w=557&h=557&mode=crop&autorotate=1',45.264440,19.831670),(6,'Novak','Goody boy','Labrador Retriever',6,185,'Kraljevo',40,'https://xdn.tf.rs/2024/11/05/shutterstock1397834915-830x553.jpg',43.725830,20.689440),(7,'Nidza','Very good boy','German Shepherd',2,120,'Vranje',60,'https://images.unsplash.com/photo-1633564522273-2b2a3f21d860?q=80&w=2128&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D',42.551390,21.903330),(8,'Kika','English girly','English Bulldog',5,80,'Beograd',30,'https://upload.wikimedia.org/wikipedia/commons/b/bf/Bulldog_inglese.jpg',44.786568,20.448921),(9,'Marsovac','Alien boy','Unknown',90,130,'Prizren',1,'https://assets3.thrillist.com/v1/image/2523441/1000x750/scale;webp=auto;jpeg_quality=60.jpg',42.213890,20.739720),(10,'Toza','Twirly girl','Dalmatian',6,120,'Zadar',20,'https://assets.rightpaw.com.au/images/breeds/dalmatian.jpg',44.119440,15.242220),(11,'Mima','Fancy girl','Maltese Dog',6,120,'Banja Luka',10,'https://upload.wikimedia.org/wikipedia/commons/9/94/Maltese_600.jpg',44.772500,17.191940),(12,'Niksa','Big shepherd boy','Caucasian Shepherd',3,220,'Niksic',80,'https://upload.wikimedia.org/wikipedia/commons/0/0b/Owczarek_kaukaski_65556.jpg',42.773060,18.944440),(13,'Micko','Proud lil guy','Black Schnauzer',3,80,'Kladovo',20,'https://upload.wikimedia.org/wikipedia/commons/3/3b/BlkStdSchnauzer2.jpg',44.606670,22.611940),(14,'Leo','Wannabe shepherd','Jack Russel',4,80,'Skadar',30,'https://upload.wikimedia.org/wikipedia/commons/9/99/Brooks_Chase_Ranger_of_Jolly_Dogs_Jack_Russell.jpg',42.068060,19.512780),(15,'Buddy','Friendly golden retriever loves swimming','Golden Retriever',3,165,'Beograd',145,'https://upload.wikimedia.org/wikipedia/commons/8/82/Golden_Retriever_standing_Tucker.jpg',44.786568,20.448921),(16,'Luna','Blue-eyed Siberian husky','Siberian Husky',2,155,'Novi Sad',125,'https://upload.wikimedia.org/wikipedia/commons/7/7a/Huskiesatrest.jpg',45.264440,19.831670),(17,'Max','Curious beagle with great nose','Beagle',4,135,'Pristina',110,'https://upload.wikimedia.org/wikipedia/commons/5/55/Beagle_600.jpg',42.662913,21.165503),(18,'Daisy','Gentle border collie','Border Collie',5,175,'Podgorica',135,'https://upload.wikimedia.org/wikipedia/commons/3/34/BorderCol2.jpg',42.430420,19.259364),(19,'Rocky','Loyal Rottweiler','Rottweiler',4,195,'Skopje',155,'https://upload.wikimedia.org/wikipedia/commons/7/74/%22Prince%22_%287369763074%29.jpg',41.997346,21.427996),(20,'Molly','Playful corgi','Pembroke Welsh Corgi',3,110,'Sarajevo',145,'https://upload.wikimedia.org/wikipedia/commons/9/99/Welsh_Pembroke_Corgi.jpg',43.856259,18.413076),(21,'Charlie','Miniature dachshund','Dachshund',6,95,'Zagreb',85,'https://upload.wikimedia.org/wikipedia/commons/9/95/Dachshund_puppy_in_blanket.jpg',45.815011,15.981919),(22,'Bailey','Fluffy Samoyed','Samoyed',2,170,'Ljubljana',160,'https://upload.wikimedia.org/wikipedia/commons/d/d6/Lulu_-_Samoyed_in_Snow.jpg',46.056947,14.505751),(23,'Zoe','Tiny chihuahua','Chihuahua',7,45,'Tirana',65,'https://upload.wikimedia.org/wikipedia/commons/4/4c/Chihuahua1_bvdb.jpg',41.327546,19.818698),(24,'Bear','Gentle giant Newfoundland','Newfoundland Dog',6,220,'Sofia',165,'https://www.dogpackapp.com/blog/wp-content/uploads/2024/11/brown-newfoundland-dog-on-grass.webp',42.697708,23.321868),(25,'Duke','Sleek Doberman','Dobermann',4,185,'Niš',175,'https://upload.wikimedia.org/wikipedia/commons/5/50/Dobermannliggend.JPG',43.320902,21.895759),(26,'Lola','Elegant Afghan hound','Afghan Hound',4,170,'Subotica',185,'https://image.petmd.com/files/inline-images/afghan-hound-3.jpg?VersionId=Py7VL5KFBCCAP31Ny2cASKuzx9HSGdnV',46.100546,19.665059),(27,'Winston','Wrinkled Shar-Pei','Shar-Pei',5,140,'Kragujevac',155,'https://upload.wikimedia.org/wikipedia/commons/0/02/Gorda_-_100.jpg',44.012792,20.911422),(28,'Ruby','Red Irish Setter','Irish Setter',3,165,'Banja Luka',145,'https://upload.wikimedia.org/wikipedia/commons/2/2e/Can_Setter_dog_GFDL.jpg',44.772500,17.191940),(29,'Oscar','Basset Hound with long ears','Basset Hound',5,130,'Mostar',125,'https://www.dailypaws.com/thmb/UpEB541yjEX6R6im34RllTlxrTE=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/basset-hound-sitting-on-sidewalk-271176049-2000-3d4bb8d43af74d139f2e3be5def77973.jpg',43.343777,17.807758),(30,'Mia','Shih Tzu with bow','Shih Tzu',4,80,'Split',135,'https://upload.wikimedia.org/wikipedia/commons/3/30/Shih-Tzu.JPG',43.508132,16.440193),(31,'Cooper','French Bulldog','French Bulldog',3,125,'Dubrovnik',195,'https://upload.wikimedia.org/wikipedia/commons/1/18/2008-07-28_Dog_at_Frolick_Field.jpg',42.650661,18.094424),(32,'Sadie','Australian Shepherd','Australian Shepherd',2,155,'Ohrid',130,'https://www.animalbehaviorcollege.com/wp-content/uploads/2015/06/australian-shepherd.jpg',41.117128,20.801804),(33,'Tucker','Great Dane puppy','Great Dane',1,190,'Prizren',195,'https://www.dogpackapp.com/blog/wp-content/uploads/2024/11/fawn-great-dane-standing-park.webp',42.213890,20.739720),(34,'Stella','Vizsla runner','Vizsla',2,150,'Tetovo',135,'https://upload.wikimedia.org/wikipedia/commons/8/89/Vizsla_02.jpg',42.009726,20.971662);
/*!40000 ALTER TABLE `dogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pet_id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `order_status` varchar(15) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `rating` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_person_order` (`user_id`),
  KEY `fk_pet_order` (`pet_id`),
  CONSTRAINT `fk_person_order` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `fk_pet_order` FOREIGN KEY (`pet_id`) REFERENCES `dogs` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (4,12,2,'CANCELLED','2025-01-18 19:27:23','2025-01-18 21:05:31',NULL),(5,4,2,'CANCELLED','2025-01-18 20:03:47','2025-01-18 21:05:43',NULL),(6,6,2,'COMPLETED','2025-01-18 20:21:06','2025-01-24 22:38:33',3),(7,5,2,'COMPLETED','2025-01-18 22:26:12','2025-01-26 23:14:33',5),(8,1,2,'COMPLETED','2025-01-18 22:27:23','2025-01-18 23:33:56',NULL),(9,3,2,'COMPLETED','2025-01-18 22:27:23','2025-01-18 23:39:06',NULL),(10,2,2,'COMPLETED','2025-01-18 22:27:23','2025-01-18 23:43:39',NULL),(11,4,2,'COMPLETED','2025-01-18 22:27:23','2025-01-18 23:27:36',NULL),(12,1,2,'COMPLETED','2025-01-18 22:44:54','2025-01-18 23:53:10',NULL),(13,3,2,'COMPLETED','2025-01-18 22:44:54','2025-01-18 23:59:40',NULL),(14,6,2,'COMPLETED','2025-01-18 22:44:54','2025-01-19 00:02:58',NULL),(15,5,2,'CANCELLED','2025-01-18 22:44:54','2025-01-20 00:49:06',NULL),(16,4,2,'CANCELLED','2025-01-18 22:44:54','2025-01-20 00:55:12',NULL),(17,2,2,'COMPLETED','2025-01-18 22:44:54','2025-01-22 20:56:57',5),(18,8,2,'COMPLETED','2025-01-18 22:44:54','2025-01-20 00:49:12',NULL),(19,9,2,'CANCELLED','2025-01-18 22:44:54','2025-01-21 23:07:36',NULL),(20,7,2,'COMPLETED','2025-01-18 22:44:54','2025-01-24 03:01:48',5),(21,1,9,'COMPLETED','2025-01-19 23:55:38','2025-01-21 02:39:44',4),(22,4,9,'COMPLETED','2025-01-20 22:47:55','2025-01-21 02:28:10',1),(23,3,9,'COMPLETED','2025-01-20 22:47:55','2025-01-21 03:10:56',5),(24,2,9,'CANCELLED','2025-01-20 22:47:55','2025-01-21 02:43:40',NULL),(25,7,9,'COMPLETED','2025-01-21 02:11:59','2025-01-21 03:12:15',4),(26,2,9,'COMPLETED','2025-01-21 03:19:12','2025-01-21 04:30:03',5),(27,2,9,'CANCELLED','2025-01-21 04:36:13','2025-01-21 05:36:21',NULL),(28,4,9,'COMPLETED','2025-01-21 18:10:29','2025-01-21 19:10:52',5),(29,2,2,'COMPLETED','2025-01-22 19:56:10','2025-01-22 20:56:37',NULL),(30,3,3,'COMPLETED','2025-01-22 21:24:32','2025-01-22 22:25:21',3),(31,2,9,'CANCELLED','2025-01-22 22:37:32','2025-01-22 23:37:42',NULL),(32,4,13,'COMPLETED','2025-01-23 00:07:00','2025-01-23 01:07:36',5),(33,7,2,'IN_PROGRESS','2025-01-24 20:01:40','2025-01-24 21:01:40',NULL),(34,2,2,'COMPLETED','2025-01-24 21:28:48','2025-01-24 22:28:59',5),(35,5,13,'COMPLETED','2025-01-28 22:39:24','2025-01-28 23:43:24',NULL),(36,2,2,'COMPLETED','2025-02-22 14:43:03','2025-02-22 15:43:27',5);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(40) NOT NULL,
  `email` varchar(80) NOT NULL,
  `phone` varchar(13) DEFAULT NULL,
  `address` varchar(120) DEFAULT NULL,
  `google_id` varchar(255) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'MATEJ','JETAM','matej@gmail.com','+123456789','Hongsh Mutin 12',NULL,'$2a$10$xphhF81dU1yCcINdh/Jy.eX4O1GBgw6KB6Oqgsa7sqEgjJeLdHVum'),(2,'Marko','Markovic','marko@gmail.com','38163333666','Beograd',NULL,'$2a$10$kg4AVsxDH6kisK9ZnpWWyeBldRYpUyXL1vujUdp5gJ7HqdQRyHVI2'),(3,'Luka','Lukic','luka@gmail.com','3816060606','Pristina',NULL,'$2a$10$3wB61PSySqN4.xKFC5Q47e2GRB12Z.lRYoYAm0V9ZtjF0vMyLX6Dq'),(4,'Jovan','Jovanovic','jovan@gmail.com','38160121212','Negotin',NULL,'$2a$10$.WCPIsFFi2sflgLL5LwP.OpK1ju.cZZRobaZgu0TSVQl5fGuPQwAa'),(5,'Darko','Darkovic','darko@gmail.com','38160121212','Gnjilane',NULL,'$2a$10$.ZzLHvPCQP3UKnbGnrSci.SeoEXLTYGaCXtQYD8qj9wQfzG6whx0G'),(6,'Aksentije','Aksentijevic','aksentije@gmail.com','38160121212','Raska',NULL,'$2a$10$Xn1E/Ohjq3U7AtVCnBv9/uJAqx3nQH.0LVqlvdjje8fkCryTDZgSe'),(7,'Bogdan','Bogdanovic','bogdan@gmail.com','38160121212','Kraljevo',NULL,'$2a$10$7kgzRp2v3tK5uGEznK0Z8OXO5EiWpWn2zz9rcO4zNISEbwKl00H5u'),(8,'Cvetolik','Cvetolikovic','cvetolik@gmail.com','38160121212','Backa Palanka',NULL,'$2a$10$mJdOhxG.PSvKdvr2zSrr9ejiPynHkcxlOalO9Uzj9vvAJtgOQwGt6'),(9,'Dragoslav','Dragoslavljevic','dragoslav@gmail.com','38160121212','Jagodina',NULL,'$2a$10$Ea8hUItNl3dXk0.LHtV1hO7iH6CzLlemVcU7I0/msX40y1sWqQIbW'),(10,'Radasin','Radasinovic','radasin@gmail.com','38160121212','Petrovac na Mlavi',NULL,'$2a$10$wENXgXWyl/Y4Avv1cPf7tOqHmLx8oaT2LOUKWmzr7uoMc/ykXx03u'),(11,'Petar','Petrovic','petar@gmail.com','38160121212','Subotica',NULL,'$2a$10$R.DZc2Z6x0f4H0xrSFZ9eOopBZlxf5pfhvpqaSsDUsPMltgk4Dklm'),(12,'Marko','Vojinovic','mare02mv@gmail.com','381611501155','Gornjomatejevačka 122/9',NULL,'$2a$10$l/vibGMCfwLRT.Ei4n5bquiNPIx9YyAahEgIb4/sHW8zEKNas/NN6'),(13,'Markos','Voinovits','fgfgfgv@gmail.com','381611501155','Adresa 11',NULL,'$2a$10$aw6s8hDO0IpFb0VZ2nll.eEkxHCcPqvcBtJPKOoV4ahOQqfDZ.gxu');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-24 15:59:09
