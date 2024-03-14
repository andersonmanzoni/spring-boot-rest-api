-- --------------------------------------------------------
-- Host:                         192.168.57.102
-- Server version:               10.1.48-MariaDB-0ubuntu0.18.04.1 - Ubuntu 18.04
-- Server OS:                    debian-linux-gnu
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for warehouse
CREATE DATABASE IF NOT EXISTS `warehouse` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `warehouse`;

-- Dumping structure for table warehouse.item
CREATE TABLE IF NOT EXISTS `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sku` varchar(50) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `external_product_number` varchar(50) DEFAULT NULL,
  `external_reference_sku` varchar(15) DEFAULT NULL,
  `available` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table warehouse.item: ~3 rows (approximately)
INSERT INTO `item` (`id`, `sku`, `description`, `external_product_number`, `external_reference_sku`, `available`) VALUES
	(1, 'SHIRTREDS', 'Red shirt, small', '2000', '2000REDAS', NULL),
	(2, 'REDCAP', 'Red cap', '1035', '1035RED', NULL),
	(3, 'SHIRTREDL', 'Red shirt, large', '2000', '2000REDL', NULL);

-- Dumping structure for table warehouse.item_attribute
CREATE TABLE IF NOT EXISTS `item_attribute` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table warehouse.item_attribute: ~3 rows (approximately)
INSERT INTO `item_attribute` (`id`, `name`, `description`) VALUES
	(1, 'color', NULL),
	(2, 'size', NULL),
	(3, 'material', NULL);

-- Dumping structure for table warehouse.item_item_atribute
CREATE TABLE IF NOT EXISTS `item_item_atribute` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) DEFAULT NULL,
  `item_attribute_id` int(11) DEFAULT NULL,
  `value` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `item_item_atribute_item_id_fk` (`item_id`),
  KEY `item_item_atribute_item_attribute_id_fk` (`item_attribute_id`),
  CONSTRAINT `item_item_atribute_item_attribute_id_fk` FOREIGN KEY (`item_attribute_id`) REFERENCES `item_attribute` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `item_item_atribute_item_id_fk` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table warehouse.item_item_atribute: ~2 rows (approximately)
INSERT INTO `item_item_atribute` (`id`, `item_id`, `item_attribute_id`, `value`) VALUES
	(1, 1, 1, 'RED'),
	(2, 1, 2, 'S');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
