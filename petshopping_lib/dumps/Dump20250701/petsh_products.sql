-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: petsh
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `unit_price` double NOT NULL,
  `stock` int NOT NULL,
  `photo_url` varchar(250) DEFAULT NULL,
  `category` varchar(10) NOT NULL,
  `description` varchar(250) NOT NULL DEFAULT '',
  `release_date` date NOT NULL DEFAULT (curdate()),
  `place_of_product` varchar(45) DEFAULT '',
  `discount` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'ROYAL 法國皇家 離乳貓與乳貓專用濕糧 BC34W 195G',71,600,'https://i8.momoshop.com.tw/1749532854/goodsimg/TP000/0153/0000/028/TP00001530000028_R_m.jpg','貓媽幼貓糧食','','2021-01-27','',0),(2,'ROYAL 法國皇家 離乳貓專用飼料 BC34 2KG(貓乾糧)',933,500,'https://i3.momoshop.com.tw/1739077294/goodsimg/0009/141/335/9141335_R.webp','貓媽幼糧食','','2022-02-27','',0),(3,'ROYAL 法國皇家K36 幼貓專用乾糧 2kg',899,650,'https://i7.momoshop.com.tw/1747716334/goodsimg/TP000/0796/0000/375/TP00007960000375_R_m.jpg','貓媽幼貓糧食','','2023-03-27','',0),(4,'ROYAL 法國皇家皇家幼貓主食濕糧 K36W 85g 貓餐包 幼母貓(皇家 貓罐 主食 濕糧)',60,500,'https://i5.momoshop.com.tw/1749532854/goodsimg/TP000/0153/0000/027/TP00001530000027_R_m.jpg','貓媽幼貓糧食','','2021-04-27','',0),(5,'ROYAL 法國皇家ROYAL CANIN 法國皇家 STW 皇家饗宴主食濕糧 豐富鮮味 85g 貓餐包',59,600,'https://i5.momoshop.com.tw/1749532854/goodsimg/TP000/0153/0000/884/TP00001530000884_R_m.jpg','貓主食濕糧','','2022-05-27','',0),(6,'ROYAL 法國皇家ROYAL CANIN 法國皇家 IN27W 皇家室內貓主食濕糧 85g 貓餐包',59,300,'https://i6.momoshop.com.tw/1749532854/goodsimg/TP000/0153/0000/878/TP00001530000878_R_m.jpg','貓主食濕糧','','2023-06-27','',0),(7,'ROYAL 法國皇家 理想體態成貓專用濕糧 F32W 85Gx12包/盒(主食餐包)',522,120,'	https://i4.momoshop.com.tw/1736877706/goodsimg/0011/504/428/11504428_B.webp','貓主食濕糧','','2024-07-27','',0),(8,'ROYAL 法國皇家ROYAL CANIN 法國皇家 S37W 皇家絕育貓主食濕糧 85g 貓餐包',59,120,'https://i5.momoshop.com.tw/1749532854/goodsimg/TP000/0153/0000/879/TP00001530000879_R_m.jpg','貓主食濕糧','','2021-06-27','',0),(9,'ROYAL 法國皇家奶貓成長奶粉',800,30,'https://p1.aprimocdn.net/marspetcare/0440c120-7b7f-4a01-bd79-b1ef001ef870/0440c120-7b7f-4a01-bd79-b1ef001ef870_DownloadAsJpg.jpg','奶貓救援','','2021-06-27','',0),(10,'Bunny Nature 德國邦尼 夢想成兔小顆三柱顆粒-無糖蔬菜配方1.5kg(84種天然草本植物/無限量餵食)',1050,600,'https://i1.momoshop.com.tw/1746409344/goodsimg/0013/975/136/13975136_R.webp','德國邦尼','84種天然草本植物 24/7無限量餵食，纖維及澱粉的黃金比例','2025-07-01','德國',0),(11,'Bunny Nature 德國邦尼 夢想成兔大顆三柱顆粒-無糖配方1.5kg(80種天然草本植物/無限量餵食)',1050,300,'https://i2.momoshop.com.tw/1746409348/goodsimg/0013/975/135/13975135_R.webp','德國邦尼','80種天然草本植物，營養再升級 24/7無限量餵食 纖維及澱粉黃金比例','2025-07-01','德國',0),(12,'Bunny Nature 德國邦尼 低升醣餅乾-愛心野莓/30g(三包組)',660,150,'https://i4.momoshop.com.tw/1693157964/goodsimg/0009/815/880/9815880_R.webp','德國邦尼','鼠兔秒殺款 低升醣無負擔 超值三件組','2025-07-01','德國',0),(13,'Bunny Nature 德國邦尼 低升醣餅乾-愛心蒲公英/30g(三包組)',660,150,'https://i4.momoshop.com.tw/1693158065/goodsimg/0009/815/881/9815881_R.webp','德國邦尼','鼠兔秒殺款 低升醣無負擔 超值三件組','2025-07-01','德國',0),(14,'Bunny Nature 德國邦尼 低升醣餅乾-方塊蘋果/50g(三包組)',750,150,'https://i4.momoshop.com.tw/1693157908/goodsimg/0009/815/883/9815883_R.webp','德國邦尼','鼠兔秒殺款 低升醣無負擔 超值三件組','2025-07-01','德國',0),(15,'Bunny Nature 德國邦尼 低升醣餅乾-方塊水果/50g(三包組)',750,150,'https://i2.momoshop.com.tw/1693157957/goodsimg/0009/815/882/9815882_R.webp','德國邦尼','鼠兔秒殺款 低升醣無負擔 超值三件組','2025-07-01','德國',0),(16,'Bunny Nature 德國邦尼 夢想幼兔小顆三柱顆粒-無糖配方1.5kg(78種天然草本植物/無限量餵食)',1050,300,'https://i4.momoshop.com.tw/1746409397/goodsimg/0013/975/134/13975134_R.webp','德國邦尼','餵食指南：將飼料放滿食盆，食用完可再添加，24/7無需定時定量。搭配每天給予牧草及水。6個月後可換邦尼夢想成兔小顆三柱顆粒-無糖蔬菜配方，或大顆三柱顆粒-無糖配方。','2025-07-01','德國',0);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-01 13:41:42
