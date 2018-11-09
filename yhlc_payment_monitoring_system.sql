-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 09, 2018 at 12:00 PM
-- Server version: 10.1.24-MariaDB
-- PHP Version: 7.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `yhlc_payment_monitoring_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `colortheme`
--

CREATE TABLE `colortheme` (
  `themeID` int(11) NOT NULL,
  `themeName` varchar(50) NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `generalpayments`
--

CREATE TABLE `generalpayments` (
  `paymentID` int(11) NOT NULL,
  `paymentName` varchar(30) NOT NULL,
  `receiptType` varchar(50) NOT NULL,
  `paymentAmount` double NOT NULL,
  `paymentFor` varchar(30) NOT NULL,
  `addDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `active` tinyint(1) NOT NULL,
  `userID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `generalpayments`
--

INSERT INTO `generalpayments` (`paymentID`, `paymentName`, `receiptType`, `paymentAmount`, `paymentFor`, `addDate`, `active`, `userID`) VALUES
(173802273, 'Tuition fee', 'Official Receipt', 10000, 'Sr. K', '2018-10-13 12:28:23', 1, 14314334),
(217529789, 'Ancilliary fee', 'Official Receipt', 3500, 'G-I', '2018-10-13 12:26:40', 1, 14314334),
(248745584, 'Entrance fee', 'Official Receipt', 800, 'G-II', '2018-10-13 12:25:18', 1, 14314334),
(293036950, 'Ancilliary fee', 'Official Receipt', 3500, 'N', '2018-10-13 12:26:40', 1, 14314334),
(417479380, 'Miscellaneous fee', 'Official Receipt', 1000, 'G-III', '2018-10-13 12:26:04', 1, 14314334),
(499389596, 'Miscellaneous fee', 'Official Receipt', 1000, 'G-V', '2018-10-13 12:26:06', 1, 14314334),
(507612942, 'Miscellaneous fee', 'Official Receipt', 1000, 'Sr. K', '2018-10-13 12:26:04', 1, 14314334),
(557164371, 'Tuition fee', 'Official Receipt', 13500, 'G-I', '2018-10-13 12:29:10', 1, 14314334),
(558933587, 'Miscellaneous fee', 'Official Receipt', 1000, 'Jr. K', '2018-10-13 12:26:05', 1, 14314334),
(651936113, 'Entrance fee', 'Official Receipt', 800, 'Sr. K', '2018-10-13 12:25:18', 1, 14314334),
(671911098, 'Ancilliary fee', 'Official Receipt', 3500, 'G-III', '2018-10-13 12:26:39', 1, 14314334),
(684352782, 'Ancilliary fee', 'Official Receipt', 3500, 'G-II', '2018-10-13 12:26:40', 1, 14314334),
(775872169, 'Tuition fee', 'Official Receipt', 13500, 'G-II', '2018-10-13 12:29:10', 1, 14314334),
(797491047, 'Miscellaneous fee', 'Official Receipt', 1000, 'G-II', '2018-10-13 12:26:05', 1, 14314334),
(810084092, 'Miscellaneous fee', 'Official Receipt', 1000, 'G-I', '2018-10-13 12:26:05', 1, 14314334),
(831722578, 'Miscellaneous fee', 'Official Receipt', 1000, 'N', '2018-10-13 12:26:04', 1, 14314334),
(846027234, 'Tuition fee', 'Official Receipt', 10000, 'Jr. K', '2018-10-13 12:30:24', 1, 14314334),
(887571652, 'Ancilliary fee', 'Official Receipt', 3500, 'G-IV', '2018-10-13 12:26:42', 1, 14314334),
(1218477373, 'Entrance fee', 'Official Receipt', 800, 'G-I', '2018-10-13 12:25:18', 1, 14314334),
(1222255126, 'Entrance fee', 'Official Receipt', 800, 'G-IV', '2018-10-13 12:25:19', 1, 14314334),
(1245588408, 'Miscellaneous fee', 'Official Receipt', 1000, 'G-IV', '2018-10-13 12:26:06', 1, 14314334),
(1322251753, 'Entrance fee', 'Official Receipt', 800, 'N', '2018-10-13 12:25:18', 1, 14314334),
(1421656130, 'Tuition fee', 'Official Receipt', 13500, 'G-V', '2018-10-13 12:29:11', 1, 14314334),
(1462875823, 'Ancilliary fee', 'Official Receipt', 3500, 'Jr. K', '2018-10-13 12:26:41', 1, 14314334),
(1506139388, 'Tuition fee', 'Official Receipt', 13500, 'G-IV', '2018-10-13 12:29:12', 1, 14314334),
(1518619933, 'Tuition fee', 'Official Receipt', 11000, 'N', '2018-10-13 12:27:19', 1, 14314334),
(1524628654, 'Entrance fee', 'Official Receipt', 800, 'Jr. K', '2018-10-13 12:25:19', 1, 14314334),
(1535193156, 'Tuition fee', 'Official Receipt', 13500, 'G-VI', '2018-10-13 12:29:12', 1, 14314334),
(1632985117, 'Ancilliary fee', 'Official Receipt', 3500, 'G-V', '2018-10-13 12:26:41', 1, 14314334),
(1769323003, 'Tuition fee', 'Official Receipt', 13500, 'G-III', '2018-10-13 12:29:09', 1, 14314334),
(1817030951, 'Ancilliary fee', 'Official Receipt', 3500, 'Sr. K', '2018-10-13 12:26:39', 1, 14314334),
(1925834003, 'Entrance fee', 'Official Receipt', 800, 'G-III', '2018-10-13 12:25:18', 1, 14314334),
(1989404595, 'Entrance fee', 'Official Receipt', 800, 'G-VI', '2018-10-13 12:25:19', 1, 14314334),
(2003310784, 'Entrance fee', 'Official Receipt', 800, 'G-V', '2018-10-13 12:25:19', 1, 14314334),
(2062442584, 'Ancilliary fee', 'Official Receipt', 3500, 'G-VI', '2018-10-13 12:26:42', 1, 14314334),
(2096311810, 'Miscellaneous fee', 'Official Receipt', 1000, 'G-VI', '2018-10-13 12:26:06', 1, 14314334);

-- --------------------------------------------------------

--
-- Table structure for table `guardian`
--

CREATE TABLE `guardian` (
  `guardianID` int(11) NOT NULL,
  `addedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userID` int(11) NOT NULL,
  `studentID` int(11) NOT NULL,
  `fullname` varchar(30) NOT NULL,
  `relationship` varchar(50) NOT NULL,
  `contactNumber` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `levels`
--

CREATE TABLE `levels` (
  `levelID` int(11) NOT NULL,
  `levelName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `levels`
--

INSERT INTO `levels` (`levelID`, `levelName`) VALUES
(73985822, 'Sr. K'),
(262898285, 'G-III'),
(396235040, 'N'),
(683710802, 'G-I'),
(1521469791, 'G-II'),
(1631500726, 'Jr. K'),
(1873340129, 'G-V'),
(1962372081, 'G-IV'),
(2101642524, 'G-VI');

-- --------------------------------------------------------

--
-- Table structure for table `schooltransaction`
--

CREATE TABLE `schooltransaction` (
  `transID` int(11) NOT NULL,
  `voucherNumber` varchar(20) NOT NULL,
  `transDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `transFor` varchar(200) NOT NULL,
  `transType` varchar(20) NOT NULL,
  `amount` double NOT NULL,
  `userID` int(11) NOT NULL,
  `remarks` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `schoolyear`
--

CREATE TABLE `schoolyear` (
  `schoolYearID` int(11) NOT NULL,
  `schoolYearName` varchar(50) NOT NULL,
  `dateCreated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userID` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `schoolyear`
--

INSERT INTO `schoolyear` (`schoolYearID`, `schoolYearName`, `dateCreated`, `userID`, `active`) VALUES
(755576781, '2018-2019', '2018-10-13 12:32:20', 30568668, 1);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `studentID` int(11) NOT NULL,
  `schoolID` varchar(20) NOT NULL,
  `userID` int(11) NOT NULL,
  `addedDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fullname` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `contactNumber` varchar(50) NOT NULL,
  `level` varchar(30) NOT NULL,
  `image` longblob,
  `form138` tinyint(1) NOT NULL,
  `birthcertificate` tinyint(1) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `graduated` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `studenttransaction`
--

CREATE TABLE `studenttransaction` (
  `transID` int(11) NOT NULL,
  `transDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `officialReceipt` varchar(20) NOT NULL,
  `paymentID` int(11) NOT NULL,
  `amount` double NOT NULL,
  `schoolYear` varchar(20) NOT NULL,
  `studentID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `remarks` varchar(200) NOT NULL,
  `remaining_balance` double NOT NULL,
  `reported` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userID` int(11) NOT NULL,
  `addedDate` varchar(50) NOT NULL,
  `type` varchar(15) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `contactNumber` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `addedDate`, `type`, `fullname`, `contactNumber`, `email`, `username`, `password`, `active`) VALUES
(30568668, '2018-24-13 12:24:11', 'Cashier', 'Eunar B. Dayangco', '09333611841', 'ebdayangco@gmail.com', 'ebdayangco', '123456', 1),
(14314334, '04/10/2018', 'Manager', 'Loralie Cabrera', 'No Contact Number', 'llcabrera@gmail.com', 'llcabrera', 'lora111', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `colortheme`
--
ALTER TABLE `colortheme`
  ADD PRIMARY KEY (`themeID`);

--
-- Indexes for table `generalpayments`
--
ALTER TABLE `generalpayments`
  ADD PRIMARY KEY (`paymentID`);

--
-- Indexes for table `guardian`
--
ALTER TABLE `guardian`
  ADD PRIMARY KEY (`guardianID`);

--
-- Indexes for table `levels`
--
ALTER TABLE `levels`
  ADD PRIMARY KEY (`levelID`);

--
-- Indexes for table `schooltransaction`
--
ALTER TABLE `schooltransaction`
  ADD PRIMARY KEY (`transID`);

--
-- Indexes for table `schoolyear`
--
ALTER TABLE `schoolyear`
  ADD PRIMARY KEY (`schoolYearID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`studentID`,`schoolID`);

--
-- Indexes for table `studenttransaction`
--
ALTER TABLE `studenttransaction`
  ADD PRIMARY KEY (`transID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`,`userID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
