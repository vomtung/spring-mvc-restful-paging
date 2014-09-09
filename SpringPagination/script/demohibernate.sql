-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 09, 2014 at 02:16 AM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `demohibernate`
--
CREATE DATABASE IF NOT EXISTS `demohibernate` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `demohibernate`;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `category_name`, `description`) VALUES
(0, 'New Newducts', 'Feature product'),
(1, 'Featured Products', 'new product'),
(2, 'Promotions Products', 'promotion product');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `manufacture` varchar(255) DEFAULT NULL,
  `owner` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` bigint(20) NOT NULL,
  `image_name` varchar(255) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  KEY `id` (`id`),
  KEY `owner` (`owner`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=31 ;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `description`, `manufacture`, `owner`, `name`, `price`, `image_name`, `category_id`) VALUES
(23, 'description', 'BAADDADASD', 3, 'product 23', 0, '1409028463151-f58fb45a-63de-4e88-ae6f-da560c5000ec.jpg', 0),
(24, '1323', '13123', 3, '24', 0, '1409028492451-1c5725f8-0f32-4630-bf3e-e79e65cc5d3c.jpg', 1),
(25, 'wqre', 'qwerqr', 3, '25', 0, '1409028511320-337cd72f-1c7b-4c84-884b-82a4a3c95c55.jpg', 2),
(26, 'dsg', '26', 3, '26', 0, '1409028524396-b5e9da0b-82f6-4bd9-a9f7-eb51ceba06d3.jpg', 0),
(27, 'adasd', 'adasd', 3, '27', 0, '1409028544100-a466809e-803c-4a01-be9d-7e930470afd7.jpg', 2),
(28, 'dgsg', 'dsgsd', 1, '28', 0, '1409028574569-f2a9318d-f845-449a-be46-f6e895d9a893.jpg', 1),
(29, 'qweqwe', 'qewqwe', 1, '29', 0, '1409028722025-7d932ec9-18c4-4d17-a61d-557aa8de7970.jpg', 0),
(30, 'adaaaaaaaaaaaaaa', 'asdas', 1, '30', 0, '1409740388468-ccad520c-f104-42ab-acaf-999ed88a67d5.jpg', 2);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_users`
--

CREATE TABLE IF NOT EXISTS `tbl_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `tbl_users`
--

INSERT INTO `tbl_users` (`id`, `username`, `password`, `enabled`) VALUES
(1, 'user', '123', 1),
(2, 'dba', '123', 1),
(3, 'admin', '123', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user_role`
--

CREATE TABLE IF NOT EXISTS `tbl_user_role` (
  `userid` int(11) NOT NULL,
  `rolename` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_user_role`
--

INSERT INTO `tbl_user_role` (`userid`, `rolename`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_DBA'),
(3, 'ROLE_ADMIN');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK_PRODUCTS_CATEGORY` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  ADD CONSTRAINT `FK_PRODUCTS_USER` FOREIGN KEY (`owner`) REFERENCES `tbl_users` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
