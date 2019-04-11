-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 20, 2018 at 08:54 AM
-- Server version: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `daydayrun`
--

-- --------------------------------------------------------

--
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
CREATE TABLE IF NOT EXISTS `score` (
  `name` varchar(45) NOT NULL,
  `score` int(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `score`
--

INSERT INTO `score` (`name`, `score`) VALUES
('null', 0),
('1', 1),
('qwe', 10),
('null', 0),
('null', 0),
('null', 0),
('12343', 11),
('123', 600),
('123', 300),
('123', 400),
('123', 1500),
('123', 1400),
('123', 600),
('123', 1300),
('123', 400),
('123', 1200),
('123', 200),
('null', 0),
('null', 0),
('null', 0),
('null', 0),
('null', 0),
('null', 0),
('null', 0),
('null', 0),
('null', 0),
('null', 0),
('null', 0),
('sujiapei', 4300),
('null', 0),
('null', 0),
('null', 0),
('null', 0),
('null', 0),
('sujiapei', 300),
('1234', 1600),
('sujiapei', 300),
('null', 600),
('null', 2600),
('null', 700),
('null', 1400),
('null', 1500),
('null', 2200),
('null', 1400),
('null', 1500),
('null', 1100),
('null', 1400),
('null', 300),
('null', 2400),
('null', 2400),
('null', 1500),
('null', 1900),
('null', 3900),
('null', 2700),
('null', 2300),
('null', 2300),
('null', 400),
('null', 1100),
('null', 700),
('null', 2900),
('null', 3300),
('null', 800),
('null', 2900),
('null', 2700),
('null', 2000),
('null', 1200),
('null', 1400),
('null', 3000),
('null', 2500),
('sujiapei', 3800);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `Score` int(20) DEFAULT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`iduser`, `name`, `password`, `Score`) VALUES
(1, '123', '123', NULL),
(2, '1234', '1234', NULL),
(3, '1234', '1234', NULL),
(4, 'sujiapei', '1234', NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
